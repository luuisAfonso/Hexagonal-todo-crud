package com.grao.hexagonal.mapper

import com.grao.hexagonal.data.TodoDto
import com.grao.hexagonal.entity.Todo
import java.util.stream.Collectors

class TodoMapper {
    fun persistableTodoToTodoDto(todo: Todo): TodoDto {
        return TodoDto(todo.id, todo.title, todo.description, todo.schedule, todo.createdAt)
    }

    fun todoDtoToPersistableTodo(todoDto: TodoDto): Todo {
        return Todo(todoDto.id, todoDto.title, todoDto.description, todoDto.schedule, todoDto.createdAt)
    }

    fun todoDtoListToPersistableTodoList(todos: List<TodoDto>): List<Todo> {
        return todos.stream()
            .map(this::todoDtoToPersistableTodo)
            .collect(Collectors.toList())
    }

    fun persistableTodoListToTodoDtoList(persistableTodos: List<Todo>): List<TodoDto> {
        return persistableTodos.stream()
            .map(this::persistableTodoToTodoDto)
            .collect(Collectors.toList())
    }
}