package com.pengdaniel.imnapping.presenter

import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.pengdaniel.imnapping.model.SharedPrefManager
import com.pengdaniel.imnapping.view.MainView


// TODO: remove dependency on context
class MainPresenter(val view: MainView, context: Context): Presenter {

    private val sharedPrefManager = SharedPrefManager(context)

    init {
        sharedPrefManager.setCustomMessage("+16135581398", "Hi icon south")
        sharedPrefManager.setCustomMessage("+17788331438", "Mrawh!")
        if (!view.checkSmsPermissionGranted()) {
            view.requestSmsPermission()
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