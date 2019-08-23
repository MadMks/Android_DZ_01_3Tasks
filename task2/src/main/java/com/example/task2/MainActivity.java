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

    private LinearLayout LL;

    private float startX;
    private float startY;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.LL = this.findViewById(R.id.ll1);

        LL.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {


                        switch (motionEvent.getAction()) {
                            case MotionEvent.ACTION_DOWN: // нажатие

                                startX = motionEvent.getX();
                                startY = motionEvent.getY();

                                break;
                            case MotionEvent.ACTION_MOVE: // движение


                                float x = motionEvent.getX();
                                float y = motionEvent.getY();

                                Direction direction = getDirection(startX, startY, x, y);

                                if (direction == Direction.DOWN || direction == Direction.UP){
                                    LL.setBackgroundColor(Color.YELLOW);
                                }
                                else if (direction == Direction.LEFT || direction == Direction.RIGHT){
                                    LL.setBackgroundColor(Color.GREEN);
                                }
                                else {
                                    LL.setBackgroundColor(Color.RED);
                                }

                                break;
                            case MotionEvent.ACTION_UP: // отпускание
                            case MotionEvent.ACTION_CANCEL:

                                break;
                        }

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

    public Direction getDirection(float x1, float y1, float x2, float y2) {
        double angle = getAngle(x1, y1, x2, y2);
        return Direction.get(angle);
    }

    public double getAngle(float x1, float y1, float x2, float y2) {
        double rad = Math.atan2(y1 - y2, x2 - x1) + Math.PI;
        return (rad * 180 / Math.PI + 180) % 360;
    }

    public enum Direction {
        NOT_DETECTED,
        UP,
        DOWN,
        LEFT,
        RIGHT,
        DIAGONAL;

        public static Direction get(double angle) {
//            if (inRange(angle, 45, 135)) {
//                return Direction.UP;
//            } else if (inRange(angle, 0, 45) || inRange(angle, 315, 360)) {
//                return Direction.RIGHT;
//            } else if (inRange(angle, 225, 315)) {
//                return Direction.DOWN;
//            } else {
//                return Direction.LEFT;
//            }

            if (inRange(angle, 65, 115)) {
                return Direction.UP;
            } else if (inRange(angle, 0, 25) || inRange(angle, 335, 360)) {
                return Direction.RIGHT;
            } else if (inRange(angle, 245, 295)) {
                return Direction.DOWN;
            } else if (inRange(angle, 155, 205)){
                return Direction.LEFT;
            } else{
                return Direction.DIAGONAL;
            }
        }

        private static boolean inRange(double angle, float init, float end) {
            return (angle >= init) && (angle < end);
        }
    }
}



