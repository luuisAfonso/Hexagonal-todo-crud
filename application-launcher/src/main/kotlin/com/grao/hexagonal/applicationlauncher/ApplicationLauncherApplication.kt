package com.grao.hexagonal.applicationlauncher

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.grao.hexagonal.applicationlayer", "com.grao.hexagonal.applicationlauncher"])
class ApplicationLauncherApplication

fun main(args: Array<String>) {



    runApplication<ApplicationLauncherApplication>(*args)
}
