package com.example.room.ui.fragment.second

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.room.data.CalculateDataBase
import com.example.room.data.Repository
import com.example.room.model.entity.History
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelForSecond (application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<History>>
    private var repository: Repository

    init {
        val resultDao = CalculateDataBase.getDataBase(application).dao()
        repository = Repository(resultDao)
        readAllData = repository.readAllData
    }

    fun deleteResult(history: History){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteResult(history)
        }
    }
   /* fun deleteALlHistory(){
        viewModelScope.launch (Dispatchers.IO ){
            repository.deleteAllHistory()
        }
    }*/
}