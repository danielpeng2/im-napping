package com.pengdaniel.imnapping.view

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import com.pengdaniel.imnapping.R
import com.pengdaniel.imnapping.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var mainPresenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter = MainPresenter(this)
    }

    override fun checkSmsPermissionGranted() = ContextCompat.checkSelfPermission(this,
            Manifest.permission.RECEIVE_SMS) == PackageManager.PERMISSION_GRANTED

    override fun requestSmsPermission() {
        ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.RECEIVE_SMS), REQUEST_SMS_PERMISSION)
    }

    companion object {
        private const val REQUEST_SMS_PERMISSION = 0
    }
}
