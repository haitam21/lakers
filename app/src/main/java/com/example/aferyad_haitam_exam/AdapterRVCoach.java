package com.example.aferyad_haitam_exam;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.aferyad_haitam_exam.Model.Coach;

import java.util.ArrayList;

public class AdapterRVCoach extends RecyclerView.Adapter<AdapterRVCoach.ViewHolder> {
    Context context;
    ArrayList<Coach> coaches;

    public AdapterRVCoach(Context context, ArrayList<Coach> coaches) {
        this.context = context;
        this.coaches = coaches;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View coachView= inflater.inflate(R.layout.item_card,parent,false);
        return new AdapterRVCoach.ViewHolder(coachView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Coach coach=coaches.get(position);

        ImageView imageView=holder.imageView;
        TextView name=holder.name;
        TextView post=holder.post;


        Glide.with(context).load(coach.getPhoto())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
        name.setText(coach.getName());

        post.setText(coach.getPosition());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,DetailsActivity.class);
                intent.putExtra("photo",coach.getPhoto());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return coaches.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        TextView post;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imagepers);
            name=itemView.findViewById(R.id.namepers);
            post=itemView.findViewById(R.id.postpers);
        }
    }
}
