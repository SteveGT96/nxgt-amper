import com.android.build.gradle.LibraryExtension

plugins {
	alias(libs.plugins.ksp)
	alias(libs.plugins.apollo)
}

dependencies {
	kspAndroid(libs.room.compiler)
	kspAndroid(libs.koin.ksp.compiler)
}

val sourceDir = "${projectDir}/build/generated/ksp/kotlin"
val apolloSourceDir = "${projectDir}/build/generated/source/apollo/service"

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

tasks.register<Copy>("copyGeneratedCode") {
	val destSrc = "$projectDir/src/generated"
	dependsOn("generateApolloSources")
	delete("$projectDir/src/generated")
	from(apolloSourceDir)
	into("$projectDir/src/generated")
}

tasks.getByName("build") {
	dependsOn("copyGeneratedCode")
}