package com.pengdaniel.imnapping.view

import android.support.annotation.StringRes

interface MainView {

    fun checkSmsPermissions()

    fun updateStatusButtonText(@StringRes buttonText: Int)
}