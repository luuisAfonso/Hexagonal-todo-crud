package com.grao.hexagonal.exceptions

class EntityNotFoundException(val id: Long) : RuntimeException("Can't find entity with specified $id id.")