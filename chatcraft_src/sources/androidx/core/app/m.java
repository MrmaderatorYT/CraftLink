package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TaskStackBuilder.java */
/* loaded from: classes.dex */
public final class m implements Iterable<Intent> {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<Intent> f567a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private final Context f568b;

    /* compiled from: TaskStackBuilder.java */
    public interface a {
        Intent d();
    }

    private m(Context context) {
        this.f568b = context;
    }

    public static m a(Context context) {
        return new m(context);
    }

    public m a(Intent intent) {
        this.f567a.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m a(Activity activity) {
        Intent intentD = activity instanceof a ? ((a) activity).d() : null;
        if (intentD == null) {
            intentD = e.a(activity);
        }
        if (intentD != null) {
            ComponentName component = intentD.getComponent();
            if (component == null) {
                component = intentD.resolveActivity(this.f568b.getPackageManager());
            }
            a(component);
            a(intentD);
        }
        return this;
    }

    public m a(ComponentName componentName) {
        int size = this.f567a.size();
        try {
            Intent intentA = e.a(this.f568b, componentName);
            while (intentA != null) {
                this.f567a.add(size, intentA);
                intentA = e.a(this.f568b, intentA.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f567a.iterator();
    }

    public void a() {
        a((Bundle) null);
    }

    public void a(Bundle bundle) {
        if (this.f567a.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f567a.toArray(new Intent[this.f567a.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (androidx.core.a.a.a(this.f568b, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.f568b.startActivity(intent);
    }
}
