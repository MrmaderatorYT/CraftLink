package com.github.steveice10.mc.v1_8.protocol.data.game.values.world;

/* loaded from: classes.dex */
public class CustomSound implements Sound {
    private String name;

    public CustomSound(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.name.equals(((CustomSound) obj).name);
    }

    public int hashCode() {
        return this.name.hashCode();
    }
}
