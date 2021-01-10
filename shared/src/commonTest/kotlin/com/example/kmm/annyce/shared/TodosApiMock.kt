package com.example.kmm.annyce.shared

class TodosApiMock : TodosApi {

    var numTimesCalled: Int = 0

    override suspend fun getAllTodos(): List<Todo> {
        numTimesCalled++

        return listOf(
            Todo(id = 1, title = "foo bar baz", completed = true),
            Todo(id = 2, title = "donut pudding sweet roll", completed = false),
            Todo(id = 3, title = "chocolate caramels cake", completed = true)
        )
    }

    fun clearNumTimesCalled() {
        numTimesCalled = 0
    }
}
