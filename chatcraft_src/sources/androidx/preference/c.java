package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.b;

/* compiled from: ListPreferenceDialogFragmentCompat.java */
/* loaded from: classes.dex */
public class c extends f {
    int ag;
    private CharSequence[] ah;
    private CharSequence[] ai;

    public static c b(String str) {
        c cVar = new c();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        cVar.g(bundle);
        return cVar;
    }

    @Override // androidx.preference.f, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        if (bundle == null) {
            ListPreference listPreferenceAg = ag();
            if (listPreferenceAg.m() == null || listPreferenceAg.n() == null) {
                throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
            }
            this.ag = listPreferenceAg.c(listPreferenceAg.p());
            this.ah = listPreferenceAg.m();
            this.ai = listPreferenceAg.n();
            return;
        }
        this.ag = bundle.getInt("ListPreferenceDialogFragment.index", 0);
        this.ah = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
        this.ai = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
    }

    @Override // androidx.preference.f, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void e(Bundle bundle) {
        super.e(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.ag);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.ah);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.ai);
    }

    private ListPreference ag() {
        return (ListPreference) af();
    }

    @Override // androidx.preference.f
    protected void a(b.a aVar) {
        super.a(aVar);
        aVar.a(this.ah, this.ag, new DialogInterface.OnClickListener() { // from class: androidx.preference.c.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                c.this.ag = i;
                c.this.onClick(dialogInterface, -1);
                dialogInterface.dismiss();
            }
        });
        aVar.a((CharSequence) null, (DialogInterface.OnClickListener) null);
    }

    @Override // androidx.preference.f
    public void k(boolean z) {
        ListPreference listPreferenceAg = ag();
        if (!z || this.ag < 0) {
            return;
        }
        String string = this.ai[this.ag].toString();
        if (listPreferenceAg.b((Object) string)) {
            listPreferenceAg.b(string);
        }
    }
}
