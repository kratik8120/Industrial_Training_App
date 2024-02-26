package com.mayank.industrial_training_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class StudentInfo2 extends AppCompatActivity {

    EditText name,rollno,phone,mode,url,section,project,technology,organisation,duration;
    Button save;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        name=findViewById(R.id.editTextname2);
        rollno=findViewById(R.id.editTextrollno2);
        phone=findViewById(R.id.editTextphone2);
        mode=findViewById(R.id.editTextmode2);
        url=findViewById(R.id.editTexturl2);
        section=findViewById(R.id.editTextsection2);
        project=findViewById(R.id.editTextproject2);
        duration=findViewById(R.id.editTextduration2);
        technology=findViewById(R.id.editTexttechnology2);
        organisation=findViewById(R.id.editTextorganisation2);
        save=findViewById(R.id.buttonsave2);

        db=FirebaseFirestore.getInstance();

        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        name.setAnimation(animation);
        rollno.setAnimation(animation);
        phone.setAnimation(animation);
        mode.setAnimation(animation);
        url.setAnimation(animation);
        section.setAnimation(animation);
        project.setAnimation(animation);
        duration.setAnimation(animation);
        technology.setAnimation(animation);
        organisation.setAnimation(animation);

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
                                    Toast.makeText(StudentInfo2.this,"Details Added Successfully",Toast.LENGTH_LONG).show();
                                }
                                else {
                                    Toast.makeText(StudentInfo2.this,"Error Occur",Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });

    }
}