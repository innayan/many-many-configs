package ManyConfigurations

import ManyConfigurations.buildTypes.*
import ManyConfigurations.vcsRoots.*
import ManyConfigurations.vcsRoots.ManyConfigurations_HttpsGithubComInnayanManyManyConfigs
import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.Project
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.VersionedSettings
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.VersionedSettings.*
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.versionedSettings
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.script
import java.io.File
import java.util.*

object Project : Project({
    uuid = "ceda96d4-342d-4a36-a259-38deb67d31ab"
    extId = "ManyConfigurations"
    parentId = "_Root"
    name = "Many Configurations"

    vcsRoot(ManyConfigurations_HttpsGithubComInnayanManyManyConfigs)

    buildType(ManyConfigurations_One)

    val randValue = Random();

    val alphabet="abcdefghijklmnopqrstuvwxyz";
    val words = File("dictionary.txt").readLines();

    fun getName(a: Int): String {
        return words.get(randValue.nextInt(340000)) + "_" + a;
    }

    fun addBuildTypes(project: Project, x: Int){
        for (a in 0..x) {
            val bt = BuildType();
            bt.name = getName(a) + "_" + project.name;
            bt.uuid = bt.name;
            bt.extId = bt.name;
            bt.vcs {
                root(ManyConfigurations.vcsRoots.ManyConfigurations_HttpsGithubComInnayanManyManyConfigs)
            }
            bt.steps {
                script {
                    scriptContent = "echo test"
                }
            }
            project.buildType(bt)
        }
    }
    fun createProjects(level: Int): List<Project> {
        val projects: MutableList<Project> = mutableListOf()
        for (a in 0..5) {
            val name = getName(a);
            val p = Project();
            p.name = name;
            p.uuid = name + "uuid";
            p.extId = name;
            p.parentId = "TeamcityDslTests";
            addBuildTypes(p, 200);
            projects.add(p);
            if (level > 0){
                p.subProjects(*createProjects(level-1).
                        toTypedArray<Project>())
            }
        }
        return projects;
    }


    subProjects(*createProjects(2).
            toTypedArray<Project>())

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
