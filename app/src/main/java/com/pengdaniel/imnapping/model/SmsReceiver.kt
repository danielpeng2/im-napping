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

        val sharedPrefManager: SharedPrefManager?
                = if (context != null) SharedPrefManager(context, SharedPrefType.MESSAGES) else null

        if (intent?.action?.equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION) == true) {

            // Get array of SmsMessage
            val msgs = Telephony.Sms.Intents.getMessagesFromIntent(intent)
            // Get message
            val smsMessage = msgs[0]
            val incomingNum = smsMessage.displayOriginatingAddress
            Log.i(TAG, "Message received: " + smsMessage?.messageBody + " from " + smsMessage.displayOriginatingAddress)

            val message: String = sharedPrefManager?.getMessage(incomingNum)?: DEFAULT_SMS_MESSAGE
            sendSMS(incomingNum, message)
        }
    }

    private fun sendSMS(phoneNumber: String, message: String) {
        val smsManager = SmsManager.getDefault()
        smsManager.sendTextMessage(phoneNumber, null, message, null, null)
    }

    companion object {
        private val TAG = "SMS_RECEIVER"

        private const val DEFAULT_SMS_MESSAGE = "I'm napping right now"
    }
}