package novak.project.controller

import android.arch.persistence.room.*
import android.arch.persistence.room.Dao
import android.util.Log
import novak.project.model.Person

@Dao
interface Dao {
    /**
     * @param person Add person to end of database
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPerson(person: Person)

    /**
     * @param id ID of person in database
     * @return Returns person of given id
     */
    @Query("SELECT * FROM persons WHERE uid=:id LIMIT 1")
    fun getPerson(id: Int): Person

    /**
     * @return Returns array of all persons in database
     */
    @Query("SELECT * FROM persons")
    fun getPersons(): Array<Person>

    /**
     * @param person Person which we want delete from database
     */
    @Delete
    fun deletePerson(person: Person)

    /**
     * Use just for one time, TESTING ONLY!
     * @param persons add programically generated persons
     */
    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun init(persons: Array<Person>)

    /**
     * @return Returns count of persons in database
     */
    @Query("SELECT COUNT(*) FROM persons")
    fun countPersons(): Int

    /**
     * Deletes whole database
     */
    @Query("DELETE FROM persons WHERE (name=name)")
    fun clearTable()

    @Query("Select uid from persons ORDER BY uid DESC LIMIT 1;")
    fun getNextId():Int

}