import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

repositories {
	mavenLocal()
	maven(url = "https://maven.aliyun.com/repository/public/")
	mavenCentral()
}
plugins {
	id("org.springframework.boot") version "2.4.1"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.4.21"
	kotlin("plugin.spring") version "1.4.21"
	kotlin("plugin.jpa") version "1.4.21"
	kotlin("kapt") version "1.4.10"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

val queryDslVersion = "4.4.0"
repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	runtimeOnly("mysql:mysql-connector-java")

	implementation("com.querydsl:querydsl-jpa:$queryDslVersion")
	implementation("com.querydsl:querydsl-sql:$queryDslVersion")
	compileOnly("com.querydsl:querydsl-apt:$queryDslVersion:jpa")
	kapt("com.querydsl:querydsl-apt:$queryDslVersion:jpa")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
