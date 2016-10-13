package ManyConfigurations

import ManyConfigurations.buildTypes.*
import ManyConfigurations.vcsRoots.*
import ManyConfigurations.vcsRoots.ManyConfigurations_HttpsGithubComInnayanManyManyConfigs
import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.Project
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.VersionedSettings
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.VersionedSettings.*
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.versionedSettings

object Project : Project({
    uuid = "ceda96d4-342d-4a36-a259-38deb67d31ab"
    extId = "ManyConfigurations"
    parentId = "_Root"
    name = "Many Configurations"

    vcsRoot(ManyConfigurations_HttpsGithubComInnayanManyManyConfigs)

    buildType(ManyConfigurations_One)

    features {
        versionedSettings {
            id = "PROJECT_EXT_1"
            mode = VersionedSettings.Mode.ENABLED
            buildSettingsMode = VersionedSettings.BuildSettingsMode.USE_CURRENT_SETTINGS
            rootExtId = ManyConfigurations_HttpsGithubComInnayanManyManyConfigs.extId
            showChanges = false
            settingsFormat = VersionedSettings.Format.KOTLIN
        }
    }
})
