package com.picpay.desafio.android.domain.repository

import com.picpay.desafio.android.domain.entities.User
import com.picpay.desafio.android.domain.result.ApiResult

interface PicPayRepository
{
    suspend fun getUsers(): ApiResult<List<User>>
}