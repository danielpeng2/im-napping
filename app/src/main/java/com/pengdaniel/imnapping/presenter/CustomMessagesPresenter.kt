package com.pengdaniel.imnapping.presenter

import com.pengdaniel.imnapping.model.CustomMessage
import com.pengdaniel.imnapping.model.SharedPrefManager
import com.pengdaniel.imnapping.view.CustomMessagesView

class CustomMessagesPresenter(val view: CustomMessagesView, messagesPrefManager: SharedPrefManager): Presenter {

    private val messagesPrefManager: SharedPrefManager = messagesPrefManager
    private var customMessages: ArrayList<CustomMessage> = messagesPrefManager.getAllMessages()

    fun onFloatingActionButtonClick() {
        // TODO: add custom message
    }

    override fun onCreate() {
    }

    override fun onPause() {
    }

    override fun onResume() {
    }

    override fun onDestroy() {
    }
}