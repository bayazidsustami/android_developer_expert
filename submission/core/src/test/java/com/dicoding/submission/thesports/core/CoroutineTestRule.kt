package com.dicoding.submission.thesports.core

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

@ExperimentalCoroutinesApi
class CoroutineTestRule: TestRule {

    private val testCoroutineDispatcher = TestCoroutineDispatcher()
    private val testCoroutineScope = TestCoroutineScope(testCoroutineDispatcher)

    override fun apply(base: Statement?, description: Description?): Statement {
        return object : Statement(){
            @Throws(Throwable::class)
            override fun evaluate() {
                Dispatchers.setMain(testCoroutineDispatcher)
                base?.evaluate()

                Dispatchers.resetMain()
                testCoroutineScope.cleanupTestCoroutines()
            }
        }
    }

    fun runBlockingTest(bloc: suspend CoroutineTestRule.() -> Unit){
        testCoroutineScope.runBlockingTest { bloc() }
    }
}