package com.example.mobile_dev.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Manager::class, Member::class], version = 1)
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
}