package com.grao.hexagonal.data

import java.time.LocalDate

class TodoDto constructor(val id: Long?, val title: String?, val description: String?, val schedule: LocalDate?, val createdAt: LocalDate? = LocalDate.now())