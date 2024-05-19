package com.example.navdrawer;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText usernameEditText, newPasswordEditText;
    private Button resetPasswordButton;
    private DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        usernameEditText = findViewById(R.id.editTextUsername);
        newPasswordEditText = findViewById(R.id.editTextNewPassword);
        resetPasswordButton = findViewById(R.id.buttonResetPassword);
        DB = new DBHelper(this);

        resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String password = newPasswordEditText.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(ForgotPasswordActivity.this, "Please enter username and new password", Toast.LENGTH_SHORT).show();
                } else {
                    if (DB.checkusername(username)) {
                        boolean passwordUpdated = DB.updatePassword(username, password);
                        if (passwordUpdated) {
                            Toast.makeText(ForgotPasswordActivity.this, "Password reset successfully", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(ForgotPasswordActivity.this, "Failed to reset password", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(ForgotPasswordActivity.this, "User not found", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}