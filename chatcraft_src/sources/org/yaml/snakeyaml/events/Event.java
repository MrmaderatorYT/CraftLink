package org.yaml.snakeyaml.events;

import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.yaml.snakeyaml.error.Mark;

/* loaded from: classes.dex */
public abstract class Event {
    private final Mark endMark;
    private final Mark startMark;

    public enum ID {
        Alias,
        DocumentEnd,
        DocumentStart,
        MappingEnd,
        MappingStart,
        Scalar,
        SequenceEnd,
        SequenceStart,
        StreamEnd,
        StreamStart
    }

    protected String getArguments() {
        return BuildConfig.FLAVOR;
    }

    public abstract boolean is(ID id);

    public Event(Mark mark, Mark mark2) {
        this.startMark = mark;
        this.endMark = mark2;
    }

    public String toString() {
        return "<" + getClass().getName() + "(" + getArguments() + ")>";
    }

    public Mark getStartMark() {
        return this.startMark;
    }

    public Mark getEndMark() {
        return this.endMark;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Event) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }
}
