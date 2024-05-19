package com.example.trackinpart;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder> {
    private List<Expense> expenses;

    public ExpenseAdapter(List<Expense> expenses) {
        this.expenses = expenses;
    }

    @NonNull
    @Override
    public ExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_expense, parent, false);
        return new ExpenseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseViewHolder holder, int position) {
        Expense expense = expenses.get(position);
        holder.amountTextView.setText(String.valueOf(expense.getAmount()));
        holder.typeTextView.setText(expense.getType());
        holder.noteTextView.setText(expense.getNote());
        holder.categoryTextView.setText(expense.getCategory());
    }

    @Override
    public int getItemCount() {
        return expenses.size();
    }

    public static class ExpenseViewHolder extends RecyclerView.ViewHolder {
        public TextView amountTextView, typeTextView, noteTextView, categoryTextView;

        public ExpenseViewHolder(@NonNull View itemView) {
            super(itemView);
            amountTextView = itemView.findViewById(R.id.amountTextView);
            typeTextView = itemView.findViewById(R.id.typeTextView);
            noteTextView = itemView.findViewById(R.id.noteTextView);
            categoryTextView = itemView.findViewById(R.id.categoryTextView);
        }
    }


}
