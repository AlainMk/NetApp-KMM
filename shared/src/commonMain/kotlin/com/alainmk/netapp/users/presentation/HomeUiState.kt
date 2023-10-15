package com.alainmk.netapp.users.presentation

import com.alainmk.netapp.users.domain.user.User

data class HomeUiState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val error: String? = null,
)