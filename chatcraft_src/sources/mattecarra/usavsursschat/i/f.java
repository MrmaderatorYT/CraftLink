package mattecarra.usavsursschat.i;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.afollestad.materialdialogs.f;
import mattecarra.usavsursschat.LoginActivity;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import me.zhanghai.android.materialprogressbar.R;

/* compiled from: UpdateMinecraftPremiumProfile.java */
/* loaded from: classes.dex */
public class f {
    public static void a(LoginActivity loginActivity, String str) {
        System.out.println("updateMinecraftPremiumProfile " + str);
        if (!loginActivity.s().a(str)) {
            System.out.println("Isn't premium. Skipping " + str);
            return;
        }
        System.out.println("It's ok");
        com.afollestad.materialdialogs.f fVarB = new f.a(loginActivity).a("Edit Account").b(R.layout.edit_account_premium, true).c("Change").k(android.R.string.cancel).a(new AnonymousClass1(loginActivity, str)).b();
        try {
            ((EditText) fVarB.findViewById(R.id.loginName)).setText(loginActivity.s().b(str).getString("email"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Shwoing alert!");
        loginActivity.b(fVarB);
    }

    /* compiled from: UpdateMinecraftPremiumProfile.java */
    /* renamed from: mattecarra.usavsursschat.i.f$1, reason: invalid class name */
    static class AnonymousClass1 implements f.j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LoginActivity f5023a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f5024b;

        AnonymousClass1(LoginActivity loginActivity, String str) {
            this.f5023a = loginActivity;
            this.f5024b = str;
        }

        @Override // com.afollestad.materialdialogs.f.j
        public void a(com.afollestad.materialdialogs.f fVar, com.afollestad.materialdialogs.b bVar) {
            try {
                final String string = ((EditText) fVar.findViewById(R.id.loginName)).getText().toString();
                final String string2 = ((EditText) fVar.findViewById(R.id.password_premium)).getText().toString();
                if (!string2.trim().equals(BuildConfig.FLAVOR)) {
                    Toast.makeText(this.f5023a, "Checking credentials! Please wait!", 0).show();
                    new Thread(new Runnable() { // from class: mattecarra.usavsursschat.i.f.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                AnonymousClass1.this.f5023a.s().c(AnonymousClass1.this.f5024b);
                                mattecarra.usavsursschat.b.e eVarA = e.a(string, string2);
                                if (eVarA != null) {
                                    if (eVarA.a().equals(AnonymousClass1.this.f5024b)) {
                                        AnonymousClass1.this.f5023a.s().a(AnonymousClass1.this.f5024b, eVarA);
                                    } else {
                                        AnonymousClass1.this.f5023a.s().b(AnonymousClass1.this.f5024b, eVarA);
                                    }
                                    AnonymousClass1.this.f5023a.runOnUiThread(new Runnable() { // from class: mattecarra.usavsursschat.i.f.1.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            try {
                                                Toast.makeText(AnonymousClass1.this.f5023a, "Account should be ok now!!", 0).show();
                                            } catch (Throwable th) {
                                                th.printStackTrace();
                                            }
                                        }
                                    });
                                    return;
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            AnonymousClass1.this.f5023a.runOnUiThread(new Runnable() { // from class: mattecarra.usavsursschat.i.f.1.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        Toast.makeText(AnonymousClass1.this.f5023a, "Account validation failed :(", 0).show();
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            });
                        }
                    }).start();
                } else {
                    this.f5023a.a("Your password is invalid. Could not update premium credentials!", "Close", -16777216, -1, -65536, (View.OnClickListener) null).e();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
