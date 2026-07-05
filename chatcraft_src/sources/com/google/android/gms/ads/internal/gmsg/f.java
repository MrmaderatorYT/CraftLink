package com.google.android.gms.ads.internal.gmsg;

import android.text.TextUtils;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.xe;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class f implements ac<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final Object f1598a = new Object();

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("mLock")
    private final Map<String, g> f1599b = new HashMap();

    public final void a(String str, g gVar) {
        synchronized (this.f1598a) {
            this.f1599b.put(str, gVar);
        }
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final void zza(Object obj, Map<String, String> map) {
        String strConcat;
        String str = map.get("id");
        String str2 = map.get("fail");
        String str3 = map.get("fail_reason");
        String str4 = map.get("fail_stack");
        String str5 = map.get("result");
        if (TextUtils.isEmpty(str4)) {
            str3 = "Unknown Fail Reason.";
        }
        if (TextUtils.isEmpty(str4)) {
            strConcat = BuildConfig.FLAVOR;
        } else {
            String strValueOf = String.valueOf(str4);
            strConcat = strValueOf.length() != 0 ? "\n".concat(strValueOf) : new String("\n");
        }
        synchronized (this.f1598a) {
            g gVarRemove = this.f1599b.remove(str);
            if (gVarRemove == null) {
                String strValueOf2 = String.valueOf(str);
                xe.e(strValueOf2.length() != 0 ? "Received result for unexpected method invocation: ".concat(strValueOf2) : new String("Received result for unexpected method invocation: "));
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                String strValueOf3 = String.valueOf(str3);
                String strValueOf4 = String.valueOf(strConcat);
                gVarRemove.a(strValueOf4.length() != 0 ? strValueOf3.concat(strValueOf4) : new String(strValueOf3));
            } else {
                if (str5 == null) {
                    gVarRemove.a((JSONObject) null);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str5);
                    if (xe.a()) {
                        String strValueOf5 = String.valueOf(jSONObject.toString(2));
                        xe.a(strValueOf5.length() != 0 ? "Result GMSG: ".concat(strValueOf5) : new String("Result GMSG: "));
                    }
                    gVarRemove.a(jSONObject);
                } catch (JSONException e) {
                    gVarRemove.a(e.getMessage());
                }
            }
        }
    }
}
