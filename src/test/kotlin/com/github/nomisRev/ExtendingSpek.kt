package com.github.nomisRev

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.TestContainer
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

infix fun <A, B, C> Pair<A, B>.to(that: C) =
        Triple(this.first, this.second, that)

fun <T> TestContainer.tableOf(vararg elements: T, f: (TestContainer.(elements: T) -> Unit)) =
        elements.toList().forEach { f.invoke(this, it) }

class TableSpekTest : Spek({
    describe("zipping lists") {
        tableOf(
                listOf(1, 2, 3) to listOf(4, 5, 6) to listOf(5, 7, 9),
                listOf(1, 2, 3) to listOf(1, 2, 3) to listOf(2, 4, 6),
                listOf(4, 5, 6) to listOf(1, 2, 3) to listOf(5, 7, 9)
        ) { (l1, l2, result) ->

            it("zipping $l1 and $l2 should result in $result") {
                assertThat(l1.zip(l2, { i1, i2 -> i1 + i2 })).isEqualTo(result)
            }
        }
    }
})