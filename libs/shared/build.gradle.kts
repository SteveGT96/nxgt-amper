plugins {
	alias(libs.plugins.ksp)
	alias(libs.plugins.apollo)
}

ksp {
	arg("room.generateKotlin", "true")
}

dependencies {
	kspAndroid(libs.room.compiler)
}

apollo {
	service("service") {
		srcDir(file("src/graphql/"))
		schemaFile.set(file("src/graphql/schema.graphqls"))
		sourceFolder.set(".")
		packageName.set("api")
		generateOptionalOperationVariables.set(false)
		generateFragmentImplementations.set(true)
		generateDataBuilders.set(true)
		//mapScalarToUpload("Upload")
		mapScalarToKotlinLong("Long")
		mapScalar("DateTime", "kotlinx.datetime.Instant", "helpers.instantAdapter")
	}
}

val kspSourceDir = "${projectDir}/build/generated/ksp/android/androidRelease/kotlin"
val apolloSourceDir = "${projectDir}/build/generated/source/apollo/service"

tasks.register<Copy>("copyGeneratedCode") {
	dependsOn("generateApolloSources", "kspDebugKotlinAndroid", "kspReleaseKotlinAndroid")
	val destSrc = "$projectDir/src/generated"
	//delete(destSrc)
	listOf(kspSourceDir, apolloSourceDir).forEach {
		from(it)
		into(destSrc)
	}
}

tasks.getByName("assemble") {
	dependsOn("copyGeneratedCode")
}