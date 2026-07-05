package mattecarra.usavsursschat.g;

import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.afollestad.materialdialogs.f;
import java.util.ArrayList;
import java.util.Iterator;
import mattecarra.usavsursschat.activities.CrackedPasswordManagerActivity;
import me.zhanghai.android.materialprogressbar.R;
import org.json.JSONException;

/* compiled from: CrackedPasswordtDialog.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private f f4993a;

    /* renamed from: b, reason: collision with root package name */
    private CrackedPasswordManagerActivity f4994b;

    public a(final String str, CrackedPasswordManagerActivity crackedPasswordManagerActivity) {
        this.f4994b = crackedPasswordManagerActivity;
        this.f4993a = new f.a(crackedPasswordManagerActivity).a("Add Auth Password").b(R.layout.add_cracked_password, true).c("Set").k(android.R.string.cancel).b(new f.j() { // from class: mattecarra.usavsursschat.g.a.2
            @Override // com.afollestad.materialdialogs.f.j
            public void a(f fVar, com.afollestad.materialdialogs.b bVar) {
                if (bVar != com.afollestad.materialdialogs.b.POSITIVE) {
                    a.this.f4994b.k();
                }
            }
        }).a(new f.j() { // from class: mattecarra.usavsursschat.g.a.1
            @Override // com.afollestad.materialdialogs.f.j
            public void a(f fVar, com.afollestad.materialdialogs.b bVar) throws JSONException {
                Spinner spinner = (Spinner) fVar.findViewById(R.id.cracked_password_server_spinner);
                a.this.f4994b.j.a((String) spinner.getSelectedItem(), str, ((EditText) fVar.findViewById(R.id.cracked_password)).getText().toString());
                a.this.f4994b.k();
            }
        }).b();
        ArrayList<mattecarra.usavsursschat.b.c> arrayListB = new mattecarra.usavsursschat.i.c(crackedPasswordManagerActivity).b();
        ArrayList arrayList = new ArrayList();
        arrayList.add("mc.usavsurss.com");
        Iterator<mattecarra.usavsursschat.b.c> it = arrayListB.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().b());
        }
        ((Spinner) this.f4993a.findViewById(R.id.cracked_password_server_spinner)).setAdapter((SpinnerAdapter) new ArrayAdapter(crackedPasswordManagerActivity, android.R.layout.simple_spinner_item, arrayList));
    }

    public f a() {
        this.f4993a.show();
        return this.f4993a;
    }
}
