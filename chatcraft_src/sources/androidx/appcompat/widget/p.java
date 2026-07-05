package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.appcompat.a;

/* compiled from: AppCompatMultiAutoCompleteTextView.java */
/* loaded from: classes.dex */
public class p extends MultiAutoCompleteTextView implements androidx.core.g.p {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f422a = {R.attr.popupBackground};

    /* renamed from: b, reason: collision with root package name */
    private final f f423b;
    private final w c;

    public p(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0018a.autoCompleteTextViewStyle);
    }

    public p(Context context, AttributeSet attributeSet, int i) {
        super(ap.a(context), attributeSet, i);
        as asVarA = as.a(getContext(), attributeSet, f422a, i, 0);
        if (asVarA.g(0)) {
            setDropDownBackgroundDrawable(asVarA.a(0));
        }
        asVarA.a();
        this.f423b = new f(this);
        this.f423b.a(attributeSet, i);
        this.c = new w(this);
        this.c.a(attributeSet, i);
        this.c.a();
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f423b != null) {
            this.f423b.a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f423b != null) {
            this.f423b.a(drawable);
        }
    }

    @Override // androidx.core.g.p
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f423b != null) {
            this.f423b.a(colorStateList);
        }
    }

    @Override // androidx.core.g.p
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f423b != null) {
            return this.f423b.a();
        }
        return null;
    }

    @Override // androidx.core.g.p
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f423b != null) {
            this.f423b.a(mode);
        }
    }

    @Override // androidx.core.g.p
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f423b != null) {
            return this.f423b.b();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f423b != null) {
            this.f423b.c();
        }
        if (this.c != null) {
            this.c.a();
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.c != null) {
            this.c.a(context, i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return l.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }
}
