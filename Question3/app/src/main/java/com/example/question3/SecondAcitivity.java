package com.example.question3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondAcitivity extends AppCompatActivity {
    private TextView displayName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_acitivity);


        this.displayName=findViewById(R.id.displayName);
        String s =getIntent().getExtras().getString("nameKey");
        displayName.setText(s);
    }
}