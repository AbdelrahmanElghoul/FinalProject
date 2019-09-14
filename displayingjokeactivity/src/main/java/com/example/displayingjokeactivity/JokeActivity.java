package com.example.displayingjokeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    TextView txtJoke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        txtJoke=findViewById(R.id.txt_joke);

        Intent intent=getIntent();
        txtJoke.setText(intent.getStringExtra(getString(R.string.JOKES_KEY)));
    }
}
