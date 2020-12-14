//Author: Hemraj Kafle
//Student#: 991511170

package project.stsBHS.dollarfinalproject.db


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//data class for ExpenseEntity
//these entities are targeted for expenses table in database

@Entity(tableName = "expenses")
data class ExpenseEntity(

        @PrimaryKey(autoGenerate = true)
    var id: Long,

        @ColumnInfo(name = "date")
    var date: String,

        @ColumnInfo(name = "description")
    var description: String,

        @ColumnInfo(name = "amount")
    var amount: Double
)