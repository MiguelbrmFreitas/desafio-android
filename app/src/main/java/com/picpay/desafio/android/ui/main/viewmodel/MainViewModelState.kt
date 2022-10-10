package com.picpay.desafio.android.ui.main.viewmodel

import com.picpay.desafio.android.util.components.RecyclerComponent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class MainViewModelState
(
    val _recyclerUsers: MutableStateFlow<RecyclerComponent> = MutableStateFlow(RecyclerComponent()),
    val recyclerUsers: StateFlow<RecyclerComponent> = _recyclerUsers
)