package com.geek.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editText;
    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.peredelka);
        button = findViewById(R.id.buttonPanel);
        editText = findViewById(R.id.et_email);
        editText2 = findViewById(R.id.password);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().equals("") || editText2.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Пожалуйста ввидите данные!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Добро пожаловать!", Toast.LENGTH_LONG).show();
                    button.setBackground(getDrawable(R.drawable.but));
                }
            }
        });
    }

}