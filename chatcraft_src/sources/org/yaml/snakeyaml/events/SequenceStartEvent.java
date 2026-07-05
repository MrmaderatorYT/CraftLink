package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event;

/* loaded from: classes.dex */
public final class SequenceStartEvent extends CollectionStartEvent {
    public SequenceStartEvent(String str, String str2, boolean z, Mark mark, Mark mark2, Boolean bool) {
        super(str, str2, z, mark, mark2, bool);
    }

    @Override // org.yaml.snakeyaml.events.Event
    public boolean is(Event.ID id) {
        return Event.ID.SequenceStart == id;
    }
}
