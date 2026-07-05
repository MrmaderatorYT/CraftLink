package com.github.steveice10.mc.auth.data;

import com.github.steveice10.mc.auth.exception.property.SignatureValidateException;
import com.github.steveice10.mc.auth.util.Base64;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public class GameProfile {
    private UUID id;
    private String name;
    private List<Property> properties;
    private Map<TextureType, Texture> textures;

    public enum TextureModel {
        NORMAL,
        SLIM
    }

    public enum TextureType {
        SKIN,
        CAPE
    }

    public GameProfile(String str, String str2) {
        this((str == null || str.equals(BuildConfig.FLAVOR)) ? null : UUID.fromString(str), str2);
    }

    public GameProfile(UUID uuid, String str) {
        if (uuid == null && (str == null || str.equals(BuildConfig.FLAVOR))) {
            throw new IllegalArgumentException("Name and ID cannot both be blank");
        }
        this.id = uuid;
        this.name = str;
    }

    public boolean isComplete() {
        return (this.id == null || this.name == null || this.name.equals(BuildConfig.FLAVOR)) ? false : true;
    }

    public UUID getId() {
        return this.id;
    }

    public String getIdAsString() {
        return this.id != null ? this.id.toString() : BuildConfig.FLAVOR;
    }

    public String getName() {
        return this.name;
    }

    public List<Property> getProperties() {
        if (this.properties == null) {
            this.properties = new ArrayList();
        }
        return this.properties;
    }

    public Property getProperty(String str) {
        for (Property property : getProperties()) {
            if (property.getName().equals(str)) {
                return property;
            }
        }
        return null;
    }

    public Map<TextureType, Texture> getTextures() {
        if (this.textures == null) {
            this.textures = new HashMap();
        }
        return this.textures;
    }

    public Texture getTexture(TextureType textureType) {
        return getTextures().get(textureType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GameProfile gameProfile = (GameProfile) obj;
        if (this.id == null ? gameProfile.id == null : this.id.equals(gameProfile.id)) {
            if (this.name != null) {
                if (this.name.equals(gameProfile.name)) {
                    return true;
                }
            } else if (gameProfile.name == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.id != null ? this.id.hashCode() : 0) * 31) + (this.name != null ? this.name.hashCode() : 0);
    }

    public String toString() {
        return "GameProfile{id=" + this.id + ", name=" + this.name + ", properties=" + getProperties() + ", textures=" + getTextures() + "}";
    }

    public static class Property {
        private String name;
        private String signature;
        private String value;

        public Property(String str, String str2) {
            this(str, str2, null);
        }

        public Property(String str, String str2, String str3) {
            this.name = str;
            this.value = str2;
            this.signature = str3;
        }

        public String getName() {
            return this.name;
        }

        public String getValue() {
            return this.value;
        }

        public String getSignature() {
            return this.signature;
        }

        public boolean hasSignature() {
            return this.signature != null;
        }

        public boolean isSignatureValid(PublicKey publicKey) throws SignatureValidateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
            if (!hasSignature()) {
                return false;
            }
            try {
                Signature signature = Signature.getInstance("SHA1withRSA");
                signature.initVerify(publicKey);
                signature.update(this.value.getBytes());
                return signature.verify(Base64.decode(this.signature.getBytes("UTF-8")));
            } catch (Exception e) {
                throw new SignatureValidateException("Could not validate property signature.", e);
            }
        }

        public String toString() {
            return "Property{name=" + this.name + ", value=" + this.value + ", signature=" + this.signature + "}";
        }
    }

    public static class Texture {
        private Map<String, String> metadata;
        private String url;

        public Texture(String str, Map<String, String> map) {
            this.url = str;
            this.metadata = map;
        }

        public String getURL() {
            return this.url;
        }

        public TextureModel getModel() {
            String str = this.metadata != null ? this.metadata.get("model") : null;
            return (str == null || !str.equals("slim")) ? TextureModel.NORMAL : TextureModel.SLIM;
        }

        public String getHash() {
            String strSubstring = this.url.endsWith("/") ? this.url.substring(0, this.url.length() - 1) : this.url;
            int iLastIndexOf = strSubstring.lastIndexOf("/");
            int iLastIndexOf2 = strSubstring.lastIndexOf(".");
            if (iLastIndexOf2 < iLastIndexOf) {
                iLastIndexOf2 = strSubstring.length();
            }
            int i = iLastIndexOf + 1;
            if (iLastIndexOf2 == -1) {
                iLastIndexOf2 = strSubstring.length();
            }
            return strSubstring.substring(i, iLastIndexOf2);
        }

        public String toString() {
            return "ProfileTexture{url=" + this.url + ", model=" + getModel() + ", hash=" + getHash() + "}";
        }
    }
}
