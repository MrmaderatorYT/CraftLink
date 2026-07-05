package mattecarra.usavsursschat.SingleInputForms;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.afollestad.materialdialogs.e;
import com.afollestad.materialdialogs.f;
import com.afollestad.materialdialogs.i;
import com.github.steveice10.mc.v1_13_2.protocol.MinecraftConstants;
import com.github.steveice10.mc.v1_5.util.Constants;
import com.github.steveice10.mc.v1_7_7.protocol.ProtocolConstants;
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
public class AddServerForm extends b {
    public static final String[] l = {"Auto Detect", MinecraftConstants.GAME_VERSION, com.github.steveice10.mc.v1_13_1.protocol.MinecraftConstants.GAME_VERSION, com.github.steveice10.mc.v1_13.protocol.MinecraftConstants.GAME_VERSION, com.github.steveice10.mc.v1_12_2.protocol.MinecraftConstants.GAME_VERSION, com.github.steveice10.mc.v1_12_1.protocol.MinecraftConstants.GAME_VERSION, com.github.steveice10.mc.v1_12.protocol.MinecraftConstants.GAME_VERSION, com.github.steveice10.mc.v1_11_2.protocol.MinecraftConstants.GAME_VERSION, com.github.steveice10.mc.v1_11.protocol.MinecraftConstants.GAME_VERSION, com.github.steveice10.mc.v1_10.protocol.MinecraftConstants.GAME_VERSION, com.github.steveice10.mc.v1_9_4.protocol.MinecraftConstants.GAME_VERSION, com.github.steveice10.mc.v1_9_2.protocol.MinecraftConstants.GAME_VERSION, com.github.steveice10.mc.v1_9.protocol.MinecraftConstants.GAME_VERSION, "1.8", "1.7.10", "1.7.9", "1.7.8", ProtocolConstants.GAME_VERSION, "1.7.6", "1.7.5", "1.7.4", "1.7.2", "1.6.4", com.github.steveice10.mc.v1_6_4.protocol.MinecraftConstants.MINECRAFT_VERSION, "1.6.1", "1.5.2", Constants.STANDARD_MINECRAFT_VERSION, "1.5"};
    private int m = -1;
    private c n;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.io.Serializable] */
    public static void a(final LoginActivity loginActivity, Object[]... objArr) {
        if (loginActivity.m().size() >= 3) {
            loginActivity.n();
            if (!a.t()) {
                try {
                    loginActivity.a(new f.a(loginActivity).a(R.string.permium_ask_title).d(R.string.permium_ask_desc).c("Continue").d("Cancel").i(R.color.material_red_400).a(e.CENTER).c(R.color.material_red_400).f(android.R.color.white).o(R.color.material_blue_gray_800_custom).m(R.color.material_teal_500).a(R.drawable.md_btn_selector_custom, com.afollestad.materialdialogs.b.POSITIVE).h(-1).j(android.R.attr.textColorSecondaryInverse).a(i.DARK).a(new f.b() { // from class: mattecarra.usavsursschat.SingleInputForms.AddServerForm.1
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
        }
        Intent intent = new Intent(loginActivity, (Class<?>) AddServerForm.class);
        for (?? r4 : objArr) {
            intent.putExtra(r4[0].toString(), (Serializable) r4);
        }
        loginActivity.startActivityForResult(intent, 4231);
    }

    @Override // com.heinrichreimersoftware.singleinputform.b
    protected List<d> a(Context context) {
        this.n = new c(this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.heinrichreimersoftware.singleinputform.a.e(context, "name", 524289, R.string.name_server_field, R.string.name_server_error, R.string.name_server_description, new e.a() { // from class: mattecarra.usavsursschat.SingleInputForms.AddServerForm.2
            @Override // com.heinrichreimersoftware.singleinputform.a.e.a
            public boolean a(String str) {
                return (AddServerForm.this.n.f(str) || str.length() == 0) ? false : true;
            }
        }));
        arrayList.add(new com.heinrichreimersoftware.singleinputform.a.e(context, "ip", 524289, R.string.ip_server_field, R.string.ip_server_error, R.string.ip_server_description, new e.a() { // from class: mattecarra.usavsursschat.SingleInputForms.AddServerForm.3
            @Override // com.heinrichreimersoftware.singleinputform.a.e.a
            public boolean a(String str) {
                return (str.contains(" ") || str.length() == 0) ? false : true;
            }
        }));
        com.heinrichreimersoftware.singleinputform.a.e eVar = new com.heinrichreimersoftware.singleinputform.a.e(context, "port", 2, R.string.port_server_field, R.string.port_server_error, R.string.port_server_description, new e.a() { // from class: mattecarra.usavsursschat.SingleInputForms.AddServerForm.4
            @Override // com.heinrichreimersoftware.singleinputform.a.e.a
            public boolean a(String str) throws NumberFormatException {
                try {
                    Integer.parseInt(str);
                    return true;
                } catch (NumberFormatException unused) {
                    return str.length() == 0;
                }
            }
        });
        eVar.a("25565");
        arrayList.add(eVar);
        arrayList.add(new com.heinrichreimersoftware.singleinputform.a.b(context, "version", l, R.string.version_server_field, R.string.version_server_error, R.string.version_server_description, new e.b() { // from class: mattecarra.usavsursschat.SingleInputForms.AddServerForm.5
            @Override // com.heinrichreimersoftware.singleinputform.a.e.b
            public void a(String str, final d.a aVar) throws NumberFormatException {
                AddServerForm.this.m = -1;
                if (!TextUtils.isEmpty(str)) {
                    if (str.equals("Auto Detect")) {
                        final f fVarC = new f.a(AddServerForm.this).a("Checking server version").b("Checking server version!").a(true, 0).c();
                        final int i = 25565;
                        try {
                            i = Integer.parseInt(com.heinrichreimersoftware.singleinputform.a.e.b(AddServerForm.this.j, "port"));
                        } catch (Exception unused) {
                        }
                        new Thread(new Runnable() { // from class: mattecarra.usavsursschat.SingleInputForms.AddServerForm.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    AddServerForm.this.m = new mattecarra.usavsursschat.McClient.c().b(com.heinrichreimersoftware.singleinputform.a.e.b(AddServerForm.this.j, "ip"), i);
                                    if (AddServerForm.this.m == 0) {
                                        AddServerForm.this.runOnUiThread(new Runnable() { // from class: mattecarra.usavsursschat.SingleInputForms.AddServerForm.5.1.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                fVarC.cancel();
                                                aVar.a("Could not fetch server version!");
                                            }
                                        });
                                        return;
                                    }
                                    System.out.println("Result version = " + AddServerForm.this.m);
                                    AddServerForm.this.runOnUiThread(new Runnable() { // from class: mattecarra.usavsursschat.SingleInputForms.AddServerForm.5.1.3
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            fVarC.cancel();
                                            aVar.a();
                                        }
                                    });
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                    AddServerForm.this.runOnUiThread(new Runnable() { // from class: mattecarra.usavsursschat.SingleInputForms.AddServerForm.5.1.2
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            fVarC.cancel();
                                            aVar.a("Could not fetch server version!");
                                        }
                                    });
                                }
                            }
                        }).start();
                        return;
                    }
                    aVar.a();
                    return;
                }
                aVar.b();
            }
        }));
        return arrayList;
    }

    @Override // com.heinrichreimersoftware.singleinputform.b
    protected HashMap<d, com.heinrichreimersoftware.singleinputform.a.c> b(Context context) {
        return new HashMap<>();
    }

    @Override // com.heinrichreimersoftware.singleinputform.b
    protected void a(Bundle bundle) {
        try {
            String strB = com.heinrichreimersoftware.singleinputform.a.e.b(bundle, "name");
            String strB2 = com.heinrichreimersoftware.singleinputform.a.e.b(bundle, "ip");
            String strB3 = com.heinrichreimersoftware.singleinputform.a.e.b(bundle, "port");
            int iC = !(this.m == -1) ? this.m : mattecarra.usavsursschat.i.e.c(l[com.heinrichreimersoftware.singleinputform.a.b.a(bundle, "version")]);
            this.m = -1;
            this.n.a(new mattecarra.usavsursschat.b.c(strB, strB2, mattecarra.usavsursschat.i.e.g(strB3), iC));
            Intent intent = new Intent();
            intent.putExtra("name", strB);
            setResult(-1, intent);
        } catch (Exception e) {
            e.printStackTrace();
            setResult(0);
        }
    }

    @Override // com.heinrichreimersoftware.singleinputform.b, androidx.fragment.app.d, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }
}
