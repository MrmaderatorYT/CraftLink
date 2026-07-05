package com.github.steveice10.mc.common;

/* loaded from: classes.dex */
public class Mod {
    public String name;
    public String version;

    public Mod(String str, String str2) {
        this.name = str;
        this.version = str2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
