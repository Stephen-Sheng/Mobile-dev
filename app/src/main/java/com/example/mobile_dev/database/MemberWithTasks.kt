package com.example.mobile_dev.database

import androidx.room.Embedded
import androidx.room.Relation

data class MemberWithTasks(
    @Embedded val member: Member,
    @Relation(
        parentColumn = "email",
        entityColumn = "memberEmail"
    )
    val tasks: List<Task>
)