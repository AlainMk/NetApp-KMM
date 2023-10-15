package com.alainmk.netapp.di

import com.alainmk.netapp.users.presentation.HomeViewModel
import org.koin.dsl.module

actual fun getViewModelByPlatform() = module {
    single {
        HomeViewModel(get(), provideDispatcher())
    }
}