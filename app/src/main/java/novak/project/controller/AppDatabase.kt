package novak.project.controller

import androidx.room.Database
import androidx.room.RoomDatabase
import novak.project.model.Person

@Database(entities = arrayOf(Person::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun personsDao(): Dao
}