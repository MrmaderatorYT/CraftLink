package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes.dex */
public class zzbrl extends IOException {

    /* renamed from: a, reason: collision with root package name */
    private asf f3664a;

    public zzbrl(String str) {
        super(str);
        this.f3664a = null;
    }

    public final zzbrl a(asf asfVar) {
        this.f3664a = asfVar;
        return this;
    }

    static zzbrl a() {
        return new zzbrl("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzbrl b() {
        return new zzbrl("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzbrl c() {
        return new zzbrl("CodedInputStream encountered a malformed varint.");
    }

    static zzbrl d() {
        return new zzbrl("Protocol message contained an invalid tag (zero).");
    }

    static zzbrl e() {
        return new zzbrl("Protocol message end-group tag did not match expected tag.");
    }

    static zzbrm f() {
        return new zzbrm("Protocol message tag had invalid wire type.");
    }

    static zzbrl g() {
        return new zzbrl("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    static zzbrl h() {
        return new zzbrl("Failed to parse the message.");
    }

    static zzbrl i() {
        return new zzbrl("Protocol message had invalid UTF-8.");
    }
}
