package com.pengdaniel.imnapping.model

import android.text.TextUtils
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CustomMessage(val address: String, val message: String, val name: String = "") {

    fun getDisplayName() = if (TextUtils.isEmpty(name)) address else name
}