package com.pengdaniel.imnapping.view

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.TextView
import com.pengdaniel.imnapping.R
import com.pengdaniel.imnapping.model.CustomMessage
import com.pengdaniel.imnapping.presenter.PopupMenuListener
import kotlinx.android.synthetic.main.item_custom_message.view.*

class CustomMessagesAdapter(private val customMessages: ArrayList<CustomMessage>,
                            private val popupMenuListener: PopupMenuListener,
                            private val context: Context):
        RecyclerView.Adapter<CustomMessagesAdapter.ViewHolder>(){

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        var nameView: TextView = view.name_text
        var messageView: TextView = view.message_text
        var overflowButton: ImageButton = view.overflow_button
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_custom_message, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameView.text = customMessages[position].getDisplayName()
        holder.messageView.text = context.getString(R.string.item_message_display,
                                                    customMessages[position].message)
        holder.overflowButton.setOnClickListener {

            val popup = PopupMenu(context, holder.overflowButton)
            popup.menuInflater.inflate(R.menu.custom_message_item, popup.menu)

            // Don't show delete for default message
            if (position == 0) {
                popup.menu.findItem(R.id.menu_delete).isVisible = false
            }

            popup.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.menu_delete -> {
                        popupMenuListener.onMenuDeleteClicked(holder.adapterPosition)
                        true
                    }
                    R.id.menu_edit -> {
                        popupMenuListener.onMenuEditClicked(holder.adapterPosition)
                        true
                    }
                    else -> false
                }
            }
            popup.show()

        }
    }

    override fun getItemCount() = customMessages.size
}