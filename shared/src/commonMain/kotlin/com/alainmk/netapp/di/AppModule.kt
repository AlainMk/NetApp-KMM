package com.alainmk.netapp.di

import com.alainmk.netapp.users.data.remote.UserApiService
import com.alainmk.netapp.users.data.repository.UserRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val commonModule = module {
    singleOf(::UserApiService)
    singleOf(::UserRepository)
}