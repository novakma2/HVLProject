package novak.project.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "persons")
data class Person(
    @PrimaryKey(autoGenerate = true) val uid: Int?,
    @ColumnInfo(name = "name") val name: String = "John",
    @ColumnInfo(name = "surname") val surname: String = "Doe",
    @ColumnInfo(name = "img") var picture: Int = 0
)
