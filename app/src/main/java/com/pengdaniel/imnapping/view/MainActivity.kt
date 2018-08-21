package com.pengdaniel.imnapping.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.StringRes
import android.support.v4.app.ActivityCompat
import com.pengdaniel.imnapping.R
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
        PermissionUtil.checkSmsPermissionGranted(this)
    }

    override fun updateStatusButtonText(@StringRes buttonText: Int) {
        status_button.text = getString(buttonText)
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }
}
