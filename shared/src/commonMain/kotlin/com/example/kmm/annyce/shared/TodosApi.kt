package com.example.kmm.annyce.shared

interface TodosApi {
    suspend fun getAllTodos(): List<Todo>
}
