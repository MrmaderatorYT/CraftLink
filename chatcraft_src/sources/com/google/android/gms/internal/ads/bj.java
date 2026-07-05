package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class bj implements bf {

    /* renamed from: a, reason: collision with root package name */
    boolean f2721a;

    /* renamed from: b, reason: collision with root package name */
    boolean f2722b;
    private final bg d;
    private final Context e;
    private final ap f;
    private final JSONObject g;
    private final pn h;
    private final bh i;
    private final axe j;
    private final aar k;
    private String l;
    private vz m;
    private by n;
    private final Object c = new Object();
    private boolean o = false;
    private long p = 0;
    private long q = 0;
    private WeakReference<View> r = null;

    public bj(Context context, bg bgVar, pn pnVar, axe axeVar, JSONObject jSONObject, bh bhVar, aar aarVar, String str) {
        this.e = context;
        this.d = bgVar;
        this.h = pnVar;
        this.j = axeVar;
        this.g = jSONObject;
        this.i = bhVar;
        this.k = aarVar;
        this.l = str;
        this.f = new ap(this.h);
    }

    @Override // com.google.android.gms.internal.ads.bf
    public void b(View view, Map<String, WeakReference<View>> map) {
    }

    @Override // com.google.android.gms.internal.ads.bf
    public View a(View.OnClickListener onClickListener, boolean z) {
        ao aoVarC = this.i.c();
        if (aoVarC == null) {
            return null;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (!z) {
            int iH = aoVarC.h();
            if (iH == 0) {
                layoutParams.addRule(10);
                layoutParams.addRule(9);
            } else {
                switch (iH) {
                    case 2:
                        layoutParams.addRule(12);
                        layoutParams.addRule(11);
                        break;
                    case 3:
                        layoutParams.addRule(12);
                        layoutParams.addRule(9);
                        break;
                    default:
                        layoutParams.addRule(10);
                        layoutParams.addRule(11);
                        break;
                }
            }
        }
        ar arVar = new ar(this.e, aoVarC, layoutParams);
        arVar.setOnClickListener(onClickListener);
        arVar.setContentDescription((CharSequence) bra.e().a(o.bB));
        return arVar;
    }

    @Override // com.google.android.gms.internal.ads.bf
    public boolean a() {
        ao aoVarC = this.i.c();
        return aoVarC != null && aoVarC.i();
    }

    @Override // com.google.android.gms.internal.ads.bf
    public boolean c() {
        return this.g != null && this.g.optBoolean("allow_pub_owned_ad_view", false);
    }

    @Override // com.google.android.gms.internal.ads.bf
    public boolean b() {
        return this.g != null && this.g.optBoolean("allow_custom_click_gesture", false);
    }

    private final boolean a(String str) {
        JSONObject jSONObjectOptJSONObject = this.g == null ? null : this.g.optJSONObject("allow_pub_event_reporting");
        if (jSONObjectOptJSONObject == null) {
            return false;
        }
        return jSONObjectOptJSONObject.optBoolean(str, false);
    }

    @Override // com.google.android.gms.internal.ads.bf
    public final void a(View view, String str, Bundle bundle, Map<String, WeakReference<View>> map, View view2, boolean z) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObjectA = a(map, view2);
        JSONObject jSONObjectG = g(view2);
        JSONObject jSONObjectH = h(view2);
        JSONObject jSONObjectI = i(view2);
        JSONObject jSONObject3 = null;
        try {
            JSONObject jSONObjectA2 = com.google.android.gms.ads.internal.ax.e().a(bundle, (JSONObject) null);
            jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("click_point", jSONObjectA2);
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            jSONObject2.put("asset_id", str);
            jSONObject = jSONObject2;
        } catch (Exception e3) {
            e = e3;
            jSONObject3 = jSONObject2;
            xe.b("Error occurred while grabbing click signals.", e);
            jSONObject = jSONObject3;
            a(view, jSONObjectG, jSONObjectA, jSONObjectH, jSONObjectI, str, jSONObject, null, z);
        }
        a(view, jSONObjectG, jSONObjectA, jSONObjectH, jSONObjectI, str, jSONObject, null, z);
    }

    @Override // com.google.android.gms.internal.ads.bf
    public void a(View view, Map<String, WeakReference<View>> map, Bundle bundle, View view2) throws JSONException {
        com.google.android.gms.common.internal.i.b("Invalid call from a non-UI thread.");
        if (map != null) {
            synchronized (map) {
                for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                    if (view.equals(entry.getValue().get())) {
                        a(view, entry.getKey(), bundle, map, view2, false);
                        return;
                    }
                }
            }
        }
        if ("6".equals(this.i.a())) {
            a(view, "3099", bundle, map, view2, false);
        } else if ("2".equals(this.i.a())) {
            a(view, "2099", bundle, map, view2, false);
        } else if ("1".equals(this.i.a())) {
            a(view, "1099", bundle, map, view2, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.bf
    public final void b(Bundle bundle) throws JSONException {
        if (bundle == null) {
            xe.b("Click data is null. No click is reported.");
        } else if (!a("click_reporting")) {
            xe.c("The ad slot cannot handle external click events. You must be whitelisted to be able to report your click events.");
        } else {
            a(null, null, null, null, null, bundle.getBundle("click_signal").getString("asset_id"), null, com.google.android.gms.ads.internal.ax.e().a(bundle, (JSONObject) null), false);
        }
    }

    private final void a(View view, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, JSONObject jSONObject6, boolean z) throws JSONException {
        com.google.android.gms.common.internal.i.b("Invalid call from a non-UI thread.");
        try {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("ad", this.g);
            if (jSONObject2 != null) {
                jSONObject7.put("asset_view_signal", jSONObject2);
            }
            if (jSONObject != null) {
                jSONObject7.put("ad_view_signal", jSONObject);
            }
            if (jSONObject5 != null) {
                jSONObject7.put("click_signal", jSONObject5);
            }
            if (jSONObject3 != null) {
                jSONObject7.put("scroll_view_signal", jSONObject3);
            }
            if (jSONObject4 != null) {
                jSONObject7.put("lock_screen_signal", jSONObject4);
            }
            JSONObject jSONObject8 = new JSONObject();
            long jA = com.google.android.gms.ads.internal.ax.l().a();
            jSONObject8.put("time_from_last_touch_down", jA - this.q);
            jSONObject8.put("time_from_last_touch", jA - this.p);
            jSONObject7.put("touch_signal", jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            jSONObject9.put("asset_id", str);
            jSONObject9.put("template", this.i.a());
            com.google.android.gms.ads.internal.ax.g();
            jSONObject9.put("is_privileged_process", xv.e());
            if (((Boolean) bra.e().a(o.bG)).booleanValue() && this.f.a() != null && this.g.optBoolean("custom_one_point_five_click_enabled", false)) {
                jSONObject9.put("custom_one_point_five_click_eligible", true);
            }
            jSONObject9.put("timestamp", jA);
            jSONObject9.put("has_custom_click_handler", this.d.c(this.i.b()) != null);
            if (this.o && b()) {
                jSONObject9.put("custom_click_gesture_eligible", true);
            }
            if (z) {
                jSONObject9.put("is_custom_click_gesture", true);
            }
            jSONObject7.put("has_custom_click_handler", this.d.c(this.i.b()) != null);
            try {
                JSONObject jSONObjectOptJSONObject = this.g.optJSONObject("tracking_urls_and_actions");
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                }
                jSONObject9.put("click_signals", this.j.a().a(this.e, jSONObjectOptJSONObject.optString("click_string"), view));
            } catch (Exception e) {
                xe.b("Exception obtaining click signals", e);
            }
            jSONObject7.put("click", jSONObject9);
            if (jSONObject6 != null) {
                jSONObject7.put("provided_signals", jSONObject6);
            }
            jSONObject7.put("ads_id", this.l);
            aax.a(this.h.b(jSONObject7), "NativeAdEngineImpl.performClick");
        } catch (JSONException e2) {
            xe.b("Unable to create click JSON.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.bf
    public void a(MotionEvent motionEvent) {
        this.p = com.google.android.gms.ads.internal.ax.l().a();
        if (motionEvent.getAction() == 0) {
            this.q = com.google.android.gms.ads.internal.ax.l().a();
        }
        this.j.a(motionEvent);
    }

    @Override // com.google.android.gms.internal.ads.bf
    public final void c(Bundle bundle) {
        if (bundle == null) {
            xe.b("Touch event data is null. No touch event is reported.");
            return;
        }
        if (!a("touch_reporting")) {
            xe.c("The ad slot cannot handle external touch events. You must be whitelisted to be able to report your touch events.");
            return;
        }
        this.j.a().a((int) bundle.getFloat("x"), (int) bundle.getFloat("y"), bundle.getInt("duration_ms"));
    }

    @Override // com.google.android.gms.internal.ads.bf
    public final void c(View view, Map<String, WeakReference<View>> map) {
        synchronized (this.c) {
            if (this.f2721a) {
                return;
            }
            if (e(view)) {
                a(view, map);
                return;
            }
            if (((Boolean) bra.e().a(o.bF)).booleanValue() && map != null) {
                synchronized (map) {
                    Iterator<Map.Entry<String, WeakReference<View>>> it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        View view2 = it.next().getValue().get();
                        if (view2 != null && e(view2)) {
                            a(view, map);
                            return;
                        }
                    }
                }
            }
        }
    }

    private static boolean e(View view) {
        return view.isShown() && view.getGlobalVisibleRect(new Rect(), null);
    }

    @Override // com.google.android.gms.internal.ads.bf
    public void m() {
        this.d.K();
    }

    @Override // com.google.android.gms.internal.ads.bf
    public void a(View view, Map<String, WeakReference<View>> map) throws JSONException {
        a(g(view), a(map, view), h(view), i(view), (JSONObject) null);
    }

    @Override // com.google.android.gms.internal.ads.bf
    public final boolean a(Bundle bundle) {
        if (!a("impression_reporting")) {
            xe.c("The ad slot cannot handle external impression events. You must be whitelisted to whitelisted to be able to report your impression events.");
            return false;
        }
        return a((JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, com.google.android.gms.ads.internal.ax.e().a(bundle, (JSONObject) null));
    }

    private final boolean a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5) throws JSONException {
        com.google.android.gms.common.internal.i.b("Invalid call from a non-UI thread.");
        if (this.f2721a) {
            return true;
        }
        this.f2721a = true;
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("ad", this.g);
            jSONObject6.put("ads_id", this.l);
            if (jSONObject2 != null) {
                jSONObject6.put("asset_view_signal", jSONObject2);
            }
            if (jSONObject != null) {
                jSONObject6.put("ad_view_signal", jSONObject);
            }
            if (jSONObject3 != null) {
                jSONObject6.put("scroll_view_signal", jSONObject3);
            }
            if (jSONObject4 != null) {
                jSONObject6.put("lock_screen_signal", jSONObject4);
            }
            if (jSONObject5 != null) {
                jSONObject6.put("provided_signals", jSONObject5);
            }
            aax.a(this.h.c(jSONObject6), "NativeAdEngineImpl.recordImpression");
            this.d.a(this);
            this.d.C();
            m();
            return true;
        } catch (JSONException e) {
            xe.b("Unable to create impression JSON.", e);
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.bf
    public void e() throws JSONException {
        com.google.android.gms.common.internal.i.b("Invalid call from a non-UI thread.");
        if (this.f2722b) {
            return;
        }
        this.f2722b = true;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.g);
            jSONObject.put("ads_id", this.l);
            aax.a(this.h.d(jSONObject), "NativeAdEngineImpl.recordDownloadedImpression");
        } catch (JSONException e) {
            aan.b(BuildConfig.FLAVOR, e);
        }
    }

    @Override // com.google.android.gms.internal.ads.bf
    public final View o() {
        if (this.r != null) {
            return this.r.get();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.bf
    public final void c(View view) {
        this.r = new WeakReference<>(view);
    }

    @Override // com.google.android.gms.internal.ads.bf
    public final void b(View view) {
        axa axaVarA;
        if (!((Boolean) bra.e().a(o.bh)).booleanValue() || this.j == null || (axaVarA = this.j.a()) == null) {
            return;
        }
        axaVarA.a(view);
    }

    public void a(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        view.setOnTouchListener(onTouchListener);
        view.setClickable(true);
        view.setOnClickListener(onClickListener);
        if (map != null) {
            synchronized (map) {
                Iterator<Map.Entry<String, WeakReference<View>>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    View view2 = it.next().getValue().get();
                    if (view2 != null) {
                        view2.setOnTouchListener(onTouchListener);
                        view2.setClickable(true);
                        view2.setOnClickListener(onClickListener);
                    }
                }
            }
        }
        if (map2 != null) {
            synchronized (map2) {
                Iterator<Map.Entry<String, WeakReference<View>>> it2 = map2.entrySet().iterator();
                while (it2.hasNext()) {
                    View view3 = it2.next().getValue().get();
                    if (view3 != null) {
                        view3.setOnTouchListener(onTouchListener);
                    }
                }
            }
        }
    }

    public afu j() {
        if (this.g == null || this.g.optJSONObject("overlay") == null) {
            return null;
        }
        com.google.android.gms.ads.internal.ax.f();
        Context context = this.e;
        bqn bqnVarA = bqn.a(this.e);
        afu afuVarA = aga.a(context, ahh.a(bqnVarA), bqnVarA.f2974a, false, false, this.j, this.k, null, null, null, bos.a());
        if (afuVarA != null) {
            afuVarA.getView().setVisibility(8);
            new bl(afuVarA).a(this.h);
        }
        return afuVarA;
    }

    public final void a(Map<String, WeakReference<View>> map) {
        if (this.i.d() != null) {
            boolean z = true;
            if ("2".equals(this.i.a())) {
                xh xhVarK = com.google.android.gms.ads.internal.ax.i().k();
                String strD = this.d.D();
                String strA = this.i.a();
                if (map == null || (!map.containsKey("2011") && !map.containsKey("3010"))) {
                    z = false;
                }
                xhVarK.a(strD, strA, z);
                return;
            }
            if ("1".equals(this.i.a())) {
                xh xhVarK2 = com.google.android.gms.ads.internal.ax.i().k();
                String strD2 = this.d.D();
                String strA2 = this.i.a();
                if (map == null || (!map.containsKey("1009") && !map.containsKey("3010"))) {
                    z = false;
                }
                xhVarK2.a(strD2, strA2, z);
            }
        }
    }

    public final boolean b(View view, bd bdVar) {
        FrameLayout.LayoutParams layoutParams;
        if (((Boolean) bra.e().a(o.bE)).booleanValue()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        }
        View viewD = this.i.d();
        if (viewD == null) {
            return false;
        }
        ViewParent parent = viewD.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(viewD);
        }
        FrameLayout frameLayout = (FrameLayout) view;
        frameLayout.removeAllViews();
        frameLayout.addView(viewD, layoutParams);
        this.d.a(bdVar);
        return true;
    }

    public final void d(View view) {
        this.d.b(view);
    }

    @Override // com.google.android.gms.internal.ads.bf
    public final void a(View view, bd bdVar) {
        if (b(view, bdVar)) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        ((FrameLayout) view).removeAllViews();
        if (this.i instanceof bi) {
            bi biVar = (bi) this.i;
            if (biVar.f() == null || biVar.f().size() <= 0) {
                return;
            }
            Object obj = biVar.f().get(0);
            cd cdVarA = obj instanceof IBinder ? ce.a((IBinder) obj) : null;
            if (cdVarA != null) {
                try {
                    com.google.android.gms.dynamic.a aVarA = cdVarA.a();
                    if (aVarA != null) {
                        Drawable drawable = (Drawable) com.google.android.gms.dynamic.b.a(aVarA);
                        ImageView imageView = new ImageView(this.e);
                        imageView.setImageDrawable(drawable);
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ((FrameLayout) view).addView(imageView, layoutParams);
                    }
                } catch (RemoteException unused) {
                    xe.e("Could not get drawable from image");
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.bf
    public void a(dv dvVar) {
        if (((Boolean) bra.e().a(o.bG)).booleanValue()) {
            if (!this.g.optBoolean("custom_one_point_five_click_enabled", false)) {
                xe.e("setUnconfirmedClickListener: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
            } else {
                this.f.a(dvVar);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.bf
    public void d() {
        if (((Boolean) bra.e().a(o.bG)).booleanValue() && this.g.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.f.b();
        }
    }

    @Override // com.google.android.gms.internal.ads.bf
    public void a(View view) {
        if (((Boolean) bra.e().a(o.bG)).booleanValue()) {
            if (!this.g.optBoolean("custom_one_point_five_click_enabled", false)) {
                xe.e("setClickConfirmingView: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
                return;
            }
            ap apVar = this.f;
            if (view != null) {
                view.setOnClickListener(apVar);
                view.setClickable(true);
                apVar.c = new WeakReference<>(view);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.bf
    public void f() {
        this.o = true;
    }

    @Override // com.google.android.gms.internal.ads.bf
    public void g() throws JSONException {
        if (this.n == null) {
            xe.b("Ad should be associated with an ad view before calling recordCustomClickGesture()");
            return;
        }
        if (!this.o) {
            xe.b("Custom click reporting failed. enableCustomClickGesture is not set.");
        } else if (!b()) {
            xe.b("Custom click reporting failed. Ad unit id not whitelisted.");
        } else {
            a(this.n.c(), "3099", null, this.n.b(), this.n.c(), true);
        }
    }

    public final void a(by byVar) {
        this.n = byVar;
    }

    public final by q() {
        return this.n;
    }

    @Override // com.google.android.gms.internal.ads.bf
    public void l() {
        this.d.O();
    }

    @Override // com.google.android.gms.internal.ads.bf
    public void n() {
        this.d.P();
    }

    @Override // com.google.android.gms.internal.ads.bf
    public void k() {
        this.h.a();
    }

    @Override // com.google.android.gms.internal.ads.bf
    public final Context p() {
        return this.e;
    }

    private static int[] f(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    private final int a(int i) {
        bra.a();
        return aac.b(this.e, i);
    }

    private final JSONObject a(Rect rect) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", a(rect.right - rect.left));
        jSONObject.put("height", a(rect.bottom - rect.top));
        jSONObject.put("x", a(rect.left));
        jSONObject.put("y", a(rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    private final JSONObject g(View view) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        if (view == null) {
            return jSONObject2;
        }
        try {
            int[] iArrF = f(view);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("width", a(view.getMeasuredWidth()));
            jSONObject3.put("height", a(view.getMeasuredHeight()));
            jSONObject3.put("x", a(iArrF[0]));
            jSONObject3.put("y", a(iArrF[1]));
            jSONObject3.put("relative_to", "window");
            jSONObject2.put("frame", jSONObject3);
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect)) {
                jSONObject = a(rect);
            } else {
                jSONObject = new JSONObject();
                jSONObject.put("width", 0);
                jSONObject.put("height", 0);
                jSONObject.put("x", a(iArrF[0]));
                jSONObject.put("y", a(iArrF[1]));
                jSONObject.put("relative_to", "window");
            }
            jSONObject2.put("visible_bounds", jSONObject);
        } catch (Exception unused) {
            xe.e("Unable to get native ad view bounding box");
        }
        return jSONObject2;
    }

    private static JSONObject h(View view) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            com.google.android.gms.ads.internal.ax.e();
            jSONObject.put("contained_in_scroll_view", xn.d(view) != -1);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private final JSONObject i(View view) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            com.google.android.gms.ads.internal.ax.e();
            jSONObject.put("can_show_on_lock_screen", xn.c(view));
            com.google.android.gms.ads.internal.ax.e();
            jSONObject.put("is_keyguard_locked", xn.k(this.e));
        } catch (JSONException unused) {
            xe.e("Unable to get lock screen information");
        }
        return jSONObject;
    }

    private final JSONObject a(Map<String, WeakReference<View>> map, View view) {
        JSONObject jSONObjectA;
        JSONObject jSONObject = new JSONObject();
        if (map == null || view == null) {
            return jSONObject;
        }
        int[] iArrF = f(view);
        synchronized (map) {
            for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                View view2 = entry.getValue().get();
                if (view2 != null) {
                    int[] iArrF2 = f(view2);
                    JSONObject jSONObject2 = new JSONObject();
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("width", a(view2.getMeasuredWidth()));
                        jSONObject3.put("height", a(view2.getMeasuredHeight()));
                        jSONObject3.put("x", a(iArrF2[0] - iArrF[0]));
                        jSONObject3.put("y", a(iArrF2[1] - iArrF[1]));
                        jSONObject3.put("relative_to", "ad_view");
                        jSONObject2.put("frame", jSONObject3);
                        Rect rect = new Rect();
                        if (view2.getLocalVisibleRect(rect)) {
                            jSONObjectA = a(rect);
                        } else {
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("width", 0);
                            jSONObject4.put("height", 0);
                            jSONObject4.put("x", a(iArrF2[0] - iArrF[0]));
                            jSONObject4.put("y", a(iArrF2[1] - iArrF[1]));
                            jSONObject4.put("relative_to", "ad_view");
                            jSONObjectA = jSONObject4;
                        }
                        jSONObject2.put("visible_bounds", jSONObjectA);
                        if (view2 instanceof TextView) {
                            TextView textView = (TextView) view2;
                            jSONObject2.put("text_color", textView.getCurrentTextColor());
                            jSONObject2.put("font_size", textView.getTextSize());
                            jSONObject2.put("text", textView.getText());
                        }
                        jSONObject.put(entry.getKey(), jSONObject2);
                    } catch (JSONException unused) {
                        xe.e("Unable to get asset views information");
                    }
                }
            }
        }
        return jSONObject;
    }

    public final vz r() {
        if (!com.google.android.gms.ads.internal.ax.E().a(this.e)) {
            return null;
        }
        if (this.m == null) {
            this.m = new vz(this.e, this.d.D());
        }
        return this.m;
    }
}
