package com.google.gson.b.a;

import com.google.gson.JsonSyntaxException;
import com.google.gson.t;
import com.google.gson.u;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* compiled from: SqlDateTypeAdapter.java */
/* loaded from: classes.dex */
public final class j extends t<Date> {

    /* renamed from: a, reason: collision with root package name */
    public static final u f3932a = new u() { // from class: com.google.gson.b.a.j.1
        @Override // com.google.gson.u
        public <T> t<T> a(com.google.gson.f fVar, com.google.gson.c.a<T> aVar) {
            if (aVar.a() == Date.class) {
                return new j();
            }
            return null;
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private final DateFormat f3933b = new SimpleDateFormat("MMM d, yyyy");

    @Override // com.google.gson.t
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public synchronized Date read(com.google.gson.stream.a aVar) {
        if (aVar.f() == com.google.gson.stream.b.NULL) {
            aVar.j();
            return null;
        }
        try {
            return new Date(this.f3933b.parse(aVar.h()).getTime());
        } catch (ParseException e) {
            throw new JsonSyntaxException(e);
        }
    }

    @Override // com.google.gson.t
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public synchronized void write(com.google.gson.stream.c cVar, Date date) {
        cVar.b(date == null ? null : this.f3933b.format((java.util.Date) date));
    }
}
