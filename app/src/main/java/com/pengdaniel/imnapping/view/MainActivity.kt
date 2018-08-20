package com.pengdaniel.imnapping.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v4.app.ActivityCompat
import com.pengdaniel.imnapping.R
import com.pengdaniel.imnapping.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this, this)
        presenter.checkSmsPermissionGranted()

        status_button.setOnClickListener {
            presenter.onStatusButtonClicked()
        }
    }

    override fun requestPermissions(vararg permissions: String) {
        ActivityCompat.requestPermissions(this, permissions, REQUEST_SMS_PERMISSION)
    }

    override fun updateStatusButtonText(@StringRes buttonText: Int) {
        status_button.text = getString(buttonText)
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    companion object {
        private const val REQUEST_SMS_PERMISSION = 0
    }
}
