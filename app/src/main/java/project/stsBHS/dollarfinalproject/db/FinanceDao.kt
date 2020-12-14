//Author: Hemraj Kafle
//Student#: 991511170

package project.stsBHS.dollarfinalproject.db

import androidx.room.*;
import project.stsBHS.dollarfinalproject.db.ExpenseEntity
import project.stsBHS.dollarfinalproject.db.IncomeEntity

import java.util.List;

//Data Access Object to communicate with the database
@Dao
interface FinanceDao{

//    For Expense Table
    @Query("SELECT * FROM expenses WHERE id = :id")
    fun getExpense(id: Long?): ExpenseEntity

    @Query("SELECT * FROM expenses")
    fun getAllExpenses(): List<ExpenseEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExpense(expense: ExpenseEntity)

    @Query("Delete FROM expenses")
    fun deleteALLExpenses()

    @Query("Delete FROM expenses WHERE id = :id")
    fun deleteExpense(id: Long?)

    @Update
    fun updateExpense(expense: ExpenseEntity)


//    For Income Table
    @Query("SELECT * FROM incomes WHERE id = :id")
    fun getIncome(id: Long?): IncomeEntity

    @Query("SELECT * FROM incomes")
    fun getAllIncomes(): List<IncomeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIncome(income: IncomeEntity)

    @Query("Delete FROM incomes")
    fun deleteAllIncomes()

    @Query("Delete FROM incomes WHERE id = :id")
    fun deleteIncome(id: Long?)

    @Update
    fun updateIncome(income: IncomeEntity)

}