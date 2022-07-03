package com.grao.hexagonal.applicationlayer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.grao.hexagonal.applicationlayer"])
class ApplicationLayerApplication

fun main(args: Array<String>) {
    runApplication<ApplicationLayerApplication>(*args)
}
