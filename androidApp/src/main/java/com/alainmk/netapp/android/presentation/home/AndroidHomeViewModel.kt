package com.alainmk.netapp.android.presentation.home

import androidx.lifecycle.ViewModel
import com.alainmk.netapp.users.presentation.HomeEvent
import com.alainmk.netapp.users.presentation.HomeViewModel

class AndroidHomeViewModel(private val viewModel: HomeViewModel): ViewModel() {

    val state = viewModel.state

    fun onEvent(event: HomeEvent) {
        viewModel.onEvent(event)
    }
}