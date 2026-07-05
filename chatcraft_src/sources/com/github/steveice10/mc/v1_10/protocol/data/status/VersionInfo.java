package com.github.steveice10.mc.v1_10.protocol.data.status;

import com.github.steveice10.mc.v1_10.protocol.MinecraftConstants;

/* loaded from: classes.dex */
public class VersionInfo {
    public static final VersionInfo CURRENT = new VersionInfo(MinecraftConstants.GAME_VERSION, MinecraftConstants.PROTOCOL_VERSION);
    private String name;
    private int protocol;

    public VersionInfo(String str, int i) {
        this.name = str;
        this.protocol = i;
    }

    public String getVersionName() {
        return this.name;
    }

    public int getProtocolVersion() {
        return this.protocol;
    }

    public boolean equals(Object obj) {
        if (obj instanceof VersionInfo) {
            VersionInfo versionInfo = (VersionInfo) obj;
            if (this.name.equals(versionInfo.name) && this.protocol == versionInfo.protocol) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.protocol;
    }
}
