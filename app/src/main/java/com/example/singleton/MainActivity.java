package com.example.singleton;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText inputUsername = findViewById(R.id.inputUsername);
        final EditText inputPassword = findViewById(R.id.inputPassword);
        Button buttonSubmit = findViewById(R.id.btnSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View v) {
                String username = inputUsername.getText().toString();
                String password = inputPassword.getText().toString();

                UserRepository instance = UserRepository.getInstance();
                Map<String, String> users = instance.getUsers();

                String storedPassword = users.get(username);

                if (storedPassword == null || !storedPassword.equals(password)) {
                    Toast invalid = Toast.makeText(
                            getApplicationContext(), "INVALID", Toast.LENGTH_LONG);
                    invalid.show();
                } else {
                    Toast valid = Toast.makeText(
                            getApplicationContext(), "VALID", Toast.LENGTH_LONG);
                    valid.show();
                }
            }
        });
    }
}
