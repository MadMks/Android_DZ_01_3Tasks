package com.example.task3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Calculator calculator;
    private TextView tvScreen;

    // Кнопки
    private Button btn1;
    private Button btn2;

    public MainActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvScreen = this.findViewById(R.id.calc_screen);
        this.calculator = new Calculator(tvScreen);

        // Присваиваем кнопки по id
        this.btn1 = this.findViewById(R.id.btn_1);
        this.btn2 = this.findViewById(R.id.btn_2);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Button clickBtn = findViewById(view.getId());

                switch (view.getId()){
                    case R.id.btn_1:
                    case R.id.btn_2:
                        tvScreen.setText("Нажата цифра" + clickBtn.getText());
                        break;
                }
            }
        };

        btn1.setOnClickListener(onClickListener);
        btn2.setOnClickListener(onClickListener);
    }
}
