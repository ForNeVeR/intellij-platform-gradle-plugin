### Tasks

Plugin introduces the following tasks

| **Task** | **Description** |
| -------- | --------------- |
| `buildPlugin`            | Assembles plugin and prepares zip archive for deployment. |
| `patchPluginXml`         | Collects all plugin.xml files in sources and fill since/until build and version attributes. |
| `prepareSandbox`         | Creates proper structure of plugin, copies patched plugin xml files and fills sandbox directory with all of it. |
| `prepareTestingSandbox`  | Prepares sandbox that will be used while running tests. |
| `buildSearchableOptions` | Builds an index of UI components (a.k.a. searchable options) for the plugin by running a headless IDE instance.<br>Note, that this is a `runIde` task with predefined arguments and all properties of `runIde` task are also applied to `buildSearchableOptions` tasks. |
| `jarSearchableOptions`   | Creates a jar file with searchable options to be distributed with the plugin. |
| `runIde`                 | Executes an IntelliJ IDEA instance with the plugin you are developing. |
| `publishPlugin`          | Uploads plugin distribution archive to https://plugins.jetbrains.com. |
| `verifyPlugin`           | Validates plugin.xml and plugin's structure. |
