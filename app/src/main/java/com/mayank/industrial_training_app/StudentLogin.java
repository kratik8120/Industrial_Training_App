package com.mayank.industrial_training_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class StudentLogin extends AppCompatActivity {

    EditText enteremail;
    EditText enterpswd;
    Button login;
    FirebaseAuth auth=FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        enteremail=findViewById(R.id.editTextEmailAddress);
        enterpswd=findViewById(R.id.enter);
        login=findViewById(R.id.submit);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userEmail=enteremail.getText().toString();
                String userPassword=enterpswd.getText().toString();
                SignInFirebase(userEmail,userPassword);
            }
        });

    }
    public void SignInFirebase(String userEmail,String userPassword)
    {
        auth.signInWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(StudentLogin.this,"Login Successful",Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(StudentLogin.this, MainMenu.class);
                            startActivity(i);

                        } else {
                            Toast.makeText(StudentLogin.this,"Mail Id or password is incorrect",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
