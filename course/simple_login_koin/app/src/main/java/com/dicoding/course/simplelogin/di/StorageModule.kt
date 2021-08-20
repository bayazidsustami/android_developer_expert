package com.dicoding.course.simplelogin.di

import android.content.Context
import com.dicoding.course.core.SessionManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {
    @Singleton
    @Provides
    fun provideSessionManager(context: Context): SessionManager = SessionManager(context)
}