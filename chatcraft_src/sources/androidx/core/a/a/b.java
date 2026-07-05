package androidx.core.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Shader;
import android.util.Log;

/* compiled from: ComplexColorCompat.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Shader f528a;

    /* renamed from: b, reason: collision with root package name */
    private final ColorStateList f529b;
    private int c;

    private b(Shader shader, ColorStateList colorStateList, int i) {
        this.f528a = shader;
        this.f529b = colorStateList;
        this.c = i;
    }

    static b a(Shader shader) {
        return new b(shader, null, 0);
    }

    static b a(ColorStateList colorStateList) {
        return new b(null, colorStateList, colorStateList.getDefaultColor());
    }

    static b a(int i) {
        return new b(null, null, i);
    }

    public Shader a() {
        return this.f528a;
    }

    public int b() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public boolean c() {
        return this.f528a != null;
    }

    public boolean d() {
        return this.f528a == null && this.f529b != null && this.f529b.isStateful();
    }

    public boolean a(int[] iArr) {
        int colorForState;
        if (!d() || (colorForState = this.f529b.getColorForState(iArr, this.f529b.getDefaultColor())) == this.c) {
            return false;
        }
        this.c = colorForState;
        return true;
    }

    public boolean e() {
        return c() || this.c != 0;
    }

    public static b a(Resources resources, int i, Resources.Theme theme) {
        try {
            return b(resources, i, theme);
        } catch (Exception e) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static androidx.core.a.a.b b(android.content.res.Resources r6, int r7, android.content.res.Resources.Theme r8) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException {
        /*
            android.content.res.XmlResourceParser r7 = r6.getXml(r7)
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r7)
        L8:
            int r1 = r7.next()
            r2 = 1
            r3 = 2
            if (r1 == r3) goto L13
            if (r1 == r2) goto L13
            goto L8
        L13:
            if (r1 != r3) goto L70
            java.lang.String r1 = r7.getName()
            r3 = -1
            int r4 = r1.hashCode()
            r5 = 89650992(0x557f730, float:1.01546526E-35)
            if (r4 == r5) goto L33
            r2 = 1191572447(0x4705f3df, float:34291.87)
            if (r4 == r2) goto L29
            goto L3c
        L29:
            java.lang.String r2 = "selector"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L3c
            r2 = 0
            goto L3d
        L33:
            java.lang.String r4 = "gradient"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L3c
            goto L3d
        L3c:
            r2 = -1
        L3d:
            switch(r2) {
                case 0: goto L67;
                case 1: goto L5e;
                default: goto L40;
            }
        L40:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r7 = r7.getPositionDescription()
            r8.append(r7)
            java.lang.String r7 = ": unsupported complex color tag "
            r8.append(r7)
            r8.append(r1)
            java.lang.String r7 = r8.toString()
            r6.<init>(r7)
            throw r6
        L5e:
            android.graphics.Shader r6 = androidx.core.a.a.d.a(r6, r7, r0, r8)
            androidx.core.a.a.b r6 = a(r6)
            return r6
        L67:
            android.content.res.ColorStateList r6 = androidx.core.a.a.a.a(r6, r7, r0, r8)
            androidx.core.a.a.b r6 = a(r6)
            return r6
        L70:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.a.a.b.b(android.content.res.Resources, int, android.content.res.Resources$Theme):androidx.core.a.a.b");
    }
}
