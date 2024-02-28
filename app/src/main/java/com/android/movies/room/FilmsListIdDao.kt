package com.android.movies.room

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase

@Dao
interface FilmsListIdDao {
    @Query("SELECT * FROM film_state_entity")
    fun getAll(): List<FilmsStateEntity>

    @Insert(entity = FilmsStateEntity::class)
    fun insertNewId(filmsStateEntity: FilmsStateEntity)
}

@Database(
    version = 1,
    entities = [FilmsStateEntity::class]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmListIdDao(): FilmsListIdDao
}