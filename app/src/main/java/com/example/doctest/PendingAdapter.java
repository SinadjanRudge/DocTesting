package com.example.doctest;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PendingAdapter extends FirebaseRecyclerAdapter<DataClass,PendingAdapter.myviewholder>
{


    private List<DataClass> dataList;
    public PendingAdapter(@NonNull FirebaseRecyclerOptions<DataClass> options) {
        super(options);
    }

    public interface ClickListener {

        void onPositionClicked(int position);

        void onLongClicked(int position);
    }


    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull DataClass DataClass)
    {

        holder.name.setText(DataClass.getDataName());
        holder.course.setText("Room: " + DataClass.getDataRoom());
        holder.email.setText("Device No: " + DataClass.getDataDevice());
     //   Glide.with(holder.img.getContext()).load(DataClass.getDataImage()).into(holder.img);
    }





    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        CircleImageView img;
        TextView name,course,email;
        Button accept;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);

            name=(TextView)itemView.findViewById(R.id.nametext);
            course=(TextView)itemView.findViewById(R.id.coursetext);
            email=(TextView)itemView.findViewById(R.id.emailtext);
            accept=(Button)itemView.findViewById(R.id.button2);
            accept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), name.getText(), Toast.LENGTH_SHORT).show();

                }
            });
        }
    }




}
