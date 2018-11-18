package com.pengdaniel.imnapping.model

import android.text.TextUtils
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CustomMessage(val address: String, val name: String = "" , val message: String) {

    private fun getDisplayAddress() = if (address == "Default Message") address
                                        else address.substring(1)
    fun getDisplayName() = if (TextUtils.isEmpty(name)) getDisplayAddress() else name
}