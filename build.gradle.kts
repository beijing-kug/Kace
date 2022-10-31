// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "4.2.0" apply false
    id("com.android.library") version "4.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.7.0" apply false
    id("com.vanniktech.maven.publish") version "0.18.0" apply false
    id("com.github.gmazzo.buildconfig") version "2.1.0" apply false
}

allprojects {
    repositories {
        maven { setUrl("https://mirrors.tencent.com/nexus/repository/maven-public/") }
        maven { setUrl("https://oss.sonatype.org/content/repositories/snapshots/") }
    }
}
