package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.core.e.b;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: AppCompatTextView.java */
/* loaded from: classes.dex */
public class x extends TextView implements androidx.core.g.p, androidx.core.widget.b {

    /* renamed from: a, reason: collision with root package name */
    private final f f449a;

    /* renamed from: b, reason: collision with root package name */
    private final w f450b;
    private Future<androidx.core.e.b> c;

    public x(Context context) {
        this(context, null);
    }

    public x(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public x(Context context, AttributeSet attributeSet, int i) {
        super(ap.a(context), attributeSet, i);
        this.f449a = new f(this);
        this.f449a.a(attributeSet, i);
        this.f450b = new w(this);
        this.f450b.a(attributeSet, i);
        this.f450b.a();
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f449a != null) {
            this.f449a.a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f449a != null) {
            this.f449a.a(drawable);
        }
    }

    @Override // androidx.core.g.p
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f449a != null) {
            this.f449a.a(colorStateList);
        }
    }

    @Override // androidx.core.g.p
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f449a != null) {
            return this.f449a.a();
        }
        return null;
    }

    @Override // androidx.core.g.p
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f449a != null) {
            this.f449a.a(mode);
        }
    }

    @Override // androidx.core.g.p
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f449a != null) {
            return this.f449a.b();
        }
        return null;
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f450b != null) {
            this.f450b.a(context, i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f449a != null) {
            this.f449a.c();
        }
        if (this.f450b != null) {
            this.f450b.a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f450b != null) {
            this.f450b.a(z, i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        if (d) {
            super.setTextSize(i, f);
        } else if (this.f450b != null) {
            this.f450b.a(i, f);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (this.f450b == null || d || !this.f450b.c()) {
            return;
        }
        this.f450b.b();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (d) {
            super.setAutoSizeTextTypeWithDefaults(i);
        } else if (this.f450b != null) {
            this.f450b.a(i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (d) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        } else if (this.f450b != null) {
            this.f450b.a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (d) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        } else if (this.f450b != null) {
            this.f450b.a(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (d) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        if (this.f450b != null) {
            return this.f450b.d();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (d) {
            return super.getAutoSizeStepGranularity();
        }
        if (this.f450b != null) {
            return this.f450b.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (d) {
            return super.getAutoSizeMinTextSize();
        }
        if (this.f450b != null) {
            return this.f450b.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (d) {
            return super.getAutoSizeMaxTextSize();
        }
        if (this.f450b != null) {
            return this.f450b.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (d) {
            return super.getAutoSizeTextAvailableSizes();
        }
        if (this.f450b != null) {
            return this.f450b.h();
        }
        return new int[0];
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return l.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i);
        } else {
            androidx.core.widget.i.b(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i);
        } else {
            androidx.core.widget.i.c(this, i);
        }
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return androidx.core.widget.i.b(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return androidx.core.widget.i.c(this);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        androidx.core.widget.i.d(this, i);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.a(this, callback));
    }

    public b.a getTextMetricsParamsCompat() {
        return androidx.core.widget.i.d(this);
    }

    public void setTextMetricsParamsCompat(b.a aVar) {
        androidx.core.widget.i.a(this, aVar);
    }

    public void setPrecomputedText(androidx.core.e.b bVar) {
        androidx.core.widget.i.a(this, bVar);
    }

    private void a() {
        if (this.c != null) {
            try {
                Future<androidx.core.e.b> future = this.c;
                this.c = null;
                androidx.core.widget.i.a(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        a();
        return super.getText();
    }

    public void setTextFuture(Future<androidx.core.e.b> future) {
        this.c = future;
        requestLayout();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        a();
        super.onMeasure(i, i2);
    }
}
