package com.crashlytics.android.a;

import android.os.Bundle;
import com.crashlytics.android.a.ab;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: FirebaseAnalyticsEventMapper.java */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private static final Set<String> f1283a = new HashSet(Arrays.asList("app_clear_data", "app_exception", "app_remove", "app_upgrade", "app_install", "app_update", "firebase_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement", "ad_exposure", "adunit_exposure", "ad_query", "ad_activeview", "ad_impression", "ad_click", "screen_view", "firebase_extra_parameter"));

    public q a(ab abVar) {
        Bundle bundle;
        String strA;
        boolean z = ab.b.CUSTOM.equals(abVar.c) && abVar.e != null;
        boolean z2 = ab.b.PREDEFINED.equals(abVar.c) && abVar.g != null;
        if (!z && !z2) {
            return null;
        }
        if (z2) {
            bundle = b(abVar);
        } else {
            bundle = new Bundle();
            if (abVar.f != null) {
                a(bundle, abVar.f);
            }
        }
        if (z2) {
            String str = (String) abVar.h.get("success");
            strA = a(abVar.g, (str == null || Boolean.parseBoolean(str)) ? false : true);
        } else {
            strA = a(abVar.e);
        }
        io.fabric.sdk.android.c.g().a("Answers", "Logging event into firebase...");
        return new q(strA, bundle);
    }

    private String a(String str) {
        if (str == null || str.length() == 0) {
            return "fabric_unnamed_event";
        }
        if (f1283a.contains(str)) {
            return "fabric_" + str;
        }
        String strReplaceAll = str.replaceAll("[^\\p{Alnum}_]+", "_");
        if (strReplaceAll.startsWith("ga_") || strReplaceAll.startsWith("google_") || strReplaceAll.startsWith("firebase_") || !Character.isLetter(strReplaceAll.charAt(0))) {
            strReplaceAll = "fabric_" + strReplaceAll;
        }
        return strReplaceAll.length() > 40 ? strReplaceAll.substring(0, 40) : strReplaceAll;
    }

    private String b(String str) {
        if (str == null || str.length() == 0) {
            return "fabric_unnamed_parameter";
        }
        String strReplaceAll = str.replaceAll("[^\\p{Alnum}_]+", "_");
        if (strReplaceAll.startsWith("ga_") || strReplaceAll.startsWith("google_") || strReplaceAll.startsWith("firebase_") || !Character.isLetter(strReplaceAll.charAt(0))) {
            strReplaceAll = "fabric_" + strReplaceAll;
        }
        return strReplaceAll.length() > 40 ? strReplaceAll.substring(0, 40) : strReplaceAll;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0040 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String a(java.lang.String r6, boolean r7) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.a.r.a(java.lang.String, boolean):java.lang.String");
    }

    private Bundle b(ab abVar) {
        Bundle bundle = new Bundle();
        if ("purchase".equals(abVar.g)) {
            a(bundle, "item_id", (String) abVar.h.get("itemId"));
            a(bundle, "item_name", (String) abVar.h.get("itemName"));
            a(bundle, "item_category", (String) abVar.h.get("itemType"));
            a(bundle, "value", b(abVar.h.get("itemPrice")));
            a(bundle, "currency", (String) abVar.h.get("currency"));
        } else if ("addToCart".equals(abVar.g)) {
            a(bundle, "item_id", (String) abVar.h.get("itemId"));
            a(bundle, "item_name", (String) abVar.h.get("itemName"));
            a(bundle, "item_category", (String) abVar.h.get("itemType"));
            a(bundle, "price", b(abVar.h.get("itemPrice")));
            a(bundle, "value", b(abVar.h.get("itemPrice")));
            a(bundle, "currency", (String) abVar.h.get("currency"));
            bundle.putLong("quantity", 1L);
        } else if ("startCheckout".equals(abVar.g)) {
            a(bundle, "quantity", Long.valueOf(((Integer) abVar.h.get("itemCount")).intValue()));
            a(bundle, "value", b(abVar.h.get("totalPrice")));
            a(bundle, "currency", (String) abVar.h.get("currency"));
        } else if ("contentView".equals(abVar.g)) {
            a(bundle, "content_type", (String) abVar.h.get("contentType"));
            a(bundle, "item_id", (String) abVar.h.get("contentId"));
            a(bundle, "item_name", (String) abVar.h.get("contentName"));
        } else if ("search".equals(abVar.g)) {
            a(bundle, "search_term", (String) abVar.h.get("query"));
        } else if ("share".equals(abVar.g)) {
            a(bundle, "method", (String) abVar.h.get("method"));
            a(bundle, "content_type", (String) abVar.h.get("contentType"));
            a(bundle, "item_id", (String) abVar.h.get("contentId"));
            a(bundle, "item_name", (String) abVar.h.get("contentName"));
        } else if ("rating".equals(abVar.g)) {
            a(bundle, "rating", String.valueOf(abVar.h.get("rating")));
            a(bundle, "content_type", (String) abVar.h.get("contentType"));
            a(bundle, "item_id", (String) abVar.h.get("contentId"));
            a(bundle, "item_name", (String) abVar.h.get("contentName"));
        } else if ("signUp".equals(abVar.g) || "login".equals(abVar.g) || "invite".equals(abVar.g)) {
            a(bundle, "method", (String) abVar.h.get("method"));
        } else if ("levelStart".equals(abVar.g)) {
            a(bundle, "level_name", (String) abVar.h.get("levelName"));
        } else if ("levelEnd".equals(abVar.g)) {
            a(bundle, "score", a(abVar.h.get("score")));
            a(bundle, "level_name", (String) abVar.h.get("levelName"));
            a(bundle, "success", c((String) abVar.h.get("success")));
        }
        a(bundle, abVar.f);
        return bundle;
    }

    private void a(Bundle bundle, String str, Long l) {
        if (l == null) {
            return;
        }
        bundle.putLong(str, l.longValue());
    }

    private void a(Bundle bundle, String str, Integer num) {
        if (num == null) {
            return;
        }
        bundle.putInt(str, num.intValue());
    }

    private void a(Bundle bundle, String str, String str2) {
        if (str2 == null) {
            return;
        }
        bundle.putString(str, str2);
    }

    private void a(Bundle bundle, String str, Double d) {
        Double dA = a(d);
        if (dA == null) {
            return;
        }
        bundle.putDouble(str, dA.doubleValue());
    }

    private Double a(Object obj) {
        String strValueOf = String.valueOf(obj);
        if (strValueOf == null) {
            return null;
        }
        return Double.valueOf(strValueOf);
    }

    private Integer c(String str) {
        if (str == null) {
            return null;
        }
        return Integer.valueOf(str.equals("true") ? 1 : 0);
    }

    private Double b(Object obj) {
        Long l = (Long) obj;
        if (l == null) {
            return null;
        }
        return Double.valueOf(new BigDecimal(l.longValue()).divide(a.f1240a).doubleValue());
    }

    private void a(Bundle bundle, Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            String strB = b(entry.getKey());
            if (value instanceof String) {
                bundle.putString(strB, entry.getValue().toString());
            } else if (value instanceof Double) {
                bundle.putDouble(strB, ((Double) entry.getValue()).doubleValue());
            } else if (value instanceof Long) {
                bundle.putLong(strB, ((Long) entry.getValue()).longValue());
            } else if (value instanceof Integer) {
                bundle.putInt(strB, ((Integer) entry.getValue()).intValue());
            }
        }
    }
}
