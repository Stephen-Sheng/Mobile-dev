package com.example.mobile_dev.database

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class MemberWithProjects(
    @Embedded val member: Member,
    @Relation(
        parentColumn = "email",
        entityColumn = "projectId",
        associateBy = Junction(MemberProjectCrossRef::class)
    )
    val projects: List<Project>
)