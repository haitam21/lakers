package com.example.aferyad_haitam_exam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.aferyad_haitam_exam.Model.Player;

import java.util.ArrayList;

public class AdapterRVPlayer extends RecyclerView.Adapter<AdapterRVPlayer.ViewHolder> {
    Context context;
    ArrayList<Player> players;

    public AdapterRVPlayer(Context context, ArrayList<Player> players) {
        this.context = context;
        this.players = players;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View playerView= inflater.inflate(R.layout.item_player,parent,false);
        return new ViewHolder(playerView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Player player=players.get(position);

        ImageView imageView=holder.imageView;
        TextView name=holder.name;
        TextView post=holder.post;
        TextView number=holder.number;

        Glide.with(context).load(player.getPhoto())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
        name.setText(player.getName());
        number.setText(player.getNumber());
        post.setText(player.getPosition());
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        TextView post;
        TextView number;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imagepers);
            name=itemView.findViewById(R.id.namepers);
            post=itemView.findViewById(R.id.postpers);
            number=itemView.findViewById(R.id.number);
        }
    }
}
