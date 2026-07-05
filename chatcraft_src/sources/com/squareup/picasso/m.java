package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

/* compiled from: LruCache.java */
/* loaded from: classes.dex */
public final class m implements d {

    /* renamed from: b, reason: collision with root package name */
    final LruCache<String, a> f4132b;

    public m(Context context) {
        this(ad.b(context));
    }

    public m(int i) {
        this.f4132b = new LruCache<String, a>(i) { // from class: com.squareup.picasso.m.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int sizeOf(String str, a aVar) {
                return aVar.f4135b;
            }
        };
    }

    @Override // com.squareup.picasso.d
    public Bitmap a(String str) {
        a aVar = this.f4132b.get(str);
        if (aVar != null) {
            return aVar.f4134a;
        }
        return null;
    }

    @Override // com.squareup.picasso.d
    public void a(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        int iA = ad.a(bitmap);
        if (iA > b()) {
            this.f4132b.remove(str);
        } else {
            this.f4132b.put(str, new a(bitmap, iA));
        }
    }

    @Override // com.squareup.picasso.d
    public int a() {
        return this.f4132b.size();
    }

    @Override // com.squareup.picasso.d
    public int b() {
        return this.f4132b.maxSize();
    }

    /* compiled from: LruCache.java */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        final Bitmap f4134a;

        /* renamed from: b, reason: collision with root package name */
        final int f4135b;

        a(Bitmap bitmap, int i) {
            this.f4134a = bitmap;
            this.f4135b = i;
        }
    }
}
