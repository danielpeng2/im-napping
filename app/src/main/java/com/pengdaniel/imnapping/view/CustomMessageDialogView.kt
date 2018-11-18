package com.pengdaniel.imnapping.view

import androidx.annotation.StringRes

interface CustomMessageDialogView {

    fun setAddressField(address: String)
    fun setNameField(name: String)
    fun setMessageField(message: String)
    fun disableAddressField()
    fun disableNameField()
    fun requestFocusMessageField()
    fun showAddressFieldError(@StringRes error: Int)
    fun showMessageFieldError(@StringRes error: Int)
    fun dismissDialog()
}