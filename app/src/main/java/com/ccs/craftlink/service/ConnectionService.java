package com.ccs.craftlink.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.net.wifi.WifiManager;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.ccs.craftlink.MainActivity;
import com.ccs.craftlink.R;
import com.ccs.craftlink.network.MinecraftConnection;
import com.ccs.craftlink.network.ServerManager;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class ConnectionService extends Service {
    private static final String TAG = "ConnectionService";
    private static final String CHANNEL_ID = "craftlink_connection_v2";
    private static final int NOTIFICATION_ID = 3001;

    private final CompositeDisposable disposables = new CompositeDisposable();
    private MinecraftConnection activeConnection;
    private PowerManager.WakeLock wakeLock;
    private WifiManager.WifiLock wifiLock;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "Service created");
        createNotificationChannel();
        acquireLocks();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "Service started");
        if (Build.VERSION.SDK_INT >= 34) { // UPSIDE_DOWN_CAKE is 34
            startForeground(NOTIFICATION_ID, createNotification("Monitoring connection..."), android.content.pm.ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC);
        } else {
            startForeground(NOTIFICATION_ID, createNotification("Monitoring connection..."));
        }
        observeConnection();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Service destroyed");
        releaseLocks();
        disposables.clear();
    }

    private void acquireLocks() {
        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        if (powerManager != null) {
            wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "CraftLink::ConnectionWakeLock");
            wakeLock.acquire();
        }

        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (wifiManager != null) {
            wifiLock = wifiManager.createWifiLock(WifiManager.WIFI_MODE_FULL_HIGH_PERF, "CraftLink::ConnectionWifiLock");
            wifiLock.acquire();
        }
    }

    private void releaseLocks() {
        if (wakeLock != null && wakeLock.isHeld()) {
            wakeLock.release();
        }
        if (wifiLock != null && wifiLock.isHeld()) {
            wifiLock.release();
        }
    }

    private void observeConnection() {
        disposables.add(ServerManager.getInstance(this).observeConnectionEvents()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(server -> {
                    activeConnection = ServerManager.getInstance(this).getActiveConnection();
                    if (activeConnection != null) {
                        observeConnectionState(activeConnection);
                        observeChatMessages(activeConnection);
                    }
                }));

        ServerManager sm = ServerManager.getInstance(this);
        if (sm.getActiveConnection() != null) {
            activeConnection = sm.getActiveConnection();
            observeConnectionState(activeConnection);
            observeChatMessages(activeConnection);
        }
    }

    private void observeConnectionState(MinecraftConnection connection) {
        disposables.add(connection.observeConnectionState()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(state -> {
                    String statusText;
                    switch (state) {
                        case CONNECTED:
                            statusText = "Connected to " + getServerName();
                            break;
                        case CONNECTING:
                            statusText = "Connecting to " + getServerName() + "...";
                            break;
                        case AUTHENTICATING:
                            statusText = "Authenticating...";
                            break;
                        case PLAYING:
                            statusText = "Playing on " + getServerName();
                            break;
                        case DISCONNECTED:
                            statusText = "Disconnected";
                            break;
                        case ERROR:
                            statusText = "Connection error";
                            break;
                        default:
                            statusText = "CraftLink";
                    }
                    updateNotification(statusText);
                }));
    }

    private void observeChatMessages(MinecraftConnection connection) {
        disposables.add(connection.getChatObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(message -> {
                    if (!message.isSystem()) {
                        updateNotification(message.getSender() + ": " + message.getContent());
                    }
                }));
    }

    private String getServerName() {
        ServerManager sm = ServerManager.getInstance(this);
        if (sm.getActiveServer() != null) {
            return sm.getActiveServer().getName();
        }
        return "server";
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "CraftLink Connection",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            channel.setDescription("Active connection notification");
            channel.setShowBadge(false);
            NotificationManager manager = getSystemService(NotificationManager.class);
            if (manager != null) {
                manager.createNotificationChannel(channel);
            }
        }
    }

    private Notification createNotification(String contentText) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        return new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("CraftLink")
                .setContentText(contentText)
                .setContentIntent(pendingIntent)
                .setOngoing(true)
                .setSilent(true)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_SERVICE)
                .build();
    }

    private void updateNotification(String contentText) {
        NotificationManager manager = getSystemService(NotificationManager.class);
        if (manager != null) {
            manager.notify(NOTIFICATION_ID, createNotification(contentText));
        }
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, ConnectionService.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    public static void stop(Context context) {
        context.stopService(new Intent(context, ConnectionService.class));
    }
}
