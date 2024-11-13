package com.demo.optimizedjavademo;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText textInput = findViewById(R.id.etInput);
        AppCompatButton btnCalculate = findViewById(R.id.btnCalculate);
        TextView txtNaiveResult = findViewById(R.id.tvResult1);
        TextView txtLoopResult = findViewById(R.id.tvResult2);

        btnCalculate.setOnClickListener(v -> {
            String input = textInput.getText().toString();
            if (input.isEmpty()) {
                textInput.setError("Please enter a number");
                return;
            }
            int number = Integer.parseInt(input);

            // Calculate Fibonacci number using naive approach
            long startTime = System.currentTimeMillis();
//            long resultNaive = calculateFibonacciWithNaiveApproach(number);
//            long endTimeNaive = System.currentTimeMillis();
//            long timeTakenNaive = endTimeNaive - startTime;
//            String resultNaiveText = getString(R.string.naive_fibonacci) + resultNaive + getString(R.string.text_calculate_time) + timeTakenNaive + getString(R.string.ms);
//            txtNaiveResult.setText(resultNaiveText);

            // Calculate Fibonacci number recursively with loop
            long resultLoop = computeRecursivelyWithLoop(number);
            long endTimeLoop = System.currentTimeMillis();
            long timeTakenLoop = endTimeLoop - startTime;
            String resultLoopText = getString(R.string.text_calculate_recursively_with_loop) + resultLoop + getString(R.string.text_calculate_time) + timeTakenLoop + getString(R.string.ms);
            txtLoopResult.setText(resultLoopText);
        });

    }

    private long calculateFibonacciWithNaiveApproach(int number) {
        if (number <= 1) {
            return number;
        }
        return calculateFibonacciWithNaiveApproach(number - 1) + calculateFibonacciWithNaiveApproach(number - 2);
    }

    private long computeRecursivelyWithLoop(int n) {
        if (n > 1) {
            long result = 1;
            do {
                result += computeRecursivelyWithLoop(n - 2);
                n--;
            } while (n > 1);
            return result;
        }
        return n;
    }
}