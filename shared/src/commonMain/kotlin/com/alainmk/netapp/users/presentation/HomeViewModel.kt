package com.alainmk.netapp.users.presentation

import com.alainmk.netapp.core.domain.util.toCommonStateFlow
import com.alainmk.netapp.di.Dispatcher
import com.alainmk.netapp.users.data.repository.UserRepository
import com.alainmk.translator_kmm.core.domain.util.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class HomeViewModel(
    private val repository: UserRepository,
    private val dispatcher: Dispatcher,
) : KoinComponent {
    private val viewModelScope = CoroutineScope(dispatcher.io)

    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.toCommonStateFlow()

    init {
        getAllFollowers()
    }

    fun onEvent(event: HomeEvent) {
        when(event) {
            is HomeEvent.OnFetch -> getAllFollowers()
        }
    }

    private fun getAllFollowers() {

        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }

            when (val result = repository.getAllFollowing()) {
                is Resource.Success -> {
                    _state.update {
                        it.copy(isLoading = false, users = result.data ?: emptyList())
                    }
                }

                is Resource.Error -> {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = result.throwable?.message ?: "Error Occured"
                        )
                    }
                }

            }
        }
    }
}