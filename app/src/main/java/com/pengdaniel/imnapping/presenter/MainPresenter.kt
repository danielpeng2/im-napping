package com.pengdaniel.imnapping.presenter

import android.content.Context
import com.pengdaniel.imnapping.R
import com.pengdaniel.imnapping.model.SharedPrefManager
import com.pengdaniel.imnapping.model.SharedPrefType
import com.pengdaniel.imnapping.view.MainView


// TODO: remove dependency on context
class MainPresenter(val view: MainView, context: Context): Presenter {

    private var receiverStatus: Boolean
    private val sharedPrefManager = SharedPrefManager(context)
    // TODO: remove temporary pref manager
    private val messagesPrefManager = SharedPrefManager(context, SharedPrefType.MESSAGES)

    init {
        // TODO: remove temp custom messages
        messagesPrefManager.setCustomMessage(address = "6505551212", newMessage = "sdfsdfsdfs")
        messagesPrefManager.setCustomMessage(address = "+16135581398", newMessage = "Hi icon south")
        messagesPrefManager.setCustomMessage(address = "+17788331438", newMessage = "Mrawh!")
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