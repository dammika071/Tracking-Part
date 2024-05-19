package com.example.trackinpart;

import android.content.Context;
import android.database.SQLException;
import java.util.List;

public class ExpenseDataSource {
    private DatabaseHelper dbHelper;

    public ExpenseDataSource(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long addExpense(Expense expense) {
        return dbHelper.addExpense(expense);
    }

    public List<Expense> getAllExpenses() {
        return dbHelper.getAllExpenses();
    }
}
