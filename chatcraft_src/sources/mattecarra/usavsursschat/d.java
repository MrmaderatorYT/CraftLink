package mattecarra.usavsursschat;

import android.content.Context;
import java.util.Map;
import me.zhanghai.android.materialprogressbar.R;
import org.yaml.snakeyaml.Yaml;

/* compiled from: Language.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static Map<String, Object> f4964a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f4965b = "en";

    public static String a(String str) {
        try {
            return (String) f4964a.get(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void a(Context context) {
        f4965b = "it";
        try {
            f4964a = (Map) new Yaml().load(context.getResources().openRawResource(R.raw.translation));
            System.out.println("LOADED LANGUAGES");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
