package com.github.steveice10.mc.v1_9_2.protocol.data.game.statistic;

/* loaded from: classes.dex */
public class BreakItemStatistic implements Statistic {
    private int id;

    public BreakItemStatistic(int i) {
        this.id = i;
    }

    public int getId() {
        return this.id;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.id == ((BreakItemStatistic) obj).id;
    }

    public int hashCode() {
        return this.id;
    }
}
