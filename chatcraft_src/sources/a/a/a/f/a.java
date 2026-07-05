package a.a.a.f;

import a.a.a.a.b;
import a.a.a.a.c;
import a.a.a.b;
import a.a.a.c.b;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* compiled from: MaterialIntroView.java */
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private String A;
    private boolean B;
    private c C;
    private boolean D;
    private boolean E;

    /* renamed from: a, reason: collision with root package name */
    private int f15a;

    /* renamed from: b, reason: collision with root package name */
    private long f16b;
    private boolean c;
    private boolean d;
    private long e;
    private a.a.a.c.a f;
    private b g;
    private a.a.a.c.c h;
    private a.a.a.d.a i;
    private Paint j;
    private Handler k;
    private Bitmap l;
    private Canvas m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private View r;
    private TextView s;
    private int t;
    private boolean u;
    private View v;
    private boolean w;
    private ImageView x;
    private boolean y;
    private a.a.a.b.a z;

    public a(Context context) {
        super(context);
        this.E = false;
        a(context);
    }

    private void a(Context context) {
        setWillNotDraw(false);
        setVisibility(4);
        this.f15a = a.a.a.e.a.f13a;
        this.f16b = a.a.a.e.a.f14b;
        this.e = a.a.a.e.a.c;
        this.n = a.a.a.e.a.d;
        this.t = a.a.a.e.a.e;
        this.g = b.ALL;
        this.h = a.a.a.c.c.CENTER;
        this.c = false;
        this.d = true;
        this.q = false;
        this.B = false;
        this.u = false;
        this.w = false;
        this.D = false;
        this.y = true;
        this.k = new Handler();
        this.z = new a.a.a.b.a(context);
        this.j = new Paint();
        this.j.setColor(-1);
        this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.j.setFlags(1);
        View viewInflate = LayoutInflater.from(getContext()).inflate(b.C0001b.material_intro_card, (ViewGroup) null);
        this.r = viewInflate.findViewById(b.a.info_layout);
        this.s = (TextView) viewInflate.findViewById(b.a.textview_info);
        this.s.setTextColor(this.t);
        this.x = (ImageView) viewInflate.findViewById(b.a.imageview_icon);
        this.v = LayoutInflater.from(getContext()).inflate(b.C0001b.dotview, (ViewGroup) null);
        this.v.measure(0, 0);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: a.a.a.f.a.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                a.this.f.a();
                if (a.this.f == null || a.this.f.c().y == 0 || a.this.B) {
                    return;
                }
                if (a.this.u) {
                    a.this.c();
                }
                if (a.this.w) {
                    a.this.d();
                }
                a.a(a.this, this);
            }
        });
    }

    @TargetApi(16)
    public static void a(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (Build.VERSION.SDK_INT < 16) {
            view.getViewTreeObserver().removeGlobalOnLayoutListener(onGlobalLayoutListener);
        } else {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.o = getMeasuredWidth();
        this.p = getMeasuredHeight();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.c) {
            if (this.l == null || canvas == null) {
                if (this.l != null) {
                    this.l.recycle();
                }
                this.l = Bitmap.createBitmap(this.o, this.p, Bitmap.Config.ARGB_8888);
                this.m = new Canvas(this.l);
            }
            this.m.drawColor(0, PorterDuff.Mode.CLEAR);
            this.m.drawColor(this.f15a);
            this.f.a(this.m, this.j, this.n);
            canvas.drawBitmap(this.l, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = Math.pow((double) (motionEvent.getX() - ((float) this.f.c().x)), 2.0d) + Math.pow((double) (motionEvent.getY() - ((float) this.f.c().y)), 2.0d) <= Math.pow((double) this.f.b(), 2.0d);
        switch (motionEvent.getAction()) {
            case 0:
                if (z && this.D) {
                    this.i.c().setPressed(true);
                    this.i.c().invalidate();
                }
                return true;
            case 1:
                if (z || this.q) {
                    a();
                }
                if (z && this.D) {
                    this.i.c().performClick();
                    this.i.c().setPressed(true);
                    this.i.c().invalidate();
                    this.i.c().setPressed(false);
                    this.i.c().invalidate();
                }
                return true;
            default:
                return super.onTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity) {
        if (this.z.a(this.A)) {
            this.E = true;
            return;
        }
        ((ViewGroup) activity.getWindow().getDecorView()).addView(this);
        setReady(true);
        this.k.postDelayed(new Runnable() { // from class: a.a.a.f.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.d) {
                    a.a.a.a.a.a(a.this, a.this.e, new b.InterfaceC0000b() { // from class: a.a.a.f.a.2.1
                        @Override // a.a.a.a.b.InterfaceC0000b
                        public void a() {
                            a.this.setVisibility(0);
                        }
                    });
                } else {
                    a.this.setVisibility(0);
                }
            }
        }, this.f16b);
    }

    private void a() {
        this.z.b(this.A);
        a.a.a.a.a.a(this, this.e, new b.a() { // from class: a.a.a.f.a.3
            @Override // a.a.a.a.b.a
            public void a() {
                a.this.setVisibility(8);
                a.this.b();
                a.this.E = true;
                if (a.this.C != null) {
                    a.this.C.a(a.this.A);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.k.post(new Runnable() { // from class: a.a.a.f.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.B = true;
                if (a.this.r.getParent() != null) {
                    ((ViewGroup) a.this.r.getParent()).removeView(a.this.r);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                if (a.this.f.c().y < a.this.p / 2) {
                    ((RelativeLayout) a.this.r).setGravity(48);
                    layoutParams.setMargins(0, a.this.f.c().y + a.this.f.b(), 0, 0);
                } else {
                    ((RelativeLayout) a.this.r).setGravity(80);
                    layoutParams.setMargins(0, 0, 0, (a.this.p - (a.this.f.c().y + a.this.f.b())) + (a.this.f.b() * 2));
                }
                a.this.r.setLayoutParams(layoutParams);
                a.this.r.postInvalidate();
                a.this.addView(a.this.r);
                if (!a.this.y) {
                    a.this.x.setVisibility(8);
                }
                a.this.r.setVisibility(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.k.post(new Runnable() { // from class: a.a.a.f.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.v.getParent() != null) {
                    ((ViewGroup) a.this.v.getParent()).removeView(a.this.v);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.height = a.a.a.e.b.a(a.a.a.e.a.f);
                layoutParams.width = a.a.a.e.b.a(a.a.a.e.a.f);
                layoutParams.setMargins(a.this.f.c().x - (layoutParams.width / 2), a.this.f.c().y - (layoutParams.height / 2), 0, 0);
                a.this.v.setLayoutParams(layoutParams);
                a.this.v.postInvalidate();
                a.this.addView(a.this.v);
                a.this.v.setVisibility(0);
                a.a.a.a.a.a(a.this.v);
            }
        });
    }

    private void setMaskColor(int i) {
        this.f15a = i;
    }

    private void setDelay(int i) {
        this.f16b = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.d = z;
    }

    private void setReady(boolean z) {
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTarget(a.a.a.d.a aVar) {
        this.i = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFocusType(a.a.a.c.b bVar) {
        this.g = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCircle(a.a.a.c.a aVar) {
        this.f = aVar;
    }

    private void setPadding(int i) {
        this.n = i;
    }

    private void setDismissOnTouch(boolean z) {
        this.q = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFocusGravity(a.a.a.c.c cVar) {
        this.h = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColorTextViewInfo(int i) {
        this.t = i;
        this.s.setTextColor(this.t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextViewInfo(String str) {
        this.s.setText(str);
    }

    private void setTextViewInfoSize(int i) {
        this.s.setTextSize(2, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        this.u = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        this.y = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        this.w = z;
    }

    public void setConfiguration(a.a.a.a aVar) {
        if (aVar != null) {
            this.f15a = aVar.a();
            this.f16b = aVar.b();
            this.d = aVar.c();
            this.t = aVar.g();
            this.w = aVar.h();
            this.q = aVar.f();
            this.g = aVar.d();
            this.h = aVar.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUsageId(String str) {
        this.A = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListener(c cVar) {
        this.C = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPerformClick(boolean z) {
        this.D = z;
    }

    /* compiled from: MaterialIntroView.java */
    /* renamed from: a.a.a.f.a$a, reason: collision with other inner class name */
    public static class C0002a {

        /* renamed from: a, reason: collision with root package name */
        private a f23a;

        /* renamed from: b, reason: collision with root package name */
        private Activity f24b;
        private a.a.a.c.b c = a.a.a.c.b.MINIMUM;

        public C0002a(Activity activity) {
            this.f24b = activity;
            this.f23a = new a(activity);
        }

        public C0002a a(boolean z) {
            this.f23a.a(z);
            return this;
        }

        public C0002a a(a.a.a.c.b bVar) {
            this.f23a.setFocusType(bVar);
            return this;
        }

        public C0002a a(a.a.a.c.c cVar) {
            this.f23a.setFocusGravity(cVar);
            return this;
        }

        public C0002a a(View view) {
            this.f23a.setTarget(new a.a.a.d.b(view));
            return this;
        }

        public C0002a a(int i) {
            this.f23a.setColorTextViewInfo(i);
            return this;
        }

        public C0002a a(String str) {
            this.f23a.b(true);
            this.f23a.setTextViewInfo(str);
            return this;
        }

        public C0002a b(String str) {
            this.f23a.setUsageId(str);
            return this;
        }

        public C0002a b(boolean z) {
            this.f23a.d(z);
            return this;
        }

        public C0002a c(boolean z) {
            this.f23a.c(z);
            return this;
        }

        public C0002a a(c cVar) {
            this.f23a.setListener(cVar);
            return this;
        }

        public static boolean a(Context context, String str) {
            return !new a.a.a.b.a(context).a(str);
        }

        public C0002a d(boolean z) {
            this.f23a.setPerformClick(z);
            return this;
        }

        public a a() {
            this.f23a.setCircle(new a.a.a.c.a(this.f23a.i, this.f23a.g, this.f23a.h, this.f23a.n));
            return this.f23a;
        }

        public a b() {
            a().a(this.f24b);
            return this.f23a;
        }
    }
}
