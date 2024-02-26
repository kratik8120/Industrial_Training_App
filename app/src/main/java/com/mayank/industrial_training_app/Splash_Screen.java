package com.mayank.industrial_training_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.SplashScreen;

public class Splash_Screen extends AppCompatActivity {

     TextView textView,base;
    Animation bottom,top;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        top= AnimationUtils.loadAnimation(this,R.anim.top);
        bottom=AnimationUtils.loadAnimation(this,R.anim.bottom);
        textView=findViewById(R.id.textView5);
        image=findViewById(R.id.imageView3);
        base=findViewById(R.id.base);

        image.setAnimation(top);
        textView.setAnimation(bottom);
        base.setAnimation(bottom);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(Splash_Screen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },5000);
    }
    
}
