package com.pengdaniel.imnapping.presenter

import com.pengdaniel.imnapping.model.CustomMessage
import com.pengdaniel.imnapping.model.SharedPrefManager
import com.pengdaniel.imnapping.view.CustomMessagesView

// TODO: make messagesPrefManager interface
class CustomMessagesPresenter(val view: CustomMessagesView, private val messagesPrefManager: SharedPrefManager):
        Presenter, PopupMenuListener {

    private var customMessages: ArrayList<CustomMessage> = messagesPrefManager.getAllMessages()

    fun onFloatingActionButtonClick() {
        view.openCustomMessagesDialog()
    }

    fun onAddDialogPositiveClick(address: String, name: String, message: String) {
        messagesPrefManager.setCustomMessage(address, name, message)
        val newCustomMessage = CustomMessage(address, name, message)
        val size = customMessages.size
        var added = 0
        // Add the custom message in alphabetical order into arraylist
        for (i in 1 until size) {
            if (newCustomMessage.getDisplayName() < customMessages[i].getDisplayName()) {
                customMessages.add(i, newCustomMessage)
                added = i
                break
            }
            if (i == size - 1) {
                customMessages.add(size, newCustomMessage)
                added = size
            }
        }
        view.addMessageListItem(added)
    }

    fun onEditDialogPositiveClick(address: String, name: String, message: String, delete: String) {
        val position = customMessages.indexOfFirst { it -> it.address == delete }
        if (address == delete) {
            if (address == "Default Message") {
                messagesPrefManager.setDefaultMessage(message)
            } else {
                messagesPrefManager.setCustomMessage(address, name, message)
            }
            customMessages[position] = CustomMessage(address, name, message)
            view.editMessageListItem(position)
        } else {
            onMenuDeleteClicked(position)
            onAddDialogPositiveClick(address, name, message)
        }
    }

    override fun onMenuDeleteClicked(position: Int) {
        messagesPrefManager.deleteMessage(customMessages[position].address)
        customMessages.removeAt(position)
        view.deleteMessageListItem(position)
    }

    override fun onMenuEditClicked(position: Int) {
        view.openCustomMessagesDialog(customMessages[position])
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