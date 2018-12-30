package com.lucifer.fintrack.database;


import android.arch.persistence.room.TypeConverter;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Currency;

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
    public static long fromLocalDateTime(LocalDateTime localDateTime) {
        return localDateTime.toEpochSecond(ZoneOffset.UTC);
    }

    @TypeConverter
    public static LocalDateTime fromLongtoLocalDateTime(long epochSec) {
        return LocalDateTime.ofEpochSecond(epochSec, 0, ZoneOffset.UTC);
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
