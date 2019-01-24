package novak.project.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "persons")
data class Person(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "name") val name: String = "John",
    @ColumnInfo(name = "surname") val surname: String = "Doe",
    @ColumnInfo(name = "img") var picture: Int = 0
)
