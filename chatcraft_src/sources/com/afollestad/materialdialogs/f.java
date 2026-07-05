package com.afollestad.materialdialogs;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.a;
import com.afollestad.materialdialogs.g;
import com.afollestad.materialdialogs.internal.MDButton;
import com.afollestad.materialdialogs.internal.MDRootLayout;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* compiled from: MaterialDialog.java */
/* loaded from: classes.dex */
public class f extends com.afollestad.materialdialogs.c implements View.OnClickListener, a.b {

    /* renamed from: b, reason: collision with root package name */
    protected final a f1209b;
    protected ImageView c;
    protected TextView d;
    protected TextView e;
    EditText f;
    RecyclerView g;
    View h;
    FrameLayout i;
    ProgressBar j;
    TextView k;
    TextView l;
    TextView m;
    CheckBox n;
    MDButton o;
    MDButton p;
    MDButton q;
    i r;
    List<Integer> s;
    private final Handler t;

    /* compiled from: MaterialDialog.java */
    public interface d {
        void a(f fVar, CharSequence charSequence);
    }

    /* compiled from: MaterialDialog.java */
    public interface e {
        void a(f fVar, View view, int i, CharSequence charSequence);
    }

    /* compiled from: MaterialDialog.java */
    /* renamed from: com.afollestad.materialdialogs.f$f, reason: collision with other inner class name */
    public interface InterfaceC0061f {
        boolean a(f fVar, Integer[] numArr, CharSequence[] charSequenceArr);
    }

    /* compiled from: MaterialDialog.java */
    public interface g {
        boolean a(f fVar, View view, int i, CharSequence charSequence);
    }

    /* compiled from: MaterialDialog.java */
    public interface h {
        boolean a(f fVar, View view, int i, CharSequence charSequence);
    }

    /* compiled from: MaterialDialog.java */
    public interface j {
        void a(f fVar, com.afollestad.materialdialogs.b bVar);
    }

    @Override // com.afollestad.materialdialogs.c, android.app.Dialog
    public /* bridge */ /* synthetic */ View findViewById(int i2) {
        return super.findViewById(i2);
    }

    @Override // com.afollestad.materialdialogs.c, android.app.Dialog
    @Deprecated
    public /* bridge */ /* synthetic */ void setContentView(int i2) {
        super.setContentView(i2);
    }

    @Override // com.afollestad.materialdialogs.c, android.app.Dialog
    @Deprecated
    public /* bridge */ /* synthetic */ void setContentView(View view) {
        super.setContentView(view);
    }

    @Override // com.afollestad.materialdialogs.c, android.app.Dialog
    @Deprecated
    public /* bridge */ /* synthetic */ void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
    }

    @SuppressLint({"InflateParams"})
    protected f(a aVar) {
        super(aVar.f1216a, com.afollestad.materialdialogs.d.a(aVar));
        this.t = new Handler();
        this.f1209b = aVar;
        this.f1204a = (MDRootLayout) LayoutInflater.from(aVar.f1216a).inflate(com.afollestad.materialdialogs.d.b(aVar), (ViewGroup) null);
        com.afollestad.materialdialogs.d.a(this);
    }

    public final a b() {
        return this.f1209b;
    }

    public final void a(TextView textView, Typeface typeface) {
        if (typeface == null) {
            return;
        }
        textView.setPaintFlags(textView.getPaintFlags() | 128);
        textView.setTypeface(typeface);
    }

    final void c() {
        if (this.g == null) {
            return;
        }
        this.g.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.afollestad.materialdialogs.f.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                final int iIntValue;
                if (Build.VERSION.SDK_INT < 16) {
                    f.this.g.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    f.this.g.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                if (f.this.r == i.SINGLE || f.this.r == i.MULTI) {
                    if (f.this.r == i.SINGLE) {
                        if (f.this.f1209b.O < 0) {
                            return;
                        } else {
                            iIntValue = f.this.f1209b.O;
                        }
                    } else {
                        if (f.this.s == null || f.this.s.size() == 0) {
                            return;
                        }
                        Collections.sort(f.this.s);
                        iIntValue = f.this.s.get(0).intValue();
                    }
                    f.this.g.post(new Runnable() { // from class: com.afollestad.materialdialogs.f.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.g.requestFocus();
                            f.this.f1209b.Y.e(iIntValue);
                        }
                    });
                }
            }
        });
    }

    final void d() {
        if (this.g == null) {
            return;
        }
        if ((this.f1209b.l == null || this.f1209b.l.size() == 0) && this.f1209b.X == null) {
            return;
        }
        if (this.f1209b.Y == null) {
            this.f1209b.Y = new LinearLayoutManager(getContext());
        }
        if (this.g.getLayoutManager() == null) {
            this.g.setLayoutManager(this.f1209b.Y);
        }
        this.g.setAdapter(this.f1209b.X);
        if (this.r != null) {
            ((com.afollestad.materialdialogs.a) this.f1209b.X).a(this);
        }
    }

    @Override // com.afollestad.materialdialogs.a.b
    public boolean a(f fVar, View view, int i2, CharSequence charSequence, boolean z) {
        boolean zB = false;
        if (!view.isEnabled()) {
            return false;
        }
        if (this.r == null || this.r == i.REGULAR) {
            if (this.f1209b.R) {
                dismiss();
            }
            if (!z && this.f1209b.E != null) {
                this.f1209b.E.a(this, view, i2, this.f1209b.l.get(i2));
            }
            if (z && this.f1209b.F != null) {
                return this.f1209b.F.a(this, view, i2, this.f1209b.l.get(i2));
            }
        } else if (this.r == i.MULTI) {
            CheckBox checkBox = (CheckBox) view.findViewById(g.e.md_control);
            if (!checkBox.isEnabled()) {
                return false;
            }
            if (!this.s.contains(Integer.valueOf(i2))) {
                this.s.add(Integer.valueOf(i2));
                if (!this.f1209b.I || i()) {
                    checkBox.setChecked(true);
                } else {
                    this.s.remove(Integer.valueOf(i2));
                }
            } else {
                this.s.remove(Integer.valueOf(i2));
                if (!this.f1209b.I || i()) {
                    checkBox.setChecked(false);
                } else {
                    this.s.add(Integer.valueOf(i2));
                }
            }
        } else if (this.r == i.SINGLE) {
            RadioButton radioButton = (RadioButton) view.findViewById(g.e.md_control);
            if (!radioButton.isEnabled()) {
                return false;
            }
            int i3 = this.f1209b.O;
            if (this.f1209b.R && this.f1209b.m == null) {
                dismiss();
                this.f1209b.O = i2;
                b(view);
            } else if (this.f1209b.J) {
                this.f1209b.O = i2;
                zB = b(view);
                this.f1209b.O = i3;
            } else {
                zB = true;
            }
            if (zB) {
                this.f1209b.O = i2;
                radioButton.setChecked(true);
                this.f1209b.X.d(i3);
                this.f1209b.X.d(i2);
            }
        }
        return true;
    }

    final Drawable e() {
        if (this.f1209b.aK != 0) {
            return androidx.core.a.a.f.a(this.f1209b.f1216a.getResources(), this.f1209b.aK, null);
        }
        Drawable drawableE = com.afollestad.materialdialogs.a.a.e(this.f1209b.f1216a, g.a.md_list_selector);
        return drawableE != null ? drawableE : com.afollestad.materialdialogs.a.a.e(getContext(), g.a.md_list_selector);
    }

    Drawable a(com.afollestad.materialdialogs.b bVar, boolean z) {
        if (z) {
            if (this.f1209b.aL != 0) {
                return androidx.core.a.a.f.a(this.f1209b.f1216a.getResources(), this.f1209b.aL, null);
            }
            Drawable drawableE = com.afollestad.materialdialogs.a.a.e(this.f1209b.f1216a, g.a.md_btn_stacked_selector);
            return drawableE != null ? drawableE : com.afollestad.materialdialogs.a.a.e(getContext(), g.a.md_btn_stacked_selector);
        }
        switch (bVar) {
            case NEUTRAL:
                if (this.f1209b.aN != 0) {
                    return androidx.core.a.a.f.a(this.f1209b.f1216a.getResources(), this.f1209b.aN, null);
                }
                Drawable drawableE2 = com.afollestad.materialdialogs.a.a.e(this.f1209b.f1216a, g.a.md_btn_neutral_selector);
                if (drawableE2 != null) {
                    return drawableE2;
                }
                Drawable drawableE3 = com.afollestad.materialdialogs.a.a.e(getContext(), g.a.md_btn_neutral_selector);
                if (Build.VERSION.SDK_INT >= 21) {
                    com.afollestad.materialdialogs.a.b.a(drawableE3, this.f1209b.h);
                }
                return drawableE3;
            case NEGATIVE:
                if (this.f1209b.aO != 0) {
                    return androidx.core.a.a.f.a(this.f1209b.f1216a.getResources(), this.f1209b.aO, null);
                }
                Drawable drawableE4 = com.afollestad.materialdialogs.a.a.e(this.f1209b.f1216a, g.a.md_btn_negative_selector);
                if (drawableE4 != null) {
                    return drawableE4;
                }
                Drawable drawableE5 = com.afollestad.materialdialogs.a.a.e(getContext(), g.a.md_btn_negative_selector);
                if (Build.VERSION.SDK_INT >= 21) {
                    com.afollestad.materialdialogs.a.b.a(drawableE5, this.f1209b.h);
                }
                return drawableE5;
            default:
                if (this.f1209b.aM != 0) {
                    return androidx.core.a.a.f.a(this.f1209b.f1216a.getResources(), this.f1209b.aM, null);
                }
                Drawable drawableE6 = com.afollestad.materialdialogs.a.a.e(this.f1209b.f1216a, g.a.md_btn_positive_selector);
                if (drawableE6 != null) {
                    return drawableE6;
                }
                Drawable drawableE7 = com.afollestad.materialdialogs.a.a.e(getContext(), g.a.md_btn_positive_selector);
                if (Build.VERSION.SDK_INT >= 21) {
                    com.afollestad.materialdialogs.a.b.a(drawableE7, this.f1209b.h);
                }
                return drawableE7;
        }
    }

    private boolean b(View view) {
        if (this.f1209b.G == null) {
            return false;
        }
        CharSequence charSequence = null;
        if (this.f1209b.O >= 0 && this.f1209b.O < this.f1209b.l.size()) {
            charSequence = this.f1209b.l.get(this.f1209b.O);
        }
        return this.f1209b.G.a(this, view, this.f1209b.O, charSequence);
    }

    private boolean i() {
        if (this.f1209b.H == null) {
            return false;
        }
        Collections.sort(this.s);
        ArrayList arrayList = new ArrayList();
        for (Integer num : this.s) {
            if (num.intValue() >= 0 && num.intValue() <= this.f1209b.l.size() - 1) {
                arrayList.add(this.f1209b.l.get(num.intValue()));
            }
        }
        return this.f1209b.H.a(this, (Integer[]) this.s.toArray(new Integer[this.s.size()]), (CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.afollestad.materialdialogs.b bVar = (com.afollestad.materialdialogs.b) view.getTag();
        switch (bVar) {
            case NEUTRAL:
                if (this.f1209b.z != null) {
                    this.f1209b.z.a(this);
                    this.f1209b.z.d(this);
                }
                if (this.f1209b.C != null) {
                    this.f1209b.C.a(this, bVar);
                }
                if (this.f1209b.R) {
                    dismiss();
                    break;
                }
                break;
            case NEGATIVE:
                if (this.f1209b.z != null) {
                    this.f1209b.z.a(this);
                    this.f1209b.z.c(this);
                }
                if (this.f1209b.B != null) {
                    this.f1209b.B.a(this, bVar);
                }
                if (this.f1209b.R) {
                    cancel();
                    break;
                }
                break;
            case POSITIVE:
                if (this.f1209b.z != null) {
                    this.f1209b.z.a(this);
                    this.f1209b.z.b(this);
                }
                if (this.f1209b.A != null) {
                    this.f1209b.A.a(this, bVar);
                }
                if (!this.f1209b.J) {
                    b(view);
                }
                if (!this.f1209b.I) {
                    i();
                }
                if (this.f1209b.ao != null && this.f != null && !this.f1209b.ar) {
                    this.f1209b.ao.a(this, this.f.getText());
                }
                if (this.f1209b.R) {
                    dismiss();
                    break;
                }
                break;
        }
        if (this.f1209b.D != null) {
            this.f1209b.D.a(this, bVar);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
        } catch (WindowManager.BadTokenException unused) {
            throw new c("Bad window token, you cannot show a dialog before an Activity is created or after it's hidden.");
        }
    }

    public final MDButton a(com.afollestad.materialdialogs.b bVar) {
        switch (bVar) {
            case NEUTRAL:
                return this.p;
            case NEGATIVE:
                return this.q;
            default:
                return this.o;
        }
    }

    public final View f() {
        return this.f1204a;
    }

    public final EditText g() {
        return this.f;
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        this.d.setText(charSequence);
    }

    @Override // android.app.Dialog
    public final void setTitle(int i2) {
        setTitle(this.f1209b.f1216a.getString(i2));
    }

    @Override // com.afollestad.materialdialogs.c, android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        if (this.f != null) {
            com.afollestad.materialdialogs.a.a.a(this, this.f1209b);
            if (this.f.getText().length() > 0) {
                this.f.setSelection(this.f.getText().length());
            }
        }
        super.onShow(dialogInterface);
    }

    void h() {
        if (this.f == null) {
            return;
        }
        this.f.addTextChangedListener(new TextWatcher() { // from class: com.afollestad.materialdialogs.f.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                int length = charSequence.toString().length();
                if (!f.this.f1209b.ap) {
                    z = length == 0;
                    f.this.a(com.afollestad.materialdialogs.b.POSITIVE).setEnabled(!z);
                }
                f.this.a(length, z);
                if (f.this.f1209b.ar) {
                    f.this.f1209b.ao.a(f.this, charSequence);
                }
            }
        });
    }

    void a(int i2, boolean z) {
        if (this.m != null) {
            if (this.f1209b.at > 0) {
                this.m.setText(String.format(Locale.getDefault(), "%d/%d", Integer.valueOf(i2), Integer.valueOf(this.f1209b.at)));
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
            boolean z2 = (z && i2 == 0) || (this.f1209b.at > 0 && i2 > this.f1209b.at) || i2 < this.f1209b.as;
            int i3 = z2 ? this.f1209b.au : this.f1209b.j;
            int i4 = z2 ? this.f1209b.au : this.f1209b.t;
            if (this.f1209b.at > 0) {
                this.m.setTextColor(i3);
            }
            com.afollestad.materialdialogs.internal.c.a(this.f, i4);
            a(com.afollestad.materialdialogs.b.POSITIVE).setEnabled(!z2);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f != null) {
            com.afollestad.materialdialogs.a.a.b(this, this.f1209b);
        }
        super.dismiss();
    }

    /* compiled from: MaterialDialog.java */
    enum i {
        REGULAR,
        SINGLE,
        MULTI;

        public static int a(i iVar) {
            switch (iVar) {
                case REGULAR:
                    return g.f.md_listitem;
                case SINGLE:
                    return g.f.md_listitem_singlechoice;
                case MULTI:
                    return g.f.md_listitem_multichoice;
                default:
                    throw new IllegalArgumentException("Not a valid list type");
            }
        }
    }

    /* compiled from: MaterialDialog.java */
    private static class c extends WindowManager.BadTokenException {
        c(String str) {
            super(str);
        }
    }

    /* compiled from: MaterialDialog.java */
    public static class a {
        protected j A;
        protected j B;
        protected j C;
        protected j D;
        protected e E;
        protected h F;
        protected g G;
        protected InterfaceC0061f H;
        protected com.afollestad.materialdialogs.i K;
        protected Typeface S;
        protected Typeface T;
        protected Drawable U;
        protected boolean V;
        protected RecyclerView.a<?> X;
        protected RecyclerView.i Y;
        protected DialogInterface.OnDismissListener Z;

        /* renamed from: a, reason: collision with root package name */
        protected final Context f1216a;
        protected NumberFormat aA;
        protected boolean aB;
        protected int aK;
        protected int aL;
        protected int aM;
        protected int aN;
        protected int aO;
        protected DialogInterface.OnCancelListener aa;
        protected DialogInterface.OnKeyListener ab;
        protected DialogInterface.OnShowListener ac;
        protected com.afollestad.materialdialogs.h ad;
        protected boolean ae;
        protected int af;
        protected int ag;
        protected int ah;
        protected boolean ai;
        protected boolean aj;
        protected CharSequence am;
        protected CharSequence an;
        protected d ao;
        protected boolean ap;
        protected boolean ar;
        protected int[] av;
        protected CharSequence aw;
        protected boolean ax;
        protected CompoundButton.OnCheckedChangeListener ay;
        protected String az;

        /* renamed from: b, reason: collision with root package name */
        protected CharSequence f1217b;
        protected com.afollestad.materialdialogs.e c;
        protected com.afollestad.materialdialogs.e d;
        protected com.afollestad.materialdialogs.e e;
        protected com.afollestad.materialdialogs.e f;
        protected com.afollestad.materialdialogs.e g;
        protected int h;
        protected CharSequence k;
        protected ArrayList<CharSequence> l;
        protected CharSequence m;
        protected CharSequence n;
        protected CharSequence o;
        protected boolean p;
        protected boolean q;
        protected boolean r;
        protected View s;
        protected int t;
        protected ColorStateList u;
        protected ColorStateList v;
        protected ColorStateList w;
        protected ColorStateList x;
        protected ColorStateList y;
        protected b z;
        protected int i = -1;
        protected int j = -1;
        protected boolean I = false;
        protected boolean J = false;
        protected boolean L = true;
        protected boolean M = true;
        protected float N = 1.2f;
        protected int O = -1;
        protected Integer[] P = null;
        protected Integer[] Q = null;
        protected boolean R = true;
        protected int W = -1;
        protected int ak = -2;
        protected int al = 0;
        protected int aq = -1;
        protected int as = -1;
        protected int at = -1;
        protected int au = 0;
        protected boolean aC = false;
        protected boolean aD = false;
        protected boolean aE = false;
        protected boolean aF = false;
        protected boolean aG = false;
        protected boolean aH = false;
        protected boolean aI = false;
        protected boolean aJ = false;

        public a(Context context) {
            this.c = com.afollestad.materialdialogs.e.START;
            this.d = com.afollestad.materialdialogs.e.START;
            this.e = com.afollestad.materialdialogs.e.END;
            this.f = com.afollestad.materialdialogs.e.START;
            this.g = com.afollestad.materialdialogs.e.START;
            this.h = 0;
            this.K = com.afollestad.materialdialogs.i.LIGHT;
            this.f1216a = context;
            this.t = com.afollestad.materialdialogs.a.a.a(context, g.a.colorAccent, com.afollestad.materialdialogs.a.a.c(context, g.b.md_material_blue_600));
            if (Build.VERSION.SDK_INT >= 21) {
                this.t = com.afollestad.materialdialogs.a.a.a(context, R.attr.colorAccent, this.t);
            }
            this.v = com.afollestad.materialdialogs.a.a.h(context, this.t);
            this.w = com.afollestad.materialdialogs.a.a.h(context, this.t);
            this.x = com.afollestad.materialdialogs.a.a.h(context, this.t);
            this.y = com.afollestad.materialdialogs.a.a.h(context, com.afollestad.materialdialogs.a.a.a(context, g.a.md_link_color, this.t));
            this.h = com.afollestad.materialdialogs.a.a.a(context, g.a.md_btn_ripple_color, com.afollestad.materialdialogs.a.a.a(context, g.a.colorControlHighlight, Build.VERSION.SDK_INT >= 21 ? com.afollestad.materialdialogs.a.a.a(context, R.attr.colorControlHighlight) : 0));
            this.aA = NumberFormat.getPercentInstance();
            this.az = "%1d/%2d";
            this.K = com.afollestad.materialdialogs.a.a.a(com.afollestad.materialdialogs.a.a.a(context, R.attr.textColorPrimary)) ? com.afollestad.materialdialogs.i.LIGHT : com.afollestad.materialdialogs.i.DARK;
            d();
            this.c = com.afollestad.materialdialogs.a.a.a(context, g.a.md_title_gravity, this.c);
            this.d = com.afollestad.materialdialogs.a.a.a(context, g.a.md_content_gravity, this.d);
            this.e = com.afollestad.materialdialogs.a.a.a(context, g.a.md_btnstacked_gravity, this.e);
            this.f = com.afollestad.materialdialogs.a.a.a(context, g.a.md_items_gravity, this.f);
            this.g = com.afollestad.materialdialogs.a.a.a(context, g.a.md_buttons_gravity, this.g);
            try {
                a(com.afollestad.materialdialogs.a.a.d(context, g.a.md_medium_font), com.afollestad.materialdialogs.a.a.d(context, g.a.md_regular_font));
            } catch (Throwable unused) {
            }
            if (this.T == null) {
                try {
                    if (Build.VERSION.SDK_INT >= 21) {
                        this.T = Typeface.create("sans-serif-medium", 0);
                    } else {
                        this.T = Typeface.create("sans-serif", 1);
                    }
                } catch (Throwable unused2) {
                    this.T = Typeface.DEFAULT_BOLD;
                }
            }
            if (this.S == null) {
                try {
                    this.S = Typeface.create("sans-serif", 0);
                } catch (Throwable unused3) {
                    this.S = Typeface.SANS_SERIF;
                    if (this.S == null) {
                        this.S = Typeface.DEFAULT;
                    }
                }
            }
        }

        public final Context a() {
            return this.f1216a;
        }

        private void d() {
            if (com.afollestad.materialdialogs.internal.d.a(false) == null) {
                return;
            }
            com.afollestad.materialdialogs.internal.d dVarA = com.afollestad.materialdialogs.internal.d.a();
            if (dVarA.f1236a) {
                this.K = com.afollestad.materialdialogs.i.DARK;
            }
            if (dVarA.f1237b != 0) {
                this.i = dVarA.f1237b;
            }
            if (dVarA.c != 0) {
                this.j = dVarA.c;
            }
            if (dVarA.d != null) {
                this.v = dVarA.d;
            }
            if (dVarA.e != null) {
                this.x = dVarA.e;
            }
            if (dVarA.f != null) {
                this.w = dVarA.f;
            }
            if (dVarA.h != 0) {
                this.ah = dVarA.h;
            }
            if (dVarA.i != null) {
                this.U = dVarA.i;
            }
            if (dVarA.j != 0) {
                this.ag = dVarA.j;
            }
            if (dVarA.k != 0) {
                this.af = dVarA.k;
            }
            if (dVarA.n != 0) {
                this.aL = dVarA.n;
            }
            if (dVarA.m != 0) {
                this.aK = dVarA.m;
            }
            if (dVarA.o != 0) {
                this.aM = dVarA.o;
            }
            if (dVarA.p != 0) {
                this.aN = dVarA.p;
            }
            if (dVarA.q != 0) {
                this.aO = dVarA.q;
            }
            if (dVarA.g != 0) {
                this.t = dVarA.g;
            }
            if (dVarA.l != null) {
                this.y = dVarA.l;
            }
            this.c = dVarA.r;
            this.d = dVarA.s;
            this.e = dVarA.t;
            this.f = dVarA.u;
            this.g = dVarA.v;
        }

        public a a(int i) {
            a(this.f1216a.getText(i));
            return this;
        }

        public a a(CharSequence charSequence) {
            this.f1217b = charSequence;
            return this;
        }

        public a a(com.afollestad.materialdialogs.e eVar) {
            this.c = eVar;
            return this;
        }

        public a b(int i) {
            this.i = i;
            this.aC = true;
            return this;
        }

        public a c(int i) {
            return b(com.afollestad.materialdialogs.a.a.c(this.f1216a, i));
        }

        public a a(String str, String str2) {
            if (str != null && !str.trim().isEmpty()) {
                this.T = com.afollestad.materialdialogs.a.c.a(this.f1216a, str);
                if (this.T == null) {
                    throw new IllegalArgumentException("No font asset found for \"" + str + "\"");
                }
            }
            if (str2 != null && !str2.trim().isEmpty()) {
                this.S = com.afollestad.materialdialogs.a.c.a(this.f1216a, str2);
                if (this.S == null) {
                    throw new IllegalArgumentException("No font asset found for \"" + str2 + "\"");
                }
            }
            return this;
        }

        public a d(int i) {
            return a(i, false);
        }

        public a a(int i, boolean z) {
            CharSequence text = this.f1216a.getText(i);
            if (z) {
                text = Html.fromHtml(text.toString().replace("\n", "<br/>"));
            }
            return b(text);
        }

        public a b(CharSequence charSequence) {
            if (this.s != null) {
                throw new IllegalStateException("You cannot set content() when you're using a custom view.");
            }
            this.k = charSequence;
            return this;
        }

        public a e(int i) {
            this.j = i;
            this.aD = true;
            return this;
        }

        public a f(int i) {
            e(com.afollestad.materialdialogs.a.a.c(this.f1216a, i));
            return this;
        }

        public a a(CharSequence... charSequenceArr) {
            if (this.s != null) {
                throw new IllegalStateException("You cannot set items() when you're using a custom view.");
            }
            this.l = new ArrayList<>();
            Collections.addAll(this.l, charSequenceArr);
            return this;
        }

        public a a(e eVar) {
            this.E = eVar;
            this.G = null;
            this.H = null;
            return this;
        }

        public a g(int i) {
            if (i == 0) {
                return this;
            }
            c(this.f1216a.getText(i));
            return this;
        }

        public a c(CharSequence charSequence) {
            this.m = charSequence;
            return this;
        }

        public a h(int i) {
            return a(com.afollestad.materialdialogs.a.a.h(this.f1216a, i));
        }

        public a i(int i) {
            return a(com.afollestad.materialdialogs.a.a.b(this.f1216a, i));
        }

        public a a(ColorStateList colorStateList) {
            this.v = colorStateList;
            this.aF = true;
            return this;
        }

        public a j(int i) {
            return b(com.afollestad.materialdialogs.a.a.a(this.f1216a, i, (ColorStateList) null));
        }

        public a b(ColorStateList colorStateList) {
            this.w = colorStateList;
            this.aH = true;
            return this;
        }

        public a k(int i) {
            return i == 0 ? this : d(this.f1216a.getText(i));
        }

        public a d(CharSequence charSequence) {
            this.o = charSequence;
            return this;
        }

        public a a(int i, com.afollestad.materialdialogs.b bVar) {
            switch (bVar) {
                case NEUTRAL:
                    this.aN = i;
                    return this;
                case NEGATIVE:
                    this.aO = i;
                    return this;
                default:
                    this.aM = i;
                    return this;
            }
        }

        public a b(int i, boolean z) {
            return a(LayoutInflater.from(this.f1216a).inflate(i, (ViewGroup) null), z);
        }

        public a a(View view, boolean z) {
            if (this.k != null) {
                throw new IllegalStateException("You cannot use customView() when you have content set.");
            }
            if (this.l != null) {
                throw new IllegalStateException("You cannot use customView() when you have items set.");
            }
            if (this.ao != null) {
                throw new IllegalStateException("You cannot use customView() with an input dialog");
            }
            if (this.ak > -2 || this.ai) {
                throw new IllegalStateException("You cannot use customView() with a progress dialog");
            }
            if (view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.s = view;
            this.ae = z;
            return this;
        }

        public a a(boolean z, int i) {
            if (this.s != null) {
                throw new IllegalStateException("You cannot set progress() when you're using a custom view.");
            }
            if (z) {
                this.ai = true;
                this.ak = -2;
            } else {
                this.aB = false;
                this.ai = false;
                this.ak = -1;
                this.al = i;
            }
            return this;
        }

        public a l(int i) {
            this.af = i;
            this.aJ = true;
            return this;
        }

        public a m(int i) {
            return l(com.afollestad.materialdialogs.a.a.c(this.f1216a, i));
        }

        public a n(int i) {
            this.ag = i;
            return this;
        }

        public a o(int i) {
            return n(com.afollestad.materialdialogs.a.a.c(this.f1216a, i));
        }

        public a a(b bVar) {
            this.z = bVar;
            return this;
        }

        public a a(j jVar) {
            this.A = jVar;
            return this;
        }

        public a b(j jVar) {
            this.D = jVar;
            return this;
        }

        public a a(com.afollestad.materialdialogs.i iVar) {
            this.K = iVar;
            return this;
        }

        public a a(boolean z) {
            this.R = z;
            return this;
        }

        public a a(DialogInterface.OnCancelListener onCancelListener) {
            this.aa = onCancelListener;
            return this;
        }

        public a a(CharSequence charSequence, CharSequence charSequence2, boolean z, d dVar) {
            if (this.s != null) {
                throw new IllegalStateException("You cannot set content() when you're using a custom view.");
            }
            this.ao = dVar;
            this.an = charSequence;
            this.am = charSequence2;
            this.ap = z;
            return this;
        }

        public a a(CharSequence charSequence, CharSequence charSequence2, d dVar) {
            return a(charSequence, charSequence2, true, dVar);
        }

        public a p(int i) {
            this.aq = i;
            return this;
        }

        public f b() {
            return new f(this);
        }

        public f c() {
            f fVarB = b();
            fVarB.show();
            return fVarB;
        }
    }

    /* compiled from: MaterialDialog.java */
    @Deprecated
    public static abstract class b {
        @Deprecated
        public void a(f fVar) {
        }

        @Deprecated
        public void b(f fVar) {
        }

        @Deprecated
        public void c(f fVar) {
        }

        @Deprecated
        public void d(f fVar) {
        }

        protected final Object clone() {
            return super.clone();
        }

        public final boolean equals(Object obj) {
            return super.equals(obj);
        }

        protected final void finalize() throws Throwable {
            super.finalize();
        }

        public final int hashCode() {
            return super.hashCode();
        }

        public final String toString() {
            return super.toString();
        }
    }
}
