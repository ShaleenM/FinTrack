package com.lucifer.fintrack.modules.overview;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import com.lucifer.fintrack.R;
import com.lucifer.fintrack.database.ExpenseDao;
import com.lucifer.fintrack.database.ExpenseRoomDatabase;

import java.math.BigInteger;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SummaryLayoutHandler {

    private final Context context;
    private final View summary_layout;
    private ExpenseRoomDatabase expenseDB;
    private ExpenseDao expenseDao;

    private TextView amount_month_spent;
    private TextView summary_month_spent;

    public void handle() {
        expenseDB = ExpenseRoomDatabase.getDatabase(context);
        expenseDao = expenseDB.getExpenseDao();

        amount_month_spent = (TextView) summary_layout.findViewById(R.id.amount_month_spent);
        summary_month_spent = (TextView) summary_layout.findViewById(R.id.summary_month_spent);

        new AmountSpentAsyncTaskRunner().execute("");

    }


    private class AmountSpentAsyncTaskRunner extends AsyncTask<String, String, Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {
            BigInteger startOfMonth = getStartOfMonth();
            BigInteger endOfMonth = getEndOfMonth();

            // TODO: 12/29/18 Query tranactions with creation date between startOfMonth and endOfMonth 
            return false;
        }

        private BigInteger getStartOfMonth() {
            long firstDayofCurrentMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()).atStartOfDay(ZoneId.of("UTC")).toEpochSecond();
            return BigInteger.valueOf(firstDayofCurrentMonth);
        }

        private BigInteger getEndOfMonth() {
            long lastDayofCurrentMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth()).atStartOfDay(ZoneId.of("UTC")).toEpochSecond() - 1;
            return BigInteger.valueOf(lastDayofCurrentMonth);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            amount_month_spent.setText(values[0]);
        }
    }
}
