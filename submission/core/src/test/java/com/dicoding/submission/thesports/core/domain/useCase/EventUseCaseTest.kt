package com.dicoding.submission.thesports.core.domain.useCase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dicoding.submission.thesports.core.CoroutineTestRule
import com.dicoding.submission.thesports.core.data.commons.Resource
import com.dicoding.submission.thesports.core.data.fakeObject.FakeObject
import com.dicoding.submission.thesports.core.domain.repository.EventRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class EventUseCaseTest{

    @Mock private lateinit var repository: EventRepository

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = CoroutineTestRule()

    private lateinit var useCase: EventUseCase

    @Before
    fun setup(){
        useCase = EventUseCaseImpl(repository)
    }

    @Test
    fun `should get all data event`() = testCoroutineRule.runBlockingTest{
        val objects = FakeObject.getEntitiesToDomain()
        val returns = flow {
            emit(Resource.Success(objects))
        }

        `when`(repository.getListEvent()).thenReturn(returns)
        useCase.getAllEvent()

        verify(repository).getListEvent()
        assertNotNull(returns)
        assertEquals(objects, returns.first().data)
    }

    @Test
    fun `should get all data favorite event`() = testCoroutineRule.runBlockingTest {
        val objects = FakeObject.getEntitiesToDomain()
        val returns = flow {
            emit(objects)
        }
        `when`(repository.getFavoriteEvent()).thenReturn(returns)
        useCase.getFavoriteEvent()

        verify(repository).getFavoriteEvent()
        assertNotNull(returns)
        assertEquals(objects.size, returns.first().size)
    }
}