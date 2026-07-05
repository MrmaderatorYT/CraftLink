package com.github.steveice10.mc.v1_7_7.protocol.data.status;

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
}
