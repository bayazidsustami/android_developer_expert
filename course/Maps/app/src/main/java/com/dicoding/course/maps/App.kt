package com.dicoding.course.maps

import android.app.Application
import com.mapbox.mapboxsdk.Mapbox

open class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Mapbox.getInstance(applicationContext, getString(R.string.mapbox_access_token))
    }
}