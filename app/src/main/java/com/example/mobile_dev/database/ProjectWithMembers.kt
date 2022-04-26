package com.example.mobile_dev.database

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class ProjectWithMembers(
    @Embedded val project: Project,
    @Relation(
        parentColumn = "projectId",
        entityColumn = "email",
        associateBy = Junction(MemberProjectCrossRef::class)
    )
    val members: List<Member>
)