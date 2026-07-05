package com.google.android.gms.common.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class d {
    private static <T> Set<T> a(int i, boolean z) {
        float f = z ? 0.75f : 1.0f;
        if (i <= (z ? 128 : 256)) {
            return new androidx.b.b(i);
        }
        return new HashSet(i, f);
    }

    @Deprecated
    public static <T> Set<T> a(T t, T t2, T t3) {
        Set setA = a(3, false);
        setA.add(t);
        setA.add(t2);
        setA.add(t3);
        return Collections.unmodifiableSet(setA);
    }

    @Deprecated
    public static <T> Set<T> a(T... tArr) {
        switch (tArr.length) {
            case 0:
                return Collections.emptySet();
            case 1:
                return Collections.singleton(tArr[0]);
            case 2:
                T t = tArr[0];
                T t2 = tArr[1];
                Set setA = a(2, false);
                setA.add(t);
                setA.add(t2);
                return Collections.unmodifiableSet(setA);
            case 3:
                return a(tArr[0], tArr[1], tArr[2]);
            case 4:
                T t3 = tArr[0];
                T t4 = tArr[1];
                T t5 = tArr[2];
                T t6 = tArr[3];
                Set setA2 = a(4, false);
                setA2.add(t3);
                setA2.add(t4);
                setA2.add(t5);
                setA2.add(t6);
                return Collections.unmodifiableSet(setA2);
            default:
                Set setA3 = a(tArr.length, false);
                Collections.addAll(setA3, tArr);
                return Collections.unmodifiableSet(setA3);
        }
    }

    private static <K, V> Map<K, V> b(int i, boolean z) {
        if (i <= 256) {
            return new androidx.b.a(i);
        }
        return new HashMap(i, 1.0f);
    }

    public static <K, V> Map<K, V> a(K k, V v, K k2, V v2, K k3, V v3) {
        Map mapB = b(3, false);
        mapB.put(k, v);
        mapB.put(k2, v2);
        mapB.put(k3, v3);
        return Collections.unmodifiableMap(mapB);
    }

    public static <K, V> Map<K, V> a(K[] kArr, V[] vArr) {
        if (kArr.length != vArr.length) {
            int length = kArr.length;
            int length2 = vArr.length;
            StringBuilder sb = new StringBuilder(66);
            sb.append("Key and values array lengths not equal: ");
            sb.append(length);
            sb.append(" != ");
            sb.append(length2);
            throw new IllegalArgumentException(sb.toString());
        }
        switch (kArr.length) {
            case 0:
                return Collections.emptyMap();
            case 1:
                return Collections.singletonMap(kArr[0], vArr[0]);
            default:
                Map mapB = b(kArr.length, false);
                for (int i = 0; i < kArr.length; i++) {
                    mapB.put(kArr[i], vArr[i]);
                }
                return Collections.unmodifiableMap(mapB);
        }
    }
}
