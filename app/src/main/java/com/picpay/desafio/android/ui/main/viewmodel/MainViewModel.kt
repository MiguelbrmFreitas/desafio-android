package com.picpay.desafio.android.ui.main.viewmodel

import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.domain.result.ApiResult
import com.picpay.desafio.android.domain.usecases.GetUsersUserCase
import com.picpay.desafio.android.ui.base.BaseViewModel
import com.picpay.desafio.android.ui.main.adapter.UserListAdapter
import com.picpay.desafio.android.util.components.RecyclerComponent
import kotlinx.coroutines.launch

class MainViewModel(private val getUsersUserCase: GetUsersUserCase, val mainViewModelState: MainViewModelState) : BaseViewModel()
{
    private val userListAdapter by lazy { UserListAdapter() }

    override fun startView() {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            when (val response = getUsersUserCase.invoke()) {
                is ApiResult.Success -> {
                    response.data.let { userList ->
                        mainViewModelState._recyclerUsers.value = RecyclerComponent(
                            adapter = userListAdapter
                        )

                        userListAdapter.users = userList
                    }
                }
                is ApiResult.Failure -> {

                }
            }
        }
    }

}