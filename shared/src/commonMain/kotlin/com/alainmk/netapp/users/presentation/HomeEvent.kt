package com.alainmk.netapp.users.presentation

sealed class HomeEvent {
    data object OnFetch: HomeEvent()
}