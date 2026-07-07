package com.ccs.craftlink.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.ccs.craftlink.BuildConfig;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ccs.craftlink.BuildConfig;
import com.ccs.craftlink.R;
import com.ccs.craftlink.afk.AFKManager;
import com.ccs.craftlink.autofeatures.AutoEatManager;
import com.ccs.craftlink.autofeatures.AutoReconnectManager;
import com.ccs.craftlink.autofeatures.PowerSaveManager;
import com.ccs.craftlink.theme.ThemeManager;
import com.ccs.craftlink.model.UserProfile;
import com.ccs.craftlink.storage.ProfileManager;
import com.ccs.craftlink.ui.DialogHelper;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.slider.Slider;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class SettingsFragment extends Fragment {
    private static final String TAG = "SettingsFragment";

    private TextView tvUsername;
    private TextView tvNickname;
    private MaterialButton btnLogin;
    private MaterialButton btnChangeNickname;
    private MaterialSwitch switchAfkEnabled;
    private MaterialSwitch switchAutoReconnect;
    private MaterialSwitch switchAntiAfkMovement;
    private TextView tvReconnectInterval;
    private Slider sliderReconnectInterval;
    private MaterialSwitch switchAutoEat;
    private TextView tvHungerStatus;
    private TextView tvHungerThreshold;
    private Slider sliderHungerThreshold;
    private RadioGroup rgPowerMode;
    private TextView tvPowerModeDescription;
    private RadioGroup rgThemeMode;
    private View viewNotConnectedAfk;
    private View viewNotConnectedSettings;

    private ProfileManager profileManager;
    private AFKManager afkManager;
    private AutoEatManager autoEatManager;
    private AutoReconnectManager autoReconnectManager;
    private PowerSaveManager powerSaveManager;
    private ThemeManager themeManager;
    private final CompositeDisposable disposables = new CompositeDisposable();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated");

        profileManager = ProfileManager.getInstance(requireContext());
        afkManager = AFKManager.getInstance(requireContext());
        autoEatManager = AutoEatManager.getInstance();
        autoReconnectManager = AutoReconnectManager.getInstance(requireContext());
        powerSaveManager = PowerSaveManager.getInstance();
        themeManager = ThemeManager.getInstance(requireContext());

        tvUsername = view.findViewById(R.id.tv_username);
        tvNickname = view.findViewById(R.id.tv_nickname);
        btnLogin = view.findViewById(R.id.btn_login);
        btnChangeNickname = view.findViewById(R.id.btn_change_nickname);
        switchAfkEnabled = view.findViewById(R.id.switch_afk_enabled);
        switchAutoReconnect = view.findViewById(R.id.switch_auto_reconnect);
        switchAntiAfkMovement = view.findViewById(R.id.switch_anti_afk_movement);
        tvReconnectInterval = view.findViewById(R.id.tv_reconnect_interval);
        sliderReconnectInterval = view.findViewById(R.id.slider_reconnect_interval);
        switchAutoEat = view.findViewById(R.id.switch_auto_eat);
        tvHungerStatus = view.findViewById(R.id.tv_hunger_status);
        tvHungerThreshold = view.findViewById(R.id.tv_hunger_threshold);
        sliderHungerThreshold = view.findViewById(R.id.slider_hunger_threshold);
        rgPowerMode = view.findViewById(R.id.rg_power_mode);
        tvPowerModeDescription = view.findViewById(R.id.tv_power_mode_description);
        rgThemeMode = view.findViewById(R.id.rg_theme_mode);
        viewNotConnectedSettings = view.findViewById(R.id.view_not_connected_settings);

        setupProfileSection();
        setupThemeSection();
        setupAfkSection();
        setupAutoReconnectSection();
        setupAutoEatSection();
        setupPowerSaveSection();
        setupVersionInfo();
        setupCreditsButton();
        observeProfile();
        observeConnection();
    }

    private void setupThemeSection() {
        switch (themeManager.getCurrentMode()) {
            case SYSTEM:
                rgThemeMode.check(R.id.rb_theme_system);
                break;
            case LIGHT:
                rgThemeMode.check(R.id.rb_theme_light);
                break;
            case DARK:
                rgThemeMode.check(R.id.rb_theme_dark);
                break;
        }

        rgThemeMode.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_theme_system) {
                themeManager.setThemeMode(ThemeManager.ThemeMode.SYSTEM);
            } else if (checkedId == R.id.rb_theme_light) {
                themeManager.setThemeMode(ThemeManager.ThemeMode.LIGHT);
            } else if (checkedId == R.id.rb_theme_dark) {
                themeManager.setThemeMode(ThemeManager.ThemeMode.DARK);
            }
        });
    }

    private void setupProfileSection() {
        btnLogin.setOnClickListener(v -> {
            Log.d(TAG, "Login button clicked");
            DialogHelper.showLoginDialog(requireContext(), new DialogHelper.OnProfileDialogListener() {
                @Override
                public void onProfileCreated(UserProfile profile) {
                    Log.d(TAG, "Profile created: " + profile.getUsername());
                    profileManager.createProfile(profile.getUsername(), profile.getPassword());
                    profileManager.updateProfile(profile);
                }

                @Override
                public void onProfileUpdated(UserProfile profile) {
                    Log.d(TAG, "Profile updated: " + profile.getUsername());
                    profileManager.updateProfile(profile);
                }
            });
        });

        btnChangeNickname.setOnClickListener(v -> {
            Log.d(TAG, "Change nickname button clicked");
            UserProfile active = profileManager.getActiveProfile();
            String current = active != null ? active.getDisplayName() : "";
            DialogHelper.showChangeNicknameDialog(requireContext(), current, newNick -> {
                Log.d(TAG, "Saving nickname: " + newNick);
                if (profileManager.getActiveProfile() == null) {
                    profileManager.createProfile(newNick, "");
                } else {
                    profileManager.changeNickname(newNick);
                }
            });
        });
    }

    private void setupAfkSection() {
        // AFK mode is coming soon — all controls disabled
        switchAfkEnabled.setChecked(false);
        switchAfkEnabled.setEnabled(false);

        switchAutoReconnect.setChecked(false);
        switchAutoReconnect.setEnabled(false);

        switchAntiAfkMovement.setChecked(false);
        switchAntiAfkMovement.setEnabled(false);

        sliderReconnectInterval.setEnabled(false);
        tvReconnectInterval.setEnabled(false);
    }

    private void setupAutoReconnectSection() {
        autoReconnectManager.setEnabled(true);
        autoReconnectManager.setReconnectDelaySeconds(30);
        autoReconnectManager.setMaxRetries(10);

        autoReconnectManager.setListener(new AutoReconnectManager.AutoReconnectListener() {
            @Override
            public void onReconnectAttempt(int attempt, int maxRetries, int delaySeconds) {
                Log.d(TAG, "Reconnect attempt " + attempt + "/" + maxRetries + " in " + delaySeconds + "s");
            }

            @Override
            public void onReconnectSuccess() {
                Log.i(TAG, "Reconnected successfully!");
            }

            @Override
            public void onReconnectFailed(String reason) {
                Log.e(TAG, "Reconnect failed: " + reason);
            }
        });
    }

    private void setupAutoEatSection() {
        switchAutoEat.setChecked(autoEatManager.isEnabled());
        sliderHungerThreshold.setValue(autoEatManager.getHungerThreshold());
        tvHungerThreshold.setText(String.valueOf(autoEatManager.getHungerThreshold()));
        updateHungerStatus();

        switchAutoEat.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Log.d(TAG, "Auto-Eat enabled: " + isChecked);
            autoEatManager.setEnabled(isChecked);
        });

        sliderHungerThreshold.addOnChangeListener((slider, value, fromUser) -> {
            int threshold = (int) value;
            autoEatManager.setHungerThreshold(threshold);
            tvHungerThreshold.setText(String.valueOf(threshold));
        });

        autoEatManager.setListener(new AutoEatManager.AutoEatListener() {
            @Override
            public void onEatAction(String foodName) {
                Log.i(TAG, "Auto-Eat: eating " + foodName);
            }

            @Override
            public void onStatusBar(int health, int hunger) {
                if (getActivity() != null) {
                    getActivity().runOnUiThread(() -> {
                        tvHungerStatus.setText("Hunger: " + hunger + "/20  Health: " + health + "/20");
                    });
                }
            }
        });
    }

    private void setupPowerSaveSection() {
        switch (powerSaveManager.getCurrentMode()) {
            case BALANCED:
                rgPowerMode.check(R.id.rb_balanced);
                tvPowerModeDescription.setText("Receiving: KeepAlive, Chat, Position, Inventory, Chunks, Health, Food");
                break;
            case LOW_POWER:
                rgPowerMode.check(R.id.rb_low_power);
                tvPowerModeDescription.setText("Receiving: KeepAlive, Chat, Position, Inventory, Chunks");
                break;
            case ULTRA_POWER_SAVING:
                rgPowerMode.check(R.id.rb_ultra_saving);
                tvPowerModeDescription.setText("Receiving: KeepAlive, Chat, Position only");
                break;
        }

        rgPowerMode.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_balanced) {
                powerSaveManager.setMode(PowerSaveManager.PowerMode.BALANCED);
                tvPowerModeDescription.setText("Receiving: KeepAlive, Chat, Position, Inventory, Chunks, Health, Food");
            } else if (checkedId == R.id.rb_low_power) {
                powerSaveManager.setMode(PowerSaveManager.PowerMode.LOW_POWER);
                tvPowerModeDescription.setText("Receiving: KeepAlive, Chat, Position, Inventory, Chunks");
            } else if (checkedId == R.id.rb_ultra_saving) {
                powerSaveManager.setMode(PowerSaveManager.PowerMode.ULTRA_POWER_SAVING);
                tvPowerModeDescription.setText("Receiving: KeepAlive, Chat, Position only");
            }
        });
    }

    private void updateHungerStatus() {
        tvHungerStatus.setText("Hunger: " + autoEatManager.getCurrentHunger() + "/20  Health: " + autoEatManager.getCurrentHealth() + "/20");
    }

    private void setupVersionInfo() {
        TextView tvVersion = getView() != null ? getView().findViewById(R.id.tv_version) : null;
        if (tvVersion != null) {
            tvVersion.setText(getString(R.string.version_label, BuildConfig.VERSION_NAME));
        }
    }

    private void setupCreditsButton() {
        MaterialButton btnCredits = getView() != null ? getView().findViewById(R.id.btn_credits) : null;
        if (btnCredits != null) {
            btnCredits.setOnClickListener(v -> DialogHelper.showInfoDialog(
                    requireContext(),
                    getString(R.string.credits),
                    getString(R.string.credits_message)));
        }
    }

    private void observeProfile() {
        disposables.add(profileManager.observeActiveProfile()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(profile -> {
                    if (profile != null) {
                        Log.d(TAG, "Active profile: " + profile.getUsername() + " nick=" + profile.getNickname());
                        tvUsername.setText(profile.getUsername());
                        tvNickname.setText(profile.getDisplayName());
                    } else {
                        Log.d(TAG, "No active profile");
                        tvUsername.setText("Not logged in");
                        tvNickname.setText("");
                    }
                }, e -> Log.e(TAG, "Profile observe error", e)));
    }

    private void observeConnection() {
        disposables.add(com.ccs.craftlink.network.ServerManager.getInstance(requireContext())
                .observeConnectionEvents()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(server -> {
                    com.ccs.craftlink.network.MinecraftConnection conn =
                            com.ccs.craftlink.network.ServerManager.getInstance(requireContext()).getActiveConnection();
                    boolean isConnected = conn != null && conn.isConnected();

                    View cardAfk = getView() != null ? getView().findViewById(R.id.card_afk) : null;
                    if (cardAfk != null) {
                        cardAfk.setAlpha(isConnected ? 1.0f : 0.5f);
                        cardAfk.setEnabled(isConnected);
                    }

                    if (viewNotConnectedAfk != null) {
                        viewNotConnectedAfk.setVisibility(isConnected ? View.GONE : View.VISIBLE);
                    }

                    if (viewNotConnectedSettings != null) {
                        viewNotConnectedSettings.setVisibility(isConnected ? View.GONE : View.VISIBLE);
                    }
                }, e -> Log.e(TAG, "Connection observe error", e)));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        disposables.clear();
    }
}
