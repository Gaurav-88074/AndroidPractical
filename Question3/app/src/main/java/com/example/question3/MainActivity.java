package com.example.question3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button submitButton;
    private EditText userInputName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.submitButton = findViewById(R.id.submitButton);
        this.userInputName = findViewById(R.id.userInputName);
        Intent intent  = new Intent(this,SecondAcitivity.class);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = userInputName.getText().toString();
                intent.putExtra("nameKey",data);
                startActivity(intent);
//                finish();
            }
        });
    }
}