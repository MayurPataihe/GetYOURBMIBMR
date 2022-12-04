package com.example.health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private Button checkButton;
    private TextInputEditText ageET,heightET,weightET;
    private RadioGroup genderGroup;

    private String selectedGender = "FEMALE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkButton = findViewById( R.id.checkBtn);
        ageET = findViewById(R.id.ageEdittext);
        heightET = findViewById(R.id.heightEdittext);
        weightET = findViewById(R.id.weightEdittext);
        genderGroup = findViewById(R.id.genderRadioGroup);

        genderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton selectedRadioButton = findViewById( i);
                selectedGender = selectedRadioButton.getText().toString();
            }
        });

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ageStr = ageET.getText().toString();
                double age = Double.parseDouble(ageStr);

                try {
                    if (13 > age || age > 150) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException numberFormatException){
                    Toast.makeText(MainActivity.this, "Input Invalid", Toast.LENGTH_SHORT).show();
                            return;
                }


                String heightStr = heightET.getText().toString();
                double height = Double.parseDouble(heightStr);

                String weightStr = weightET.getText().toString();
                double weight = Double.parseDouble(weightStr);

                double bmi = weight / ((height/100)*(height/100));

                double bmr = 0;
                if( selectedGender.equals( "MALE")) {
                    bmr = 88.362 + ( 13.396 * weight) + ( 4.799 * height) - ( 5.677 * age);
                } else {
                    bmr = 447.593 + ( 9.247 * weight) + ( 3.098 * height) - ( 4.330 * age);
                }

                Intent intent = new Intent(getApplicationContext(),BMIActivity.class);
                intent.putExtra( "bmi",bmi);
                intent.putExtra("bmr",bmr);
                startActivity(intent);
            }

        });
    }

}