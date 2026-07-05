package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class bje {

    /* renamed from: a, reason: collision with root package name */
    public final int f2727a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f2728b;
    public final Map<String, String> c;
    public final List<bfd> d;
    public final boolean e;
    private final long f;

    /* JADX WARN: Illegal instructions before constructor call */
    @Deprecated
    public bje(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        List arrayList;
        if (map == null) {
            arrayList = null;
        } else if (map.isEmpty()) {
            arrayList = Collections.emptyList();
        } else {
            arrayList = new ArrayList(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new bfd(entry.getKey(), entry.getValue()));
            }
        }
        this(i, bArr, map, arrayList, z, j);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public bje(int i, byte[] bArr, boolean z, long j, List<bfd> list) {
        Map treeMap;
        if (list == null) {
            treeMap = null;
        } else if (list.isEmpty()) {
            treeMap = Collections.emptyMap();
        } else {
            treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (bfd bfdVar : list) {
                treeMap.put(bfdVar.a(), bfdVar.b());
            }
        }
        this(i, bArr, treeMap, list, z, j);
    }

    @Deprecated
    public bje(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0L);
    }

    private bje(int i, byte[] bArr, Map<String, String> map, List<bfd> list, boolean z, long j) {
        this.f2727a = i;
        this.f2728b = bArr;
        this.c = map;
        if (list == null) {
            this.d = null;
        } else {
            this.d = Collections.unmodifiableList(list);
        }
        this.e = z;
        this.f = j;
    }
}
