package com.mayank.industrial_training_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button admin,student;
    ImageView bot;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        admin=findViewById(R.id.buttonAdmin);
        student=findViewById(R.id.buttonStudent);
        text=findViewById(R.id.textViewAbout);
        bot=findViewById(R.id.imageViewBot);

        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bottom);
        bot.setAnimation(animation);
        text.setAnimation(animation);

        bot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MainActivity.this, BotPage.class);
                startActivity(i);
            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, AdminLogin.class);
                startActivity(i);
            }
        });

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, StudentSignUp.class);
                startActivity(i);
            }
         });
    }
}
