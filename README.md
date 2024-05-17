# Tracking-Part
TrackInPart is an Android application for tracking expenses and income. It provides a user-friendly interface to add, view, and analyze financial transactions. The app includes features to display total income, expenses, and balance.

## Features
- Add and categorize expenses and income.
- View a list of all financial transactions.
- Calculate and display total income, total expenses, and balance.

## Screenshots
![image](https://github.com/StarScrum/Tracking-Part/assets/159421973/374c2bea-d6c9-4eb5-8470-223d295cd4d7)
![image](https://github.com/StarScrum/Tracking-Part/assets/159421973/68e7eb53-23a9-4553-a470-3450351d4092)

## Installation

1. Clone the repository:
    ```bash
    git clone (https://github.com/StarScrum/Tracking-Part)
    ```
2. Open the project in Android Studio.
3. Build and run the application on an emulator or physical device.

## Usage

1. Launch the application.
2. Use the "Add Expense" screen to input a new financial transaction.
3. View the list of transactions on the "Dashboard" screen.

## Code Structure

- `AddExpenseActivity.java`: Handles the functionality for adding new expenses or income.
- `DashboardActivity.java`: Displays the list of all transactions and provides a button to view the graphical representation.
- `DatabaseHelper.java`: Manages the SQLite database for storing financial transactions.
- `Expense.java`: Model class representing an expense or income entry.
- `ExpenseAdapter.java`: Adapter class for displaying transactions in a RecyclerView.
- `ExpenseDataSource.java`: Provides methods to interact with the database.

## Dependencies

- MPAndroidChart: A library for creating charts in Android.
    ```gradle
    dependencies {
        implementation 'com.github.PhilJay:MPAndroidChart:v3.1.0'
    }
    ```

## Contact

For any inquiries or feedback, please contact ms24018678@my.sliit.lk.
