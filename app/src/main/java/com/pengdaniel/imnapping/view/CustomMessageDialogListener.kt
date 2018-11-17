package com.pengdaniel.imnapping.view

interface CustomMessageDialogListener {

    fun onAddDialogPositiveClick(address: String, name: String = "", message: String)

    fun onEditDialogPositiveClick(address: String, name: String = "", message: String, delete: String)
}