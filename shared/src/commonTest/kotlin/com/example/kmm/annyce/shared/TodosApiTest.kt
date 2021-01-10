package com.example.kmm.annyce.shared

import kotlin.test.Test
import kotlin.test.assertTrue

class TodosApiTest : BaseTest() {

    private val todosApi = TodosApiMock()

    @Test
    fun todosLoadProperlyTest() = runTest {
        assertTrue(todosApi.getAllTodos().size == 3)
    }
}
