package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class bt extends ci implements View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, by {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f3007a = {"2011", "1009", "3010"};
    private final FrameLayout c;
    private FrameLayout d;
    private View e;
    private View g;
    private bf h;

    /* renamed from: b, reason: collision with root package name */
    private final Object f3008b = new Object();
    private Map<String, WeakReference<View>> f = Collections.synchronizedMap(new HashMap());
    private boolean i = false;
    private Point j = new Point();
    private Point k = new Point();
    private WeakReference<bmg> l = new WeakReference<>(null);

    @TargetApi(21)
    public bt(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.c = frameLayout;
        this.d = frameLayout2;
        com.google.android.gms.ads.internal.ax.D();
        acd.a((View) this.c, (ViewTreeObserver.OnGlobalLayoutListener) this);
        com.google.android.gms.ads.internal.ax.D();
        acd.a((View) this.c, (ViewTreeObserver.OnScrollChangedListener) this);
        this.c.setOnTouchListener(this);
        this.c.setOnClickListener(this);
        if (frameLayout2 != null && com.google.android.gms.common.util.j.h()) {
            frameLayout2.setElevation(Float.MAX_VALUE);
        }
        o.a(this.c.getContext());
    }

    @Override // com.google.android.gms.internal.ads.ch
    public final void a(String str, com.google.android.gms.dynamic.a aVar) {
        View view = (View) com.google.android.gms.dynamic.b.a(aVar);
        synchronized (this.f3008b) {
            if (this.f == null) {
                return;
            }
            if (view == null) {
                this.f.remove(str);
            } else {
                this.f.put(str, new WeakReference<>(view));
                if (!"1098".equals(str) && !"3011".equals(str)) {
                    view.setOnTouchListener(this);
                    view.setClickable(true);
                    view.setOnClickListener(this);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.ch
    public final com.google.android.gms.dynamic.a a(String str) {
        synchronized (this.f3008b) {
            View view = null;
            if (this.f == null) {
                return null;
            }
            WeakReference<View> weakReference = this.f.get(str);
            if (weakReference != null) {
                view = weakReference.get();
            }
            return com.google.android.gms.dynamic.b.a(view);
        }
    }

    private final void a(View view) {
        bf bfVarI;
        if (this.h != null) {
            if (this.h instanceof be) {
                bfVarI = ((be) this.h).i();
            } else {
                bfVarI = this.h;
            }
            if (bfVarI != null) {
                bfVarI.c(view);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x017f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ca A[Catch: all -> 0x021a, TryCatch #2 {, blocks: (B:5:0x0004, B:7:0x000f, B:8:0x0014, B:10:0x0016, B:12:0x001f, B:13:0x0028, B:15:0x002f, B:17:0x0035, B:19:0x003b, B:21:0x004b, B:23:0x0051, B:24:0x0054, B:27:0x0060, B:28:0x0063, B:30:0x0069, B:32:0x0073, B:36:0x0087, B:38:0x008b, B:40:0x008d, B:42:0x009d, B:44:0x00a1, B:46:0x00af, B:48:0x00bb, B:51:0x00c6, B:53:0x00ca, B:59:0x00d4, B:61:0x00df, B:63:0x00e3, B:65:0x00f3, B:66:0x00fc, B:68:0x0116, B:69:0x011b, B:71:0x012a, B:72:0x0141, B:74:0x014b, B:75:0x0152, B:84:0x016f, B:86:0x0173, B:87:0x017c, B:88:0x017e, B:106:0x01ba, B:108:0x01d4, B:110:0x01da, B:112:0x01e0, B:114:0x01f0, B:116:0x01fa, B:117:0x020e, B:118:0x0215, B:122:0x0219, B:78:0x0158, B:80:0x0161, B:81:0x0167, B:49:0x00c2, B:33:0x007b, B:35:0x0081, B:89:0x017f, B:91:0x0188, B:93:0x018d, B:95:0x0199, B:96:0x01a0, B:97:0x01a3, B:99:0x01a7, B:101:0x01a9, B:103:0x01b2, B:105:0x01b9, B:104:0x01b6), top: B:129:0x0004, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00df A[Catch: all -> 0x021a, TryCatch #2 {, blocks: (B:5:0x0004, B:7:0x000f, B:8:0x0014, B:10:0x0016, B:12:0x001f, B:13:0x0028, B:15:0x002f, B:17:0x0035, B:19:0x003b, B:21:0x004b, B:23:0x0051, B:24:0x0054, B:27:0x0060, B:28:0x0063, B:30:0x0069, B:32:0x0073, B:36:0x0087, B:38:0x008b, B:40:0x008d, B:42:0x009d, B:44:0x00a1, B:46:0x00af, B:48:0x00bb, B:51:0x00c6, B:53:0x00ca, B:59:0x00d4, B:61:0x00df, B:63:0x00e3, B:65:0x00f3, B:66:0x00fc, B:68:0x0116, B:69:0x011b, B:71:0x012a, B:72:0x0141, B:74:0x014b, B:75:0x0152, B:84:0x016f, B:86:0x0173, B:87:0x017c, B:88:0x017e, B:106:0x01ba, B:108:0x01d4, B:110:0x01da, B:112:0x01e0, B:114:0x01f0, B:116:0x01fa, B:117:0x020e, B:118:0x0215, B:122:0x0219, B:78:0x0158, B:80:0x0161, B:81:0x0167, B:49:0x00c2, B:33:0x007b, B:35:0x0081, B:89:0x017f, B:91:0x0188, B:93:0x018d, B:95:0x0199, B:96:0x01a0, B:97:0x01a3, B:99:0x01a7, B:101:0x01a9, B:103:0x01b2, B:105:0x01b9, B:104:0x01b6), top: B:129:0x0004, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x012a A[Catch: all -> 0x021a, TryCatch #2 {, blocks: (B:5:0x0004, B:7:0x000f, B:8:0x0014, B:10:0x0016, B:12:0x001f, B:13:0x0028, B:15:0x002f, B:17:0x0035, B:19:0x003b, B:21:0x004b, B:23:0x0051, B:24:0x0054, B:27:0x0060, B:28:0x0063, B:30:0x0069, B:32:0x0073, B:36:0x0087, B:38:0x008b, B:40:0x008d, B:42:0x009d, B:44:0x00a1, B:46:0x00af, B:48:0x00bb, B:51:0x00c6, B:53:0x00ca, B:59:0x00d4, B:61:0x00df, B:63:0x00e3, B:65:0x00f3, B:66:0x00fc, B:68:0x0116, B:69:0x011b, B:71:0x012a, B:72:0x0141, B:74:0x014b, B:75:0x0152, B:84:0x016f, B:86:0x0173, B:87:0x017c, B:88:0x017e, B:106:0x01ba, B:108:0x01d4, B:110:0x01da, B:112:0x01e0, B:114:0x01f0, B:116:0x01fa, B:117:0x020e, B:118:0x0215, B:122:0x0219, B:78:0x0158, B:80:0x0161, B:81:0x0167, B:49:0x00c2, B:33:0x007b, B:35:0x0081, B:89:0x017f, B:91:0x0188, B:93:0x018d, B:95:0x0199, B:96:0x01a0, B:97:0x01a3, B:99:0x01a7, B:101:0x01a9, B:103:0x01b2, B:105:0x01b9, B:104:0x01b6), top: B:129:0x0004, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x014b A[Catch: all -> 0x021a, TRY_LEAVE, TryCatch #2 {, blocks: (B:5:0x0004, B:7:0x000f, B:8:0x0014, B:10:0x0016, B:12:0x001f, B:13:0x0028, B:15:0x002f, B:17:0x0035, B:19:0x003b, B:21:0x004b, B:23:0x0051, B:24:0x0054, B:27:0x0060, B:28:0x0063, B:30:0x0069, B:32:0x0073, B:36:0x0087, B:38:0x008b, B:40:0x008d, B:42:0x009d, B:44:0x00a1, B:46:0x00af, B:48:0x00bb, B:51:0x00c6, B:53:0x00ca, B:59:0x00d4, B:61:0x00df, B:63:0x00e3, B:65:0x00f3, B:66:0x00fc, B:68:0x0116, B:69:0x011b, B:71:0x012a, B:72:0x0141, B:74:0x014b, B:75:0x0152, B:84:0x016f, B:86:0x0173, B:87:0x017c, B:88:0x017e, B:106:0x01ba, B:108:0x01d4, B:110:0x01da, B:112:0x01e0, B:114:0x01f0, B:116:0x01fa, B:117:0x020e, B:118:0x0215, B:122:0x0219, B:78:0x0158, B:80:0x0161, B:81:0x0167, B:49:0x00c2, B:33:0x007b, B:35:0x0081, B:89:0x017f, B:91:0x0188, B:93:0x018d, B:95:0x0199, B:96:0x01a0, B:97:0x01a3, B:99:0x01a7, B:101:0x01a9, B:103:0x01b2, B:105:0x01b9, B:104:0x01b6), top: B:129:0x0004, inners: #0, #1 }] */
    @Override // com.google.android.gms.internal.ads.ch
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.google.android.gms.dynamic.a r12) {
        /*
            Method dump skipped, instructions count: 541
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bt.a(com.google.android.gms.dynamic.a):void");
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        synchronized (this.f3008b) {
            if (this.h == null) {
                return;
            }
            this.h.d();
            Bundle bundle = new Bundle();
            bundle.putFloat("x", a(this.j.x));
            bundle.putFloat("y", a(this.j.y));
            bundle.putFloat("start_x", a(this.k.x));
            bundle.putFloat("start_y", a(this.k.y));
            if (this.g != null && this.g.equals(view)) {
                if (this.h instanceof be) {
                    if (((be) this.h).i() != null) {
                        ((be) this.h).i().a(view, "1007", bundle, this.f, this.c, false);
                    }
                } else {
                    this.h.a(view, "1007", bundle, this.f, this.c, false);
                }
            } else {
                this.h.a(view, this.f, bundle, this.c);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        synchronized (this.f3008b) {
            if (this.h != null) {
                this.h.c(this.c, this.f);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        synchronized (this.f3008b) {
            if (this.h != null) {
                this.h.c(this.c, this.f);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.f3008b) {
            if (this.h == null) {
                return false;
            }
            this.c.getLocationOnScreen(new int[2]);
            Point point = new Point((int) (motionEvent.getRawX() - r0[0]), (int) (motionEvent.getRawY() - r0[1]));
            this.j = point;
            if (motionEvent.getAction() == 0) {
                this.k = point;
            }
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            motionEventObtain.setLocation(point.x, point.y);
            this.h.a(motionEventObtain);
            motionEventObtain.recycle();
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.ch
    public final void a() {
        synchronized (this.f3008b) {
            if (this.d != null) {
                this.d.removeAllViews();
            }
            this.d = null;
            this.f = null;
            this.g = null;
            this.h = null;
            this.j = null;
            this.k = null;
            this.l = null;
            this.e = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.ch
    public final void a(com.google.android.gms.dynamic.a aVar, int i) {
        bmg bmgVar;
        if (!com.google.android.gms.ads.internal.ax.E().a(this.c.getContext()) || this.l == null || (bmgVar = this.l.get()) == null) {
            return;
        }
        bmgVar.a();
    }

    @Override // com.google.android.gms.internal.ads.ch
    public final void b(com.google.android.gms.dynamic.a aVar) {
        this.h.a((View) com.google.android.gms.dynamic.b.a(aVar));
    }

    @Override // com.google.android.gms.internal.ads.by
    public final synchronized Map<String, WeakReference<View>> b() {
        return this.f;
    }

    @Override // com.google.android.gms.internal.ads.by
    public final View c() {
        return this.c;
    }

    private final int a(int i) {
        bra.a();
        return aac.b(this.h.p(), i);
    }
}
