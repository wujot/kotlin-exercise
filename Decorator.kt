package com.husar.exercise

enum class LogLevel {
    DEBUG, NORMAL, ERROR
}

interface Logger {
    var toUpper: Boolean
    var level: LogLevel
    fun log(message: String)
}

class LoggerTemplate(override var toUpper: Boolean = false, override var level: LogLevel = LogLevel.NORMAL): Logger {
    override fun log(message: String) {
        if (toUpper) {
            println("$level: ${message.toUpperCase()}")
        } else
            println("$level: $message")
    }
}

sealed class LoggerDecorator() {
    class LoggerHeader(val logger: Logger): Logger by logger {
        override fun log(message: String) {
            println("----- Begin log -----")
            logger.log(message)
        }
    }

    class LoggerFooter(val logger: Logger): Logger by logger {
        override fun log(message: String) {
            logger.log(message)
            println("----- End log -----")
        }
    }

    class LoggerComplete(val logger: Logger): Logger by logger {
        override fun log(message: String) {
            println("----- Begin log -----")
            logger.log(message)
            println("----- End log -----")
        }
    }

    class LoggerDefault(val logger: Logger): Logger by logger {
        override fun log(message: String) {
            logger.log(message)
        }
    }
}

fun main(args : Array<String>) {

    val loggerFooter = LoggerDecorator.LoggerHeader(LoggerTemplate(true, LogLevel.ERROR))
    loggerFooter.log("Wiadomosc testowa")
    println()
    val logerHeader = LoggerDecorator.LoggerFooter(LoggerTemplate(false, LogLevel.DEBUG))
    logerHeader.log("Wiadomosc testowa")
    println()
    val loggerComplete = LoggerDecorator.LoggerComplete(LoggerTemplate())
    loggerComplete.log("Wiadomosc testowa")
    println()
    val loggerDefault = LoggerDecorator.LoggerDefault(LoggerTemplate())
    loggerDefault.log("Wiadomosc testowa")
    println()
}