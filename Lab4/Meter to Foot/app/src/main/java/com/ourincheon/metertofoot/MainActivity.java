package com.ourincheon.metertofoot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton meterBtn, feetBtn;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meterBtn = (RadioButton)findViewById(R.id.meterBtn);
        feetBtn = (RadioButton)findViewById(R.id.feetBtn);
        editText = (EditText)findViewById(R.id.edit_Input);

        final Button clearButton = (Button)findViewById(R.id.btn_clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
            }
        });

        final Button convertButton = (Button)findViewById(R.id.btn_convert);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = editText.getText().toString();
                if(s.length()>0){
                    double value = Double.parseDouble(s);
                    if(meterBtn.isChecked()){
                        convertMeterToFoot(value);
                    } else if(feetBtn.isChecked()){
                        convertFootToMeter(value);
                    }
                } else {
                    Toast.makeText(getApplicationContext(),
                            "정확한 값을 입력하세요",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void convertMeterToFoot(double meter){
        double foot = meter*3.28084;
        editText.setText("Meter : " + meter +"m" + " --> Foot : "
        + String.format("%.1f", foot)+ "feet");
    }

    private  void convertFootToMeter(double foot){
        double meter = foot*0.3048;
        editText.setText("Foot : " + foot +"ft" + " --> Meter : "
                + String.format("%.1f", meter)+ "meter");
    }
}
