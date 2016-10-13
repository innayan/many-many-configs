package ManyConfigurations.vcsRoots

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.vcs.GitVcsRoot

object ManyConfigurations_HttpsGithubComInnayanManyManyConfigs : GitVcsRoot({
    uuid = "b8fde8ef-508b-412a-8979-4d3a949e0795"
    extId = "ManyConfigurations_HttpsGithubComInnayanManyManyConfigs"
    name = "https://github.com/innayan/many-many-configs"
    url = "https://github.com/innayan/many-many-configs.git"
    authMethod = password {
        userName = "Inna_yan@mail.ru"
        password = "zxxdbb7a62f033d83a8775d03cbe80d301b"
    }
})
