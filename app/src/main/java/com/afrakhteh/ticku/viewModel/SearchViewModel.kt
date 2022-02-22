package com.afrakhteh.ticku.viewModel

import android.util.Log
import android.widget.EditText
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.afrakhteh.ticku.model.useCase.ListsPagesUseCases
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@ObsoleteCoroutinesApi
class SearchViewModel @Inject constructor(
    private val listsPagesUseCases: ListsPagesUseCases
): ViewModel() {
    private val searchChanel = ConflatedBroadcastChannel<String>()

    fun setSearchQuery(search: String) {
        searchChanel.trySend(search).isSuccess
    }

    val searchTaskLiveData = searchChanel.asFlow()
        .flatMapLatest { search ->
            listsPagesUseCases.searchTaskUseCase(search)
        }.asLiveData()
}