package com.mayank.industrial_training_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StudentLogin extends AppCompatActivity {

    TextView intro;
    TextView rollno;
    EditText enterroll;
    TextView pswd;
    EditText enterpswd;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

      intro=findViewById(R.id.heading);
        rollno=findViewById(R.id.name);
        enterroll=findViewById(R.id.entername);
        enterpswd=findViewById(R.id.enter);
        pswd=findViewById(R.id.pswd);
        login=findViewById(R.id.submit);

    }
}
