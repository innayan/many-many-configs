package ManyConfigurations.buildTypes

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v10.triggers.ScheduleTrigger
import jetbrains.buildServer.configs.kotlin.v10.triggers.ScheduleTrigger.*
import jetbrains.buildServer.configs.kotlin.v10.triggers.schedule

object ManyConfigurations_One : BuildType({
    uuid = "dd7b58cd-6251-4b39-b5ab-aa4b65bfde74"
    extId = "ManyConfigurations_One"
    name = "one"

    steps {
        script {
            scriptContent = "echo test"
        }
    }

    triggers {
        schedule {
            enabled = false
            schedulingPolicy = daily {
            }
            triggerBuild = always()
            param("revisionRule", "lastFinished")
            param("dayOfWeek", "Sunday")
        }
    }
})
