package com.github.steveice10.mc.auth.service;

import com.github.steveice10.mc.auth.data.GameProfile;
import com.github.steveice10.mc.auth.exception.profile.ProfileLookupException;
import com.github.steveice10.mc.auth.exception.profile.ProfileNotFoundException;
import com.github.steveice10.mc.auth.exception.property.ProfileTextureException;
import com.github.steveice10.mc.auth.exception.request.RequestException;
import com.github.steveice10.mc.auth.util.Base64;
import com.github.steveice10.mc.auth.util.HTTP;
import com.github.steveice10.mc.auth.util.UUIDSerializer;
import java.net.Proxy;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import mattecarra.usavsursschat.ChatCraftActivity;

/* loaded from: classes.dex */
public class SessionService {
    private static final String BASE_URL = "https://sessionserver.mojang.com/session/minecraft/";
    private static final String HAS_JOINED_URL = "https://sessionserver.mojang.com/session/minecraft/hasJoined";
    private static final String JOIN_URL = "https://sessionserver.mojang.com/session/minecraft/join";
    private static final String PROFILE_URL = "https://sessionserver.mojang.com/session/minecraft/profile";
    private Proxy proxy;

    public String toString() {
        return "SessionService{}";
    }

    public SessionService() {
        this(Proxy.NO_PROXY);
    }

    public SessionService(Proxy proxy) {
        if (proxy == null) {
            throw new IllegalArgumentException("Proxy cannot be null.");
        }
        this.proxy = proxy;
    }

    public void joinServer(GameProfile gameProfile, String str, String str2) {
        try {
            HTTP.makeRequest(this.proxy, JOIN_URL, new JoinServerRequest(str, gameProfile.getId(), str2), null);
        } catch (RequestException e) {
            e.getMessage().equalsIgnoreCase("Access Token can not be null or empty.");
            throw e;
        }
    }

    public GameProfile getProfileByServer(String str, String str2) {
        HasJoinedResponse hasJoinedResponse = (HasJoinedResponse) HTTP.makeRequest(this.proxy, "https://sessionserver.mojang.com/session/minecraft/hasJoined?username=" + str + "&serverId=" + str2, null, HasJoinedResponse.class);
        if (hasJoinedResponse == null || hasJoinedResponse.id == null) {
            return null;
        }
        GameProfile gameProfile = new GameProfile(hasJoinedResponse.id, str);
        if (hasJoinedResponse.properties != null) {
            gameProfile.getProperties().addAll(hasJoinedResponse.properties);
        }
        return gameProfile;
    }

    public GameProfile fillProfileProperties(GameProfile gameProfile) throws ProfileNotFoundException, ProfileLookupException {
        if (gameProfile.getId() == null) {
            return gameProfile;
        }
        try {
            MinecraftProfileResponse minecraftProfileResponse = (MinecraftProfileResponse) HTTP.makeRequest(this.proxy, "https://sessionserver.mojang.com/session/minecraft/profile/" + UUIDSerializer.fromUUID(gameProfile.getId()) + "?unsigned=false", null, MinecraftProfileResponse.class);
            if (minecraftProfileResponse == null) {
                throw new ProfileNotFoundException("Couldn't fetch profile properties for " + gameProfile + " as the profile does not exist.");
            }
            if (minecraftProfileResponse.properties != null) {
                gameProfile.getProperties().addAll(minecraftProfileResponse.properties);
            }
            return gameProfile;
        } catch (RequestException e) {
            throw new ProfileLookupException("Couldn't look up profile properties for " + gameProfile + ".", e);
        }
    }

    public GameProfile fillProfileTextures(GameProfile gameProfile, boolean z) throws ProfileTextureException {
        GameProfile.Property property = gameProfile.getProperty("textures");
        if (property != null) {
            if (!property.hasSignature()) {
                throw new ProfileTextureException("Signature is missing from textures payload.");
            }
            if (!property.isSignatureValid(ChatCraftActivity.j)) {
                throw new ProfileTextureException("Textures payload has been tampered with. (signature invalid)");
            }
            try {
                MinecraftTexturesPayload minecraftTexturesPayload = (MinecraftTexturesPayload) ChatCraftActivity.k.a(new String(Base64.decode(property.getValue().getBytes("UTF-8"))), MinecraftTexturesPayload.class);
                if (minecraftTexturesPayload.profileId == null || !minecraftTexturesPayload.profileId.equals(gameProfile.getId())) {
                    throw new ProfileTextureException("Decrypted textures payload was for another user. (expected id " + gameProfile.getId() + " but was for " + minecraftTexturesPayload.profileId + ")");
                }
                if (minecraftTexturesPayload.profileName == null || !minecraftTexturesPayload.profileName.equals(gameProfile.getName())) {
                    throw new ProfileTextureException("Decrypted textures payload was for another user. (expected name " + gameProfile.getName() + " but was for " + minecraftTexturesPayload.profileName + ")");
                }
                if (z) {
                    if (minecraftTexturesPayload.isPublic) {
                        throw new ProfileTextureException("Decrypted textures payload was public when secure data is required.");
                    }
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(5, -1);
                    Date date = new Date(minecraftTexturesPayload.timestamp);
                    if (date.before(calendar.getTime())) {
                        throw new ProfileTextureException("Decrypted textures payload is too old. (" + date + ", needs to be at least " + calendar + ")");
                    }
                }
                if (minecraftTexturesPayload.textures != null) {
                    gameProfile.getTextures().putAll(minecraftTexturesPayload.textures);
                }
            } catch (Exception e) {
                throw new ProfileTextureException("Could not decode texture payload.", e);
            }
        }
        return gameProfile;
    }

    private static class JoinServerRequest {
        private String accessToken;
        private UUID selectedProfile;
        private String serverId;

        protected JoinServerRequest(String str, UUID uuid, String str2) {
            this.accessToken = str;
            this.selectedProfile = uuid;
            this.serverId = str2;
        }
    }

    private static class HasJoinedResponse {
        public UUID id;
        public List<GameProfile.Property> properties;

        private HasJoinedResponse() {
        }
    }

    private static class MinecraftProfileResponse {
        public UUID id;
        public String name;
        public List<GameProfile.Property> properties;

        private MinecraftProfileResponse() {
        }
    }

    private static class MinecraftTexturesPayload {
        public boolean isPublic;
        public UUID profileId;
        public String profileName;
        public Map<GameProfile.TextureType, GameProfile.Texture> textures;
        public long timestamp;

        private MinecraftTexturesPayload() {
        }
    }
}
