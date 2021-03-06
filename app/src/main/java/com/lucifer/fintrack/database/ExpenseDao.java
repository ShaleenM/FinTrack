package com.lucifer.fintrack.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ExpenseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Expense expense);

    @Query("SELECT * FROM expense WHERE expense_creation_date BETWEEN :startOfMonth and :endOfMonth")
    List<Expense> getExpensesByMonth(long startOfMonth, long endOfMonth);

    @Query("SELECT SUM(transaction_amount) as total_spent FROM expense WHERE expense_creation_date BETWEEN :startOfMonth and :endOfMonth")
    String getExpensesSummaryByMonth(long startOfMonth, long endOfMonth);

    @Query("SELECT * FROM expense ORDER BY transaction_date, expense_creation_date DESC LIMIT :l")
    List<Expense> getRecentExpenses(int l);

    @Query("DELETE FROM expense WHERE expense_creation_date = :id")
    void deleteExpense(long id);

    @Query("DELETE FROM expense")
    void deleteAll();
}
