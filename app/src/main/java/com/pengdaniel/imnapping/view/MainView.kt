package com.pengdaniel.imnapping.view

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

interface MainView {

    fun checkSmsPermissions()

    fun updateStatusButtonText(@StringRes buttonText: Int)

    fun updateStatusImage(@DrawableRes image: Int)

    fun enableBroadcastReceiver()

    fun disableBroadcastReceiver()
}