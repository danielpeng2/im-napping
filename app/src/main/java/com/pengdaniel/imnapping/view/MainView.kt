package com.pengdaniel.imnapping.view

import android.support.annotation.DrawableRes
import android.support.annotation.StringRes

interface MainView {

    fun checkSmsPermissions()

    fun updateStatusButtonText(@StringRes buttonText: Int)

    fun updateStatusImage(@DrawableRes image: Int)

    fun enableBroadcastReceiver()

    fun disableBroadcastReceiver()
}