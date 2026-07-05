package mattecarra.usavsursschat.SingleInputForms;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.afollestad.materialdialogs.f;
import com.afollestad.materialdialogs.i;
import com.heinrichreimersoftware.singleinputform.a.a;
import com.heinrichreimersoftware.singleinputform.a.d;
import com.heinrichreimersoftware.singleinputform.a.e;
import com.heinrichreimersoftware.singleinputform.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mattecarra.usavsursschat.InAppPurchase.a;
import mattecarra.usavsursschat.LoginActivity;
import mattecarra.usavsursschat.i.c;
import me.zhanghai.android.materialprogressbar.R;

/* loaded from: classes.dex */
public class AddAccountForm extends b {
    private e n;
    private c p;
    private HashMap<d, com.heinrichreimersoftware.singleinputform.a.c> l = new HashMap<>();
    private f m = null;
    private mattecarra.usavsursschat.b.e o = new mattecarra.usavsursschat.b.e();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.io.Serializable] */
    public static void a(final LoginActivity loginActivity, Object[]... objArr) {
        if (loginActivity.l().size() >= 1 && !a.t()) {
            try {
                loginActivity.a(new f.a(loginActivity).a(R.string.permium_ask_title).d(R.string.pro_account_add).c("Continue").d("Cancel").i(R.color.material_red_400).a(com.afollestad.materialdialogs.e.CENTER).c(R.color.material_red_400).f(android.R.color.white).o(R.color.material_blue_gray_800_custom).m(R.color.material_teal_500).a(R.drawable.md_btn_selector_custom, com.afollestad.materialdialogs.b.POSITIVE).h(-1).j(android.R.attr.textColorSecondaryInverse).a(i.DARK).a(new f.b() { // from class: mattecarra.usavsursschat.SingleInputForms.AddAccountForm.1
                    @Override // com.afollestad.materialdialogs.f.b
                    public void b(f fVar) {
                        super.b(fVar);
                        try {
                            loginActivity.n().e("chatcraft_pro_features");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }));
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        Intent intent = new Intent(loginActivity, (Class<?>) AddAccountForm.class);
        for (?? r4 : objArr) {
            intent.putExtra(r4[0].toString(), (Serializable) r4);
        }
        loginActivity.startActivityForResult(intent, 4321);
    }

    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, android.app.Activity
    protected void onDestroy() {
        try {
            if (this.m != null && this.m.isShowing()) {
                this.m.cancel();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }

    @Override // com.heinrichreimersoftware.singleinputform.b
    protected List<d> a(Context context) {
        this.p = new c(this);
        ArrayList arrayList = new ArrayList();
        this.n = new e(context, "username", 524320, R.string.name_account_field, R.string.name_account_error, R.string.name_account_description, new e.a() { // from class: mattecarra.usavsursschat.SingleInputForms.AddAccountForm.2
            @Override // com.heinrichreimersoftware.singleinputform.a.e.a
            public boolean a(String str) {
                return (AddAccountForm.this.p.d(str) || str.contains(" ") || str.length() == 0) ? false : true;
            }
        });
        arrayList.add(this.n);
        arrayList.add(new com.heinrichreimersoftware.singleinputform.a.a(context, "premium_account", R.string.password_premium_checkbox_field, R.string.password_premium_checkbox_field, R.string.password_premium_checkbox_error, R.string.password_premiumt_checkbox_description, new a.InterfaceC0090a() { // from class: mattecarra.usavsursschat.SingleInputForms.AddAccountForm.3
            @Override // com.heinrichreimersoftware.singleinputform.a.a.InterfaceC0090a
            public boolean a(boolean z) {
                if (!z) {
                    try {
                        if (e.b(AddAccountForm.this.j, "username").contains("@")) {
                            Toast.makeText(AddAccountForm.this, R.string.error_email, 1).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }
        }));
        e eVar = new e(context, "premium_account_password", 129, R.string.password_premium_field, R.string.password_premium_error, R.string.password_premium_description, new AnonymousClass4());
        arrayList.add(eVar);
        this.l.put(eVar, new com.heinrichreimersoftware.singleinputform.a.c() { // from class: mattecarra.usavsursschat.SingleInputForms.AddAccountForm.5
            @Override // com.heinrichreimersoftware.singleinputform.a.c
            public boolean a() {
                return com.heinrichreimersoftware.singleinputform.a.a.a(AddAccountForm.this.j, "premium_account");
            }
        });
        return arrayList;
    }

    /* renamed from: mattecarra.usavsursschat.SingleInputForms.AddAccountForm$4, reason: invalid class name */
    class AnonymousClass4 implements e.b {
        AnonymousClass4() {
        }

        @Override // com.heinrichreimersoftware.singleinputform.a.e.b
        public void a(final String str, final d.a aVar) {
            try {
                AddAccountForm.this.m = new f.a(AddAccountForm.this).a("Checking credential").b("Checking credentials!").a(true, 0).c();
            } catch (Exception e) {
                e.printStackTrace();
                AddAccountForm.this.m = null;
            }
            final String strB = e.b(AddAccountForm.this.j, "username");
            new Thread(new Runnable() { // from class: mattecarra.usavsursschat.SingleInputForms.AddAccountForm.4.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        mattecarra.usavsursschat.b.e eVarA = mattecarra.usavsursschat.i.e.a(strB, str);
                        if (eVarA != null) {
                            AddAccountForm.this.o.b(eVarA.c());
                            AddAccountForm.this.o.a(eVarA.a());
                            AddAccountForm.this.o.a(true);
                            AddAccountForm.this.o.e(eVarA.f());
                            AddAccountForm.this.o.c(eVarA.d());
                            AddAccountForm.this.o.d(eVarA.e());
                            AddAccountForm.this.runOnUiThread(new Runnable() { // from class: mattecarra.usavsursschat.SingleInputForms.AddAccountForm.4.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (AddAccountForm.this.m != null) {
                                        AddAccountForm.this.m.cancel();
                                    }
                                    aVar.a();
                                }
                            });
                        } else {
                            AddAccountForm.this.runOnUiThread(new Runnable() { // from class: mattecarra.usavsursschat.SingleInputForms.AddAccountForm.4.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (AddAccountForm.this.m != null) {
                                        AddAccountForm.this.m.cancel();
                                    }
                                    aVar.a("Invalid credentials!");
                                    if (strB.contains("@")) {
                                        return;
                                    }
                                    Toast.makeText(AddAccountForm.this, R.string.error_name, 1).show();
                                }
                            });
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }).start();
        }
    }

    @Override // com.heinrichreimersoftware.singleinputform.b
    protected HashMap<d, com.heinrichreimersoftware.singleinputform.a.c> b(Context context) {
        return this.l;
    }

    @Override // com.heinrichreimersoftware.singleinputform.b
    protected void a(Bundle bundle) {
        try {
            if (!this.o.b()) {
                this.o.a(e.b(bundle, "username"));
            }
            this.p.a(this.o);
            Intent intent = new Intent();
            intent.putExtra("username", this.o.a());
            setResult(-1, intent);
        } catch (Throwable th) {
            th.printStackTrace();
            setResult(0);
        }
    }

    @Override // com.heinrichreimersoftware.singleinputform.b, androidx.fragment.app.d, android.app.Activity
    public void onBackPressed() {
        if (getIntent().getBooleanExtra("obbligatorio", false)) {
            if (k().equals(this.n)) {
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.HOME");
                intent.setFlags(67108864);
                startActivity(intent);
                return;
            }
            super.onBackPressed();
            return;
        }
        super.onBackPressed();
    }
}
