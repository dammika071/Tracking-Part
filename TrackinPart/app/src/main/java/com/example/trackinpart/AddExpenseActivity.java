package com.example.trackinpart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup ;


public class AddExpenseActivity extends AppCompatActivity {
    private EditText amountEditText, noteEditText,categoryEditText;
    private RadioGroup typeRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amountEditText = findViewById(R.id.amount);
        noteEditText = findViewById(R.id.note);
        categoryEditText = findViewById(R.id.category);
        typeRadioGroup = findViewById(R.id.typeRadioGroup) ;

    }

    public void addExpense(View view){
        double amount = Double.parseDouble(amountEditText.getText().toString());
        String note = noteEditText.getText().toString();
        String category = categoryEditText.getText().toString();
        int selectedTypeId = typeRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedTypeRadioButton = findViewById(selectedTypeId);
        String type = selectedTypeRadioButton.getText().toString();

        ExpenseDataSource dataSource = new ExpenseDataSource(this);
        dataSource.open();
        Expense expense = new Expense(amount, type, note, category);
        dataSource.addExpense(expense);
        dataSource.close();

        // Start DashboardActivity to display the list of expenses
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);



        finish();

    }


}