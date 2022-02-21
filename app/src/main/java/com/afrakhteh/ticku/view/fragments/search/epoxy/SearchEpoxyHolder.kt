package com.afrakhteh.ticku.view.fragments.search.epoxy

import android.widget.CheckBox
import android.widget.TextView
import com.afrakhteh.ticku.R
import com.afrakhteh.ticku.util.EpoxyKotlinHolder

class SearchEpoxyHolder: EpoxyKotlinHolder() {
    val taskTitle by bind <TextView> (R.id.taskCategoryTaskTv)
    val taskDate by bind <TextView> (R.id.taskCategoryDateTv)
    val taskCheck by bind <CheckBox> (R.id.taskCategoryCheckBox)
}