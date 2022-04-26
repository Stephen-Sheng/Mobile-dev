package com.example.mobile_dev.database

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class ManagerRepository(private val managerDao: ManagerDao) {
    val allManagers: Flow<List<Manager>> = managerDao.getManagers()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(manager: Manager){
        managerDao.insert(manager)
    }
}