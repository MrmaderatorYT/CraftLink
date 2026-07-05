package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.amw;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public final class ajn<P> {

    /* renamed from: a, reason: collision with root package name */
    private static final Charset f2017a = Charset.forName("UTF-8");

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentMap<String, List<ajp<P>>> f2018b = new ConcurrentHashMap();
    private ajp<P> c;

    public final ajp<P> a() {
        return this.c;
    }

    public final Collection<List<ajp<P>>> b() {
        return this.f2018b.values();
    }

    protected final void a(ajp<P> ajpVar) {
        this.c = ajpVar;
    }

    protected final ajp<P> a(P p, amw.b bVar) throws GeneralSecurityException {
        byte[] bArrArray;
        switch (bVar.e()) {
            case LEGACY:
            case CRUNCHY:
                bArrArray = ByteBuffer.allocate(5).put((byte) 0).putInt(bVar.d()).array();
                break;
            case TINK:
                bArrArray = ByteBuffer.allocate(5).put((byte) 1).putInt(bVar.d()).array();
                break;
            case RAW:
                bArrArray = ajd.f2013a;
                break;
            default:
                throw new GeneralSecurityException("unknown output prefix type");
        }
        ajp<P> ajpVar = new ajp<>(p, bArrArray, bVar.c(), bVar.e());
        ArrayList arrayList = new ArrayList();
        arrayList.add(ajpVar);
        String str = new String(ajpVar.b(), f2017a);
        List<ajp<P>> listPut = this.f2018b.put(str, Collections.unmodifiableList(arrayList));
        if (listPut != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(listPut);
            arrayList2.add(ajpVar);
            this.f2018b.put(str, Collections.unmodifiableList(arrayList2));
        }
        return ajpVar;
    }
}
