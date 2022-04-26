package com.example.mobile_dev.database

import androidx.room.Embedded
import androidx.room.Relation


data class ManagerWithProjects(
    @Embedded val manager: Manager,
    @Relation(
        parentColumn = "email",
        entityColumn = "managerEmail"
    )
    val projects: List<Project>
)