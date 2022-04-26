package com.example.mobile_dev.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Member(
    @PrimaryKey val email: String,

    val fullName: String,
    val password: String
)