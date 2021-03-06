package com.dicoding.course.simplelogin

import com.dicoding.course.core.UserRepository
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.koin.core.context.loadKoinModules
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class MainActivityTest: KoinTest{
    private val userRepository: UserRepository by inject()
    private val userName = "bay bay"

    @Before
    fun before(){
        loadKoinModules(storageModule)
        userRepository.loginUser(userName)
    }

    @After
    fun after(){
        stopKoin()
    }

    @Test
    fun getUsernameFromRepository(){
        val requestedName = userRepository.getUser()
        assertEquals(userName, requestedName)
    }
}