package org.yaml.snakeyaml.resolver;

import java.util.regex.Pattern;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes.dex */
final class ResolverTuple {
    private final Pattern regexp;
    private final Tag tag;

    public ResolverTuple(Tag tag, Pattern pattern) {
        this.tag = tag;
        this.regexp = pattern;
    }

    public Tag getTag() {
        return this.tag;
    }

    public Pattern getRegexp() {
        return this.regexp;
    }

    public String toString() {
        return "Tuple tag=" + this.tag + " regexp=" + this.regexp;
    }
}
