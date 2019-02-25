package com.husar.exercise.smarthome.controller

import com.husar.exercise.smarthome.model.*
import java.lang.NullPointerException

class AppController {

    // List of locations
    var locations = mutableListOf<Location>()
    // Initialize configuration
    init {
        Location.values().forEach { location ->
            locations.add(location)
        }
        locations.forEach{ it ->
            when(it.name.toLowerCase()) {
                "kitchen" -> it.devices.add(Oven())
                "bedroom" -> it.devices.add(SoundSystem())
                "hall" -> it.devices.add(Camera())
            }
            it.devices.add(Radiator())
            it.devices.add(Light())
        }
        println("Initialized configurations")
        println()
    }

    // Get location by name
    fun getLocation(name: String): Location? {
        var location: Location? = null
        locations.forEach { it ->
            if (it.name.toLowerCase() == name) {
                location = it
            }
        }
        if (location == null) {
            println("Unknown location")
        }
        return location
    }

    // Get Device by location
    fun getDeviceByLocation(locationName: String, deviceName: String): Device? {
        var device: Device? = null
        var location = getLocation(locationName)
        location!!.devices.forEach { it ->
            if (it.type.name.toLowerCase() == deviceName) {
                println("Found")
                device = it
            }
        }
        if (device == null) {
            println("Unknown device")
        }
        return device
    }

    // Run Oven
    fun startOven() {
        val oven = getDeviceByLocation("kitchen", "oven")
        oven!!.activate()
    }

    // Stop Oven
    fun stopOven() {
        val oven = getDeviceByLocation("kitchen", "oven")
        oven!!.deactivate()
    }

    // Activate device by name and location
    fun activateDeviceIn(deviceName: String, locationName: String) {
        try {
            val device: Device? = getDeviceByLocation(locationName, deviceName)
            device!!.activate()
        } catch (e: NullPointerException) {
            println("Device not found")
        }
    }

    // Deactivate device by name and location
    fun deactivateDeviceIn(deviceName: String, locationName: String) {
        try {
            val device: Device? = getDeviceByLocation(locationName, deviceName)
            device!!.deactivate()
        } catch (e: NullPointerException) {
            println("Device not found")
        }
    }

    // Activate all devices
    fun activateSystem() {
        locations.forEach{ location ->
            println()
            println("${location.name} devices will start activation")
            println()
            location.devices.forEach {device ->
                device.activate()
            }
        }
    }

    // Deactivate all devices
    fun deactivateSystem() {
        locations.forEach{ location ->
            println()
            println("${location.name} devices will start deactivation")
            println()
            location.devices.forEach {device ->
                device.deactivate()
            }
        }
    }
}