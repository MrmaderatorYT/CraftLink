package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.a;

/* compiled from: TooltipPopup.java */
/* loaded from: classes.dex */
class aw {

    /* renamed from: a, reason: collision with root package name */
    private final Context f379a;

    /* renamed from: b, reason: collision with root package name */
    private final View f380b;
    private final TextView c;
    private final WindowManager.LayoutParams d = new WindowManager.LayoutParams();
    private final Rect e = new Rect();
    private final int[] f = new int[2];
    private final int[] g = new int[2];

    aw(Context context) {
        this.f379a = context;
        this.f380b = LayoutInflater.from(this.f379a).inflate(a.g.abc_tooltip, (ViewGroup) null);
        this.c = (TextView) this.f380b.findViewById(a.f.message);
        this.d.setTitle(getClass().getSimpleName());
        this.d.packageName = this.f379a.getPackageName();
        this.d.type = 1002;
        this.d.width = -2;
        this.d.height = -2;
        this.d.format = -3;
        this.d.windowAnimations = a.i.Animation_AppCompat_Tooltip;
        this.d.flags = 24;
    }

    void a(View view, int i, int i2, boolean z, CharSequence charSequence) throws Resources.NotFoundException {
        if (b()) {
            a();
        }
        this.c.setText(charSequence);
        a(view, i, i2, z, this.d);
        ((WindowManager) this.f379a.getSystemService("window")).addView(this.f380b, this.d);
    }

    void a() {
        if (b()) {
            ((WindowManager) this.f379a.getSystemService("window")).removeView(this.f380b);
        }
    }

    boolean b() {
        return this.f380b.getParent() != null;
    }

    private void a(View view, int i, int i2, boolean z, WindowManager.LayoutParams layoutParams) throws Resources.NotFoundException {
        int height;
        int i3;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f379a.getResources().getDimensionPixelOffset(a.d.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f379a.getResources().getDimensionPixelOffset(a.d.tooltip_precise_anchor_extra_offset);
            height = i2 + dimensionPixelOffset2;
            i3 = i2 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i3 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f379a.getResources().getDimensionPixelOffset(z ? a.d.tooltip_y_offset_touch : a.d.tooltip_y_offset_non_touch);
        View viewA = a(view);
        if (viewA == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        viewA.getWindowVisibleDisplayFrame(this.e);
        if (this.e.left < 0 && this.e.top < 0) {
            Resources resources = this.f379a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        viewA.getLocationOnScreen(this.g);
        view.getLocationOnScreen(this.f);
        int[] iArr = this.f;
        iArr[0] = iArr[0] - this.g[0];
        int[] iArr2 = this.f;
        iArr2[1] = iArr2[1] - this.g[1];
        layoutParams.x = (this.f[0] + i) - (viewA.getWidth() / 2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f380b.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredHeight = this.f380b.getMeasuredHeight();
        int i4 = ((this.f[1] + i3) - dimensionPixelOffset3) - measuredHeight;
        int i5 = this.f[1] + height + dimensionPixelOffset3;
        if (z) {
            if (i4 >= 0) {
                layoutParams.y = i4;
                return;
            } else {
                layoutParams.y = i5;
                return;
            }
        }
        if (measuredHeight + i5 <= this.e.height()) {
            layoutParams.y = i5;
        } else {
            layoutParams.y = i4;
        }
    }

    private static View a(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }
}
