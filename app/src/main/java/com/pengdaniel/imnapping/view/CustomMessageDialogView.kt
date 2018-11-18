package com.pengdaniel.imnapping.view

interface CustomMessageDialogView {

    fun setAddressField(address: String)
    fun setNameField(name: String)
    fun setMessageField(message: String)
    fun disableAddressField()
    fun disableNameField()
    fun requestFocusMessageField()
    fun showAddressFieldError(error: String)
    fun showMessageFieldError(error: String)
    fun dismissDialog()
}