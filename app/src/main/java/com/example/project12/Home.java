package com.example.project12;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class Home extends AppCompatActivity {
    TextView welcome_txt;
    Button packageButton, placesButton;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        welcome_txt=(TextView)findViewById(R.id.welcome_txt);
        Intent intent = getIntent();
        //welcoming message will appear on user's screen.
        String username= intent.getStringExtra("username");
        welcome_txt.setText("Welcome "+ username +" in Traveler App");
        Toast.makeText(Home.this, "Traveller Home", Toast.LENGTH_SHORT).show();
        //when user clicks on the start button, packages page will be opened.
        packageButton =(Button) findViewById(R.id.button2);
        packageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Packages.class);
                startActivity(intent);
            }
        });
        //when user clicks on the explore button, places page will be opened.
        placesButton =(Button) findViewById(R.id.button3);
        placesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Places.class);
                startActivity(intent);
            }
        });
    }
}
