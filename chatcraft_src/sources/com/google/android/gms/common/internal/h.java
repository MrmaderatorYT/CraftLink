package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class h {
    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a a(Object obj) {
        return new a(obj);
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<String> f1730a;

        /* renamed from: b, reason: collision with root package name */
        private final Object f1731b;

        private a(Object obj) {
            this.f1731b = i.a(obj);
            this.f1730a = new ArrayList();
        }

        public final a a(String str, Object obj) {
            List<String> list = this.f1730a;
            String str2 = (String) i.a(str);
            String strValueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(strValueOf).length());
            sb.append(str2);
            sb.append("=");
            sb.append(strValueOf);
            list.add(sb.toString());
            return this;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f1731b.getClass().getSimpleName());
            sb.append('{');
            int size = this.f1730a.size();
            for (int i = 0; i < size; i++) {
                sb.append(this.f1730a.get(i));
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }
}
