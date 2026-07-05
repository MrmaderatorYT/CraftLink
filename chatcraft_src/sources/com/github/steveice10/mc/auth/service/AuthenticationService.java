package com.github.steveice10.mc.auth.service;

import com.github.steveice10.mc.auth.data.GameProfile;
import com.github.steveice10.mc.auth.exception.request.InvalidCredentialsException;
import com.github.steveice10.mc.auth.exception.request.RequestException;
import com.github.steveice10.mc.auth.util.HTTP;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public class AuthenticationService {
    private static final String AUTHENTICATE_URL = "https://authserver.mojang.com/authenticate";
    private static final String BASE_URL = "https://authserver.mojang.com/";
    private static final String INVALIDATE_URL = "https://authserver.mojang.com/invalidate";
    private static final String REFRESH_URL = "https://authserver.mojang.com/refresh";
    private static final String VALIDATE_URL = "https://authserver.mojang.com/validate";
    private String accessToken;
    private String clientToken;
    private String id;
    private boolean loggedIn;
    private String password;
    private List<GameProfile> profiles;
    private List<GameProfile.Property> properties;
    private Proxy proxy;
    private GameProfile selectedProfile;
    private String username;

    public AuthenticationService() {
        this(UUID.randomUUID().toString());
    }

    public AuthenticationService(Proxy proxy) {
        this(UUID.randomUUID().toString(), proxy);
    }

    public AuthenticationService(String str) {
        this(str, Proxy.NO_PROXY);
    }

    public AuthenticationService(String str, Proxy proxy) {
        this.properties = new ArrayList();
        this.profiles = new ArrayList();
        if (str == null) {
            throw new IllegalArgumentException("ClientToken cannot be null.");
        }
        if (proxy == null) {
            throw new IllegalArgumentException("Proxy cannot be null.");
        }
        this.clientToken = str;
        this.proxy = proxy;
    }

    public String getClientToken() {
        return this.clientToken;
    }

    public String getUsername() {
        return this.id;
    }

    public void setUsername(String str) {
        if (this.loggedIn && this.selectedProfile != null) {
            throw new IllegalStateException("Cannot change username while user is logged in and profile is selected.");
        }
        this.username = str;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String str) {
        if (this.loggedIn && this.selectedProfile != null) {
            throw new IllegalStateException("Cannot change password while user is logged in and profile is selected.");
        }
        this.password = str;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        if (this.loggedIn && this.selectedProfile != null) {
            throw new IllegalStateException("Cannot change access token while user is logged in and profile is selected.");
        }
        this.accessToken = str;
    }

    public boolean isLoggedIn() {
        return this.loggedIn;
    }

    public String getId() {
        return this.id;
    }

    public List<GameProfile.Property> getProperties() {
        return isLoggedIn() ? new ArrayList(this.properties) : Collections.emptyList();
    }

    public List<GameProfile> getAvailableProfiles() {
        return this.profiles;
    }

    public GameProfile getSelectedProfile() {
        return this.selectedProfile;
    }

    public void login() {
        if (this.username == null || this.username.equals(BuildConfig.FLAVOR)) {
            throw new InvalidCredentialsException("Invalid username.");
        }
        if (this.accessToken != null && !this.accessToken.equals(BuildConfig.FLAVOR)) {
            loginWithToken();
        } else {
            if (this.password == null || this.password.equals(BuildConfig.FLAVOR)) {
                throw new InvalidCredentialsException("Invalid password.");
            }
            loginWithPassword();
        }
    }

    public void logout() {
        if (!this.loggedIn) {
            throw new IllegalStateException("Cannot log out while not logged in.");
        }
        HTTP.makeRequest(this.proxy, INVALIDATE_URL, new InvalidateRequest(this.clientToken, this.accessToken));
        this.accessToken = null;
        this.loggedIn = false;
        this.id = null;
        this.properties.clear();
        this.profiles.clear();
        this.selectedProfile = null;
    }

    public void selectGameProfile(GameProfile gameProfile) throws RequestException {
        if (!this.loggedIn) {
            throw new RequestException("Cannot change game profile while not logged in.");
        }
        if (this.selectedProfile != null) {
            throw new RequestException("Cannot change game profile when it is already selected.");
        }
        if (gameProfile != null && this.profiles.contains(gameProfile)) {
            RefreshResponse refreshResponse = (RefreshResponse) HTTP.makeRequest(this.proxy, REFRESH_URL, new RefreshRequest(this.clientToken, this.accessToken, gameProfile), RefreshResponse.class);
            if (refreshResponse.clientToken.equals(this.clientToken)) {
                this.accessToken = refreshResponse.accessToken;
                this.selectedProfile = refreshResponse.selectedProfile;
                return;
            }
            throw new RequestException("Server requested we change our client token. Don't know how to handle this!");
        }
        throw new IllegalArgumentException("Invalid profile '" + gameProfile + "'.");
    }

    public String toString() {
        return "UserAuthentication{clientToken=" + this.clientToken + ", username=" + this.username + ", accessToken=" + this.accessToken + ", loggedIn=" + this.loggedIn + ", profiles=" + this.profiles + ", selectedProfile=" + this.selectedProfile + "}";
    }

    private void loginWithPassword() throws RequestException {
        if (this.username == null || this.username.isEmpty()) {
            throw new InvalidCredentialsException("Invalid username.");
        }
        if (this.password == null || this.password.isEmpty()) {
            throw new InvalidCredentialsException("Invalid password.");
        }
        AuthenticationResponse authenticationResponse = (AuthenticationResponse) HTTP.makeRequest(this.proxy, AUTHENTICATE_URL, new AuthenticationRequest(this.username, this.password, this.clientToken), AuthenticationResponse.class);
        if (authenticationResponse.clientToken.equals(this.clientToken)) {
            if (authenticationResponse.user != null && authenticationResponse.user.id != null) {
                this.id = authenticationResponse.user.id;
            } else {
                this.id = this.username;
            }
            this.loggedIn = true;
            this.accessToken = authenticationResponse.accessToken;
            this.profiles = authenticationResponse.availableProfiles != null ? Arrays.asList(authenticationResponse.availableProfiles) : Collections.emptyList();
            this.selectedProfile = authenticationResponse.selectedProfile;
            this.properties.clear();
            if (authenticationResponse.user == null || authenticationResponse.user.properties == null) {
                return;
            }
            this.properties.addAll(authenticationResponse.user.properties);
            return;
        }
        throw new RequestException("Server requested we change our client token. Don't know how to handle this!");
    }

    private void loginWithToken() throws RequestException {
        if (this.id == null || this.id.isEmpty()) {
            if (this.username == null || this.username.isEmpty()) {
                throw new InvalidCredentialsException("Invalid uuid and username.");
            }
            this.id = this.username;
        }
        if (this.accessToken == null || this.accessToken.equals(BuildConfig.FLAVOR)) {
            throw new InvalidCredentialsException("Invalid access token.");
        }
        RefreshResponse refreshResponse = (RefreshResponse) HTTP.makeRequest(this.proxy, REFRESH_URL, new RefreshRequest(this.clientToken, this.accessToken, null), RefreshResponse.class);
        if (refreshResponse.clientToken.equals(this.clientToken)) {
            if (refreshResponse.user != null && refreshResponse.user.id != null) {
                this.id = refreshResponse.user.id;
            } else {
                this.id = this.username;
            }
            this.loggedIn = true;
            this.accessToken = refreshResponse.accessToken;
            this.profiles = refreshResponse.availableProfiles != null ? Arrays.asList(refreshResponse.availableProfiles) : Collections.emptyList();
            this.selectedProfile = refreshResponse.selectedProfile;
            this.properties.clear();
            if (refreshResponse.user == null || refreshResponse.user.properties == null) {
                return;
            }
            this.properties.addAll(refreshResponse.user.properties);
            return;
        }
        throw new RequestException("Server requested we change our client token. Don't know how to handle this!");
    }

    private static class Agent {
        private String name;
        private int version;

        protected Agent(String str, int i) {
            this.name = str;
            this.version = i;
        }
    }

    private static class User {
        public String id;
        public List<GameProfile.Property> properties;

        private User() {
        }
    }

    private static class AuthenticationRequest {
        private String clientToken;
        private String password;
        private String username;
        private Agent agent = new Agent("Minecraft", 1);
        private boolean requestUser = true;

        protected AuthenticationRequest(String str, String str2, String str3) {
            this.username = str;
            this.password = str2;
            this.clientToken = str3;
        }
    }

    private static class RefreshRequest {
        private String accessToken;
        private String clientToken;
        private boolean requestUser = true;
        private GameProfile selectedProfile;

        protected RefreshRequest(String str, String str2, GameProfile gameProfile) {
            this.clientToken = str;
            this.accessToken = str2;
            this.selectedProfile = gameProfile;
        }
    }

    private static class InvalidateRequest {
        private String accessToken;
        private String clientToken;

        protected InvalidateRequest(String str, String str2) {
            this.clientToken = str;
            this.accessToken = str2;
        }
    }

    private static class AuthenticationResponse {
        public String accessToken;
        public GameProfile[] availableProfiles;
        public String clientToken;
        public GameProfile selectedProfile;
        public User user;

        private AuthenticationResponse() {
        }
    }

    private static class RefreshResponse {
        public String accessToken;
        public GameProfile[] availableProfiles;
        public String clientToken;
        public GameProfile selectedProfile;
        public User user;

        private RefreshResponse() {
        }
    }
}
