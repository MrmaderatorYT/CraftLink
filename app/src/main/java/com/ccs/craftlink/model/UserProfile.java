package com.ccs.craftlink.model;

import java.io.Serializable;

public class UserProfile implements Serializable {
    private long id;
    private String username;
    private String password;
    private String nickname;
    private boolean autoLogin;
    private boolean saveCredentials;
    private long lastLogin;
    private String serverAddress;

    public UserProfile() {}

    public UserProfile(String username, String password) {
        this.username = username;
        this.password = password;
        this.autoLogin = true;
        this.saveCredentials = true;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public boolean isAutoLogin() { return autoLogin; }
    public void setAutoLogin(boolean autoLogin) { this.autoLogin = autoLogin; }
    public boolean isSaveCredentials() { return saveCredentials; }
    public void setSaveCredentials(boolean saveCredentials) { this.saveCredentials = saveCredentials; }
    public long getLastLogin() { return lastLogin; }
    public void setLastLogin(long lastLogin) { this.lastLogin = lastLogin; }
    public String getServerAddress() { return serverAddress; }
    public void setServerAddress(String serverAddress) { this.serverAddress = serverAddress; }

    public String getDisplayName() {
        return nickname != null && !nickname.isEmpty() ? nickname : username;
    }
}
