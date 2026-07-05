package mattecarra.usavsursschat.g;

import android.view.View;
import com.afollestad.materialdialogs.f;
import mattecarra.usavsursschat.LoginActivity;

/* compiled from: ServerMoreDialog.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private f f5010a;

    /* renamed from: b, reason: collision with root package name */
    private LoginActivity f5011b;
    private mattecarra.usavsursschat.b.d c;
    private a d;

    /* compiled from: ServerMoreDialog.java */
    public interface a {
        void a(mattecarra.usavsursschat.b.d dVar);

        void b(mattecarra.usavsursschat.b.d dVar);

        void c(mattecarra.usavsursschat.b.d dVar);
    }

    public d(mattecarra.usavsursschat.b.d dVar, LoginActivity loginActivity, a aVar) {
        this.c = dVar;
        this.f5011b = loginActivity;
        this.d = aVar;
        this.f5010a = new f.a(this.f5011b).a("Edit", "Remove", "Auto detect version").a(new f.e() { // from class: mattecarra.usavsursschat.g.d.1
            @Override // com.afollestad.materialdialogs.f.e
            public void a(f fVar, View view, int i, CharSequence charSequence) {
                switch (i) {
                    case 0:
                        d.this.d.b(d.this.c);
                        break;
                    case 1:
                        d.this.d.a(d.this.c);
                        break;
                    case 2:
                        d.this.d.c(d.this.c);
                        break;
                }
            }
        }).b();
    }

    public f a() {
        this.f5010a.show();
        return this.f5010a;
    }
}
