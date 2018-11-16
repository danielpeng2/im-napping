package com.pengdaniel.imnapping.presenter

import com.pengdaniel.imnapping.model.CustomMessage
import com.pengdaniel.imnapping.view.CustomMessageRowView

class MessagesListPresenter {

    private var customMessages: ArrayList<CustomMessage>

    init {
        // TODO: remove temp messages
        customMessages = arrayListOf(CustomMessage(address = "123", name = "abc", message = "ahhhh"),
                                    CustomMessage(address = "239", message = "lskjskn"))
    }

    fun onBindCustomMessageRowViewAtPosition(pos: Int, rowView: CustomMessageRowView) {
        val customMessage = customMessages[pos]
        rowView.setName(customMessage.getDisplayName())
        rowView.setMessage(customMessage.message)
        rowView.setOverflowOnClick()
    }

    fun getCustomMessagesRowsCount() = customMessages.size
}