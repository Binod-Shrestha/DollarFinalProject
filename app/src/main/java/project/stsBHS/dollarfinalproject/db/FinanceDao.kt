package project.stsBHS.dollarfinalproject

import androidx.room.*;
import project.stsBHS.dollarfinalproject.db.ExpenseEntity

import java.util.List;

@Dao
interface FinanceDao{

    @Query("SELECT * FROM expenses")
    fun getAllExpenses(): List<ExpenseEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(student: ExpenseEntity)

    @Query("Delete FROM expenses")
    fun deleteALL()
}