package project.stsBHS.dollarfinalproject.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import project.stsBHS.dollarfinalproject.FinanceDao

@Database(entities = [ExpenseEntity::class], version = 1)
abstract class FinanceDatabase : RoomDatabase() {
        abstract fun expenseDao(): FinanceDao

        companion object {

                @Volatile
                private var INSTANCE: FinanceDatabase? = null

                fun getInstance(context: Context): FinanceDatabase {
                        if (INSTANCE == null) {
                                INSTANCE = Room.databaseBuilder(
                                        context,
                                        FinanceDatabase::class.java,
                                        "expenses.db")
                                        .build()
                        }
                        return INSTANCE as FinanceDatabase
                }
        }
}