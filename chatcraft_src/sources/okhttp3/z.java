package okhttp3;

import javax.annotation.Nullable;

/* compiled from: RequestBody.java */
/* loaded from: classes.dex */
public abstract class z {
    @Nullable
    public abstract u a();

    public abstract void a(b.d dVar);

    public long b() {
        return -1L;
    }

    public static z a(@Nullable u uVar, byte[] bArr) {
        return a(uVar, bArr, 0, bArr.length);
    }

    public static z a(@Nullable final u uVar, final byte[] bArr, final int i, final int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        okhttp3.internal.c.a(bArr.length, i, i2);
        return new z() { // from class: okhttp3.z.1
            @Override // okhttp3.z
            @Nullable
            public u a() {
                return uVar;
            }

            @Override // okhttp3.z
            public long b() {
                return i2;
            }

            @Override // okhttp3.z
            public void a(b.d dVar) {
                dVar.c(bArr, i, i2);
            }
        };
    }
}
