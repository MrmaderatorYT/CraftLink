package com.google.android.gms.internal.ads;

import android.graphics.Point;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class bv extends cn implements View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, by {

    /* renamed from: a, reason: collision with root package name */
    static final String[] f3037a = {"2011", "1009", "3010"};
    private final WeakReference<View> c;

    @GuardedBy("mLock")
    private bf g;
    private View h;

    /* renamed from: b, reason: collision with root package name */
    private final Object f3038b = new Object();
    private final Map<String, WeakReference<View>> d = new HashMap();
    private final Map<String, WeakReference<View>> e = new HashMap();
    private final Map<String, WeakReference<View>> f = new HashMap();
    private Point i = new Point();
    private Point j = new Point();
    private WeakReference<bmg> k = new WeakReference<>(null);

    public bv(View view, HashMap<String, View> map, HashMap<String, View> map2) {
        com.google.android.gms.ads.internal.ax.D();
        acd.a(view, (ViewTreeObserver.OnGlobalLayoutListener) this);
        com.google.android.gms.ads.internal.ax.D();
        acd.a(view, (ViewTreeObserver.OnScrollChangedListener) this);
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        this.c = new WeakReference<>(view);
        for (Map.Entry<String, View> entry : map.entrySet()) {
            String key = entry.getKey();
            View value = entry.getValue();
            if (value != null) {
                this.d.put(key, new WeakReference<>(value));
                if (!"1098".equals(key) && !"3011".equals(key)) {
                    value.setOnTouchListener(this);
                    value.setClickable(true);
                    value.setOnClickListener(this);
                }
            }
        }
        this.f.putAll(this.d);
        for (Map.Entry<String, View> entry2 : map2.entrySet()) {
            View value2 = entry2.getValue();
            if (value2 != null) {
                this.e.put(entry2.getKey(), new WeakReference<>(value2));
                value2.setOnTouchListener(this);
            }
        }
        this.f.putAll(this.e);
        o.a(view.getContext());
    }

    @Override // com.google.android.gms.internal.ads.cm
    public final void a() {
        synchronized (this.f3038b) {
            this.h = null;
            this.g = null;
            this.i = null;
            this.j = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.cm
    public final void a(com.google.android.gms.dynamic.a aVar) {
        int i;
        KeyEvent.Callback callback;
        synchronized (this.f3038b) {
            a((View) null);
            Object objA = com.google.android.gms.dynamic.b.a(aVar);
            if (!(objA instanceof bj)) {
                xe.e("Not an instance of native engine. This is most likely a transient error");
                return;
            }
            bj bjVar = (bj) objA;
            if (!bjVar.c()) {
                xe.c("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
                return;
            }
            View view = this.c.get();
            if (this.g != null && view != null) {
                this.g.b(view, this.f);
            }
            synchronized (this.f3038b) {
                i = 0;
                if (this.g instanceof bj) {
                    bj bjVar2 = (bj) this.g;
                    View view2 = this.c.get();
                    if (bjVar2 != null && bjVar2.p() != null && view2 != null && com.google.android.gms.ads.internal.ax.E().a(view2.getContext())) {
                        vz vzVarR = bjVar2.r();
                        if (vzVarR != null) {
                            vzVarR.a(false);
                        }
                        bmg bmgVar = this.k.get();
                        if (bmgVar != null && vzVarR != null) {
                            bmgVar.b(vzVarR);
                        }
                    }
                }
            }
            if ((this.g instanceof be) && ((be) this.g).h()) {
                ((be) this.g).a(bjVar);
            } else {
                this.g = bjVar;
                if (bjVar instanceof be) {
                    ((be) bjVar).a((bf) null);
                }
            }
            String[] strArr = {"1098", "3011"};
            while (true) {
                if (i >= 2) {
                    callback = null;
                    break;
                }
                WeakReference<View> weakReference = this.f.get(strArr[i]);
                if (weakReference != null) {
                    callback = (View) weakReference.get();
                    break;
                }
                i++;
            }
            if (callback == null) {
                xe.e("Ad choices asset view is not provided.");
            } else {
                ViewGroup viewGroup = callback instanceof ViewGroup ? (ViewGroup) callback : null;
                if (viewGroup != null) {
                    this.h = bjVar.a((View.OnClickListener) this, true);
                    if (this.h != null) {
                        this.f.put("1007", new WeakReference<>(this.h));
                        this.d.put("1007", new WeakReference<>(this.h));
                        viewGroup.removeAllViews();
                        viewGroup.addView(this.h);
                    }
                }
            }
            bjVar.a(view, this.d, this.e, this, this);
            xn.f3583a.post(new bw(this, bjVar));
            a(view);
            this.g.b(view);
            synchronized (this.f3038b) {
                if (this.g instanceof bj) {
                    bj bjVar3 = (bj) this.g;
                    View view3 = this.c.get();
                    if (bjVar3 != null && bjVar3.p() != null && view3 != null && com.google.android.gms.ads.internal.ax.E().a(view3.getContext())) {
                        bmg bmgVar2 = this.k.get();
                        if (bmgVar2 == null) {
                            bmgVar2 = new bmg(view3.getContext(), view3);
                            this.k = new WeakReference<>(bmgVar2);
                        }
                        bmgVar2.a(bjVar3.r());
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.cm
    public final void b(com.google.android.gms.dynamic.a aVar) {
        synchronized (this.f3038b) {
            this.g.a((View) com.google.android.gms.dynamic.b.a(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a(String[] strArr) {
        for (String str : strArr) {
            if (this.d.get(str) != null) {
                return true;
            }
        }
        for (String str2 : strArr) {
            if (this.e.get(str2) != null) {
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(bj bjVar) {
        View view;
        synchronized (this.f3038b) {
            String[] strArr = f3037a;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    view = null;
                    break;
                }
                WeakReference<View> weakReference = this.f.get(strArr[i]);
                if (weakReference != null) {
                    view = weakReference.get();
                    break;
                }
                i++;
            }
            if (!(view instanceof FrameLayout)) {
                bjVar.l();
                return;
            }
            bx bxVar = new bx(this, view);
            if (bjVar instanceof be) {
                bjVar.b(view, bxVar);
            } else {
                bjVar.a(view, bxVar);
            }
        }
    }

    private final void a(View view) {
        bf bfVarI;
        synchronized (this.f3038b) {
            if (this.g != null) {
                if (this.g instanceof be) {
                    bfVarI = ((be) this.g).i();
                } else {
                    bfVarI = this.g;
                }
                if (bfVarI != null) {
                    bfVarI.c(view);
                }
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        View view;
        synchronized (this.f3038b) {
            if (this.g != null && (view = this.c.get()) != null) {
                this.g.c(view, this.f);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        View view;
        synchronized (this.f3038b) {
            if (this.g != null && (view = this.c.get()) != null) {
                this.g.c(view, this.f);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.f3038b) {
            if (this.g == null) {
                return false;
            }
            View view2 = this.c.get();
            if (view2 == null) {
                return false;
            }
            view2.getLocationOnScreen(new int[2]);
            Point point = new Point((int) (motionEvent.getRawX() - r2[0]), (int) (motionEvent.getRawY() - r2[1]));
            this.i = point;
            if (motionEvent.getAction() == 0) {
                this.j = point;
            }
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            motionEventObtain.setLocation(point.x, point.y);
            this.g.a(motionEventObtain);
            motionEventObtain.recycle();
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.by
    public final synchronized Map<String, WeakReference<View>> b() {
        return this.f;
    }

    @Override // com.google.android.gms.internal.ads.by
    public final View c() {
        return this.c.get();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        synchronized (this.f3038b) {
            if (this.g == null) {
                return;
            }
            View view2 = this.c.get();
            if (view2 == null) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat("x", a(this.i.x));
            bundle.putFloat("y", a(this.i.y));
            bundle.putFloat("start_x", a(this.j.x));
            bundle.putFloat("start_y", a(this.j.y));
            if (this.h != null && this.h.equals(view)) {
                if (this.g instanceof be) {
                    if (((be) this.g).i() != null) {
                        ((be) this.g).i().a(view, "1007", bundle, this.f, view2, false);
                    }
                } else {
                    this.g.a(view, "1007", bundle, this.f, view2, false);
                }
            } else {
                this.g.a(view, this.f, bundle, view2);
            }
        }
    }

    private final int a(int i) {
        int iB;
        synchronized (this.f3038b) {
            bra.a();
            iB = aac.b(this.g.p(), i);
        }
        return iB;
    }
}
