package com.pengdaniel.imnapping.view

import android.support.annotation.StringRes

interface MainView {

    fun requestPermissions(vararg permissions: String)

    fun updateStatusButtonText(@StringRes buttonText: Int)
}