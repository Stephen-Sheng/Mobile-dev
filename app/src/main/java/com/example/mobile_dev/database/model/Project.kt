package com.example.mobile_dev.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Project(
    @PrimaryKey val projectId: String,

    val projectName: String,
    val deadline: String,
    val status: String,
    val managerEmail: String
)