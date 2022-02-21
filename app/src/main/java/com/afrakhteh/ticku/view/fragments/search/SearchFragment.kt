package com.afrakhteh.ticku.view.fragments.search

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.afrakhteh.ticku.R
import com.afrakhteh.ticku.databinding.FragmentSearchBinding
import com.afrakhteh.ticku.di.builders.ViewModelComponentBuilder
import com.afrakhteh.ticku.model.entities.TaskEntity
import com.afrakhteh.ticku.viewModel.SearchViewModel
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@ObsoleteCoroutinesApi
class SearchFragment : Fragment() {

    private var searchBinding: FragmentSearchBinding? = null

    @Inject
    lateinit var vmProvider: ViewModelProvider.Factory
    private val viewModel: SearchViewModel by viewModels { vmProvider }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        ViewModelComponentBuilder.getInstance().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSearchBinding.inflate(inflater, container, false)
        searchBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialiseView()
        viewModel.searchTaskLiveData.observe(viewLifecycleOwner, ::renderSearch)
    }

    private fun renderSearch(list: List<TaskEntity>?) {

    }

    private fun initialiseView() {
        requireNotNull(searchBinding).searchSV.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener,
                androidx.appcompat.widget.SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    newText?.let {
                        viewModel.setSearchQuery(it)
                    }
                    return true
                }
            }
        )

    }


    override fun onDestroy() {
        searchBinding = null
        super.onDestroy()
    }
}