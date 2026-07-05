package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.m;

/* loaded from: classes.dex */
public class SeekBarPreference extends Preference {

    /* renamed from: a, reason: collision with root package name */
    int f958a;

    /* renamed from: b, reason: collision with root package name */
    int f959b;
    boolean c;
    SeekBar d;
    boolean e;
    private int f;
    private int g;
    private TextView h;
    private boolean i;
    private SeekBar.OnSeekBarChangeListener j;
    private View.OnKeyListener k;

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.j = new SeekBar.OnSeekBarChangeListener() { // from class: androidx.preference.SeekBarPreference.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i3, boolean z) {
                if (!z || SeekBarPreference.this.c) {
                    return;
                }
                SeekBarPreference.this.a(seekBar);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                SeekBarPreference.this.c = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                SeekBarPreference.this.c = false;
                if (seekBar.getProgress() + SeekBarPreference.this.f959b != SeekBarPreference.this.f958a) {
                    SeekBarPreference.this.a(seekBar);
                }
            }
        };
        this.k = new View.OnKeyListener() { // from class: androidx.preference.SeekBarPreference.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i3, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                if ((!SeekBarPreference.this.e && (i3 == 21 || i3 == 22)) || i3 == 23 || i3 == 66) {
                    return false;
                }
                if (SeekBarPreference.this.d == null) {
                    Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
                    return false;
                }
                return SeekBarPreference.this.d.onKeyDown(i3, keyEvent);
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.g.SeekBarPreference, i, i2);
        this.f959b = typedArrayObtainStyledAttributes.getInt(m.g.SeekBarPreference_min, 0);
        g(typedArrayObtainStyledAttributes.getInt(m.g.SeekBarPreference_android_max, 100));
        h(typedArrayObtainStyledAttributes.getInt(m.g.SeekBarPreference_seekBarIncrement, 0));
        this.e = typedArrayObtainStyledAttributes.getBoolean(m.g.SeekBarPreference_adjustable, true);
        this.i = typedArrayObtainStyledAttributes.getBoolean(m.g.SeekBarPreference_showSeekBarValue, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m.a.seekBarPreferenceStyle);
    }

    @Override // androidx.preference.Preference
    public void a(l lVar) {
        super.a(lVar);
        lVar.f1052a.setOnKeyListener(this.k);
        this.d = (SeekBar) lVar.a(m.c.seekbar);
        this.h = (TextView) lVar.a(m.c.seekbar_value);
        if (this.i) {
            this.h.setVisibility(0);
        } else {
            this.h.setVisibility(8);
            this.h = null;
        }
        if (this.d == null) {
            Log.e("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
            return;
        }
        this.d.setOnSeekBarChangeListener(this.j);
        this.d.setMax(this.f - this.f959b);
        if (this.g != 0) {
            this.d.setKeyProgressIncrement(this.g);
        } else {
            this.g = this.d.getKeyProgressIncrement();
        }
        this.d.setProgress(this.f958a - this.f959b);
        if (this.h != null) {
            this.h.setText(String.valueOf(this.f958a));
        }
        this.d.setEnabled(z());
    }

    @Override // androidx.preference.Preference
    protected void a(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        i(f(((Integer) obj).intValue()));
    }

    @Override // androidx.preference.Preference
    protected Object a(TypedArray typedArray, int i) {
        return Integer.valueOf(typedArray.getInt(i, 0));
    }

    public final void g(int i) {
        if (i < this.f959b) {
            i = this.f959b;
        }
        if (i != this.f) {
            this.f = i;
            j();
        }
    }

    public final void h(int i) {
        if (i != this.g) {
            this.g = Math.min(this.f - this.f959b, Math.abs(i));
            j();
        }
    }

    public void i(int i) {
        a(i, true);
    }

    private void a(int i, boolean z) {
        if (i < this.f959b) {
            i = this.f959b;
        }
        if (i > this.f) {
            i = this.f;
        }
        if (i != this.f958a) {
            this.f958a = i;
            if (this.h != null) {
                this.h.setText(String.valueOf(this.f958a));
            }
            e(i);
            if (z) {
                j();
            }
        }
    }

    void a(SeekBar seekBar) {
        int progress = this.f959b + seekBar.getProgress();
        if (progress != this.f958a) {
            if (b(Integer.valueOf(progress))) {
                a(progress, false);
            } else {
                seekBar.setProgress(this.f958a - this.f959b);
            }
        }
    }

    @Override // androidx.preference.Preference
    protected Parcelable l() {
        Parcelable parcelableL = super.l();
        if (E()) {
            return parcelableL;
        }
        a aVar = new a(parcelableL);
        aVar.f962a = this.f958a;
        aVar.f963b = this.f959b;
        aVar.c = this.f;
        return aVar;
    }

    @Override // androidx.preference.Preference
    protected void a(Parcelable parcelable) {
        if (!parcelable.getClass().equals(a.class)) {
            super.a(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.a(aVar.getSuperState());
        this.f958a = aVar.f962a;
        this.f959b = aVar.f963b;
        this.f = aVar.c;
        j();
    }

    private static class a extends Preference.a {
        public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: androidx.preference.SeekBarPreference.a.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i) {
                return new a[i];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        int f962a;

        /* renamed from: b, reason: collision with root package name */
        int f963b;
        int c;

        public a(Parcel parcel) {
            super(parcel);
            this.f962a = parcel.readInt();
            this.f963b = parcel.readInt();
            this.c = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f962a);
            parcel.writeInt(this.f963b);
            parcel.writeInt(this.c);
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
