package com.mayank.industrial_training_app;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class AdminFinalPage extends AppCompatActivity {

    ArrayList<UserModel> listAllItem;
    FirebaseFirestore db;
    Context context;
    TextView text;
    TextView name,roll,section,phone,project,organisation,technology,mode,url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_final_page);

        db=FirebaseFirestore.getInstance();
        name=findViewById(R.id.studentName);
        roll=findViewById(R.id.studentRoll);
        section=findViewById(R.id.studentSection);
        phone=findViewById(R.id.studentPhone);
        project=findViewById(R.id.studentProject);
        organisation=findViewById(R.id.studentOrganisation);
        technology=findViewById(R.id.studentTechnology);
        mode=findViewById(R.id.studentMode);
        url=findViewById(R.id.studentUrl);
        text=findViewById(R.id.textView22);

        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        Animation animation1= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.top);

        text.setAnimation(animation1);
        name.setAnimation(animation);
        roll.setAnimation(animation);
        section.setAnimation(animation);
        phone.setAnimation(animation);
        project.setAnimation(animation);
        organisation.setAnimation(animation);
        technology.setAnimation(animation);
        mode.setAnimation(animation);
        url.setAnimation(animation);

        Intent intent = getIntent();
        if (intent != null) {
            UserModel selectedStudent = (UserModel) intent.getSerializableExtra("selectedStudent");

            if (selectedStudent != null) {
                // Display student details
                name.setText(selectedStudent.getS_name());
                roll.setText(selectedStudent.getS_roll_no());
                section.setText(selectedStudent.getS_Section());
                phone.setText(selectedStudent.getS_Phone());
                project.setText(selectedStudent.getS_Project());
                organisation.setText(selectedStudent.getS_Organisation());
                technology.setText(selectedStudent.getS_Technology());
                mode.setText(selectedStudent.getS_Mode());
                url.setText(selectedStudent.getS_Url());
                // ... (other details)

            } else {
                // Handle the case where selectedStudent is not provided
            }
        }

}}