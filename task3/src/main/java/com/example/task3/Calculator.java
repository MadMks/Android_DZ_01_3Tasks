package com.example.task3;

import android.util.Log;
import android.widget.TextView;

import java.util.Deque;

public class Calculator {

    private final static String TAG = "=== Calculator ";

    private Deque numbers;
    private Deque<String> signs;
    private TextView textView;

    public Calculator(TextView textViewForScreen) {
        this.textView = textViewForScreen;
    }

    public void setNumber(int digit) {
        numbers.addLast(digit);
        Log.d(TAG, "added number: " + numbers.peekLast());
    }

    public void setSign(String sign) {
        signs.addLast(sign);
        Log.d(TAG, "added sign: " + signs.peekLast());
    }
}
