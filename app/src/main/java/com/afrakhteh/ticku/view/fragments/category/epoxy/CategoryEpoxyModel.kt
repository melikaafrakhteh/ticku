package com.afrakhteh.ticku.view.fragments.category.epoxy

import android.graphics.Paint
import android.widget.TextView
import com.afrakhteh.ticku.R
import com.afrakhteh.ticku.view.fragments.search.epoxy.SearchEpoxyHolder
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder

@EpoxyModelClass(layout = R.layout.todo_category_row)
abstract class CategoryEpoxyModel: EpoxyModelWithHolder<CategoryEpoxyHolder>() {

    @field: EpoxyAttribute
    var title: String ? = null

    @field: EpoxyAttribute
    var date: String  ? = null

    @field: EpoxyAttribute
    open var isDone: Boolean = false

    override fun bind(holder: CategoryEpoxyHolder) {
        super.bind(holder)
        with(holder) {
            taskTitle.text = title?.trim()
            taskDate.text = date?.trim()
            taskCheckBox.isChecked = isDone
            drawLineOnTaskIfDone(taskTitle)
        }
    }

    private fun drawLineOnTaskIfDone(view: TextView) {
        if (isDone) view.paintFlags = view.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }
}