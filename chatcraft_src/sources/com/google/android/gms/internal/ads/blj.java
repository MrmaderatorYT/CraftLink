package com.google.android.gms.internal.ads;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class blj implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a, reason: collision with root package name */
    protected final blh f2805a;
    private final WeakReference<wk> c;
    private final bmu e;
    private final Context f;
    private final WindowManager g;
    private final PowerManager h;
    private final KeyguardManager i;
    private final DisplayMetrics j;
    private blq k;
    private boolean l;
    private boolean p;
    private BroadcastReceiver r;
    private float x;

    /* renamed from: b, reason: collision with root package name */
    private final Object f2806b = new Object();
    private boolean m = false;
    private boolean n = false;
    private final HashSet<blg> s = new HashSet<>();
    private final HashSet<bmf> u = new HashSet<>();
    private final Rect v = new Rect();
    private WeakReference<ViewTreeObserver> d = new WeakReference<>(null);
    private boolean o = true;
    private boolean q = false;
    private zr t = new zr(200);
    private final blm w = new blm(this, new Handler());

    public blj(Context context, bqn bqnVar, wk wkVar, aar aarVar, bmu bmuVar) {
        this.c = new WeakReference<>(wkVar);
        this.e = bmuVar;
        this.f2805a = new blh(UUID.randomUUID().toString(), aarVar, bqnVar.f2974a, wkVar.k, wkVar.a(), bqnVar.h);
        this.g = (WindowManager) context.getSystemService("window");
        this.h = (PowerManager) context.getApplicationContext().getSystemService("power");
        this.i = (KeyguardManager) context.getSystemService("keyguard");
        this.f = context;
        this.f.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.w);
        this.j = context.getResources().getDisplayMetrics();
        Display defaultDisplay = this.g.getDefaultDisplay();
        this.v.right = defaultDisplay.getWidth();
        this.v.bottom = defaultDisplay.getHeight();
        a();
    }

    public final void a() {
        this.x = yh.a(this.f);
    }

    public final void b() {
        synchronized (this.f2806b) {
            if (this.o) {
                this.p = true;
                try {
                    try {
                        JSONObject jSONObjectI = i();
                        jSONObjectI.put("doneReasonCode", "u");
                        a(jSONObjectI, true);
                    } catch (RuntimeException e) {
                        xe.b("Failure while processing active view data.", e);
                    }
                } catch (JSONException e2) {
                    xe.b("JSON failure while processing active view data.", e2);
                }
                String strValueOf = String.valueOf(this.f2805a.d());
                xe.b(strValueOf.length() != 0 ? "Untracking ad unit: ".concat(strValueOf) : new String("Untracking ad unit: "));
            }
        }
    }

    protected final void a(int i) {
        boolean z;
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        synchronized (this.f2806b) {
            Iterator<bmf> it = this.u.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().a()) {
                    z = true;
                    break;
                }
            }
            if (z && this.o) {
                View viewA = this.e.a();
                boolean z2 = viewA != null && com.google.android.gms.ads.internal.ax.e().a(viewA, this.h, this.i);
                boolean z3 = viewA != null && z2 && viewA.getGlobalVisibleRect(new Rect(), null);
                if (this.e.b()) {
                    b();
                    return;
                }
                if (i == 1 && !this.t.a() && z3 == this.q) {
                    return;
                }
                if (z3 || this.q || i != 1) {
                    try {
                        a(a(viewA, Boolean.valueOf(z2)), false);
                        this.q = z3;
                    } catch (RuntimeException | JSONException e) {
                        xe.a("Active view update failed.", e);
                    }
                    View viewA2 = this.e.c().a();
                    if (viewA2 != null && (viewTreeObserver2 = viewA2.getViewTreeObserver()) != (viewTreeObserver = this.d.get())) {
                        h();
                        if (!this.l || (viewTreeObserver != null && viewTreeObserver.isAlive())) {
                            this.l = true;
                            viewTreeObserver2.addOnScrollChangedListener(this);
                            viewTreeObserver2.addOnGlobalLayoutListener(this);
                        }
                        this.d = new WeakReference<>(viewTreeObserver2);
                    }
                    g();
                }
            }
        }
    }

    private final void g() {
        if (this.k != null) {
            this.k.a(this);
        }
    }

    public final boolean c() {
        boolean z;
        synchronized (this.f2806b) {
            z = this.o;
        }
        return z;
    }

    private static int a(int i, DisplayMetrics displayMetrics) {
        return (int) (i / displayMetrics.density);
    }

    final boolean a(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(this.f2805a.d());
    }

    final void b(Map<String, String> map) {
        a(3);
    }

    final void a(bmf bmfVar, Map<String, String> map) {
        String strValueOf = String.valueOf(this.f2805a.d());
        xe.b(strValueOf.length() != 0 ? "Received request to untrack: ".concat(strValueOf) : new String("Received request to untrack: "));
        b(bmfVar);
    }

    final void c(Map<String, String> map) {
        if (map.containsKey("isVisible")) {
            boolean z = "1".equals(map.get("isVisible")) || "true".equals(map.get("isVisible"));
            Iterator<blg> it = this.s.iterator();
            while (it.hasNext()) {
                it.next().a(this, z);
            }
        }
    }

    private final void h() {
        ViewTreeObserver viewTreeObserver = this.d.get();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnScrollChangedListener(this);
        viewTreeObserver.removeGlobalOnLayoutListener(this);
    }

    private final JSONObject i() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("afmaVersion", this.f2805a.b()).put("activeViewJSON", this.f2805a.c()).put("timestamp", com.google.android.gms.ads.internal.ax.l().b()).put("adFormat", this.f2805a.a()).put("hashCode", this.f2805a.d()).put("isMraid", this.f2805a.e()).put("isStopped", this.n).put("isPaused", this.m).put("isNative", this.f2805a.f()).put("isScreenOn", j()).put("appMuted", com.google.android.gms.ads.internal.ax.j().b()).put("appVolume", com.google.android.gms.ads.internal.ax.j().a()).put("deviceVolume", this.x);
        return jSONObject;
    }

    private static JSONObject a(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }

    private final void a(JSONObject jSONObject, boolean z) {
        try {
            JSONObject jSONObjectA = a(jSONObject);
            ArrayList arrayList = new ArrayList(this.u);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((bmf) obj).a(jSONObjectA, z);
            }
        } catch (Throwable th) {
            xe.b("Skipping active view message.", th);
        }
    }

    public final void a(bmf bmfVar) {
        if (this.u.isEmpty()) {
            synchronized (this.f2806b) {
                if (this.r == null) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    this.r = new blk(this);
                    com.google.android.gms.ads.internal.ax.B().a(this.f, this.r, intentFilter);
                }
            }
            a(3);
        }
        this.u.add(bmfVar);
        try {
            bmfVar.a(a(a(this.e.a(), (Boolean) null)), false);
        } catch (JSONException e) {
            xe.b("Skipping measurement update for new client.", e);
        }
    }

    public final void b(bmf bmfVar) {
        this.u.remove(bmfVar);
        bmfVar.b();
        if (this.u.isEmpty()) {
            synchronized (this.f2806b) {
                h();
                synchronized (this.f2806b) {
                    if (this.r != null) {
                        try {
                            com.google.android.gms.ads.internal.ax.B().a(this.f, this.r);
                        } catch (IllegalStateException e) {
                            xe.b("Failed trying to unregister the receiver", e);
                        } catch (Exception e2) {
                            com.google.android.gms.ads.internal.ax.i().a(e2, "ActiveViewUnit.stopScreenStatusMonitoring");
                        }
                        this.r = null;
                    }
                }
                this.f.getContentResolver().unregisterContentObserver(this.w);
                int i = 0;
                this.o = false;
                g();
                ArrayList arrayList = new ArrayList(this.u);
                int size = arrayList.size();
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    b((bmf) obj);
                }
            }
        }
    }

    private final JSONObject a(View view, Boolean bool) throws JSONException {
        if (view == null) {
            return i().put("isAttachedToWindow", false).put("isScreenOn", j()).put("isVisible", false);
        }
        boolean zA = com.google.android.gms.ads.internal.ax.g().a(view);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        try {
            view.getLocationOnScreen(iArr);
            view.getLocationInWindow(iArr2);
        } catch (Exception e) {
            xe.b("Failure getting view location.", e);
        }
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect2, null);
        Rect rect3 = new Rect();
        boolean localVisibleRect = view.getLocalVisibleRect(rect3);
        Rect rect4 = new Rect();
        view.getHitRect(rect4);
        JSONObject jSONObjectI = i();
        jSONObjectI.put("windowVisibility", view.getWindowVisibility()).put("isAttachedToWindow", zA).put("viewBox", new JSONObject().put("top", a(this.v.top, this.j)).put("bottom", a(this.v.bottom, this.j)).put("left", a(this.v.left, this.j)).put("right", a(this.v.right, this.j))).put("adBox", new JSONObject().put("top", a(rect.top, this.j)).put("bottom", a(rect.bottom, this.j)).put("left", a(rect.left, this.j)).put("right", a(rect.right, this.j))).put("globalVisibleBox", new JSONObject().put("top", a(rect2.top, this.j)).put("bottom", a(rect2.bottom, this.j)).put("left", a(rect2.left, this.j)).put("right", a(rect2.right, this.j))).put("globalVisibleBoxVisible", globalVisibleRect).put("localVisibleBox", new JSONObject().put("top", a(rect3.top, this.j)).put("bottom", a(rect3.bottom, this.j)).put("left", a(rect3.left, this.j)).put("right", a(rect3.right, this.j))).put("localVisibleBoxVisible", localVisibleRect).put("hitBox", new JSONObject().put("top", a(rect4.top, this.j)).put("bottom", a(rect4.bottom, this.j)).put("left", a(rect4.left, this.j)).put("right", a(rect4.right, this.j))).put("screenDensity", this.j.density);
        if (bool == null) {
            bool = Boolean.valueOf(com.google.android.gms.ads.internal.ax.e().a(view, this.h, this.i));
        }
        jSONObjectI.put("isVisible", bool.booleanValue());
        return jSONObjectI;
    }

    private final boolean j() {
        if (Build.VERSION.SDK_INT >= 20) {
            return this.h.isInteractive();
        }
        return this.h.isScreenOn();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        a(1);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        a(2);
    }

    public final void a(blq blqVar) {
        synchronized (this.f2806b) {
            this.k = blqVar;
        }
    }

    public final void d() {
        synchronized (this.f2806b) {
            this.n = true;
            a(3);
        }
    }

    public final void e() {
        synchronized (this.f2806b) {
            this.m = true;
            a(3);
        }
    }

    public final void f() {
        synchronized (this.f2806b) {
            this.m = false;
            a(3);
        }
    }
}
