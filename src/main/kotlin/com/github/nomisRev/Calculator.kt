package com.github.nomisRev

//Example from https://github.com/JetBrains/spek
open class Calculator {
    fun add(x: Int, y: Int) = x + y

    fun subtract(x: Int, y: Int) = x - y

    fun divide(x: Int, y: Int) =
            if (y == 0) throw IllegalArgumentException()
            else x / y
}

class AdvancedCalculator : Calculator() {
    fun pow(base: Int, exponent: Int) =
            Math.pow(base.toDouble(), exponent.toDouble()).toInt()
}