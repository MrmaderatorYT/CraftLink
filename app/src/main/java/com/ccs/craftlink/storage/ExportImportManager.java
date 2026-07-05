package com.ccs.craftlink.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;

import com.ccs.craftlink.model.MinecraftServer;
import com.ccs.craftlink.model.UserProfile;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExportImportManager {
    private static final String TAG = "ExportImportManager";
    private static ExportImportManager instance;
    private final Context context;
    private final Gson gson = new Gson();

    public static ExportImportManager getInstance(Context ctx) {
        if (instance == null) instance = new ExportImportManager(ctx.getApplicationContext());
        return instance;
    }

    private ExportImportManager(Context context) { this.context = context; }

    public String exportToJson() {
        Map<String, Object> data = new HashMap<>();
        data.put("version", 1);

        List<MinecraftServer> servers = loadList("craftlink_servers", "servers", new TypeToken<List<MinecraftServer>>() {}.getType());
        List<UserProfile> profiles = loadList("craftlink_profiles", "profiles", new TypeToken<List<UserProfile>>() {}.getType());

        Map<String, Object> settings = new HashMap<>();
        SharedPreferences tp = context.getSharedPreferences("craftlink_theme", Context.MODE_PRIVATE);
        settings.put("theme_mode", tp.getInt("theme_mode", 0));
        SharedPreferences ap = context.getSharedPreferences("craftlink_afk", Context.MODE_PRIVATE);
        settings.put("afk_enabled", ap.getBoolean("afk_enabled", false));
        settings.put("reconnect_interval", ap.getInt("reconnect_interval", 30));
        settings.put("anti_afk_movement", ap.getBoolean("anti_afk_movement", true));

        data.put("servers", servers);
        data.put("profiles", profiles);
        data.put("settings", settings);
        return gson.toJson(data);
    }

    public boolean importFromJson(String json) {
        try {
            Map<String, Object> root = gson.fromJson(json, new TypeToken<Map<String, Object>>() {}.getType());
            if (root == null) return false;

            if (root.containsKey("servers")) {
                List<MinecraftServer> servers = gson.fromJson(gson.toJson(root.get("servers")), new TypeToken<List<MinecraftServer>>() {}.getType());
                if (servers != null) saveList("craftlink_servers", "servers", servers);
            }
            if (root.containsKey("profiles")) {
                List<UserProfile> profiles = gson.fromJson(gson.toJson(root.get("profiles")), new TypeToken<List<UserProfile>>() {}.getType());
                if (profiles != null) saveList("craftlink_profiles", "profiles", profiles);
            }
            if (root.containsKey("settings")) {
                @SuppressWarnings("unchecked")
                Map<String, Object> settings = (Map<String, Object>) root.get("settings");
                if (settings != null) {
                    SharedPreferences tp = context.getSharedPreferences("craftlink_theme", Context.MODE_PRIVATE);
                    if (settings.containsKey("theme_mode")) tp.edit().putInt("theme_mode", ((Number) settings.get("theme_mode")).intValue()).apply();
                    SharedPreferences ap = context.getSharedPreferences("craftlink_afk", Context.MODE_PRIVATE);
                    if (settings.containsKey("afk_enabled")) ap.edit().putBoolean("afk_enabled", (Boolean) settings.get("afk_enabled")).apply();
                    if (settings.containsKey("reconnect_interval")) ap.edit().putInt("reconnect_interval", ((Number) settings.get("reconnect_interval")).intValue()).apply();
                    if (settings.containsKey("anti_afk_movement")) ap.edit().putBoolean("anti_afk_movement", (Boolean) settings.get("anti_afk_movement")).apply();
                }
            }
            return true;
        } catch (Exception e) {
            Log.e(TAG, "Import failed", e);
            return false;
        }
    }

    public String readUriContent(Uri uri) {
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(context.getContentResolver().openInputStream(uri)));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) sb.append(line).append("\n");
            r.close();
            return sb.toString();
        } catch (Exception e) { return null; }
    }

    public void writeUriContent(Uri uri, String content) {
        try {
            OutputStream o = context.getContentResolver().openOutputStream(uri);
            if (o != null) { o.write(content.getBytes()); o.close(); }
        } catch (Exception e) { Log.e(TAG, "Write failed", e); }
    }

    @SuppressWarnings("unchecked")
    private <T> List<T> loadList(String prefsName, String key, Type type) {
        try {
            SharedPreferences sp = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE);
            String json = sp.getString(key, "[]");
            return gson.fromJson(json, type);
        } catch (Exception e) { return new ArrayList<>(); }
    }

    private <T> void saveList(String prefsName, String key, List<T> list) {
        context.getSharedPreferences(prefsName, Context.MODE_PRIVATE).edit().putString(key, gson.toJson(list)).apply();
    }
}
