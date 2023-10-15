package com.alainmk.netapp.di

import com.alainmk.netapp.users.presentation.HomeViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.dsl.module

actual fun getViewModelByPlatform() = module {
    single {
        HomeViewModel(get(), provideDispatcher())
    }
}

object KoinHelper: KoinComponent {
    fun getHomeViewModel() = get<HomeViewModel>()
}