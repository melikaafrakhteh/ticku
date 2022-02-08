package com.afrakhteh.ticku.model.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.afrakhteh.ticku.constants.Numerals
import com.afrakhteh.ticku.di.scopes.DBScope
import com.afrakhteh.ticku.model.entities.Tasks

@Database(
    entities = [Tasks::class],
    version = Numerals.DATABASE_VERSION,
    exportSchema = false
)
@DBScope
abstract class TaskDataBase : RoomDatabase(){
    abstract fun dao(): TaskDao
}