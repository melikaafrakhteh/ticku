package com.afrakhteh.ticku.view.fragments.category.epoxy

import android.widget.CheckBox
import android.widget.TextView
import com.afrakhteh.ticku.R
import com.afrakhteh.ticku.util.EpoxyKotlinHolder

class CategoryEpoxyHolder : EpoxyKotlinHolder() {
    val taskTitle by bind<TextView>(R.id.taskCategoryTaskTv)
    val taskDate by bind<TextView>(R.id.taskCategoryDateTv)
    val taskCheckBox by bind<CheckBox>(R.id.taskCategoryCheckBox)
}