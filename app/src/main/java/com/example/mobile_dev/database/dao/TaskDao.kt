package com.example.mobile_dev.database.dao


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.mobile_dev.database.model.Task


@Dao
interface TaskDao {
    @Query("SELECT * FROM Task")
    fun getTasks(): LiveData<List<Task>>
}