package com.dicoding.submission.thesports.core.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dicoding.submission.thesports.core.CoroutineTestRule
import com.dicoding.submission.thesports.core.data.commons.Resource
import com.dicoding.submission.thesports.core.data.fakeObject.FakeObject
import com.dicoding.submission.thesports.core.data.local.EventLocalDataSource
import com.dicoding.submission.thesports.core.data.remote.EventRemoteDataSource
import com.dicoding.submission.thesports.core.domain.repository.EventRepository
import com.dicoding.submission.thesports.core.utils.DataMapper
import kotlinx.coroutines.ExperimentalCoroutinesApi
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
class EventRepositoryTest{
    @get:Rule val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule val testCoroutineRule = CoroutineTestRule()

    @Mock private lateinit var remoteDataSource : EventRemoteDataSource
    @Mock private lateinit var localDataSource: EventLocalDataSource

    private lateinit var repository: EventRepository

    @Before
    fun setup(){
        repository = EventRepositoryImpl(localDataSource, remoteDataSource)
    }

    @Test
    fun `should get all data event`() = testCoroutineRule.runBlockingTest {
        val expected = flow {
            emit(FakeObject.getListEvent())
        }

        `when`(localDataSource.getAllEvent()).thenReturn(expected)
        localDataSource.getAllEvent()

        repository.getListEvent()

        val data = Resource.Success(data = FakeObject.getListEvent())
        verify(localDataSource).getAllEvent()
        assertNotNull(data)
        assertEquals(FakeObject.getListEvent().size, data.data?.size)
    }

    @Test
    fun `should get all event favorite`() = testCoroutineRule.runBlockingTest {
        val expected = flow {
            emit(FakeObject.getListEvent())
        }

        `when`(localDataSource.getFavoriteEvent()).thenReturn(expected)
        repository.getFavoriteEvent()

        val data = DataMapper.mapEventEntitiesToDomain(FakeObject.getListEvent())
        verify(localDataSource).getFavoriteEvent()
        assertNotNull(data)
        assertEquals(FakeObject.getEntitiesToDomain().size, data.size)
    }
}