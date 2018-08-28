package com.pengdaniel.imnapping.presenter

import android.content.Context
import com.pengdaniel.imnapping.R
import com.pengdaniel.imnapping.model.SharedPrefManager
import com.pengdaniel.imnapping.view.MainView


// TODO: remove dependency on context
class MainPresenter(val view: MainView, val context: Context): Presenter {

    private var receiverStatus: Boolean
    private val sharedPrefManager = SharedPrefManager(context)

    init {
//        sharedPrefManager.setCustomMessage("+16135581398", "Hi icon south")
//        sharedPrefManager.setCustomMessage("+17788331438", "Mrawh!")
        receiverStatus = sharedPrefManager.getReceiverStatus()
        updateStatusViews()
    }

    fun onStatusButtonClicked() {
        receiverStatus = !receiverStatus
        updateStatusViews()
        if (receiverStatus) {
            view.enableBroadcastReceiver()
        } else {
            view.disableBroadcastReceiver()
        }
    }

    private fun updateStatusViews() {
        if (receiverStatus) {
            view.updateStatusButtonText(R.string.button_status_on)
            view.updateStatusImage(R.drawable.ic_kitty_asleep)
        } else {
            view.updateStatusButtonText(R.string.button_status_off)
            view.updateStatusImage(R.drawable.ic_kitty_awake)
        }
    }

    override fun onCreate() {
        view.checkSmsPermissions()
    }

    override fun onPause() {
        sharedPrefManager.setReceiverStatus(receiverStatus)
    }

    override fun onResume() {
    }

    override fun onDestroy() {
    }
}