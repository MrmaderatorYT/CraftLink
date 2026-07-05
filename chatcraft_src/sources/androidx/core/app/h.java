package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: NotificationCompatBuilder.java */
/* loaded from: classes.dex */
class h implements f {

    /* renamed from: a, reason: collision with root package name */
    private final Notification.Builder f551a;

    /* renamed from: b, reason: collision with root package name */
    private final g.b f552b;
    private RemoteViews c;
    private RemoteViews d;
    private final List<Bundle> e = new ArrayList();
    private final Bundle f = new Bundle();
    private int g;
    private RemoteViews h;

    h(g.b bVar) {
        this.f552b = bVar;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f551a = new Notification.Builder(bVar.f549a, bVar.I);
        } else {
            this.f551a = new Notification.Builder(bVar.f549a);
        }
        Notification notification = bVar.N;
        this.f551a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, bVar.h).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(bVar.d).setContentText(bVar.e).setContentInfo(bVar.j).setContentIntent(bVar.f).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(bVar.g, (notification.flags & 128) != 0).setLargeIcon(bVar.i).setNumber(bVar.k).setProgress(bVar.r, bVar.s, bVar.t);
        if (Build.VERSION.SDK_INT < 21) {
            this.f551a.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f551a.setSubText(bVar.p).setUsesChronometer(bVar.n).setPriority(bVar.l);
            Iterator<g.a> it = bVar.f550b.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            if (bVar.B != null) {
                this.f.putAll(bVar.B);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (bVar.x) {
                    this.f.putBoolean("android.support.localOnly", true);
                }
                if (bVar.u != null) {
                    this.f.putString("android.support.groupKey", bVar.u);
                    if (bVar.v) {
                        this.f.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f.putBoolean("android.support.useSideChannel", true);
                    }
                }
                if (bVar.w != null) {
                    this.f.putString("android.support.sortKey", bVar.w);
                }
            }
            this.c = bVar.F;
            this.d = bVar.G;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.f551a.setShowWhen(bVar.m);
            if (Build.VERSION.SDK_INT < 21 && bVar.O != null && !bVar.O.isEmpty()) {
                this.f.putStringArray("android.people", (String[]) bVar.O.toArray(new String[bVar.O.size()]));
            }
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.f551a.setLocalOnly(bVar.x).setGroup(bVar.u).setGroupSummary(bVar.v).setSortKey(bVar.w);
            this.g = bVar.M;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f551a.setCategory(bVar.A).setColor(bVar.C).setVisibility(bVar.D).setPublicVersion(bVar.E).setSound(notification.sound, notification.audioAttributes);
            Iterator<String> it2 = bVar.O.iterator();
            while (it2.hasNext()) {
                this.f551a.addPerson(it2.next());
            }
            this.h = bVar.H;
            if (bVar.c.size() > 0) {
                Bundle bundle = bVar.a().getBundle("android.car.EXTENSIONS");
                bundle = bundle == null ? new Bundle() : bundle;
                Bundle bundle2 = new Bundle();
                for (int i = 0; i < bVar.c.size(); i++) {
                    bundle2.putBundle(Integer.toString(i), i.a(bVar.c.get(i)));
                }
                bundle.putBundle("invisible_actions", bundle2);
                bVar.a().putBundle("android.car.EXTENSIONS", bundle);
                this.f.putBundle("android.car.EXTENSIONS", bundle);
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f551a.setExtras(bVar.B).setRemoteInputHistory(bVar.q);
            if (bVar.F != null) {
                this.f551a.setCustomContentView(bVar.F);
            }
            if (bVar.G != null) {
                this.f551a.setCustomBigContentView(bVar.G);
            }
            if (bVar.H != null) {
                this.f551a.setCustomHeadsUpContentView(bVar.H);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f551a.setBadgeIconType(bVar.J).setShortcutId(bVar.K).setTimeoutAfter(bVar.L).setGroupAlertBehavior(bVar.M);
            if (bVar.z) {
                this.f551a.setColorized(bVar.y);
            }
            if (TextUtils.isEmpty(bVar.I)) {
                return;
            }
            this.f551a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
    }

    public Notification a() {
        Bundle bundleA;
        RemoteViews remoteViewsD;
        RemoteViews remoteViewsC;
        g.c cVar = this.f552b.o;
        if (cVar != null) {
            cVar.a(this);
        }
        RemoteViews remoteViewsB = cVar != null ? cVar.b(this) : null;
        Notification notificationB = b();
        if (remoteViewsB != null) {
            notificationB.contentView = remoteViewsB;
        } else if (this.f552b.F != null) {
            notificationB.contentView = this.f552b.F;
        }
        if (Build.VERSION.SDK_INT >= 16 && cVar != null && (remoteViewsC = cVar.c(this)) != null) {
            notificationB.bigContentView = remoteViewsC;
        }
        if (Build.VERSION.SDK_INT >= 21 && cVar != null && (remoteViewsD = this.f552b.o.d(this)) != null) {
            notificationB.headsUpContentView = remoteViewsD;
        }
        if (Build.VERSION.SDK_INT >= 16 && cVar != null && (bundleA = g.a(notificationB)) != null) {
            cVar.a(bundleA);
        }
        return notificationB;
    }

    private void a(g.a aVar) {
        Bundle bundle;
        if (Build.VERSION.SDK_INT >= 20) {
            Notification.Action.Builder builder = new Notification.Action.Builder(aVar.a(), aVar.b(), aVar.c());
            if (aVar.f() != null) {
                for (RemoteInput remoteInput : k.a(aVar.f())) {
                    builder.addRemoteInput(remoteInput);
                }
            }
            if (aVar.d() != null) {
                bundle = new Bundle(aVar.d());
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", aVar.e());
            if (Build.VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(aVar.e());
            }
            bundle.putInt("android.support.action.semanticAction", aVar.g());
            if (Build.VERSION.SDK_INT >= 28) {
                builder.setSemanticAction(aVar.g());
            }
            bundle.putBoolean("android.support.action.showsUserInterface", aVar.i());
            builder.addExtras(bundle);
            this.f551a.addAction(builder.build());
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.e.add(i.a(this.f551a, aVar));
        }
    }

    protected Notification b() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f551a.build();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Notification notificationBuild = this.f551a.build();
            if (this.g != 0) {
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) != 0 && this.g == 2) {
                    a(notificationBuild);
                }
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) == 0 && this.g == 1) {
                    a(notificationBuild);
                }
            }
            return notificationBuild;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f551a.setExtras(this.f);
            Notification notificationBuild2 = this.f551a.build();
            if (this.c != null) {
                notificationBuild2.contentView = this.c;
            }
            if (this.d != null) {
                notificationBuild2.bigContentView = this.d;
            }
            if (this.h != null) {
                notificationBuild2.headsUpContentView = this.h;
            }
            if (this.g != 0) {
                if (notificationBuild2.getGroup() != null && (notificationBuild2.flags & 512) != 0 && this.g == 2) {
                    a(notificationBuild2);
                }
                if (notificationBuild2.getGroup() != null && (notificationBuild2.flags & 512) == 0 && this.g == 1) {
                    a(notificationBuild2);
                }
            }
            return notificationBuild2;
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.f551a.setExtras(this.f);
            Notification notificationBuild3 = this.f551a.build();
            if (this.c != null) {
                notificationBuild3.contentView = this.c;
            }
            if (this.d != null) {
                notificationBuild3.bigContentView = this.d;
            }
            if (this.g != 0) {
                if (notificationBuild3.getGroup() != null && (notificationBuild3.flags & 512) != 0 && this.g == 2) {
                    a(notificationBuild3);
                }
                if (notificationBuild3.getGroup() != null && (notificationBuild3.flags & 512) == 0 && this.g == 1) {
                    a(notificationBuild3);
                }
            }
            return notificationBuild3;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            SparseArray<Bundle> sparseArrayA = i.a(this.e);
            if (sparseArrayA != null) {
                this.f.putSparseParcelableArray("android.support.actionExtras", sparseArrayA);
            }
            this.f551a.setExtras(this.f);
            Notification notificationBuild4 = this.f551a.build();
            if (this.c != null) {
                notificationBuild4.contentView = this.c;
            }
            if (this.d != null) {
                notificationBuild4.bigContentView = this.d;
            }
            return notificationBuild4;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            Notification notificationBuild5 = this.f551a.build();
            Bundle bundleA = g.a(notificationBuild5);
            Bundle bundle = new Bundle(this.f);
            for (String str : this.f.keySet()) {
                if (bundleA.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            bundleA.putAll(bundle);
            SparseArray<Bundle> sparseArrayA2 = i.a(this.e);
            if (sparseArrayA2 != null) {
                g.a(notificationBuild5).putSparseParcelableArray("android.support.actionExtras", sparseArrayA2);
            }
            if (this.c != null) {
                notificationBuild5.contentView = this.c;
            }
            if (this.d != null) {
                notificationBuild5.bigContentView = this.d;
            }
            return notificationBuild5;
        }
        return this.f551a.getNotification();
    }

    private void a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }
}
