package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
/* loaded from: classes.dex */
public final class bnj {

    /* renamed from: b, reason: collision with root package name */
    private final int f2876b;
    private final bni d = new bnn();

    /* renamed from: a, reason: collision with root package name */
    private final int f2875a = 6;
    private final int c = 0;

    public bnj(int i) {
        this.f2876b = i;
    }

    public final String a(ArrayList<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            String str = arrayList2.get(i);
            i++;
            sb.append(str.toLowerCase(Locale.US));
            sb.append('\n');
        }
        return a(sb.toString());
    }

    private final String a(String str) throws UnsupportedEncodingException {
        String[] strArrSplit = str.split("\n");
        if (strArrSplit.length == 0) {
            return BuildConfig.FLAVOR;
        }
        bnl bnlVar = new bnl();
        PriorityQueue priorityQueue = new PriorityQueue(this.f2876b, new bnk(this));
        for (String str2 : strArrSplit) {
            String[] strArrA = bnm.a(str2, false);
            if (strArrA.length != 0) {
                bnp.a(strArrA, this.f2876b, this.f2875a, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                bnlVar.a(this.d.a(((bnq) it.next()).f2881b));
            } catch (IOException e) {
                xe.b("Error while writing hash to byteStream", e);
            }
        }
        return bnlVar.toString();
    }
}
