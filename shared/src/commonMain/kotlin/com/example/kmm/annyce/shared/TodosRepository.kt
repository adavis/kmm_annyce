package com.example.kmm.annyce.shared

import co.touchlab.kermit.Kermit
import org.koin.core.KoinComponent
import org.koin.core.inject

class TodosRepository : KoinComponent {

    private val api: TodosApi by inject()
    private val logger: Kermit by inject()

    private val todos: MutableList<Todo> = mutableListOf()

    @Throws(Exception::class) suspend fun getAllTodos(forceReload: Boolean): List<Todo> {
        logger.i{ "loading todos" }

        return if (todos.isNotEmpty() && !forceReload) {
            todos
        } else {
            api.getAllTodos().also {
                todos.clear()
                todos.addAll(it)
            }
        }
    }

}
