package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event;

/* loaded from: classes.dex */
public final class AliasEvent extends NodeEvent {
    public AliasEvent(String str, Mark mark, Mark mark2) {
        super(str, mark, mark2);
    }

    @Override // org.yaml.snakeyaml.events.Event
    public boolean is(Event.ID id) {
        return Event.ID.Alias == id;
    }
}
