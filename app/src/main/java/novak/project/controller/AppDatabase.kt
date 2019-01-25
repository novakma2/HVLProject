package novak.project.controller

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import novak.project.model.Person

/**
 * class for description of database
 */
@Database(entities = arrayOf(Person::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun personsDao(): Dao
}