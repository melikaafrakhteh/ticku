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
import com.afrakhteh.ticku.databinding.FragmentCategoryBinding
import com.afrakhteh.ticku.di.builders.ViewModelComponentBuilder
import com.afrakhteh.ticku.viewModel.CategoryViewModel
import javax.inject.Inject

class CategoryFragment : Fragment() {

    private var categoryBinding: FragmentCategoryBinding? = null

    @Inject lateinit var vmProvider: ViewModelProvider.Factory
    private val viewModel: CategoryViewModel by viewModels {vmProvider}

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

    override fun onDestroy() {
        categoryBinding = null
        super.onDestroy()
    }
}