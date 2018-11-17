package com.pengdaniel.imnapping.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.pengdaniel.imnapping.R
import com.pengdaniel.imnapping.model.CustomMessage

class CustomMessageDialogFragment: DialogFragment() {

    private lateinit var dialogListener: CustomMessageDialogListener
    private lateinit var toolbar: Toolbar

    companion object {
        private const val TAG = "CUSTOM_MESSAGE_DIALOG_FRAGMENT"

        fun newInstance(): CustomMessageDialogFragment {
            val dialogFragment = CustomMessageDialogFragment()
            return dialogFragment
        }

        fun newInstance(customMessage: CustomMessage): CustomMessageDialogFragment {
            val dialogFragment = CustomMessageDialogFragment()
            return dialogFragment
        }

        fun display(fragmentManager: FragmentManager): CustomMessageDialogFragment {
            val dialogFragment = CustomMessageDialogFragment()
            dialogFragment.show(fragmentManager, TAG)
            return dialogFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.AppTheme_FullScreenDialog)
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
            dialogListener.onDialogNegativeClick()
            dismiss()
        }
        toolbar.setTitle(R.string.title_custom_messages_dialog)
        toolbar.setTitleTextColor(ContextCompat.getColor(view.context, R.color.white))
        toolbar.inflateMenu(R.menu.custom_message_dialog)
        toolbar.setOnMenuItemClickListener {
            //dialogListener.onDialogPositiveClick()
            dismiss()
            true
        }
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
}