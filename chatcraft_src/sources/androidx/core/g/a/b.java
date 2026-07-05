package androidx.core.g.a;

import android.os.Build;
import android.view.accessibility.AccessibilityManager;

/* compiled from: AccessibilityManagerCompat.java */
/* loaded from: classes.dex */
public final class b {

    /* compiled from: AccessibilityManagerCompat.java */
    public interface a {
        void a(boolean z);
    }

    public static boolean a(AccessibilityManager accessibilityManager, a aVar) {
        if (Build.VERSION.SDK_INT < 19 || aVar == null) {
            return false;
        }
        return accessibilityManager.addTouchExplorationStateChangeListener(new AccessibilityManagerTouchExplorationStateChangeListenerC0040b(aVar));
    }

    public static boolean b(AccessibilityManager accessibilityManager, a aVar) {
        if (Build.VERSION.SDK_INT < 19 || aVar == null) {
            return false;
        }
        return accessibilityManager.removeTouchExplorationStateChangeListener(new AccessibilityManagerTouchExplorationStateChangeListenerC0040b(aVar));
    }

    /* compiled from: AccessibilityManagerCompat.java */
    /* renamed from: androidx.core.g.a.b$b, reason: collision with other inner class name */
    private static class AccessibilityManagerTouchExplorationStateChangeListenerC0040b implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final a f618a;

        AccessibilityManagerTouchExplorationStateChangeListenerC0040b(a aVar) {
            this.f618a = aVar;
        }

        public int hashCode() {
            return this.f618a.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.f618a.equals(((AccessibilityManagerTouchExplorationStateChangeListenerC0040b) obj).f618a);
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z) {
            this.f618a.a(z);
        }
    }
}
