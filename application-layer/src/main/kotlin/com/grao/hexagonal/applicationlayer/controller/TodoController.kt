package com.grao.hexagonal.applicationlayer.controller

import com.grao.hexagonal.data.TodoDto
import com.grao.hexagonal.ports.api.TodoServicePort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todo")
class TodoController(@Autowired(required = false) val todoServicePort: TodoServicePort?) {

    @GetMapping("/{id}")
    fun getTodo(@PathVariable id: Long): ResponseEntity<TodoDto> {
        val todoById = todoServicePort?.getTodoById(id)

        return ResponseEntity.ok(todoById)
    }

    @GetMapping
    fun listAll(): ResponseEntity<List<TodoDto>> {
        val listTodos = todoServicePort?.listTodos()

        return ResponseEntity.ok(listTodos)
    }

    @PostMapping
    fun createTodo(@RequestBody todoDto: TodoDto): ResponseEntity<TodoDto> {
        val todo = todoServicePort?.addTodo(todoDto)

        return ResponseEntity.ok(todo)
    }

    @PutMapping
    fun updateTodo(@RequestBody todoDto: TodoDto): ResponseEntity<TodoDto> {
        val updateTodo = todoServicePort?.updateTodo(todoDto)

        return ResponseEntity.ok(updateTodo)
    }

    @DeleteMapping("/{id}")
    fun deleteTodo(@PathVariable id: Long): ResponseEntity<Any> {
        val hasBeenDeleted = todoServicePort?.deleteTodoById(id)

        return if (hasBeenDeleted == true)
            ResponseEntity.ok().build()
        else
            ResponseEntity.notFound().build()
    }
}