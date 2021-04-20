package com.geek.myapplication4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.state.State;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class calculator extends AppCompatActivity {

    private CalculatorModel calculatorModel;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        int[] numberIds = new int[]{
                R.id.ac0,
                R.id.ac1,
                R.id.ac2,
                R.id.ac3,
                R.id.ac4,
                R.id.ac5,
                R.id.ac6,
                R.id.ac7,
                R.id.ac8,
                R.id.ac9,

        };
        int[] actionsIdc = new int[]{
                R.id.division,
                R.id.multiply,
                R.id.minus,
                R.id.plus,
                R.id.equals,
        };

        textView = findViewById(R.id.text);

        calculatorModel = new CalculatorModel();

        View.OnClickListener numberButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorModel.onNumPressed(view.getId());
                textView.setText(calculatorModel.getText());

            }
        };

        View.OnClickListener actionButtonOnclickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorModel.onActionPressed(view.getId());
                textView.setText(calculatorModel.getText());

            }
        };

        for (int i = 0; i < numberIds.length; i++) {
            findViewById(numberIds[i]).setOnClickListener(numberButtonClickListener);
        }

        for (int i = 0; i < actionsIdc.length; i++) {
            findViewById(actionsIdc[i]).setOnClickListener(actionButtonOnclickListener);
        }

        findViewById(R.id.ac).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorModel.reset();
                textView.setText(calculatorModel.getText());
            }
        });

    }
}




















