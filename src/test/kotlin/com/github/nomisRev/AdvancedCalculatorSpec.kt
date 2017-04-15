package com.github.nomisRev

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.subject.SubjectSpek
import org.jetbrains.spek.subject.itBehavesLike

//Example from https://github.com/JetBrains/spek
object AdvancedCalculatorSpec : SubjectSpek<AdvancedCalculator>({
    subject { AdvancedCalculator() }
    itBehavesLike(CalculatorSpec)

    describe("pow") {
        it("should return the power of base raise com.github.nomisRev.com.github.nomisRev.to exponent") {
            assertThat(subject.pow(2, 2)).isEqualTo(4)
        }
    }
})