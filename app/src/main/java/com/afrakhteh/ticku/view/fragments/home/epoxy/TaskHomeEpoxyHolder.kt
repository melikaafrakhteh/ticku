package com.afrakhteh.ticku.view.fragments.home.epoxy

import android.widget.CheckBox
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.afrakhteh.ticku.R
import com.afrakhteh.ticku.util.EpoxyKotlinHolder

class TaskHomeEpoxyHolder: EpoxyKotlinHolder() {
    val taskCheckbox by bind <CheckBox> (R.id.homeTaskCheckBox)
    val taskTitle by bind <TextView> (R.id.homeTaskTaskTv)
    val taskHome by  bind <ConstraintLayout> (R.id.homeTaskConstraint)
}
