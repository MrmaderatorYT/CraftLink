package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
@TargetApi(14)
/* loaded from: classes.dex */
public final class ach extends act implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    private static final Map<Integer, String> c = new HashMap();
    private final adm d;
    private final boolean e;
    private int f;
    private int g;
    private MediaPlayer h;
    private Uri i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private adi o;
    private boolean p;
    private int q;
    private acs r;

    public ach(Context context, boolean z, boolean z2, adj adjVar, adm admVar) {
        super(context);
        this.f = 0;
        this.g = 0;
        setSurfaceTextureListener(this);
        this.d = admVar;
        this.p = z;
        this.e = z2;
        this.d.a(this);
    }

    @Override // com.google.android.gms.internal.ads.act
    public final String a() {
        String strValueOf = String.valueOf(this.p ? " spherical" : BuildConfig.FLAVOR);
        return strValueOf.length() != 0 ? "MediaPlayer".concat(strValueOf) : new String("MediaPlayer");
    }

    @Override // com.google.android.gms.internal.ads.act
    public final void a(acs acsVar) {
        this.r = acsVar;
    }

    @Override // com.google.android.gms.internal.ads.act
    public final void setVideoPath(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        Uri uri = Uri.parse(str);
        bod bodVarA = bod.a(uri);
        if (bodVarA != null) {
            uri = Uri.parse(bodVarA.f2896a);
        }
        this.i = uri;
        this.q = 0;
        f();
        requestLayout();
        invalidate();
    }

    @Override // com.google.android.gms.internal.ads.act
    public final void b() throws IllegalStateException {
        xe.a("AdMediaPlayerView stop");
        if (this.h != null) {
            this.h.stop();
            this.h.release();
            this.h = null;
            g(0);
            this.g = 0;
        }
        this.d.b();
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdMediaPlayerView size changed: ");
        sb.append(i);
        sb.append(" x ");
        sb.append(i2);
        xe.a(sb.toString());
        this.j = mediaPlayer.getVideoWidth();
        this.k = mediaPlayer.getVideoHeight();
        if (this.j == 0 || this.k == 0) {
            return;
        }
        requestLayout();
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
        xe.a("AdMediaPlayerView prepared");
        g(2);
        this.d.a();
        xn.f3583a.post(new acj(this));
        this.j = mediaPlayer.getVideoWidth();
        this.k = mediaPlayer.getVideoHeight();
        if (this.q != 0) {
            a(this.q);
        }
        g();
        int i = this.j;
        int i2 = this.k;
        StringBuilder sb = new StringBuilder(62);
        sb.append("AdMediaPlayerView stream dimensions: ");
        sb.append(i);
        sb.append(" x ");
        sb.append(i2);
        xe.d(sb.toString());
        if (this.g == 3) {
            c();
        }
        e();
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        xe.a("AdMediaPlayerView completion");
        g(5);
        this.g = 5;
        xn.f3583a.post(new acl(this));
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = c.get(Integer.valueOf(i));
        String str2 = c.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer info: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        xe.a(sb.toString());
        return true;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str = c.get(Integer.valueOf(i));
        String str2 = c.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 38 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer error: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        xe.e(sb.toString());
        g(-1);
        this.g = -1;
        xn.f3583a.post(new acm(this, str, str2));
        return true;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.l = i;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        xe.a("AdMediaPlayerView surface created");
        f();
        xn.f3583a.post(new acn(this));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        xe.a("AdMediaPlayerView surface changed");
        boolean z = false;
        boolean z2 = this.g == 3;
        if (this.j == i && this.k == i2) {
            z = true;
        }
        if (this.h != null && z2 && z) {
            if (this.q != 0) {
                a(this.q);
            }
            c();
        }
        if (this.o != null) {
            this.o.a(i, i2);
        }
        xn.f3583a.post(new aco(this, i, i2));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        xe.a("AdMediaPlayerView surface destroyed");
        if (this.h != null && this.q == 0) {
            this.q = this.h.getCurrentPosition();
        }
        if (this.o != null) {
            this.o.b();
        }
        xn.f3583a.post(new acp(this));
        a(true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.d.b(this);
        this.f1844a.a(surfaceTexture, this.r);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(final int i) {
        StringBuilder sb = new StringBuilder(58);
        sb.append("AdMediaPlayerView window visibility changed to ");
        sb.append(i);
        xe.a(sb.toString());
        xn.f3583a.post(new Runnable(this, i) { // from class: com.google.android.gms.internal.ads.aci

            /* renamed from: a, reason: collision with root package name */
            private final ach f1832a;

            /* renamed from: b, reason: collision with root package name */
            private final int f1833b;

            {
                this.f1832a = this;
                this.f1833b = i;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f1832a.b(this.f1833b);
            }
        });
        super.onWindowVisibilityChanged(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void onMeasure(int r6, int r7) throws java.lang.IllegalStateException {
        /*
            r5 = this;
            int r0 = r5.j
            int r0 = getDefaultSize(r0, r6)
            int r1 = r5.k
            int r1 = getDefaultSize(r1, r7)
            int r2 = r5.j
            if (r2 <= 0) goto L96
            int r2 = r5.k
            if (r2 <= 0) goto L96
            com.google.android.gms.internal.ads.adi r2 = r5.o
            if (r2 != 0) goto L96
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L55
            if (r1 != r2) goto L55
            int r0 = r5.j
            int r0 = r0 * r7
            int r1 = r5.k
            int r1 = r1 * r6
            if (r0 >= r1) goto L42
            int r6 = r5.j
            int r6 = r6 * r7
            int r0 = r5.k
            int r0 = r6 / r0
            r6 = r0
            goto L98
        L42:
            int r0 = r5.j
            int r0 = r0 * r7
            int r1 = r5.k
            int r1 = r1 * r6
            if (r0 <= r1) goto L98
            int r7 = r5.k
            int r7 = r7 * r6
            int r0 = r5.j
            int r1 = r7 / r0
            goto L97
        L55:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L67
            int r0 = r5.k
            int r0 = r0 * r6
            int r2 = r5.j
            int r0 = r0 / r2
            if (r1 != r3) goto L65
            if (r0 <= r7) goto L65
            goto L98
        L65:
            r7 = r0
            goto L98
        L67:
            if (r1 != r2) goto L77
            int r1 = r5.j
            int r1 = r1 * r7
            int r2 = r5.k
            int r1 = r1 / r2
            if (r0 != r3) goto L75
            if (r1 <= r6) goto L75
            goto L98
        L75:
            r6 = r1
            goto L98
        L77:
            int r2 = r5.j
            int r4 = r5.k
            if (r1 != r3) goto L87
            if (r4 <= r7) goto L87
            int r1 = r5.j
            int r1 = r1 * r7
            int r2 = r5.k
            int r1 = r1 / r2
            goto L89
        L87:
            r1 = r2
            r7 = r4
        L89:
            if (r0 != r3) goto L75
            if (r1 <= r6) goto L75
            int r7 = r5.k
            int r7 = r7 * r6
            int r0 = r5.j
            int r1 = r7 / r0
            goto L97
        L96:
            r6 = r0
        L97:
            r7 = r1
        L98:
            r5.setMeasuredDimension(r6, r7)
            com.google.android.gms.internal.ads.adi r0 = r5.o
            if (r0 == 0) goto La4
            com.google.android.gms.internal.ads.adi r0 = r5.o
            r0.a(r6, r7)
        La4:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 16
            if (r0 != r1) goto Lc1
            int r0 = r5.m
            if (r0 <= 0) goto Lb2
            int r0 = r5.m
            if (r0 != r6) goto Lba
        Lb2:
            int r0 = r5.n
            if (r0 <= 0) goto Lbd
            int r0 = r5.n
            if (r0 == r7) goto Lbd
        Lba:
            r5.g()
        Lbd:
            r5.m = r6
            r5.n = r7
        Lc1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ach.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public final String toString() {
        String name = getClass().getName();
        String hexString = Integer.toHexString(hashCode());
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 1 + String.valueOf(hexString).length());
        sb.append(name);
        sb.append("@");
        sb.append(hexString);
        return sb.toString();
    }

    private final void f() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        xe.a("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.i == null || surfaceTexture == null) {
            return;
        }
        a(false);
        try {
            com.google.android.gms.ads.internal.ax.w();
            this.h = new MediaPlayer();
            this.h.setOnBufferingUpdateListener(this);
            this.h.setOnCompletionListener(this);
            this.h.setOnErrorListener(this);
            this.h.setOnInfoListener(this);
            this.h.setOnPreparedListener(this);
            this.h.setOnVideoSizeChangedListener(this);
            this.l = 0;
            if (this.p) {
                this.o = new adi(getContext());
                this.o.a(surfaceTexture, getWidth(), getHeight());
                this.o.start();
                SurfaceTexture surfaceTextureC = this.o.c();
                if (surfaceTextureC != null) {
                    surfaceTexture = surfaceTextureC;
                } else {
                    this.o.b();
                    this.o = null;
                }
            }
            this.h.setDataSource(getContext(), this.i);
            com.google.android.gms.ads.internal.ax.x();
            this.h.setSurface(new Surface(surfaceTexture));
            this.h.setAudioStreamType(3);
            this.h.setScreenOnWhilePlaying(true);
            this.h.prepareAsync();
            g(1);
        } catch (IOException | IllegalArgumentException | IllegalStateException e) {
            String strValueOf = String.valueOf(this.i);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 36);
            sb.append("Failed to initialize MediaPlayer at ");
            sb.append(strValueOf);
            xe.c(sb.toString(), e);
            onError(this.h, 1, 0);
        }
    }

    private final void g() throws IllegalStateException {
        if (this.e && h() && this.h.getCurrentPosition() > 0 && this.g != 3) {
            xe.a("AdMediaPlayerView nudging MediaPlayer");
            a(0.0f);
            this.h.start();
            int currentPosition = this.h.getCurrentPosition();
            long jA = com.google.android.gms.ads.internal.ax.l().a();
            while (h() && this.h.getCurrentPosition() == currentPosition && com.google.android.gms.ads.internal.ax.l().a() - jA <= 250) {
            }
            this.h.pause();
            e();
        }
    }

    private final void a(boolean z) {
        xe.a("AdMediaPlayerView release");
        if (this.o != null) {
            this.o.b();
            this.o = null;
        }
        if (this.h != null) {
            this.h.reset();
            this.h.release();
            this.h = null;
            g(0);
            if (z) {
                this.g = 0;
                this.g = 0;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.act
    public final void c() throws IllegalStateException {
        xe.a("AdMediaPlayerView play");
        if (h()) {
            this.h.start();
            g(3);
            this.f1844a.a();
            xn.f3583a.post(new acq(this));
        }
        this.g = 3;
    }

    @Override // com.google.android.gms.internal.ads.act
    public final void d() throws IllegalStateException {
        xe.a("AdMediaPlayerView pause");
        if (h() && this.h.isPlaying()) {
            this.h.pause();
            g(4);
            xn.f3583a.post(new acr(this));
        }
        this.g = 4;
    }

    @Override // com.google.android.gms.internal.ads.act
    public final int getDuration() {
        if (h()) {
            return this.h.getDuration();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.act
    public final int getCurrentPosition() {
        if (h()) {
            return this.h.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.act
    public final void a(int i) throws IllegalStateException {
        StringBuilder sb = new StringBuilder(34);
        sb.append("AdMediaPlayerView seek ");
        sb.append(i);
        xe.a(sb.toString());
        if (h()) {
            this.h.seekTo(i);
            this.q = 0;
        } else {
            this.q = i;
        }
    }

    private final boolean h() {
        return (this.h == null || this.f == -1 || this.f == 0 || this.f == 1) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.act
    public final void a(float f, float f2) {
        if (this.o != null) {
            this.o.a(f, f2);
        }
    }

    @Override // com.google.android.gms.internal.ads.act
    public final int getVideoWidth() {
        if (this.h != null) {
            return this.h.getVideoWidth();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.act
    public final int getVideoHeight() {
        if (this.h != null) {
            return this.h.getVideoHeight();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.act, com.google.android.gms.internal.ads.adp
    public final void e() {
        a(this.f1845b.a());
    }

    private final void a(float f) {
        if (this.h != null) {
            try {
                this.h.setVolume(f, f);
            } catch (IllegalStateException unused) {
            }
        } else {
            xe.e("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        }
    }

    private final void g(int i) {
        if (i == 3) {
            this.d.c();
            this.f1845b.b();
        } else if (this.f == 3) {
            this.d.d();
            this.f1845b.c();
        }
        this.f = i;
    }

    final /* synthetic */ void b(int i) {
        if (this.r != null) {
            this.r.onWindowVisibilityChanged(i);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            c.put(-1004, "MEDIA_ERROR_IO");
            c.put(-1007, "MEDIA_ERROR_MALFORMED");
            c.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
            c.put(-110, "MEDIA_ERROR_TIMED_OUT");
            c.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        }
        c.put(100, "MEDIA_ERROR_SERVER_DIED");
        c.put(1, "MEDIA_ERROR_UNKNOWN");
        c.put(1, "MEDIA_INFO_UNKNOWN");
        c.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        c.put(701, "MEDIA_INFO_BUFFERING_START");
        c.put(702, "MEDIA_INFO_BUFFERING_END");
        c.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        c.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        c.put(802, "MEDIA_INFO_METADATA_UPDATE");
        if (Build.VERSION.SDK_INT >= 19) {
            c.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
            c.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
        }
    }
}
