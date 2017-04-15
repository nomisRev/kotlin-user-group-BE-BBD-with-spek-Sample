package com.github.nomisRev

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it

object FixtureSpec : Spek({
    describe("spek fixtures"){
        beforeEachTest { println("hello from outer before each test \n") }
        beforeGroup { println("hello from outer before each group \n") }

        context("first nested group") {
            beforeEachTest { println("hello from before each context test \n") }
            it("first test") { println("hello from first context test \n") }
            it("second test") { println("hello from second context test \n") }
            afterEachTest { println("hello from after each context test \n") }
        }

        given("some other nested group") {
            beforeEachTest { println("hello from before each given test \n") }
            it("should be 2 as well") { }
            afterEachTest { println("hello from after each given test \n") }
        }

        afterEachTest { println("hello from outer after each test \n") }
        afterGroup { println("hello from outer after each group \n") }
    }
})