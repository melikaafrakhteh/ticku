package com.afrakhteh.ticku.view.customs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.afrakhteh.ticku.R
import com.afrakhteh.ticku.databinding.DialogDeleteBinding

class DeleteDialog(
    private val onDelete: () -> Unit
): DialogFragment() {
    private var deleteBinding: DialogDeleteBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dialog?.window?.setBackgroundDrawableResource(R.drawable.round_corner)
        val binding = DialogDeleteBinding.inflate(inflater, container, false)
        deleteBinding = binding
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        dialog?.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(requireNotNull(deleteBinding)) {
            deleteDialogCancelTv.setOnClickListener { dialog?.dismiss() }
            deleteDialogDeleteTv.setOnClickListener {
                onDelete.invoke()
                dialog?.dismiss()
            }
        }
    }

    override fun onDestroy() {
        deleteBinding = null
        super.onDestroy()
    }
}