package com.mayank.industrial_training_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class StudentSignUp extends AppCompatActivity {

    TextView Signup;
    TextView Name;
    EditText entername;
    TextView rollno;
    EditText enterroll;

    TextView mail;
    EditText entermail;
    TextView pswd;
    EditText enterpswd;

    TextView alreadyaccount;
    TextView login;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_sign_up);

         Signup=findViewById(R.id.heading);
        Name=findViewById(R.id.name);
        entername=findViewById(R.id.entername);
        rollno=findViewById(R.id.rollno);
        enterroll=findViewById(R.id.enterrolno);
        mail=findViewById(R.id.mailid);
        entermail=findViewById(R.id.entermail);
        pswd=findViewById(R.id.pswd);
        enterpswd=findViewById(R.id.enter);
        signup=findViewById(R.id.submit);
        alreadyaccount=findViewById(R.id.textView);
        login=findViewById(R.id.textView2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(), StudentLogin.class);
                startActivity(i);
            }
        });
    }
}
