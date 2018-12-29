package com.lucifer.fintrack.database;


import android.arch.persistence.room.TypeConverter;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

public class Converters {

    @TypeConverter
    public static String fromBigDecimal(BigDecimal bigDecimal) {
        Gson gson = new Gson();
        String json = gson.toJson(bigDecimal);
        return json;
    }

    @TypeConverter
    public static BigDecimal fromStringtoBigDecimal(String value) {
        Type bigDecimalType = new TypeToken<BigDecimal>(){}.getType();
        return new Gson().fromJson(value, bigDecimalType);
    }

    @TypeConverter
    public static String fromDate(Date date) {
        Gson gson = new Gson();
        String json = gson.toJson(date);
        return json;
    }

    @TypeConverter
    public static Date fromStringtoDate(String value) {
        Type dateType = new TypeToken<Date>(){}.getType();
        return new Gson().fromJson(value, dateType);
    }

    @TypeConverter
    public static String fromCurrency(Currency currency) {
        Gson gson = new Gson();
        String json = gson.toJson(currency);
        return json;
    }

    @TypeConverter
    public static Currency fromStringtoCurrency(String value) {
        Type currencyType = new TypeToken<Currency>(){}.getType();
        return new Gson().fromJson(value, currencyType);
    }
}
