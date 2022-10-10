package com.picpay.desafio.android.ui.main.viewmodel

import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.domain.result.ApiResult
import com.picpay.desafio.android.domain.usecases.GetUsersUserCase
import com.picpay.desafio.android.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class MainViewModel(private val getUsersUserCase: GetUsersUserCase, val mainViewModelState: MainViewModelState) : BaseViewModel()
{
    override fun startView() {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            when (val response = getUsersUserCase.invoke()) {
                is ApiResult.Success -> {
                    response.data.let { userList ->

                    }
                }
                is ApiResult.Failure -> {

                }
            }
        }
    }

}