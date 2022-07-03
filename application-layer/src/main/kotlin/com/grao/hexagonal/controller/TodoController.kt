package com.grao.hexagonal.controller

import com.grao.hexagonal.data.TodoDto
import jakarta.inject.Inject
import com.grao.hexagonal.ports.api.TodoServicePort
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*


@Controller("/todo")
class TodoController {

    @Inject
    lateinit var todoServicePort: TodoServicePort

    @Get(produces = [MediaType.APPLICATION_JSON])
    fun getAllTodos(): HttpResponse<List<TodoDto>> {
        return HttpResponse.ok(todoServicePort.listTodos())
    }

    @Get("/{id}",produces = [MediaType.APPLICATION_JSON])
    fun getTodoById(id: Long): HttpResponse<TodoDto> {
        return HttpResponse.ok(todoServicePort.getTodoById(id))
    }

    @Post(consumes = [MediaType.APPLICATION_JSON], produces = [MediaType.APPLICATION_JSON])
    fun createTodo(@Body todo: TodoDto): HttpResponse<TodoDto> {
        return HttpResponse.ok(todoServicePort.addTodo(todo))
    }

    @Put(consumes = [MediaType.APPLICATION_JSON], produces = [MediaType.APPLICATION_JSON])
    fun updateTodo(@Body todo: TodoDto): HttpResponse<TodoDto> {
        return HttpResponse.ok(todoServicePort.updateTodo(todo))
    }

    @Delete("/{id}", consumes = [MediaType.APPLICATION_JSON], produces = [MediaType.APPLICATION_JSON])
    fun deleteTodo(id: Long): HttpResponse<String> {
        val hasDeleteTodoById = todoServicePort.deleteTodoById(id)

        return if (!hasDeleteTodoById)
            HttpResponse.notFound()
        else
            HttpResponse.ok()
    }

}
