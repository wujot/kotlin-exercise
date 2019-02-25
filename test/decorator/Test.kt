package com.husar.exercise.decorator

import com.husar.exercise.LogLevel
import com.husar.exercise.LoggerDecorator
import com.husar.exercise.LoggerTemplate
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class Test {

    @Test
    fun`Default log level should be NORMAL`() {
        val logger = LoggerDecorator.LoggerDefault(LoggerTemplate())
        val currentLogLevel = logger.level.name
        assertEquals("NORMAL", currentLogLevel)
    }

    @Test
    fun`Change log level to DEBUG`() {
        val logger = LoggerDecorator.LoggerDefault(LoggerTemplate(false, LogLevel.DEBUG))
        val currentLogLevel = logger.level.name
        assertEquals("DEBUG", currentLogLevel)
    }

    @Test
    fun`Change log level to ERROR`() {
        val logger = LoggerDecorator.LoggerDefault(LoggerTemplate(false, LogLevel.ERROR))
        val currentLogLevel = logger.level.name
        assertEquals("ERROR", currentLogLevel)
    }

    @Test
    fun`Decorate message to uppercase content`() {
        val logger = LoggerDecorator.LoggerDefault(LoggerTemplate(true, LogLevel.ERROR))
        val isUpperCase = logger.toUpper
        assertTrue(isUpperCase)
    }
}