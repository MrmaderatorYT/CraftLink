package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.widget.as;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements AdapterView.OnItemClickListener, h.b, p {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f211a = {R.attr.background, R.attr.divider};

    /* renamed from: b, reason: collision with root package name */
    private h f212b;
    private int c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        as asVarA = as.a(context, attributeSet, f211a, i, 0);
        if (asVarA.g(0)) {
            setBackgroundDrawable(asVarA.a(0));
        }
        if (asVarA.g(1)) {
            setDivider(asVarA.a(1));
        }
        asVarA.a();
    }

    @Override // androidx.appcompat.view.menu.p
    public void a(h hVar) {
        this.f212b = hVar;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // androidx.appcompat.view.menu.h.b
    public boolean a(j jVar) {
        return this.f212b.a(jVar, 0);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        a((j) getAdapter().getItem(i));
    }

    public int getWindowAnimations() {
        return this.c;
    }
}
