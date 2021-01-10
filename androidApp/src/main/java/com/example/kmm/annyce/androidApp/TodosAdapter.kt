package com.example.kmm.annyce.androidApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kmm.annyce.androidApp.databinding.ItemTodoBinding
import com.example.kmm.annyce.shared.Todo

class TodosAdapter(var todos: List<Todo>) : RecyclerView.Adapter<TodosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = todos.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(todos[position])
    }

    inner class ViewHolder(private val itemBinding: ItemTodoBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bindData(todo: Todo) {
            itemBinding.checkBox.isChecked = todo.completed
            itemBinding.textView.text = todo.title
        }
    }
}
