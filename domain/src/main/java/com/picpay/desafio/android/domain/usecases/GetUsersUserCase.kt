package com.picpay.desafio.android.domain.usecases

import com.picpay.desafio.android.domain.repository.PicPayRepository

class GetUsersUserCase (private val picPayRepository: PicPayRepository)
{
    suspend fun invoke() = picPayRepository.getUsers()
}