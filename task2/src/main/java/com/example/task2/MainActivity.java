package com.example.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvX;
    private TextView tvY;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tvX = this.findViewById(R.id.tvX);
        this.tvY = this.findViewById(R.id.tvY);

        LinearLayout LL = this.findViewById(R.id.ll1);

        LL.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {

                        int action = motionEvent.getAction();

                        float x = motionEvent.getX();
                        float y = motionEvent.getY();

                        String textX = "X = ";
                        String textY = "Y = ";
                        String text = "";
//
                        if (action == MotionEvent.ACTION_MOVE){
                            text += "Перемещение: (" + action + ")" + "\n";
                        }


                        text += "X = " + x + "\nY = " + y;

                        MainActivity.this.tvX.setText(text);

                        return false;
                    }
                }
        );

        LL.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }
        );
    }
}
