package com.mayank.industrial_training_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class AdminStudentInfo extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<UserModel>listAllItem;
    UserModel userModel;
    FirebaseFirestore db;
    Context context;
    ReadDataAdapter readDataAdapter;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_student_info);

        db=FirebaseFirestore.getInstance();
        recyclerView=findViewById(R.id.RecycleView);
        searchView=findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                 Log.d("Search", "Query text changed: " + s);
                filterList(s);
                return true;
            }
        });
        readDataAdapter = new ReadDataAdapter(this, new ArrayList<>());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(readDataAdapter);
        getAllData();
    }

    public void getAllData()
    {
       // listAllItem=new ArrayList<UserModel>();
        listAllItem=new ArrayList<>();
        //listAllItem.clear();

        // Snapshot Listener is for to get data
        db.collection("Second Year Student").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                 if (error != null) {
        // Handle the error, e.g., log or display a message to the user
        Toast.makeText(AdminStudentInfo.this, "Error fetching data from Firestore", Toast.LENGTH_SHORT).show();
        Log.e("FirestoreError", "Error fetching data", error);
        return;
    }
                // if(error==null)
                // {
                    List<UserModel> data= value.toObjects(UserModel.class);
                    listAllItem.clear();
                    listAllItem.addAll(data);
                    recyclerView.setLayoutManager(new LinearLayoutManager(AdminStudentInfo.this));
                    //------->
                    recyclerView.setAdapter(new ReadDataAdapter(AdminStudentInfo.this,listAllItem));
                    filterList("");

                // }
                }
        });
    }
    private void filterList(String text)
    {
        Log.d("Search", "Filtering with text: " + text);
        ArrayList<UserModel> filterdList=new ArrayList<>();
        for(UserModel item:listAllItem)
        {
            if(item.getS_name().toLowerCase().contains(text.toLowerCase()))
            {
                filterdList.add(item);
            }
        }
        if(filterdList.isEmpty())
        {
            Toast.makeText(AdminStudentInfo.this,"No data Found",Toast.LENGTH_SHORT).show();
        }
        else
        {
            readDataAdapter.setFilterdList(filterdList);
        }
    }


}
