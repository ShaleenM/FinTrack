package com.lucifer.fintrack.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.math.BigInteger;
import java.util.Currency;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity(tableName = "expense")
public class Expense {

    // TODO: 12/26/18 Convert to Long. Since we cannot get a value bigger than long for this field. @see SummaryLayoutHandler.AmountSpentAsyncTaskRunner.getStartOfMonth
    /** Unique identifier of an expense. Epoch timestamp of expense creation time.**/
    @PrimaryKey
    @NonNull
    private BigInteger expense_creation_date;

    /**YYYY MM DD of the transaction**/
    @NonNull
    @ColumnInfo(index = true)
    private Date transaction_date;

    /**Amount of money spent**/
    @NonNull
    private Double transaction_amount;

    /**Currency of transaction**/
    private Currency currency;

    /**Category of transaction**/

    @ColumnInfo(index = true)
    private String category;

    /**Annotation**/
    private String annotation;

    public Expense(@NonNull BigInteger expense_creation_date, @NonNull Date transaction_date, @NonNull Double transaction_amount, Currency currency, String category, String annotation) {
        this.expense_creation_date = expense_creation_date;
        this.transaction_date = transaction_date;
        this.transaction_amount = transaction_amount;
        this.currency = currency;
        this.category = category;
        this.annotation = annotation;
    }

    @NonNull
    public BigInteger getExpense_creation_date() {
        return expense_creation_date;
    }

    @NonNull
    public Date getTransaction_date() {
        return transaction_date;
    }

    @NonNull
    public Double getTransaction_amount() {
        return transaction_amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public String getCategory() {
        return category;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setExpense_creation_date(@NonNull BigInteger expense_creation_date) {
        this.expense_creation_date = expense_creation_date;
    }

    public void setTransaction_date(@NonNull Date transaction_date) {
        this.transaction_date = transaction_date;
    }

    public void setTransaction_amount(@NonNull Double transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }
}
