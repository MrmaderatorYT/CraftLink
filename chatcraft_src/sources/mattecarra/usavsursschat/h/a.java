package mattecarra.usavsursschat.h;

import android.widget.ImageView;
import com.squareup.picasso.t;
import mattecarra.usavsursschat.f;
import me.zhanghai.android.materialprogressbar.R;

/* compiled from: SkinDownloader.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f5013a = "http://crafatar.com/avatars/";

    /* renamed from: b, reason: collision with root package name */
    private f f5014b;

    public a(f fVar) {
        this.f5014b = fVar;
    }

    public void a(ImageView imageView, String str) {
        if (str != null && this.f5014b.d()) {
            t.b().a("http://crafatar.com/avatars/" + str).a(str).a(R.drawable.avatarnew).a(imageView);
        }
    }
}
