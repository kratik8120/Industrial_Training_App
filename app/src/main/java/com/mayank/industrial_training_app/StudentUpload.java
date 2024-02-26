package com.mayank.industrial_training_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class StudentUpload extends AppCompatActivity {

    TextView head;
    Button but1,but2,but3,but4,but5,but6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_upload);
        head=findViewById(R.id.textView3);
        but1=findViewById(R.id.button3);
        but2=findViewById(R.id.button4);
        but3=findViewById(R.id.button5);
        but4=findViewById(R.id.button6);
        but5=findViewById(R.id.button7);
        but6=findViewById(R.id.button8);

        Animation animation1= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.top);

        head.setAnimation(animation1);

        Animation animation2=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        but1.setAnimation(animation2);
        but2.setAnimation(animation2);
        but3.setAnimation(animation2);
        but4.setAnimation(animation2);
        but5.setAnimation(animation2);
        but6.setAnimation(animation2);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(StudentUpload.this, StudentInfo.class);
                startActivity(i);
            }
        });
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(StudentUpload.this, StudentInfo2.class);
                startActivity(i);
            }
        });
        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(StudentUpload.this, StudentInfo2.class);
                startActivity(i);
            }
        });
    }
}
