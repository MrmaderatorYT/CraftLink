package androidx.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.preference.m;

/* loaded from: classes.dex */
public class DropDownPreference extends ListPreference {

    /* renamed from: a, reason: collision with root package name */
    private final Context f939a;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayAdapter f940b;
    private Spinner c;
    private final AdapterView.OnItemSelectedListener d;

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m.a.dropdownPreferenceStyle);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.d = new AdapterView.OnItemSelectedListener() { // from class: androidx.preference.DropDownPreference.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j) {
                if (i3 >= 0) {
                    String string = DropDownPreference.this.n()[i3].toString();
                    if (string.equals(DropDownPreference.this.p()) || !DropDownPreference.this.b((Object) string)) {
                        return;
                    }
                    DropDownPreference.this.b(string);
                }
            }
        };
        this.f939a = context;
        this.f940b = i();
        Q();
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    protected void h() {
        this.c.performClick();
    }

    protected ArrayAdapter i() {
        return new ArrayAdapter(this.f939a, R.layout.simple_spinner_dropdown_item);
    }

    private void Q() {
        this.f940b.clear();
        if (m() != null) {
            for (CharSequence charSequence : m()) {
                this.f940b.add(charSequence.toString());
            }
        }
    }

    public int a(String str) {
        CharSequence[] charSequenceArrN = n();
        if (str == null || charSequenceArrN == null) {
            return -1;
        }
        for (int length = charSequenceArrN.length - 1; length >= 0; length--) {
            if (charSequenceArrN[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    @Override // androidx.preference.Preference
    protected void j() {
        super.j();
        this.f940b.notifyDataSetChanged();
    }

    @Override // androidx.preference.Preference
    public void a(l lVar) {
        this.c = (Spinner) lVar.f1052a.findViewById(m.c.spinner);
        this.c.setAdapter((SpinnerAdapter) this.f940b);
        this.c.setOnItemSelectedListener(this.d);
        this.c.setSelection(a(p()));
        super.a(lVar);
    }
}
