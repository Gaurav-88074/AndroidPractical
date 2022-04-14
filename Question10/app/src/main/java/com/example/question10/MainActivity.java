package com.example.question10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView signupNavigateButton;
    private EditText email;
    private EditText password;
    private Button loginButton;
    public User isPresent(List<User> users, String email){
        for (User user : users) {
            if (user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.signupNavigateButton = findViewById(R.id.signupNavigateButton);
        this.email = findViewById(R.id.email);
        this.password = findViewById(R.id.password);
        this.loginButton = findViewById(R.id.loginButton);
        DbHandler handler = new DbHandler(this,"userDb",null,1);
        this.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<User> allUsers = handler.getAllUsers();
                String iemail = email.getText().toString();
                User check = isPresent(allUsers,iemail);
                if (check!=null && check.getPassword().equals(password.getText().toString())){
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(getApplicationContext(),"Welcome "+ check.getName(), duration);
                    toast.show();
                }
                else{
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(getApplicationContext(), "Couldn't find your account!", duration);
                    toast.show();
                }
            }
        });
        Intent intent = new Intent(this,SignupActivity.class);
        this.signupNavigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(intent);
            }
        });
    }
}