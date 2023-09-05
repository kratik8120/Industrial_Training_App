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

public class StudentSignUp extends AppCompatActivity {

    EditText entername;
    EditText enterroll;
    EditText entermail;
    EditText enterpswd;
    TextView login;
    Button signup;
    FirebaseAuth auth=FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_sign_up);


        entername=findViewById(R.id.entername);
        enterroll=findViewById(R.id.enterRollNo);
        entermail=findViewById(R.id.enterMail);
        enterpswd=findViewById(R.id.enter);
        signup=findViewById(R.id.submit);
        login=findViewById(R.id.textView2);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=entername.getText().toString();
                String userEmail=entermail.getText().toString();
                String userRoll=enterroll.getText().toString();
                String userPassword=enterpswd.getText().toString();
                SignUpFirebase(userName,userRoll,userEmail,userPassword);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(getApplicationContext(), StudentLogin.class);
                startActivity(i);

            }
        });

    }
    public void SignUpFirebase(String userName,String userRoll,String userEmail,String userPassword)
    {
        auth.createUserWithEmailAndPassword(userEmail,userPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(StudentSignUp.this,"Your Account is Created"+userName,Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(StudentSignUp.this, StudentLogin.class);
                            startActivity(i);

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(StudentSignUp.this,"There is problem",Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
}
