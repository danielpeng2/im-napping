package com.pengdaniel.imnapping.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.TextView
import com.pengdaniel.imnapping.R
import kotlinx.android.synthetic.main.item_custom_message.view.*

class CustomMessageViewHolder(val view: View, private val context: Context): RecyclerView.ViewHolder(view), CustomMessageRowView {

    private var nameView: TextView = view.name_text
    private var messageView: TextView = view.message_text
    private var overflowButton: ImageButton = view.overflow_button

    override fun setName(name: String) {
        nameView.text = name
    }

    override fun setMessage(message: String) {
        messageView.text = message
    }

    override fun setOverflowOnClick() {
        overflowButton.setOnClickListener {
            val popup = PopupMenu(context, overflowButton)
            popup.menuInflater.inflate(R.menu.custom_message_item, popup.menu)
            popup.setOnMenuItemClickListener {menuItem ->
                when (menuItem.itemId) {
                    R.id.menu_edit -> {
                        true
                    }
                    R.id.menu_delete -> {
                        true
                    }
                    else -> false
                }
            }
            popup.show()
        }
    }

}