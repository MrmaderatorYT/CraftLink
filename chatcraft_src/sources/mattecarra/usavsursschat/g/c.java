package mattecarra.usavsursschat.g;

import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.afollestad.materialdialogs.f;
import java.io.IOException;
import java.util.Arrays;
import mattecarra.usavsursschat.LoginActivity;
import mattecarra.usavsursschat.SingleInputForms.AddServerForm;
import mattecarra.usavsursschat.i.e;
import me.zhanghai.android.materialprogressbar.R;
import org.json.JSONException;

/* compiled from: EditServerDialog.java */
/* loaded from: classes.dex */
public class c implements f.j {

    /* renamed from: a, reason: collision with root package name */
    private LoginActivity f5008a;

    /* renamed from: b, reason: collision with root package name */
    private f f5009b;
    private a c;
    private mattecarra.usavsursschat.b.c d;

    /* compiled from: EditServerDialog.java */
    public interface a {
        void a(String str, mattecarra.usavsursschat.b.c cVar);
    }

    public c(mattecarra.usavsursschat.b.c cVar, LoginActivity loginActivity, a aVar) {
        this.f5008a = loginActivity;
        this.c = aVar;
        this.d = cVar;
        this.f5009b = new f.a(loginActivity).a("Edit Server").b(R.layout.edit_server_dialog, true).c("Change").k(android.R.string.cancel).a(this).b();
        ((EditText) this.f5009b.findViewById(R.id.serverAddress)).setText(cVar.b() + ":" + cVar.c());
        ArrayAdapter arrayAdapter = new ArrayAdapter(loginActivity, android.R.layout.simple_spinner_item, AddServerForm.l);
        Spinner spinner = (Spinner) this.f5009b.findViewById(R.id.serverVersion);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        int iIndexOf = Arrays.asList(AddServerForm.l).indexOf(e.a(cVar.d()));
        if (iIndexOf != -1) {
            spinner.setSelection(iIndexOf);
        }
        ((EditText) this.f5009b.findViewById(R.id.serverName)).setText(cVar.a());
    }

    public f a() {
        return this.f5009b;
    }

    public f b() {
        this.f5009b.show();
        return this.f5009b;
    }

    @Override // com.afollestad.materialdialogs.f.j
    public void a(f fVar, com.afollestad.materialdialogs.b bVar) throws JSONException, NumberFormatException {
        String strA = this.d.a();
        String string = ((EditText) fVar.findViewById(R.id.serverName)).getText().toString();
        String string2 = ((EditText) fVar.findViewById(R.id.serverAddress)).getText().toString();
        String[] strArrSplit = string2.split(":");
        int i = 25565;
        if (strArrSplit.length > 1) {
            try {
                int i2 = Integer.parseInt(strArrSplit[1]);
                try {
                    string2 = strArrSplit[0];
                    i = i2;
                } catch (Exception e) {
                    e = e;
                    i = i2;
                    e.printStackTrace();
                    mattecarra.usavsursschat.b.c cVar = new mattecarra.usavsursschat.b.c(string, string2, i, e.c((String) ((Spinner) fVar.findViewById(R.id.serverVersion)).getSelectedItem()));
                    this.f5008a.s().a(strA, cVar);
                    this.c.a(strA, cVar);
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        mattecarra.usavsursschat.b.c cVar2 = new mattecarra.usavsursschat.b.c(string, string2, i, e.c((String) ((Spinner) fVar.findViewById(R.id.serverVersion)).getSelectedItem()));
        try {
            this.f5008a.s().a(strA, cVar2);
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        this.c.a(strA, cVar2);
    }
}
