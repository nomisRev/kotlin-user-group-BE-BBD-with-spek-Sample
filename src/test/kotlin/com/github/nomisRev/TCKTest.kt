package com.github.nomisRev

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

private val items = arrayOf(1, 2, 3, 4)

abstract class CollectionSpek(private val collection: Collection<Int> = listOf()) : Spek({

    describe("requesting the size") {
        it("$collection should have size ${items.size}"){
            assertThat(collection.size).isEqualTo(items.size)
        }
    }

})

class SetCollectionSpek : CollectionSpek(setOf(*items))

class ListCollectionSpek : CollectionSpek(items.asList())