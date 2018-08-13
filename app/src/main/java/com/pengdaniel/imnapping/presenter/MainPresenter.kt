package com.pengdaniel.imnapping.presenter

import com.pengdaniel.imnapping.view.MainView



class MainPresenter(val view: MainView): Presenter {

    init {
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