package com.example.mobile_dev.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow


@Dao
interface ProjectDao {
    @Query("SELECT * FROM Project")
    fun getProjects(): Flow<List<Project>>

    @Transaction
    @Query("SELECT * FROM Project")
    fun getProjectWithTasks(): List<ManagerWithProjects>

    @Transaction
    @Query("SELECT * FROM Project")
    fun getProjectsWithMembers(): List<ProjectWithMembers>
}