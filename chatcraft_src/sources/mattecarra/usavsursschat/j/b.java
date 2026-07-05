package mattecarra.usavsursschat.j;

import android.os.AsyncTask;
import android.widget.Toast;
import com.afollestad.materialdialogs.f;
import mattecarra.usavsursschat.LoginActivity;
import mattecarra.usavsursschat.McClient.c;
import mattecarra.usavsursschat.b.d;
import mattecarra.usavsursschat.i.e;

/* compiled from: ServerVersionFixer.java */
/* loaded from: classes.dex */
public class b {
    /* JADX WARN: Type inference failed for: r2v1, types: [mattecarra.usavsursschat.j.b$1] */
    public static void a(final LoginActivity loginActivity, final d dVar) {
        final f fVarB = new f.a(loginActivity).a("Checking server version").b("Checking server version!").a(true, 0).b();
        loginActivity.b(fVarB);
        try {
            new AsyncTask<Void, Void, d>() { // from class: mattecarra.usavsursschat.j.b.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public d doInBackground(Void... voidArr) {
                    try {
                        dVar.b(new c().b(dVar.b(), dVar.c()));
                        return dVar;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onPostExecute(d dVar2) {
                    fVarB.dismiss();
                    if (dVar2 != null) {
                        try {
                            loginActivity.s().a(dVar);
                            Toast.makeText(loginActivity, "Server version detected! Version is " + e.a(dVar2.d()), 0).show();
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    Toast.makeText(loginActivity, "Failed to autodetect server version", 0).show();
                }
            }.execute(new Void[0]);
        } catch (Throwable th) {
            com.crashlytics.android.a.a(th);
        }
    }
}
