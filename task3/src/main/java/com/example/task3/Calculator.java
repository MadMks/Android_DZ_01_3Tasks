package com.example.task3;

import android.util.Log;
import android.widget.TextView;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Calculator {

    private final static String TAG = "=== Calculator ";

    private LinkedList<Integer> numbers;
    private LinkedList<String> signs;
    private TextView textView;

    public Calculator(TextView textViewForScreen) {
        this.textView = textViewForScreen;

        numbers = new LinkedList<>();
        signs = new LinkedList<>();

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
        if (signs != null){
            signs.addLast(sign);
            Log.d(TAG, "added sign: " + signs.peekLast());
        }
    }

    public String getResult() {

        // Если элементов меньше 2х
        if (numbers.size() < 2){
            if (numbers.size() == 0) return "0";
            else return Integer.toString(numbers.pollFirst());
        }

        // TODO метод не нужен (лишние знаки не используются)
        // Если после знака нажали =
        if (numbers.size() == signs.size()) {
            // Удалим последний (не используемый знак)
            signs.removeLast();
        }

        int result = 0;
        boolean isFirstCalculation = true;
        // TODO Производим вычисления
        while (numbers.size() != 0) {
            if (!isFirstCalculation){
                numbers.addFirst(result);
            }

            int a;
            int b;
            String s;
            if (numbers.size() > 1){
                a = numbers.pollFirst();
                b = numbers.pollFirst();
                s = signs.pollFirst();

                // Проверка деления на 0
                if ((s == "/") && (b == 0)) {
                    // TODO в верхнюю (дополнительную) строку дописать "Деление на ноль"
                    return "Невозможно";
                }

                result = compute(a, s, b);
            }


            isFirstCalculation = false;
        }

        return Integer.toString(result);
    }

    private int compute(int a, String sign, int b) {

        int result = 0;

        switch (sign){
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
        }

        return result;
    }
}
