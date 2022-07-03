package com.grao.hexagonal.repository

import com.grao.hexagonal.configuration.Hibernate
import com.grao.hexagonal.entity.Todo
import java.util.*

class TodoRepositoryImpl : ITodoRepository {

    override fun findById(id: Long): Optional<Todo> {
        val openSession = Hibernate.session().openSession()
        val optionalTodo = Optional.ofNullable(openSession.find(Todo::class.java, id))

        openSession.close()
        return optionalTodo
    }

    override fun findAll(): List<Todo> {
        val openedSession = Hibernate.session().openSession()
        val query = openedSession.createQuery("SELECT t FROM Todo t", Todo::class.java)
        val resultList = query.resultList
        openedSession.close()

        return resultList
    }

    override fun save(todo: Todo): Todo {
        val session = Hibernate.session().openSession()
        val beginTransaction = session.beginTransaction()

        session.persist(todo)

        beginTransaction.commit()
        session.close()

        return todo
    }

    override fun update(todo: Todo): Todo {
        val session = Hibernate.session().openSession()
        val beginTransaction = session.beginTransaction()

        session.merge(todo)

        beginTransaction.commit()
        session.close()

        return todo
    }

    override fun deleteById(id: Long): Boolean {
        val session = Hibernate.session().openSession()
        val beginTransaction = session.beginTransaction()

        val optionalTodo = Optional.ofNullable(session.find(Todo::class.java, id))

        if (optionalTodo.isPresent) {
            session.remove(optionalTodo.get())
            beginTransaction.commit()
            return true
        }

        return false
    }
}