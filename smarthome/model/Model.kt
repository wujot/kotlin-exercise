package com.husar.exercise.smarthome.model

enum class Location(var devices: MutableList<Device>) {
    KITCHEN(mutableListOf<Device>()),
    HALL(mutableListOf<Device>()),
    BATHROM(mutableListOf<Device>()),
    BEDROOM(mutableListOf<Device>()),
    LIVINGROOM(mutableListOf<Device>())
}

enum class DeviceType {
    CAMERA, LIGHT, RADIATOR, OVEN, SOUNDSYSTEM
}

interface Device {
    var type: DeviceType
    var isWorking: Boolean
    fun activate() {
        if (!isWorking) {
            isWorking = true
        }
        println("${type.name} had been activated")
    }
    fun deactivate() {
        if (isWorking) {
            isWorking = false
        }
        println("${type.name} had been deactivated")
    }
}

class Camera(
             override var type: DeviceType = DeviceType.CAMERA,
             override var isWorking: Boolean = false,
             var isDayVision: Boolean = true
        ): Device {
        fun setNightVision() {
            if (isDayVision) {
                isDayVision = false
            }
        }
    fun setDayVision() {
        if (!isDayVision) {
            isDayVision = true
        }
    }
}

class Light(
             override var type: DeviceType = DeviceType.LIGHT,
             override var isWorking: Boolean = false
): Device {
}

class Radiator(
            override var type: DeviceType = DeviceType.RADIATOR,
            override var isWorking: Boolean = false
): Device {
}

class Oven(
    override var type: DeviceType = DeviceType.OVEN,
    override var isWorking: Boolean = false,
    var temperature: Int = 0,
    var time: Double = 0.0
): Device {
}

class SoundSystem(
    override var type: DeviceType = DeviceType.SOUNDSYSTEM,
    override var isWorking: Boolean = false,
    var isPlaying: Boolean = false
): Device {
    fun playAudio() {
        if (isWorking) {
            isPlaying = true
        }
    }
    fun stopAudio() {
        if(isPlaying) {
            isPlaying = false
        }
    }
}



