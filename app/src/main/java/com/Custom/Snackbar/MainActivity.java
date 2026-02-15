package com.Custom.Snackbar;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.Custom.Snackbar.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.simpleSnackbar.setOnClickListener( v -> {
            CustomSnackbar.showSnackbarWithColor(this, "Simple Snackbar",
                    17,           // textSize
                    0xFF000000,   // textColor (white)
                    0xFF009688    // backgroundColor (green)
            );
        });

        binding.durationSnackbar.setOnClickListener( v -> {
            CustomSnackbar.showSnackbarWithColor(this, "Duration Snackbar",
                    17,           // textSize
                    0xFF000000,   // textColor (white)
                    0xFF8BC34A   // backgroundColor (green)
                    , Snackbar.LENGTH_LONG);
        });

        binding.colorSnackbar.setOnClickListener( v -> {
            CustomSnackbar.showSnackbarWithColor(this, "Color Snackbar",
                    17,           // textSize
                    0xFF000000,   // textColor (white)
                    0xFFFFEB3B    // backgroundColor (green)
            );
        });

        binding.buttonSnackbar.setOnClickListener( v -> {
            CustomSnackbar.showSnackbarWithAction(this,
                    "Delete this item?",
                    "Delete",                    // actionText
                    0xFFFF0000,                  // actionBgColor (red)
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // Delete action
                        }
                    }
            );
        });
    }
}