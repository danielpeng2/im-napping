package com.pengdaniel.imnapping.view

import android.content.ComponentName
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.StringRes
import android.support.v4.app.ActivityCompat
import com.pengdaniel.imnapping.R
import com.pengdaniel.imnapping.model.SmsReceiver
import com.pengdaniel.imnapping.presenter.MainPresenter
import com.pengdaniel.imnapping.util.PermissionUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this, this)
        presenter.onCreate()

        status_button.setOnClickListener {
            presenter.onStatusButtonClicked()
        }
    }

    override fun checkSmsPermissions() {
        if (!PermissionUtil.checkSmsPermissionGranted(this)) {
            PermissionUtil.requestSmsPermissions(this)
        }
    }

    override fun updateStatusButtonText(@StringRes buttonText: Int) {
        status_button.text = getString(buttonText)
    }

    override fun enableBroadcastReceiver() {
        val componentName = ComponentName(this, SmsReceiver::class.java)
        this.packageManager.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP)
    }

    override fun disableBroadcastReceiver() {
        val componentName = ComponentName(this, SmsReceiver::class.java)
        this.packageManager.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP)
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }
}
