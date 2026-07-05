package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public class SearchView extends af implements androidx.appcompat.view.c {
    static final a i = new a();
    private c A;
    private b B;
    private d C;
    private View.OnClickListener D;
    private boolean E;
    private boolean F;
    private boolean G;
    private CharSequence H;
    private boolean I;
    private boolean J;
    private int K;
    private boolean L;
    private CharSequence M;
    private CharSequence N;
    private boolean O;
    private int P;
    private Bundle Q;
    private final Runnable R;
    private Runnable S;
    private final WeakHashMap<String, Drawable.ConstantState> T;
    private final View.OnClickListener U;
    private final TextView.OnEditorActionListener V;
    private final AdapterView.OnItemClickListener W;

    /* renamed from: a, reason: collision with root package name */
    final SearchAutoComplete f285a;
    private final AdapterView.OnItemSelectedListener aa;
    private TextWatcher ab;

    /* renamed from: b, reason: collision with root package name */
    final ImageView f286b;
    final ImageView c;
    final ImageView d;
    final ImageView e;
    View.OnFocusChangeListener f;
    androidx.c.a.a g;
    SearchableInfo h;
    View.OnKeyListener j;
    private final View k;
    private final View l;
    private final View m;
    private final View n;
    private f o;
    private Rect p;
    private Rect q;
    private int[] r;
    private int[] s;
    private final ImageView t;
    private final Drawable u;
    private final int v;
    private final int w;
    private final Intent x;
    private final Intent y;
    private final CharSequence z;

    public interface b {
        boolean a();
    }

    public interface c {
        boolean a(String str);

        boolean b(String str);
    }

    public interface d {
        boolean a(int i);

        boolean b(int i);
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0018a.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.p = new Rect();
        this.q = new Rect();
        this.r = new int[2];
        this.s = new int[2];
        this.R = new Runnable() { // from class: androidx.appcompat.widget.SearchView.1
            @Override // java.lang.Runnable
            public void run() {
                SearchView.this.d();
            }
        };
        this.S = new Runnable() { // from class: androidx.appcompat.widget.SearchView.3
            @Override // java.lang.Runnable
            public void run() {
                if (SearchView.this.g == null || !(SearchView.this.g instanceof am)) {
                    return;
                }
                SearchView.this.g.a((Cursor) null);
            }
        };
        this.T = new WeakHashMap<>();
        this.U = new View.OnClickListener() { // from class: androidx.appcompat.widget.SearchView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                if (view == SearchView.this.f286b) {
                    SearchView.this.g();
                    return;
                }
                if (view == SearchView.this.d) {
                    SearchView.this.f();
                    return;
                }
                if (view == SearchView.this.c) {
                    SearchView.this.e();
                } else if (view == SearchView.this.e) {
                    SearchView.this.h();
                } else if (view == SearchView.this.f285a) {
                    SearchView.this.l();
                }
            }
        };
        this.j = new View.OnKeyListener() { // from class: androidx.appcompat.widget.SearchView.7
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i3, KeyEvent keyEvent) {
                if (SearchView.this.h == null) {
                    return false;
                }
                if (SearchView.this.f285a.isPopupShowing() && SearchView.this.f285a.getListSelection() != -1) {
                    return SearchView.this.a(view, i3, keyEvent);
                }
                if (SearchView.this.f285a.a() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i3 != 66) {
                    return false;
                }
                view.cancelLongPress();
                SearchView.this.a(0, (String) null, SearchView.this.f285a.getText().toString());
                return true;
            }
        };
        this.V = new TextView.OnEditorActionListener() { // from class: androidx.appcompat.widget.SearchView.8
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                SearchView.this.e();
                return true;
            }
        };
        this.W = new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.widget.SearchView.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                SearchView.this.a(i3, 0, (String) null);
            }
        };
        this.aa = new AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.SearchView.10
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j) {
                SearchView.this.a(i3);
            }
        };
        this.ab = new TextWatcher() { // from class: androidx.appcompat.widget.SearchView.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                SearchView.this.b(charSequence);
            }
        };
        as asVarA = as.a(context, attributeSet, a.j.SearchView, i2, 0);
        LayoutInflater.from(context).inflate(asVarA.g(a.j.SearchView_layout, a.g.abc_search_view), (ViewGroup) this, true);
        this.f285a = (SearchAutoComplete) findViewById(a.f.search_src_text);
        this.f285a.setSearchView(this);
        this.k = findViewById(a.f.search_edit_frame);
        this.l = findViewById(a.f.search_plate);
        this.m = findViewById(a.f.submit_area);
        this.f286b = (ImageView) findViewById(a.f.search_button);
        this.c = (ImageView) findViewById(a.f.search_go_btn);
        this.d = (ImageView) findViewById(a.f.search_close_btn);
        this.e = (ImageView) findViewById(a.f.search_voice_btn);
        this.t = (ImageView) findViewById(a.f.search_mag_icon);
        androidx.core.g.q.a(this.l, asVarA.a(a.j.SearchView_queryBackground));
        androidx.core.g.q.a(this.m, asVarA.a(a.j.SearchView_submitBackground));
        this.f286b.setImageDrawable(asVarA.a(a.j.SearchView_searchIcon));
        this.c.setImageDrawable(asVarA.a(a.j.SearchView_goIcon));
        this.d.setImageDrawable(asVarA.a(a.j.SearchView_closeIcon));
        this.e.setImageDrawable(asVarA.a(a.j.SearchView_voiceIcon));
        this.t.setImageDrawable(asVarA.a(a.j.SearchView_searchIcon));
        this.u = asVarA.a(a.j.SearchView_searchHintIcon);
        au.a(this.f286b, getResources().getString(a.h.abc_searchview_description_search));
        this.v = asVarA.g(a.j.SearchView_suggestionRowLayout, a.g.abc_search_dropdown_item_icons_2line);
        this.w = asVarA.g(a.j.SearchView_commitIcon, 0);
        this.f286b.setOnClickListener(this.U);
        this.d.setOnClickListener(this.U);
        this.c.setOnClickListener(this.U);
        this.e.setOnClickListener(this.U);
        this.f285a.setOnClickListener(this.U);
        this.f285a.addTextChangedListener(this.ab);
        this.f285a.setOnEditorActionListener(this.V);
        this.f285a.setOnItemClickListener(this.W);
        this.f285a.setOnItemSelectedListener(this.aa);
        this.f285a.setOnKeyListener(this.j);
        this.f285a.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: androidx.appcompat.widget.SearchView.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (SearchView.this.f != null) {
                    SearchView.this.f.onFocusChange(SearchView.this, z);
                }
            }
        });
        setIconifiedByDefault(asVarA.a(a.j.SearchView_iconifiedByDefault, true));
        int iE = asVarA.e(a.j.SearchView_android_maxWidth, -1);
        if (iE != -1) {
            setMaxWidth(iE);
        }
        this.z = asVarA.c(a.j.SearchView_defaultQueryHint);
        this.H = asVarA.c(a.j.SearchView_queryHint);
        int iA = asVarA.a(a.j.SearchView_android_imeOptions, -1);
        if (iA != -1) {
            setImeOptions(iA);
        }
        int iA2 = asVarA.a(a.j.SearchView_android_inputType, -1);
        if (iA2 != -1) {
            setInputType(iA2);
        }
        setFocusable(asVarA.a(a.j.SearchView_android_focusable, true));
        asVarA.a();
        this.x = new Intent("android.speech.action.WEB_SEARCH");
        this.x.addFlags(268435456);
        this.x.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.y = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.y.addFlags(268435456);
        this.n = findViewById(this.f285a.getDropDownAnchor());
        if (this.n != null) {
            this.n.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.appcompat.widget.SearchView.5
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                    SearchView.this.k();
                }
            });
        }
        a(this.E);
        r();
    }

    int getSuggestionRowLayout() {
        return this.v;
    }

    int getSuggestionCommitIconResId() {
        return this.w;
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.h = searchableInfo;
        if (this.h != null) {
            s();
            r();
        }
        this.L = m();
        if (this.L) {
            this.f285a.setPrivateImeOptions("nm");
        }
        a(c());
    }

    public void setAppSearchData(Bundle bundle) {
        this.Q = bundle;
    }

    public void setImeOptions(int i2) {
        this.f285a.setImeOptions(i2);
    }

    public int getImeOptions() {
        return this.f285a.getImeOptions();
    }

    public void setInputType(int i2) {
        this.f285a.setInputType(i2);
    }

    public int getInputType() {
        return this.f285a.getInputType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i2, Rect rect) {
        if (this.J || !isFocusable()) {
            return false;
        }
        if (!c()) {
            boolean zRequestFocus = this.f285a.requestFocus(i2, rect);
            if (zRequestFocus) {
                a(false);
            }
            return zRequestFocus;
        }
        return super.requestFocus(i2, rect);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.J = true;
        super.clearFocus();
        this.f285a.clearFocus();
        this.f285a.setImeVisibility(false);
        this.J = false;
    }

    public void setOnQueryTextListener(c cVar) {
        this.A = cVar;
    }

    public void setOnCloseListener(b bVar) {
        this.B = bVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f = onFocusChangeListener;
    }

    public void setOnSuggestionListener(d dVar) {
        this.C = dVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.D = onClickListener;
    }

    public CharSequence getQuery() {
        return this.f285a.getText();
    }

    public void a(CharSequence charSequence, boolean z) {
        this.f285a.setText(charSequence);
        if (charSequence != null) {
            this.f285a.setSelection(this.f285a.length());
            this.N = charSequence;
        }
        if (!z || TextUtils.isEmpty(charSequence)) {
            return;
        }
        e();
    }

    public void setQueryHint(CharSequence charSequence) {
        this.H = charSequence;
        r();
    }

    public CharSequence getQueryHint() {
        if (this.H != null) {
            return this.H;
        }
        if (this.h != null && this.h.getHintId() != 0) {
            return getContext().getText(this.h.getHintId());
        }
        return this.z;
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.E == z) {
            return;
        }
        this.E = z;
        a(z);
        r();
    }

    public void setIconified(boolean z) {
        if (z) {
            f();
        } else {
            g();
        }
    }

    public boolean c() {
        return this.F;
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.G = z;
        a(c());
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.I = z;
        if (this.g instanceof am) {
            ((am) this.g).a(z ? 2 : 1);
        }
    }

    public void setSuggestionsAdapter(androidx.c.a.a aVar) {
        this.g = aVar;
        this.f285a.setAdapter(this.g);
    }

    public androidx.c.a.a getSuggestionsAdapter() {
        return this.g;
    }

    public void setMaxWidth(int i2) {
        this.K = i2;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.K;
    }

    @Override // androidx.appcompat.widget.af, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (c()) {
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            size = this.K > 0 ? Math.min(this.K, size) : Math.min(getPreferredWidth(), size);
        } else if (mode != 0) {
            if (mode == 1073741824 && this.K > 0) {
                size = Math.min(this.K, size);
            }
        } else {
            size = this.K > 0 ? this.K : getPreferredWidth();
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // androidx.appcompat.widget.af, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            a(this.f285a, this.p);
            this.q.set(this.p.left, 0, this.p.right, i5 - i3);
            if (this.o == null) {
                this.o = new f(this.q, this.p, this.f285a);
                setTouchDelegate(this.o);
            } else {
                this.o.a(this.q, this.p);
            }
        }
    }

    private void a(View view, Rect rect) {
        view.getLocationInWindow(this.r);
        getLocationInWindow(this.s);
        int i2 = this.r[1] - this.s[1];
        int i3 = this.r[0] - this.s[0];
        rect.set(i3, i2, view.getWidth() + i3, view.getHeight() + i2);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(a.d.abc_search_view_preferred_width);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(a.d.abc_search_view_preferred_height);
    }

    private void a(boolean z) {
        this.F = z;
        int i2 = 8;
        int i3 = z ? 0 : 8;
        boolean z2 = !TextUtils.isEmpty(this.f285a.getText());
        this.f286b.setVisibility(i3);
        b(z2);
        this.k.setVisibility(z ? 8 : 0);
        if (this.t.getDrawable() != null && !this.E) {
            i2 = 0;
        }
        this.t.setVisibility(i2);
        p();
        c(z2 ? false : true);
        o();
    }

    private boolean m() {
        if (this.h != null && this.h.getVoiceSearchEnabled()) {
            Intent intent = null;
            if (this.h.getVoiceSearchLaunchWebSearch()) {
                intent = this.x;
            } else if (this.h.getVoiceSearchLaunchRecognizer()) {
                intent = this.y;
            }
            return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
        }
        return false;
    }

    private boolean n() {
        return (this.G || this.L) && !c();
    }

    private void b(boolean z) {
        this.c.setVisibility((this.G && n() && hasFocus() && (z || !this.L)) ? 0 : 8);
    }

    private void o() {
        this.m.setVisibility((n() && (this.c.getVisibility() == 0 || this.e.getVisibility() == 0)) ? 0 : 8);
    }

    private void p() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f285a.getText());
        if (!z2 && (!this.E || this.O)) {
            z = false;
        }
        this.d.setVisibility(z ? 0 : 8);
        Drawable drawable = this.d.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void q() {
        post(this.R);
    }

    void d() {
        int[] iArr = this.f285a.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = this.l.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.m.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.R);
        post(this.S);
        super.onDetachedFromWindow();
    }

    void a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    boolean a(View view, int i2, KeyEvent keyEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.h != null && this.g != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i2 == 66 || i2 == 84 || i2 == 61) {
                return a(this.f285a.getListSelection(), 0, (String) null);
            }
            if (i2 == 21 || i2 == 22) {
                this.f285a.setSelection(i2 == 21 ? 0 : this.f285a.length());
                this.f285a.setListSelection(0);
                this.f285a.clearListSelection();
                i.a(this.f285a, true);
                return true;
            }
            if (i2 != 19 || this.f285a.getListSelection() == 0) {
                return false;
            }
        }
        return false;
    }

    private CharSequence c(CharSequence charSequence) {
        if (!this.E || this.u == null) {
            return charSequence;
        }
        double textSize = this.f285a.getTextSize();
        Double.isNaN(textSize);
        int i2 = (int) (textSize * 1.25d);
        this.u.setBounds(0, 0, i2, i2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.u), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private void r() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f285a;
        if (queryHint == null) {
            queryHint = BuildConfig.FLAVOR;
        }
        searchAutoComplete.setHint(c(queryHint));
    }

    private void s() {
        this.f285a.setThreshold(this.h.getSuggestThreshold());
        this.f285a.setImeOptions(this.h.getImeOptions());
        int inputType = this.h.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.h.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.f285a.setInputType(inputType);
        if (this.g != null) {
            this.g.a((Cursor) null);
        }
        if (this.h.getSuggestAuthority() != null) {
            this.g = new am(getContext(), this, this.h, this.T);
            this.f285a.setAdapter(this.g);
            ((am) this.g).a(this.I ? 2 : 1);
        }
    }

    private void c(boolean z) {
        int i2;
        if (this.L && !c() && z) {
            i2 = 0;
            this.c.setVisibility(8);
        } else {
            i2 = 8;
        }
        this.e.setVisibility(i2);
    }

    void b(CharSequence charSequence) {
        Editable text = this.f285a.getText();
        this.N = text;
        boolean z = !TextUtils.isEmpty(text);
        b(z);
        c(z ? false : true);
        p();
        o();
        if (this.A != null && !TextUtils.equals(charSequence, this.M)) {
            this.A.b(charSequence.toString());
        }
        this.M = charSequence.toString();
    }

    void e() {
        Editable text = this.f285a.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        if (this.A == null || !this.A.a(text.toString())) {
            if (this.h != null) {
                a(0, (String) null, text.toString());
            }
            this.f285a.setImeVisibility(false);
            t();
        }
    }

    private void t() {
        this.f285a.dismissDropDown();
    }

    void f() {
        if (TextUtils.isEmpty(this.f285a.getText())) {
            if (this.E) {
                if (this.B == null || !this.B.a()) {
                    clearFocus();
                    a(true);
                    return;
                }
                return;
            }
            return;
        }
        this.f285a.setText(BuildConfig.FLAVOR);
        this.f285a.requestFocus();
        this.f285a.setImeVisibility(true);
    }

    void g() {
        a(false);
        this.f285a.requestFocus();
        this.f285a.setImeVisibility(true);
        if (this.D != null) {
            this.D.onClick(this);
        }
    }

    void h() {
        if (this.h == null) {
            return;
        }
        SearchableInfo searchableInfo = this.h;
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(a(this.x, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(b(this.y, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    void i() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        a(c());
        q();
        if (this.f285a.hasFocus()) {
            l();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        q();
    }

    @Override // androidx.appcompat.view.c
    public void b() {
        a(BuildConfig.FLAVOR, false);
        clearFocus();
        a(true);
        this.f285a.setImeOptions(this.P);
        this.O = false;
    }

    @Override // androidx.appcompat.view.c
    public void a() {
        if (this.O) {
            return;
        }
        this.O = true;
        this.P = this.f285a.getImeOptions();
        this.f285a.setImeOptions(this.P | 33554432);
        this.f285a.setText(BuildConfig.FLAVOR);
        setIconified(false);
    }

    static class e extends androidx.d.a.a {
        public static final Parcelable.Creator<e> CREATOR = new Parcelable.ClassLoaderCreator<e>() { // from class: androidx.appcompat.widget.SearchView.e.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new e(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i) {
                return new e[i];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        boolean f302a;

        e(Parcelable parcelable) {
            super(parcelable);
        }

        public e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f302a = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        @Override // androidx.d.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f302a));
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f302a + "}";
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        eVar.f302a = c();
        return eVar;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.a());
        a(eVar.f302a);
        requestLayout();
    }

    void k() {
        int i2;
        if (this.n.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.l.getPaddingLeft();
            Rect rect = new Rect();
            boolean zA = ay.a(this);
            int dimensionPixelSize = this.E ? resources.getDimensionPixelSize(a.d.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(a.d.abc_dropdownitem_text_padding_left) : 0;
            this.f285a.getDropDownBackground().getPadding(rect);
            if (zA) {
                i2 = -rect.left;
            } else {
                i2 = paddingLeft - (rect.left + dimensionPixelSize);
            }
            this.f285a.setDropDownHorizontalOffset(i2);
            this.f285a.setDropDownWidth((((this.n.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    boolean a(int i2, int i3, String str) {
        if (this.C != null && this.C.b(i2)) {
            return false;
        }
        b(i2, 0, null);
        this.f285a.setImeVisibility(false);
        t();
        return true;
    }

    boolean a(int i2) {
        if (this.C != null && this.C.a(i2)) {
            return false;
        }
        e(i2);
        return true;
    }

    private void e(int i2) {
        Editable text = this.f285a.getText();
        Cursor cursorA = this.g.a();
        if (cursorA == null) {
            return;
        }
        if (cursorA.moveToPosition(i2)) {
            CharSequence charSequenceB = this.g.b(cursorA);
            if (charSequenceB != null) {
                setQuery(charSequenceB);
                return;
            } else {
                setQuery(text);
                return;
            }
        }
        setQuery(text);
    }

    private boolean b(int i2, int i3, String str) {
        Cursor cursorA = this.g.a();
        if (cursorA == null || !cursorA.moveToPosition(i2)) {
            return false;
        }
        a(a(cursorA, i3, str));
        return true;
    }

    private void a(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e2) {
            Log.e("SearchView", "Failed launch activity: " + intent, e2);
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.f285a.setText(charSequence);
        this.f285a.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    void a(int i2, String str, String str2) {
        getContext().startActivity(a("android.intent.action.SEARCH", (Uri) null, (String) null, str2, i2, str));
    }

    private Intent a(String str, Uri uri, String str2, String str3, int i2, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.N);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.Q != null) {
            intent.putExtra("app_data", this.Q);
        }
        if (i2 != 0) {
            intent.putExtra("action_key", i2);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.h.getSearchActivity());
        return intent;
    }

    private Intent a(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private Intent b(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        if (this.Q != null) {
            bundle.putParcelable("app_data", this.Q);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent a(Cursor cursor, int i2, String str) {
        int position;
        String strA;
        try {
            String strA2 = am.a(cursor, "suggest_intent_action");
            if (strA2 == null) {
                strA2 = this.h.getSuggestIntentAction();
            }
            if (strA2 == null) {
                strA2 = "android.intent.action.SEARCH";
            }
            String str2 = strA2;
            String strA3 = am.a(cursor, "suggest_intent_data");
            if (strA3 == null) {
                strA3 = this.h.getSuggestIntentData();
            }
            if (strA3 != null && (strA = am.a(cursor, "suggest_intent_data_id")) != null) {
                strA3 = strA3 + "/" + Uri.encode(strA);
            }
            return a(str2, strA3 == null ? null : Uri.parse(strA3), am.a(cursor, "suggest_intent_extra_data"), am.a(cursor, "suggest_intent_query"), i2, str);
        } catch (RuntimeException e2) {
            try {
                position = cursor.getPosition();
            } catch (RuntimeException unused) {
                position = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e2);
            return null;
        }
    }

    void l() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        i.a(this.f285a);
        i.b(this.f285a);
    }

    static boolean a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private static class f extends TouchDelegate {

        /* renamed from: a, reason: collision with root package name */
        private final View f303a;

        /* renamed from: b, reason: collision with root package name */
        private final Rect f304b;
        private final Rect c;
        private final Rect d;
        private final int e;
        private boolean f;

        public f(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f304b = new Rect();
            this.d = new Rect();
            this.c = new Rect();
            a(rect, rect2);
            this.f303a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f304b.set(rect);
            this.d.set(rect);
            this.d.inset(-this.e, -this.e);
            this.c.set(rect2);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
        @Override // android.view.TouchDelegate
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouchEvent(android.view.MotionEvent r7) {
            /*
                r6 = this;
                float r0 = r7.getX()
                int r0 = (int) r0
                float r1 = r7.getY()
                int r1 = (int) r1
                int r2 = r7.getAction()
                r3 = 1
                r4 = 0
                switch(r2) {
                    case 0: goto L27;
                    case 1: goto L19;
                    case 2: goto L19;
                    case 3: goto L14;
                    default: goto L13;
                }
            L13:
                goto L33
            L14:
                boolean r2 = r6.f
                r6.f = r4
                goto L34
            L19:
                boolean r2 = r6.f
                if (r2 == 0) goto L34
                android.graphics.Rect r5 = r6.d
                boolean r5 = r5.contains(r0, r1)
                if (r5 != 0) goto L34
                r3 = 0
                goto L34
            L27:
                android.graphics.Rect r2 = r6.f304b
                boolean r2 = r2.contains(r0, r1)
                if (r2 == 0) goto L33
                r6.f = r3
                r2 = 1
                goto L34
            L33:
                r2 = 0
            L34:
                if (r2 == 0) goto L6b
                if (r3 == 0) goto L56
                android.graphics.Rect r2 = r6.c
                boolean r2 = r2.contains(r0, r1)
                if (r2 != 0) goto L56
                android.view.View r0 = r6.f303a
                int r0 = r0.getWidth()
                int r0 = r0 / 2
                float r0 = (float) r0
                android.view.View r1 = r6.f303a
                int r1 = r1.getHeight()
                int r1 = r1 / 2
                float r1 = (float) r1
                r7.setLocation(r0, r1)
                goto L65
            L56:
                android.graphics.Rect r2 = r6.c
                int r2 = r2.left
                int r0 = r0 - r2
                float r0 = (float) r0
                android.graphics.Rect r2 = r6.c
                int r2 = r2.top
                int r1 = r1 - r2
                float r1 = (float) r1
                r7.setLocation(r0, r1)
            L65:
                android.view.View r0 = r6.f303a
                boolean r4 = r0.dispatchTouchEvent(r7)
            L6b:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.f.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    public static class SearchAutoComplete extends androidx.appcompat.widget.e {

        /* renamed from: a, reason: collision with root package name */
        final Runnable f297a;

        /* renamed from: b, reason: collision with root package name */
        private int f298b;
        private SearchView c;
        private boolean d;

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, a.C0018a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f297a = new Runnable() { // from class: androidx.appcompat.widget.SearchView.SearchAutoComplete.1
                @Override // java.lang.Runnable
                public void run() {
                    SearchAutoComplete.this.b();
                }
            };
            this.f298b = getThreshold();
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        void setSearchView(SearchView searchView) {
            this.c = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f298b = i;
        }

        boolean a() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            super.onWindowFocusChanged(z);
            if (z && this.c.hasFocus() && getVisibility() == 0) {
                this.d = true;
                if (SearchView.a(getContext())) {
                    SearchView.i.a(this, true);
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z, int i, Rect rect) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            super.onFocusChanged(z, i, rect);
            this.c.i();
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f298b <= 0 || super.enoughToFilter();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.c.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i >= 960 && i2 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i < 600) {
                return (i < 640 || i2 < 480) ? 160 : 192;
            }
            return 192;
        }

        @Override // androidx.appcompat.widget.e, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.d) {
                removeCallbacks(this.f297a);
                post(this.f297a);
            }
            return inputConnectionOnCreateInputConnection;
        }

        void b() {
            if (this.d) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.d = false;
            }
        }

        void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.d = false;
                removeCallbacks(this.f297a);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (inputMethodManager.isActive(this)) {
                    this.d = false;
                    removeCallbacks(this.f297a);
                    inputMethodManager.showSoftInput(this, 0);
                    return;
                }
                this.d = true;
            }
        }
    }

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private Method f300a;

        /* renamed from: b, reason: collision with root package name */
        private Method f301b;
        private Method c;

        a() {
            try {
                this.f300a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f300a.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                this.f301b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f301b.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                this.c = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.c.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (this.f300a != null) {
                try {
                    this.f300a.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (this.f301b != null) {
                try {
                    this.f301b.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (this.c != null) {
                try {
                    this.c.invoke(autoCompleteTextView, Boolean.valueOf(z));
                } catch (Exception unused) {
                }
            }
        }
    }
}
