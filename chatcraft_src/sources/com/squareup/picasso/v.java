package com.squareup.picasso;

import android.net.NetworkInfo;
import com.squareup.picasso.ad;
import com.squareup.picasso.t;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: PicassoExecutorService.java */
/* loaded from: classes.dex */
class v extends ThreadPoolExecutor {
    v() {
        super(3, 3, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ad.b());
    }

    void a(NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
            a(3);
            return;
        }
        int type = networkInfo.getType();
        if (type != 6 && type != 9) {
            switch (type) {
                case 0:
                    int subtype = networkInfo.getSubtype();
                    switch (subtype) {
                        case 1:
                        case 2:
                            a(1);
                            break;
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            break;
                        default:
                            switch (subtype) {
                                case 12:
                                    break;
                                case 13:
                                case 14:
                                case 15:
                                    a(3);
                                    break;
                                default:
                                    a(3);
                                    break;
                            }
                    }
                    a(2);
                    break;
                case 1:
                    break;
                default:
                    a(3);
                    break;
            }
        }
        a(4);
    }

    private void a(int i) {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        a aVar = new a((c) runnable);
        execute(aVar);
        return aVar;
    }

    /* compiled from: PicassoExecutorService.java */
    private static final class a extends FutureTask<c> implements Comparable<a> {

        /* renamed from: a, reason: collision with root package name */
        private final c f4166a;

        a(c cVar) {
            super(cVar, null);
            this.f4166a = cVar;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            t.e eVarN = this.f4166a.n();
            t.e eVarN2 = aVar.f4166a.n();
            return eVarN == eVarN2 ? this.f4166a.f4113a - aVar.f4166a.f4113a : eVarN2.ordinal() - eVarN.ordinal();
        }
    }
}
