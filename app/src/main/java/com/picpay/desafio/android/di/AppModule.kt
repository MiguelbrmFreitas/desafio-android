package com.picpay.desafio.android.di

import com.picpay.desafio.android.ui.main.viewmodel.MainViewModel
import com.picpay.desafio.android.ui.main.viewmodel.MainViewModelState
import com.picpay.desafio.data.di.createGetUsersUseCase
import com.picpay.desafio.data.di.createPicPayRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {

    viewModel { MainViewModel(get(), get()) }

    factory { MainViewModelState() }

    single { createPicPayRepository(get()) }

    single { createGetUsersUseCase(get()) }
}