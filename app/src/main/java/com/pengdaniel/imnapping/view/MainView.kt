package com.pengdaniel.imnapping.view

interface MainView {

    fun checkSmsPermissionGranted(): Boolean

    fun requestSmsPermission()
}