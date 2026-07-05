package com.google.gson;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: DefaultDateTypeAdapter.java */
/* loaded from: classes.dex */
final class a extends t<Date> {

    /* renamed from: a, reason: collision with root package name */
    private final Class<? extends Date> f3905a;

    /* renamed from: b, reason: collision with root package name */
    private final List<DateFormat> f3906b = new ArrayList();

    a(Class<? extends Date> cls, String str) {
        this.f3905a = a(cls);
        this.f3906b.add(new SimpleDateFormat(str, Locale.US));
        if (Locale.getDefault().equals(Locale.US)) {
            return;
        }
        this.f3906b.add(new SimpleDateFormat(str));
    }

    public a(Class<? extends Date> cls, int i, int i2) {
        this.f3905a = a(cls);
        this.f3906b.add(DateFormat.getDateTimeInstance(i, i2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.f3906b.add(DateFormat.getDateTimeInstance(i, i2));
        }
        if (com.google.gson.b.e.b()) {
            this.f3906b.add(com.google.gson.b.j.a(i, i2));
        }
    }

    private static Class<? extends Date> a(Class<? extends Date> cls) {
        if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
            return cls;
        }
        throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
    }

    @Override // com.google.gson.t
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void write(com.google.gson.stream.c cVar, Date date) throws IOException {
        if (date == null) {
            cVar.f();
            return;
        }
        synchronized (this.f3906b) {
            cVar.b(this.f3906b.get(0).format(date));
        }
    }

    @Override // com.google.gson.t
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Date read(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.f() == com.google.gson.stream.b.NULL) {
            aVar.j();
            return null;
        }
        Date dateA = a(aVar.h());
        if (this.f3905a == Date.class) {
            return dateA;
        }
        if (this.f3905a == Timestamp.class) {
            return new Timestamp(dateA.getTime());
        }
        if (this.f3905a == java.sql.Date.class) {
            return new java.sql.Date(dateA.getTime());
        }
        throw new AssertionError();
    }

    private Date a(String str) {
        synchronized (this.f3906b) {
            Iterator<DateFormat> it = this.f3906b.iterator();
            while (it.hasNext()) {
                try {
                    return it.next().parse(str);
                } catch (ParseException unused) {
                }
            }
            try {
                return com.google.gson.b.a.a.a.a(str, new ParsePosition(0));
            } catch (ParseException e) {
                throw new JsonSyntaxException(str, e);
            }
        }
    }

    public String toString() {
        DateFormat dateFormat = this.f3906b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }
}
