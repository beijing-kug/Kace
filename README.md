English | **[简体中文](README_zh.md)**

# Kace
[![Hex.pm](https://img.shields.io/hexpm/l/plug.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![Language](https://img.shields.io/badge/Language-Kotlin-green)](https://kotlinlang.org/)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.kanyun.kace/kace-gradle-plugin/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.kanyun.kace/kace-gradle-plugin)

> The Kace means kotlin-android-compatible-extensions, a framework for assisting in the seamless migration from kotlin-android-extensions

The kotlin-android-extensions framework has been deprecated for a long time and will be officially removed in Kotlin 1.8

For new code, we can use ViewBinding instead, but the migration of a large amount of old code is not an easy job for developers

The Kace implements the seamless migration of kotlin-android-extensions by parsing layout to generate source code, helping developers to easily upgrade to Kotlin 1.8

## Quick Start
### 1. Add the plugin to classpath
```kotlin
// Option 1
// The classic way, add the following code to build.gradle.kts in the root directory
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("com.kanyun.kace:kace-gradle-plugin:$latest_version")
    }
}

// Option 2
// The new way, add the following code to settings.gradle.kts
pluginManagement {
    repositories {
        mavenCentral()
    }
    plugins {
        id("com.kanyun.kace") version "$latest_version" apply false
    }
}
````

### 2. Apply the plugin
Remove the `kotlin-android-extensions` plugin and add the following code

```kotlin
plugins {
    id("com.kanyun.kace")
    id("kotlin-parcelize") // optional, need to be added when the `@Parcelize` annotation is used
}
````

### 3. Configure the plugin (optional)
By default,The Kace will parse each layout in the module and generate code. Users can also customize the layout that needs to be parsed

```kotlin
kace {
    whiteList = listOf() // When the whiteList is not empty, only the layout in the whiteList will be parsed
    blackList = listOf("activity_main.xml") // When the blackList is not empty, the layout in the blackList will not be parsed
}
````

## Supported types
- android.app.Activity
- androidx.fragment.app.Fragment
- androidx.fragment.app.DialogFragment
- android.view.View (The View types currently do not support viewId caching )

The Kace currently supports the above four most commonly used types. Other types supported by kotlin-android-extensions such as android.app.Fragment, android.app.Dialog, kotlinx.android.extensions.LayoutContainer are deprecated or rarely used, currently not supported by the Kace

## Version compatible
| Kace         | Kotlin       | AGP   | Gradle |
|--------------|--------------|-------|--------|
| 1.7.0-1.0.4  | 1.7.0        | 4.2.0 | 6.7.1  |
| 1.8.0-1.0.4  | 1.8.0~1.8.10 | 4.2.0 | 6.8.3  |
| 1.8.20-1.1.0 | 1.8.20       | 4.2.0 | 6.8.3  |
| 1.9.0-1.2.0  | 1.9.0~1.9.20 | 4.2.2 | 6.8.3  |
| 1.9.20-1.2.0 | 1.9.20       | 4.2.2 | 6.8.3  |
| 2.0.0-1.2.0  | 2.0.0        | 7.1.3 | 7.2    |

Since the goal of the Kace is to help developers easily upgrade to Kotlin 1.8, the minimum supported version of Kotlin is relatively high

## Benchmark
### Compilation speed
By default, The Kace will parse each layout in the module and generate code, which may have a certain impact on the compilation speed

The Kace accelerates code generation by parallel tasks. After testing, the Kace plugin is applied into a module including 500 layouts, and the total time costed to parse layout and generate code during full compilation is about 1.5 seconds.

The Kace also supports incremental compilation. When modifying or adding a layout, the total time to parse layout and generate code is about 8 milliseconds

### Package size
The code generated by The Kace is all inline extension properties, and the unused code will be automatically removed after Code shrinking. After testing, the package size has almost no change before and after applying the Kace plugin.

## License
````
Copyright (C) 2022 KanYun

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
````
