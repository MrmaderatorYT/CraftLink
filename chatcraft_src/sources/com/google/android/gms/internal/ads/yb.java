package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.webkit.WebSettings;

@TargetApi(17)
/* loaded from: classes.dex */
public class yb extends yd {
    @Override // com.google.android.gms.internal.ads.yd, com.google.android.gms.internal.ads.xy, com.google.android.gms.internal.ads.xv
    public final boolean a(Context context, WebSettings webSettings) {
        super.a(context, webSettings);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.xv
    public final String a(Context context) {
        String str;
        zv zvVarA = zv.a();
        if (TextUtils.isEmpty(zvVarA.f3646a)) {
            if (com.google.android.gms.common.util.b.a()) {
                str = (String) zt.a(context, new zw(zvVarA, context));
            } else {
                str = (String) zt.a(context, new zx(zvVarA, com.google.android.gms.common.e.a(context), context));
            }
            zvVarA.f3646a = str;
        }
        return zvVarA.f3646a;
    }

    @Override // com.google.android.gms.internal.ads.xv
    public final void b(Context context) {
        zv zvVarA = zv.a();
        xe.a("Updating user agent.");
        String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        if (!defaultUserAgent.equals(zvVarA.f3646a)) {
            Context contextA = com.google.android.gms.common.e.a(context);
            if (com.google.android.gms.common.util.b.a() || contextA == null) {
                SharedPreferences.Editor editorPutString = context.getSharedPreferences("admob_user_agent", 0).edit().putString("user_agent", WebSettings.getDefaultUserAgent(context));
                if (contextA == null) {
                    editorPutString.apply();
                } else {
                    com.google.android.gms.common.util.l.a(context, editorPutString, "admob_user_agent");
                }
            }
            zvVarA.f3646a = defaultUserAgent;
        }
        xe.a("User agent is updated.");
    }

    @Override // com.google.android.gms.internal.ads.xv
    public final Drawable a(Context context, Bitmap bitmap, boolean z, float f) {
        if (!z || f <= 0.0f || f > 25.0f) {
            return new BitmapDrawable(context.getResources(), bitmap);
        }
        try {
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateScaledBitmap);
            RenderScript renderScriptCreate = RenderScript.create(context);
            ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateScaledBitmap);
            Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
            scriptIntrinsicBlurCreate.setRadius(f);
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
            allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
            return new BitmapDrawable(context.getResources(), bitmapCreateBitmap);
        } catch (RuntimeException unused) {
            return new BitmapDrawable(context.getResources(), bitmap);
        }
    }
}
