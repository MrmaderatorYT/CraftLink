package com.ccs.craftlink.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.ccs.craftlink.R;
import com.ccs.craftlink.adapter.ServerAdapter;
import com.ccs.craftlink.model.MinecraftServer;
import com.ccs.craftlink.network.ServerManager;
import com.ccs.craftlink.network.ServerPinger;
import com.ccs.craftlink.ui.DialogHelper;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class ServersFragment extends Fragment implements ServerAdapter.OnServerClickListener {
    private static final String TAG = "ServersFragment";

    private RecyclerView recyclerServers;
    private SwipeRefreshLayout swipeRefresh;
    private ExtendedFloatingActionButton fabAddServer;
    private ServerAdapter adapter;
    private ServerManager serverManager;
    private final CompositeDisposable disposables = new CompositeDisposable();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        return inflater.inflate(R.layout.fragment_servers, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated");

        serverManager = ServerManager.getInstance(requireContext());

        recyclerServers = view.findViewById(R.id.recycler_servers);
        swipeRefresh = view.findViewById(R.id.swipe_refresh);
        fabAddServer = view.findViewById(R.id.fab_add_server);

        setupRecyclerView();
        setupSwipeRefresh();
        setupFab();
        observeServers();

        Log.d(TAG, "Server count from manager: " + serverManager.getServers().size());
        Toast.makeText(requireContext(), "Servers: " + serverManager.getServers().size(), Toast.LENGTH_SHORT).show();
    }

    private void setupRecyclerView() {
        adapter = new ServerAdapter();
        adapter.setOnServerClickListener(this);
        recyclerServers.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerServers.setAdapter(adapter);
    }

    private void setupSwipeRefresh() {
        swipeRefresh.setColorSchemeColors(
                getResources().getColor(R.color.oneui_primary, null)
        );
        swipeRefresh.setProgressBackgroundColorSchemeColor(
                getResources().getColor(R.color.oneui_surface_card, null)
        );
        swipeRefresh.setOnRefreshListener(() -> {
            List<MinecraftServer> servers = serverManager.getServers();
            Log.d(TAG, "SwipeRefresh: " + servers.size() + " servers");
            adapter.setServers(servers);
            swipeRefresh.setRefreshing(false);
        });
    }

    private void setupFab() {
        fabAddServer.setOnClickListener(v -> {
            Log.d(TAG, "FAB clicked - showing add server dialog");
            DialogHelper.showAddServerDialog(requireContext(), new DialogHelper.OnServerDialogListener() {
                @Override
                public void onServerAdded(MinecraftServer server) {
                    Log.i(TAG, "Server added: " + server.getName() + " " + server.getAddress() + ":" + server.getPort());
                    serverManager.addServer(server);
                    Toast.makeText(requireContext(), "Added: " + server.getName(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onServerUpdated(MinecraftServer server) {
                    serverManager.updateServer(server);
                }
            });
        });
    }

    private void observeServers() {
        disposables.add(serverManager.observeServers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(servers -> {
                    Log.i(TAG, "observeServers: " + servers.size() + " servers");
                    adapter.setServers(servers);
                    if (servers.isEmpty()) {
                        Toast.makeText(requireContext(), "No servers. Tap + to add one.", Toast.LENGTH_SHORT).show();
                    } else {
                        pingAllServers(servers);
                    }
                }, e -> Log.e(TAG, "observeServers error", e)));
    }

    private void pingAllServers(List<MinecraftServer> servers) {
        ServerPinger pinger = ServerPinger.getInstance();
        for (MinecraftServer server : servers) {
            if (!server.isConnected()) {
                pinger.pingServer(server);
            }
        }
    }

    @Override
    public void onConnectClick(MinecraftServer server) {
        Log.i(TAG, "onConnectClick: " + server.getName() + " connected=" + server.isConnected());
        Toast.makeText(requireContext(), "Connecting to " + server.getName() + "...", Toast.LENGTH_SHORT).show();

        if (server.isConnected()) {
            Log.i(TAG, "Disconnecting from " + server.getName());
            serverManager.disconnectFromServer();
        } else {
            Log.i(TAG, "Connecting to " + server.getName() + " at " + server.getAddress() + ":" + server.getPort());
            serverManager.connectToServer(server);
        }
    }

    @Override
    public void onMoreClick(MinecraftServer server, View anchor) {
        PopupMenu popup = new PopupMenu(requireContext(), anchor);
        popup.getMenu().add(0, 1, 0, R.string.edit_server);
        popup.getMenu().add(0, 2, 1, R.string.delete_server);

        popup.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == 1) {
                DialogHelper.showEditServerDialog(requireContext(), server, new DialogHelper.OnServerDialogListener() {
                    @Override
                    public void onServerAdded(MinecraftServer server1) {}

                    @Override
                    public void onServerUpdated(MinecraftServer updatedServer) {
                        Log.i(TAG, "Server updated: " + updatedServer.getName());
                        serverManager.updateServer(updatedServer);
                    }
                });
                return true;
            } else if (item.getItemId() == 2) {
                Log.i(TAG, "Deleting server: " + server.getName());
                DialogHelper.showDeleteServerDialog(requireContext(), server.getName(),
                        () -> serverManager.removeServer(server.getId()));
                return true;
            }
            return false;
        });

        popup.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        disposables.clear();
    }
}
