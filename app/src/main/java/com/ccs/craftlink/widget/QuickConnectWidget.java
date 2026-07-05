package com.ccs.craftlink.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;

import com.ccs.craftlink.MainActivity;
import com.ccs.craftlink.R;
import com.ccs.craftlink.model.MinecraftServer;
import com.ccs.craftlink.network.MinecraftConnection;
import com.ccs.craftlink.network.ServerManager;
import com.ccs.craftlink.theme.ThemeManager;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;

public class QuickConnectWidget extends AppWidgetProvider {
    private static final String TAG = "QuickConnectWidget";
    public static final String ACTION_CONNECT = "com.ccs.craftlink.ACTION_CONNECT";
    public static final String ACTION_DISCONNECT = "com.ccs.craftlink.ACTION_DISCONNECT";
    public static final String ACTION_UPDATE_STATUS = "com.ccs.craftlink.ACTION_WIDGET_UPDATE_STATUS";

    private static Disposable connectionDisposable;

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int id : appWidgetIds) {
            updateWidget(context, appWidgetManager, id);
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        String action = intent.getAction();

        if (ACTION_CONNECT.equals(action)) {
            ServerManager sm = ServerManager.getInstance(context);
            MinecraftServer server = getLastServer(sm);
            if (server != null) {
                Log.i(TAG, "Widget: connecting to " + server.getName());
                sm.connectToServer(server);

                // Immediately show "Connecting..." on all widgets
                updateAllWidgetsStatus(context, "Connecting…", Color.parseColor("#FFFFAA00"), true);

                // Observe connection state to update widget
                observeConnection(context, sm);
            }
        } else if (ACTION_DISCONNECT.equals(action)) {
            ServerManager sm = ServerManager.getInstance(context);
            Log.i(TAG, "Widget: disconnecting");
            sm.disconnectFromServer();
            updateAllWidgetsStatus(context, "Disconnected", Color.parseColor("#FFFF3B30"), false);
        } else if (ACTION_UPDATE_STATUS.equals(action)) {
            // Triggered externally to refresh widget state
            refreshAllWidgets(context);
        }
    }

    private void observeConnection(Context context, ServerManager sm) {
        if (connectionDisposable != null && !connectionDisposable.isDisposed()) {
            connectionDisposable.dispose();
        }

        MinecraftConnection conn = sm.getActiveConnection();
        if (conn == null) return;

        connectionDisposable = conn.observeConnectionState()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(state -> {
                    Log.d(TAG, "Widget observed state: " + state);
                    switch (state) {
                        case CONNECTING:
                            updateAllWidgetsStatus(context, "Connecting…", Color.parseColor("#FFFFAA00"), true);
                            break;
                        case CONNECTED:
                        case AUTHENTICATING:
                            updateAllWidgetsStatus(context, "Authenticating…", Color.parseColor("#FFFFAA00"), true);
                            break;
                        case PLAYING:
                            updateAllWidgetsStatus(context, "● Connected", Color.parseColor("#FF34C759"), true);
                            break;
                        case DISCONNECTED:
                            updateAllWidgetsStatus(context, "Disconnected", Color.parseColor("#FF8E8E93"), false);
                            if (connectionDisposable != null) connectionDisposable.dispose();
                            break;
                        case ERROR:
                            updateAllWidgetsStatus(context, "Connection Error", Color.parseColor("#FFFF3B30"), false);
                            if (connectionDisposable != null) connectionDisposable.dispose();
                            break;
                    }
                }, error -> {
                    Log.e(TAG, "Widget connection observe error", error);
                    updateAllWidgetsStatus(context, "Error", Color.parseColor("#FFFF3B30"), false);
                });
    }

    private void updateAllWidgetsStatus(Context context, String statusText, int statusColor, boolean isConnected) {
        AppWidgetManager mgr = AppWidgetManager.getInstance(context);

        // Update all widget variants
        updateWidgetClassStatus(context, mgr, QuickConnectWidget.class, R.layout.widget_quick_connect, statusText, statusColor, isConnected);
        updateWidgetClassStatus(context, mgr, QuickConnectWidget2x2.class, R.layout.widget_quick_connect_2x2, statusText, statusColor, isConnected);
        updateWidgetClassStatus(context, mgr, QuickConnectWidget4x1.class, R.layout.widget_quick_connect_4x1, statusText, statusColor, isConnected);
    }

    private void updateWidgetClassStatus(Context context, AppWidgetManager mgr, Class<?> widgetClass, int layoutId,
                                          String statusText, int statusColor, boolean isConnected) {
        ComponentName cn = new ComponentName(context, widgetClass);
        int[] ids = mgr.getAppWidgetIds(cn);
        for (int id : ids) {
            RemoteViews views = new RemoteViews(context.getPackageName(), layoutId);

            // Update status text
            views.setTextViewText(R.id.tv_widget_status, statusText);
            views.setTextColor(R.id.tv_widget_status, statusColor);
            views.setViewVisibility(R.id.tv_widget_status, View.VISIBLE);

            // Update button: Connect or Disconnect
            if (isConnected) {
                views.setTextViewText(R.id.btn_widget_connect, "Disconnect");
                views.setInt(R.id.btn_widget_connect, "setBackgroundResource", R.drawable.bg_button_danger);

                Intent disconnect = new Intent(context, widgetClass);
                disconnect.setAction(ACTION_DISCONNECT);
                disconnect.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, id);
                views.setOnClickPendingIntent(R.id.btn_widget_connect,
                        PendingIntent.getBroadcast(context, id + 1000, disconnect,
                                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE));
            } else {
                views.setTextViewText(R.id.btn_widget_connect, "Connect");
                views.setInt(R.id.btn_widget_connect, "setBackgroundResource", R.drawable.bg_button_primary);

                Intent connect = new Intent(context, widgetClass);
                connect.setAction(ACTION_CONNECT);
                connect.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, id);
                views.setOnClickPendingIntent(R.id.btn_widget_connect,
                        PendingIntent.getBroadcast(context, id, connect,
                                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE));
            }

            // Apply theme
            applyTheme(context, views);

            mgr.updateAppWidget(id, views);
        }
    }

    protected int getLayoutId() {
        return R.layout.widget_quick_connect;
    }

    protected void updateWidget(Context ctx, AppWidgetManager mgr, int id) {
        RemoteViews views = new RemoteViews(ctx.getPackageName(), getLayoutId());
        ServerManager sm = ServerManager.getInstance(ctx);
        MinecraftServer server = getLastServer(sm);

        if (server != null) {
            views.setTextViewText(R.id.tv_widget_server, server.getName() + "\n" + server.getAddress());
        } else {
            List<MinecraftServer> list = sm.getServers();
            if (!list.isEmpty()) {
                views.setTextViewText(R.id.tv_widget_server, list.get(0).getName());
            } else {
                views.setTextViewText(R.id.tv_widget_server, "Add a server first");
            }
        }

        // Check current connection status
        MinecraftConnection conn = sm.getActiveConnection();
        boolean isConnected = conn != null && conn.isConnected();

        if (isConnected) {
            views.setTextViewText(R.id.tv_widget_status, "● Connected");
            views.setTextColor(R.id.tv_widget_status, Color.parseColor("#FF34C759"));
            views.setViewVisibility(R.id.tv_widget_status, View.VISIBLE);

            views.setTextViewText(R.id.btn_widget_connect, "Disconnect");
            views.setInt(R.id.btn_widget_connect, "setBackgroundResource", R.drawable.bg_button_danger);

            Intent disconnect = new Intent(ctx, getClass());
            disconnect.setAction(ACTION_DISCONNECT);
            disconnect.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, id);
            views.setOnClickPendingIntent(R.id.btn_widget_connect,
                    PendingIntent.getBroadcast(ctx, id + 1000, disconnect,
                            PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE));

            // Start observing for state changes
            observeConnection(ctx, sm);
        } else {
            views.setViewVisibility(R.id.tv_widget_status, View.GONE);

            views.setTextViewText(R.id.btn_widget_connect, "Connect");
            views.setInt(R.id.btn_widget_connect, "setBackgroundResource", R.drawable.bg_button_primary);

            Intent connect = new Intent(ctx, getClass());
            connect.setAction(ACTION_CONNECT);
            connect.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, id);
            views.setOnClickPendingIntent(R.id.btn_widget_connect,
                    PendingIntent.getBroadcast(ctx, id, connect,
                            PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE));
        }

        applyTheme(ctx, views);

        Intent open = new Intent(ctx, MainActivity.class);
        views.setOnClickPendingIntent(R.id.tv_widget_server,
                PendingIntent.getActivity(ctx, 0, open, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE));

        mgr.updateAppWidget(id, views);
    }

    private void applyTheme(Context ctx, RemoteViews views) {
        ThemeManager.ThemeMode mode = ThemeManager.getInstance(ctx).getCurrentMode();
        boolean isDark = ThemeManager.isDarkMode(ctx);
        if (mode == ThemeManager.ThemeMode.DARK) isDark = true;
        if (mode == ThemeManager.ThemeMode.LIGHT) isDark = false;

        if (isDark) {
            views.setInt(R.id.widget_root, "setBackgroundResource", R.drawable.bg_widget_dark);
            views.setTextColor(R.id.tv_widget_server, Color.parseColor("#B0B5C0"));
        } else {
            views.setInt(R.id.widget_root, "setBackgroundResource", R.drawable.bg_widget_light);
            views.setTextColor(R.id.tv_widget_server, Color.parseColor("#6B6F7A"));
        }
    }

    public static void refreshAllWidgets(Context context) {
        AppWidgetManager mgr = AppWidgetManager.getInstance(context);

        refreshWidgetClass(context, mgr, QuickConnectWidget.class);
        refreshWidgetClass(context, mgr, QuickConnectWidget2x2.class);
        refreshWidgetClass(context, mgr, QuickConnectWidget4x1.class);
    }

    private static void refreshWidgetClass(Context context, AppWidgetManager mgr, Class<?> cls) {
        ComponentName cn = new ComponentName(context, cls);
        int[] ids = mgr.getAppWidgetIds(cn);
        if (ids.length > 0) {
            Intent intent = new Intent(context, cls);
            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids);
            context.sendBroadcast(intent);
        }
    }

    private MinecraftServer getLastServer(ServerManager sm) {
        MinecraftServer best = null;
        long bestTime = 0;
        for (MinecraftServer s : sm.getServers()) {
            if (s.getLastConnected() > bestTime) {
                bestTime = s.getLastConnected();
                best = s;
            }
        }
        return best;
    }
}
