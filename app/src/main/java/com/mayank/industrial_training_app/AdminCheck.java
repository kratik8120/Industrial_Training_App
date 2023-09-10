package com.mayank.industrial_training_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AdminCheck extends AppCompatActivity {
      ImageView img;
    Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_check);
        img=findViewById(R.id.imageView2);
        button1=findViewById(R.id.button11);
        button2=findViewById(R.id.button12);
    }
}
