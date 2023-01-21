package com.example.project12;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    Button loginButton, signupButton;
    EditText username, password,email;
    Context context;
    Button errorButton;
    MySQLite db;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        signupButton = (Button) findViewById(R.id.register);
        loginButton = (Button) findViewById(R.id.button);
        password = (EditText) findViewById(R.id.txt_password);
        username= (EditText) findViewById(R.id.txt_username);
        db = new MySQLite(this);
        context = this;
        //if user clicks on login button.
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass = password.getText().toString().trim();
                String usernam =username.getText().toString().trim();
                //validate username and password.
                Boolean result = db.validateLogin( usernam,pass);
                //if user left some fields empty.
                if (usernam.equals("") || pass.equals("") )
                    Toast.makeText(Login.this, "Please enter all data", Toast.LENGTH_SHORT).show();
                else {
                    //if user information is correct.
                    if (result == true) {
                        Toast.makeText(Login.this, "login success", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this, Home.class);
                        intent.putExtra("username", username.getText().toString());
                        startActivity(intent);
                        finish();
                    }
                    //if username or password is incorrect, a dialog will appear on user's screen.
                    else {
                        AlertDialog.Builder myBuilder = new AlertDialog.Builder(Login.this);
                        myBuilder.setTitle("Error");
                        myBuilder.setMessage("Username or password is incorrect please try again.");
                        myBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int i){
                            }
                        });
                        myBuilder.show();
                    }
                }
            }
        });
        //if user clicks on signup button.
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Signup.class);
                startActivity(intent);
            }
        });
    }
}