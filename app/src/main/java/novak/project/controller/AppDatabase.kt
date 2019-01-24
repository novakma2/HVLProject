package novak.project.controller

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import novak.project.model.Person

@Database(entities = arrayOf(Person::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun personsDao(): Dao
}