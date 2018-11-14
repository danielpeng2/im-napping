package com.pengdaniel.imnapping.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
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

        fab.setOnClickListener {
        }

        presenter = CustomMessagesPresenter(this, this)

        // TODO: initialize in presenter
        // Temp data
        val tempData = arrayListOf(CustomMessage("123", "daniel", "xD"),
                            CustomMessage("456", "joslyn", "bun"),
                            CustomMessage("3433331334", "ahhhhhh"))

        viewManager = LinearLayoutManager(this)
        viewAdapter = CustomMessagesAdapter(tempData)
        recyclerView = custom_messages_list.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        val sharedPrefManager = SharedPrefManager(this, SharedPrefType.MESSAGES)
    }
}