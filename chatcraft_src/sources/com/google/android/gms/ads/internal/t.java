package com.google.android.gms.ads.internal;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.google.android.gms.internal.ads.afu;
import com.google.android.gms.internal.ads.ahc;
import com.google.android.gms.internal.ads.cd;
import com.google.android.gms.internal.ads.ce;
import com.google.android.gms.internal.ads.ka;
import com.google.android.gms.internal.ads.kw;
import com.google.android.gms.internal.ads.kz;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.wk;
import com.google.android.gms.internal.ads.xe;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import javax.annotation.ParametersAreNonnullByDefault;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class t {
    public static View a(wk wkVar) {
        if (wkVar == null) {
            xe.c("AdState is null");
            return null;
        }
        if (b(wkVar) && wkVar.f3544b != null) {
            return wkVar.f3544b.getView();
        }
        try {
            com.google.android.gms.dynamic.a aVarA = wkVar.p != null ? wkVar.p.a() : null;
            if (aVarA != null) {
                return (View) com.google.android.gms.dynamic.b.a(aVarA);
            }
            xe.e("View in mediation adapter is null.");
            return null;
        } catch (RemoteException e) {
            xe.c("Could not get View from mediation adapter.", e);
            return null;
        }
    }

    public static boolean a(final afu afuVar, ka kaVar, CountDownLatch countDownLatch) {
        boolean z = false;
        try {
            View view = afuVar.getView();
            if (view == null) {
                xe.e("AdWebView is null");
            } else {
                view.setVisibility(4);
                List<String> list = kaVar.f3221b.r;
                if (list == null || list.isEmpty()) {
                    xe.e("No template ids present in mediation response");
                } else {
                    afuVar.a("/nativeExpressAssetsLoaded", new w(countDownLatch));
                    afuVar.a("/nativeExpressAssetsLoadingFailed", new x(countDownLatch));
                    kw kwVarH = kaVar.c.h();
                    kz kzVarI = kaVar.c.i();
                    if (list.contains("2") && kwVarH != null) {
                        final com.google.android.gms.internal.ads.au auVar = new com.google.android.gms.internal.ads.au(kwVarH.a(), kwVarH.b(), kwVarH.c(), kwVarH.d(), kwVarH.e(), kwVarH.f(), kwVarH.g(), kwVarH.h(), null, kwVarH.l(), null, kwVarH.p() != null ? (View) com.google.android.gms.dynamic.b.a(kwVarH.p()) : null, kwVarH.q(), null);
                        final String str = kaVar.f3221b.q;
                        afuVar.w().a(new ahc(auVar, str, afuVar) { // from class: com.google.android.gms.ads.internal.u

                            /* renamed from: a, reason: collision with root package name */
                            private final com.google.android.gms.internal.ads.au f1649a;

                            /* renamed from: b, reason: collision with root package name */
                            private final String f1650b;
                            private final afu c;

                            {
                                this.f1649a = auVar;
                                this.f1650b = str;
                                this.c = afuVar;
                            }

                            @Override // com.google.android.gms.internal.ads.ahc
                            public final void a(boolean z2) throws JSONException {
                                t.a(this.f1649a, this.f1650b, this.c, z2);
                            }
                        });
                    } else if (list.contains("1") && kzVarI != null) {
                        final com.google.android.gms.internal.ads.aw awVar = new com.google.android.gms.internal.ads.aw(kzVarI.a(), kzVarI.b(), kzVarI.c(), kzVarI.d(), kzVarI.e(), kzVarI.f(), null, kzVarI.j(), null, kzVarI.n() != null ? (View) com.google.android.gms.dynamic.b.a(kzVarI.n()) : null, kzVarI.o(), null);
                        final String str2 = kaVar.f3221b.q;
                        afuVar.w().a(new ahc(awVar, str2, afuVar) { // from class: com.google.android.gms.ads.internal.v

                            /* renamed from: a, reason: collision with root package name */
                            private final com.google.android.gms.internal.ads.aw f1651a;

                            /* renamed from: b, reason: collision with root package name */
                            private final String f1652b;
                            private final afu c;

                            {
                                this.f1651a = awVar;
                                this.f1652b = str2;
                                this.c = afuVar;
                            }

                            @Override // com.google.android.gms.internal.ads.ahc
                            public final void a(boolean z2) throws JSONException {
                                t.a(this.f1651a, this.f1652b, this.c, z2);
                            }
                        });
                    } else {
                        xe.e("No matching template id and mapper");
                    }
                    String str3 = kaVar.f3221b.o;
                    String str4 = kaVar.f3221b.p;
                    if (str4 != null) {
                        afuVar.loadDataWithBaseURL(str4, str3, "text/html", "UTF-8", null);
                    } else {
                        afuVar.loadData(str3, "text/html", "UTF-8");
                    }
                    z = true;
                }
            }
        } catch (RemoteException e) {
            xe.c("Unable to invoke load assets", e);
        } catch (RuntimeException e2) {
            countDownLatch.countDown();
            throw e2;
        }
        if (!z) {
            countDownLatch.countDown();
        }
        return z;
    }

    public static boolean b(wk wkVar) {
        return (wkVar == null || !wkVar.n || wkVar.o == null || wkVar.o.o == null) ? false : true;
    }

    static com.google.android.gms.ads.internal.gmsg.ac<afu> a(kw kwVar, kz kzVar, c cVar) {
        return new y(kwVar, cVar, kzVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(afu afuVar) {
        View.OnClickListener onClickListener = afuVar.getOnClickListener();
        if (onClickListener != null) {
            onClickListener.onClick(afuVar.getView());
        }
    }

    private static JSONObject a(Bundle bundle, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (bundle == null || TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject(str);
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (bundle.containsKey(next)) {
                if ("image".equals(jSONObject2.getString(next))) {
                    Object obj = bundle.get(next);
                    if (obj instanceof Bitmap) {
                        jSONObject.put(next, a((Bitmap) obj));
                    } else {
                        xe.e("Invalid type. An image type extra should return a bitmap");
                    }
                } else if (bundle.get(next) instanceof Bitmap) {
                    xe.e("Invalid asset type. Bitmap should be returned only for image type");
                } else {
                    jSONObject.put(next, String.valueOf(bundle.get(next)));
                }
            }
        }
        return jSONObject;
    }

    private static String a(cd cdVar) {
        if (cdVar == null) {
            xe.e("Image is null. Returning empty string");
            return BuildConfig.FLAVOR;
        }
        try {
            Uri uriB = cdVar.b();
            if (uriB != null) {
                return uriB.toString();
            }
        } catch (RemoteException unused) {
            xe.e("Unable to get image uri. Trying data uri next");
        }
        return b(cdVar);
    }

    private static String b(cd cdVar) {
        try {
            com.google.android.gms.dynamic.a aVarA = cdVar.a();
            if (aVarA == null) {
                xe.e("Drawable is null. Returning empty string");
                return BuildConfig.FLAVOR;
            }
            Drawable drawable = (Drawable) com.google.android.gms.dynamic.b.a(aVarA);
            if (!(drawable instanceof BitmapDrawable)) {
                xe.e("Drawable is not an instance of BitmapDrawable. Returning empty string");
                return BuildConfig.FLAVOR;
            }
            return a(((BitmapDrawable) drawable).getBitmap());
        } catch (RemoteException unused) {
            xe.e("Unable to get drawable. Returning empty string");
            return BuildConfig.FLAVOR;
        }
    }

    private static String a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap == null) {
            xe.e("Bitmap is null. Returning empty string");
            return BuildConfig.FLAVOR;
        }
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        String strValueOf = String.valueOf("data:image/png;base64,");
        String strValueOf2 = String.valueOf(strEncodeToString);
        return strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
    }

    private static cd a(Object obj) {
        if (obj instanceof IBinder) {
            return ce.a((IBinder) obj);
        }
        return null;
    }

    static final /* synthetic */ void a(com.google.android.gms.internal.ads.aw awVar, String str, afu afuVar, boolean z) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("headline", awVar.e());
            jSONObject.put("body", awVar.i());
            jSONObject.put("call_to_action", awVar.k());
            jSONObject.put("advertiser", awVar.l());
            jSONObject.put("logo", a(awVar.j()));
            JSONArray jSONArray = new JSONArray();
            List listF = awVar.f();
            if (listF != null) {
                Iterator it = listF.iterator();
                while (it.hasNext()) {
                    jSONArray.put(a(a(it.next())));
                }
            }
            jSONObject.put("images", jSONArray);
            jSONObject.put("extras", a(awVar.o(), str));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("assets", jSONObject);
            jSONObject2.put("template_id", "1");
            afuVar.b("google.afma.nativeExpressAds.loadAssets", jSONObject2);
        } catch (JSONException e) {
            xe.c("Exception occurred when loading assets", e);
        }
    }

    static final /* synthetic */ void a(com.google.android.gms.internal.ads.au auVar, String str, afu afuVar, boolean z) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("headline", auVar.e());
            jSONObject.put("body", auVar.g());
            jSONObject.put("call_to_action", auVar.i());
            jSONObject.put("price", auVar.l());
            jSONObject.put("star_rating", String.valueOf(auVar.j()));
            jSONObject.put("store", auVar.k());
            jSONObject.put("icon", a(auVar.h()));
            JSONArray jSONArray = new JSONArray();
            List listF = auVar.f();
            if (listF != null) {
                Iterator it = listF.iterator();
                while (it.hasNext()) {
                    jSONArray.put(a(a(it.next())));
                }
            }
            jSONObject.put("images", jSONArray);
            jSONObject.put("extras", a(auVar.o(), str));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("assets", jSONObject);
            jSONObject2.put("template_id", "2");
            afuVar.b("google.afma.nativeExpressAds.loadAssets", jSONObject2);
        } catch (JSONException e) {
            xe.c("Exception occurred when loading assets", e);
        }
    }
}
