package com.github.nomisRev

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object FibonacciTest : Spek({
    describe("a com.github.nomisRev.fibonacci calculator") {

        //Simple test
        it("Seventh com.github.nomisRev.fibonacci number is equal com.github.nomisRev.com.github.nomisRev.to 13") {
            assertThat(fibonacci(7)).isEqualTo(13)
        }

        //generation of data
        //Def com.github.nomisRev.fibonacci -> sum of previous 2 com.github.nomisRev.items = current
        (2..100).forEach { n ->
            val prev = fibonacci(n - 1)
            val beforePrev = fibonacci(n - 2)
            val cur = fibonacci(n)

            it("$cur should be the sum of the two previous com.github.nomisRev.fibonacci numbers: $prev, $beforePrev") {
                assertThat(prev + beforePrev).isEqualTo(cur)
            }
        }

//        Table of data
        tableOf(
                0 to 0,
                1 to 1,
                2 to 1,
                3 to 2,
                4 to 3,
                5 to 5,
                6 to 8,
                7 to 13
        ) { (n, result) ->
            it("should be $n for n = $result") {
                assertThat(fibonacci(n)).isEqualTo(result)
            }
        }
    }
})