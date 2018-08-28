package com.pengdaniel.imnapping.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pengdaniel.imnapping.R
import com.pengdaniel.imnapping.presenter.CustomMessagesPresenter

class CustomMessagesActivity : AppCompatActivity(), CustomMessagesView {

    private lateinit var presenter: CustomMessagesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_messages)

        presenter = CustomMessagesPresenter()
    }
}