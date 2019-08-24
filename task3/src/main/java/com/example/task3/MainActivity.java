package com.example.task3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "=== MainActivity ";

    private Calculator calculator;
    private TextView tvScreen;

    // === Кнопки
    // Элементы управления.
    private Button btnC;
    private Button btnBackspace;
    // Цифры.
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    // Знаки.
    private Button btnPlus;
    private Button btnMinus;
    private Button btnMultiply;
    private Button btnDivide;
    private Button btnEqually;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvScreen = this.findViewById(R.id.calc_screen);
        this.calculator = new Calculator(tvScreen);

        // === Присваиваем полям кнопки по id
        // Элементы управления
        this.btnC = this.findViewById(R.id.btn_C);
        this.btnBackspace = this.findViewById(R.id.btn_backspace);
        // Цифры.
        this.btn0 = this.findViewById(R.id.btn_0);
        this.btn1 = this.findViewById(R.id.btn_1);
        this.btn2 = this.findViewById(R.id.btn_2);
        this.btn3 = this.findViewById(R.id.btn_3);
        this.btn4 = this.findViewById(R.id.btn_4);
        this.btn5 = this.findViewById(R.id.btn_5);
        this.btn6 = this.findViewById(R.id.btn_6);
        this.btn7 = this.findViewById(R.id.btn_7);
        this.btn8 = this.findViewById(R.id.btn_8);
        this.btn9 = this.findViewById(R.id.btn_9);
        // Знаки.
        this.btnPlus = this.findViewById(R.id.btn_plus);
        this.btnMinus = this.findViewById(R.id.btn_minus);
        this.btnMultiply = this.findViewById(R.id.btn_multiply);
        this.btnDivide = this.findViewById(R.id.btn_divide);
        this.btnEqually = this.findViewById(R.id.btn_equally);


        // Значение экрана по умолчанию
        tvScreen.setText("0");

        // === Обработчики

        // Элементы управления.
        View.OnClickListener onClickControlsListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Button clickBtn = findViewById(view.getId());

                // Log
                Log.d(TAG, "onClick " + clickBtn.getText());

                switch (view.getId()){
                    case R.id.btn_C:
                        // Вывести ноль на экран
                        tvScreen.setText("0");
                        // Обнуляем массивы
                        calculator.clearLists();
                        break;
                    case R.id.btn_backspace:
                        // TODO удалить последний символ с табло

                        break;
                }
            }
        };

        // Цифры.
        View.OnClickListener onClickNumberListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Button clickBtn = findViewById(view.getId());

                // Log
                Log.d(TAG, "onClickNumberListener " + clickBtn.getText());

                // Отображение на табло
                String tempStr;
                Log.d(TAG, "tvScreen: " + tvScreen.getText().toString());

                if (tvScreen.getText() != "0"){
                    tempStr = tvScreen.getText().toString() +
                            clickBtn.getText().toString();
                }
                else{
                    tempStr = clickBtn.getText().toString();
                }
                tvScreen.setText(tempStr);
                Log.d(TAG, "tvScreen: " + tvScreen.getText().toString());
            }
        };

        // Знаки.
        View.OnClickListener onClickSignListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Button clickBtn = findViewById(view.getId());

                // Log
                Log.d(TAG, "onClickSignListener " + clickBtn.getText());

                // Записиваем число и знак
                Integer num = Integer.parseInt(tvScreen.getText().toString());
                String sign = clickBtn.getText().toString();
                Log.d(TAG, "num = " + num);
                calculator.setNumber(num);
                calculator.setSign(sign);

                // TODO если нажать 2 знака подряд - второй перезапишет предыдущий


                // Действия:
                switch (view.getId()){
                    case R.id.btn_plus:
                    case R.id.btn_minus:
                    case R.id.btn_multiply:
                    case R.id.btn_divide:

                        // Вывести на табло 0
                        tvScreen.setText("0");
                        // TODO вывести знак на доп. строку на табло.
                        break;
                    case R.id.btn_equally:
                        // Вывести на табло результат вычисления
                        tvScreen.setText(calculator.getResult());
                        calculator.clearLists();
                        break;
                }
            }
        };


        // === Добавление обработчиков кнопкам.

        // Элементы управления.
        btnC.setOnClickListener(onClickControlsListener);
        btnBackspace.setOnClickListener(onClickControlsListener);   // TODO

        // Цифры.
        btn0.setOnClickListener(onClickNumberListener); // TODO
        btn1.setOnClickListener(onClickNumberListener);
        btn2.setOnClickListener(onClickNumberListener);
        btn3.setOnClickListener(onClickNumberListener);
        btn4.setOnClickListener(onClickNumberListener);
        btn5.setOnClickListener(onClickNumberListener);
        btn6.setOnClickListener(onClickNumberListener);
        btn7.setOnClickListener(onClickNumberListener);
        btn8.setOnClickListener(onClickNumberListener);
        btn9.setOnClickListener(onClickNumberListener);

        // Знаки.
        btnPlus.setOnClickListener(onClickSignListener);
        btnMinus.setOnClickListener(onClickSignListener);
        btnMultiply.setOnClickListener(onClickSignListener);
        btnDivide.setOnClickListener(onClickSignListener);
        btnEqually.setOnClickListener(onClickSignListener);
    }

}
