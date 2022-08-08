package com.example.room.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.room.model.entity.History
import kotlinx.coroutines.selects.select

@Dao
interface ResultDao {

@Insert(onConflict = OnConflictStrategy.IGNORE)
fun addResultToHistory(history: History)

@Delete
fun deleteHistoryResult(history: History)

/*@Query("DELETE FROM history_data")
suspend fun deleteAllHistory()*/

@Query("SELECT * FROM history_data ORDER BY id ASC")

fun readAllData(): LiveData<List<History>>
}