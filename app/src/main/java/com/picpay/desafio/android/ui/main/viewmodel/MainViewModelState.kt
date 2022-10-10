package com.picpay.desafio.android.ui.main.viewmodel

import android.view.View
import com.picpay.desafio.android.util.components.RecyclerComponent
import kotlinx.coroutines.flow.MutableStateFlow

data class MainViewModelState
(
    val recyclerUsers: MutableStateFlow<RecyclerComponent> = MutableStateFlow(RecyclerComponent()),
    val progressVisibility: MutableStateFlow<Int> = MutableStateFlow(View.VISIBLE)
)