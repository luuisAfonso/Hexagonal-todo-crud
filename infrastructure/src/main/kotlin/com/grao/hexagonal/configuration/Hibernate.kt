package com.grao.hexagonal.configuration

import com.grao.hexagonal.entity.Todo
import org.hibernate.SessionFactory
import org.hibernate.cfg.Configuration

class Hibernate {

    companion object {
        fun session(): SessionFactory = Hibernate().buildSessionFactory()
    }

    fun buildSessionFactory(): SessionFactory {

        val configuration = Configuration()
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/todo")
        configuration.setProperty("hibernate.connection.username", "postgres")
        configuration.setProperty("hibernate.connection.password", "postgres")
        configuration.setProperty("hibernate.hbm2ddl.auto", "update")
        configuration.setProperty("hibernate.show_sql", "true")

        configuration.addAnnotatedClass(Todo::class.java)


        return configuration.buildSessionFactory()
    }
}