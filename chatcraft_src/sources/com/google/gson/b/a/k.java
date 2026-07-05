package com.google.gson.b.a;

import com.google.gson.JsonSyntaxException;
import com.google.gson.t;
import com.google.gson.u;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: TimeTypeAdapter.java */
/* loaded from: classes.dex */
public final class k extends t<Time> {

    /* renamed from: a, reason: collision with root package name */
    public static final u f3934a = new u() { // from class: com.google.gson.b.a.k.1
        @Override // com.google.gson.u
        public <T> t<T> a(com.google.gson.f fVar, com.google.gson.c.a<T> aVar) {
            if (aVar.a() == Time.class) {
                return new k();
            }
            return null;
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private final DateFormat f3935b = new SimpleDateFormat("hh:mm:ss a");

    @Override // com.google.gson.t
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public synchronized Time read(com.google.gson.stream.a aVar) {
        if (aVar.f() == com.google.gson.stream.b.NULL) {
            aVar.j();
            return null;
        }
        try {
            return new Time(this.f3935b.parse(aVar.h()).getTime());
        } catch (ParseException e) {
            throw new JsonSyntaxException(e);
        }
    }

    @Override // com.google.gson.t
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public synchronized void write(com.google.gson.stream.c cVar, Time time) {
        cVar.b(time == null ? null : this.f3935b.format((Date) time));
    }
}
