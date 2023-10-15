package com.alainmk.netapp.di

import kotlinx.coroutines.CoroutineDispatcher

interface Dispatcher {
    val io: CoroutineDispatcher
}

internal expect fun provideDispatcher(): Dispatcher