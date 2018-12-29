package com.lucifer.fintrack.modules.overview;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import com.lucifer.fintrack.R;
import com.lucifer.fintrack.database.ExpenseDao;
import com.lucifer.fintrack.database.ExpenseRoomDatabase;

import java.math.BigInteger;
import java.util.Calendar;

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

            // TODO: 12/29/18 Replace Calendar with a thread safe library 
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY, 0); // ! clear would not reset the hour of day !
            cal.clear(Calendar.MINUTE);
            cal.clear(Calendar.SECOND);
            cal.clear(Calendar.MILLISECOND);

            return BigInteger.valueOf(cal.getInstance().getTimeInMillis()/1000);
        }

        private BigInteger getEndOfMonth() {

            // TODO: 12/29/18 Replace Calendar with a thread safe library
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY, 0); // ! clear would not reset the hour of day !
            cal.clear(Calendar.MINUTE);
            cal.clear(Calendar.SECOND);
            cal.clear(Calendar.MILLISECOND);

            cal.add(Calendar.MONTH, 1);
            cal.add(Calendar.SECOND, -1); // To get 20XX-MM-31 11:59 PM

            return BigInteger.valueOf(cal.getInstance().getTimeInMillis()/1000);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            amount_month_spent.setText(values[0]);
        }
    }
}
