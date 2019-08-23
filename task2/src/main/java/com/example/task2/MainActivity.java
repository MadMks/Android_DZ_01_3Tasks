package com.example.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
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
    private TextView tvoldX;
    private TextView tvoldY;
    private TextView tvD;

    private LinearLayout LL;


    float x;
    float y;
    String sDown;
    String sMove;
    String sUp;

    private float oldX;
    private float oldY;

    private int cntX;
    private int cntY;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tv = this.findViewById(R.id.tv);
        this.tvX = this.findViewById(R.id.tvX);
        this.tvY = this.findViewById(R.id.tvY);

        this.LL = this.findViewById(R.id.ll1);

        this.tvoldX = this.findViewById(R.id.oldX);
        this.tvoldY = this.findViewById(R.id.oldY);
        this.tvD = this.findViewById(R.id.tvD);


        LL.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {

                        x = motionEvent.getX();
                        y = motionEvent.getY();

                        tvX.setText("_");
                        tvY.setText("_");

                        tvoldX.setText("_");
                        tvoldY.setText("_");
                        tvD.setText("=");

                        boolean is1 = false;


                        int margin = 100;

                        switch (motionEvent.getAction()) {
                            case MotionEvent.ACTION_DOWN: // нажатие
                                sDown = "Down: " + x + "," + y;
                                sMove = ""; sUp = "";
                                oldX = motionEvent.getX();
                                oldY = motionEvent.getY();

                                tvoldX.setText("oldX - " + oldX);
                                tvoldX.setText("oldY - " + oldY);
                                break;
                            case MotionEvent.ACTION_MOVE: // движение
                                sMove = "Move: " + x + "," + y;



                                // Если движение по X
                                if (
                                    (x > oldX + 50 || x < oldX - 50) // в любую сторону по Х от нажатия
                                    && (
                                        y > (oldY - margin)
                                        &&
                                        y < (oldY + margin)
                                    )
                                ){
//                                    oldX = motionEvent.getX();
                                    tvX.setText("Движение по X");
                                }
                                // Сброс oldX при превышении допустимого отступа от Y для движения
//                                else if (y < (oldY - margin) || y > (oldY + margin)){
//                                    oldY = motionEvent.getY();
//                                    tvoldY.setText("oldY - " + oldY);
//                                }


                                // Если движение по Y
                                 if (
                                    (y > oldY + 50 || y < oldY - 50) // в любую сторону по Y от нажатия
                                    && (
                                        x > (oldX - margin)
                                        &&
                                        x < (oldX + margin)
                                        )
                                ) {
//                                    oldY = motionEvent.getY();
                                    tvY.setText("Движение по Y");
                                }
                                // Сброс oldY при превышении допустимого отступа от X для движения
//                                else if (x < (oldX - margin) || x > (oldX + margin)){
////                                    oldX = motionEvent.getX();
////                                    tvoldX.setText("oldX - " + oldX);
//                                    is1 = true;
//                                }
//                                else {
//                                    tvD.setText("=== По диагонали");
//                                }







                                break;
                            case MotionEvent.ACTION_UP: // отпускание
                            case MotionEvent.ACTION_CANCEL:
                                sMove = "";
                                sUp = "Up: " + x + "," + y;
                                break;
                        }
                        tv.setText(sDown + "\n" + sMove + "\n" + sUp);

                        return true;
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
