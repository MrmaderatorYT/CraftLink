package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.a;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    final a f270a;

    /* renamed from: b, reason: collision with root package name */
    final FrameLayout f271b;
    final FrameLayout c;
    androidx.core.g.b d;
    final DataSetObserver e;
    PopupWindow.OnDismissListener f;
    boolean g;
    int h;
    private final b i;
    private final View j;
    private final ImageView k;
    private final int l;
    private final ViewTreeObserver.OnGlobalLayoutListener m;
    private ag n;
    private boolean o;
    private int p;

    public void setActivityChooserModel(d dVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f270a.a(dVar);
        if (c()) {
            b();
            a();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.k.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.k.setContentDescription(getContext().getString(i));
    }

    public void setProvider(androidx.core.g.b bVar) {
        this.d = bVar;
    }

    public boolean a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (c() || !this.o) {
            return false;
        }
        this.g = false;
        a(this.h);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [boolean, int] */
    void a(int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f270a.d() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.m);
        ?? r0 = this.c.getVisibility() == 0 ? 1 : 0;
        int iC = this.f270a.c();
        if (i != Integer.MAX_VALUE && iC > i + r0) {
            this.f270a.a(true);
            this.f270a.a(i - 1);
        } else {
            this.f270a.a(false);
            this.f270a.a(i);
        }
        ag listPopupWindow = getListPopupWindow();
        if (listPopupWindow.d()) {
            return;
        }
        if (this.g || r0 == 0) {
            this.f270a.a(true, r0);
        } else {
            this.f270a.a(false, false);
        }
        listPopupWindow.g(Math.min(this.f270a.a(), this.l));
        listPopupWindow.a();
        if (this.d != null) {
            this.d.a(true);
        }
        listPopupWindow.e().setContentDescription(getContext().getString(a.h.abc_activitychooserview_choose_application));
        listPopupWindow.e().setSelector(new ColorDrawable(0));
    }

    public boolean b() {
        if (!c()) {
            return true;
        }
        getListPopupWindow().c();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.m);
        return true;
    }

    public boolean c() {
        return getListPopupWindow().d();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d dVarD = this.f270a.d();
        if (dVarD != null) {
            dVarD.registerObserver(this.e);
        }
        this.o = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVarD = this.f270a.d();
        if (dVarD != null) {
            dVarD.unregisterObserver(this.e);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.m);
        }
        if (c()) {
            b();
        }
        this.o = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        View view = this.j;
        if (this.c.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.j.layout(0, 0, i3 - i, i4 - i2);
        if (c()) {
            return;
        }
        b();
    }

    public d getDataModel() {
        return this.f270a.d();
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f = onDismissListener;
    }

    public void setInitialActivityCount(int i) {
        this.h = i;
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.p = i;
    }

    ag getListPopupWindow() {
        if (this.n == null) {
            this.n = new ag(getContext());
            this.n.a(this.f270a);
            this.n.b(this);
            this.n.a(true);
            this.n.a((AdapterView.OnItemClickListener) this.i);
            this.n.a((PopupWindow.OnDismissListener) this.i);
        }
        return this.n;
    }

    private class b implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ActivityChooserView f275a;

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            switch (((a) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    this.f275a.b();
                    if (this.f275a.g) {
                        if (i > 0) {
                            this.f275a.f270a.d().c(i);
                            return;
                        }
                        return;
                    }
                    if (!this.f275a.f270a.e()) {
                        i++;
                    }
                    Intent intentB = this.f275a.f270a.d().b(i);
                    if (intentB != null) {
                        intentB.addFlags(524288);
                        this.f275a.getContext().startActivity(intentB);
                        return;
                    }
                    return;
                case 1:
                    this.f275a.a(Integer.MAX_VALUE);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (view == this.f275a.c) {
                this.f275a.b();
                Intent intentB = this.f275a.f270a.d().b(this.f275a.f270a.d().a(this.f275a.f270a.b()));
                if (intentB != null) {
                    intentB.addFlags(524288);
                    this.f275a.getContext().startActivity(intentB);
                    return;
                }
                return;
            }
            if (view == this.f275a.f271b) {
                this.f275a.g = false;
                this.f275a.a(this.f275a.h);
                return;
            }
            throw new IllegalArgumentException();
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (view == this.f275a.c) {
                if (this.f275a.f270a.getCount() > 0) {
                    this.f275a.g = true;
                    this.f275a.a(this.f275a.h);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a();
            if (this.f275a.d != null) {
                this.f275a.d.a(false);
            }
        }

        private void a() {
            if (this.f275a.f != null) {
                this.f275a.f.onDismiss();
            }
        }
    }

    private class a extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ActivityChooserView f273a;

        /* renamed from: b, reason: collision with root package name */
        private d f274b;
        private int c;
        private boolean d;
        private boolean e;
        private boolean f;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        public void a(d dVar) {
            d dVarD = this.f273a.f270a.d();
            if (dVarD != null && this.f273a.isShown()) {
                dVarD.unregisterObserver(this.f273a.e);
            }
            this.f274b = dVar;
            if (dVar != null && this.f273a.isShown()) {
                dVar.registerObserver(this.f273a.e);
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return (this.f && i == getCount() - 1) ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int iA = this.f274b.a();
            if (!this.d && this.f274b.b() != null) {
                iA--;
            }
            int iMin = Math.min(iA, this.c);
            return this.f ? iMin + 1 : iMin;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!this.d && this.f274b.b() != null) {
                        i++;
                    }
                    return this.f274b.a(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != a.f.list_item) {
                        view = LayoutInflater.from(this.f273a.getContext()).inflate(a.g.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    PackageManager packageManager = this.f273a.getContext().getPackageManager();
                    ImageView imageView = (ImageView) view.findViewById(a.f.icon);
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(a.f.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (this.d && i == 0 && this.e) {
                        view.setActivated(true);
                    } else {
                        view.setActivated(false);
                    }
                    return view;
                case 1:
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    View viewInflate = LayoutInflater.from(this.f273a.getContext()).inflate(a.g.abc_activity_chooser_view_list_item, viewGroup, false);
                    viewInflate.setId(1);
                    ((TextView) viewInflate.findViewById(a.f.title)).setText(this.f273a.getContext().getString(a.h.abc_activity_chooser_view_see_all));
                    return viewInflate;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public int a() {
            int i = this.c;
            this.c = Integer.MAX_VALUE;
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int iMax = 0;
            for (int i2 = 0; i2 < count; i2++) {
                view = getView(i2, view, null);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                iMax = Math.max(iMax, view.getMeasuredWidth());
            }
            this.c = i;
            return iMax;
        }

        public void a(int i) {
            if (this.c != i) {
                this.c = i;
                notifyDataSetChanged();
            }
        }

        public ResolveInfo b() {
            return this.f274b.b();
        }

        public void a(boolean z) {
            if (this.f != z) {
                this.f = z;
                notifyDataSetChanged();
            }
        }

        public int c() {
            return this.f274b.a();
        }

        public d d() {
            return this.f274b;
        }

        public void a(boolean z, boolean z2) {
            if (this.d == z && this.e == z2) {
                return;
            }
            this.d = z;
            this.e = z2;
            notifyDataSetChanged();
        }

        public boolean e() {
            return this.d;
        }
    }

    public static class InnerLayout extends LinearLayout {

        /* renamed from: a, reason: collision with root package name */
        private static final int[] f272a = {R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            as asVarA = as.a(context, attributeSet, f272a);
            setBackgroundDrawable(asVarA.a(0));
            asVarA.a();
        }
    }
}
