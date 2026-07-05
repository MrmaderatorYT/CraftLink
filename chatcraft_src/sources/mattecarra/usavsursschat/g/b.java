package mattecarra.usavsursschat.g;

import android.os.AsyncTask;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import com.afollestad.materialdialogs.f;
import mattecarra.usavsursschat.LoginActivity;
import mattecarra.usavsursschat.activities.CrackedPasswordManagerActivity;
import mattecarra.usavsursschat.b.e;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import me.zhanghai.android.materialprogressbar.R;

/* compiled from: EditAccountDialog.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private LoginActivity f4998a;

    /* renamed from: b, reason: collision with root package name */
    private f f4999b;
    private InterfaceC0115b c;

    /* compiled from: EditAccountDialog.java */
    /* renamed from: mattecarra.usavsursschat.g.b$b, reason: collision with other inner class name */
    public interface InterfaceC0115b {
        void a();

        void a(String str, e eVar);
    }

    public b(final e eVar, final LoginActivity loginActivity, InterfaceC0115b interfaceC0115b) {
        this.f4998a = loginActivity;
        this.c = interfaceC0115b;
        this.f4999b = new f.a(loginActivity).a("Edit Account").b(R.layout.edit_account, true).c("Change").k(android.R.string.cancel).a(new f.j() { // from class: mattecarra.usavsursschat.g.b.1
            @Override // com.afollestad.materialdialogs.f.j
            public void a(f fVar, com.afollestad.materialdialogs.b bVar) {
                try {
                    boolean zIsChecked = ((CheckBox) fVar.findViewById(R.id.premium_account)).isChecked();
                    String strA = eVar.a();
                    String string = ((EditText) fVar.findViewById(R.id.loginName)).getText().toString();
                    String string2 = zIsChecked ? ((EditText) fVar.findViewById(R.id.password_premium)).getText().toString() : BuildConfig.FLAVOR;
                    if (!zIsChecked || string2.trim().equals(BuildConfig.FLAVOR)) {
                        b.this.c.a(strA, new e(string));
                        return;
                    }
                    try {
                        b.this.new a(string, string2, strA).execute(new Void[0]);
                    } catch (Throwable th) {
                        com.crashlytics.android.a.a(th);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).b();
        ((EditText) this.f4999b.findViewById(R.id.loginName)).setText(eVar.a());
        final EditText editText = (EditText) this.f4999b.findViewById(R.id.password_premium);
        ((CheckBox) this.f4999b.findViewById(R.id.premium_account)).setChecked(eVar.b());
        editText.setEnabled(eVar.b());
        this.f4999b.findViewById(R.id.cracked_password).setOnClickListener(new View.OnClickListener() { // from class: mattecarra.usavsursschat.g.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.f4999b.dismiss();
                CrackedPasswordManagerActivity.a(loginActivity, eVar.a());
            }
        });
        ((CheckBox) this.f4999b.findViewById(R.id.premium_account)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: mattecarra.usavsursschat.g.b.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                editText.setEnabled(z);
            }
        });
    }

    public f a() {
        this.f4999b.show();
        return this.f4999b;
    }

    /* compiled from: EditAccountDialog.java */
    class a extends AsyncTask<Void, Void, e> {

        /* renamed from: b, reason: collision with root package name */
        private String f5007b;
        private String c;
        private String d;

        public a(String str, String str2, String str3) {
            this.f5007b = str3;
            this.d = str2;
            this.c = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(e eVar) {
            if (eVar != null) {
                b.this.c.a(this.f5007b, eVar);
            } else {
                b.this.c.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e doInBackground(Void... voidArr) {
            e eVarA = mattecarra.usavsursschat.i.e.a(this.c, this.d);
            if (eVarA != null) {
                return eVarA;
            }
            return null;
        }
    }
}
