package com.afrakhteh.ticku.view.fragments.addEdit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.afrakhteh.ticku.R
import com.afrakhteh.ticku.constants.Numerals
import com.afrakhteh.ticku.constants.Strings
import com.afrakhteh.ticku.databinding.FragmentAddBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AddFragment(
    private val onAddButtonClick: (Int, String) -> Unit
) : BottomSheetDialogFragment() {

    private var addBinding: FragmentAddBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.AppBottomSheetDialogTheme)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAddBinding.inflate(inflater, container, false)
        addBinding = binding
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireNotNull(addBinding).addAddOrEditIv.setOnClickListener(::addANewTask)
    }

    private fun addANewTask(view: View?) {
        with(requireNotNull(addBinding)) {
            if (addEditEt.text.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.empty_add_msg),
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val task = addEditEt.text.toString().trim()
                val taskType = findSelectedRadioType()
                onAddButtonClick.invoke(taskType, task)
                dismiss()
            }
        }
    }

    private fun findSelectedRadioType(): Int {
        return when (requireNotNull(addBinding).addRadioGp.checkedRadioButtonId) {
            R.id.addSchoolRadio -> Numerals.SCHOOL_TYPE
            R.id.addHolidayRadio -> Numerals.HOLIDAY_TYPE
            R.id.addBusinessRadio -> Numerals.BUSINESS_TYPE
            R.id.addShoppingRadio -> Numerals.SHOPPING_TYPE
            else -> { -1 }
        }
    }

    override fun onDestroy() {
        addBinding = null
        super.onDestroy()
    }
}