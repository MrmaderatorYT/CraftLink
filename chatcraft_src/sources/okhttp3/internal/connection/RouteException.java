package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class RouteException extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    private static final Method f5132a;

    /* renamed from: b, reason: collision with root package name */
    private IOException f5133b;

    static {
        Method declaredMethod;
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
            declaredMethod = null;
        }
        f5132a = declaredMethod;
    }

    public RouteException(IOException iOException) {
        super(iOException);
        this.f5133b = iOException;
    }

    public IOException a() {
        return this.f5133b;
    }

    public void a(IOException iOException) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        a(iOException, this.f5133b);
        this.f5133b = iOException;
    }

    private void a(IOException iOException, IOException iOException2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (f5132a != null) {
            try {
                f5132a.invoke(iOException, iOException2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }
}
