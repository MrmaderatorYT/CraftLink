package okhttp3;

import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* compiled from: MediaType.java */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f5248a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f5249b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    private final String c;

    public String toString() {
        return this.c;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof u) && ((u) obj).c.equals(this.c);
    }

    public int hashCode() {
        return this.c.hashCode();
    }
}
