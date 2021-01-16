package com.example.kmm.annyce.androidApp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmm.annyce.shared.Todo
import com.example.kmm.annyce.shared.TodosRepository
import kotlinx.coroutines.launch

class MainViewModel(private val todosRepository: TodosRepository) : ViewModel() {

    private val _todos : MutableLiveData<List<Todo>> = MutableLiveData()
    val todos: LiveData<List<Todo>> = _todos

    fun loadData(forceReload: Boolean) {
        viewModelScope.launch {
            todosRepository.getAllTodos(forceReload).also {
                _todos.value = it
            }
        }
    }
}
