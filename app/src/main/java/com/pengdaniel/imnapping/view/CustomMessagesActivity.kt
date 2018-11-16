package com.pengdaniel.imnapping.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pengdaniel.imnapping.R
import com.pengdaniel.imnapping.model.CustomMessage
import com.pengdaniel.imnapping.model.SharedPrefManager
import com.pengdaniel.imnapping.model.SharedPrefType
import com.pengdaniel.imnapping.presenter.CustomMessagesPresenter
import kotlinx.android.synthetic.main.activity_custom_messages.*

class CustomMessagesActivity : AppCompatActivity(), CustomMessagesView {

    private lateinit var presenter: CustomMessagesPresenter

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_messages)

        setSupportActionBar(custom_messages_toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = getString(R.string.title_custom_messages)

        presenter = CustomMessagesPresenter(this,
                SharedPrefManager(this, SharedPrefType.MESSAGES))

        fab.setOnClickListener {
            presenter.onFloatingActionButtonClick()
        }

        viewManager = LinearLayoutManager(this)
        recyclerView = custom_messages_list.apply {
            layoutManager = viewManager
        }

        presenter.onCreate()
    }

    override fun initializeMessageList(customMessages: ArrayList<CustomMessage>) {
        viewAdapter = CustomMessagesAdapter(customMessages, presenter, this)
        custom_messages_list.apply {
            adapter = viewAdapter
        }
    }

    override fun deleteMessageListItem(position: Int) {
        viewAdapter.notifyItemRemoved(position)
    }
}