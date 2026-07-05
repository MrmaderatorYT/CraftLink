package com.ccs.craftlink.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.ccs.craftlink.model.UserProfile;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class ProfileManager {
    private static final String TAG = "ProfileManager";
    private static ProfileManager instance;

    private final Context context;
    private final SharedPreferences prefs;
    private final Gson gson;
    private final BehaviorSubject<UserProfile> activeProfile = BehaviorSubject.create();
    private final BehaviorSubject<List<UserProfile>> profiles = BehaviorSubject.createDefault(new ArrayList<>());

    public static synchronized ProfileManager getInstance(Context context) {
        if (instance == null) {
            instance = new ProfileManager(context.getApplicationContext());
        }
        return instance;
    }

    private ProfileManager(Context context) {
        this.context = context;
        this.prefs = context.getSharedPreferences("craftlink_profiles", Context.MODE_PRIVATE);
        this.gson = new Gson();
        loadProfiles();
    }

    public Observable<UserProfile> observeActiveProfile() {
        return activeProfile;
    }

    public Observable<List<UserProfile>> observeProfiles() {
        return profiles;
    }

    public UserProfile getActiveProfile() {
        return activeProfile.getValue();
    }

    public List<UserProfile> getAllProfiles() {
        return new ArrayList<>(profiles.getValue() != null ? profiles.getValue() : new ArrayList<>());
    }

    public void createProfile(String username, String password) {
        List<UserProfile> current = getAllProfiles();
        UserProfile profile = new UserProfile(username, password);
        profile.setId(System.currentTimeMillis());
        profile.setLastLogin(System.currentTimeMillis());

        boolean alreadyExists = false;
        for (UserProfile p : current) {
            if (p.getUsername().equalsIgnoreCase(username)) {
                p.setPassword(password);
                profile = p;
                alreadyExists = true;
                break;
            }
        }

        if (!alreadyExists) {
            current.add(profile);
        }

        saveProfiles(current);
        profiles.onNext(current);
        setActiveProfile(profile);
    }

    public void updateProfile(UserProfile profile) {
        List<UserProfile> current = getAllProfiles();
        for (int i = 0; i < current.size(); i++) {
            if (current.get(i).getId() == profile.getId()) {
                current.set(i, profile);
                break;
            }
        }
        saveProfiles(current);
        profiles.onNext(current);

        UserProfile active = getActiveProfile();
        if (active != null && active.getId() == profile.getId()) {
            activeProfile.onNext(profile);
        }
    }

    public void deleteProfile(long profileId) {
        List<UserProfile> current = getAllProfiles();
        current.removeIf(p -> p.getId() == profileId);
        saveProfiles(current);
        profiles.onNext(current);

        if (getActiveProfile() != null && getActiveProfile().getId() == profileId) {
            activeProfile.onNext(null);
        }
    }

    public void setActiveProfile(UserProfile profile) {
        if (profile != null) {
            profile.setLastLogin(System.currentTimeMillis());
            prefs.edit().putLong("active_profile_id", profile.getId()).apply();
        } else {
            prefs.edit().remove("active_profile_id").apply();
        }
        activeProfile.onNext(profile);
    }

    public void changeNickname(String newNickname) {
        UserProfile active = getActiveProfile();
        if (active != null) {
            active.setNickname(newNickname);
            updateProfile(active);
        }
    }

    public boolean hasSavedCredentials(String username) {
        List<UserProfile> current = getAllProfiles();
        for (UserProfile p : current) {
            if (p.getUsername().equalsIgnoreCase(username) && p.isSaveCredentials()) {
                return true;
            }
        }
        return false;
    }

    public UserProfile getSavedProfile(String username) {
        List<UserProfile> current = getAllProfiles();
        for (UserProfile p : current) {
            if (p.getUsername().equalsIgnoreCase(username)) {
                return p;
            }
        }
        return null;
    }

    private void loadProfiles() {
        try {
            String json = prefs.getString("profiles", "[]");
            Type type = new TypeToken<List<UserProfile>>() {}.getType();
            List<UserProfile> loaded = gson.fromJson(json, type);
            if (loaded == null) loaded = new ArrayList<>();

            long activeId = prefs.getLong("active_profile_id", -1);
            UserProfile active = null;
            for (UserProfile p : loaded) {
                if (p.getId() == activeId) {
                    active = p;
                    break;
                }
            }

            profiles.onNext(loaded);
            if (active != null) {
                activeProfile.onNext(active);
            } else if (!loaded.isEmpty()) {
                setActiveProfile(loaded.get(0));
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to load profiles", e);
            profiles.onNext(new ArrayList<>());
        }
    }

    private void saveProfiles(List<UserProfile> profileList) {
        prefs.edit().putString("profiles", gson.toJson(profileList)).apply();
    }
}
