package com.lucifer.fintrack.modules.utils;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.lucifer.fintrack.modules.expenses.createupdate.CreateUpdateExpenseActivity;


public class AddExpenseFABListener implements View.OnClickListener {

    private Context context;

    public AddExpenseFABListener(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), CreateUpdateExpenseActivity.class);
        context.startActivity(intent);

    }
}
