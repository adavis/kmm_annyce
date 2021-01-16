package com.example.kmm.annyce.androidApp.di

import com.example.kmm.annyce.androidApp.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainViewModel(get()) }
}
