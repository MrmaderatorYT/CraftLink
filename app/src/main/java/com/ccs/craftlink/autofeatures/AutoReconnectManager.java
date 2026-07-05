package com.ccs.craftlink.autofeatures;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.ccs.craftlink.R;
import com.ccs.craftlink.network.MinecraftConnection;
import com.ccs.craftlink.network.ServerManager;
import com.ccs.craftlink.model.MinecraftServer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class AutoReconnectManager {
    private static final String TAG = "AutoReconnectManager";
    private static AutoReconnectManager instance;
    private static final String CHANNEL_ID = "craftlink_reconnect";

    private final Context context;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final CompositeDisposable disposables = new CompositeDisposable();

    private boolean enabled = false;
    private int reconnectDelaySeconds = 30;
    private int maxRetries = 10;
    private int currentRetry = 0;
    private boolean isReconnecting = false;

    private Runnable reconnectRunnable;
    private Runnable countdownRunnable;

    public interface AutoReconnectListener {
        void onReconnectAttempt(int attempt, int maxRetries, int delaySeconds);
        void onReconnectSuccess();
        void onReconnectFailed(String reason);
    }

    private AutoReconnectListener listener;

    public static AutoReconnectManager getInstance(Context context) {
        if (instance == null) {
            instance = new AutoReconnectManager(context.getApplicationContext());
        }
        return instance;
    }

    private AutoReconnectManager(Context context) {
        this.context = context;
        createNotificationChannel();
    }

    public void setListener(AutoReconnectListener listener) {
        this.listener = listener;
    }

    public boolean isEnabled() { return enabled; }
    public int getReconnectDelaySeconds() { return reconnectDelaySeconds; }
    public int getMaxRetries() { return maxRetries; }
    public int getCurrentRetry() { return currentRetry; }
    public boolean isReconnecting() { return isReconnecting; }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        Log.i(TAG, "Auto-Reconnect " + (enabled ? "enabled" : "disabled"));
        if (!enabled) {
            stopReconnect();
        }
    }

    public void setReconnectDelaySeconds(int seconds) {
        this.reconnectDelaySeconds = Math.max(10, Math.min(120, seconds));
    }

    public void setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    public void onDisconnected(String reason) {
        if (!enabled) return;
        Log.i(TAG, "Disconnected: " + reason + ". Auto-reconnect will start in " + reconnectDelaySeconds + "s");
        showDisconnectedNotification(reason);
        startReconnectCountdown();
    }

    public void onConnected() {
        currentRetry = 0;
        isReconnecting = false;
        stopReconnect();
        if (listener != null) {
            listener.onReconnectSuccess();
        }
        showReconnectedNotification();
    }

    public void onConnectionError() {
        if (!enabled) return;
        currentRetry++;
        Log.w(TAG, "Connection error. Retry " + currentRetry + "/" + maxRetries);

        if (currentRetry >= maxRetries) {
            Log.e(TAG, "Max retries reached. Giving up.");
            isReconnecting = false;
            if (listener != null) {
                listener.onReconnectFailed("Max retries (" + maxRetries + ") reached");
            }
            showMaxRetriesNotification();
            return;
        }

        startReconnectCountdown();
    }

    private void startReconnectCountdown() {
        stopReconnect();
        isReconnecting = true;

        reconnectRunnable = () -> {
            Log.i(TAG, "Reconnect timer fired. Attempting reconnection...");
            attemptReconnect();
        };

        countdownRunnable = new Runnable() {
            int remaining = reconnectDelaySeconds;

            @Override
            public void run() {
                if (!enabled || !isReconnecting) return;

                if (listener != null) {
                    listener.onReconnectAttempt(currentRetry + 1, maxRetries, remaining);
                }

                if (remaining <= 0) {
                    attemptReconnect();
                    return;
                }

                remaining--;
                mainHandler.postDelayed(this, 1000);
            }
        };

        mainHandler.post(countdownRunnable);
    }

    private void attemptReconnect() {
        if (!enabled || !isReconnecting) return;

        ServerManager serverManager = ServerManager.getInstance(context);
        MinecraftServer activeServer = serverManager.getActiveServer();

        if (activeServer == null) {
            Log.w(TAG, "No active server to reconnect to");
            isReconnecting = false;
            if (listener != null) {
                listener.onReconnectFailed("No active server set");
            }
            return;
        }

        Log.i(TAG, "Attempting reconnect to " + activeServer.getName() + " (attempt " + (currentRetry + 1) + "/" + maxRetries + ")");
        showReconnectingNotification(activeServer.getName(), currentRetry + 1);

        executor.execute(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            mainHandler.post(() -> {
                serverManager.connectToServer(activeServer);
            });
        });
    }

    private void stopReconnect() {
        if (reconnectRunnable != null) {
            mainHandler.removeCallbacks(reconnectRunnable);
            reconnectRunnable = null;
        }
        if (countdownRunnable != null) {
            mainHandler.removeCallbacks(countdownRunnable);
            countdownRunnable = null;
        }
        isReconnecting = false;
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "CraftLink Reconnect",
                    NotificationManager.IMPORTANCE_LOW
            );
            channel.setDescription("Auto-reconnect notifications");
            NotificationManager manager = context.getSystemService(NotificationManager.class);
            if (manager != null) {
                manager.createNotificationChannel(channel);
            }
        }
    }

    private void showDisconnectedNotification(String reason) {
        NotificationManager manager = context.getSystemService(NotificationManager.class);
        if (manager == null) return;

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("Disconnected")
                .setContentText("Server: " + reason)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setOngoing(true)
                .setSilent(true);

        manager.notify(2001, builder.build());
    }

    private void showReconnectingNotification(String serverName, int attempt) {
        NotificationManager manager = context.getSystemService(NotificationManager.class);
        if (manager == null) return;

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("Reconnecting...")
                .setContentText(serverName + " (attempt " + attempt + "/" + maxRetries + ")")
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setOngoing(true)
                .setSilent(true);

        manager.notify(2002, builder.build());
    }

    private void showReconnectedNotification() {
        NotificationManager manager = context.getSystemService(NotificationManager.class);
        if (manager == null) return;

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("Reconnected!")
                .setContentText("Successfully reconnected to server")
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setAutoCancel(true);

        manager.notify(2003, builder.build());
        manager.cancel(2001);
        manager.cancel(2002);
    }

    private void showMaxRetriesNotification() {
        NotificationManager manager = context.getSystemService(NotificationManager.class);
        if (manager == null) return;

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("Reconnect Failed")
                .setContentText("Max retries reached. Please reconnect manually.")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true);

        manager.notify(2004, builder.build());
        manager.cancel(2001);
        manager.cancel(2002);
    }

    public void cleanup() {
        stopReconnect();
        disposables.clear();
    }
}
