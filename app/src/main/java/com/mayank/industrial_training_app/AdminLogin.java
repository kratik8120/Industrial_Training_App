package com.mayank.industrial_training_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    EditText userid,pass;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        userid=findViewById(R.id.editTextName);
        pass=findViewById(R.id.editTextPassword);
        submit=findViewById(R.id.buttonSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(TextUtils.isEmpty(userid.getText().toString())||TextUtils.isEmpty(pass.getText().toString()))
                    {
                        Toast.makeText(AdminLogin.this, "Enter the Data", Toast.LENGTH_SHORT).show();
                    }
                    if(userid.getText().toString().equals("Mayank") && pass.getText().toString().equals("1234")) {

                        Intent i = new Intent(AdminLogin.this, AdminStudentInfo.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(AdminLogin.this,"Entered detail are invalid",Toast.LENGTH_SHORT).show();
                    }
                }
            });

    }
}