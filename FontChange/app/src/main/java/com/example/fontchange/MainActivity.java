package com.example.fontchange;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button changeFontButton;
    private Button changeColorButton;
    private boolean isFontChanged = false;
    private boolean isColorChanged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the UI elements
        textView = findViewById(R.id.textView);
        changeFontButton = findViewById(R.id.changeFontButton);
        changeColorButton = findViewById(R.id.changeColorButton);

        // Set the click listener for the change font button
        changeFontButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFontChanged) {
                    textView.setTypeface(Typeface.DEFAULT);
                    isFontChanged = false;
                } else {
                    try {
                        Typeface customFont = Typeface.createFromAsset(getAssets(), "font/roboto_regular.ttf");
                        textView.setTypeface(customFont);
                        isFontChanged = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Failed to change font", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                Toast.makeText(MainActivity.this, "Font changed", Toast.LENGTH_SHORT).show();
            }
        });

        // Set the click listener for the change color button
        changeColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isColorChanged) {
                    textView.setTextColor(Color.BLACK);
                    isColorChanged = false;
                } else {
                    textView.setTextColor(Color.RED);
                    isColorChanged = true;
                }
                Toast.makeText(MainActivity.this, "Color changed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


