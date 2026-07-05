package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {
    static final PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;

    /* renamed from: a, reason: collision with root package name */
    public int f660a;

    /* renamed from: b, reason: collision with root package name */
    Object f661b;
    public byte[] c;
    public Parcelable d;
    public int e;
    public int f;
    public ColorStateList g = null;
    PorterDuff.Mode i = h;
    public String j;

    private static String a(int i) {
        switch (i) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public String a() {
        if (this.f660a == -1 && Build.VERSION.SDK_INT >= 23) {
            return a((Icon) this.f661b);
        }
        if (this.f660a != 2) {
            throw new IllegalStateException("called getResPackage() on " + this);
        }
        return ((String) this.f661b).split(":", -1)[0];
    }

    public int b() {
        if (this.f660a == -1 && Build.VERSION.SDK_INT >= 23) {
            return b((Icon) this.f661b);
        }
        if (this.f660a != 2) {
            throw new IllegalStateException("called getResId() on " + this);
        }
        return this.e;
    }

    public String toString() {
        if (this.f660a == -1) {
            return String.valueOf(this.f661b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(a(this.f660a));
        switch (this.f660a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f661b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f661b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(a());
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(b())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.e);
                if (this.f != 0) {
                    sb.append(" off=");
                    sb.append(this.f);
                    break;
                }
                break;
            case 4:
                sb.append(" uri=");
                sb.append(this.f661b);
                break;
        }
        if (this.g != null) {
            sb.append(" tint=");
            sb.append(this.g);
        }
        if (this.i != h) {
            sb.append(" mode=");
            sb.append(this.i);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void a(boolean z) {
        this.j = this.i.name();
        int i = this.f660a;
        if (i == -1) {
            if (z) {
                throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
            }
            this.d = (Parcelable) this.f661b;
            return;
        }
        switch (i) {
            case 1:
            case 5:
                if (z) {
                    Bitmap bitmap = (Bitmap) this.f661b;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.c = byteArrayOutputStream.toByteArray();
                    return;
                }
                this.d = (Parcelable) this.f661b;
                return;
            case 2:
                this.c = ((String) this.f661b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.c = (byte[]) this.f661b;
                return;
            case 4:
                this.c = this.f661b.toString().getBytes(Charset.forName("UTF-16"));
                return;
            default:
                return;
        }
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void c() {
        this.i = PorterDuff.Mode.valueOf(this.j);
        int i = this.f660a;
        if (i == -1) {
            if (this.d != null) {
                this.f661b = this.d;
                return;
            }
            throw new IllegalArgumentException("Invalid icon");
        }
        switch (i) {
            case 1:
            case 5:
                if (this.d != null) {
                    this.f661b = this.d;
                    return;
                }
                this.f661b = this.c;
                this.f660a = 3;
                this.e = 0;
                this.f = this.c.length;
                return;
            case 2:
            case 4:
                this.f661b = new String(this.c, Charset.forName("UTF-16"));
                return;
            case 3:
                this.f661b = this.c;
                return;
            default:
                return;
        }
    }

    private static String a(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon package", e);
            return null;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon package", e2);
            return null;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon package", e3);
            return null;
        }
    }

    private static int b(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon resource", e);
            return 0;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        }
    }
}
