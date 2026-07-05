package mattecarra.usavsursschat.f;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ServerFastAuthConfiguration.java */
/* loaded from: classes.dex */
public class b extends a {
    public b(Context context) {
        super(new File(context.getFilesDir(), "serverFastAuth.yml"), context);
    }

    public void a(String str) {
        Iterator<String> itKeys = this.c.keys();
        while (itKeys.hasNext()) {
            try {
                this.c.getJSONObject(itKeys.next()).remove(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        try {
            b();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        try {
            this.c.getJSONObject(str).remove(str2);
            b();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    public List<String> b(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<String> itKeys = this.c.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    if (this.c.getJSONObject(next).has(str)) {
                        arrayList.add(next);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public String b(String str, String str2) throws JSONException {
        try {
            String string = this.c.getJSONObject(str).getString(str2);
            if (string != null) {
                return mattecarra.usavsursschat.i.b.a(string);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public void a(String str, String str2, String str3) throws JSONException {
        try {
            JSONObject jSONObject = this.c.has(str) ? this.c.getJSONObject(str) : new JSONObject();
            jSONObject.put(str2, mattecarra.usavsursschat.i.b.b(str3));
            this.c.put(str, jSONObject);
            b();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
