package com.geek.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editText;
    private EditText editText2;
    private TextView textView;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.peredelka);
        button = findViewById(R.id.buttonPanel);
        editText = findViewById(R.id.et_email);
        editText2 = findViewById(R.id.password);
        textView = findViewById(R.id.tv_welcome);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Пожалуйста ввидите вашу почту!", Toast.LENGTH_LONG).show();
                } if (editText2.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Пожалуйста ввидите ваш пароль!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Добро пожаловать!", Toast.LENGTH_LONG).show();
                    name = editText.getText().toString();
                    if (!name.equals("")){
                        textView.setText("Добро пожаловать \n" + name +" !");}
                    button.setBackground(getDrawable(R.drawable.but));
                }
            }
        });
    }

}