package okhttp3.internal.http2;

import java.util.List;

/* compiled from: PushObserver.java */
/* loaded from: classes.dex */
public interface k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f5218a = new k() { // from class: okhttp3.internal.http2.k.1
        @Override // okhttp3.internal.http2.k
        public void a(int i, a aVar) {
        }

        @Override // okhttp3.internal.http2.k
        public boolean a(int i, List<b> list) {
            return true;
        }

        @Override // okhttp3.internal.http2.k
        public boolean a(int i, List<b> list, boolean z) {
            return true;
        }

        @Override // okhttp3.internal.http2.k
        public boolean a(int i, b.e eVar, int i2, boolean z) {
            eVar.h(i2);
            return true;
        }
    };

    void a(int i, a aVar);

    boolean a(int i, b.e eVar, int i2, boolean z);

    boolean a(int i, List<b> list);

    boolean a(int i, List<b> list, boolean z);
}
