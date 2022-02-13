package com.afrakhteh.ticku.util

import android.view.View
import com.airbnb.epoxy.EpoxyHolder
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

abstract class EpoxyKotlinHolder : EpoxyHolder() {

    private lateinit var _view: View

    override fun bindView(itemView: View) {
        _view = itemView
    }

    protected fun <V : View> bind(id: Int): ReadOnlyProperty<EpoxyKotlinHolder, V> =
        Lazy { holder: EpoxyKotlinHolder, prop ->
            holder._view.findViewById(id) as V?
                ?: throw IllegalStateException("View ID $id for '${prop.name}' not found.")
        }

    private class Lazy<V>(
        private val initializer: (EpoxyKotlinHolder, KProperty<*>) -> V
    ) : ReadOnlyProperty<EpoxyKotlinHolder, V> {

        private object EMPTY

        private var value: Any? = EMPTY

        override fun getValue(thisRef: EpoxyKotlinHolder, property: KProperty<*>): V {

            if (value == EMPTY) {
                value = initializer(thisRef, property)
            }

            @Suppress("UNCHECKED_CAST")
            return value as V
        }
    }
}