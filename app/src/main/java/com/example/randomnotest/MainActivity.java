package com.example.randomnotest;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tvFirst,tvSecond;
    Button btnReload,btnClear;

    EditText edtAdd,edtSub,edtMult,edtDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvFirst = (TextView) findViewById(R.id.tvFirst);
        tvSecond = (TextView) findViewById(R.id.tvSecond);

        btnReload = (Button) findViewById(R.id.btnReload);
        btnClear = (Button)findViewById(R.id.btnClear);

        edtAdd = (EditText)findViewById(R.id.edtAdd);
        edtSub = (EditText)findViewById(R.id.edtSub);
        edtMult = (EditText)findViewById(R.id.edtMult);
        edtDiv = (EditText)findViewById(R.id.edtDiv);

        btnReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reload();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtAdd.setText("");
                edtSub.setText("");
                edtMult.setText("");
                edtDiv.setText("");
            }
        });

        edtAdd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int a,b,ans;

                a = Integer.parseInt(tvFirst.getText().toString());
                b = Integer.parseInt(tvSecond.getText().toString());

                ans = Integer.parseInt(edtAdd.getText().toString().isEmpty() ? "0":
                        edtAdd.getText().toString());

                if((a+b) == ans){
                    edtAdd.setTextColor(Color.parseColor("#00ff00"));
                }else{
                    edtAdd.setTextColor(Color.parseColor("#ff0000"));
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edtSub.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int a,b,ans;

                a = Integer.parseInt(tvFirst.getText().toString());
                b = Integer.parseInt(tvSecond.getText().toString());

                ans = Integer.parseInt(edtSub.getText().toString().isEmpty() ? "0" :
                        edtSub.getText().toString());

                if((a-b) == ans){
                    edtSub.setTextColor(Color.parseColor("#00ff00"));
                }else{
                    edtSub.setTextColor(Color.parseColor("#ff0000"));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        edtMult.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int a,b,ans;

                a = Integer.parseInt(tvFirst.getText().toString());
                b = Integer.parseInt(tvSecond.getText().toString());

                ans = Integer.parseInt(edtMult.getText().toString().isEmpty() ? "0" :
                        edtMult.getText().toString());

                if((a*b) == ans){
                    edtMult.setTextColor(Color.parseColor("#00ff00"));
                }else{
                    edtMult.setTextColor(Color.parseColor("#ff0000"));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edtDiv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                double a,b;
                double ans;

                a = Double.parseDouble(tvFirst.getText().toString());
                b = Double.parseDouble(tvSecond.getText().toString());

                ans = Double.parseDouble(edtDiv.getText().toString().isEmpty() ? "0" :
                        edtDiv.getText().toString());

                if(Double.parseDouble(String.format("%.6f",(a/b))) == ans){
                    edtDiv.setTextColor(Color.parseColor("#00ff00"));
                }else{
                    edtDiv.setTextColor(Color.parseColor("#ff0000"));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        reload();

    }

    void reload(){
        Random r = new Random();
        tvFirst.setText(""+r.nextInt(100));
        tvSecond.setText(""+r.nextInt(100));
    }
}