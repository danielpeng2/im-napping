package com.pengdaniel.imnapping.model

import android.content.Context
import android.content.SharedPreferences
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class SharedPrefManager(context: Context, type: SharedPrefType = SharedPrefType.DEFAULT) {

    private var sharedPreferences: SharedPreferences
    private val moshi: Moshi
    private val jsonAdapter: JsonAdapter<CustomMessage>

    init {
        sharedPreferences = when (type) {
            SharedPrefType.MESSAGES -> {
                context.getSharedPreferences(MESSAGES_PREF_KEY, Context.MODE_PRIVATE)
            } else -> {
                context.getSharedPreferences(DEFAULT_PREF_KEY, Context.MODE_PRIVATE)
            }
        }
        moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        jsonAdapter = moshi.adapter(CustomMessage::class.java)
    }

    inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = this.edit()
        operation(editor)
        editor.apply()
    }

    fun getDefaultMessage(): String {
        val json = sharedPreferences.getString(DEFAULT_MSG_KEY, null)
        return if (json == null) DEFAULT_SMS_MESSAGE else jsonAdapter.fromJson(json)!!.message
    }

    fun getMessage(incomingAddress: String): String {
        val json = sharedPreferences.getString(incomingAddress, null)
        return if (json == null) getDefaultMessage() else jsonAdapter.fromJson(json)!!.message
    }

    fun getReceiverStatus() = sharedPreferences.getBoolean(RECEIVER_STATUS_KEY, false)

    fun setDefaultMessage(newMessage: String) {
        val customMessage = CustomMessage(address = DEFAULT_MSG_KEY, message = newMessage)
        sharedPreferences.edit { it.putString(DEFAULT_MSG_KEY, jsonAdapter.toJson(customMessage)) }
    }

    fun setCustomMessage(address: String, name: String = "", newMessage: String) {
        val customMessage = CustomMessage(address, name, newMessage)
        sharedPreferences.edit { it.putString(address, jsonAdapter.toJson(customMessage)) }
    }

    fun setReceiverStatus(newStatus: Boolean) {
        sharedPreferences.edit { it.putBoolean(RECEIVER_STATUS_KEY, newStatus) }
    }

    companion object {
        private const val DEFAULT_SMS_MESSAGE = "I'm napping right now"

        private const val DEFAULT_PREF_KEY = "com.pengdaniel.imnapping.DEFAULT_PREF_KEY"
        private const val MESSAGES_PREF_KEY = "com.pengdaniel.imnapping.MESSAGES_PREF_KEY"

        private const val DEFAULT_MSG_KEY = "DEFAULT_MSG_KEY"
        private const val RECEIVER_STATUS_KEY = "RECEIVER_STATUS_KEY"
    }
}