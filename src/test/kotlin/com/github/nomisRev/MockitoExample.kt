package com.github.nomisRev

import com.nhaarman.mockito_kotlin.*
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class MockitoExample : Spek({

    describe("mockito-kotlin") {

        val mock = mock<MyClass>()

        val mock2 = mock<MyClass> {
            on { getStringValue() } doReturn "stringValue"
            on { someOtherStringValue } doReturn "stringOtherValue"
        }

        beforeEachTest { clearInvocations(mock, mock2) }

        it("calling doSomething") {
            mock.doSomething()
            verify(mock).doSomething()
        }

        it("assigning a value") {
            mock2.someOtherStringValue = "stringOtherValue2"

            verify(mock2).someOtherStringValue = "stringOtherValue2"
        }


        it("capturing a single value") {
            mock.setSomething(listOf("1", "2"))

            verify(mock).setSomething(argThat { size == 2 })
        }

        it("capturing a single value with multiple assertions") {
            mock.setSomething(listOf("1", "2"))

            verify(mock).setSomething(check {
                assertThat(it.size).isEqualTo(2)
                assertThat(it[0]).isEqualTo("1")
            })
        }

        it("capturing multiple value with multiple assertions") {
            mock.setSomething(listOf("1", "2"))
            mock.setSomething(listOf("3", "4"))

            argumentCaptor<List<String>>().apply {
                verify(mock, times(2)).setSomething(capture())

                assertThat(allValues.size).isEqualTo(2)
                assertThat(firstValue).isEqualTo(listOf("1", "2"))
            }
        }

        it("testing order of execution") {
            mock.getStringValue()
            mock2.getStringValue()

            inOrder(mock, mock2) {
                verify(mock).getStringValue()
                verify(mock2).getStringValue()
            }
        }

        MockitoKotlin.registerInstanceCreator { com.github.nomisRev.MyOtherClass(2) }

        val mock3 = mock<MyOtherClass>()

        it("verify that mocked correctly") {
            assertThatThrownBy({ assertThat(mock3.number).isEqualTo(2) })
                        .isInstanceOf(AssertionError::class.java)
        }
    }
})


class MyOtherClass(val number: Int) {

    init {
        if(number <= 1) error("$number should be greater than 1")
    }
}

