package com.example.epeas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Spinner spinner;
    Button login;
    String selectedRole;
    String[] role={"admin","employee","evaluator"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,role);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedRole= adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        username = findViewById(R.id.username);

        password = findViewById(R.id.password);
        login = findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(username.getText().toString().equals("devraj")
                        && password.getText().toString().equals("123456")
                        &&  selectedRole!= null && selectedRole.equals("admin") ){
                    Toast.makeText(MainActivity.this,selectedRole, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Incorrect credential", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return false;
    }
}