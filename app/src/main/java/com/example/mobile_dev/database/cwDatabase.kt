package com.example.mobile_dev.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mobile_dev.database.dao.ManagerDao
import com.example.mobile_dev.database.dao.MemberDao
import com.example.mobile_dev.database.dao.ProjectDao
import com.example.mobile_dev.database.dao.TaskDao
import com.example.mobile_dev.database.model.Manager
import com.example.mobile_dev.database.model.Member
import com.example.mobile_dev.database.model.Project
import com.example.mobile_dev.database.model.Task


@Database(entities = [Manager::class, Member::class, Task::class, Project::class], version = 1)
abstract class CwDatabase : RoomDatabase() {
    companion object{
        private  lateinit var cwDatabase: CwDatabase

        fun getDatabase(applicationContext: Context) : CwDatabase{
            if(!(::cwDatabase.isInitialized)){
                cwDatabase =
                    Room.databaseBuilder(applicationContext,
                        cwDatabase::class.java,"cw-db")
                        .build()
            }
            return cwDatabase
        }
    }

    abstract fun memberDao() : MemberDao

    abstract fun managerDao() : ManagerDao

    abstract fun taskDao() : TaskDao

    abstract fun projectDao() : ProjectDao
}