package com.example.calory_counter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.calory_img);


            EditText email = findViewById(R.id.editTextTextEmailAddress);
            EditText password = findViewById(R.id.editTextTextPassword);
            Button login = findViewById(R.id.LoginBtn);

            login.setOnClickListener(v1 -> {
                if(!email.getText().toString().isEmpty()&& !password.getText().toString().isEmpty()){
                    Intent intent = new Intent(Login_activity.this, MainActivity.class);
                    intent.putExtra("email", email.getText().toString());

                    startActivity(intent);

                }
            });





            return insets;
        });
    }
}