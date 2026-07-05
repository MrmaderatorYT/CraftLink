package mattecarra.usavsursschat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.g;
import androidx.core.app.j;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.h;
import androidx.fragment.app.m;
import androidx.viewpager.widget.ViewPager;
import com.afollestad.materialdialogs.f;
import java.io.File;
import java.io.FileWriter;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import mattecarra.usavsursschat.BroadcastReceiver.NotificationReceivers;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import me.zhanghai.android.materialprogressbar.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ChatCraftActivity extends b implements h.b {
    public static PublicKey j;
    public static com.google.gson.f k;
    private String A;
    private String B;
    private int C;
    private int D;
    private mattecarra.usavsursschat.McClient.a E;
    private JSONArray G;
    private mattecarra.usavsursschat.f.b H;
    private mattecarra.usavsursschat.c.e K;
    private a w;
    private ViewPager x;
    private String y;
    private String z;
    private final String v = "minecraft_client_fragment";
    private boolean F = false;
    private AtomicBoolean I = new AtomicBoolean(false);
    private AtomicBoolean J = new AtomicBoolean(false);
    public final String l = "conneced_notification";

    public mattecarra.usavsursschat.InAppPurchase.a p() {
        return this;
    }

    private void y() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("conneced_notification", "NotesOnline", 3);
            notificationChannel.setDescription("Prevents the app from being killed while it's connected to a server");
            ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
        }
    }

    public void k() {
        System.out.println("UVUVUEFE");
        try {
            Intent intent = new Intent(this, (Class<?>) NotificationReceivers.class);
            intent.setAction("disconnect");
            PendingIntent broadcast = PendingIntent.getBroadcast(this, 12345, intent, 134217728);
            y();
            j.a(this).a(1, new g.b(this, "conneced_notification").a(R.drawable.ic_notification).a(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)).a("ChatCraft is on").b(true).a(android.R.drawable.ic_menu_close_clear_cancel, "Disconnect", broadcast).a(true).b("This should prevent random disconnect!").b());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void l() {
        try {
            ((NotificationManager) getSystemService("notification")).cancel(1);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // mattecarra.usavsursschat.b, mattecarra.usavsursschat.InAppPurchase.a, androidx.appcompat.app.c, androidx.fragment.app.d, androidx.core.app.d, android.app.Activity
    protected void onCreate(Bundle bundle) throws Throwable {
        super.onCreate(bundle);
        try {
            ChatCraftApplication.f4809a.a(this);
        } catch (IllegalArgumentException unused) {
        }
        d.a(this);
        z();
        setContentView(R.layout.activity_chat_craft);
        Intent intent = getIntent();
        this.z = intent.getStringExtra("username");
        this.y = intent.getStringExtra("serverName");
        this.B = intent.getStringExtra("ip");
        this.C = intent.getIntExtra("port", 25565);
        this.D = intent.getIntExtra("version", mattecarra.usavsursschat.i.e.a());
        this.H = new mattecarra.usavsursschat.f.b(this);
        if (this.n.e()) {
            this.A = this.H.b(this.B, this.z);
        }
        h hVarJ = j();
        this.K = (mattecarra.usavsursschat.c.e) hVarJ.a("minecraft_client_fragment");
        if (this.K == null) {
            this.K = mattecarra.usavsursschat.c.e.a(this.y, this.B, this.C, this.D, this.z, this.A);
            hVarJ.a().a(this.K, "minecraft_client_fragment").c();
        }
        j().a(this);
        k();
        this.E = this.K.ak();
        try {
            a((Toolbar) findViewById(R.id.toolbar));
            a().b(true);
            a().a(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.w = new a(j());
        this.x = (ViewPager) findViewById(R.id.container);
        this.x.setAdapter(this.w);
        this.x.a(new ViewPager.f() { // from class: mattecarra.usavsursschat.ChatCraftActivity.1
            @Override // androidx.viewpager.widget.ViewPager.f
            public void a(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.f
            public void b(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.f
            public void a(int i, float f, int i2) {
                View currentFocus = ChatCraftActivity.this.getCurrentFocus();
                if (currentFocus != null) {
                    ((InputMethodManager) ChatCraftActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                }
            }
        });
    }

    public void b(int i) throws Resources.NotFoundException {
        this.x.a(i, true);
    }

    @com.squareup.a.h
    public void messageReceived(mattecarra.usavsursschat.a.a.a.d dVar) {
        if (this.F || (v() && this.n.c())) {
            this.F = true;
            if (this.G == null) {
                this.G = new JSONArray();
            }
            this.G.put(dVar.a().toJsonString());
        }
    }

    @com.squareup.a.h
    public void onAsyncMessagePacket(mattecarra.usavsursschat.a.a.a.a aVar) {
        if (this.E.g()) {
            return;
        }
        String strB = mattecarra.usavsursschat.i.e.b(aVar.a());
        if (strB.equals("[FunLogin] Sei già loggato") || strB.equals("Successful login!") || strB.equals("[FunLogin] Loggato!") || strB.equals("You're already logged in!")) {
            this.E.a(true);
            return;
        }
        if (this.J.get() || this.I.get()) {
            return;
        }
        if (strB.equals("Please, login with the command \"/login <password>\"") || strB.equals("Scrivi /login password")) {
            if (this.A != null) {
                this.E.a("/login " + this.A);
                return;
            }
            if (this.J.getAndSet(true)) {
                return;
            }
            runOnUiThread(new Runnable() { // from class: mattecarra.usavsursschat.ChatCraftActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    ChatCraftActivity.this.a(new f.a(ChatCraftActivity.this).a("Login").b(R.layout.dialog_login, true).c("Ok").d("Cancel").a(new f.j() { // from class: mattecarra.usavsursschat.ChatCraftActivity.2.1
                        @Override // com.afollestad.materialdialogs.f.j
                        public void a(com.afollestad.materialdialogs.f fVar, com.afollestad.materialdialogs.b bVar) throws JSONException {
                            String string = ((EditText) fVar.findViewById(R.id.password)).getText().toString();
                            ChatCraftActivity.this.E.a("/login " + string);
                            ChatCraftActivity.this.A = string;
                            if (((CheckBox) fVar.findViewById(R.id.savePassword)).isChecked()) {
                                ChatCraftActivity.this.H.a(ChatCraftActivity.this.B, ChatCraftActivity.this.z, string);
                            }
                        }
                    }));
                }
            });
            return;
        }
        if ((strB.equals("Scrivi /register password password") || strB.equals("Please, register to the server with the command \"/register <password> <ConfirmPassword>\"")) && !this.I.getAndSet(true)) {
            runOnUiThread(new Runnable() { // from class: mattecarra.usavsursschat.ChatCraftActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    ChatCraftActivity.this.a(new f.a(ChatCraftActivity.this).a("Registration").b(R.layout.dialog_register, true).c("Ok").d("Cancel").a(false).a(new f.j() { // from class: mattecarra.usavsursschat.ChatCraftActivity.3.2
                        @Override // com.afollestad.materialdialogs.f.j
                        public void a(com.afollestad.materialdialogs.f fVar, com.afollestad.materialdialogs.b bVar) throws JSONException {
                            EditText editText = (EditText) fVar.findViewById(R.id.password);
                            String string = editText.getText().toString();
                            if (string.equals(((EditText) fVar.findViewById(R.id.same_password)).getText().toString())) {
                                ChatCraftActivity.this.E.a("/register " + string + " " + string);
                                ChatCraftActivity.this.A = string;
                                if (((CheckBox) fVar.findViewById(R.id.savePassword)).isChecked()) {
                                    ChatCraftActivity.this.H.a(ChatCraftActivity.this.B, ChatCraftActivity.this.z, string);
                                }
                                fVar.dismiss();
                                return;
                            }
                            editText.setError("Passwords doesn't match!");
                        }
                    }).b(new f.j() { // from class: mattecarra.usavsursschat.ChatCraftActivity.3.1
                        @Override // com.afollestad.materialdialogs.f.j
                        public void a(com.afollestad.materialdialogs.f fVar, com.afollestad.materialdialogs.b bVar) {
                            if (bVar != com.afollestad.materialdialogs.b.POSITIVE) {
                                fVar.dismiss();
                            }
                        }
                    }));
                }
            });
        }
    }

    @com.squareup.a.h
    public void disconnectEvent(mattecarra.usavsursschat.a.a.a.c cVar) throws JSONException {
        if (this.F && this.G != null) {
            try {
                System.out.println("Saving log!");
                JSONObject jSONObject = new JSONObject();
                String str = new SimpleDateFormat("yyyy MMM dd HH:mm").format(new Date());
                File file = new File(getFilesDir(), "logs");
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, this.y.replace(" ", BuildConfig.FLAVOR) + " " + str);
                jSONObject.put("date", str);
                jSONObject.put("server-ip", this.B + ":" + this.C);
                jSONObject.put("server-name", this.y);
                jSONObject.put("messages", this.G);
                FileWriter fileWriter = new FileWriter(file2);
                fileWriter.write(jSONObject.toString());
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Intent intent = new Intent();
        intent.putExtra("ip", this.B);
        intent.putExtra("port", this.C);
        intent.putExtra("username", this.z);
        intent.putExtra("server-name", this.y);
        intent.putExtra("KICK_REASON", cVar.a());
        intent.putExtra("PREMIUM_ERROR", cVar.b());
        setResult(-1, intent);
        finish();
    }

    @Override // mattecarra.usavsursschat.b, mattecarra.usavsursschat.InAppPurchase.a, androidx.appcompat.app.c, androidx.fragment.app.d, android.app.Activity
    protected void onDestroy() {
        try {
            ChatCraftApplication.f4809a.b(this);
        } catch (Throwable unused) {
        }
        l();
        super.onDestroy();
    }

    public String m() {
        return this.z;
    }

    public String n() {
        return this.B;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x003e A[EXC_TOP_SPLITTER, PHI: r1
      0x003e: PHI (r1v6 java.io.InputStream) = (r1v5 java.io.InputStream), (r1v9 java.io.InputStream) binds: [B:19:0x0050, B:9:0x003c] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void z() throws java.lang.Throwable {
        /*
            r6 = this;
            r0 = 0
            android.content.res.Resources r1 = r6.getResources()     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L49
            r2 = 2131623937(0x7f0e0001, float:1.887504E38)
            java.io.InputStream r1 = r1.openRawResource(r2)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L49
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Exception -> L42 java.lang.Throwable -> L6a
            r0.<init>()     // Catch: java.lang.Exception -> L42 java.lang.Throwable -> L6a
            r2 = 4096(0x1000, float:5.74E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Exception -> L42 java.lang.Throwable -> L6a
        L15:
            int r3 = r1.read(r2)     // Catch: java.lang.Exception -> L42 java.lang.Throwable -> L6a
            r4 = -1
            if (r3 == r4) goto L21
            r4 = 0
            r0.write(r2, r4, r3)     // Catch: java.lang.Exception -> L42 java.lang.Throwable -> L6a
            goto L15
        L21:
            r1.close()     // Catch: java.lang.Exception -> L42 java.lang.Throwable -> L6a
            r0.close()     // Catch: java.lang.Exception -> L42 java.lang.Throwable -> L6a
            java.security.spec.X509EncodedKeySpec r2 = new java.security.spec.X509EncodedKeySpec     // Catch: java.lang.Exception -> L42 java.lang.Throwable -> L6a
            byte[] r0 = r0.toByteArray()     // Catch: java.lang.Exception -> L42 java.lang.Throwable -> L6a
            r2.<init>(r0)     // Catch: java.lang.Exception -> L42 java.lang.Throwable -> L6a
            java.lang.String r0 = "RSA"
            java.security.KeyFactory r0 = java.security.KeyFactory.getInstance(r0)     // Catch: java.lang.Exception -> L42 java.lang.Throwable -> L6a
            java.security.PublicKey r0 = r0.generatePublic(r2)     // Catch: java.lang.Exception -> L42 java.lang.Throwable -> L6a
            mattecarra.usavsursschat.ChatCraftActivity.j = r0     // Catch: java.lang.Exception -> L42 java.lang.Throwable -> L6a
            if (r1 == 0) goto L53
        L3e:
            r1.close()     // Catch: java.io.IOException -> L53
            goto L53
        L42:
            r0 = move-exception
            goto L4d
        L44:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L6b
        L49:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L4d:
            com.crashlytics.android.a.a(r0)     // Catch: java.lang.Throwable -> L6a
            if (r1 == 0) goto L53
            goto L3e
        L53:
            com.google.gson.g r0 = new com.google.gson.g
            r0.<init>()
            java.lang.Class<java.util.UUID> r1 = java.util.UUID.class
            com.github.steveice10.mc.auth.util.UUIDSerializer r2 = new com.github.steveice10.mc.auth.util.UUIDSerializer
            r2.<init>()
            com.google.gson.g r0 = r0.a(r1, r2)
            com.google.gson.f r0 = r0.a()
            mattecarra.usavsursschat.ChatCraftActivity.k = r0
            return
        L6a:
            r0 = move-exception
        L6b:
            if (r1 == 0) goto L70
            r1.close()     // Catch: java.io.IOException -> L70
        L70:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: mattecarra.usavsursschat.ChatCraftActivity.z():void");
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_chat_craft, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) throws Resources.NotFoundException {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        }
        if (itemId == R.id.action_messages) {
            if (this.x.getCurrentItem() != 0) {
                this.x.a(0, true);
            }
        } else if (itemId == R.id.action_players && this.x.getCurrentItem() != 1) {
            this.x.a(1, true);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    public void onBackPressed() throws Resources.NotFoundException {
        if (this.x.getCurrentItem() != 0) {
            this.x.a(0, true);
            return;
        }
        com.afollestad.materialdialogs.f fVarB = new f.a(this).a("Are you sure?").d(R.string.ask_for_disconnect).c("Yes").d("No").a(new f.j() { // from class: mattecarra.usavsursschat.ChatCraftActivity.4
            @Override // com.afollestad.materialdialogs.f.j
            public void a(com.afollestad.materialdialogs.f fVar, com.afollestad.materialdialogs.b bVar) {
                try {
                    ChatCraftActivity.this.E.e();
                } catch (Throwable th) {
                    th.printStackTrace();
                    ChatCraftActivity.this.finish();
                }
            }
        }).b();
        a(fVarB);
        fVarB.show();
    }

    public mattecarra.usavsursschat.f.b o() {
        return this.H;
    }

    @Override // mattecarra.usavsursschat.b
    protected View q() {
        return findViewById(R.id.snack_bar_container);
    }

    @Override // androidx.fragment.app.h.b
    public void E_() {
        this.K = (mattecarra.usavsursschat.c.e) j().a("minecraft_client_fragment");
    }

    public class a extends m {
        @Override // androidx.viewpager.widget.a
        public int b() {
            return 3;
        }

        public a(h hVar) {
            super(hVar);
        }

        @Override // androidx.fragment.app.m
        public Fragment a(int i) {
            switch (i) {
                case 0:
                    return mattecarra.usavsursschat.c.d.ah();
                case 1:
                    return mattecarra.usavsursschat.c.f.ah();
                case 2:
                    return mattecarra.usavsursschat.c.g.ah();
                default:
                    return null;
            }
        }
    }
}
