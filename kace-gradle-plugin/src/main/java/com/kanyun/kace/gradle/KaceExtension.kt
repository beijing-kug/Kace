/*
 * Copyright (C) 2022 KanYun
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kanyun.kace.gradle

import com.android.build.gradle.api.BaseVariant

open class KaceExtension {
    var whiteList: List<String> = listOf()
    var blackList: List<String> = listOf()
    var customVariant: Map<String, List<String>> = emptyMap()
    internal val customVariantCallbacks: ArrayList<(BaseVariant) -> Map<String, List<String>>> = ArrayList()

    fun customVariant(block: (BaseVariant) -> Map<String, List<String>>) {
        customVariantCallbacks += block
    }
}
