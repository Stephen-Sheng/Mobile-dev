package com.example.mobile_dev.database

import androidx.room.Entity


@Entity(primaryKeys = ["email", "projectId"])
data class MemberProjectCrossRef(
    val email: String,
    val projectId: String
)