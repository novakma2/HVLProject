package novak.project.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 *  Passing Int to @param uid will rewrite Person with that uid ! Pass only null to add Person
 */
@Entity(tableName = "persons")
data class Person(
    @PrimaryKey(autoGenerate = true) val uid: Int?,
    @ColumnInfo(name = "name") val name: String = "John",
    @ColumnInfo(name = "surname") val surname: String = "Doe",
    @ColumnInfo(name = "img") var picture: Int = 0
)
