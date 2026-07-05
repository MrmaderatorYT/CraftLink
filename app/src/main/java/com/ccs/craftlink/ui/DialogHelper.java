package com.ccs.craftlink.ui;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

import com.ccs.craftlink.R;
import com.ccs.craftlink.model.MinecraftServer;
import com.ccs.craftlink.model.UserProfile;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.materialswitch.MaterialSwitch;

public class DialogHelper {

    public interface OnServerDialogListener {
        void onServerAdded(MinecraftServer server);
        void onServerUpdated(MinecraftServer server);
    }

    public interface OnProfileDialogListener {
        void onProfileCreated(UserProfile profile);
        void onProfileUpdated(UserProfile profile);
    }

    public interface OnConfirmListener {
        void onConfirmed();
    }

    public interface OnNicknameListener {
        void onNicknameChanged(String newNickname);
    }

    private static Context getThemedContext(Context context) {
        return new android.view.ContextThemeWrapper(context, R.style.Theme_CraftLink);
    }

    public static void showAddServerDialog(Context context, OnServerDialogListener listener) {
        View view = LayoutInflater.from(getThemedContext(context)).inflate(R.layout.dialog_server, null);

        TextInputEditText etName = view.findViewById(R.id.et_server_name);
        TextInputEditText etAddress = view.findViewById(R.id.et_server_address);
        TextInputEditText etPort = view.findViewById(R.id.et_server_port);
        TextInputEditText etVersion = view.findViewById(R.id.et_server_version);
        ChipGroup chipGroup = view.findViewById(R.id.chip_group_server_type);

        new MaterialAlertDialogBuilder(getThemedContext(context))
                .setTitle(R.string.add_server)
                .setView(view)
                .setPositiveButton(R.string.add_server, (dialog, which) -> {
                    String name = getText(etName);
                    String address = getText(etAddress);
                    int port = 25565;
                    try {
                        port = Integer.parseInt(getText(etPort));
                    } catch (NumberFormatException ignored) {}
                    String version = getText(etVersion);
                    String serverType = getSelectedServerType(chipGroup);

                    if (!name.isEmpty() && !address.isEmpty()) {
                        listener.onServerAdded(new MinecraftServer(name, address, port, version, serverType));
                    }
                })
                .setNegativeButton(R.string.cancel, null)
                .show();
    }

    public static void showEditServerDialog(Context context, MinecraftServer server, OnServerDialogListener listener) {
        View view = LayoutInflater.from(getThemedContext(context)).inflate(R.layout.dialog_server, null);

        TextInputEditText etName = view.findViewById(R.id.et_server_name);
        TextInputEditText etAddress = view.findViewById(R.id.et_server_address);
        TextInputEditText etPort = view.findViewById(R.id.et_server_port);
        TextInputEditText etVersion = view.findViewById(R.id.et_server_version);
        ChipGroup chipGroup = view.findViewById(R.id.chip_group_server_type);

        etName.setText(server.getName());
        etAddress.setText(server.getAddress());
        etPort.setText(String.valueOf(server.getPort()));
        etVersion.setText(server.getVersion());
        setSelectedServerType(chipGroup, server.getServerType());

        new MaterialAlertDialogBuilder(getThemedContext(context))
                .setTitle(R.string.edit_server)
                .setView(view)
                .setPositiveButton(R.string.confirm, (dialog, which) -> {
                    server.setName(getText(etName));
                    server.setAddress(getText(etAddress));
                    try {
                        server.setPort(Integer.parseInt(getText(etPort)));
                    } catch (NumberFormatException ignored) {}
                    server.setVersion(getText(etVersion));
                    server.setServerType(getSelectedServerType(chipGroup));

                    listener.onServerUpdated(server);
                })
                .setNegativeButton(R.string.cancel, null)
                .show();
    }

    public static void showDeleteServerDialog(Context context, String serverName, OnConfirmListener listener) {
        new MaterialAlertDialogBuilder(getThemedContext(context))
                .setTitle(R.string.delete_server)
                .setMessage("Delete server \"" + serverName + "\"?")
                .setPositiveButton(R.string.yes, (dialog, which) -> listener.onConfirmed())
                .setNegativeButton(R.string.no, null)
                .show();
    }

    public static void showLoginDialog(Context context, OnProfileDialogListener listener) {
        View view = LayoutInflater.from(getThemedContext(context)).inflate(R.layout.dialog_profile, null);

        TextInputEditText etUsername = view.findViewById(R.id.et_username);
        TextInputEditText etPassword = view.findViewById(R.id.et_password);
        MaterialSwitch switchAutoLogin = view.findViewById(R.id.switch_auto_login);
        MaterialSwitch switchSaveCredentials = view.findViewById(R.id.switch_save_credentials);

        new MaterialAlertDialogBuilder(getThemedContext(context))
                .setTitle(R.string.login)
                .setView(view)
                .setPositiveButton(R.string.login, (dialog, which) -> {
                    String username = getText(etUsername);
                    String password = getText(etPassword);
                    boolean autoLogin = switchAutoLogin.isChecked();
                    boolean saveCredentials = switchSaveCredentials.isChecked();

                    if (!username.isEmpty() && !password.isEmpty()) {
                        UserProfile profile = new UserProfile(username, password);
                        profile.setAutoLogin(autoLogin);
                        profile.setSaveCredentials(saveCredentials);
                        listener.onProfileCreated(profile);
                    }
                })
                .setNegativeButton(R.string.cancel, null)
                .show();
    }

    public static void showRegisterDialog(Context context, OnProfileDialogListener listener) {
        View view = LayoutInflater.from(getThemedContext(context)).inflate(R.layout.dialog_profile, null);

        TextInputEditText etUsername = view.findViewById(R.id.et_username);
        TextInputEditText etPassword = view.findViewById(R.id.et_password);
        MaterialSwitch switchAutoLogin = view.findViewById(R.id.switch_auto_login);
        MaterialSwitch switchSaveCredentials = view.findViewById(R.id.switch_save_credentials);

        new MaterialAlertDialogBuilder(getThemedContext(context))
                .setTitle(R.string.register)
                .setView(view)
                .setPositiveButton(R.string.register, (dialog, which) -> {
                    String username = getText(etUsername);
                    String password = getText(etPassword);
                    boolean autoLogin = switchAutoLogin.isChecked();
                    boolean saveCredentials = switchSaveCredentials.isChecked();

                    if (!username.isEmpty() && !password.isEmpty()) {
                        UserProfile profile = new UserProfile(username, password);
                        profile.setAutoLogin(autoLogin);
                        profile.setSaveCredentials(saveCredentials);
                        listener.onProfileCreated(profile);
                    }
                })
                .setNegativeButton(R.string.cancel, null)
                .show();
    }

    public static void showChangeNicknameDialog(Context context, String currentNickname, OnNicknameListener listener) {
        View view = LayoutInflater.from(getThemedContext(context)).inflate(R.layout.dialog_nickname, null);

        TextInputEditText etName = view.findViewById(R.id.et_nickname);
        etName.setText(currentNickname);

        new MaterialAlertDialogBuilder(getThemedContext(context))
                .setTitle(R.string.change_nickname)
                .setView(view)
                .setPositiveButton(R.string.confirm, (dialog, which) -> {
                    String newNick = getText(etName);
                    if (!newNick.isEmpty()) {
                        Log.d("DialogHelper", "Nickname changed to: " + newNick);
                        listener.onNicknameChanged(newNick);
                    }
                })
                .setNegativeButton(R.string.cancel, null)
                .show();
    }

    public static void showAfkSettingsDialog(Context context, boolean currentAutoReconnect,
                                               int currentInterval, boolean currentMovement,
                                               OnConfirmListener listener) {
        View view = LayoutInflater.from(getThemedContext(context)).inflate(R.layout.dialog_server, null);

        new MaterialAlertDialogBuilder(getThemedContext(context))
                .setTitle(R.string.afk_mode)
                .setView(view)
                .setPositiveButton(R.string.confirm, (dialog, which) -> listener.onConfirmed())
                .setNegativeButton(R.string.cancel, null)
                .show();
    }

    public static void showConfirmDialog(Context context, String title, String message,
                                          OnConfirmListener listener) {
        new MaterialAlertDialogBuilder(getThemedContext(context))
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.yes, (dialog, which) -> listener.onConfirmed())
                .setNegativeButton(R.string.no, null)
                .show();
    }

    public static void showErrorDialog(Context context, String title, String message) {
        new MaterialAlertDialogBuilder(getThemedContext(context))
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.ok, null)
                .show();
    }

    public static void showInfoDialog(Context context, String title, String message) {
        new MaterialAlertDialogBuilder(getThemedContext(context))
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.ok, null)
                .show();
    }

    private static String getText(TextInputEditText editText) {
        if (editText.getText() != null) {
            return editText.getText().toString().trim();
        }
        return "";
    }

    private static String getSelectedServerType(ChipGroup chipGroup) {
        int checkedId = chipGroup.getCheckedChipId();
        if (checkedId == R.id.chip_vanilla) return "Vanilla";
        if (checkedId == R.id.chip_forge) return "Forge";
        if (checkedId == R.id.chip_bukkit) return "Bukkit";
        if (checkedId == R.id.chip_spigot) return "Spigot";
        if (checkedId == R.id.chip_sponge) return "Sponge";
        return "Vanilla";
    }

    private static void setSelectedServerType(ChipGroup chipGroup, String type) {
        switch (type) {
            case "Forge":
                chipGroup.check(R.id.chip_forge);
                break;
            case "Bukkit":
                chipGroup.check(R.id.chip_bukkit);
                break;
            case "Spigot":
                chipGroup.check(R.id.chip_spigot);
                break;
            case "Sponge":
                chipGroup.check(R.id.chip_sponge);
                break;
            default:
                chipGroup.check(R.id.chip_vanilla);
                break;
        }
    }
}
