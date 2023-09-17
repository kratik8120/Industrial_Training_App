package com.mayank.industrial_training_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class StudentInfo extends AppCompatActivity {

    EditText name,rollno,phone,mode,url,section,project,duration,technology,organisation;
    Button save;
    FirebaseFirestore db;

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

        db=FirebaseFirestore.getInstance();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String S_name,S_roll_no,S_Mode,S_Url,S_Section,S_Project,S_Technology,S_Organisation,S_Phone
                        ,S_duration;

                S_name=name.getText().toString();
                S_roll_no=rollno.getText().toString();
                S_Mode=mode.getText().toString();
                S_Url=url.getText().toString();
                S_Section=section.getText().toString();
                S_Project=project.getText().toString();
                S_Technology=technology.getText().toString();
                S_Organisation=organisation.getText().toString();
                S_Phone=phone.getText().toString();
                S_duration=duration.getText().toString();

                UserModel data=new UserModel(S_name,S_roll_no,S_Mode,S_Url,S_Section,S_Project,S_Technology
                ,S_Organisation,S_Phone,S_duration);
                db.collection("Second Year Student").document().set(data)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(StudentInfo.this,"Added Successfully",Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(StudentInfo.this,"Error Occur",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

    }
}