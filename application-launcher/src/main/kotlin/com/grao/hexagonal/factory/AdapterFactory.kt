package com.grao.hexagonal.factory

import com.grao.hexagonal.adapters.TodoPersistenceAdapter
import com.grao.hexagonal.mapper.TodoMapper
import com.grao.hexagonal.ports.api.TodoServicePort
import com.grao.hexagonal.repository.TodoRepositoryImpl
import com.grao.hexagonal.service.TodoServiceImpl
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Factory
class AdapterFactory {

    @Singleton
    fun todoServicePort(): TodoServicePort {
        return TodoServiceImpl(TodoPersistenceAdapter(TodoRepositoryImpl(), TodoMapper()))
    }
}