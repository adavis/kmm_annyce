package com.example.kmm.annyce.androidApp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmm.annyce.shared.Injector
import com.example.kmm.annyce.shared.Todo
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _todos : MutableLiveData<List<Todo>> = MutableLiveData()
    val todos: LiveData<List<Todo>> = _todos

    fun loadData(forceReload: Boolean) {
        viewModelScope.launch {
            Injector.todosRepository.getAllTodos(forceReload).also {
                _todos.value = it
            }
        }
    }
}
