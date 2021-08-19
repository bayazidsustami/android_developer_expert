package com.dicoding.course.simplelogin

import android.app.Application
import com.dicoding.course.simplelogin.di.AppComponent
import com.dicoding.course.simplelogin.di.DaggerAppComponent

open class App : Application(){
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}