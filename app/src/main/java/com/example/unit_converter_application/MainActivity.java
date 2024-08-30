package com.example.unit_converter_application;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputValue;
    private Spinner fromUnit, toUnit;
    private TextView resultView;
    private Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputValue = findViewById(R.id.inputValue);
        fromUnit = findViewById(R.id.fromUnit);
        toUnit = findViewById(R.id.toUnit);
        resultView = findViewById(R.id.resultView);
        convertButton = findViewById(R.id.convertButton);

        // Units to convert from and to
        String[] units = {"Centimeters", "Meters", "Grams", "Kilograms"};

        // Set adapters for spinners
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, units);
        fromUnit.setAdapter(adapter);
        toUnit.setAdapter(adapter);

        // Conversion button click listener
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performConversion();
            }
        });
    }

    // Method to perform the unit conversion
    private void performConversion() {
        String from = fromUnit.getSelectedItem().toString();
        String to = toUnit.getSelectedItem().toString();
        double input = Double.parseDouble(inputValue.getText().toString());
        double result = 0;

        // Example conversion logic
        if (from.equals("Centimeters") && to.equals("Meters")) {
            result = input / 100;
        } else if (from.equals("Meters") && to.equals("Centimeters")) {
            result = input * 100;
        } else if (from.equals("Grams") && to.equals("Kilograms")) {
            result = input / 1000;
        } else if (from.equals("Kilograms") && to.equals("Grams")) {
            result = input * 1000;
        } else {
            resultView.setText("Invalid Conversion");
            return;
        }

        resultView.setText(String.valueOf(result));
    }
}
