package com.example.project12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Signup extends AppCompatActivity {
    EditText name,username, password, email, confirm;
    Button signup_btn;
    MySQLite db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        name = (EditText) findViewById(R.id.txt_name);
        username = (EditText) findViewById(R.id.txt_username);
        password = (EditText) findViewById(R.id.txt_password);
        email = (EditText) findViewById(R.id.txt_email);
        confirm = (EditText) findViewById(R.id.txt_conf_password);
        signup_btn = (Button) findViewById(R.id.signup_btn);

        db = new MySQLite(this);
        //when user clicks on signup button after filling the required fill, a new account will be created
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nam = name.getText().toString().trim();
                String usernam = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                String emai = email.getText().toString().trim();
                String conf= confirm.getText().toString().trim();
                //check if the email is already used by someone.
                Boolean result = db.validateEmail(emai);
                //check if the fields are empty
                if (usernam.equals("") || nam.equals("") || pass.equals("") || emai.equals("") || conf.equals("") )
                    Toast.makeText(Signup.this, "Please fill all the fields.", Toast.LENGTH_SHORT).show();
                else if(!pass.equals(conf))
                    Toast.makeText(Signup.this, "Password and confirmation password doesn't match.", Toast.LENGTH_SHORT).show();
                else {
                    //if there is no account with the same email.
                    if (result == false) {
                        Long insert = db.insertNewUser(nam,usernam, pass, emai);
                        if (insert > 0) {
                            Toast.makeText(Signup.this, "New account has been created", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Signup.this, Login.class);
                            startActivity(intent);
                            finish();
                        }
                        //if the user not inserted.
                        else {
                            Toast.makeText(Signup.this, "Something went wrong, please try again,", Toast.LENGTH_SHORT).show();
                        }
                    }
                    //if the email is already taken by another user.
                    else
                        Toast.makeText(Signup.this, "This email is already taken, please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}