package com.example.kmm.annyce.shared

object Injector {

    val todosRepository by lazy {
        TodosRepository(api = TodosApiReal())
    }
}
