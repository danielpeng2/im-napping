package com.pengdaniel.imnapping.model

import android.text.TextUtils
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CustomMessage(val address: String, val name: String = "" , val message: String) {

    fun getDisplayName() = if (TextUtils.isEmpty(name)) address else name
}