package com.dicoding.course.apptestcrash

import android.app.Application
import timber.log.Timber

open class App: Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}