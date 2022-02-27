package com.afrakhteh.ticku.view.fragments.home.epoxy

import android.graphics.Paint
import android.widget.TextView
import com.afrakhteh.ticku.R
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder

@EpoxyModelClass(layout = R.layout.home_todo_row)
abstract class TaskHomeEpoxyModel : EpoxyModelWithHolder<TaskHomeEpoxyHolder>() {

    @EpoxyAttribute
    var title: String = ""

    @EpoxyAttribute
    open var isDone: Boolean = false

    @EpoxyAttribute
    lateinit var onCheckedAction: () -> Unit

    @EpoxyAttribute
    lateinit var deleteListener: () -> Unit

    override fun bind(holder: TaskHomeEpoxyHolder) {
        super.bind(holder)

        with(holder) {
            taskTitle.text = title
            taskCheckbox.apply {
                isChecked = isDone
                setOnCheckedChangeListener { _, _ -> onCheckedAction() }
            }
            drawLineOnTaskIfDone(taskTitle)
            taskHome.setOnLongClickListener{
                deleteListener()
                return@setOnLongClickListener true
            }
        }
    }

    private fun drawLineOnTaskIfDone(view: TextView) {
        if (isDone) view.paintFlags = view.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }
}

