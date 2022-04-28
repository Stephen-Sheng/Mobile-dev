package com.example.mobile_dev.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.mobile_dev.database.model.Project


@Dao
interface ProjectDao {
    @Query("SELECT * FROM Project")
    fun getProjects(): LiveData<List<Project>>
}