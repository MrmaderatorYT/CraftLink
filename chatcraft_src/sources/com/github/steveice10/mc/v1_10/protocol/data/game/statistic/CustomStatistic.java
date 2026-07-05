package com.github.steveice10.mc.v1_10.protocol.data.game.statistic;

import com.github.steveice10.mc.common.util.ObjectUtil;
import java.util.Objects;

/* loaded from: classes.dex */
public class CustomStatistic implements Statistic {
    private String name;

    public CustomStatistic(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CustomStatistic) {
            return Objects.equals(this.name, ((CustomStatistic) obj).name);
        }
        return false;
    }

    public int hashCode() {
        return ObjectUtil.hashCode(this.name);
    }

    public String toString() {
        return ObjectUtil.toString(this);
    }
}
