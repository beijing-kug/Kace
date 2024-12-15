package com.kanyun.kace.gradle.compat

import java.io.File
import java.io.Serializable

/**
 * Copy this from Kotlin compiler to avoid depending on it explicitly.
 */
sealed class ChangedFiles : Serializable {
    class Known(val modified: List<File>, val removed: List<File>, val forDependencies: Boolean = false) : ChangedFiles()
    class Unknown : ChangedFiles()
    companion object {
        const val serialVersionUID: Long = 0
    }
}
