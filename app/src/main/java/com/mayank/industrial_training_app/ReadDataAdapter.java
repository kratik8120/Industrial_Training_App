package com.mayank.industrial_training_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ReadDataAdapter extends RecyclerView.Adapter<ReadDataAdapter.ReadDataHolder> {

    ArrayList<UserModel>listAllItem;
    Context context;

    public void
    setFilterdList(ArrayList<UserModel> filterdList)
    {
        this.listAllItem=filterdList;
        notifyDataSetChanged();
    }
    public ReadDataAdapter(Context context, ArrayList<UserModel>listAllItem) {
        this.listAllItem = listAllItem;
        this.context=context;
    }

    @NonNull
    @Override
    public ReadDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ReadDataHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ReadDataHolder holder, int position) {

        holder.studentName.setText(listAllItem.get(position).getS_name());
        holder.studentRoll.setText(listAllItem.get(position).getS_roll_no());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserModel selectedStudent = listAllItem.get(position);
                Intent i = new Intent(context, AdminFinalPage.class);
                i.putExtra("selectedStudent", selectedStudent); // Pass the UserModel object
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listAllItem.size();
    }

    class ReadDataHolder extends ViewHolder {

        TextView studentName,studentRoll;
        public ReadDataHolder(@NonNull View itemView) {

            super(itemView);
            studentName=itemView.findViewById(R.id.text1);
            studentRoll=itemView.findViewById(R.id.studentRoll);
        }

        }
    }

