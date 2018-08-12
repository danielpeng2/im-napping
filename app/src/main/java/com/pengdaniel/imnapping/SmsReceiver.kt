package com.pengdaniel.imnapping

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.widget.Toast

class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        if (intent?.action?.equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION) == true) {
            Toast.makeText(context, "Message received", Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        private val TAG = SmsReceiver::class.java.name
    }
}