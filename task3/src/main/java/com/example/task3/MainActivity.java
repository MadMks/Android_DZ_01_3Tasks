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
    private Button btn1;
    private Button btn2;
    // Знаки.
    private Button btnPlus;
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
        this.btn1 = this.findViewById(R.id.btn_1);
        this.btn2 = this.findViewById(R.id.btn_2);
        // Знаки.
        this.btnPlus = this.findViewById(R.id.btn_plus);
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
                        // TODO обнулить массивы
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

                // TODO записать число и знак
                Integer num = Integer.parseInt(tvScreen.getText().toString());
                String sign = clickBtn.getText().toString();


                calculator.setNumber(num);
                calculator.setSign(sign);
                // TODO если нажать 2 знака подряд - второй перезапишет предыдущий



                switch (view.getId()){
                    case R.id.btn_plus:
                        // Вывести на табло 0
                        tvScreen.setText("0");
                        break;
                    case R.id.btn_equally:
                        // Вывести на табло результат вычисления
                        tvScreen.setText(calculator.getResult());
                        break;
                }
            }
        };


        // === Добавление обработчиков кнопкам.

        // Элементы управления.
        btnC.setOnClickListener(onClickControlsListener);

        // Цифры.
        btn1.setOnClickListener(onClickNumberListener);
        btn2.setOnClickListener(onClickNumberListener);

        // Знаки.
        btnPlus.setOnClickListener(onClickSignListener);
        btnEqually.setOnClickListener(onClickSignListener);
    }

}
