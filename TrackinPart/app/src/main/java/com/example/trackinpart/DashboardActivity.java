package com.example.trackinpart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class DashboardActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ExpenseAdapter adapter;
    private ExpenseDataSource dataSource;
    private TextView totalIncomeTextView, totalExpenseTextView, balanceTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        totalIncomeTextView = findViewById(R.id.totalIncomeTextView);
        totalExpenseTextView = findViewById(R.id.totalExpenseTextView);
        balanceTextView = findViewById(R.id.balanceTextView);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dataSource = new ExpenseDataSource(this);
        dataSource.open();

        List<Expense> expenses = dataSource.getAllExpenses();
        adapter = new  ExpenseAdapter(expenses);
        recyclerView.setAdapter(adapter);

        // Calculate and display total income, total expense, and balance
        calculateAndDisplayTotals(expenses);
    }

    private void calculateAndDisplayTotals(List<Expense> expenses) {
        double totalIncome = 0;
        double totalExpense = 0;

        for (Expense expense : expenses) {
            if (expense.getType().equals("Income")) {
                totalIncome += expense.getAmount();
            } else {
                totalExpense += expense.getAmount();
            }
        }

        totalIncomeTextView.setText(String.format(Locale.getDefault(), "Total Income: %.2f", totalIncome));
        totalExpenseTextView.setText(String.format(Locale.getDefault(), "Total Expense: %.2f", totalExpense));

        double balance = totalIncome - totalExpense;
        balanceTextView.setText(String.format(Locale.getDefault(), "Balance: %.2f", balance));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        dataSource.close();
    }


}