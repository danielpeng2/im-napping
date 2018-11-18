package com.pengdaniel.imnapping.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.pengdaniel.imnapping.R
import com.pengdaniel.imnapping.model.CustomMessage
import com.pengdaniel.imnapping.presenter.CustomMessageDialogPresenter
import kotlinx.android.synthetic.main.fragment_custom_message_dialog.*

class CustomMessageDialogFragment: DialogFragment(), CustomMessageDialogView {

    private lateinit var presenter: CustomMessageDialogPresenter
    private lateinit var dialogListener: CustomMessageDialogListener
    private lateinit var toolbar: Toolbar

    companion object {
        private const val TAG = "CUSTOM_MESSAGE_DIALOG_FRAGMENT"
        private const val ARG_ADDRESS = "ARG_ADDRESS"
        private const val ARG_NAME = "ARG_NAME"
        private const val ARG_MESSAGE = "ARG_MESSAGE"

        private fun newInstance(customMessage: CustomMessage): CustomMessageDialogFragment {
            val dialogFragment = CustomMessageDialogFragment()
            val bundle = Bundle()

            bundle.putString(ARG_ADDRESS, customMessage.address)
            bundle.putString(ARG_NAME, customMessage.name)
            bundle.putString(ARG_MESSAGE, customMessage.message)

            dialogFragment.arguments = bundle
            return dialogFragment
        }

        fun display(fragmentManager: FragmentManager): CustomMessageDialogFragment {
            val dialogFragment = CustomMessageDialogFragment()
            dialogFragment.show(fragmentManager, TAG)
            return dialogFragment
        }

        fun display(fragmentManager: FragmentManager, customMessage: CustomMessage):
                CustomMessageDialogFragment {
            val dialogFragment = newInstance(customMessage)
            dialogFragment.show(fragmentManager, TAG)
            return dialogFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.AppTheme_FullScreenDialog)
        val bundle = arguments
        presenter = if (bundle == null) {
            CustomMessageDialogPresenter(this)
        } else {
            val address = bundle.getString(ARG_ADDRESS, "")
            val name = bundle.getString(ARG_NAME, "")
            val message = bundle.getString(ARG_MESSAGE, "")
            CustomMessageDialogPresenter(this, address, name, message)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.fragment_custom_message_dialog, container, false)
        toolbar = view.findViewById(R.id.custom_messages_dialog_toolbar)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.setNavigationOnClickListener {
            dismiss()
        }
        toolbar.setTitle(R.string.title_custom_messages_dialog)
        toolbar.setTitleTextColor(ContextCompat.getColor(view.context, R.color.white))
        toolbar.inflateMenu(R.menu.custom_message_dialog)
        toolbar.setOnMenuItemClickListener {
            val address = text_input_phone_number.editText!!.text.toString()
            val name = text_input_nickname.editText!!.text.toString()
            val message = text_input_custom_message.editText!!.text.toString()
            presenter.onDialogPositiveClicked(dialogListener, address, name, message)
            true
        }
        presenter.setViewFields()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            dialogListener = context as CustomMessageDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException((context.toString() +
                    " must implement CustomMessageDialogListener"))
        }
    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if (dialog != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            dialog.window?.setLayout(width, height)
        }
    }

    override fun setAddressField(address: String) {
        text_input_phone_number.editText!!.setText(address)
    }

    override fun setNameField(name: String) {
        text_input_nickname.editText!!.setText(name)
    }

    override fun setMessageField(message: String) {
        text_input_custom_message.editText!!.setText(message)
    }

    override fun disableAddressField() {
        text_input_phone_number.editText!!.isEnabled = false
    }

    override fun disableNameField() {
        text_input_nickname.editText!!.isEnabled = false
    }

    override fun requestFocusMessageField() {
        text_input_custom_message.editText!!.requestFocus()
    }

    override fun showAddressFieldError(@StringRes error: Int) {
        text_input_phone_number.error = getString(error)
    }

    override fun showMessageFieldError(@StringRes error: Int) {
        text_input_custom_message.error = getString(error)
    }

    override fun dismissDialog() {
        dismiss()
    }
}