package com.grao.hexagonal.service

import com.grao.hexagonal.data.TodoDto
import com.grao.hexagonal.ports.api.TodoServicePort
import com.grao.hexagonal.ports.spi.TodoPersistencePort

class TodoServiceImpl(private val todoPersistencePort: TodoPersistencePort) : TodoServicePort {

    override fun getTodoById(id: Long): TodoDto {
        return todoPersistencePort.getTodoById(id)
    }

    override fun listTodos(): List<TodoDto> {
        return todoPersistencePort.listTodos()
    }

    override fun addTodo(todo: TodoDto): TodoDto {
        return todoPersistencePort.addTodo(todo)
    }

    override fun updateTodo(todo: TodoDto): TodoDto {
        return todoPersistencePort.updateTodo(todo)
    }

    override fun deleteTodoById(id: Long): Boolean {
        return todoPersistencePort.deleteTodoById(id)
    }
}