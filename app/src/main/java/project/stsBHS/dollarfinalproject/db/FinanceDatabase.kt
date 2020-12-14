//Author: Hemraj Kafle
//Student#: 991511170

package project.stsBHS.dollarfinalproject.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context

//Class to create the instance of the RoomDatabase and communicate with database via Dao
@Database(entities = [ExpenseEntity::class, IncomeEntity::class], version = 1)
abstract class FinanceDatabase : RoomDatabase() {
        abstract fun financeDao(): FinanceDao

        companion object {

                @Volatile
                private var INSTANCE: FinanceDatabase? = null

                fun getInstance(context: Context): FinanceDatabase {
                        if (INSTANCE == null) {
                                INSTANCE = Room.databaseBuilder(
                                        context,
                                        FinanceDatabase::class.java,
                                        "finances.db")
                                        .build()
                        }
                        return INSTANCE as FinanceDatabase
                }
        }
}