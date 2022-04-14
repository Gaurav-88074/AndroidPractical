package com.example.question7;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rgCourses;
    private HashMap<String, String> coursesMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCourses();
    }

    private void initCourses() {
        rgCourses = findViewById(R.id.rgCourses);
        if (coursesMap == null) {
            coursesMap = new HashMap<>();
            coursesMap.put("BSc(H) Computer Science", " Dr.V.S.Dixit");
            coursesMap.put("BCom(H)", " Dr.Manika Jain");
            coursesMap.put("BA(H) Sociology", " Dr. Apra Sinha");
            for (String course : coursesMap.keySet()) {
                RadioButton rButton = new RadioButton(MainActivity.this);
                rButton.setText(course);
                rgCourses.addView(rButton);
            }
            rgCourses.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    int checkedRadioButtonId = rgCourses.getCheckedRadioButtonId();
                    RadioButton rButton = findViewById(checkedRadioButtonId);
                    Snackbar.make(rgCourses, coursesMap.get(rButton.getText()), Snackbar.LENGTH_SHORT)
                            .show();
                }
            });
        }
    }
}
