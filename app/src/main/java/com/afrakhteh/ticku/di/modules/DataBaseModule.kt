package com.afrakhteh.ticku.di.modules

import android.content.Context
import androidx.room.Room
import com.afrakhteh.ticku.constants.Strings
import com.afrakhteh.ticku.di.scopes.DBScope
import com.afrakhteh.ticku.model.data.database.TaskDao
import com.afrakhteh.ticku.model.data.database.TaskDataBase
import dagger.Module
import dagger.Provides

@Module
class DataBaseModule {

    @Provides
    @DBScope
    fun providesDataBase(ctx: Context): TaskDataBase {
        return Room.databaseBuilder(
            ctx,
            TaskDataBase::class.java,
            Strings.DATABASE_NAME
        ).build()
    }

    @Provides
    @DBScope
    fun providesDao(db: TaskDataBase): TaskDao {
        return db.dao()
    }
}