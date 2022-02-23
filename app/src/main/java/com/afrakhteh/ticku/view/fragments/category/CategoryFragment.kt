package com.afrakhteh.ticku.view.fragments.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.afrakhteh.ticku.R
import com.afrakhteh.ticku.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {

    private var categoryBinding: FragmentCategoryBinding? = null

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