package com.github.steveice10.mc.v1_9.protocol.data.game.world.sound;

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
        return (obj instanceof CustomSound) && this.name.equals(((CustomSound) obj).name);
    }

    public int hashCode() {
        return this.name.hashCode();
    }
}
