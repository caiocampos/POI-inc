plugins {
	id("org.springframework.boot") version "4.1.0"
	id("io.spring.dependency-management") version "1.1.7"
	kotlin("jvm") version "2.4.10"
	kotlin("plugin.spring") version "2.4.10"
}

group = "br.campos"
version = "0.0.1-SNAPSHOT"
description = "Cadastro de pontos de interesse"

kotlin {
	jvmToolchain(25)
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// Web (MVC) e MongoDB - nomes de starter atualizados para o Spring Boot 4
	implementation("org.springframework.boot:spring-boot-starter-webmvc")
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")

	// Suporte Kotlin
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("tools.jackson.module:jackson-module-kotlin")

	// Testes
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

springBoot {
    mainClass.set("br.campos.poi.POIIncApplication")
}