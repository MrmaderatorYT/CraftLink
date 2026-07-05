package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public abstract class VersionedParcel {

    public static class ParcelException extends RuntimeException {
    }

    protected abstract void a(int i);

    protected abstract void a(Parcelable parcelable);

    protected abstract void a(String str);

    public void a(boolean z, boolean z2) {
    }

    protected abstract void a(byte[] bArr);

    public boolean a() {
        return false;
    }

    protected abstract void b();

    protected abstract boolean b(int i);

    protected abstract VersionedParcel c();

    protected abstract void c(int i);

    protected abstract int d();

    protected abstract String e();

    protected abstract byte[] f();

    protected abstract <T extends Parcelable> T g();

    public void a(byte[] bArr, int i) {
        c(i);
        a(bArr);
    }

    public void a(int i, int i2) {
        c(i2);
        a(i);
    }

    public void a(String str, int i) {
        c(i);
        a(str);
    }

    public void a(Parcelable parcelable, int i) {
        c(i);
        a(parcelable);
    }

    public int b(int i, int i2) {
        return !b(i2) ? i : d();
    }

    public String b(String str, int i) {
        return !b(i) ? str : e();
    }

    public byte[] b(byte[] bArr, int i) {
        return !b(i) ? bArr : f();
    }

    public <T extends Parcelable> T b(T t, int i) {
        return !b(i) ? t : (T) g();
    }

    public void a(b bVar, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        c(i);
        a(bVar);
    }

    protected void a(b bVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (bVar == null) {
            a((String) null);
            return;
        }
        b(bVar);
        VersionedParcel versionedParcelC = c();
        a(bVar, versionedParcelC);
        versionedParcelC.b();
    }

    private void b(b bVar) {
        try {
            a(a((Class<? extends b>) bVar.getClass()).getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(bVar.getClass().getSimpleName() + " does not have a Parcelizer", e);
        }
    }

    public <T extends b> T b(T t, int i) {
        return !b(i) ? t : (T) h();
    }

    protected <T extends b> T h() {
        String strE = e();
        if (strE == null) {
            return null;
        }
        return (T) a(strE, c());
    }

    protected static <T extends b> T a(String str, VersionedParcel versionedParcel) {
        try {
            return (T) Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class).invoke(null, versionedParcel);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    protected static <T extends b> void a(T t, VersionedParcel versionedParcel) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            c(t).getDeclaredMethod("write", t.getClass(), VersionedParcel.class).invoke(null, t, versionedParcel);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    private static <T extends b> Class c(T t) {
        return a((Class<? extends b>) t.getClass());
    }

    private static Class a(Class<? extends b> cls) {
        return Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
    }
}
