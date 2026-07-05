package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.util.Calendar;

/* compiled from: TwilightManager.java */
/* loaded from: classes.dex */
class k {

    /* renamed from: a, reason: collision with root package name */
    private static k f157a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f158b;
    private final LocationManager c;
    private final a d = new a();

    static k a(Context context) {
        if (f157a == null) {
            Context applicationContext = context.getApplicationContext();
            f157a = new k(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f157a;
    }

    k(Context context, LocationManager locationManager) {
        this.f158b = context;
        this.c = locationManager;
    }

    boolean a() {
        a aVar = this.d;
        if (c()) {
            return aVar.f159a;
        }
        Location locationB = b();
        if (locationB != null) {
            a(locationB);
            return aVar.f159a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location locationA = androidx.core.a.b.a(this.f158b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? a("network") : null;
        Location locationA2 = androidx.core.a.b.a(this.f158b, "android.permission.ACCESS_FINE_LOCATION") == 0 ? a("gps") : null;
        return (locationA2 == null || locationA == null) ? locationA2 != null ? locationA2 : locationA : locationA2.getTime() > locationA.getTime() ? locationA2 : locationA;
    }

    private Location a(String str) {
        try {
            if (this.c.isProviderEnabled(str)) {
                return this.c.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }

    private boolean c() {
        return this.d.f > System.currentTimeMillis();
    }

    private void a(Location location) {
        long j;
        a aVar = this.d;
        long jCurrentTimeMillis = System.currentTimeMillis();
        j jVarA = j.a();
        jVarA.a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = jVarA.f155a;
        jVarA.a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = jVarA.c == 1;
        long j3 = jVarA.f156b;
        long j4 = jVarA.f155a;
        boolean z2 = z;
        jVarA.a(86400000 + jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = jVarA.f156b;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + jCurrentTimeMillis;
        } else {
            j = (jCurrentTimeMillis > j4 ? 0 + j5 : jCurrentTimeMillis > j3 ? 0 + j4 : 0 + j3) + 60000;
        }
        aVar.f159a = z2;
        aVar.f160b = j2;
        aVar.c = j3;
        aVar.d = j4;
        aVar.e = j5;
        aVar.f = j;
    }

    /* compiled from: TwilightManager.java */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f159a;

        /* renamed from: b, reason: collision with root package name */
        long f160b;
        long c;
        long d;
        long e;
        long f;

        a() {
        }
    }
}
