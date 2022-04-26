package com.example.mobile_dev.database

import androidx.room.Embedded
import androidx.room.Relation

data class ProjectWithTasks(
    @Embedded val project: Project,
    @Relation(
        parentColumn = "projectId",
        entityColumn = "projectId"
    )
    val tasks: List<Task>
)