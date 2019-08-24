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

    // Кнопки
    private Button btnC;

    private Button btn1;
    private Button btn2;

    private Button btnPlus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvScreen = this.findViewById(R.id.calc_screen);
        this.calculator = new Calculator(tvScreen);

        // Присваиваем кнопки по id
        this.btnC = this.findViewById(R.id.btn_C);

        this.btn1 = this.findViewById(R.id.btn_1);
        this.btn2 = this.findViewById(R.id.btn_2);

        this.btnPlus = this.findViewById(R.id.btn_plus);

        // Значение экрана по умолчанию
        tvScreen.setText("0");

        // Один обработчик для всех нажатий
        // TODO: переделать на несколько обработчиков
        View.OnClickListener onClickListener = new View.OnClickListener() {
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
                    case R.id.btn_1:
                    case R.id.btn_2:
                        // TODO отобразить на экране
                        String str = "0";
                        Log.d(TAG, "tvScreen: " + tvScreen.getText().toString());
                        if (tvScreen.getText() != "0"){
                            str = tvScreen.getText().toString() +
                                    clickBtn.getText().toString();
                        }
                        else{
                            str = clickBtn.getText().toString();
                        }
                        tvScreen.setText(str);
                        Log.d(TAG, "tvScreen: " + tvScreen.getText().toString());
                        break;
                        // + - * /
                    case R.id.btn_plus:

                        // TODO записать число и знак
                        Integer num = Integer.parseInt(tvScreen.getText().toString());
                        String sign = clickBtn.getText().toString();


                        calculator.setNumber(num);
//                        calculator.setSign(sign);

                        // Вывести на табло 0
                        tvScreen.setText("0");
                        break;
                }
            }
        };


        btnC.setOnClickListener(onClickListener);

        btn1.setOnClickListener(onClickListener);
        btn2.setOnClickListener(onClickListener);

        btnPlus.setOnClickListener(onClickListener);
    }
}
