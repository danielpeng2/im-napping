package com.pengdaniel.imnapping.view

import com.pengdaniel.imnapping.model.CustomMessage

interface CustomMessagesView {

    fun initializeMessageList(customMessages: ArrayList<CustomMessage>)
}