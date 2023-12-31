package com.example.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isInputValid()){
                    String userName = username.getText().toString();
                    String pass = password.getText().toString();
                    loginPerformed(userName, pass);
                }else{
                    Toast.makeText(LoginActivity.this,"Fill all the field", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean isInputValid(){
        return !username.getText().toString().trim().isEmpty() && !password.getText().toString().trim().isEmpty();
    }
    private void loginPerformed(String username, String password){
        if(username.equals("admin") && password.equals("123456")){
            Toast.makeText(this,"Successfully Logged in", Toast.LENGTH_SHORT ).show();
            Intent intent = new Intent(this, AdminDashboardActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Password or username incorrect", Toast.LENGTH_SHORT).show();
        }
    }
}