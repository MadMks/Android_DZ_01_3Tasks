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


        LL.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {

                        x = motionEvent.getX();
                        y = motionEvent.getY();

                        tvX.setText("_");
                        tvY.setText("_");

                        int margin = 50;

                        switch (motionEvent.getAction()) {
                            case MotionEvent.ACTION_DOWN: // нажатие
                                sDown = "Down: " + x + "," + y;
                                sMove = ""; sUp = "";
                                oldX = motionEvent.getX();
                                oldY = motionEvent.getY();
                                break;
                            case MotionEvent.ACTION_MOVE: // движение
                                sMove = "Move: " + x + "," + y;

                                if (
                                    (x > oldX + 20 || x < oldX - 20)
                                    && (
                                        y > (oldY - margin)
                                        &&
                                        y < (oldY + margin)
                                    )
                                ){
//                                    oldX = motionEvent.getX();
                                    tvX.setText("Движение по X" + "___ cntX=" + cntX);
                                }

                                if (
                                    (y > oldY + 20 || y < oldY - 20)
                                    && (
                                        x > (oldX - margin)
                                        &&
                                        x < (oldX + margin)
                                        )
                                ) {
//                                    oldY = motionEvent.getY();
                                    tvY.setText("Движение по Y");
                                }

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
