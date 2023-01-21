package com.example.project12;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button loginButton, signupButton;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton =(Button) findViewById(R.id.login_btn);
        signupButton =(Button) findViewById(R.id.signup_btn);
        Toast.makeText(this, "Welcome to Traveler App",Toast.LENGTH_LONG).show();
        //if user clicks on login button, login page will be opened.
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
        //if user clicks on signup button, signup page will be opened.
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Signup.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Sign up page", Toast.LENGTH_LONG).show();
            }
        });
    }
}