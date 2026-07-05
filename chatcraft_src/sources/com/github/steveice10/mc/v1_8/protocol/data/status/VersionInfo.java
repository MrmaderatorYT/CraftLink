package com.github.steveice10.mc.v1_8.protocol.data.status;

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
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VersionInfo versionInfo = (VersionInfo) obj;
        return this.protocol == versionInfo.protocol && this.name.equals(versionInfo.name);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.protocol;
    }
}
