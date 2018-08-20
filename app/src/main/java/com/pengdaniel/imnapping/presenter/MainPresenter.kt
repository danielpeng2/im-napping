package com.pengdaniel.imnapping.presenter

import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.content.ContextCompat
import com.pengdaniel.imnapping.R
import com.pengdaniel.imnapping.model.SharedPrefManager
import com.pengdaniel.imnapping.view.MainView


// TODO: remove dependency on context
class MainPresenter(val view: MainView, val context: Context): Presenter {

    private var receiverStatus: Boolean
    private val sharedPrefManager = SharedPrefManager(context)

    init {
        sharedPrefManager.setCustomMessage("+16135581398", "Hi icon south")
        sharedPrefManager.setCustomMessage("+17788331438", "Mrawh!")
        receiverStatus = sharedPrefManager.getReceiverStatus()
        view.updateStatusButtonText(if (receiverStatus) R.string.button_status_on
                                    else R.string.button_status_off)
    }

    private fun isPermissionGranted(permission: String) =
            ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED

    fun checkSmsPermissionGranted() {
        if (!isPermissionGranted(android.Manifest.permission.RECEIVE_SMS) ||
            !isPermissionGranted(android.Manifest.permission.SEND_SMS) ||
            !isPermissionGranted(android.Manifest.permission.READ_SMS)) {
                view.requestPermissions(android.Manifest.permission.RECEIVE_SMS,
                        android.Manifest.permission.SEND_SMS,
                        android.Manifest.permission.READ_SMS)
            }
    }

    fun onStatusButtonClicked() {
        receiverStatus = !receiverStatus
        view.updateStatusButtonText(if (receiverStatus) R.string.button_status_on
                                    else R.string.button_status_off)
    }

    override fun onCreate() {
    }

    override fun onPause() {
        sharedPrefManager.setReceiverStatus(receiverStatus)
    }

    override fun onResume() {
    }

    override fun onDestroy() {

    }
}