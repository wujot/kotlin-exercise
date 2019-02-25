package com.husar.exercise

enum class AudioFormat {
    MID, MP3, WAV, OGG
}

interface MediaPlayer {
    var format: AudioFormat
    fun play(filename: String)
}

class MidiDecoder(override var format: AudioFormat = AudioFormat.MID): MediaPlayer {
    override fun play(filename: String) {
        println(filename)
    }
}

class Mp3Decoder(override var format: AudioFormat = AudioFormat.MP3): MediaPlayer {
    override fun play(filename: String) {
        println(filename)
    }
}

class WavDecoder(override var format: AudioFormat = AudioFormat.WAV): MediaPlayer {
    override fun play(filename: String) {
        println(filename)
    }
}

class OggDecoder(override var format: AudioFormat = AudioFormat.OGG): MediaPlayer {
    override fun play(filename: String) {
        println(filename)
    }
}

class Player(val mediaPlayer: MediaPlayer): MediaPlayer by mediaPlayer {
    override fun play(filename: String) {
        val (name, fileFormat) = filename.split(".")
        if(format.name.toLowerCase() == fileFormat) {
            println("Module format: $format")
            println("Audio format: $fileFormat")
            mediaPlayer.play("Audio name: $name")
        } else {
          println("${format.name} Decoder does not support .$fileFormat file extension !")
        }
    }
}


fun main(args : Array<String>) {

    val fileName = "temp.mid"
    val player = Player(Mp3Decoder())
    player.play(fileName)
}