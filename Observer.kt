package com.husar.exercise

import java.lang.Thread.sleep
import kotlin.concurrent.thread
import kotlin.properties.Delegates

interface CurrencyRateListener {
    fun onValueChanged(newValue: Double)
}

class Client(var id: Int): CurrencyRateListener {
    override fun onValueChanged(newValue: Double) =
        println("Client#$id: $newValue")
}

class ExchangeOffice(clients: List<CurrencyRateListener>) {
    var rate: Double by Delegates.observable(
        initialValue = 0.0,
        onChange = {
                prop, old, new ->
            clients.forEach{ client ->
                client.onValueChanged(new)
            }
        }
    )
    fun produceRate() {
        thread {
            rate = randomNumber()
            sleep(1000)
        }
    }
    val randomNumber: () -> Double = {0.0 + Math.random() * (1.0 - 0.0)}
}

fun main(args : Array<String>) {

    val clients = mutableListOf<Client>(Client(1), Client(2), Client(3))
    val exchangeOffice = ExchangeOffice(clients)
    exchangeOffice.produceRate()
}