package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event;

/* loaded from: classes.dex */
public final class ScalarEvent extends NodeEvent {
    private final ImplicitTuple implicit;
    private final Character style;
    private final String tag;
    private final String value;

    public ScalarEvent(String str, String str2, ImplicitTuple implicitTuple, String str3, Mark mark, Mark mark2, Character ch) {
        super(str, mark, mark2);
        this.tag = str2;
        this.implicit = implicitTuple;
        this.value = str3;
        this.style = ch;
    }

    public String getTag() {
        return this.tag;
    }

    public Character getStyle() {
        return this.style;
    }

    public String getValue() {
        return this.value;
    }

    public ImplicitTuple getImplicit() {
        return this.implicit;
    }

    @Override // org.yaml.snakeyaml.events.NodeEvent, org.yaml.snakeyaml.events.Event
    protected String getArguments() {
        return super.getArguments() + ", tag=" + this.tag + ", " + this.implicit + ", value=" + this.value;
    }

    @Override // org.yaml.snakeyaml.events.Event
    public boolean is(Event.ID id) {
        return Event.ID.Scalar == id;
    }
}
