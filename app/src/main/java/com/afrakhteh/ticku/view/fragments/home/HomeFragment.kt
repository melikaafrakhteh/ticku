package com.afrakhteh.ticku.view.fragments.home

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.afrakhteh.ticku.R
import com.afrakhteh.ticku.constants.Numerals
import com.afrakhteh.ticku.constants.Strings
import com.afrakhteh.ticku.databinding.FragmentHomeBinding
import com.afrakhteh.ticku.di.builders.ViewModelComponentBuilder
import com.afrakhteh.ticku.model.entities.TaskEntity
import com.afrakhteh.ticku.view.fragments.addEdit.AddFragment
import com.afrakhteh.ticku.view.fragments.home.epoxy.TaskHomeEpoxyController
import com.afrakhteh.ticku.viewModel.HomeViewModel
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class HomeFragment : Fragment() {

    private var homeBinding: FragmentHomeBinding? = null

    @Inject
    lateinit var vmProvider: ViewModelProvider.Factory
    private val viewModel: HomeViewModel by viewModels { vmProvider }

    private lateinit var rvController: TaskHomeEpoxyController

    private var task: String? = null
    private var taskType: Int? = null

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        ViewModelComponentBuilder.getInstance().inject(this)
    }

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
        // viewModel.getAllTask(findDate().trim())
        rvController = TaskHomeEpoxyController(::checkDoneHomeTask, ::removeTaskFromList)
        requireNotNull(homeBinding).homeRv.setController(rvController)
        viewModel.listOfTasks.observe(viewLifecycleOwner, ::renderTaskList)
        itemClicks()
    }

    override fun onResume() {
        super.onResume()
        //viewModel.getAllTask(findDate().trim())
    }

    private fun removeTaskFromList(position: Int) {

    }

    private fun checkDoneHomeTask(position: Int) {

    }

    private fun renderTaskList(list: List<TaskEntity>?) {
        rvController.setData(list)
        Log.d("renderlist", "$list")
    }

    @SuppressLint("SimpleDateFormat")
    private fun findDate(): String {
        val yourMilliSeconds = System.currentTimeMillis()
        val sdf = SimpleDateFormat("MMM dd,yyyy")
        val resultDate = Date(yourMilliSeconds)
        return sdf.format(resultDate)
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
        AddFragment { type, taskTitle ->
            task = taskTitle
            taskType = type
            viewModel.addNewTask(
                TaskEntity(
                    task = task,
                    taskType = requireNotNull(taskType),
                    date = findDate(),
                    isDone = false
                )
            )
            Toast.makeText(requireContext(), getString(R.string.add_toast), Toast.LENGTH_LONG)
                .show()
        }.show(requireActivity().supportFragmentManager, "tag")
    }

    private fun goToShoppingCategoryPage(view: View?) {
        goToCategories(Numerals.SHOPPING_TYPE, view)
    }

    private fun goToBusinessCategoryPage(view: View?) {
        goToCategories(Numerals.BUSINESS_TYPE, view)
    }

    private fun goToHolidayCategoryPage(view: View?) {
        goToCategories(Numerals.HOLIDAY_TYPE, view)
    }

    private fun goToSchoolCategoryPage(view: View?) {
        goToCategories(Numerals.SCHOOL_TYPE, view)
    }

    private fun goToCategories(type: Int, view: View?) {
        val action = R.id.action_homeFragment_to_categoryFragment
        val bundle = bundleOf(Strings.TYPE_KEY to type)
        view?.findNavController()?.navigate(action, bundle)
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