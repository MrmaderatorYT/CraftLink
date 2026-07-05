package com.ccs.craftlink.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ccs.craftlink.R;
import com.ccs.craftlink.model.MinecraftServer;
import com.google.android.material.chip.Chip;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

public class ServerAdapter extends RecyclerView.Adapter<ServerAdapter.ServerViewHolder> {

    public interface OnServerClickListener {
        void onConnectClick(MinecraftServer server);
        void onMoreClick(MinecraftServer server, View anchor);
    }

    private final List<MinecraftServer> servers = new ArrayList<>();
    private OnServerClickListener listener;

    public void setOnServerClickListener(OnServerClickListener listener) {
        this.listener = listener;
    }

    public void setServers(List<MinecraftServer> newServers) {
        servers.clear();
        servers.addAll(newServers);
        notifyDataSetChanged();
    }

    public void updateServerPingStatus(long serverId, String statusText, boolean isOnline) {
        for (int i = 0; i < servers.size(); i++) {
            if (servers.get(i).getId() == serverId) {
                notifyItemChanged(i);
                return;
            }
        }
    }

    public void updateServer(MinecraftServer updatedServer) {
        for (int i = 0; i < servers.size(); i++) {
            if (servers.get(i).getId() == updatedServer.getId()) {
                servers.set(i, updatedServer);
                notifyItemChanged(i);
                return;
            }
        }
    }

    @NonNull
    @Override
    public ServerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_server, parent, false);
        return new ServerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServerViewHolder holder, int position) {
        MinecraftServer server = servers.get(position);
        holder.bind(server);
    }

    @Override
    public int getItemCount() {
        return servers.size();
    }

    class ServerViewHolder extends RecyclerView.ViewHolder {
        private final View viewStatus;
        private final TextView tvName;
        private final TextView tvAddress;
        private final Chip chipType;
        private final TextView tvVersion;
        private final TextView tvPingStatus;
        private final ImageButton btnMore;
        private final com.google.android.material.button.MaterialButton btnConnect;

        ServerViewHolder(@NonNull View itemView) {
            super(itemView);
            viewStatus = itemView.findViewById(R.id.view_status);
            tvName = itemView.findViewById(R.id.tv_server_name);
            tvAddress = itemView.findViewById(R.id.tv_server_address);
            chipType = itemView.findViewById(R.id.chip_server_type);
            tvVersion = itemView.findViewById(R.id.tv_server_version);
            tvPingStatus = itemView.findViewById(R.id.tv_ping_status);
            btnMore = itemView.findViewById(R.id.btn_more);
            btnConnect = itemView.findViewById(R.id.btn_connect);
        }

        void bind(MinecraftServer server) {
            tvName.setText(server.getName());
            tvAddress.setText(server.getHost());
            chipType.setText(server.getServerType());
            tvVersion.setText(server.getVersion());

            if (server.isConnected()) {
                viewStatus.setBackgroundResource(R.drawable.bg_status_online);
                btnConnect.setText(R.string.disconnect);
            } else {
                viewStatus.setBackgroundResource(R.drawable.bg_status_offline);
                btnConnect.setText(R.string.connect);
            }

            tvPingStatus.setVisibility(View.GONE);

            btnConnect.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onConnectClick(server);
                }
            });

            btnMore.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onMoreClick(server, v);
                }
            });

            ((MaterialCardView) itemView).setOnClickListener(v -> {
                if (listener != null) {
                    listener.onConnectClick(server);
                }
            });
        }
    }
}
