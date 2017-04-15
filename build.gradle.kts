import org.gradle.api.plugins.ExtensionAware
import org.junit.platform.gradle.plugin.EnginesExtension
import org.junit.platform.gradle.plugin.FiltersExtension
import org.junit.platform.gradle.plugin.JUnitPlatformExtension

buildscript {

    repositories {
        jcenter()
        mavenCentral()
        gradleScriptKotlin()
        maven { setUrl("http://dl.bintray.com/jetbrains/spek") }
    }

    dependencies {
        classpath(kotlinModule("gradle-plugin"))
        classpath("org.junit.platform:junit-platform-gradle-plugin:1.0.0-M3")
    }
}

plugins {
    application
}

apply {
    plugin("kotlin")
    plugin("org.junit.platform.gradle.plugin")
}

configure<JUnitPlatformExtension> {
    platformVersion = "1.0.0-M3"

    filters {
        engines {
            include("spek")
        }
    }
}


repositories {
    gradleScriptKotlin()
}

dependencies {
    compile(kotlinModule("stdlib-jre8", "1.1.0"))

    testCompile(kotlinModule("reflect", "1.1.0"))
    testCompile("org.jetbrains.spek:spek-api:1.1.0")
    testCompile("org.jetbrains.spek:spek-subject-extension:1.1.0")
    testCompile("com.nhaarman:mockito-kotlin:1.4.0")
    testCompile("com.github.nomisrev.rxassertj:rx2assertj:0.9.0")

    testRuntime("org.jetbrains.spek:spek-junit-platform-engine:1.1.0")
}

fun JUnitPlatformExtension.filters(setup: FiltersExtension.() -> Unit) {
    when (this) {
        is ExtensionAware -> extensions.getByType(FiltersExtension::class.java).setup()
        else -> throw Exception("${this::class} must be an instance of ExtensionAware")
    }
}

fun FiltersExtension.engines(setup: EnginesExtension.() -> Unit) {
    when (this) {
        is ExtensionAware -> extensions.getByType(EnginesExtension::class.java).setup()
        else -> throw Exception("${this::class} must be an instance of ExtensionAware")
    }
}