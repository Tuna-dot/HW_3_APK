package com.example.hw_3_apk;

import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private float a;
    private float b;
    private boolean isOperationClick;
    private String operation;
    

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
        textView = findViewById(R.id.text_view);

    }

    public void onNumberClick(View view) {
        String text = ((MaterialButton) view).getText().toString();
        if (text.equals("AC")) {
            textView.setText("0");
            a = 0;
            b = 0;
        } else if (text.equals("+/-")) {
            Float d = Float.parseFloat(textView.getText().toString());
            d = d * -1;
            if (d == Math.floor(d)){
                int intd = Math.round(d);
                textView.setText(String.valueOf(intd));
            }else {
                textView.setText(String.valueOf(d));
            }
        }else if (textView.getText().toString().equals("0") || isOperationClick) {
            textView.setText(text);
        } else {
            textView.append(text);



        }
        isOperationClick = false;
    }




    public void onOperationClick(View view) {
        if (view.getId() == R.id.btn_plus) {
            operation = "+";
            a = textView.getText().toString().contains("%") ?
                    Float.parseFloat(textView.getText().toString().replace("%", "").trim()) / 100 :
                    Float.parseFloat(textView.getText().toString().trim());
        } else if (view.getId() == R.id.btn_percent) {
            operation = "%";
            a = textView.getText().toString().contains("%") ?
                    Float.parseFloat(textView.getText().toString().replace("%", "").trim()) / 100 :
                    Float.parseFloat(textView.getText().toString().trim());
        } else if (view.getId() == R.id.division) {
            operation = "/";
            a = textView.getText().toString().contains("%") ?
                    Float.parseFloat(textView.getText().toString().replace("%", "").trim()) / 100 :
                    Float.parseFloat(textView.getText().toString().trim());
        } else if (view.getId() == R.id.multiplication) {
            operation = "x";
            a = textView.getText().toString().contains("%") ?
                    Float.parseFloat(textView.getText().toString().replace("%", "").trim()) / 100 :
                    Float.parseFloat(textView.getText().toString().trim());
        }else if (view.getId() == R.id.btn_minus) {
            operation = "-";
            a = textView.getText().toString().contains("%") ?
                    Float.parseFloat(textView.getText().toString().replace("%", "").trim()) / 100 :
                    Float.parseFloat(textView.getText().toString().trim());
        } else if (view.getId() == R.id.btn_equal) {
            boolean percentOn = textView.getText().toString().contains("%");
            b = percentOn ?
                    Float.parseFloat(textView.getText().toString().replace("%", "").trim()) / 100 :
                    Float.parseFloat(textView.getText().toString().trim());

            if (percentOn == true) {
                if (operation == "+") {
                    float c = a * b;
                    float result = a + c;
                    if (result == Math.floor(result)){
                        int intResult = (int) result;
                        textView.setText(String.valueOf(intResult));
                    }else {
                        textView.setText(String.valueOf(result));
                    }
                } else if (operation == "-") {
                    float c = a * b;
                    float result = a - c;
                    if (result == Math.floor(result)){
                        int intResult = (int) result;
                        textView.setText(String.valueOf(intResult));
                    }else {
                        textView.setText(String.valueOf(result));
                    }
                }
            } else {
                if (operation == "+") {
                    float result = a + b;
                    if (result == Math.floor(result)){
                        int intResult = (int) result;
                        textView.setText(String.valueOf(intResult));
                    }else {
                        textView.setText(String.valueOf(result));
                    }
                } else if (operation == "-") {
                    float result = a - b;
                    if (result == Math.floor(result)){
                        int intResult = (int) result;
                        textView.setText(String.valueOf(intResult));
                    }else {
                        textView.setText(String.valueOf(result));
                    }
                }else if (operation == "x") {
                    float result = a * b;
                    if (result == Math.floor(result)){
                        int intResult = (int) result;
                        textView.setText(String.valueOf(intResult));
                    }else {
                        textView.setText(String.valueOf(result));
                    }
                }else if (operation == "/") {
                    if(b == 0){
                        String error = "Error";
                        textView.setText(error);
                    }else {
                        float result = a / b;
                        if (result == Math.floor(result)){
                            int intResult = (int) result;
                            textView.setText(String.valueOf(intResult));
                        }else {
                            textView.setText(String.valueOf(result));
                        }
                    }

                }
            }

        }
        isOperationClick = true;
    }
}