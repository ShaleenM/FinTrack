package com.lucifer.fintrack.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.lucifer.fintrack.R;

@Database(entities = {Expense.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class ExpenseRoomDatabase extends RoomDatabase {

    public abstract ExpenseDao getExpenseDao();

    private static volatile ExpenseRoomDatabase INSTANCE;

    public static ExpenseRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ExpenseRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ExpenseRoomDatabase.class, context.getString(R.string.expense_database_name))
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
