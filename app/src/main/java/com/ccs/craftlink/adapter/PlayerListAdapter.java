package com.ccs.craftlink.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ccs.craftlink.R;

import java.util.List;

public class PlayerListAdapter extends RecyclerView.Adapter<PlayerListAdapter.PlayerViewHolder> {

    private final List<String> players;

    public PlayerListAdapter(List<String> players) {
        this.players = players;
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_player, parent, false);
        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        String username = players.get(position);
        holder.tvName.setText(username);
        
        // Fetch skin from Minotar using username
        String skinUrl = "https://minotar.net/helm/" + username + "/64.png";
        Glide.with(holder.ivFace.getContext())
                .load(skinUrl)
                .into(holder.ivFace);
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    static class PlayerViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFace;
        TextView tvName;

        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFace = itemView.findViewById(R.id.iv_player_face);
            tvName = itemView.findViewById(R.id.tv_player_name);
        }
    }
}
