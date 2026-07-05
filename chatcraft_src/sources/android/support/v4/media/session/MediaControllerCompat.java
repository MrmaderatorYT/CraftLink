package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.a;
import android.support.v4.media.session.b;
import android.support.v4.media.session.c;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class MediaControllerCompat {

    public static abstract class a implements IBinder.DeathRecipient {

        /* renamed from: a, reason: collision with root package name */
        final Object f48a;

        /* renamed from: b, reason: collision with root package name */
        HandlerC0012a f49b;
        android.support.v4.media.session.a c;

        public void a() {
        }

        public void a(int i) {
        }

        public void a(Bundle bundle) {
        }

        public void a(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void a(b bVar) {
        }

        public void a(PlaybackStateCompat playbackStateCompat) {
        }

        public void a(CharSequence charSequence) {
        }

        public void a(String str, Bundle bundle) {
        }

        public void a(List<MediaSessionCompat.QueueItem> list) {
        }

        public void a(boolean z) {
        }

        public void b() {
        }

        public void b(int i) {
        }

        public a() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.f48a = android.support.v4.media.session.c.a(new b(this));
                return;
            }
            c cVar = new c(this);
            this.c = cVar;
            this.f48a = cVar;
        }

        void a(int i, Object obj, Bundle bundle) {
            if (this.f49b != null) {
                Message messageObtainMessage = this.f49b.obtainMessage(i, obj);
                messageObtainMessage.setData(bundle);
                messageObtainMessage.sendToTarget();
            }
        }

        private static class b implements c.a {

            /* renamed from: a, reason: collision with root package name */
            private final WeakReference<a> f52a;

            b(a aVar) {
                this.f52a = new WeakReference<>(aVar);
            }

            @Override // android.support.v4.media.session.c.a
            public void a() {
                a aVar = this.f52a.get();
                if (aVar != null) {
                    aVar.b();
                }
            }

            @Override // android.support.v4.media.session.c.a
            public void a(String str, Bundle bundle) {
                a aVar = this.f52a.get();
                if (aVar != null) {
                    if (aVar.c == null || Build.VERSION.SDK_INT >= 23) {
                        aVar.a(str, bundle);
                    }
                }
            }

            @Override // android.support.v4.media.session.c.a
            public void a(Object obj) {
                a aVar = this.f52a.get();
                if (aVar == null || aVar.c != null) {
                    return;
                }
                aVar.a(PlaybackStateCompat.a(obj));
            }

            @Override // android.support.v4.media.session.c.a
            public void b(Object obj) {
                a aVar = this.f52a.get();
                if (aVar != null) {
                    aVar.a(MediaMetadataCompat.a(obj));
                }
            }

            @Override // android.support.v4.media.session.c.a
            public void a(List<?> list) {
                a aVar = this.f52a.get();
                if (aVar != null) {
                    aVar.a(MediaSessionCompat.QueueItem.a(list));
                }
            }

            @Override // android.support.v4.media.session.c.a
            public void a(CharSequence charSequence) {
                a aVar = this.f52a.get();
                if (aVar != null) {
                    aVar.a(charSequence);
                }
            }

            @Override // android.support.v4.media.session.c.a
            public void a(Bundle bundle) {
                a aVar = this.f52a.get();
                if (aVar != null) {
                    aVar.a(bundle);
                }
            }

            @Override // android.support.v4.media.session.c.a
            public void a(int i, int i2, int i3, int i4, int i5) {
                a aVar = this.f52a.get();
                if (aVar != null) {
                    aVar.a(new b(i, i2, i3, i4, i5));
                }
            }
        }

        private static class c extends a.AbstractBinderC0013a {

            /* renamed from: a, reason: collision with root package name */
            private final WeakReference<a> f53a;

            @Override // android.support.v4.media.session.a
            public void a(boolean z) {
            }

            c(a aVar) {
                this.f53a = new WeakReference<>(aVar);
            }

            @Override // android.support.v4.media.session.a
            public void a(String str, Bundle bundle) {
                a aVar = this.f53a.get();
                if (aVar != null) {
                    aVar.a(1, str, bundle);
                }
            }

            public void a() {
                a aVar = this.f53a.get();
                if (aVar != null) {
                    aVar.a(8, null, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void a(PlaybackStateCompat playbackStateCompat) {
                a aVar = this.f53a.get();
                if (aVar != null) {
                    aVar.a(2, playbackStateCompat, null);
                }
            }

            public void a(MediaMetadataCompat mediaMetadataCompat) {
                a aVar = this.f53a.get();
                if (aVar != null) {
                    aVar.a(3, mediaMetadataCompat, null);
                }
            }

            public void a(List<MediaSessionCompat.QueueItem> list) {
                a aVar = this.f53a.get();
                if (aVar != null) {
                    aVar.a(5, list, null);
                }
            }

            public void a(CharSequence charSequence) {
                a aVar = this.f53a.get();
                if (aVar != null) {
                    aVar.a(6, charSequence, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void b(boolean z) {
                a aVar = this.f53a.get();
                if (aVar != null) {
                    aVar.a(11, Boolean.valueOf(z), null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void a(int i) {
                a aVar = this.f53a.get();
                if (aVar != null) {
                    aVar.a(9, Integer.valueOf(i), null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void b(int i) {
                a aVar = this.f53a.get();
                if (aVar != null) {
                    aVar.a(12, Integer.valueOf(i), null);
                }
            }

            public void a(Bundle bundle) {
                a aVar = this.f53a.get();
                if (aVar != null) {
                    aVar.a(7, bundle, null);
                }
            }

            public void a(ParcelableVolumeInfo parcelableVolumeInfo) {
                a aVar = this.f53a.get();
                if (aVar != null) {
                    aVar.a(4, parcelableVolumeInfo != null ? new b(parcelableVolumeInfo.f61a, parcelableVolumeInfo.f62b, parcelableVolumeInfo.c, parcelableVolumeInfo.d, parcelableVolumeInfo.e) : null, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void b() {
                a aVar = this.f53a.get();
                if (aVar != null) {
                    aVar.a(13, null, null);
                }
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$a, reason: collision with other inner class name */
        private class HandlerC0012a extends Handler {

            /* renamed from: a, reason: collision with root package name */
            boolean f50a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f51b;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (this.f50a) {
                    switch (message.what) {
                        case 1:
                            Bundle data = message.getData();
                            MediaSessionCompat.a(data);
                            this.f51b.a((String) message.obj, data);
                            break;
                        case 2:
                            this.f51b.a((PlaybackStateCompat) message.obj);
                            break;
                        case 3:
                            this.f51b.a((MediaMetadataCompat) message.obj);
                            break;
                        case 4:
                            this.f51b.a((b) message.obj);
                            break;
                        case 5:
                            this.f51b.a((List<MediaSessionCompat.QueueItem>) message.obj);
                            break;
                        case 6:
                            this.f51b.a((CharSequence) message.obj);
                            break;
                        case 7:
                            Bundle bundle = (Bundle) message.obj;
                            MediaSessionCompat.a(bundle);
                            this.f51b.a(bundle);
                            break;
                        case 8:
                            this.f51b.b();
                            break;
                        case 9:
                            this.f51b.a(((Integer) message.obj).intValue());
                            break;
                        case 11:
                            this.f51b.a(((Boolean) message.obj).booleanValue());
                            break;
                        case 12:
                            this.f51b.b(((Integer) message.obj).intValue());
                            break;
                        case 13:
                            this.f51b.a();
                            break;
                    }
                }
            }
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f54a;

        /* renamed from: b, reason: collision with root package name */
        private final int f55b;
        private final int c;
        private final int d;
        private final int e;

        b(int i, int i2, int i3, int i4, int i5) {
            this.f54a = i;
            this.f55b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
        }
    }

    static class MediaControllerImplApi21 {

        /* renamed from: a, reason: collision with root package name */
        final Object f45a;

        /* renamed from: b, reason: collision with root package name */
        final MediaSessionCompat.Token f46b;
        private final List<a> c;
        private HashMap<a, a> d;

        void a() {
            if (this.f46b.a() == null) {
                return;
            }
            for (a aVar : this.c) {
                a aVar2 = new a(aVar);
                this.d.put(aVar, aVar2);
                aVar.c = aVar2;
                try {
                    this.f46b.a().a(aVar2);
                    aVar.a(13, null, null);
                } catch (RemoteException e) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
                }
            }
            this.c.clear();
        }

        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {

            /* renamed from: a, reason: collision with root package name */
            private WeakReference<MediaControllerImplApi21> f47a;

            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = this.f47a.get();
                if (mediaControllerImplApi21 == null || bundle == null) {
                    return;
                }
                synchronized (mediaControllerImplApi21.f45a) {
                    mediaControllerImplApi21.f46b.a(b.a.a(androidx.core.app.c.a(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                    mediaControllerImplApi21.f46b.a(bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));
                    mediaControllerImplApi21.a();
                }
            }
        }

        private static class a extends a.c {
            a(a aVar) {
                super(aVar);
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void a() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void a(MediaMetadataCompat mediaMetadataCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void a(List<MediaSessionCompat.QueueItem> list) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void a(CharSequence charSequence) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void a(Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void a(ParcelableVolumeInfo parcelableVolumeInfo) {
                throw new AssertionError();
            }
        }
    }
}
