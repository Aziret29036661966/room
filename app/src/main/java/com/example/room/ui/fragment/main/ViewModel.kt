package com.example.room.ui.fragment.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.room.data.CalculateDataBase
import com.example.room.data.Repository
import com.example.room.model.entity.History
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(application: Application): AndroidViewModel(application) {

    private val readAllData: LiveData<List<History>>
    private var repository:Repository

    init {
val resultDao = CalculateDataBase.getDataBase(application).dao()
        repository = Repository(resultDao)
        readAllData = repository.readAllData
    }
    fun addResultToNextFragment(history: History){
        viewModelScope.launch ( Dispatchers.IO){
            repository.addResult(history)
        }

    }
}