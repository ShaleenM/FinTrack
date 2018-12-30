package com.lucifer.fintrack.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.util.Log;

import com.lucifer.fintrack.modules.utils.ExpenseCategory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

@Entity(tableName = "expense")
public class Expense {

    /** Unique identifier of an expense. Epoch timestamp of expense creation time.**/
    @PrimaryKey
    @NonNull
    private LocalDateTime expense_creation_date;

    /**YYYY MM DD of the transaction**/
    @NonNull
    @ColumnInfo(index = true)
    private LocalDateTime transaction_date;

    /**Amount of money spent**/
    @NonNull
    private BigDecimal transaction_amount;

    /**Currency of transaction**/
    @NonNull
    private Currency currency;

    /**Category of transaction**/
    @ColumnInfo(index = true)
    @NonNull
    private String category;

    /**Description of transaction**/
    @ColumnInfo(index = true)
    @NonNull
    private String expense_name;

    /**Annotation of transaction**/
    private String annotation;

    public Expense(@NonNull LocalDateTime expense_creation_date, @NonNull LocalDateTime transaction_date, @NonNull BigDecimal transaction_amount,@NonNull Currency currency, @NonNull String category,@NonNull String expense_name, String annotation) {
        this.expense_creation_date = expense_creation_date;
        this.transaction_date = transaction_date;
        this.transaction_amount = transaction_amount;
        this.currency = currency;
        this.category = category;
        this.expense_name = expense_name;
        this.annotation = annotation;
    }

    @NonNull
    public LocalDateTime getExpense_creation_date() {
        return expense_creation_date;
    }

    @NonNull
    public LocalDateTime getTransaction_date() {
        return transaction_date;
    }

    @NonNull
    public BigDecimal getTransaction_amount() {
        return transaction_amount;
    }

    @NonNull
    public Currency getCurrency() {
        return currency;
    }

    @NonNull
    public String getCategory() {
        return category;
    }

    public String getAnnotation() {
        return annotation;
    }

    @NonNull
    public String getExpense_name() {
        return expense_name;
    }

    public void setExpense_name(@NonNull String expense_name) {
        this.expense_name = expense_name;
    }


    public void setExpense_creation_date(@NonNull LocalDateTime expense_creation_date) {
        this.expense_creation_date = expense_creation_date;
    }

    public void setTransaction_date(@NonNull LocalDateTime transaction_date) {
        this.transaction_date = transaction_date;
    }

    public void setTransaction_amount(@NonNull BigDecimal transaction_amount) {
        this.transaction_amount = transaction_amount;
    }


    public void setCurrency(@NonNull Currency currency) {
        this.currency = currency;
    }

    /**
     * This method will store ExpenseCategory enum as string. If the enum is not present it will default to MISCELLANEOUS
     * @param category
     */
    public void setCategory(@NonNull String category) {
        try {
            ExpenseCategory.valueOf(category);
            this.category = category;
        } catch (Exception e) {
            Log.w("ExpenseEntity", "Unknown category defaulted to MISCELLANEOUS. Caught Exception: " + e.getStackTrace());
            this.category = ExpenseCategory.MISCELLANEOUS.name();
        }

    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }
}
