package com.example.kmm.annyce.shared

class TodosRepository(private val api: TodosApi) {

    private val todos: MutableList<Todo> = mutableListOf()

    @Throws(Exception::class) suspend fun getAllTodos(forceReload: Boolean): List<Todo> {
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
