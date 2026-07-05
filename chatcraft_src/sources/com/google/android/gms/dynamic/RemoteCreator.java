package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.i;

/* loaded from: classes.dex */
public abstract class RemoteCreator<T> {

    /* renamed from: a, reason: collision with root package name */
    private final String f1758a;

    /* renamed from: b, reason: collision with root package name */
    private T f1759b;

    protected RemoteCreator(String str) {
        this.f1758a = str;
    }

    protected abstract T a(IBinder iBinder);

    public static class RemoteCreatorException extends Exception {
        public RemoteCreatorException(String str) {
            super(str);
        }

        public RemoteCreatorException(String str, Throwable th) {
            super(str, th);
        }
    }

    protected final T a(Context context) throws RemoteCreatorException {
        if (this.f1759b == null) {
            i.a(context);
            Context contextA = e.a(context);
            if (contextA == null) {
                throw new RemoteCreatorException("Could not get remote context.");
            }
            try {
                this.f1759b = a((IBinder) contextA.getClassLoader().loadClass(this.f1758a).newInstance());
            } catch (ClassNotFoundException e) {
                throw new RemoteCreatorException("Could not load creator class.", e);
            } catch (IllegalAccessException e2) {
                throw new RemoteCreatorException("Could not access creator.", e2);
            } catch (InstantiationException e3) {
                throw new RemoteCreatorException("Could not instantiate creator.", e3);
            }
        }
        return this.f1759b;
    }
}
