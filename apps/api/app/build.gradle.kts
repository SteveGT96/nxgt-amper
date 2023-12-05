plugins {
	alias(libs.plugins.spring.boot)
	alias(libs.plugins.kotlin.plugin.spring)
	alias(libs.plugins.spring.dependency.management)
	alias(libs.plugins.graalvm.native)
}

group = "com.strange"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}