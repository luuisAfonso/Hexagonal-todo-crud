package com.grao.hexagonal.entity

import org.hibernate.Hibernate
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "todo")
data class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val title: String? = null,

    @Column
    val description: String? = null,

    @Column
    val schedule: LocalDate? = null,

    @Column
    val createdAt: LocalDate? = null,

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Todo

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}