package com.pengdaniel.imnapping.presenter

import com.pengdaniel.imnapping.model.CustomMessage
import com.pengdaniel.imnapping.model.SharedPrefManager
import com.pengdaniel.imnapping.view.CustomMessagesView

class CustomMessagesPresenter(val view: CustomMessagesView, private val messagesPrefManager: SharedPrefManager):
        Presenter, PopupMenuListener {

    private var customMessages: ArrayList<CustomMessage> = messagesPrefManager.getAllMessages()

    fun onFloatingActionButtonClick() {
        view.openCustomMessagesDialog()
    }

    override fun deleteCustomMessage(position: Int) {
        messagesPrefManager.deleteMessage(customMessages[position].address)
        customMessages.removeAt(position)
        view.deleteMessageListItem(position)
    }

    override fun editCustomMessage(position: Int) {
        // TODO: open custom message dialog
    }

    override fun onCreate() {
        view.initializeMessageList(customMessages)
    }

    override fun onPause() {
    }

    override fun onResume() {
    }

    override fun onDestroy() {
    }
}