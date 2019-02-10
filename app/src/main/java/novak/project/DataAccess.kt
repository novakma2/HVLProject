package novak.project

import android.content.Context
import novak.project.controller.AppDatabase
import novak.project.controller.Dao

object DataAccess {

    fun provideDAO(context: Context): Dao {
        return AppDatabase.getInstance(context).personsDao()
    }
}