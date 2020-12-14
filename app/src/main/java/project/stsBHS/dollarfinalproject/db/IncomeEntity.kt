package project.stsBHS.dollarfinalproject.db


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "incomes")
data class IncomeEntity(

        @PrimaryKey(autoGenerate = true)
        var id: Long,

        @ColumnInfo(name = "date")
        var date: String,

        @ColumnInfo(name = "description")
        var description: String,

        @ColumnInfo(name = "amount")
        var amount: Double
)