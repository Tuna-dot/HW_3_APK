package com.example.hw_3_apk;



import android.os.Bundle;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    ImageView hert;
    boolean theButtonIsActuve = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        findViewById(R.id.big_btn).setOnClickListener((View v) -> {
            finish();
        });

        findViewById(R.id.hert).setOnClickListener(view -> {
            theButtonIsActuve = true;
            hert = findViewById(R.id.hert);
            if (theButtonIsActuve) {
                hert.setImageResource(R.drawable.heart);
            }
        });

        Spinner spinner = findViewById(R.id.spiner);

        ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(this,
                R.array.dropdown_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
    }

}