package org.yaml.snakeyaml.events;

import java.util.Map;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event;

/* loaded from: classes.dex */
public final class DocumentStartEvent extends Event {
    private final boolean explicit;
    private final Map<String, String> tags;
    private final Integer[] version;

    public DocumentStartEvent(Mark mark, Mark mark2, boolean z, Integer[] numArr, Map<String, String> map) {
        super(mark, mark2);
        this.explicit = z;
        this.version = numArr;
        this.tags = map;
    }

    public boolean getExplicit() {
        return this.explicit;
    }

    public Integer[] getVersion() {
        return this.version;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    @Override // org.yaml.snakeyaml.events.Event
    public boolean is(Event.ID id) {
        return Event.ID.DocumentStart == id;
    }
}
