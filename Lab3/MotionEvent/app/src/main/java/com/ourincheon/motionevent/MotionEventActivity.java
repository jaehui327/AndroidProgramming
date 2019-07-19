package com.ourincheon.motionevent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MotionEventActivity extends AppCompatActivity {

    void handleTouch (MotionEvent m){
        TextView textView1 = (TextView)findViewById(R.id.textView);
        TextView textView2 = (TextView)findViewById(R.id.textView2);

        int pointerCount = m.getPointerCount();

        for (int i=0; i<pointerCount; i++){
            int x = (int)m.getX();
            int y = (int)m.getY();
            int id = m.getPointerId(i);
            int action = m.getActionMasked();
            int actionIndex = m.getActionIndex();
            String actionString;

            switch (action){
                case MotionEvent.ACTION_DOWN:
                    actionString = "DOWN";
                    break;
                case MotionEvent.ACTION_UP:
                    actionString = "UP";
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    actionString = "PNTR DOWN";
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    actionString = "PNTR UP";
                    break;
                case MotionEvent.ACTION_MOVE:
                    actionString = "MOVE";
                    break;
                default:
                    actionString = "";
            }

            String touchStatus = "Action: " + actionString +
                    " Index: " + actionIndex
                    + " ID: " + id + " X: " + x + " Y: " + y;

            if (id == 0)
                textView1.setText(touchStatus);
            else
                textView2.setText(touchStatus);
        }
        Log.i(this.getClass().getName(), "pointerCount: " + pointerCount);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion_event);

        RelativeLayout myLayout =
                (RelativeLayout)findViewById(R.id.RelativeLayout1);
        myLayout.setOnTouchListener(
                new RelativeLayout.OnTouchListener() {
                    @Override
                    public boolean onTouch(
                            View v, MotionEvent m) {
                        handleTouch(m);
                        return true;
                    }
                }
        );

    }



}
