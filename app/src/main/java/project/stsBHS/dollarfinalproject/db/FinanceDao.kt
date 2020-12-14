package project.stsBHS.dollarfinalproject

import androidx.room.*;
import project.stsBHS.dollarfinalproject.db.ExpenseEntity

import java.util.List;

@Dao
interface FinanceDao{

    @Query("SELECT * FROM expenses WHERE id = :id")
    fun getExpense(id: Long?): ExpenseEntity

    @Query("SELECT * FROM expenses")
    fun getAllExpenses(): List<ExpenseEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(expense: ExpenseEntity)

    @Query("Delete FROM expenses")
    fun deleteALL()

    @Query("Delete FROM expenses WHERE id = :id")
    fun deleteAExpense(id: Long?)

    @Update
    fun updateExpense(expense: ExpenseEntity)

}