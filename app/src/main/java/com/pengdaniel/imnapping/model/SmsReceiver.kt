package com.pengdaniel.imnapping.model

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.telephony.SmsManager
import android.widget.Toast
import android.util.Log


class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        if (intent?.action?.equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION) == true) {

            Toast.makeText(context, "Message received", Toast.LENGTH_LONG).show()

            // Get array of SmsMessage
            val msgs = Telephony.Sms.Intents.getMessagesFromIntent(intent)
            // Get message
            val smsMessage = msgs[0]
            Log.i(TAG, "Message received: " + smsMessage?.messageBody + " from " + smsMessage.displayOriginatingAddress)

            sendSMS(smsMessage.displayOriginatingAddress)
        }
    }

    private fun sendSMS(phoneNumber: String) {
        val text = "Testing!"

        val smsManager = SmsManager.getDefault()
        smsManager.sendTextMessage(phoneNumber, null, text, null, null)
    }

    companion object {
        private const val PDUS = "pdus"
        private val TAG = SmsReceiver::class.java.name
    }
}