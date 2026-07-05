package mattecarra.usavsursschat.i;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FileUtils.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private File f5018a = new File(BuildConfig.FLAVOR);

    /* renamed from: b, reason: collision with root package name */
    private File f5019b = new File("accountsnew.yml");
    private File c = new File("serversNew.yml");

    public c(Context context) {
        a(context);
    }

    public void a(Context context) {
        this.f5018a = context.getFilesDir();
        this.f5019b = new File(this.f5018a, "accountsnew.yml");
        this.c = new File(context.getFilesDir(), "serversNew.yml");
    }

    public String a(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        try {
            StringBuilder sb = new StringBuilder();
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                sb.append(line);
                sb.append("\n");
            }
            return sb.toString();
        } finally {
            bufferedReader.close();
        }
    }

    public void a(File file, JSONObject jSONObject) {
        PrintWriter printWriter = new PrintWriter(new FileWriter(file, false));
        printWriter.println(jSONObject.toString());
        printWriter.flush();
        printWriter.close();
    }

    private JSONObject b(File file) {
        JSONObject jSONObject = new JSONObject();
        try {
            a(file, jSONObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject c(File file) {
        if (file.exists()) {
            try {
                return new JSONObject(a(file));
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                return new JSONObject();
            }
        }
        return b(file);
    }

    public List<mattecarra.usavsursschat.b.e> a() {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObjectC = c(this.f5019b);
        if (jSONObjectC.length() == 0) {
            return arrayList;
        }
        Iterator<String> itKeys = jSONObjectC.keys();
        while (itKeys.hasNext()) {
            try {
                mattecarra.usavsursschat.b.e eVarA = a(jSONObjectC, itKeys.next());
                if (eVarA != null) {
                    arrayList.add(eVarA);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public mattecarra.usavsursschat.b.e a(JSONObject jSONObject, String str) throws JSONException {
        String str2;
        String str3;
        String str4;
        String strA;
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            boolean z = jSONObject2.has("email") && jSONObject2.has("authTokenNew") && jSONObject2.has("clientTokenNew");
            if (z) {
                String string = jSONObject2.getString("email");
                String string2 = jSONObject2.getString("uuid");
                String strA2 = b.a(jSONObject2.getString("authTokenNew"));
                strA = b.a(jSONObject2.getString("clientTokenNew"));
                str3 = string;
                str2 = string2;
                str4 = strA2;
            } else {
                str2 = null;
                str3 = null;
                str4 = null;
                strA = null;
            }
            return new mattecarra.usavsursschat.b.e(str, str2, z, str3, str4, strA);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean a(mattecarra.usavsursschat.b.e eVar) throws JSONException {
        File file = this.f5019b;
        JSONObject jSONObjectC = c(file);
        JSONObject jSONObjectB = b(eVar.a());
        try {
            if (eVar.b()) {
                if (!e.f(eVar.c())) {
                    jSONObjectB.put("email", eVar.c());
                }
                if (!e.f(eVar.f())) {
                    jSONObjectB.put("uuid", eVar.f());
                }
                if (!e.f(eVar.d())) {
                    jSONObjectB.put("authTokenNew", b.b(eVar.d()));
                }
                if (!e.f(eVar.e())) {
                    jSONObjectB.put("clientTokenNew", b.b(eVar.e()));
                }
            } else {
                if (jSONObjectB.has("email")) {
                    jSONObjectB.remove("email");
                }
                if (jSONObjectB.has("uuid")) {
                    jSONObjectB.remove("uuid");
                }
                if (jSONObjectB.has("authTokenNew")) {
                    jSONObjectB.remove("authTokenNew");
                }
                if (jSONObjectB.has("clientTokenNew")) {
                    jSONObjectB.remove("clientTokenNew");
                }
            }
            jSONObjectC.put(eVar.a(), jSONObjectB);
            a(file, jSONObjectC);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void a(String str, mattecarra.usavsursschat.b.e eVar) throws JSONException {
        if (!str.equals(eVar.a())) {
            e(str);
        }
        a(eVar);
    }

    public mattecarra.usavsursschat.b.e b(String str, mattecarra.usavsursschat.b.e eVar) {
        try {
            if (str.equals(eVar.a())) {
                return null;
            }
            mattecarra.usavsursschat.b.e eVarA = a(c(this.f5019b), str);
            if (eVarA != null && eVarA.b()) {
                eVar.a(true);
                if (e.f(eVar.c()) && !e.f(eVarA.c())) {
                    eVar.b(eVarA.c());
                }
                if (e.f(eVar.d()) && !e.f(eVarA.d())) {
                    eVar.c(eVarA.d());
                }
                if (e.f(eVar.e()) && !e.f(eVarA.e())) {
                    eVar.d(eVarA.e());
                }
            }
            a(eVar);
            e(str);
            return eVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean a(String str) throws JSONException {
        try {
            JSONObject jSONObject = c(this.f5019b).getJSONObject(str);
            if (jSONObject != null) {
                return jSONObject.has("email");
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public JSONObject b(String str) {
        return c(c(this.f5019b), str);
    }

    private JSONObject c(JSONObject jSONObject, String str) {
        try {
            return jSONObject.has(str) ? jSONObject.getJSONObject(str) : new JSONObject();
        } catch (JSONException e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    public mattecarra.usavsursschat.b.e c(String str) {
        return a(c(this.f5019b), str);
    }

    public boolean d(String str) {
        return c(this.f5019b).has(str);
    }

    public boolean e(String str) {
        File file = this.f5019b;
        JSONObject jSONObjectC = c(file);
        if (!jSONObjectC.has(str)) {
            return false;
        }
        jSONObjectC.remove(str);
        try {
            a(file, jSONObjectC);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean f(String str) {
        return c(this.c).has(str);
    }

    public void a(String str, mattecarra.usavsursschat.b.c cVar) throws JSONException {
        if (!str.equals(cVar.a())) {
            g(str);
        }
        a(cVar);
    }

    public boolean g(String str) {
        JSONObject jSONObjectC = c(this.c);
        if (!jSONObjectC.has(str)) {
            return false;
        }
        jSONObjectC.remove(str);
        try {
            a(this.c, jSONObjectC);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void a(mattecarra.usavsursschat.b.c cVar) throws JSONException {
        JSONObject jSONObjectC = c(this.c);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ip", cVar.b());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            jSONObject.put("port", cVar.c());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        try {
            jSONObject.put("versionCode", cVar.d());
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        try {
            jSONObjectC.put(cVar.a(), jSONObject);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        a(this.c, jSONObjectC);
    }

    public mattecarra.usavsursschat.b.c h(String str) {
        return b(c(this.c), str);
    }

    public mattecarra.usavsursschat.b.c b(JSONObject jSONObject, String str) throws JSONException {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            mattecarra.usavsursschat.b.c cVar = new mattecarra.usavsursschat.b.c();
            cVar.a(str);
            cVar.b(jSONObject2.getString("ip"));
            cVar.a(jSONObject2.has("port") ? jSONObject2.getInt("port") : 25565);
            cVar.b(jSONObject2.has("versionCode") ? jSONObject2.getInt("versionCode") : cVar.d());
            return cVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<mattecarra.usavsursschat.b.c> b() {
        ArrayList<mattecarra.usavsursschat.b.c> arrayList = new ArrayList<>();
        JSONObject jSONObjectC = c(this.c);
        if (jSONObjectC.length() == 0) {
            return arrayList;
        }
        Iterator<String> itKeys = jSONObjectC.keys();
        while (itKeys.hasNext()) {
            try {
                String next = itKeys.next();
                mattecarra.usavsursschat.b.c cVarB = b(jSONObjectC, next);
                if (cVarB == null) {
                    System.out.println("Server " + next + " failed to load!");
                } else {
                    arrayList.add(cVarB);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }
}
