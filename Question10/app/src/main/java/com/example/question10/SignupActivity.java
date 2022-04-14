package com.example.question10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class SignupActivity extends AppCompatActivity {
    private EditText s_name;
    private EditText s_email;
    private EditText s_password;
    private Button signupButton;
    public boolean isPresent(List<User> users,String email){
        for (User user : users) {
            if (user.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        this.s_name = findViewById(R.id.s_name);
        this.s_email = findViewById(R.id.s_email);
        this.s_password = findViewById(R.id.s_password);
        this.signupButton = findViewById(R.id.loginButton);
        DbHandler handler = new DbHandler(this,"userDb",null,1);

        this.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<User> allUsers = handler.getAllUsers();
                String email = s_email.getText().toString();
                boolean isPresent = isPresent(allUsers,email);
                if (isPresent){
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(getApplicationContext(), "Email has already been taken!", duration);
                    toast.show();
                    return;
                }
                handler.addUser(new User(
                        s_name.getText().toString(),
                        s_email.getText().toString(),
                        s_password.getText().toString()
                ));
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(getApplicationContext(), "Sign up successful!", duration);
                toast.show();
                Intent intent = new Intent(getApplication(),MainActivity.class);
                startActivity(intent);
            }
        });

    }
}