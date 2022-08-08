package com.example.room.data

import androidx.lifecycle.LiveData
import com.example.room.model.entity.History

class Repository(private val resultDao: ResultDao) {

    val readAllData : LiveData<List<History>> = resultDao.readAllData()

    fun addResult(history: History){
        resultDao.addResultToHistory(history)
    }

    fun deleteResult(history: History){
        resultDao.deleteHistoryResult(history)
    }

  /*  suspend fun deleteAllHistory(){
        resultDao.deleteAllHistory()
    }*/
}