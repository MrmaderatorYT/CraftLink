package io.netty.util;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.Map;

/* compiled from: CharsetUtil.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f4761a = Charset.forName("UTF-16");

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f4762b = Charset.forName("UTF-16BE");
    public static final Charset c = Charset.forName("UTF-16LE");
    public static final Charset d = Charset.forName("UTF-8");
    public static final Charset e = Charset.forName("ISO-8859-1");
    public static final Charset f = Charset.forName("US-ASCII");
    private static final Charset[] g = {f4761a, f4762b, c, d, e, f};

    public static CharsetEncoder a(Charset charset, CodingErrorAction codingErrorAction, CodingErrorAction codingErrorAction2) {
        io.netty.util.a.j.a(charset, "charset");
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        charsetEncoderNewEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction2);
        return charsetEncoderNewEncoder;
    }

    public static CharsetEncoder a(Charset charset) {
        io.netty.util.a.j.a(charset, "charset");
        Map<Charset, CharsetEncoder> mapE = io.netty.util.a.d.b().e();
        CharsetEncoder charsetEncoder = mapE.get(charset);
        if (charsetEncoder != null) {
            charsetEncoder.reset().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
            return charsetEncoder;
        }
        CharsetEncoder charsetEncoderA = a(charset, CodingErrorAction.REPLACE, CodingErrorAction.REPLACE);
        mapE.put(charset, charsetEncoderA);
        return charsetEncoderA;
    }
}
