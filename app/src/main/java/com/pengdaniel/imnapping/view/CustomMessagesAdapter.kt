package com.pengdaniel.imnapping.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.pengdaniel.imnapping.R
import com.pengdaniel.imnapping.presenter.MessagesListPresenter

class CustomMessagesAdapter(private val presenter: MessagesListPresenter):
        RecyclerView.Adapter<CustomMessageViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomMessageViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_custom_message, parent, false)
        return CustomMessageViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomMessageViewHolder, position: Int) {
        presenter.onBindCustomMessageRowViewAtPosition(position, holder)
    }

    override fun getItemCount(): Int = presenter.getCustomMessagesRowsCount()

    /*class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
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
        holder.messageView.text = customMessages[position].message
        holder.overflowButton.setOnClickListener {
            // TODO: add implementation
        }
    }

    override fun getItemCount() = customMessages.size*/
}