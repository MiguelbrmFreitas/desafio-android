package com.picpay.desafio.android.ui.main.viewmodel

import android.view.View
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
                        mainViewModelState.apply {
                            recyclerUsers.value = RecyclerComponent(
                                adapter = userListAdapter
                            )

                            progressVisibility.value = View.GONE
                        }

                        userListAdapter.users = userList
                    }
                }
                is ApiResult.Failure -> {
                    mainViewModelState.progressVisibility.value = View.GONE

                    //TODO: Criar snackbar de erro
                }
            }
        }
    }

}