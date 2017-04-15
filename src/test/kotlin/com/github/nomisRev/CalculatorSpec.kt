package com.github.nomisRev

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.subject.SubjectSpek

//Example from https://github.com/JetBrains/spek
object CalculatorSpec : SubjectSpek<Calculator>({
    subject { Calculator() }

    describe("addition") {
        it("should return the result of adding the first number to the second number") {
            assertThat(subject.add(2, 4)).isEqualTo(6)
        }
    }

    describe("subtract") {
        it("should return the result of subtracting the second number from the first number") {
            assertThat(subject.subtract(2, 4)).isEqualTo(-2)
        }
    }

    describe("division") {
        it("should return the result of dividing the first number by the second number") {
            assertThat(subject.divide(4, 2)).isEqualTo(2)
        }

        context("division by zero") {
            it("should throw an exception") {
                assertThatThrownBy({ subject.divide(2, 0) })
                        .isInstanceOf(IllegalArgumentException::class.java)
            }
        }
    }
})