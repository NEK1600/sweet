package com.example.sweet.base;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private Context context;
    private Helper helper;
    private SQLiteDatabase db;

    public Manager(Context context){
        this.context = context;
        helper=new Helper(context);
    }

    public void openBase(){
        db = helper.getWritableDatabase();
    }


    public void insertBase(String name, Double gram){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.NAME, name);
        contentValues.put(Constants.GRAM, gram);
        db.insert(Constants.TABLE_NAME, null, contentValues);
    }



    public List<String> readBaseName(){
        List<String> tempList = new ArrayList<>();
        openBase();
        Cursor cursor = db.query(Constants.TABLE_NAME, null, null,
                null, null, null, null);
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndexOrThrow
                    (Constants.NAME));
            tempList.add(name);
        }
        cursor.close();
        return tempList;
    }

    public /*здесь должен быть просто List*/ArrayList<Double> readBaseGram(){
        /*здесь должен быть просто List*/ArrayList<Double> tempList = new ArrayList<>();
        openBase();
        Cursor cursor = db.query(Constants.TABLE_NAME, null, null,
                null, null, null, null);
        while (cursor.moveToNext()){
            Double name = cursor.getDouble(cursor.getColumnIndexOrThrow
                    (Constants.GRAM));
            tempList.add(name);
        }
        cursor.close();
        return tempList;
    }

    public void closeDb(){
        db.close();
    }


}


































