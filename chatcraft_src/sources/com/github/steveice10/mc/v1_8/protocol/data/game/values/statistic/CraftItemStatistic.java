package com.github.steveice10.mc.v1_8.protocol.data.game.values.statistic;

/* loaded from: classes.dex */
public class CraftItemStatistic implements Statistic {
    private int id;

    public CraftItemStatistic(int i) {
        this.id = i;
    }

    public int getId() {
        return this.id;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.id == ((CraftItemStatistic) obj).id;
    }

    public int hashCode() {
        return this.id;
    }
}
