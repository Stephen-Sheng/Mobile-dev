package com.example.mobile_dev.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ManagerDao {
    @Query("SELECT * FROM Manager")
    fun getManagers(): Flow<List<Manager>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(manager: Manager)

    @Query("DELETE FROM Manager")
    suspend fun deleteAll()

    @Transaction
    @Query("SELECT * FROM Manager")
    fun getManageWithProjects(): List<ManagerWithProjects>
}