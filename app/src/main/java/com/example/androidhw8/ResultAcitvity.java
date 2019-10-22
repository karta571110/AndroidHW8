package com.example.androidhw8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultAcitvity extends AppCompatActivity {

    String diagnosis;
    Double BMIcal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_acitvity);

        TextView BMIresult = (TextView) findViewById(R.id.BMIresult);
        TextView checkresult = (TextView) findViewById(R.id.checkresult);
        Button againbtn=(Button)findViewById(R.id.again);
        Intent BMI = getIntent();
        BMIcal = BMI.getDoubleExtra("BMI", 0);

        BMIcal = Math.round(BMIcal * 100.0) / 100.0;
        BMIresult.setText("你的BMI是:" + BMIcal);
        if (BMIcal < 18.5) {
            diagnosis = "體重過輕(異常)";

        }
        if (BMIcal >= 18.5 && BMIcal < 24) {
            diagnosis = "正常";
        }
        if (BMIcal >= 24 && BMIcal < 27) {
            diagnosis = "體重過重(異常)";
        }
        if (BMIcal >= 27 && BMIcal < 30) {
            diagnosis = "輕度肥胖(異常)";
        }
        if (BMIcal >= 30 && BMIcal < 35) {
            diagnosis = "中度肥胖(異常)";
        }
        if (BMIcal >= 35) {
            diagnosis = "重度肥胖(異常)";
        }
        checkresult.setText("診斷結果:" + diagnosis);
    againbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent BtoA = new Intent(ResultAcitvity.this, MainActivity.class);
            startActivity(BtoA);

        }
    });
    }
}
