package com.heinrichreimersoftware.singleinputform;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewAnimator;
import android.widget.ViewSwitcher;
import androidx.appcompat.app.c;
import androidx.cardview.widget.CardView;
import com.heinrichreimersoftware.singleinputform.a;
import com.heinrichreimersoftware.singleinputform.a.d;
import com.heinrichreimersoftware.singleinputform.a.e;
import com.nineoldandroids.a.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: SingleInputFormActivity.java */
/* loaded from: classes.dex */
public abstract class b extends c {
    private Drawable B;
    private Drawable C;
    private boolean q;
    private ScrollView r;
    private TextSwitcher s;
    private TextSwitcher t;
    private TextSwitcher u;
    private CardView v;
    private ViewAnimator w;
    private ImageButton x;
    private ProgressBar y;
    private TextView z;
    private com.nineoldandroids.util.c<ProgressBar, Integer> l = new com.nineoldandroids.util.c<ProgressBar, Integer>(Integer.class, "PB_PROGRESS_PROPERTY") { // from class: com.heinrichreimersoftware.singleinputform.b.1
        @Override // com.nineoldandroids.util.c
        public void a(ProgressBar progressBar, Integer num) {
            progressBar.setProgress(num.intValue());
            b.this.A();
        }

        @Override // com.nineoldandroids.util.c
        public Integer a(ProgressBar progressBar) {
            return Integer.valueOf(progressBar.getProgress());
        }
    };
    private List<d> m = new ArrayList();
    private HashMap<d, com.heinrichreimersoftware.singleinputform.a.c> n = new HashMap<>();
    private androidx.fragment.app.d o = this;
    protected Bundle j = new Bundle();
    private volatile int p = 0;
    private View.OnClickListener A = new View.OnClickListener() { // from class: com.heinrichreimersoftware.singleinputform.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.o();
        }
    };
    protected TextView.OnEditorActionListener k = new TextView.OnEditorActionListener() { // from class: com.heinrichreimersoftware.singleinputform.b.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 5) {
                if (keyEvent == null) {
                    return true;
                }
                try {
                    if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 66) {
                        return true;
                    }
                } catch (Exception unused) {
                    return true;
                }
            }
            b.this.o();
            return true;
        }
    };
    private int D = -1;
    private int E = -1;
    private int F = -1;
    private int G = -1;
    private int H = -1;

    protected abstract List<d> a(Context context);

    protected abstract void a(Bundle bundle);

    protected abstract HashMap<d, com.heinrichreimersoftware.singleinputform.a.c> b(Context context);

    static /* synthetic */ int f(b bVar) {
        int i = bVar.p;
        bVar.p = i + 1;
        return i;
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    public void onBackPressed() {
        if (this.p == 0) {
            finish();
        } else {
            n();
        }
    }

    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.core.app.d, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.e.activity_single_input_form);
        q();
        this.m = a((Context) this);
        this.n = b((Context) this);
        p();
        if (bundle != null) {
            this.j = bundle.getBundle("key_data");
            this.p = bundle.getInt("key_step_index", 0);
        }
        r();
        s();
        t();
        u();
        this.x.setOnClickListener(this.A);
        this.t.setText(BuildConfig.FLAVOR);
        d dVarK = k();
        if (dVarK != null && (dVarK instanceof e)) {
            try {
                ((e) dVarK).e().setOnEditorActionListener(this.k);
            } catch (Exception unused) {
            }
        }
        v();
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            this.j = bundle.getBundle("key_data");
            this.p = bundle.getInt("key_step_index", 0);
        }
    }

    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.core.app.d, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.j = k().a(this.j);
        bundle.putBundle("key_data", this.j);
        bundle.putInt("key_step_index", this.p);
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    protected void onPause() {
        x();
        super.onPause();
    }

    private void p() {
        this.r = (ScrollView) findViewById(a.d.container_scroll_view);
        this.s = (TextSwitcher) findViewById(a.d.title_switcher);
        this.t = (TextSwitcher) findViewById(a.d.error_switcher);
        this.u = (TextSwitcher) findViewById(a.d.details_switcher);
        this.v = (CardView) findViewById(a.d.text_field);
        this.w = (ViewAnimator) findViewById(a.d.input_switcher);
        this.x = (ImageButton) findViewById(a.d.next_button);
        this.y = (ProgressBar) findViewById(a.d.progressbar);
        this.z = (TextView) findViewById(a.d.step_text);
    }

    protected d k() {
        return l();
    }

    protected d l() {
        int i = this.p;
        if (i >= this.m.size()) {
            return null;
        }
        d dVar = this.m.get(i);
        if (this.n.containsKey(dVar) && !this.n.get(dVar).a()) {
            this.p++;
            return l();
        }
        dVar.a(this);
        System.out.println("Returning " + i);
        x();
        return dVar;
    }

    protected d m() {
        System.out.println("They called previous step! " + this.p);
        if (this.p >= this.m.size()) {
            return null;
        }
        d dVar = this.m.get(this.p);
        if (this.n.containsKey(dVar) && !this.n.get(dVar).a()) {
            this.p--;
            if (this.p < 0) {
                finish();
                return null;
            }
            return m();
        }
        dVar.a(this);
        System.out.println("Returning " + this.p);
        return dVar;
    }

    protected d b(int i) {
        if (i >= this.m.size()) {
            return null;
        }
        d dVar = this.m.get(i);
        dVar.a(this);
        return dVar;
    }

    private void q() {
        this.B = getResources().getDrawable(a.c.ic_action_next_item);
        this.C = getResources().getDrawable(a.c.ic_action_accept);
        TypedArray typedArrayObtainStyledAttributes = obtainStyledAttributes(new int[]{a.b.colorPrimary, a.b.colorPrimaryDark, R.attr.textColorPrimary, R.attr.textColorSecondary, a.b.sifNextIcon, a.b.sifFinishIcon});
        this.D = typedArrayObtainStyledAttributes.getColor(0, 0);
        this.E = typedArrayObtainStyledAttributes.getColor(1, 0);
        int color = typedArrayObtainStyledAttributes.getColor(2, 0);
        this.H = color;
        this.F = color;
        this.G = typedArrayObtainStyledAttributes.getColor(3, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(4);
        if (drawable != null) {
            this.B = drawable;
        }
        Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(5);
        if (drawable2 != null) {
            this.C = drawable2;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private Animation a(int i, boolean z) throws Resources.NotFoundException {
        Interpolator accelerateInterpolator;
        if (z) {
            accelerateInterpolator = new DecelerateInterpolator(1.0f);
        } else {
            accelerateInterpolator = new AccelerateInterpolator(1.0f);
        }
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.o, i);
        animationLoadAnimation.setInterpolator(accelerateInterpolator);
        return animationLoadAnimation;
    }

    private void r() {
        this.s.setInAnimation(a(a.C0089a.slide_in_to_bottom, true));
        this.s.setOutAnimation(a(a.C0089a.slide_out_to_top, false));
        this.s.setFactory(new ViewSwitcher.ViewFactory() { // from class: com.heinrichreimersoftware.singleinputform.b.4
            @Override // android.widget.ViewSwitcher.ViewFactory
            public View makeView() {
                TextView textView = (TextView) b.this.o.getLayoutInflater().inflate(a.e.view_title, (ViewGroup) null);
                if (textView != null) {
                    textView.setTextColor(b.this.F);
                }
                return textView;
            }
        });
        this.s.setText(BuildConfig.FLAVOR);
    }

    private void s() {
        this.w.setInAnimation(a(a.C0089a.alpha_in, true));
        this.w.setOutAnimation(a(a.C0089a.alpha_out, false));
        this.w.removeAllViews();
        System.out.println("Step size = " + w());
        for (int i = 0; i < w(); i++) {
            System.out.println("Problem with " + i + "?");
            this.w.addView(b(i).e());
        }
    }

    private void t() {
        this.t.setInAnimation(a(R.anim.slide_in_left, true));
        this.t.setOutAnimation(a(R.anim.slide_out_right, false));
        this.t.setFactory(new ViewSwitcher.ViewFactory() { // from class: com.heinrichreimersoftware.singleinputform.b.5
            @Override // android.widget.ViewSwitcher.ViewFactory
            public View makeView() {
                TextView textView = (TextView) b.this.o.getLayoutInflater().inflate(a.e.view_error, (ViewGroup) null);
                if (textView != null && b.this.H != -1) {
                    textView.setTextColor(b.this.H);
                }
                return textView;
            }
        });
        this.t.setText(BuildConfig.FLAVOR);
    }

    private void u() {
        this.u.setInAnimation(a(a.C0089a.alpha_in, true));
        this.u.setOutAnimation(a(a.C0089a.alpha_out, false));
        this.u.setFactory(new ViewSwitcher.ViewFactory() { // from class: com.heinrichreimersoftware.singleinputform.b.6
            @Override // android.widget.ViewSwitcher.ViewFactory
            public View makeView() {
                TextView textView = (TextView) b.this.o.getLayoutInflater().inflate(a.e.view_details, (ViewGroup) null);
                if (textView != null && b.this.G != -1) {
                    textView.setTextColor(b.this.G);
                }
                return textView;
            }
        });
        this.u.setText(BuildConfig.FLAVOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.p >= w()) {
            x();
            a(this.j);
            this.p--;
            finish();
            return;
        }
        y();
        this.r.smoothScrollTo(0, 0);
    }

    private int w() {
        return this.m.size();
    }

    private void x() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.o.getSystemService("input_method");
        View currentFocus = getCurrentFocus();
        if (currentFocus == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }

    private void y() {
        d dVarK = k();
        if (dVarK == null && this.p >= w()) {
            x();
            a(this.j);
            this.p--;
            finish();
            return;
        }
        if (this.p + 1 >= w()) {
            this.x.setImageDrawable(this.C);
            dVarK.a(true);
        } else {
            x();
            this.x.setImageDrawable(this.B);
            dVarK.a(false);
        }
        dVarK.b(this.j);
        z();
        this.w.setDisplayedChild(this.p);
        this.t.setText(BuildConfig.FLAVOR);
        this.u.setText(dVarK.j());
        this.s.setText(dVarK.h());
        this.z.setText(getString(a.f.page_number, new Object[]{Integer.valueOf(this.p + 1), Integer.valueOf(w())}));
        this.z.setTextColor(this.G);
        if (dVarK instanceof e) {
            System.out.println(dVarK.e().requestFocus());
        }
        B();
    }

    private void z() {
        if (this.D != -1) {
            this.v.setCardBackgroundColor(this.D);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        Drawable progressDrawable;
        if (this.E == -1 || (progressDrawable = this.y.getProgressDrawable()) == null) {
            return;
        }
        progressDrawable.setColorFilter(this.E, PorterDuff.Mode.SRC_IN);
    }

    private void B() {
        this.y.setMax(w() * 100);
        g.a(this.y, this.l, this.p * 100).a();
    }

    protected void n() {
        this.j = k().a(this.j);
        this.p--;
        try {
            if (this.p > 0) {
                if (m() == null) {
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        v();
    }

    protected void o() {
        final d dVarK = k();
        a(new d.a() { // from class: com.heinrichreimersoftware.singleinputform.b.7
            @Override // com.heinrichreimersoftware.singleinputform.a.d.a
            public void a() {
                b.this.q = false;
                b.this.j = dVarK.a(b.this.j);
                b.f(b.this);
                d dVarK2 = b.this.k();
                if (dVarK2 != null && (dVarK2 instanceof e)) {
                    try {
                        ((e) dVarK2).e().setOnEditorActionListener(b.this.k);
                    } catch (Exception unused) {
                    }
                }
                b.this.v();
            }

            @Override // com.heinrichreimersoftware.singleinputform.a.d.a
            public void b() {
                if (b.this.q) {
                    return;
                }
                b.this.q = true;
                b.this.t.setText(dVarK.i());
            }

            @Override // com.heinrichreimersoftware.singleinputform.a.d.a
            public void a(String str) {
                if (b.this.q) {
                    return;
                }
                b.this.q = true;
                b.this.t.setText(str);
            }
        });
    }

    private void a(d.a aVar) {
        k().a(aVar);
    }
}
