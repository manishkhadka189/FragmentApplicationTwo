package com.frag.fragmentapplicationtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText username, password;
    Button btnLogin;
    String user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        user = username.getText().toString().trim();
        pass = password.getText().toString().trim();
        if (!user.isEmpty() && !pass.isEmpty()) {

            if (user.equals("manish") && pass.equals("admin")) {
                Intent intent = new Intent(MainActivity.this, BottomNav.class);
                startActivity(intent);
                //Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

        } else {
            if (user.isEmpty()) {
                username.setError("Enter User Name");
            }
            if (pass.isEmpty()) {
                password.setError("Enter Password");
            }
        }
    }
}
