package com.example.kmm.annyce.androidApp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kmm.annyce.androidApp.databinding.ActivityMainBinding
import com.example.kmm.annyce.shared.Todo
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val todosAdapter = TodosAdapter(listOf())
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Todos"
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.todos.observe(this, {
            displayTodos(it)
        })

        binding.todosRecyclerView.adapter = todosAdapter
        binding.todosRecyclerView.layoutManager = LinearLayoutManager(this)

        binding.swipeContainer.setOnRefreshListener {
            binding.swipeContainer.isRefreshing = false
            loadData()
        }

        loadData()
    }

    private fun loadData() {
        binding.progressBarView.isVisible = true
        viewModel.loadData(false)
    }

    private fun displayTodos(todos: List<Todo>) {
        todosAdapter.todos = todos
        todosAdapter.notifyDataSetChanged()

        binding.progressBarView.isVisible = false
    }
}
