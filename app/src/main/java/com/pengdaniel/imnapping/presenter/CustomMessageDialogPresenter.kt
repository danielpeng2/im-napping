package com.pengdaniel.imnapping.presenter

import com.pengdaniel.imnapping.R
import com.pengdaniel.imnapping.view.CustomMessageDialogListener
import com.pengdaniel.imnapping.view.CustomMessageDialogView

class CustomMessageDialogPresenter(val view: CustomMessageDialogView, val address: String = "",
                                   val name: String = "", val message: String = ""): Presenter {

    private fun validateAddressField(address: String): Boolean {
        return when {
            address.isBlank() -> {
                view.showAddressFieldError(R.string.error_empty_phone_number)
                false
            }
            address.toIntOrNull() == null -> {
                view.showAddressFieldError(R.string.error_invalid_phone_number)
                false
            }
            else -> {
                view.showAddressFieldError(R.string.error_stop)
                true
            }
        }
    }

    private fun validateMessageField(message: String): Boolean {
        return if (message.isBlank()) {
            view.showMessageFieldError(R.string.error_empty_message)
            false
        } else {
            view.showMessageFieldError(R.string.error_stop)
            true
        }
    }

    fun onDialogPositiveClicked(dialogListener: CustomMessageDialogListener, address: String,
                                name: String, message: String) {
        // Validate correct field entries, show error if not
        if (!validateAddressField(address) || !validateMessageField(message)) return

        if (this.address.isEmpty()) {
            dialogListener.onAddDialogPositiveClick("+$address", name, message)
        } else {
            dialogListener.onEditDialogPositiveClick("+$address", name, message, this.address)
        }
        view.dismissDialog()
    }

    fun setViewFields() {
        if (address.isNotEmpty()) view.setAddressField(address.substring(1))
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