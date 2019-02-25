package com.husar.exercise.smarthome

import com.husar.exercise.smarthome.controller.AppController

fun main(args : Array<String>) {

    val appName = "Smart Home v0.1"
    println(appName)
    println()

    val appController = AppController()

    appController.activateSystem()
}
