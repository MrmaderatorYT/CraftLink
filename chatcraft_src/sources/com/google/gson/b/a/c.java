package com.google.gson.b.a;

import com.google.gson.JsonSyntaxException;
import com.google.gson.t;
import com.google.gson.u;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: DateTypeAdapter.java */
/* loaded from: classes.dex */
public final class c extends t<Date> {

    /* renamed from: a, reason: collision with root package name */
    public static final u f3913a = new u() { // from class: com.google.gson.b.a.c.1
        @Override // com.google.gson.u
        public <T> t<T> a(com.google.gson.f fVar, com.google.gson.c.a<T> aVar) {
            if (aVar.a() == Date.class) {
                return new c();
            }
            return null;
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private final List<DateFormat> f3914b = new ArrayList();

    public c() {
        this.f3914b.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.f3914b.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (com.google.gson.b.e.b()) {
            this.f3914b.add(com.google.gson.b.j.a(2, 2));
        }
    }

    @Override // com.google.gson.t
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Date read(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.f() == com.google.gson.stream.b.NULL) {
            aVar.j();
            return null;
        }
        return a(aVar.h());
    }

    private synchronized Date a(String str) {
        Iterator<DateFormat> it = this.f3914b.iterator();
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

    @Override // com.google.gson.t
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public synchronized void write(com.google.gson.stream.c cVar, Date date) {
        if (date == null) {
            cVar.f();
        } else {
            cVar.b(this.f3914b.get(0).format(date));
        }
    }
}
