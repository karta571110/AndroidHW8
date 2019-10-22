package com.example.androidhw8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText high = (EditText) findViewById(R.id.higheditText);
        final EditText weight = (EditText) findViewById(R.id.weighteditText);
        Button displayresult = (Button) findViewById(R.id.displayresult);

        displayresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!("".equals(high.getText().toString())) && !("".equals(weight.getText().toString()))) {
                    Double highvalue = Double.parseDouble(high.getEditableText().toString());
                    Double weightvalue = Double.parseDouble(weight.getEditableText().toString());
                    Double BMI;
                    highvalue = highvalue / 100;
                    BMI = weightvalue / Math.pow(highvalue, 2);

                    Intent AtoB = new Intent(MainActivity.this, ResultAcitvity.class);
                    AtoB.putExtra("BMI", BMI);
                    startActivity(AtoB);


                }
            }
        });
    }
}
