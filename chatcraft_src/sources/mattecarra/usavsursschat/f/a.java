package mattecarra.usavsursschat.f;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChatCraftAbstractConfiguration.java */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected Context f4989a;

    /* renamed from: b, reason: collision with root package name */
    protected File f4990b;
    protected JSONObject c;

    public a(File file, Context context) {
        this.f4989a = context;
        this.f4990b = file;
        try {
            a();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            c();
        }
    }

    protected void a() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(this.f4990b));
        try {
            StringBuilder sb = new StringBuilder();
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                sb.append(line);
                sb.append("\n");
            }
            this.c = new JSONObject(sb.toString());
        } finally {
            bufferedReader.close();
        }
    }

    protected void b() {
        PrintWriter printWriter = new PrintWriter(new FileWriter(this.f4990b, false));
        printWriter.println(this.c.toString());
        printWriter.flush();
        printWriter.close();
    }

    protected void c() {
        this.c = new JSONObject();
        try {
            b();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
