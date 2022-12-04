package com.example.health;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class BMIActivity extends AppCompatActivity {

    private TextView bmiView;
    private TextView bmrView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);

        bmiView = findViewById(R.id.bmi);
        bmrView = findViewById(R.id.bmr);

        double bmi = getIntent().getDoubleExtra("bmi",0.0);
        bmiView.setText(String.format("Bmi = %.2f",bmi));

        double bmr = getIntent().getDoubleExtra("bmr",0.0);
        bmrView.setText(String.format("Bmr = %.2f",bmr));



    }
}