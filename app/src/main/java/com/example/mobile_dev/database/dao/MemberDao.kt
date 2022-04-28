package com.example.mobile_dev.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mobile_dev.database.model.Member



@Dao
interface MemberDao {
    @Query("SELECT * FROM Member")
    fun getMembers(): LiveData<List<Member>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(member: Member)

    @Query("DELETE FROM Member")
    suspend fun deleteAll()
}