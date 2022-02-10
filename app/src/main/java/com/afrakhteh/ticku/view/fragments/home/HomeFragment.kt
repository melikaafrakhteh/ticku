package com.afrakhteh.ticku.view.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.afrakhteh.ticku.R
import com.afrakhteh.ticku.constants.Strings
import com.afrakhteh.ticku.databinding.FragmentHomeBinding
import com.afrakhteh.ticku.view.fragments.addEdit.AddFragment

class HomeFragment : Fragment() {

    private var homeBinding: FragmentHomeBinding? = null

    private var task: String? = null
    private var taskType: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        homeBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemClicks()
    }


    private fun itemClicks() {
        with(requireNotNull(homeBinding)) {
            homeSearchEditText.setOnClickListener(::goToSearchPage)
            homeSchoolLinear.setOnClickListener(::goToSchoolCategoryPage)
            homeHolidayLinear.setOnClickListener(::goToHolidayCategoryPage)
            homeBusinessLinear.setOnClickListener(::goToBusinessCategoryPage)
            homeShoppingLinear.setOnClickListener(::goToShoppingCategoryPage)
            homeFab.setOnClickListener(::addNewTask)
        }
    }

    private fun addNewTask(view: View?) {
        AddFragment{ type, taskTitle ->
            task = taskTitle
            taskType = type

        }.show(requireActivity().supportFragmentManager, "tag")

    }

    private fun goToShoppingCategoryPage(view: View?) {

    }

    private fun goToBusinessCategoryPage(view: View?) {

    }

    private fun goToHolidayCategoryPage(view: View?) {

    }

    private fun goToSchoolCategoryPage(view: View?) {

    }

    private fun goToSearchPage(view: View?) {
        val action = R.id.action_homeFragment_to_searchFragment
       Navigation.findNavController(requireNotNull(view)).navigate(action)
    }

    override fun onDestroy() {
        homeBinding = null
        super.onDestroy()
    }
}