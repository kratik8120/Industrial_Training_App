package com.mayank.industrial_training_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetActivity extends AppCompatActivity {

    EditText email;
    Button sendOtp;
    FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        email=findViewById(R.id.emailVerify);
        sendOtp=findViewById(R.id.sendOtp);

        sendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail=email.getText().toString();
                if(TextUtils.isEmpty(userEmail))
                {
                    Toast.makeText(ForgetActivity.this,"Please Enter the mail id",Toast.LENGTH_SHORT).show();
                }
                firebaseAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(ForgetActivity.this,"Password is sended to your mail id",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ForgetActivity.this,"Please enter the valid email",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                finish();
            }
        });
    }
}