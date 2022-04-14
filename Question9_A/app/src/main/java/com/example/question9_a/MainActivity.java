package com.example.question9_a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button red;
    private Button green;
    private Button blue;
    private Button reset;
    private ConstraintLayout home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.red = findViewById(R.id.red);
        this.blue = findViewById(R.id.blue);
        this.green = findViewById(R.id.green);
        this.reset = findViewById(R.id.reset);
//        this.home = findViewById(R.id.)
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View parent = (View) view.getParent();
                parent.setBackgroundColor(Color.RED);
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View parent = (View) view.getParent();
                parent.setBackgroundColor(Color.BLUE);
            }
        });
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View parent = (View) view.getParent();
                parent.setBackgroundColor(Color.GREEN);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View parent = (View) view.getParent();
                parent.setBackgroundColor(Color.WHITE);
            }
        });
    }
}