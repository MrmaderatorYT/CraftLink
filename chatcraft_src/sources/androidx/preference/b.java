package androidx.preference;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/* compiled from: EditTextPreferenceDialogFragmentCompat.java */
/* loaded from: classes.dex */
public class b extends f {
    private EditText ag;
    private CharSequence ah;

    @Override // androidx.preference.f
    protected boolean ae() {
        return true;
    }

    public static b b(String str) {
        b bVar = new b();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        bVar.g(bundle);
        return bVar;
    }

    @Override // androidx.preference.f, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        if (bundle == null) {
            this.ah = ag().i();
        } else {
            this.ah = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }

    @Override // androidx.preference.f, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void e(Bundle bundle) {
        super.e(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.ah);
    }

    @Override // androidx.preference.f
    protected void b(View view) {
        super.b(view);
        this.ag = (EditText) view.findViewById(R.id.edit);
        this.ag.requestFocus();
        if (this.ag == null) {
            throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
        }
        this.ag.setText(this.ah);
        this.ag.setSelection(this.ag.getText().length());
    }

    private EditTextPreference ag() {
        return (EditTextPreference) af();
    }

    @Override // androidx.preference.f
    public void k(boolean z) {
        if (z) {
            String string = this.ag.getText().toString();
            if (ag().b((Object) string)) {
                ag().a(string);
            }
        }
    }
}
