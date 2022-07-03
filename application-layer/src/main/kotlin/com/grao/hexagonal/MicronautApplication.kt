package com.grao.hexagonal

import io.micronaut.runtime.Micronaut

object MicronautApplication {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.run(MicronautApplication.javaClass)
    }
}

