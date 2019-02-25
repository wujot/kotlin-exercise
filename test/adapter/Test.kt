package com.husar.exercise.adapter

import com.husar.exercise.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test

class Test {

    @Test
    fun`Player plays file extensions supported by assigned decoder`() {
        val fileName = "temp.mp3"
        val player = Player(Mp3Decoder())
        val mp3DecoderFormat = Mp3Decoder().format
        val mediaPlayerFormat = player.mediaPlayer.format
        assertEquals(mp3DecoderFormat, mediaPlayerFormat)
    }

    @Test
    fun`Player does not play file extensions unsupported by decoder`() {
        val filename = "temp.wav"
        val player = Player(WavDecoder())
        val oggDecooderFormat = OggDecoder().format
        val mediaPlayerFormat = player.mediaPlayer.format
        val isSupportExtension: () -> Boolean = {
            oggDecooderFormat == mediaPlayerFormat
        }
        assertFalse(isSupportExtension())
    }
}