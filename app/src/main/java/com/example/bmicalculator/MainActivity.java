package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView result;
        EditText editWeight,editHeight_ft,editHeight_in;
        Button calculate_button;

        calculate_button = findViewById(R.id.calculate_button);
        editWeight = findViewById(R.id.editWeight);
        editHeight_in = findViewById(R.id.editHeight_in);
        editHeight_ft = findViewById(R.id.editHeight_ft);
        result = findViewById(R.id.txtresult);
        LinearLayout Lmain = findViewById(R.id.Lmain);

        calculate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int weight = Integer.parseInt(editWeight.getText().toString());
                int height_IN_feet = Integer.parseInt(editHeight_ft.getText().toString());
                int height_IN_inches = Integer.parseInt(editHeight_in.getText().toString());

                int total_inches = height_IN_feet*12 + height_IN_inches;
                double total_cm = total_inches*2.53;
                double total_m = total_cm/100;
                double body_mass_index = weight/Math.pow(total_m,2);
                
                if(body_mass_index>25) {
                    result.setText(R.string.more_than_25);
                    Lmain.setBackgroundColor(getResources().getColor(R.color.overweight));
                } else if (body_mass_index<18) {
                    result.setText(R.string.less_than_18);
                    Lmain.setBackgroundColor(getResources().getColor(R.color.underweight));
                } else {
                    result.setText(R.string.between_18_25);
                    Lmain.setBackgroundColor(getResources().getColor(R.color.healthy));
                }
            }
        });
    }
}