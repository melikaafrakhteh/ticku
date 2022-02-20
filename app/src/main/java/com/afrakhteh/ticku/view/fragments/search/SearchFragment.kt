package com.afrakhteh.ticku.view.fragments.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.afrakhteh.ticku.R
import com.afrakhteh.ticku.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private var searchBinding: FragmentSearchBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSearchBinding.inflate(inflater, container, false)
        searchBinding = binding
        return binding.root
    }


    override fun onDestroy() {
        searchBinding = null
        super.onDestroy()
    }
}