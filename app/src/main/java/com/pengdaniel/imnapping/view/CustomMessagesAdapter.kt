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
        return CustomMessageViewHolder(itemView, parent.context)
    }

    override fun onBindViewHolder(holder: CustomMessageViewHolder, position: Int) {
        presenter.onBindCustomMessageRowViewAtPosition(position, holder)
    }

    override fun getItemCount(): Int = presenter.getCustomMessagesRowsCount()
}