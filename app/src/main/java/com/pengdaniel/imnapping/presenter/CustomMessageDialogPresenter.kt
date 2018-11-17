package com.pengdaniel.imnapping.presenter

import com.pengdaniel.imnapping.view.CustomMessageDialogListener
import com.pengdaniel.imnapping.view.CustomMessageDialogView

class CustomMessageDialogPresenter(val view: CustomMessageDialogView, val address: String = "",
                                   val name: String = "", val message: String = ""): Presenter {

    fun onDialogPositiveClicked(dialogListener: CustomMessageDialogListener, address: String,
                                name: String, message: String) {
        // TODO: error handling
        if (this.address == "") {
            dialogListener.onAddDialogPositiveClick(address, name, message)
        } else {
            dialogListener.onEditDialogPositiveClick(address, name, message, this.address)
        }
    }

    fun setViewFields() {
        view.setAddressField(address)
        view.setMessageField(message)
        view.setNameField(name)
        if (address == "Default Message") {
            view.disableAddressField()
            view.disableNameField()
            view.requestFocusMessageField()
        }
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