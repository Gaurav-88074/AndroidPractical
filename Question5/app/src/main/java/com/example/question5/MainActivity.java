package com.example.question5;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        image = findViewById(R.id.image);
        String[] language = {"Select One", "Ruby", "Python", "Cpp", "JavaScript","Swift","Go"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, language);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        image.setImageResource(R.drawable.rubylogo);
                        break;
                    case 2:
                        image.setImageResource(R.drawable.pythonlogo);
                        break;
                    case 3:
                        image.setImageResource(R.drawable.cpplogo);
                        break;
                    case 4:
                        image.setImageResource(R.drawable.javascriptlogo);
                        break;
                    case 5:
                        image.setImageResource(R.drawable.swiftlogo);
                        break;
                    case 6:
                        image.setImageResource(R.drawable.gologo);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}