package com.afrakhteh.ticku.view.fragments.category

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.afrakhteh.ticku.R
import com.afrakhteh.ticku.constants.Numerals
import com.afrakhteh.ticku.constants.Strings
import com.afrakhteh.ticku.databinding.FragmentCategoryBinding
import com.afrakhteh.ticku.di.builders.ViewModelComponentBuilder
import com.afrakhteh.ticku.model.entities.TaskEntity
import com.afrakhteh.ticku.view.customs.DeleteDialog
import com.afrakhteh.ticku.view.fragments.category.epoxy.CategoryEpoxyController
import com.afrakhteh.ticku.viewModel.CategoryViewModel
import javax.inject.Inject

class CategoryFragment : Fragment() {

    private var categoryBinding: FragmentCategoryBinding? = null

    @Inject
    lateinit var vmProvider: ViewModelProvider.Factory
    private val viewModel: CategoryViewModel by viewModels { vmProvider }

    private lateinit var controller: CategoryEpoxyController

    private var type: Int? = null

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        ViewModelComponentBuilder.getInstance().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCategoryBinding.inflate(layoutInflater, container, false)
        categoryBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        controller = CategoryEpoxyController()
        initialiseView()
        viewModel.getCategoryItem(type!!)
        viewModel.listOfData.observe(viewLifecycleOwner, ::renderList)
    }

    private fun renderList(list: List<TaskEntity>?) {
        controller.setData(list)
    }

    private fun initialiseView() {
        requireNotNull(categoryBinding).apply {
            CategoryTitleTv.text = findCategoryName().trim()
            CategoryRv.adapter = controller.adapter
            CategoryDeleteAllIv.setOnClickListener(::deleteAllTasks)
        }
    }

    private fun deleteAllTasks(view: View?) {
        DeleteDialog {
            viewModel.deleteAllCategoryList(type!!)
        }.show(activity?.supportFragmentManager!!, "delete")
    }

    private fun findCategoryName(): String {
        return when (requireNotNull(type)) {
            Numerals.SCHOOL_TYPE -> Strings.SCHOOL_TYPE
            Numerals.HOLIDAY_TYPE -> Strings.HOLIDAY_TYPE
            Numerals.BUSINESS_TYPE -> Strings.BUSINESS_TYPE
            Numerals.SHOPPING_TYPE -> Strings.SHOPPING_TYPE
            else -> ""
        }
    }

    override fun onDestroy() {
        categoryBinding = null
        super.onDestroy()
    }
}