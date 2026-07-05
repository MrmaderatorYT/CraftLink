package io.netty.handler.codec.http.multipart;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class HttpPostRequestEncoder {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Pattern, String> f4574a = new HashMap();

    public static class ErrorDataEncoderException extends Exception {
    }

    static {
        f4574a.put(Pattern.compile("\\*"), "%2A");
        f4574a.put(Pattern.compile("\\+"), "%20");
        f4574a.put(Pattern.compile("%7E"), "~");
    }
}
