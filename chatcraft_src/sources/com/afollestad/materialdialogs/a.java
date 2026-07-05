package com.afollestad.materialdialogs;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.g;

/* compiled from: DefaultRvAdapter.java */
/* loaded from: classes.dex */
class a extends RecyclerView.a<ViewOnClickListenerC0059a> {

    /* renamed from: a, reason: collision with root package name */
    private final f f1195a;

    /* renamed from: b, reason: collision with root package name */
    private final int f1196b;
    private final e c;
    private b d;

    /* compiled from: DefaultRvAdapter.java */
    interface b {
        boolean a(f fVar, View view, int i, CharSequence charSequence, boolean z);
    }

    a(f fVar, int i) {
        this.f1195a = fVar;
        this.f1196b = i;
        this.c = fVar.f1209b.f;
    }

    void a(b bVar) {
        this.d = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ViewOnClickListenerC0059a b(ViewGroup viewGroup, int i) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.f1196b, viewGroup, false);
        com.afollestad.materialdialogs.a.a.a(viewInflate, this.f1195a.e());
        return new ViewOnClickListenerC0059a(viewInflate, this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void a(ViewOnClickListenerC0059a viewOnClickListenerC0059a, int i) {
        View view = viewOnClickListenerC0059a.f1052a;
        boolean zA = com.afollestad.materialdialogs.a.a.a(Integer.valueOf(i), this.f1195a.f1209b.Q);
        int iA = zA ? com.afollestad.materialdialogs.a.a.a(this.f1195a.f1209b.ah, 0.4f) : this.f1195a.f1209b.ah;
        viewOnClickListenerC0059a.f1052a.setEnabled(!zA);
        switch (this.f1195a.r) {
            case SINGLE:
                RadioButton radioButton = (RadioButton) viewOnClickListenerC0059a.q;
                boolean z = this.f1195a.f1209b.O == i;
                if (this.f1195a.f1209b.u != null) {
                    com.afollestad.materialdialogs.internal.c.a(radioButton, this.f1195a.f1209b.u);
                } else {
                    com.afollestad.materialdialogs.internal.c.a(radioButton, this.f1195a.f1209b.t);
                }
                radioButton.setChecked(z);
                radioButton.setEnabled(!zA);
                break;
            case MULTI:
                CheckBox checkBox = (CheckBox) viewOnClickListenerC0059a.q;
                boolean zContains = this.f1195a.s.contains(Integer.valueOf(i));
                if (this.f1195a.f1209b.u != null) {
                    com.afollestad.materialdialogs.internal.c.a(checkBox, this.f1195a.f1209b.u);
                } else {
                    com.afollestad.materialdialogs.internal.c.a(checkBox, this.f1195a.f1209b.t);
                }
                checkBox.setChecked(zContains);
                checkBox.setEnabled(!zA);
                break;
        }
        viewOnClickListenerC0059a.r.setText(this.f1195a.f1209b.l.get(i));
        viewOnClickListenerC0059a.r.setTextColor(iA);
        this.f1195a.a(viewOnClickListenerC0059a.r, this.f1195a.f1209b.S);
        ViewGroup viewGroup = (ViewGroup) view;
        a(viewGroup);
        if (this.f1195a.f1209b.av != null) {
            if (i < this.f1195a.f1209b.av.length) {
                view.setId(this.f1195a.f1209b.av[i]);
            } else {
                view.setId(-1);
            }
        }
        if (Build.VERSION.SDK_INT < 21 || viewGroup.getChildCount() != 2) {
            return;
        }
        if (viewGroup.getChildAt(0) instanceof CompoundButton) {
            viewGroup.getChildAt(0).setBackground(null);
        } else if (viewGroup.getChildAt(1) instanceof CompoundButton) {
            viewGroup.getChildAt(1).setBackground(null);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int b() {
        if (this.f1195a.f1209b.l != null) {
            return this.f1195a.f1209b.l.size();
        }
        return 0;
    }

    @TargetApi(17)
    private void a(ViewGroup viewGroup) {
        ((LinearLayout) viewGroup).setGravity(this.c.a() | 16);
        if (viewGroup.getChildCount() == 2) {
            if (this.c == e.END && !a() && (viewGroup.getChildAt(0) instanceof CompoundButton)) {
                View view = (CompoundButton) viewGroup.getChildAt(0);
                viewGroup.removeView(view);
                TextView textView = (TextView) viewGroup.getChildAt(0);
                viewGroup.removeView(textView);
                textView.setPadding(textView.getPaddingRight(), textView.getPaddingTop(), textView.getPaddingLeft(), textView.getPaddingBottom());
                viewGroup.addView(textView);
                viewGroup.addView(view);
                return;
            }
            if (this.c == e.START && a() && (viewGroup.getChildAt(1) instanceof CompoundButton)) {
                View view2 = (CompoundButton) viewGroup.getChildAt(1);
                viewGroup.removeView(view2);
                TextView textView2 = (TextView) viewGroup.getChildAt(0);
                viewGroup.removeView(textView2);
                textView2.setPadding(textView2.getPaddingRight(), textView2.getPaddingTop(), textView2.getPaddingRight(), textView2.getPaddingBottom());
                viewGroup.addView(view2);
                viewGroup.addView(textView2);
            }
        }
    }

    @TargetApi(17)
    private boolean a() {
        return Build.VERSION.SDK_INT >= 17 && this.f1195a.b().a().getResources().getConfiguration().getLayoutDirection() == 1;
    }

    /* compiled from: DefaultRvAdapter.java */
    /* renamed from: com.afollestad.materialdialogs.a$a, reason: collision with other inner class name */
    static class ViewOnClickListenerC0059a extends RecyclerView.x implements View.OnClickListener, View.OnLongClickListener {
        final CompoundButton q;
        final TextView r;
        final a s;

        ViewOnClickListenerC0059a(View view, a aVar) {
            super(view);
            this.q = (CompoundButton) view.findViewById(g.e.md_control);
            this.r = (TextView) view.findViewById(g.e.md_title);
            this.s = aVar;
            view.setOnClickListener(this);
            if (aVar.f1195a.f1209b.F != null) {
                view.setOnLongClickListener(this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.s.d == null || g() == -1) {
                return;
            }
            CharSequence charSequence = null;
            if (this.s.f1195a.f1209b.l != null && g() < this.s.f1195a.f1209b.l.size()) {
                charSequence = this.s.f1195a.f1209b.l.get(g());
            }
            this.s.d.a(this.s.f1195a, view, g(), charSequence, false);
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (this.s.d == null || g() == -1) {
                return false;
            }
            CharSequence charSequence = null;
            if (this.s.f1195a.f1209b.l != null && g() < this.s.f1195a.f1209b.l.size()) {
                charSequence = this.s.f1195a.f1209b.l.get(g());
            }
            return this.s.d.a(this.s.f1195a, view, g(), charSequence, true);
        }
    }
}
