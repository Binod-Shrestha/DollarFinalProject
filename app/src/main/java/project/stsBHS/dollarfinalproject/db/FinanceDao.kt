package project.stsBHS.dollarfinalproject.db

import androidx.room.*;

import java.util.List;

@Dao
interface FinanceDao{

    @Query("SELECT * FROM expenses")
    fun getAllExpenses(): List<ExpenseEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(expense: ExpenseEntity)

    @Query("Delete FROM expenses")
    fun deleteALLExpenses()

    @Query("SELECT * FROM incomes")
    fun getAllEarnings(): List<IncomeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(earning: IncomeEntity)

    @Query("Delete FROM incomes")
    fun deleteALLEarnings()
}