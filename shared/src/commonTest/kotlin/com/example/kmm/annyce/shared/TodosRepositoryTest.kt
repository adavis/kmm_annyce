package com.example.kmm.annyce.shared

import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

class TodosRepositoryTest : BaseTest() {

    private lateinit var repository: TodosRepository
    private val api = TodosApiMock()

    @BeforeTest
    fun setup() = runTest {
        repository = TodosRepository(api)
    }

    @AfterTest
    fun tearDown() = runTest {
        api.clearNumTimesCalled()
    }

    @Test
    fun todosLoadProperlyTest() = runTest {
        assertTrue(repository.getAllTodos(forceReload = false).size == 3)
    }

    @Test
    fun todosLoadFromCacheTest() = runTest {
        assertTrue(repository.getAllTodos(forceReload = false).size == 3)
        assertTrue(api.numTimesCalled == 1)

        assertTrue(repository.getAllTodos(forceReload = false).size == 3)
        assertTrue(api.numTimesCalled == 1, "The API should not have been called again")
    }

    @Test
    fun todosLoadFromNetworkTest() = runTest {
        assertTrue(repository.getAllTodos(forceReload = true).size == 3)
        assertTrue(api.numTimesCalled == 1)

        assertTrue(repository.getAllTodos(forceReload = true).size == 3)
        assertTrue(api.numTimesCalled == 2, "The API should not have been called again")
    }
}
