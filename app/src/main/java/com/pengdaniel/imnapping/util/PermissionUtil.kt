package com.pengdaniel.imnapping.util

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

object PermissionUtil {

    private const val REQUEST_SMS_PERMISSION = 0

    private fun isPermissionGranted(permission: String, context: Context) =
            ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED

    fun checkSmsPermissionGranted(activity: Activity): Boolean =
        isPermissionGranted(android.Manifest.permission.RECEIVE_SMS, activity) &&
            isPermissionGranted(android.Manifest.permission.SEND_SMS, activity) &&
            isPermissionGranted(android.Manifest.permission.READ_SMS, activity)

    fun requestSmsPermissions(activity: Activity) {
        ActivityCompat.requestPermissions(activity, arrayOf(android.Manifest.permission.RECEIVE_SMS,
                android.Manifest.permission.SEND_SMS,
                android.Manifest.permission.READ_SMS), REQUEST_SMS_PERMISSION)
    }
}