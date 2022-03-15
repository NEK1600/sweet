package com.example.sweet.base;

public final class Constants {
    public static final String TABLE_NAME = "my_table";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String GRAM = "gram";

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "DbDayProduct.db";

    public static final String TABLE_STRUCTURE = "CREATE TABLE " + TABLE_NAME + " (" +
            ID + " INTEGER PRIMARY KEY, " + NAME + " TEXT, " + GRAM + " TEXT)";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
}
