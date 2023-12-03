plugins {
	alias(libs.plugins.ksp)
}

dependencies {
	kspAndroid(libs.room.compiler)
	kspAndroid(libs.koin.ksp.compiler)
}