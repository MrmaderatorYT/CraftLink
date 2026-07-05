package com.github.steveice10.mc.v1_9.protocol.data.status;

/* loaded from: classes.dex */
public class VersionInfo {
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
