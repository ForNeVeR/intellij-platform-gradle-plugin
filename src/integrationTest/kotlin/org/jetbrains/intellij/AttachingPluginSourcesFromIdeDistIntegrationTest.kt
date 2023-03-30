// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.jetbrains.intellij

import org.junit.jupiter.api.Test

class AttachingPluginSourcesFromIdeDistIntegrationTest : IntelliJPlatformIntegrationTestBase() {

    @Test
    fun test() {
        use("attaching-plugin-sources-from-ide-dist")

        build("buildPlugin").let {
            val cssPluginIvyFileName = "CSS-ideaIU-IU-212.5712.43-withSources-3.xml"

            pluginsCacheDirectory containsFile cssPluginIvyFileName

            val ivyFile = pluginsCacheDirectory.resolve(cssPluginIvyFileName)
            ivyFile containsText """<artifact name="lib/src/src_css-api" type="zip" ext="zip" conf="sources"/>"""
        }
    }
}
