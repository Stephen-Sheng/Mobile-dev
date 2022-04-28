package com.example.mobile_dev.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Task(
    @PrimaryKey val taskId: String,

    val taskName: String,
    val details: String,
    val deadline: String,
    val status: String,
    val projectId: String,
    val memberEmail: String
)