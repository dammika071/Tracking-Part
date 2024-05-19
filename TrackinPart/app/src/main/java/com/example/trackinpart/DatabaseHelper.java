package com.example.trackinpart;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "expenses.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_EXPENSES = "expenses";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_AMOUNT = "amount";
    private static final String COLUMN_TYPE = "type";
    private static final String COLUMN_NOTE = "note";
    private static final String COLUMN_CATEGORY = "category";

    private static final String CREATE_TABLE_EXPENSES = "CREATE TABLE " + TABLE_EXPENSES + "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_AMOUNT + " REAL," +
            COLUMN_TYPE + " TEXT," +
            COLUMN_NOTE + " TEXT," +
            COLUMN_CATEGORY + " TEXT" +
            ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_EXPENSES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXPENSES);
        onCreate(db);
    }

    public long addExpense(Expense expense){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(COLUMN_AMOUNT,expense.getAmount());
        values.put(COLUMN_TYPE, expense.getType());
        values.put(COLUMN_NOTE, expense.getNote());
        values.put(COLUMN_CATEGORY, expense.getCategory());
        long id = db.insert(TABLE_EXPENSES,null,values);
        db.close();
        return id;
    }

    @SuppressLint("Range")
    public List<Expense> getAllExpenses() {
        List<Expense> expenses = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_EXPENSES;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Expense expense = new Expense();
                expense.setId(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
                expense.setAmount(cursor.getDouble(cursor.getColumnIndex(COLUMN_AMOUNT)));
                expense.setType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                expense.setNote(cursor.getString(cursor.getColumnIndex(COLUMN_NOTE)));
                expense.setCategory(cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORY)));
                expenses.add(expense);
            } while (cursor.moveToNext());
            cursor.close();
        }
        db.close();
        return expenses;
    }



}