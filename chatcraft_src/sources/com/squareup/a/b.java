package com.squareup.a;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: Bus.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentMap<Class<?>, Set<d>> f4083a;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentMap<Class<?>, e> f4084b;
    private final String c;
    private final i d;
    private final f e;
    private final ThreadLocal<ConcurrentLinkedQueue<a>> f;
    private final ThreadLocal<Boolean> g;
    private final ConcurrentMap<Class<?>, Set<Class<?>>> h;

    public b() {
        this("default");
    }

    public b(String str) {
        this(i.f4097b, str);
    }

    public b(i iVar) {
        this(iVar, "default");
    }

    public b(i iVar, String str) {
        this(iVar, str, f.f4095a);
    }

    b(i iVar, String str, f fVar) {
        this.f4083a = new ConcurrentHashMap();
        this.f4084b = new ConcurrentHashMap();
        this.f = new ThreadLocal<ConcurrentLinkedQueue<a>>() { // from class: com.squareup.a.b.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ConcurrentLinkedQueue<a> initialValue() {
                return new ConcurrentLinkedQueue<>();
            }
        };
        this.g = new ThreadLocal<Boolean>() { // from class: com.squareup.a.b.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean initialValue() {
                return false;
            }
        };
        this.h = new ConcurrentHashMap();
        this.d = iVar;
        this.c = str;
        this.e = fVar;
    }

    public String toString() {
        return "[Bus \"" + this.c + "\"]";
    }

    public void a(Object obj) throws IllegalAccessException, IllegalArgumentException {
        Set<d> setPutIfAbsent;
        if (obj == null) {
            throw new NullPointerException("Object to register must not be null.");
        }
        this.d.a(this);
        Map<Class<?>, e> mapA = this.e.a(obj);
        for (Class<?> cls : mapA.keySet()) {
            e eVar = mapA.get(cls);
            e eVarPutIfAbsent = this.f4084b.putIfAbsent(cls, eVar);
            if (eVarPutIfAbsent != null) {
                throw new IllegalArgumentException("Producer method for type " + cls + " found on type " + eVar.f4093a.getClass() + ", but already registered by type " + eVarPutIfAbsent.f4093a.getClass() + ".");
            }
            Set<d> set = this.f4083a.get(cls);
            if (set != null && !set.isEmpty()) {
                Iterator<d> it = set.iterator();
                while (it.hasNext()) {
                    a(it.next(), eVar);
                }
            }
        }
        Map<Class<?>, Set<d>> mapB = this.e.b(obj);
        for (Class<?> cls2 : mapB.keySet()) {
            Set<d> copyOnWriteArraySet = this.f4083a.get(cls2);
            if (copyOnWriteArraySet == null && (setPutIfAbsent = this.f4083a.putIfAbsent(cls2, (copyOnWriteArraySet = new CopyOnWriteArraySet<>()))) != null) {
                copyOnWriteArraySet = setPutIfAbsent;
            }
            if (!copyOnWriteArraySet.addAll(mapB.get(cls2))) {
                throw new IllegalArgumentException("Object already registered.");
            }
        }
        for (Map.Entry<Class<?>, Set<d>> entry : mapB.entrySet()) {
            e eVar2 = this.f4084b.get(entry.getKey());
            if (eVar2 != null && eVar2.a()) {
                for (d dVar : entry.getValue()) {
                    if (!eVar2.a()) {
                        break;
                    } else if (dVar.a()) {
                        a(dVar, eVar2);
                    }
                }
            }
        }
    }

    private void a(d dVar, e eVar) throws IllegalAccessException, IllegalArgumentException {
        Object objC;
        try {
            objC = eVar.c();
        } catch (InvocationTargetException e) {
            a("Producer " + eVar + " threw an exception.", e);
            objC = null;
        }
        if (objC == null) {
            return;
        }
        b(objC, dVar);
    }

    public void b(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Object to unregister must not be null.");
        }
        this.d.a(this);
        for (Map.Entry<Class<?>, e> entry : this.e.a(obj).entrySet()) {
            Class<?> key = entry.getKey();
            e eVarA = a(key);
            e value = entry.getValue();
            if (value == null || !value.equals(eVarA)) {
                throw new IllegalArgumentException("Missing event producer for an annotated method. Is " + obj.getClass() + " registered?");
            }
            this.f4084b.remove(key).b();
        }
        for (Map.Entry<Class<?>, Set<d>> entry2 : this.e.b(obj).entrySet()) {
            Set<d> setB = b(entry2.getKey());
            Set<d> value2 = entry2.getValue();
            if (setB == null || !setB.containsAll(value2)) {
                throw new IllegalArgumentException("Missing event handler for an annotated method. Is " + obj.getClass() + " registered?");
            }
            for (d dVar : setB) {
                if (value2.contains(dVar)) {
                    dVar.b();
                }
            }
            setB.removeAll(value2);
        }
    }

    public void c(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Event to post must not be null.");
        }
        this.d.a(this);
        boolean z = false;
        Iterator<Class<?>> it = c(obj.getClass()).iterator();
        while (it.hasNext()) {
            Set<d> setB = b(it.next());
            if (setB != null && !setB.isEmpty()) {
                z = true;
                Iterator<d> it2 = setB.iterator();
                while (it2.hasNext()) {
                    a(obj, it2.next());
                }
            }
        }
        if (!z && !(obj instanceof c)) {
            c(new c(this, obj));
        }
        a();
    }

    protected void a(Object obj, d dVar) {
        this.f.get().offer(new a(obj, dVar));
    }

    protected void a() {
        if (this.g.get().booleanValue()) {
            return;
        }
        this.g.set(true);
        while (true) {
            try {
                a aVarPoll = this.f.get().poll();
                if (aVarPoll == null) {
                    return;
                }
                if (aVarPoll.f4088b.a()) {
                    b(aVarPoll.f4087a, aVarPoll.f4088b);
                }
            } finally {
                this.g.set(false);
            }
        }
    }

    protected void b(Object obj, d dVar) throws IllegalAccessException, IllegalArgumentException {
        try {
            dVar.a(obj);
        } catch (InvocationTargetException e) {
            a("Could not dispatch event: " + obj.getClass() + " to handler " + dVar, e);
        }
    }

    e a(Class<?> cls) {
        return this.f4084b.get(cls);
    }

    Set<d> b(Class<?> cls) {
        return this.f4083a.get(cls);
    }

    Set<Class<?>> c(Class<?> cls) {
        Set<Class<?>> set = this.h.get(cls);
        if (set != null) {
            return set;
        }
        Set<Class<?>> setD = d(cls);
        Set<Class<?>> setPutIfAbsent = this.h.putIfAbsent(cls, setD);
        return setPutIfAbsent == null ? setD : setPutIfAbsent;
    }

    private Set<Class<?>> d(Class<?> cls) {
        LinkedList linkedList = new LinkedList();
        HashSet hashSet = new HashSet();
        linkedList.add(cls);
        while (!linkedList.isEmpty()) {
            Class cls2 = (Class) linkedList.remove(0);
            hashSet.add(cls2);
            Class superclass = cls2.getSuperclass();
            if (superclass != null) {
                linkedList.add(superclass);
            }
        }
        return hashSet;
    }

    private static void a(String str, InvocationTargetException invocationTargetException) {
        Throwable cause = invocationTargetException.getCause();
        if (cause != null) {
            throw new RuntimeException(str + ": " + cause.getMessage(), cause);
        }
        throw new RuntimeException(str + ": " + invocationTargetException.getMessage(), invocationTargetException);
    }

    /* compiled from: Bus.java */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        final Object f4087a;

        /* renamed from: b, reason: collision with root package name */
        final d f4088b;

        public a(Object obj, d dVar) {
            this.f4087a = obj;
            this.f4088b = dVar;
        }
    }
}
