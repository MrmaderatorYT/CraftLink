package com.ccs.craftlink.network;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.ccs.craftlink.autofeatures.AutoReconnectManager;
import com.ccs.craftlink.widget.QuickConnectWidget;
import com.ccs.craftlink.model.MinecraftServer;
import com.ccs.craftlink.model.UserProfile;
import com.ccs.craftlink.service.ConnectionService;
import com.ccs.craftlink.storage.ProfileManager;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class ServerManager {
    private static final String TAG = "ServerManager";
    private static ServerManager instance;

    private final Context context;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final List<MinecraftServer> servers = new ArrayList<>();
    private final BehaviorSubject<List<MinecraftServer>> serversSubject = BehaviorSubject.createDefault(new ArrayList<>());
    private final PublishSubject<MinecraftServer> connectionEvent = PublishSubject.create();

    private MinecraftConnection activeConnection;
    private MinecraftServer activeServer;

    public static synchronized ServerManager getInstance(Context context) {
        if (instance == null) {
            instance = new ServerManager(context.getApplicationContext());
        }
        return instance;
    }

    private ServerManager(Context context) {
        this.context = context.getApplicationContext();
        BlockColors.load(this.context);
        loadServers();
    }

    public Observable<List<MinecraftServer>> observeServers() {
        return serversSubject;
    }

    public Observable<MinecraftServer> observeConnectionEvents() {
        return connectionEvent;
    }

    public List<MinecraftServer> getServers() {
        return new ArrayList<>(servers);
    }

    public MinecraftServer getActiveServer() {
        return activeServer;
    }

    public MinecraftConnection getActiveConnection() {
        return activeConnection;
    }

    public boolean isConnected() {
        return activeConnection != null && activeConnection.isConnected();
    }

    public void addServer(MinecraftServer server) {
        server.setId(System.currentTimeMillis());
        servers.add(server);
        saveServers();
        serversSubject.onNext(getServers());
    }

    public void updateServer(MinecraftServer server) {
        for (int i = 0; i < servers.size(); i++) {
            if (servers.get(i).getId() == server.getId()) {
                servers.set(i, server);
                break;
            }
        }
        saveServers();
        serversSubject.onNext(getServers());
    }

    public void removeServer(long serverId) {
        servers.removeIf(s -> s.getId() == serverId);
        saveServers();
        serversSubject.onNext(getServers());
    }

    public void connectToServer(MinecraftServer server) {
        Log.i(TAG, "=== CONNECT TO SERVER ===");
        Log.i(TAG, "Server: " + server.getName() + " (" + server.getAddress() + ":" + server.getPort() + ")");
        Log.i(TAG, "Active connection exists: " + (activeConnection != null));

        if (activeConnection != null) {
            Log.d(TAG, "Disconnecting existing connection");
            activeConnection.disconnect();
        }

        activeServer = server;
        activeConnection = new MinecraftConnection();

        // Use profile username if available
        UserProfile profile = ProfileManager.getInstance(context).getActiveProfile();
        String username = (profile != null && profile.getDisplayName() != null && !profile.getDisplayName().isEmpty())
                ? profile.getDisplayName()
                : "CraftLink_User";
        Log.i(TAG, "Using username for connection: " + username);
        activeConnection.setUsername(username);

        Log.d(TAG, "Setting server connected=true");
        server.setConnected(true);
        server.setLastConnected(System.currentTimeMillis());
        notifyServerChanged(server);

        Log.d(TAG, "Emitting connection event");
        connectionEvent.onNext(server);

        Log.d(TAG, "Subscribing to connection state...");
        disposables.add(activeConnection.observeConnectionState()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(state -> {
                    Log.i(TAG, "Connection state changed: " + state);
                    if (activeServer == null) return;

                    switch (state) {
                        case CONNECTED:
                            activeServer.setConnected(true);
                            notifyServerChanged(activeServer);
                            AutoReconnectManager.getInstance(context).onConnected();
                            refreshWidgets();
                            break;
                        case PLAYING:
                            UserProfile activeProfile = ProfileManager.getInstance(context).getActiveProfile();
                            if (activeProfile != null && activeProfile.isAutoLogin() && activeProfile.getPassword() != null && !activeProfile.getPassword().isEmpty()) {
                                mainHandler.postDelayed(() -> {
                                    if (activeConnection != null && activeConnection.isConnected()) {
                                        activeConnection.sendChat("/login " + activeProfile.getPassword());
                                    }
                                }, 1000); // 1 sec delay to ensure we can chat
                            }
                            refreshWidgets();
                            break;
                        case DISCONNECTED:
                            activeServer.setConnected(false);
                            notifyServerChanged(activeServer);
                            AutoReconnectManager.getInstance(context).onDisconnected("Server closed connection");
                            refreshWidgets();
                            break;
                        case ERROR:
                            activeServer.setConnected(false);
                            notifyServerChanged(activeServer);
                            AutoReconnectManager.getInstance(context).onConnectionError();
                            refreshWidgets();
                            break;
                        default:
                            break;
                    }
                }, e -> Log.e(TAG, "Connection state error", e)));

        Log.d(TAG, "Starting connection...");
        activeConnection.connect(server);
        Log.d(TAG, "connect() returned (connection is async)");

        ConnectionService.start(context);
    }

    public void disconnectFromServer() {
        AutoReconnectManager.getInstance(context).cleanup();
        disposables.clear();
        ConnectionService.stop(context);

        if (activeConnection != null) {
            activeConnection.disconnect();
            activeConnection = null;
        }
        if (activeServer != null) {
            activeServer.setConnected(false);
            notifyServerChanged(activeServer);
            activeServer = null;
        }
    }

    private void notifyServerChanged(MinecraftServer server) {
        saveServers();
        mainHandler.post(() -> serversSubject.onNext(getServers()));
    }

    public MinecraftServer getServerById(long id) {
        for (MinecraftServer server : servers) {
            if (server.getId() == id) {
                return server;
            }
        }
        return null;
    }

    private void loadServers() {
        try {
            android.content.SharedPreferences prefs = context.getSharedPreferences("craftlink_servers", Context.MODE_PRIVATE);
            String serversJson = prefs.getString("servers", "[]");
            com.google.gson.Gson gson = new com.google.gson.Gson();
            java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<List<MinecraftServer>>() {}.getType();
            List<MinecraftServer> loaded = gson.fromJson(serversJson, type);
            if (loaded != null) {
                for (MinecraftServer s : loaded) {
                    s.setConnected(false);
                }
                servers.addAll(loaded);
            }
            Log.i(TAG, "Loaded " + servers.size() + " servers from storage");
            serversSubject.onNext(getServers());
        } catch (Exception e) {
            Log.e(TAG, "Failed to load servers", e);
        }
    }

    private void saveServers() {
        try {
            android.content.SharedPreferences prefs = context.getSharedPreferences("craftlink_servers", Context.MODE_PRIVATE);
            com.google.gson.Gson gson = new com.google.gson.Gson();
            prefs.edit().putString("servers", gson.toJson(servers)).apply();
        } catch (Exception e) {
            Log.e(TAG, "Failed to save servers", e);
        }
    }

    private void refreshWidgets() {
        QuickConnectWidget.refreshAllWidgets(context);
    }
}
