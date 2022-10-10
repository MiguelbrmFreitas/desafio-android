package com.picpay.desafio.android.application

import android.app.Application
import androidx.multidex.MultiDex
import com.picpay.desafio.android.di.appModule
import com.picpay.desafio.data.di.remoteDataModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MainApplication)
            modules(listOf(remoteDataModule, appModule))
        }

    }
}