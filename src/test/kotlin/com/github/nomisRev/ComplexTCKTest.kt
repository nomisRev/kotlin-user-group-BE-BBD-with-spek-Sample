//package com.github.nomisRev
//
//import com.nhaarman.mockito_kotlin.doReturn
//import com.nhaarman.mockito_kotlin.mock
//import org.assertj.core.api.Assertions.assertThat
//import org.jetbrains.spek.api.Spek
//import org.jetbrains.spek.api.dsl.describe
//
//interface ComplexClass {
//    fun doSomethingComplex(): Boolean
//}
//
//class ComplexImpl : ComplexClass {
//    override fun doSomethingComplex() = true
//}
//
//class SuccesDetermination : ComplexClass {
//    override fun doSomethingComplex(): Boolean {
//        TODO() //Impl will be mock.
//    }
//}
//
//class ComplexImplWithDependency(succesDetermination: SuccesDetermination) :
//        ComplexClass by succesDetermination
//
//open class ComplexSpek(private val factory: () -> ComplexClass = { ComplexImpl() }) : Spek({
//
//    val subject = factory.invoke()
//
//    describe("A complex class should succeed") {
//        assertThat(subject.doSomethingComplex()).isTrue()
//    }
//
//})
//
//object ComplexImplComplexSpek : ComplexSpek({ ComplexImpl() })
//
//object ComplexImplWithDependencyComplexSpek : ComplexSpek({
//    val succesDetermination = mock<SuccesDetermination> {
//        on { doSomethingComplex() } doReturn true
//    }
//
//    ComplexImplWithDependency(succesDetermination)
//})