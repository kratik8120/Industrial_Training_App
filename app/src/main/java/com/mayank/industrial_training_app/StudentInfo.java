package com.mayank.industrial_training_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentInfo extends AppCompatActivity {

    EditText name,rollno,phone,mode,url,section,project,duration,technology,organisation;
    Button save;
    FirebaseDatabase fd=FirebaseDatabase.getInstance();
    DatabaseReference dr=fd.getReference().child("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        name=findViewById(R.id.editTextname);
        rollno=findViewById(R.id.editTextrollno);
        phone=findViewById(R.id.editTextphone);
        mode=findViewById(R.id.editTextmode);
        url=findViewById(R.id.editTexturl);
        section=findViewById(R.id.editTextsection);
        project=findViewById(R.id.editTextproject);
        duration=findViewById(R.id.editTextduration);
        technology=findViewById(R.id.editTexttechnology);
        organisation=findViewById(R.id.editTextorganisation);
        save=findViewById(R.id.buttonsave);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(StudentInfo.this,"Successful",Toast.LENGTH_LONG).show();
                String Name=name.getText().toString();
                dr.child("Names").setValue(Name);
            }
        });

    }
}