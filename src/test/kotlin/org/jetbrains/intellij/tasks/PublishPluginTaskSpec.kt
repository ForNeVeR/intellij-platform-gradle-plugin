// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.jetbrains.intellij.tasks

import org.jetbrains.intellij.IntelliJPluginConstants
import org.jetbrains.intellij.IntelliJPluginSpecBase
import kotlin.test.BeforeTest
import kotlin.test.Test

@Suppress("ComplexRedundantLet")
class PublishPluginTaskSpec : IntelliJPluginSpecBase() {

    @BeforeTest
    override fun setUp() {
        super.setUp()

        pluginXml.xml("""
            <idea-plugin>
                <name>PluginName</name>
                <version>0.0.1</version>
                <description>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</description>
                <vendor>JetBrains</vendor>
            </idea-plugin>
        """)
    }

    @Test
    fun `skip publishing if token is missing`() {
        buildFile.groovy("""
            publishPlugin { }
            verifyPlugin {
                ignoreFailures = true
            }
        """)

        buildAndFail(IntelliJPluginConstants.PUBLISH_PLUGIN_TASK_NAME).let {
            assertContains("token property must be specified for plugin publishing", it.output)
        }
    }

    @Test
    fun `reuse configuration cache`() {
        buildFile.groovy("""
            publishPlugin { }
            verifyPlugin {
                ignoreFailures = true
            }
        """)

        buildAndFail(IntelliJPluginConstants.PUBLISH_PLUGIN_TASK_NAME, "--configuration-cache")
        buildAndFail(IntelliJPluginConstants.PUBLISH_PLUGIN_TASK_NAME, "--configuration-cache").let {
            assertContains("Reusing configuration cache.", it.output)
        }
    }
}
