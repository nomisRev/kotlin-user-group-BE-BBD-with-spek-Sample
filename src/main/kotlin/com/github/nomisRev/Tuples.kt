package com.github.nomisRev

import java.io.Serializable

infix fun <A, B, C> Pair<A, B>.to(that: C) = Triple(this.first, this.second, that)

infix fun <A, B, C, D> Triple<A, B, C>.to(that: D) = Quad(this.first, this.second, this.third, that)

data class Quad<out A, out B, out C, out D>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D
) : Serializable {

    /**
     * Returns string representation of the [Triple] including its [first], [second], [third] and [fourth] values.
     */
    override fun toString(): String = "($first, $second, $third), $fourth"
}