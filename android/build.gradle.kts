allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    id("com.android.application") version "8.2.1" apply false
    id("dev.flutter.flutter-gradle-plugin") version "1.0.0" apply false
    id("com.google.gms.google-services") version "4.4.1" apply false
}

rootProject.buildDir = "../build"
subprojects {
    project.buildDir = "${rootProject.buildDir}/${project.name}"
}
subprojects {
    project.evaluationDependsOn(":app")
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
