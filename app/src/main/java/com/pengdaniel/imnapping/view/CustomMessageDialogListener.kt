package com.pengdaniel.imnapping.view

interface CustomMessageDialogListener {

    fun onDialogPositiveClick(address: String, name: String = "", message: String)

    fun onDialogNegativeClick()

}