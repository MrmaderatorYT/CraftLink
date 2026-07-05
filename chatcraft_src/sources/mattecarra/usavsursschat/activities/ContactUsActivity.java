package mattecarra.usavsursschat.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.c;
import androidx.appcompat.widget.Toolbar;
import com.afollestad.materialdialogs.b;
import com.afollestad.materialdialogs.f;
import com.afollestad.materialdialogs.i;
import mattecarra.usavsursschat.i.e;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import me.zhanghai.android.materialprogressbar.R;

/* loaded from: classes.dex */
public class ContactUsActivity extends c {
    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.core.app.d, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_contact_us);
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle("Contact us");
            try {
                a(toolbar);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: mattecarra.usavsursschat.activities.ContactUsActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ContactUsActivity.this.onBackPressed();
                }
            });
            a().b(true);
            a().c(false);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() { // from class: mattecarra.usavsursschat.activities.ContactUsActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    final String string = ((EditText) ContactUsActivity.this.findViewById(R.id.email)).getText().toString();
                    final String string2 = ((EditText) ContactUsActivity.this.findViewById(R.id.contact_text)).getText().toString();
                    if (string2.trim().equalsIgnoreCase(BuildConfig.FLAVOR)) {
                        Toast.makeText(ContactUsActivity.this, "Text is empty!", 0).show();
                        return;
                    }
                    if (!string.trim().equalsIgnoreCase(BuildConfig.FLAVOR) && e.a(string)) {
                        ContactUsActivity.this.a(string, string2);
                        return;
                    }
                    new f.a(ContactUsActivity.this).a("Email is empty or wrong").b("Your email is empty or wrong. We wont be able to contact you. Are you sure to continue?").g(R.string.yes).k(R.string.no).i(R.color.material_red_400).c(R.color.material_red_400).f(android.R.color.white).o(R.color.material_blue_gray_800_custom).m(R.color.material_teal_500).a(R.drawable.md_btn_selector_custom, b.POSITIVE).h(-1).j(android.R.attr.textColorSecondaryInverse).a(i.DARK).a(new f.b() { // from class: mattecarra.usavsursschat.activities.ContactUsActivity.2.1
                        @Override // com.afollestad.materialdialogs.f.b
                        public void b(f fVar) {
                            super.b(fVar);
                            ContactUsActivity.this.a(string, string2);
                        }
                    }).c();
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        });
    }

    public void a(String str, String str2) {
        new Thread(new Runnable() { // from class: mattecarra.usavsursschat.activities.ContactUsActivity.3
            @Override // java.lang.Runnable
            public void run() {
            }
        }).start();
        finish();
    }
}
