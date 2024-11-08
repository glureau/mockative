package io.mockative

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

abstract class MockativeProcessRuntimeTask : DefaultTask() {
    init {
        outputs.upToDateWhen { false }
    }

    @TaskAction
    fun run() {
        project.info("io.mockative.enabled=${project.findProperty("io.mockative.enabled")}")
        project.info("gradle.startParameter.taskNames=${project.gradle.startParameter.taskNames.joinToString()}")
        project.info("gradle.taskGraph.allTasks=${project.gradle.taskGraph.allTasks.toDescription()}")

        project.info("verificationTasks: ${project.verificationTasks.toDescription()}")
        project.info("testTasks: ${project.testTasks.toDescription()}")
        project.info("deviceTestTasks: ${project.deviceTestTasks.toDescription()}")
        project.info("mockativeDir: ${project.mockativeDir}")
        project.info("isMockativeEnabled: ${project.isMockativeEnabled}")
        project.info("isMockativeDisabled: ${project.isMockativeDisabled}")
        project.info("isRunningConnectedAndroidTests: ${project.isRunningConnectedAndroidTests}")
        project.info("isRunningAndroidUnitTests: ${project.isRunningAndroidUnitTests}")
    }
}
