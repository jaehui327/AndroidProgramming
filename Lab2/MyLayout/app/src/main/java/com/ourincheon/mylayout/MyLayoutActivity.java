package com.ourincheon.mylayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class MyLayoutActivity extends AppCompatActivity {

    private final static float myEditTextWidth = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button myButton = new Button(this);
        myButton.setText("Press Me");
        myButton.setAllCaps(false);
        myButton.setBackgroundColor(Color.YELLOW);
        myButton.setGravity(1);

        RelativeLayout myLayout = new RelativeLayout(this);
        myLayout.setBackgroundColor(Color.BLUE);

        EditText myEditText = new EditText(this);

        myButton.setId(R.id.buttonId);
        //myButton.setId(View.generateViewId());

        myEditText.setId(R.id.editTextId);
        //myEditText.setId(View.generateViewId());



//        float pxs = TypedValue.applyDimension(
//                TypedValue.COMPLEX_UNIT_DIP,
//                myEditTextWidth,
//                getResources().getDisplayMetrics());
//        myEditText.setWidth((int)pxs);

//        float pxs = myEditTextWidth * getResources().getDisplayMetrics().density;
//        myEditText.setWidth((int)pxs);

        myEditText.setWidth((int) getResources().getDimension(R.dimen.widthSize));


        RelativeLayout.LayoutParams buttomParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        buttomParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttomParams.addRule(RelativeLayout.CENTER_VERTICAL);

        RelativeLayout.LayoutParams textParams
                = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        textParams.setMargins(0,0,0,80);
        textParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        textParams.addRule(RelativeLayout.ABOVE, myButton.getId());

        myLayout.addView(myButton, buttomParams);
        myLayout.addView(myEditText, textParams);
        setContentView(myLayout);


    }
}
