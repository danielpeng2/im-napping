package com.pengdaniel.imnapping.util

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat

object PermissionUtil {

    private const val REQUEST_SMS_PERMISSION = 0

    fun checkSmsPermissionGranted(activity: Activity) {
        if (!isPermissionGranted(android.Manifest.permission.RECEIVE_SMS, activity) ||
            !isPermissionGranted(android.Manifest.permission.SEND_SMS, activity) ||
            !isPermissionGranted(android.Manifest.permission.READ_SMS, activity)) {
            requestPermissions(activity, android.Manifest.permission.RECEIVE_SMS,
                                         android.Manifest.permission.SEND_SMS,
                                         android.Manifest.permission.READ_SMS)
        }
    }

    private fun isPermissionGranted(permission: String, context: Context) =
            ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED

    private fun requestPermissions(activity: Activity, vararg permissions: String) {
        ActivityCompat.requestPermissions(activity, permissions, REQUEST_SMS_PERMISSION)
    }
}