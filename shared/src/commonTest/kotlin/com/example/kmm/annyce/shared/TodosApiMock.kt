package com.example.kmm.annyce.shared

class TodosApiMock : TodosApi {

    override suspend fun getAllTodos(): List<Todo> {
        return listOf(
            Todo(id = 1, title = "foo bar baz", completed = true),
            Todo(id = 2, title = "donut pudding sweet roll", completed = false),
            Todo(id = 3, title = "chocolate caramels cake", completed = true)
        )
    }
}
