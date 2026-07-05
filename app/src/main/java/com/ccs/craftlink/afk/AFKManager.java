package com.ccs.craftlink.afk;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.ccs.craftlink.R;
import com.ccs.craftlink.network.MinecraftConnection;
import com.ccs.craftlink.network.ServerManager;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class AFKManager {
    private static final String TAG = "AFKManager";
    private static AFKManager instance;
    private static final String CHANNEL_ID = "craftlink_afk";

    private final Context context;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final Random random = new Random();
    private final SharedPreferences prefs;
    private final CompositeDisposable disposables = new CompositeDisposable();

    private final BehaviorSubject<Boolean> afkState = BehaviorSubject.createDefault(false);
    private final BehaviorSubject<Integer> reconnectTimer = BehaviorSubject.createDefault(0);

    private boolean afkEnabled;
    private int reconnectInterval;
    private boolean autoReconnect;
    private boolean antiAfkMovement;
    private long afkStartTime;
    private long lastMovementTime;
    private Runnable movementRunnable;
    private Runnable reconnectRunnable;

    public static synchronized AFKManager getInstance(Context context) {
        if (instance == null) {
            instance = new AFKManager(context.getApplicationContext());
        }
        return instance;
    }

    private AFKManager(Context context) {
        this.context = context;
        this.prefs = context.getSharedPreferences("craftlink_afk_prefs", Context.MODE_PRIVATE);
        this.afkEnabled = prefs.getBoolean("afkEnabled", false);
        this.reconnectInterval = prefs.getInt("reconnectInterval", 30);
        this.autoReconnect = prefs.getBoolean("autoReconnect", false);
        this.antiAfkMovement = prefs.getBoolean("antiAfkMovement", true);
        createNotificationChannel();
        if (this.afkEnabled) {
            setAfkEnabled(true);
        }
    }

    public Observable<Boolean> observeAfkState() {
        return afkState;
    }

    public Observable<Integer> observeReconnectTimer() {
        return reconnectTimer;
    }

    public boolean isAfkEnabled() {
        return afkEnabled;
    }

    public int getReconnectInterval() {
        return reconnectInterval;
    }

    public boolean isAutoReconnect() {
        return autoReconnect;
    }

    public boolean isAntiAfkMovement() {
        return antiAfkMovement;
    }

    public long getAfkDuration() {
        return System.currentTimeMillis() - afkStartTime;
    }

    public void setAfkEnabled(boolean enabled) {
        this.afkEnabled = enabled;
        prefs.edit().putBoolean("afkEnabled", enabled).apply();
        afkState.onNext(enabled);

        if (enabled) {
            afkStartTime = System.currentTimeMillis();
            lastMovementTime = System.currentTimeMillis();
            if (antiAfkMovement) {
                startAntiAfkMovement();
            }
            showAfkNotification();
        } else {
            stopAntiAfkMovement();
            stopReconnectTimer();
            hideAfkNotification();
        }
    }

    public void setReconnectInterval(int seconds) {
        this.reconnectInterval = seconds;
        prefs.edit().putInt("reconnectInterval", seconds).apply();
    }

    public void setAutoReconnect(boolean autoReconnect) {
        this.autoReconnect = autoReconnect;
        prefs.edit().putBoolean("autoReconnect", autoReconnect).apply();
    }

    public void setAntiAfkMovement(boolean enabled) {
        this.antiAfkMovement = enabled;
        prefs.edit().putBoolean("antiAfkMovement", enabled).apply();
        if (enabled) {
            startAntiAfkMovement();
        } else {
            stopAntiAfkMovement();
        }
    }

    private void startAntiAfkMovement() {
        stopAntiAfkMovement();

        movementRunnable = new Runnable() {
            @Override
            public void run() {
                // Removed afkEnabled guard to allow movement even when AFK is off

                ServerManager serverManager = ServerManager.getInstance(context);
                MinecraftConnection connection = serverManager.getActiveConnection();

        if (connection != null && connection.isConnected()) {
                    // Always perform anti-AFK movement when enabled, regardless of AFK state
                    performAntiAfkAction(connection);
                    lastMovementTime = System.currentTimeMillis();
                }

                int delay = 15000 + random.nextInt(30000);
                mainHandler.postDelayed(this, delay);
            }
        };

        mainHandler.postDelayed(movementRunnable, 5000);
    }

    private void performAntiAfkAction(MinecraftConnection connection) {
        int action = random.nextInt(4); // Remove chat sending
        float dYaw = (random.nextFloat() - 0.5f) * 40.0f; // Rotate between -20 and 20 degrees
        switch (action) {
            case 0:
            case 1:
                connection.rotateCamera(dYaw, 0);
                Log.d(TAG, "Anti-AFK: Rotated yaw");
                break;
            case 2:
                connection.rotateCamera(0, dYaw); // Rotate pitch
                Log.d(TAG, "Anti-AFK: Rotated pitch");
                break;
            case 3:
                connection.moveRelative(0, 1, 0); // Jump
                Log.d(TAG, "Anti-AFK: Jumped");
                break;
        }
    }

    private void stopAntiAfkMovement() {
        if (movementRunnable != null) {
            mainHandler.removeCallbacks(movementRunnable);
            movementRunnable = null;
        }
    }

    public void startReconnectTimer() {
        stopReconnectTimer();

        reconnectRunnable = new Runnable() {
            int countdown = reconnectInterval;

            @Override
            public void run() {
                if (!afkEnabled || !autoReconnect) return;

                reconnectTimer.onNext(countdown);
                updateReconnectNotification(countdown);

                if (countdown <= 0) {
                    reconnectToServer();
                    countdown = reconnectInterval;
                } else {
                    countdown--;
                    mainHandler.postDelayed(this, 1000);
                }
            }
        };

        mainHandler.post(reconnectRunnable);
    }

    private void stopReconnectTimer() {
        if (reconnectRunnable != null) {
            mainHandler.removeCallbacks(reconnectRunnable);
            reconnectRunnable = null;
        }
        reconnectTimer.onNext(0);
    }

    private void reconnectToServer() {
        executor.execute(() -> {
            ServerManager serverManager = ServerManager.getInstance(context);
            MinecraftConnection connection = serverManager.getActiveConnection();

            if (connection != null && connection.isConnected()) {
                connection.disconnect();
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            if (serverManager.getActiveServer() != null) {
                showReconnectNotification(serverManager.getActiveServer().getName());
                serverManager.connectToServer(serverManager.getActiveServer());
            }
        });
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "CraftLink AFK",
                    NotificationManager.IMPORTANCE_LOW
            );
            channel.setDescription("Anti-AFK notifications");

            NotificationManager manager = context.getSystemService(NotificationManager.class);
            if (manager != null) {
                manager.createNotificationChannel(channel);
            }
        }
    }

    private void showAfkNotification() {
        NotificationManager manager = context.getSystemService(NotificationManager.class);
        if (manager == null) return;

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle(context.getString(R.string.afk_notification_title))
                .setContentText(context.getString(R.string.afk_notification_text, reconnectInterval))
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setOngoing(true)
                .setSilent(true);

        manager.notify(1001, builder.build());
    }

    private void updateReconnectNotification(int seconds) {
        NotificationManager manager = context.getSystemService(NotificationManager.class);
        if (manager == null) return;

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle(context.getString(R.string.reconnect_notification_title))
                .setContentText("Reconnecting in " + seconds + "s...")
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setOngoing(true)
                .setSilent(true);

        manager.notify(1002, builder.build());
    }

    private void showReconnectNotification(String serverName) {
        NotificationManager manager = context.getSystemService(NotificationManager.class);
        if (manager == null) return;

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle(context.getString(R.string.reconnect_notification_title))
                .setContentText(context.getString(R.string.reconnect_notification_text, serverName))
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setOngoing(true);

        manager.notify(1003, builder.build());
    }

    private void hideAfkNotification() {
        NotificationManager manager = context.getSystemService(NotificationManager.class);
        if (manager != null) {
            manager.cancel(1001);
            manager.cancel(1002);
            manager.cancel(1003);
        }
    }

    public void cleanup() {
        setAfkEnabled(false);
        disposables.clear();
        mainHandler.removeCallbacksAndMessages(null);
    }
}
