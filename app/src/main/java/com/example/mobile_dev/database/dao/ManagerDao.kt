package com.example.mobile_dev.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mobile_dev.database.model.Manager

@Dao
interface ManagerDao {
    @Query("SELECT * FROM Manager")
    fun getManagers(): LiveData<List<Manager>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(manager: Manager)

    @Query("DELETE FROM Manager")
    suspend fun deleteAll()

}