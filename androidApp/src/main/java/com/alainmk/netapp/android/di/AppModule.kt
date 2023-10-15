package com.alainmk.netapp.android.di

import com.alainmk.netapp.android.presentation.home.AndroidHomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val androidAppModule = module {
    viewModelOf(::AndroidHomeViewModel)
}