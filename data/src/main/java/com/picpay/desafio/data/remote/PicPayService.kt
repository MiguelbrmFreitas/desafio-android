package com.picpay.desafio.data.remote

import com.picpay.desafio.android.domain.entities.User
import retrofit2.Response
import retrofit2.http.GET


interface PicPayService {
    @GET("users")
    fun getUsers(): Response<List<User>>
}