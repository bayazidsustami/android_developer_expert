package com.dicoding.tourismapp

import android.app.Application
import com.dicoding.tourismapp.core.di.databaseModule
import com.dicoding.tourismapp.core.di.networkModule
import com.dicoding.tourismapp.core.di.repositoryModule
import com.dicoding.tourismapp.di.useCaseModule
import com.dicoding.tourismapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(
                databaseModule,
                networkModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            ))
        }
    }
}