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

    private TextView tv;
    private TextView tvX;
    private TextView tvY;

    private float x = 0;
    private float y = 0;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tv = this.findViewById(R.id.tv);
        this.tvX = this.findViewById(R.id.tvX);
        this.tvY = this.findViewById(R.id.tvY);

        LinearLayout LL = this.findViewById(R.id.ll1);

        LL.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {

                        int action = motionEvent.getAction();

                        float tempX = motionEvent.getX();
                        float tempY = motionEvent.getY();

                        String textX = "X = ";
                        String textY = "Y = ";
                        String textTV = "_";
                        String text = "";
//
                        if (action == MotionEvent.ACTION_MOVE){

                            
                            if (
                                    (tempX != x) && (tempY != y)
                                    && (
                                            (tempY < y - 4) || (tempY > y + 4)
                                            &&
                                            (tempX < x - 4) || (tempX > x + 4)
                                            )
                            ){
                                textTV += "Перемещение по диагонали";
                            }
                            else if (
                                    (tempX != x)
                                    && ((tempY > y - 3) && (tempY < y + 3))
                            ) {
                                textTV += "Перемещение по X: ";
                            }
                            else if (
                                    (tempX != y)
                                            && ((tempX > x - 3) && (tempX < x + 3))
                            ) {
                                textTV += "Перемещение по Y: ";
                            }


                            x = tempX;
                            y = tempY;
                        }


                        text += "tempX = " + tempX + "\ntempY = " + tempY;

                        MainActivity.this.tv.setText(textTV);
                        MainActivity.this.tvX.setText(text);
                        MainActivity.this.tvY.setText("x = " + x + "\ny = " + y);

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
