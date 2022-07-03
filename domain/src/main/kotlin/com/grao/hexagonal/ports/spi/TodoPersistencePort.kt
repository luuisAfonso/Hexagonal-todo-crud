package com.grao.hexagonal.ports.spi

import com.grao.hexagonal.data.TodoDto

interface TodoPersistencePort {

    fun getTodoById(id: Long): TodoDto

    fun listTodos(): List<TodoDto>

    fun addTodo(todo: TodoDto): TodoDto

    fun updateTodo(todo: TodoDto): TodoDto

    fun deleteTodoById(id: Long): Boolean

}
