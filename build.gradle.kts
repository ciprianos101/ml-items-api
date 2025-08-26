plugins {
    id("org.springframework.boot") version "3.2.6"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.spring") version "1.9.23"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

kotlin {
    jvmToolchain(17) //Para corrigir erro de versão do Java/Kotlin
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.springframework.boot:spring-boot-starter-cache")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("com.github.ben-manes.caffeine:caffeine:3.1.8")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.7.3")
    implementation("io.projectreactor:reactor-core:3.6.5")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    //cucumber
    testImplementation("io.cucumber:cucumber-java:7.11.2")
    testImplementation("io.cucumber:cucumber-junit:7.11.2")
    testImplementation("io.cucumber:cucumber-spring:7.11.2")
    testImplementation("org.junit.vintage:junit-vintage-engine:5.9.3")
}
tasks.test {
    useJUnitPlatform()
}

configurations {
    create("cucumberRuntime") {
        extendsFrom(configurations["testImplementation"])
    }
}

tasks.register<JavaExec>("cucumber") {
    dependsOn("assemble", "testClasses")
    mainClass.set("io.cucumber.core.cli.Main")
    classpath = sourceSets["main"].runtimeClasspath +
            sourceSets["test"].runtimeClasspath +
            configurations["cucumberRuntime"]
    args = listOf(
        "--plugin", "pretty",
        "--glue", "com.lucasoliveira.itemdetail.cucumber",
        "src/test/resources/features",
        "--plugin", "json:${buildDir}/results/cucumber/cucumber.json"
    )
}