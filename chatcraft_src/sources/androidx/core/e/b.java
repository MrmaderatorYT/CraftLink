package androidx.core.e;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import java.util.concurrent.Executor;

/* compiled from: PrecomputedTextCompat.java */
/* loaded from: classes.dex */
public class b implements Spannable {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f595a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static Executor f596b = null;
    private final Spannable c;
    private final a d;
    private final PrecomputedText e;

    /* compiled from: PrecomputedTextCompat.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final PrecomputedText.Params f597a;

        /* renamed from: b, reason: collision with root package name */
        private final TextPaint f598b;
        private final TextDirectionHeuristic c;
        private final int d;
        private final int e;

        /* compiled from: PrecomputedTextCompat.java */
        /* renamed from: androidx.core.e.b$a$a, reason: collision with other inner class name */
        public static class C0037a {

            /* renamed from: a, reason: collision with root package name */
            private final TextPaint f599a;

            /* renamed from: b, reason: collision with root package name */
            private TextDirectionHeuristic f600b;
            private int c;
            private int d;

            public C0037a(TextPaint textPaint) {
                this.f599a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.c = 1;
                    this.d = 1;
                } else {
                    this.d = 0;
                    this.c = 0;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    this.f600b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f600b = null;
                }
            }

            public C0037a a(int i) {
                this.c = i;
                return this;
            }

            public C0037a b(int i) {
                this.d = i;
                return this;
            }

            public C0037a a(TextDirectionHeuristic textDirectionHeuristic) {
                this.f600b = textDirectionHeuristic;
                return this;
            }

            public a a() {
                return new a(this.f599a, this.f600b, this.c, this.d);
            }
        }

        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.f597a = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f597a = null;
            }
            this.f598b = textPaint;
            this.c = textDirectionHeuristic;
            this.d = i;
            this.e = i2;
        }

        public a(PrecomputedText.Params params) {
            this.f598b = params.getTextPaint();
            this.c = params.getTextDirection();
            this.d = params.getBreakStrategy();
            this.e = params.getHyphenationFrequency();
            this.f597a = params;
        }

        public TextPaint a() {
            return this.f598b;
        }

        public TextDirectionHeuristic b() {
            return this.c;
        }

        public int c() {
            return this.d;
        }

        public int d() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f597a != null) {
                return this.f597a.equals(aVar.f597a);
            }
            if (Build.VERSION.SDK_INT >= 23 && (this.d != aVar.c() || this.e != aVar.d())) {
                return false;
            }
            if ((Build.VERSION.SDK_INT >= 18 && this.c != aVar.b()) || this.f598b.getTextSize() != aVar.a().getTextSize() || this.f598b.getTextScaleX() != aVar.a().getTextScaleX() || this.f598b.getTextSkewX() != aVar.a().getTextSkewX()) {
                return false;
            }
            if ((Build.VERSION.SDK_INT >= 21 && (this.f598b.getLetterSpacing() != aVar.a().getLetterSpacing() || !TextUtils.equals(this.f598b.getFontFeatureSettings(), aVar.a().getFontFeatureSettings()))) || this.f598b.getFlags() != aVar.a().getFlags()) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                if (!this.f598b.getTextLocales().equals(aVar.a().getTextLocales())) {
                    return false;
                }
            } else if (Build.VERSION.SDK_INT >= 17 && !this.f598b.getTextLocale().equals(aVar.a().getTextLocale())) {
                return false;
            }
            if (this.f598b.getTypeface() == null) {
                if (aVar.a().getTypeface() != null) {
                    return false;
                }
            } else if (!this.f598b.getTypeface().equals(aVar.a().getTypeface())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT >= 24) {
                return androidx.core.f.c.a(Float.valueOf(this.f598b.getTextSize()), Float.valueOf(this.f598b.getTextScaleX()), Float.valueOf(this.f598b.getTextSkewX()), Float.valueOf(this.f598b.getLetterSpacing()), Integer.valueOf(this.f598b.getFlags()), this.f598b.getTextLocales(), this.f598b.getTypeface(), Boolean.valueOf(this.f598b.isElegantTextHeight()), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                return androidx.core.f.c.a(Float.valueOf(this.f598b.getTextSize()), Float.valueOf(this.f598b.getTextScaleX()), Float.valueOf(this.f598b.getTextSkewX()), Float.valueOf(this.f598b.getLetterSpacing()), Integer.valueOf(this.f598b.getFlags()), this.f598b.getTextLocale(), this.f598b.getTypeface(), Boolean.valueOf(this.f598b.isElegantTextHeight()), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e));
            }
            if (Build.VERSION.SDK_INT >= 18) {
                return androidx.core.f.c.a(Float.valueOf(this.f598b.getTextSize()), Float.valueOf(this.f598b.getTextScaleX()), Float.valueOf(this.f598b.getTextSkewX()), Integer.valueOf(this.f598b.getFlags()), this.f598b.getTextLocale(), this.f598b.getTypeface(), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e));
            }
            if (Build.VERSION.SDK_INT >= 17) {
                return androidx.core.f.c.a(Float.valueOf(this.f598b.getTextSize()), Float.valueOf(this.f598b.getTextScaleX()), Float.valueOf(this.f598b.getTextSkewX()), Integer.valueOf(this.f598b.getFlags()), this.f598b.getTextLocale(), this.f598b.getTypeface(), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e));
            }
            return androidx.core.f.c.a(Float.valueOf(this.f598b.getTextSize()), Float.valueOf(this.f598b.getTextScaleX()), Float.valueOf(this.f598b.getTextSkewX()), Integer.valueOf(this.f598b.getFlags()), this.f598b.getTypeface(), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f598b.getTextSize());
            sb.append(", textScaleX=" + this.f598b.getTextScaleX());
            sb.append(", textSkewX=" + this.f598b.getTextSkewX());
            if (Build.VERSION.SDK_INT >= 21) {
                sb.append(", letterSpacing=" + this.f598b.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.f598b.isElegantTextHeight());
            }
            if (Build.VERSION.SDK_INT >= 24) {
                sb.append(", textLocale=" + this.f598b.getTextLocales());
            } else if (Build.VERSION.SDK_INT >= 17) {
                sb.append(", textLocale=" + this.f598b.getTextLocale());
            }
            sb.append(", typeface=" + this.f598b.getTypeface());
            if (Build.VERSION.SDK_INT >= 26) {
                sb.append(", variationSettings=" + this.f598b.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.c);
            sb.append(", breakStrategy=" + this.d);
            sb.append(", hyphenationFrequency=" + this.e);
            sb.append("}");
            return sb.toString();
        }
    }

    public PrecomputedText a() {
        if (this.c instanceof PrecomputedText) {
            return (PrecomputedText) this.c;
        }
        return null;
    }

    public a b() {
        return this.d;
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 28) {
            this.e.setSpan(obj, i, i2, i3);
        } else {
            this.c.setSpan(obj, i, i2, i3);
        }
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 28) {
            this.e.removeSpan(obj);
        } else {
            this.c.removeSpan(obj);
        }
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T[]) this.e.getSpans(i, i2, cls);
        }
        return (T[]) this.c.getSpans(i, i2, cls);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.c.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.c.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.c.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.c.nextSpanTransition(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.c.length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.c.charAt(i);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.c.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.c.toString();
    }
}
