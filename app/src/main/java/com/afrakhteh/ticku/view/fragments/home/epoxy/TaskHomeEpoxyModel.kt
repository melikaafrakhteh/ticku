package com.afrakhteh.ticku.view.fragments.home.epoxy

import android.annotation.SuppressLint
import android.graphics.Paint
import android.widget.TextView
import com.afrakhteh.ticku.R
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder

@SuppressLint("NonConstantResourceId")
@EpoxyModelClass(layout = R.layout.home_todo_row)
abstract class TaskHomeEpoxyModel : EpoxyModelWithHolder<TaskHomeEpoxyHolder>() {

    @EpoxyAttribute
    var title: String = ""

    @EpoxyAttribute
    var type: Int = -1

    @EpoxyAttribute
    var isDone: Boolean = false

    @EpoxyAttribute
    lateinit var onCheckedAction: () -> Unit

    override fun bind(holder: TaskHomeEpoxyHolder) {
        super.bind(holder)

        with(holder) {
            taskTitle.text = title
            drawLineOnTaskIfDone(taskTitle)
            taskCheckbox.apply {
                isChecked = isDone
                setOnCheckedChangeListener { _, _ -> onCheckedAction() }
            }
        }
    }

    private fun drawLineOnTaskIfDone(view: TextView) {
        if (isDone) view.paintFlags = view.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }
}