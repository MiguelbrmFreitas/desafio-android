package com.picpay.desafio.data.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.picpay.desafio.android.domain.repository.PicPayRepository
import com.picpay.desafio.android.domain.usecases.GetUsersUserCase
import com.picpay.desafio.data.remote.PicPayRepositoryImpl
import com.picpay.desafio.data.remote.PicPayService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

private const val TIME_OUT = 30L
private val BASE_URL = "https://609a908e0f5a13001721b74e.mockapi.io/picpay/api/"

val remoteDataModule = module {
    single { createService(get()) }

    single { createRetrofit(get(), BASE_URL) }

    single { createOkHttpClient(get()) }

    single { createLoggingInterceptor() }

}

fun createMoshiBuilder(): Moshi {
    return Moshi.Builder().build()
}

fun createLoggingInterceptor(): HttpLoggingInterceptor {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return loggingInterceptor
}

fun createOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(TIME_OUT, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor).build()
}

fun createRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
    val moshi by lazy {
        val moshiBuilder = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
        moshiBuilder.build()
    }


    return Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addConverterFactory(ScalarsConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
}

fun createService(retrofit: Retrofit): PicPayService {
    return retrofit.create(PicPayService::class.java)
}

fun createPicPayRepository(picPayService: PicPayService): PicPayRepository {
    return PicPayRepositoryImpl(picPayService)
}

fun createGetUsersUseCase(picPayRepository: PicPayRepository): GetUsersUserCase {
    return GetUsersUserCase(picPayRepository)
}
