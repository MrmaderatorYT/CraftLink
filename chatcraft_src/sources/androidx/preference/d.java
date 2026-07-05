package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.b;
import androidx.preference.internal.AbstractMultiSelectListPreference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* compiled from: MultiSelectListPreferenceDialogFragmentCompat.java */
/* loaded from: classes.dex */
public class d extends f {
    Set<String> ag = new HashSet();
    boolean ah;
    CharSequence[] ai;
    CharSequence[] aj;

    public static d b(String str) {
        d dVar = new d();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        dVar.g(bundle);
        return dVar;
    }

    @Override // androidx.preference.f, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        if (bundle == null) {
            AbstractMultiSelectListPreference abstractMultiSelectListPreferenceAg = ag();
            if (abstractMultiSelectListPreferenceAg.i() == null || abstractMultiSelectListPreferenceAg.m() == null) {
                throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
            }
            this.ag.clear();
            this.ag.addAll(abstractMultiSelectListPreferenceAg.n());
            this.ah = false;
            this.ai = abstractMultiSelectListPreferenceAg.i();
            this.aj = abstractMultiSelectListPreferenceAg.m();
            return;
        }
        this.ag.clear();
        this.ag.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
        this.ah = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
        this.ai = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
        this.aj = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
    }

    @Override // androidx.preference.f, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void e(Bundle bundle) {
        super.e(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList<>(this.ag));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.ah);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.ai);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.aj);
    }

    private AbstractMultiSelectListPreference ag() {
        return (AbstractMultiSelectListPreference) af();
    }

    @Override // androidx.preference.f
    protected void a(b.a aVar) {
        super.a(aVar);
        int length = this.aj.length;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            zArr[i] = this.ag.contains(this.aj[i].toString());
        }
        aVar.a(this.ai, zArr, new DialogInterface.OnMultiChoiceClickListener() { // from class: androidx.preference.d.1
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public void onClick(DialogInterface dialogInterface, int i2, boolean z) {
                if (z) {
                    d dVar = d.this;
                    dVar.ah = d.this.ag.add(d.this.aj[i2].toString()) | dVar.ah;
                } else {
                    d dVar2 = d.this;
                    dVar2.ah = d.this.ag.remove(d.this.aj[i2].toString()) | dVar2.ah;
                }
            }
        });
    }

    @Override // androidx.preference.f
    public void k(boolean z) {
        AbstractMultiSelectListPreference abstractMultiSelectListPreferenceAg = ag();
        if (z && this.ah) {
            Set<String> set = this.ag;
            if (abstractMultiSelectListPreferenceAg.b((Object) set)) {
                abstractMultiSelectListPreferenceAg.a(set);
            }
        }
        this.ah = false;
    }
}
