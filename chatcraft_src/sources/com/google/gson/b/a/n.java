package com.google.gson.b.a;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.p;
import com.google.gson.t;
import com.google.gson.u;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* compiled from: TypeAdapters.java */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final t<Class> f3943a = new t<Class>() { // from class: com.google.gson.b.a.n.1
        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, Class cls) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Class read(com.google.gson.stream.a aVar) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    }.nullSafe();

    /* renamed from: b, reason: collision with root package name */
    public static final u f3944b = a(Class.class, f3943a);
    public static final t<BitSet> c = new t<BitSet>() { // from class: com.google.gson.b.a.n.12
        /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0069 A[SYNTHETIC] */
        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.util.BitSet read(com.google.gson.stream.a r7) throws java.io.IOException {
            /*
                r6 = this;
                java.util.BitSet r0 = new java.util.BitSet
                r0.<init>()
                r7.a()
                com.google.gson.stream.b r1 = r7.f()
                r2 = 0
                r3 = 0
            Le:
                com.google.gson.stream.b r4 = com.google.gson.stream.b.END_ARRAY
                if (r1 == r4) goto L70
                int[] r4 = com.google.gson.b.a.n.AnonymousClass30.f3959a
                int r5 = r1.ordinal()
                r4 = r4[r5]
                r5 = 1
                switch(r4) {
                    case 1: goto L5e;
                    case 2: goto L59;
                    case 3: goto L35;
                    default: goto L1e;
                }
            L1e:
                com.google.gson.JsonSyntaxException r7 = new com.google.gson.JsonSyntaxException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Invalid bitset value type: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r7.<init>(r0)
                throw r7
            L35:
                java.lang.String r1 = r7.h()
                int r4 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L42
                if (r4 == 0) goto L40
                goto L64
            L40:
                r5 = 0
                goto L64
            L42:
                com.google.gson.JsonSyntaxException r7 = new com.google.gson.JsonSyntaxException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Error: Expecting: bitset number value (1, 0), Found: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r7.<init>(r0)
                throw r7
            L59:
                boolean r5 = r7.i()
                goto L64
            L5e:
                int r1 = r7.m()
                if (r1 == 0) goto L40
            L64:
                if (r5 == 0) goto L69
                r0.set(r3)
            L69:
                int r3 = r3 + 1
                com.google.gson.stream.b r1 = r7.f()
                goto Le
            L70:
                r7.b()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.b.a.n.AnonymousClass12.read(com.google.gson.stream.a):java.util.BitSet");
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, BitSet bitSet) throws IOException {
            cVar.b();
            int length = bitSet.length();
            for (int i2 = 0; i2 < length; i2++) {
                cVar.a(bitSet.get(i2) ? 1L : 0L);
            }
            cVar.c();
        }
    }.nullSafe();
    public static final u d = a(BitSet.class, c);
    public static final t<Boolean> e = new t<Boolean>() { // from class: com.google.gson.b.a.n.23
        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean read(com.google.gson.stream.a aVar) throws IOException {
            com.google.gson.stream.b bVarF = aVar.f();
            if (bVarF == com.google.gson.stream.b.NULL) {
                aVar.j();
                return null;
            }
            if (bVarF == com.google.gson.stream.b.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(aVar.h()));
            }
            return Boolean.valueOf(aVar.i());
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, Boolean bool) throws IOException {
            cVar.a(bool);
        }
    };
    public static final t<Boolean> f = new t<Boolean>() { // from class: com.google.gson.b.a.n.31
        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.f() == com.google.gson.stream.b.NULL) {
                aVar.j();
                return null;
            }
            return Boolean.valueOf(aVar.h());
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, Boolean bool) throws IOException {
            cVar.b(bool == null ? "null" : bool.toString());
        }
    };
    public static final u g = a(Boolean.TYPE, Boolean.class, e);
    public static final t<Number> h = new t<Number>() { // from class: com.google.gson.b.a.n.32
        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.f() == com.google.gson.stream.b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return Byte.valueOf((byte) aVar.m());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final u i = a(Byte.TYPE, Byte.class, h);
    public static final t<Number> j = new t<Number>() { // from class: com.google.gson.b.a.n.33
        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.f() == com.google.gson.stream.b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return Short.valueOf((short) aVar.m());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final u k = a(Short.TYPE, Short.class, j);
    public static final t<Number> l = new t<Number>() { // from class: com.google.gson.b.a.n.34
        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.f() == com.google.gson.stream.b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return Integer.valueOf(aVar.m());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final u m = a(Integer.TYPE, Integer.class, l);
    public static final t<AtomicInteger> n = new t<AtomicInteger>() { // from class: com.google.gson.b.a.n.35
        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AtomicInteger read(com.google.gson.stream.a aVar) {
            try {
                return new AtomicInteger(aVar.m());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, AtomicInteger atomicInteger) throws IOException {
            cVar.a(atomicInteger.get());
        }
    }.nullSafe();
    public static final u o = a(AtomicInteger.class, n);
    public static final t<AtomicBoolean> p = new t<AtomicBoolean>() { // from class: com.google.gson.b.a.n.36
        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AtomicBoolean read(com.google.gson.stream.a aVar) {
            return new AtomicBoolean(aVar.i());
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, AtomicBoolean atomicBoolean) throws IOException {
            cVar.a(atomicBoolean.get());
        }
    }.nullSafe();
    public static final u q = a(AtomicBoolean.class, p);
    public static final t<AtomicIntegerArray> r = new t<AtomicIntegerArray>() { // from class: com.google.gson.b.a.n.2
        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AtomicIntegerArray read(com.google.gson.stream.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.a();
            while (aVar.e()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.m()));
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }
            aVar.b();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i2 = 0; i2 < size; i2++) {
                atomicIntegerArray.set(i2, ((Integer) arrayList.get(i2)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            cVar.b();
            int length = atomicIntegerArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                cVar.a(atomicIntegerArray.get(i2));
            }
            cVar.c();
        }
    }.nullSafe();
    public static final u s = a(AtomicIntegerArray.class, r);
    public static final t<Number> t = new t<Number>() { // from class: com.google.gson.b.a.n.3
        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.f() == com.google.gson.stream.b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return Long.valueOf(aVar.l());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final t<Number> u = new t<Number>() { // from class: com.google.gson.b.a.n.4
        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.f() == com.google.gson.stream.b.NULL) {
                aVar.j();
                return null;
            }
            return Float.valueOf((float) aVar.k());
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final t<Number> v = new t<Number>() { // from class: com.google.gson.b.a.n.5
        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.f() == com.google.gson.stream.b.NULL) {
                aVar.j();
                return null;
            }
            return Double.valueOf(aVar.k());
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final t<Number> w = new t<Number>() { // from class: com.google.gson.b.a.n.6
        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            com.google.gson.stream.b bVarF = aVar.f();
            int i2 = AnonymousClass30.f3959a[bVarF.ordinal()];
            if (i2 != 1) {
                switch (i2) {
                    case 3:
                        break;
                    case 4:
                        aVar.j();
                        return null;
                    default:
                        throw new JsonSyntaxException("Expecting number, got: " + bVarF);
                }
            }
            return new com.google.gson.b.g(aVar.h());
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final u x = a(Number.class, w);
    public static final t<Character> y = new t<Character>() { // from class: com.google.gson.b.a.n.7
        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Character read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.f() == com.google.gson.stream.b.NULL) {
                aVar.j();
                return null;
            }
            String strH = aVar.h();
            if (strH.length() != 1) {
                throw new JsonSyntaxException("Expecting character, got: " + strH);
            }
            return Character.valueOf(strH.charAt(0));
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, Character ch) throws IOException {
            cVar.b(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final u z = a(Character.TYPE, Character.class, y);
    public static final t<String> A = new t<String>() { // from class: com.google.gson.b.a.n.8
        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String read(com.google.gson.stream.a aVar) throws IOException {
            com.google.gson.stream.b bVarF = aVar.f();
            if (bVarF == com.google.gson.stream.b.NULL) {
                aVar.j();
                return null;
            }
            if (bVarF == com.google.gson.stream.b.BOOLEAN) {
                return Boolean.toString(aVar.i());
            }
            return aVar.h();
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, String str) throws IOException {
            cVar.b(str);
        }
    };
    public static final t<BigDecimal> B = new t<BigDecimal>() { // from class: com.google.gson.b.a.n.9
        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.f() == com.google.gson.stream.b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return new BigDecimal(aVar.h());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, BigDecimal bigDecimal) throws IOException {
            cVar.a(bigDecimal);
        }
    };
    public static final t<BigInteger> C = new t<BigInteger>() { // from class: com.google.gson.b.a.n.10
        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigInteger read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.f() == com.google.gson.stream.b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return new BigInteger(aVar.h());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, BigInteger bigInteger) throws IOException {
            cVar.a(bigInteger);
        }
    };
    public static final u D = a(String.class, A);
    public static final t<StringBuilder> E = new t<StringBuilder>() { // from class: com.google.gson.b.a.n.11
        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuilder read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.f() == com.google.gson.stream.b.NULL) {
                aVar.j();
                return null;
            }
            return new StringBuilder(aVar.h());
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, StringBuilder sb) throws IOException {
            cVar.b(sb == null ? null : sb.toString());
        }
    };
    public static final u F = a(StringBuilder.class, E);
    public static final t<StringBuffer> G = new t<StringBuffer>() { // from class: com.google.gson.b.a.n.13
        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuffer read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.f() == com.google.gson.stream.b.NULL) {
                aVar.j();
                return null;
            }
            return new StringBuffer(aVar.h());
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, StringBuffer stringBuffer) throws IOException {
            cVar.b(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final u H = a(StringBuffer.class, G);
    public static final t<URL> I = new t<URL>() { // from class: com.google.gson.b.a.n.14
        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public URL read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.f() == com.google.gson.stream.b.NULL) {
                aVar.j();
                return null;
            }
            String strH = aVar.h();
            if ("null".equals(strH)) {
                return null;
            }
            return new URL(strH);
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, URL url) throws IOException {
            cVar.b(url == null ? null : url.toExternalForm());
        }
    };
    public static final u J = a(URL.class, I);
    public static final t<URI> K = new t<URI>() { // from class: com.google.gson.b.a.n.15
        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public URI read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.f() == com.google.gson.stream.b.NULL) {
                aVar.j();
                return null;
            }
            try {
                String strH = aVar.h();
                if ("null".equals(strH)) {
                    return null;
                }
                return new URI(strH);
            } catch (URISyntaxException e2) {
                throw new JsonIOException(e2);
            }
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, URI uri) throws IOException {
            cVar.b(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final u L = a(URI.class, K);
    public static final t<InetAddress> M = new t<InetAddress>() { // from class: com.google.gson.b.a.n.16
        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InetAddress read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.f() == com.google.gson.stream.b.NULL) {
                aVar.j();
                return null;
            }
            return InetAddress.getByName(aVar.h());
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, InetAddress inetAddress) throws IOException {
            cVar.b(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final u N = b(InetAddress.class, M);
    public static final t<UUID> O = new t<UUID>() { // from class: com.google.gson.b.a.n.17
        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UUID read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.f() == com.google.gson.stream.b.NULL) {
                aVar.j();
                return null;
            }
            return UUID.fromString(aVar.h());
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, UUID uuid) throws IOException {
            cVar.b(uuid == null ? null : uuid.toString());
        }
    };
    public static final u P = a(UUID.class, O);
    public static final t<Currency> Q = new t<Currency>() { // from class: com.google.gson.b.a.n.18
        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Currency read(com.google.gson.stream.a aVar) {
            return Currency.getInstance(aVar.h());
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, Currency currency) throws IOException {
            cVar.b(currency.getCurrencyCode());
        }
    }.nullSafe();
    public static final u R = a(Currency.class, Q);
    public static final u S = new u() { // from class: com.google.gson.b.a.n.19
        @Override // com.google.gson.u
        public <T> t<T> a(com.google.gson.f fVar, com.google.gson.c.a<T> aVar) {
            if (aVar.a() != Timestamp.class) {
                return null;
            }
            final t<T> tVarA = fVar.a((Class) Date.class);
            return (t<T>) new t<Timestamp>() { // from class: com.google.gson.b.a.n.19.1
                @Override // com.google.gson.t
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Timestamp read(com.google.gson.stream.a aVar2) {
                    Date date = (Date) tVarA.read(aVar2);
                    if (date != null) {
                        return new Timestamp(date.getTime());
                    }
                    return null;
                }

                @Override // com.google.gson.t
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void write(com.google.gson.stream.c cVar, Timestamp timestamp) {
                    tVarA.write(cVar, timestamp);
                }
            };
        }
    };
    public static final t<Calendar> T = new t<Calendar>() { // from class: com.google.gson.b.a.n.20
        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Calendar read(com.google.gson.stream.a aVar) throws IOException, NumberFormatException {
            if (aVar.f() == com.google.gson.stream.b.NULL) {
                aVar.j();
                return null;
            }
            aVar.c();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (aVar.f() != com.google.gson.stream.b.END_OBJECT) {
                String strG = aVar.g();
                int iM = aVar.m();
                if ("year".equals(strG)) {
                    i2 = iM;
                } else if ("month".equals(strG)) {
                    i3 = iM;
                } else if ("dayOfMonth".equals(strG)) {
                    i4 = iM;
                } else if ("hourOfDay".equals(strG)) {
                    i5 = iM;
                } else if ("minute".equals(strG)) {
                    i6 = iM;
                } else if ("second".equals(strG)) {
                    i7 = iM;
                }
            }
            aVar.d();
            return new GregorianCalendar(i2, i3, i4, i5, i6, i7);
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                cVar.f();
                return;
            }
            cVar.d();
            cVar.a("year");
            cVar.a(calendar.get(1));
            cVar.a("month");
            cVar.a(calendar.get(2));
            cVar.a("dayOfMonth");
            cVar.a(calendar.get(5));
            cVar.a("hourOfDay");
            cVar.a(calendar.get(11));
            cVar.a("minute");
            cVar.a(calendar.get(12));
            cVar.a("second");
            cVar.a(calendar.get(13));
            cVar.e();
        }
    };
    public static final u U = b(Calendar.class, GregorianCalendar.class, T);
    public static final t<Locale> V = new t<Locale>() { // from class: com.google.gson.b.a.n.21
        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Locale read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.f() == com.google.gson.stream.b.NULL) {
                aVar.j();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.h(), "_");
            String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (strNextToken2 == null && strNextToken3 == null) {
                return new Locale(strNextToken);
            }
            if (strNextToken3 == null) {
                return new Locale(strNextToken, strNextToken2);
            }
            return new Locale(strNextToken, strNextToken2, strNextToken3);
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, Locale locale) throws IOException {
            cVar.b(locale == null ? null : locale.toString());
        }
    };
    public static final u W = a(Locale.class, V);
    public static final t<com.google.gson.l> X = new t<com.google.gson.l>() { // from class: com.google.gson.b.a.n.22
        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.gson.l read(com.google.gson.stream.a aVar) throws IOException {
            switch (AnonymousClass30.f3959a[aVar.f().ordinal()]) {
                case 1:
                    return new p((Number) new com.google.gson.b.g(aVar.h()));
                case 2:
                    return new p(Boolean.valueOf(aVar.i()));
                case 3:
                    return new p(aVar.h());
                case 4:
                    aVar.j();
                    return com.google.gson.m.f4033a;
                case 5:
                    com.google.gson.i iVar = new com.google.gson.i();
                    aVar.a();
                    while (aVar.e()) {
                        iVar.a(read(aVar));
                    }
                    aVar.b();
                    return iVar;
                case 6:
                    com.google.gson.n nVar = new com.google.gson.n();
                    aVar.c();
                    while (aVar.e()) {
                        nVar.a(aVar.g(), read(aVar));
                    }
                    aVar.d();
                    return nVar;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, com.google.gson.l lVar) throws IOException {
            if (lVar == null || lVar.k()) {
                cVar.f();
                return;
            }
            if (lVar.j()) {
                p pVarN = lVar.n();
                if (pVarN.p()) {
                    cVar.a(pVarN.b());
                    return;
                } else if (pVarN.a()) {
                    cVar.a(pVarN.g());
                    return;
                } else {
                    cVar.b(pVarN.c());
                    return;
                }
            }
            if (lVar.h()) {
                cVar.b();
                Iterator<com.google.gson.l> it = lVar.m().iterator();
                while (it.hasNext()) {
                    write(cVar, it.next());
                }
                cVar.c();
                return;
            }
            if (lVar.i()) {
                cVar.d();
                for (Map.Entry<String, com.google.gson.l> entry : lVar.l().a()) {
                    cVar.a(entry.getKey());
                    write(cVar, entry.getValue());
                }
                cVar.e();
                return;
            }
            throw new IllegalArgumentException("Couldn't write " + lVar.getClass());
        }
    };
    public static final u Y = b(com.google.gson.l.class, X);
    public static final u Z = new u() { // from class: com.google.gson.b.a.n.24
        @Override // com.google.gson.u
        public <T> t<T> a(com.google.gson.f fVar, com.google.gson.c.a<T> aVar) {
            Class<? super T> clsA = aVar.a();
            if (!Enum.class.isAssignableFrom(clsA) || clsA == Enum.class) {
                return null;
            }
            if (!clsA.isEnum()) {
                clsA = clsA.getSuperclass();
            }
            return new a(clsA);
        }
    };

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.b.a.n$30, reason: invalid class name */
    static /* synthetic */ class AnonymousClass30 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3959a = new int[com.google.gson.stream.b.values().length];

        static {
            try {
                f3959a[com.google.gson.stream.b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3959a[com.google.gson.stream.b.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3959a[com.google.gson.stream.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3959a[com.google.gson.stream.b.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3959a[com.google.gson.stream.b.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3959a[com.google.gson.stream.b.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3959a[com.google.gson.stream.b.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3959a[com.google.gson.stream.b.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3959a[com.google.gson.stream.b.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3959a[com.google.gson.stream.b.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    private static final class a<T extends Enum<T>> extends t<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Map<String, T> f3960a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        private final Map<T, String> f3961b = new HashMap();

        public a(Class<T> cls) {
            try {
                for (T t : cls.getEnumConstants()) {
                    String strName = t.name();
                    com.google.gson.a.c cVar = (com.google.gson.a.c) cls.getField(strName).getAnnotation(com.google.gson.a.c.class);
                    if (cVar != null) {
                        strName = cVar.a();
                        for (String str : cVar.b()) {
                            this.f3960a.put(str, t);
                        }
                    }
                    this.f3960a.put(strName, t);
                    this.f3961b.put(t, strName);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public T read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.f() == com.google.gson.stream.b.NULL) {
                aVar.j();
                return null;
            }
            return this.f3960a.get(aVar.h());
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, T t) throws IOException {
            cVar.b(t == null ? null : this.f3961b.get(t));
        }
    }

    public static <TT> u a(final com.google.gson.c.a<TT> aVar, final t<TT> tVar) {
        return new u() { // from class: com.google.gson.b.a.n.25
            @Override // com.google.gson.u
            public <T> t<T> a(com.google.gson.f fVar, com.google.gson.c.a<T> aVar2) {
                if (aVar2.equals(aVar)) {
                    return tVar;
                }
                return null;
            }
        };
    }

    public static <TT> u a(final Class<TT> cls, final t<TT> tVar) {
        return new u() { // from class: com.google.gson.b.a.n.26
            @Override // com.google.gson.u
            public <T> t<T> a(com.google.gson.f fVar, com.google.gson.c.a<T> aVar) {
                if (aVar.a() == cls) {
                    return tVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + tVar + "]";
            }
        };
    }

    public static <TT> u a(final Class<TT> cls, final Class<TT> cls2, final t<? super TT> tVar) {
        return new u() { // from class: com.google.gson.b.a.n.27
            @Override // com.google.gson.u
            public <T> t<T> a(com.google.gson.f fVar, com.google.gson.c.a<T> aVar) {
                Class<? super T> clsA = aVar.a();
                if (clsA == cls || clsA == cls2) {
                    return tVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + tVar + "]";
            }
        };
    }

    public static <TT> u b(final Class<TT> cls, final Class<? extends TT> cls2, final t<? super TT> tVar) {
        return new u() { // from class: com.google.gson.b.a.n.28
            @Override // com.google.gson.u
            public <T> t<T> a(com.google.gson.f fVar, com.google.gson.c.a<T> aVar) {
                Class<? super T> clsA = aVar.a();
                if (clsA == cls || clsA == cls2) {
                    return tVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + tVar + "]";
            }
        };
    }

    public static <T1> u b(final Class<T1> cls, final t<T1> tVar) {
        return new u() { // from class: com.google.gson.b.a.n.29
            @Override // com.google.gson.u
            public <T2> t<T2> a(com.google.gson.f fVar, com.google.gson.c.a<T2> aVar) {
                final Class<? super T2> clsA = aVar.a();
                if (cls.isAssignableFrom(clsA)) {
                    return (t<T2>) new t<T1>() { // from class: com.google.gson.b.a.n.29.1
                        @Override // com.google.gson.t
                        public void write(com.google.gson.stream.c cVar, T1 t1) {
                            tVar.write(cVar, t1);
                        }

                        @Override // com.google.gson.t
                        public T1 read(com.google.gson.stream.a aVar2) {
                            T1 t1 = (T1) tVar.read(aVar2);
                            if (t1 == null || clsA.isInstance(t1)) {
                                return t1;
                            }
                            throw new JsonSyntaxException("Expected a " + clsA.getName() + " but was " + t1.getClass().getName());
                        }
                    };
                }
                return null;
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + tVar + "]";
            }
        };
    }
}
