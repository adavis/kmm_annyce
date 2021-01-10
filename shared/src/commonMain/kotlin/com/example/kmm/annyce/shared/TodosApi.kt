package com.example.kmm.annyce.shared

interface TodosApi {
    @Throws(Exception::class) suspend fun getAllTodos(): List<Todo>
}
