package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.ab;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: SupportMenuInflater.java */
/* loaded from: classes.dex */
public class g extends MenuInflater {

    /* renamed from: a, reason: collision with root package name */
    static final Class<?>[] f197a = {Context.class};

    /* renamed from: b, reason: collision with root package name */
    static final Class<?>[] f198b = f197a;
    final Object[] c;
    final Object[] d;
    Context e;
    private Object f;

    public g(Context context) {
        super(context);
        this.e = context;
        this.c = new Object[]{context};
        this.d = this.c;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) throws Throwable {
        XmlResourceParser layout;
        if (!(menu instanceof androidx.core.b.a.a)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                layout = this.e.getResources().getLayout(i);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        } catch (XmlPullParserException e2) {
            e = e2;
        }
        try {
            a(layout, Xml.asAttributeSet(layout), menu);
            if (layout != null) {
                layout.close();
            }
        } catch (IOException e3) {
            e = e3;
            throw new InflateException("Error inflating menu XML", e);
        } catch (XmlPullParserException e4) {
            e = e4;
            throw new InflateException("Error inflating menu XML", e);
        } catch (Throwable th2) {
            th = th2;
            xmlResourceParser = layout;
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    private void a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        int next = eventType;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            switch (next) {
                case 1:
                    throw new RuntimeException("Unexpected end of document");
                case 2:
                    if (!z2) {
                        String name2 = xmlPullParser.getName();
                        if (name2.equals("group")) {
                            bVar.a(attributeSet);
                            break;
                        } else if (name2.equals("item")) {
                            bVar.b(attributeSet);
                            break;
                        } else if (!name2.equals("menu")) {
                            str = name2;
                            z2 = true;
                            break;
                        } else {
                            a(xmlPullParser, attributeSet, bVar.c());
                            break;
                        }
                    } else {
                        break;
                    }
                case 3:
                    String name3 = xmlPullParser.getName();
                    if (!z2 || !name3.equals(str)) {
                        if (name3.equals("group")) {
                            bVar.a();
                            break;
                        } else if (name3.equals("item")) {
                            if (!bVar.d()) {
                                if (bVar.f201a != null && bVar.f201a.c()) {
                                    bVar.c();
                                    break;
                                } else {
                                    bVar.b();
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else if (!name3.equals("menu")) {
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    } else {
                        str = null;
                        z2 = false;
                        break;
                    }
                    break;
            }
            next = xmlPullParser.next();
        }
    }

    Object a() {
        if (this.f == null) {
            this.f = a(this.e);
        }
        return this.f;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* compiled from: SupportMenuInflater.java */
    private static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        private static final Class<?>[] f199a = {MenuItem.class};

        /* renamed from: b, reason: collision with root package name */
        private Object f200b;
        private Method c;

        public a(Object obj, String str) {
            this.f200b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.c = cls.getMethod(str, f199a);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                if (this.c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.c.invoke(this.f200b, menuItem)).booleanValue();
                }
                this.c.invoke(this.f200b, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* compiled from: SupportMenuInflater.java */
    private class b {
        private String A;
        private String B;
        private CharSequence C;
        private CharSequence D;
        private ColorStateList E = null;
        private PorterDuff.Mode F = null;

        /* renamed from: a, reason: collision with root package name */
        androidx.core.g.b f201a;
        private Menu c;
        private int d;
        private int e;
        private int f;
        private int g;
        private boolean h;
        private boolean i;
        private boolean j;
        private int k;
        private int l;
        private CharSequence m;
        private CharSequence n;
        private int o;
        private char p;
        private int q;
        private char r;
        private int s;
        private int t;
        private boolean u;
        private boolean v;
        private boolean w;
        private int x;
        private int y;
        private String z;

        public b(Menu menu) {
            this.c = menu;
            a();
        }

        public void a() {
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = true;
            this.i = true;
        }

        public void a(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = g.this.e.obtainStyledAttributes(attributeSet, a.j.MenuGroup);
            this.d = typedArrayObtainStyledAttributes.getResourceId(a.j.MenuGroup_android_id, 0);
            this.e = typedArrayObtainStyledAttributes.getInt(a.j.MenuGroup_android_menuCategory, 0);
            this.f = typedArrayObtainStyledAttributes.getInt(a.j.MenuGroup_android_orderInCategory, 0);
            this.g = typedArrayObtainStyledAttributes.getInt(a.j.MenuGroup_android_checkableBehavior, 0);
            this.h = typedArrayObtainStyledAttributes.getBoolean(a.j.MenuGroup_android_visible, true);
            this.i = typedArrayObtainStyledAttributes.getBoolean(a.j.MenuGroup_android_enabled, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void b(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = g.this.e.obtainStyledAttributes(attributeSet, a.j.MenuItem);
            this.k = typedArrayObtainStyledAttributes.getResourceId(a.j.MenuItem_android_id, 0);
            this.l = (typedArrayObtainStyledAttributes.getInt(a.j.MenuItem_android_menuCategory, this.e) & (-65536)) | (typedArrayObtainStyledAttributes.getInt(a.j.MenuItem_android_orderInCategory, this.f) & 65535);
            this.m = typedArrayObtainStyledAttributes.getText(a.j.MenuItem_android_title);
            this.n = typedArrayObtainStyledAttributes.getText(a.j.MenuItem_android_titleCondensed);
            this.o = typedArrayObtainStyledAttributes.getResourceId(a.j.MenuItem_android_icon, 0);
            this.p = a(typedArrayObtainStyledAttributes.getString(a.j.MenuItem_android_alphabeticShortcut));
            this.q = typedArrayObtainStyledAttributes.getInt(a.j.MenuItem_alphabeticModifiers, 4096);
            this.r = a(typedArrayObtainStyledAttributes.getString(a.j.MenuItem_android_numericShortcut));
            this.s = typedArrayObtainStyledAttributes.getInt(a.j.MenuItem_numericModifiers, 4096);
            if (typedArrayObtainStyledAttributes.hasValue(a.j.MenuItem_android_checkable)) {
                this.t = typedArrayObtainStyledAttributes.getBoolean(a.j.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.t = this.g;
            }
            this.u = typedArrayObtainStyledAttributes.getBoolean(a.j.MenuItem_android_checked, false);
            this.v = typedArrayObtainStyledAttributes.getBoolean(a.j.MenuItem_android_visible, this.h);
            this.w = typedArrayObtainStyledAttributes.getBoolean(a.j.MenuItem_android_enabled, this.i);
            this.x = typedArrayObtainStyledAttributes.getInt(a.j.MenuItem_showAsAction, -1);
            this.B = typedArrayObtainStyledAttributes.getString(a.j.MenuItem_android_onClick);
            this.y = typedArrayObtainStyledAttributes.getResourceId(a.j.MenuItem_actionLayout, 0);
            this.z = typedArrayObtainStyledAttributes.getString(a.j.MenuItem_actionViewClass);
            this.A = typedArrayObtainStyledAttributes.getString(a.j.MenuItem_actionProviderClass);
            boolean z = this.A != null;
            if (z && this.y == 0 && this.z == null) {
                this.f201a = (androidx.core.g.b) a(this.A, g.f198b, g.this.d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f201a = null;
            }
            this.C = typedArrayObtainStyledAttributes.getText(a.j.MenuItem_contentDescription);
            this.D = typedArrayObtainStyledAttributes.getText(a.j.MenuItem_tooltipText);
            if (typedArrayObtainStyledAttributes.hasValue(a.j.MenuItem_iconTintMode)) {
                this.F = ab.a(typedArrayObtainStyledAttributes.getInt(a.j.MenuItem_iconTintMode, -1), this.F);
            } else {
                this.F = null;
            }
            if (typedArrayObtainStyledAttributes.hasValue(a.j.MenuItem_iconTint)) {
                this.E = typedArrayObtainStyledAttributes.getColorStateList(a.j.MenuItem_iconTint);
            } else {
                this.E = null;
            }
            typedArrayObtainStyledAttributes.recycle();
            this.j = false;
        }

        private char a(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private void a(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            boolean z = false;
            menuItem.setChecked(this.u).setVisible(this.v).setEnabled(this.w).setCheckable(this.t >= 1).setTitleCondensed(this.n).setIcon(this.o);
            if (this.x >= 0) {
                menuItem.setShowAsAction(this.x);
            }
            if (this.B != null) {
                if (g.this.e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.this.a(), this.B));
            }
            boolean z2 = menuItem instanceof j;
            if (z2) {
            }
            if (this.t >= 2) {
                if (z2) {
                    ((j) menuItem).a(true);
                } else if (menuItem instanceof k) {
                    ((k) menuItem).a(true);
                }
            }
            if (this.z != null) {
                menuItem.setActionView((View) a(this.z, g.f197a, g.this.c));
                z = true;
            }
            if (this.y > 0) {
                if (!z) {
                    menuItem.setActionView(this.y);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            if (this.f201a != null) {
                androidx.core.g.g.a(menuItem, this.f201a);
            }
            androidx.core.g.g.a(menuItem, this.C);
            androidx.core.g.g.b(menuItem, this.D);
            androidx.core.g.g.b(menuItem, this.p, this.q);
            androidx.core.g.g.a(menuItem, this.r, this.s);
            if (this.F != null) {
                androidx.core.g.g.a(menuItem, this.F);
            }
            if (this.E != null) {
                androidx.core.g.g.a(menuItem, this.E);
            }
        }

        public void b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.j = true;
            a(this.c.add(this.d, this.k, this.l, this.m));
        }

        public SubMenu c() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.j = true;
            SubMenu subMenuAddSubMenu = this.c.addSubMenu(this.d, this.k, this.l, this.m);
            a(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public boolean d() {
            return this.j;
        }

        private <T> T a(String str, Class<?>[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
            try {
                Constructor<?> constructor = g.this.e.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }
    }
}
