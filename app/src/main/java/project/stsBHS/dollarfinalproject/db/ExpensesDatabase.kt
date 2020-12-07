package project.stsBHS.dollarfinalproject.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import project.stsBHS.dollarfinalproject.ExpenseDao

@Database(entities = [ExpenseEntity::class], version = 1)
abstract class ExpensesDatabase : RoomDatabase() {
    abstract fun expenseDao(): ExpenseDao

    companion object {

        @Volatile
        private var INSTANCE: ExpensesDatabase? = null

        fun getInstance(context: Context): ExpensesDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    ExpensesDatabase::class.java,
                    "expenses.db")
                    .build()
            }
            return INSTANCE as ExpensesDatabase
        }
    }
}