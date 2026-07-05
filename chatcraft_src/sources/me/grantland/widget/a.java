package me.grantland.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.Editable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import me.grantland.widget.b;

/* compiled from: AutofitHelper.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private TextView f5035a;

    /* renamed from: b, reason: collision with root package name */
    private TextPaint f5036b;
    private float c;
    private int d;
    private float e;
    private float f;
    private float g;
    private boolean h;
    private boolean i;
    private ArrayList<c> j;
    private TextWatcher k;
    private View.OnLayoutChangeListener l;

    /* compiled from: AutofitHelper.java */
    public interface c {
        void a(float f, float f2);
    }

    public static a a(TextView textView, AttributeSet attributeSet, int i) {
        a aVar = new a(textView);
        boolean z = true;
        if (attributeSet != null) {
            Context context = textView.getContext();
            int iB = (int) aVar.b();
            float fA = aVar.a();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.a.AutofitTextView, i, 0);
            z = typedArrayObtainStyledAttributes.getBoolean(b.a.AutofitTextView_sizeToFit, true);
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(b.a.AutofitTextView_minTextSize, iB);
            float f = typedArrayObtainStyledAttributes.getFloat(b.a.AutofitTextView_precision, fA);
            typedArrayObtainStyledAttributes.recycle();
            aVar.a(0, dimensionPixelSize).a(f);
        }
        aVar.a(z);
        return aVar;
    }

    private static void a(TextView textView, TextPaint textPaint, float f, float f2, int i, float f3) {
        int width;
        float fA = f2;
        if (i <= 0 || i == Integer.MAX_VALUE || (width = (textView.getWidth() - textView.getPaddingLeft()) - textView.getPaddingRight()) <= 0) {
            return;
        }
        CharSequence text = textView.getText();
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod != null) {
            text = transformationMethod.getTransformation(text, textView);
        }
        Context context = textView.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        DisplayMetrics displayMetrics = system.getDisplayMetrics();
        textPaint.set(textView.getPaint());
        textPaint.setTextSize(f2);
        if ((i == 1 && textPaint.measureText(text, 0, text.length()) > width) || a(text, textPaint, f2, width, displayMetrics) > i) {
            fA = a(text, textPaint, width, i, 0.0f, f2, f3, displayMetrics);
        }
        textView.setTextSize(0, fA < f ? f : fA);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r13v1 ??, still in use, count: 1, list:
          (r13v1 ?? I:android.text.StaticLayout) from 0x002d: INVOKE (r6v8 ?? I:int) = (r13v1 ?? I:android.text.StaticLayout) VIRTUAL call: android.text.StaticLayout.getLineCount():int A[MD:():int (c)] (LINE:154)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    private static float a(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r13v1 ??, still in use, count: 1, list:
          (r13v1 ?? I:android.text.StaticLayout) from 0x002d: INVOKE (r6v8 ?? I:int) = (r13v1 ?? I:android.text.StaticLayout) VIRTUAL call: android.text.StaticLayout.getLineCount():int A[MD:():int (c)] (LINE:154)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r16v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:405)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */

    private static int a(CharSequence charSequence, TextPaint textPaint, float f, float f2, DisplayMetrics displayMetrics) {
        textPaint.setTextSize(TypedValue.applyDimension(0, f, displayMetrics));
        return new StaticLayout(charSequence, textPaint, (int) f2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getLineCount();
    }

    private static int a(TextView textView) {
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod != null && (transformationMethod instanceof SingleLineTransformationMethod)) {
            return 1;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return textView.getMaxLines();
        }
        return -1;
    }

    private a(TextView textView) {
        this.k = new b();
        this.l = new ViewOnLayoutChangeListenerC0119a();
        float f = textView.getContext().getResources().getDisplayMetrics().scaledDensity;
        this.f5035a = textView;
        this.f5036b = new TextPaint();
        e(textView.getTextSize());
        this.d = a(textView);
        this.e = f * 8.0f;
        this.f = this.c;
        this.g = 0.5f;
    }

    public a a(c cVar) {
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.add(cVar);
        return this;
    }

    public float a() {
        return this.g;
    }

    public a a(float f) {
        if (this.g != f) {
            this.g = f;
            d();
        }
        return this;
    }

    public float b() {
        return this.e;
    }

    public a a(int i, float f) {
        Context context = this.f5035a.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        c(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        return this;
    }

    private void c(float f) {
        if (f != this.e) {
            this.e = f;
            d();
        }
    }

    public float c() {
        return this.f;
    }

    public a b(float f) {
        return b(2, f);
    }

    public a b(int i, float f) {
        Context context = this.f5035a.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        d(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        return this;
    }

    private void d(float f) {
        if (f != this.f) {
            this.f = f;
            d();
        }
    }

    public a a(int i) {
        if (this.d != i) {
            this.d = i;
            d();
        }
        return this;
    }

    public a a(boolean z) {
        if (this.h != z) {
            this.h = z;
            if (z) {
                this.f5035a.addTextChangedListener(this.k);
                this.f5035a.addOnLayoutChangeListener(this.l);
                d();
            } else {
                this.f5035a.removeTextChangedListener(this.k);
                this.f5035a.removeOnLayoutChangeListener(this.l);
                this.f5035a.setTextSize(0, this.c);
            }
        }
        return this;
    }

    public void c(int i, float f) {
        if (this.i) {
            return;
        }
        Context context = this.f5035a.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        e(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
    }

    private void e(float f) {
        if (this.c != f) {
            this.c = f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        float textSize = this.f5035a.getTextSize();
        this.i = true;
        a(this.f5035a, this.f5036b, this.e, this.f, this.d, this.g);
        this.i = false;
        float textSize2 = this.f5035a.getTextSize();
        if (textSize2 != textSize) {
            a(textSize2, textSize);
        }
    }

    private void a(float f, float f2) {
        if (this.j == null) {
            return;
        }
        Iterator<c> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().a(f, f2);
        }
    }

    /* compiled from: AutofitHelper.java */
    private class b implements TextWatcher {
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        private b() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            a.this.d();
        }
    }

    /* compiled from: AutofitHelper.java */
    /* renamed from: me.grantland.widget.a$a, reason: collision with other inner class name */
    private class ViewOnLayoutChangeListenerC0119a implements View.OnLayoutChangeListener {
        private ViewOnLayoutChangeListenerC0119a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            a.this.d();
        }
    }
}
