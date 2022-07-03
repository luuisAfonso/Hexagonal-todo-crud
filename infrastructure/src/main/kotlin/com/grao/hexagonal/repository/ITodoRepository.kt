package com.grao.hexagonal.repository

import com.grao.hexagonal.entity.Todo
import java.util.*

interface ITodoRepository {
    fun findById(id: Long): Optional<Todo>

    fun findAll(): List<Todo>

    fun save(todo: Todo): Todo

    fun update(todo: Todo): Todo

    fun deleteById(id: Long): Boolean
}