package com.grao.hexagonal.applicationlauncher.configuration

import com.grao.hexagonal.adapters.TodoPersistenceAdapter
import com.grao.hexagonal.mapper.TodoMapper
import com.grao.hexagonal.ports.api.TodoServicePort
import com.grao.hexagonal.repository.TodoRepositoryImpl
import com.grao.hexagonal.service.TodoServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PersitenceAdpterConfig {
    @Bean
    fun todoServicePort(): TodoServicePort {
        return TodoServiceImpl(TodoPersistenceAdapter(TodoRepositoryImpl(), TodoMapper()))
    }
}