package com.example.bmi__;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_bmidisp;
    TextView tv_weight;
    TextView tv_height;
    TextView tv_bmi;
    TextView tv_bmicondition;
    EditText et_lb;
    EditText et_feet;
    EditText et_inches;
    Button bt_calculate;
    Double result;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("BMI CALCULATOR");

        tv_bmidisp = findViewById(R.id.tv_bmidisp);
        tv_weight = findViewById(R.id.tv_weight);
        tv_height = findViewById(R.id.tv_height);
        tv_bmi = findViewById(R.id.tv_bmi);
        tv_bmicondition = findViewById(R.id.tv_bmicondition);
        et_lb = findViewById(R.id.et_lb);
        et_feet = findViewById(R.id.et_feet);
        et_inches = findViewById(R.id.et_inches);
        bt_calculate = findViewById(R.id.bt_calculate);

        tv_bmidisp.setText("BMI CALCULATOR");
        tv_weight.setText("WEIGHT");
        tv_height.setText("HEIGHT");




        bt_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(et_lb.getText().toString().equals("")){
                    et_lb.setError("Hey I need a value!");
                }
                if(et_feet.getText().toString().equals("")){
                    et_feet.setError("Hey I need a value!");
                }
                if(et_inches.getText().toString().equals("")){
                    et_inches.setError("Hey I need a value!");
                }

               double length1 =  (Double.parseDouble(et_inches.getText().toString()));
               double length2 = (Double.parseDouble(et_feet.getText().toString()))*12;
               double length3 = length1 + length2;


            //result = ((Double.parseDouble(et_lb.getText().toString()))/((Double.parseDouble(et_inches.getText().toString())) * (Double.parseDouble(et_inches.getText().toString()))))*703;
                result = ((Double.parseDouble(et_lb.getText().toString()))/ (length3 * length3))*703;
            tv_bmi.setText("BMI IS:"+result+"");

                if (result <= 18.5) {
                    tv_bmicondition.setText("UnderWeight");
                }
                if (result >= 18.5 && result <= 24.9){
                    tv_bmicondition.setText("NormalWeight");
                }
                if (result >= 25 && result <= 29.9){
                    tv_bmicondition.setText("OverWeight");
                }
                if (result >= 30){
                    tv_bmicondition.setText("Obesity");
                }


           }
        });

    }
}
