package com.pengdaniel.imnapping.presenter

import com.pengdaniel.imnapping.R
import com.pengdaniel.imnapping.model.SharedPrefManagerable
import com.pengdaniel.imnapping.view.MainView

class MainPresenter(val view: MainView, private val sharedPrefManager: SharedPrefManagerable): Presenter {

    private var receiverStatus: Boolean

    init {
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
            view.updateStatusImage(R.drawable.ic_kitty_outline_asleep)
        } else {
            view.updateStatusButtonText(R.string.button_status_off)
            view.updateStatusImage(R.drawable.ic_kitty_outline_awake)
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