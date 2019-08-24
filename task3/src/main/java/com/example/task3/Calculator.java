package com.example.task3;

import android.util.Log;
import android.widget.TextView;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Calculator {

    private final static String TAG = "=== Calculator ";

    private LinkedList<Integer> numbers;
    private Deque<String> signs;
    private TextView textView;

    public Calculator(TextView textViewForScreen) {
        this.textView = textViewForScreen;

        numbers = new LinkedList<Integer>();

        Log.d(TAG, "Constructor");
    }

    public void setNumber(int digit) {
        Log.d(TAG, "added number (до): " + numbers.peekLast());
        if (numbers != null){
            numbers.addLast(digit);
            Log.d(TAG, "added number (после): " + numbers.peekLast());
        }
    }

    public void setSign(String sign) {
        signs.addLast(sign);
        Log.d(TAG, "added sign: " + signs.peekLast());
    }
}
