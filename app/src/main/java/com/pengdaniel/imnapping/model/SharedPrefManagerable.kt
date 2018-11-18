package com.pengdaniel.imnapping.model

interface SharedPrefManagerable {

    fun getMessage(incomingAddress: String): String

    fun getAllMessages(): ArrayList<CustomMessage>

    fun deleteMessage(address: String)

    fun getReceiverStatus(): Boolean

    fun setDefaultMessage(newMessage: String)

    fun setCustomMessage(address: String, name: String = "", newMessage: String)

    fun setReceiverStatus(newStatus: Boolean)
}