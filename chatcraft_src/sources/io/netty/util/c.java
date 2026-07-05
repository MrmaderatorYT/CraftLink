package io.netty.util;

/* compiled from: AttributeKey.java */
/* loaded from: classes.dex */
public final class c<T> extends a<c<T>> {

    /* renamed from: a, reason: collision with root package name */
    private static final h<c<Object>> f4713a = new h<c<Object>>() { // from class: io.netty.util.c.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c<Object> b(int i, String str) {
            return new c<>(i, str);
        }
    };

    private c(int i, String str) {
        super(i, str);
    }
}
