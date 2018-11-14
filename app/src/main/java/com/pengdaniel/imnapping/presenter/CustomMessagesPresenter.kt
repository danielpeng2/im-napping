package com.pengdaniel.imnapping.presenter

import android.content.Context
import com.pengdaniel.imnapping.model.CustomMessage
import com.pengdaniel.imnapping.model.SharedPrefManager
import com.pengdaniel.imnapping.model.SharedPrefType
import com.pengdaniel.imnapping.view.CustomMessagesView

class CustomMessagesPresenter(val view: CustomMessagesView, context: Context): Presenter {

    // TODO: inject dependency
    private val messagesPrefManager = SharedPrefManager(context, SharedPrefType.MESSAGES)

    init {
        // Temp data
        // TODO: should maybe refactor this to onCreate?
        val tempData = arrayListOf(CustomMessage("123", "daniel", "xD"),
                CustomMessage("456", "joslyn", "bun"),
                CustomMessage("3433331334", "ahhhhhh"))
        view.updateMessageList(tempData)
        // TODO: add getAll method in PrefManager
    }

    override fun onCreate() {
    }

    override fun onPause() {
    }

    override fun onResume() {
    }

    override fun onDestroy() {
    }
}