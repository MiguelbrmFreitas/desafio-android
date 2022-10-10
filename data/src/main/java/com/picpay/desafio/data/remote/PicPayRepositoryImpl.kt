package com.picpay.desafio.data.remote

import com.picpay.desafio.android.domain.entities.User
import com.picpay.desafio.android.domain.repository.PicPayRepository
import com.picpay.desafio.android.domain.result.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PicPayRepositoryImpl(private val picPayService: PicPayService) : PicPayRepository
{
    override suspend fun getUsers(): ApiResult<List<User>> =
        withContext(Dispatchers.IO) {
            val response = picPayService.getUsers()
            if (response.isSuccessful) {
                response.body()?.let { users ->
                    return@withContext ApiResult.Success(users)
                } ?: kotlin.run {
                    return@withContext ApiResult.Failure(response.message())
                }
            } else {
                return@withContext ApiResult.Failure(response.message())
            }
        }

}