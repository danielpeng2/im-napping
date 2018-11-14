package com.pengdaniel.imnapping.presenter

import android.content.Context
import com.pengdaniel.imnapping.model.SharedPrefManager
import com.pengdaniel.imnapping.model.SharedPrefType
import com.pengdaniel.imnapping.view.CustomMessagesView

class CustomMessagesPresenter(val view: CustomMessagesView, context: Context): Presenter {

    // TODO: inject dependency
    private val messagesPrefManager = SharedPrefManager(context, SharedPrefType.MESSAGES)

    init {

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