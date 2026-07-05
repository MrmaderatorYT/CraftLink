package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class bqk {

    /* renamed from: a, reason: collision with root package name */
    private long f2971a;

    /* renamed from: b, reason: collision with root package name */
    private Bundle f2972b;
    private int c;
    private List<String> d;
    private boolean e;
    private int f;
    private boolean g;
    private String h;
    private bty i;
    private Location j;
    private String k;
    private Bundle l;
    private Bundle m;
    private List<String> n;
    private String o;
    private String p;
    private boolean q;
    private bqc r;
    private int s;
    private String t;

    public bqk() {
        this.f2971a = -1L;
        this.f2972b = new Bundle();
        this.c = -1;
        this.d = new ArrayList();
        this.e = false;
        this.f = -1;
        this.g = false;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = new Bundle();
        this.m = new Bundle();
        this.n = new ArrayList();
        this.o = null;
        this.p = null;
        this.q = false;
        this.s = -1;
        this.t = null;
    }

    public bqk(bqj bqjVar) {
        this.f2971a = bqjVar.f2970b;
        this.f2972b = bqjVar.c;
        this.c = bqjVar.d;
        this.d = bqjVar.e;
        this.e = bqjVar.f;
        this.f = bqjVar.g;
        this.g = bqjVar.h;
        this.h = bqjVar.i;
        this.i = bqjVar.j;
        this.j = bqjVar.k;
        this.k = bqjVar.l;
        this.l = bqjVar.m;
        this.m = bqjVar.n;
        this.n = bqjVar.o;
        this.o = bqjVar.p;
        this.p = bqjVar.q;
        this.q = bqjVar.r;
        this.r = bqjVar.s;
        this.s = bqjVar.t;
        this.t = bqjVar.u;
    }

    public final bqj a() {
        return new bqj(8, this.f2971a, this.f2972b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t);
    }

    public final bqk a(Location location) {
        this.j = null;
        return this;
    }
}
