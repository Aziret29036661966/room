package com.example.room.data


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.room.dataBase
import com.example.room.model.entity.History

@Database(entities = [History::class], version = 1, exportSchema = false)
abstract class CalculateDataBase : RoomDatabase(){

    abstract fun dao():ResultDao

    companion object{
        @Volatile
        private var INSTANCE : CalculateDataBase? = null
        fun getDataBase(context: Context):CalculateDataBase{
            val tempInst = INSTANCE
            if (tempInst != null) {
                return tempInst
            }
            synchronized(this){
                val inst = Room.databaseBuilder(context.applicationContext, CalculateDataBase::class.java, dataBase).build()
                INSTANCE = inst
                return inst
            }
        }
    }
}