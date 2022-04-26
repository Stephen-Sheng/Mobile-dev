package com.example.mobile_dev.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface MemberDao {
    @Query("SELECT * FROM Member")
    fun getMembers(): Flow<List<Member>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(member: Member)

    @Query("DELETE FROM Member")
    suspend fun deleteAll()

    @Transaction
    @Query("SELECT * FROM Member")
    fun getMemberWithTasks(): List<MemberWithTasks>

    @Transaction
    @Query("SELECT * FROM Member")
    fun getMembersWithProjects(): List<MemberWithProjects>
}