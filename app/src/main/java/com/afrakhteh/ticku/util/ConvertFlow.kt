package com.afrakhteh.ticku.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.toList

suspend fun <T> Flow<List<T>>.flattenToList() =
    flatMapConcat {
        it.asFlow()
    }.toList()
