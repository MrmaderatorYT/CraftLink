package androidx.core.g.a;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: AccessibilityNodeInfoCompat.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public int f619a = -1;

    /* renamed from: b, reason: collision with root package name */
    private final AccessibilityNodeInfo f620b;

    private static String b(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final Object f621a;

        public static a a(int i, int i2, boolean z, int i3) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new a(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new a(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z));
            }
            return new a(null);
        }

        a(Object obj) {
            this.f621a = obj;
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        final Object f622a;

        public static b a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new b(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new b(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z));
            }
            return new b(null);
        }

        b(Object obj) {
            this.f622a = obj;
        }

        public int a() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f622a).getColumnIndex();
            }
            return 0;
        }

        public int b() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f622a).getColumnSpan();
            }
            return 0;
        }

        public int c() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f622a).getRowIndex();
            }
            return 0;
        }

        public int d() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f622a).getRowSpan();
            }
            return 0;
        }

        public boolean e() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f622a).isSelected();
            }
            return false;
        }
    }

    private c(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f620b = accessibilityNodeInfo;
    }

    public static c a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new c(accessibilityNodeInfo);
    }

    public AccessibilityNodeInfo a() {
        return this.f620b;
    }

    public int b() {
        return this.f620b.getActions();
    }

    public void a(int i) {
        this.f620b.addAction(i);
    }

    public void a(Rect rect) {
        this.f620b.getBoundsInParent(rect);
    }

    public void b(Rect rect) {
        this.f620b.getBoundsInScreen(rect);
    }

    public boolean c() {
        return this.f620b.isCheckable();
    }

    public void a(boolean z) {
        this.f620b.setCheckable(z);
    }

    public boolean d() {
        return this.f620b.isChecked();
    }

    public void b(boolean z) {
        this.f620b.setChecked(z);
    }

    public boolean e() {
        return this.f620b.isFocusable();
    }

    public boolean f() {
        return this.f620b.isFocused();
    }

    public boolean g() {
        return this.f620b.isSelected();
    }

    public boolean h() {
        return this.f620b.isClickable();
    }

    public boolean i() {
        return this.f620b.isLongClickable();
    }

    public boolean j() {
        return this.f620b.isEnabled();
    }

    public boolean k() {
        return this.f620b.isPassword();
    }

    public boolean l() {
        return this.f620b.isScrollable();
    }

    public void c(boolean z) {
        this.f620b.setScrollable(z);
    }

    public CharSequence m() {
        return this.f620b.getPackageName();
    }

    public CharSequence n() {
        return this.f620b.getClassName();
    }

    public void a(CharSequence charSequence) {
        this.f620b.setClassName(charSequence);
    }

    public CharSequence o() {
        return this.f620b.getText();
    }

    public void b(CharSequence charSequence) {
        this.f620b.setText(charSequence);
    }

    public CharSequence p() {
        return this.f620b.getContentDescription();
    }

    public String q() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f620b.getViewIdResourceName();
        }
        return null;
    }

    public void a(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f620b.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((a) obj).f621a);
        }
    }

    public void b(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f620b.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((b) obj).f622a);
        }
    }

    public b r() {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
        if (Build.VERSION.SDK_INT < 19 || (collectionItemInfo = this.f620b.getCollectionItemInfo()) == null) {
            return null;
        }
        return new b(collectionItemInfo);
    }

    public void d(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f620b.setContentInvalid(z);
        }
    }

    public void c(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f620b.setHintText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.f620b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public void d(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f620b.setError(charSequence);
        }
    }

    public Bundle s() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.f620b.getExtras();
        }
        return new Bundle();
    }

    public void e(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f620b.setDismissable(z);
        }
    }

    public void f(boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f620b.setShowingHintText(z);
        } else {
            a(4, z);
        }
    }

    public int hashCode() {
        if (this.f620b == null) {
            return 0;
        }
        return this.f620b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f620b == null) {
            if (cVar.f620b != null) {
                return false;
            }
        } else if (!this.f620b.equals(cVar.f620b)) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        sb.append("; boundsInParent: " + rect);
        b(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(m());
        sb.append("; className: ");
        sb.append(n());
        sb.append("; text: ");
        sb.append(o());
        sb.append("; contentDescription: ");
        sb.append(p());
        sb.append("; viewId: ");
        sb.append(q());
        sb.append("; checkable: ");
        sb.append(c());
        sb.append("; checked: ");
        sb.append(d());
        sb.append("; focusable: ");
        sb.append(e());
        sb.append("; focused: ");
        sb.append(f());
        sb.append("; selected: ");
        sb.append(g());
        sb.append("; clickable: ");
        sb.append(h());
        sb.append("; longClickable: ");
        sb.append(i());
        sb.append("; enabled: ");
        sb.append(j());
        sb.append("; password: ");
        sb.append(k());
        sb.append("; scrollable: " + l());
        sb.append("; [");
        int iB = b();
        while (iB != 0) {
            int iNumberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(iB);
            iB &= iNumberOfTrailingZeros ^ (-1);
            sb.append(b(iNumberOfTrailingZeros));
            if (iB != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void a(int i, boolean z) {
        Bundle bundleS = s();
        if (bundleS != null) {
            int i2 = bundleS.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (i ^ (-1));
            if (!z) {
                i = 0;
            }
            bundleS.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i | i2);
        }
    }
}
