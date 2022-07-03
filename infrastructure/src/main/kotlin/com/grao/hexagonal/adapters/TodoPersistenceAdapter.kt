package com.grao.hexagonal.adapters

import com.grao.hexagonal.data.TodoDto
import com.grao.hexagonal.exceptions.EntityNotFoundException
import com.grao.hexagonal.exceptions.InvalidEntityException
import com.grao.hexagonal.exceptions.RequiredIdException
import com.grao.hexagonal.mapper.TodoMapper
import com.grao.hexagonal.ports.spi.TodoPersistencePort
import com.grao.hexagonal.repository.ITodoRepository

class TodoPersistenceAdapter(
    private val todoRepository: ITodoRepository,
    private val mapper: TodoMapper,
) : TodoPersistencePort {

    override fun getTodoById(id: Long): TodoDto {
        val optionalTodo = todoRepository.findById(id)

        if (optionalTodo.isEmpty) {
            throw EntityNotFoundException(id)
        }

        return mapper.persistableTodoToTodoDto(optionalTodo.get())
    }

    override fun listTodos(): List<TodoDto> {
        return mapper.persistableTodoListToTodoDtoList(todoRepository.findAll().toList())
    }

    override fun addTodo(todo: TodoDto): TodoDto {
        val persistableTodo = mapper.todoDtoToPersistableTodo(todo)

        if (persistableTodo.id != null)
            throw InvalidEntityException("The entity already has a specified Id and can't be created")

        return mapper.persistableTodoToTodoDto(todoRepository.save(persistableTodo))
    }

    override fun updateTodo(todo: TodoDto): TodoDto {
        val persistableTodo = mapper.todoDtoToPersistableTodo(todo)

        if (persistableTodo.id == null)
            throw RequiredIdException()

        val updatedTODO = todoRepository.update(persistableTodo)

        return mapper.persistableTodoToTodoDto(updatedTODO)
    }

    override fun deleteTodoById(id: Long): Boolean {
        return todoRepository.deleteById(id)
    }
}