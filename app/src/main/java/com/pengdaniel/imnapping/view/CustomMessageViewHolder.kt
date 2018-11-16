package com.pengdaniel.imnapping.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.android.synthetic.main.item_custom_message.view.*

class CustomMessageViewHolder(val view: View): RecyclerView.ViewHolder(view), CustomMessageRowView {

    var nameView: TextView = view.name_text
    var messageView: TextView = view.message_text
    var overflowButton: ImageButton = view.overflow_button

    override fun setName(name: String) {
        nameView.text = name
    }

    override fun setMessage(message: String) {
        messageView.text = message
    }

    override fun setOverflowOnClick() {
        overflowButton.setOnClickListener {

        }
    }

}