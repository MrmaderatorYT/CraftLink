package mattecarra.usavsursschat.activities;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.c;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.f;
import com.github.steveice10.mc.v1_10.protocol.data.message.Message;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import mattecarra.usavsursschat.d.d;
import mattecarra.usavsursschat.e.b;
import mattecarra.usavsursschat.e.f;
import mattecarra.usavsursschat.i.e;
import me.zhanghai.android.materialprogressbar.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class LogViewerActivity extends c implements f {
    private RecyclerView j;
    private b k;
    private LinearLayoutManager l;
    private Date m;
    private String n;
    private String o;
    private ArrayList<mattecarra.usavsursschat.b.a> p = new ArrayList<>();
    private d q = new d();

    public static void a(String str, Context context) {
        Intent intent = new Intent(context, (Class<?>) LogViewerActivity.class);
        intent.putExtra("log", str);
        context.startActivity(intent);
    }

    public static String a(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                sb.append(line);
                sb.append("\n");
            } else {
                bufferedReader.close();
                return sb.toString();
            }
        }
    }

    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.core.app.d, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.k.a(bundle);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.core.app.d, android.app.Activity
    protected void onCreate(Bundle bundle) throws JSONException {
        super.onCreate(bundle);
        setContentView(R.layout.activity_log_viewer);
        try {
            a((Toolbar) findViewById(R.id.toolbar));
            a().b(true);
            a().a(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (getIntent() != null && getIntent().hasExtra("log")) {
            try {
                JSONObject jSONObject = new JSONObject(a(new FileInputStream(new File(new File(getFilesDir(), "logs"), getIntent().getStringExtra("log")))));
                JSONArray jSONArray = jSONObject.getJSONArray("messages");
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.p.add(new mattecarra.usavsursschat.b.a(e.a(Message.fromString(jSONArray.getString(i)))));
                }
                try {
                    this.m = new SimpleDateFormat("yyyy MMM dd HH:mm").parse(jSONObject.getString("date"));
                } catch (ParseException unused) {
                }
                this.o = jSONObject.getString("server-ip");
                this.n = jSONObject.getString("server-name");
                this.j = (RecyclerView) findViewById(R.id.log_recycler);
                this.l = new LinearLayoutManager(this);
                this.j.setLayoutManager(this.l);
                this.k = new b(this.p, this);
                if (bundle != null) {
                    this.k.b(bundle);
                }
                this.j.setAdapter(this.k);
                this.j.setHasFixedSize(true);
                this.l.a(true);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                finish();
                return;
            }
        }
        finish();
    }

    public boolean a(String str) {
        try {
            return this.q.a(str);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // mattecarra.usavsursschat.e.f
    public void a(int i, View view, boolean z) {
        System.out.println("On click!");
        String string = this.p.get(i).a().toString();
        final LinkedList linkedList = new LinkedList();
        String[] strArrSplit = string.split(" ");
        int length = strArrSplit.length;
        for (int i2 = 0; i2 < length; i2++) {
            String str = strArrSplit[i2];
            if (!str.startsWith("http://") && !str.startsWith("https://")) {
                str = "http://" + str;
            }
            if (a(str)) {
                linkedList.add(str);
            }
        }
        if (linkedList.size() > 1) {
            new f.a(this).a("Open link").a((CharSequence[]) linkedList.toArray(new CharSequence[linkedList.size()])).a(new f.e() { // from class: mattecarra.usavsursschat.activities.LogViewerActivity.1
                @Override // com.afollestad.materialdialogs.f.e
                public void a(com.afollestad.materialdialogs.f fVar, View view2, int i3, CharSequence charSequence) {
                    LogViewerActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(charSequence.toString())));
                    linkedList.clear();
                }
            }).c();
        } else if (linkedList.size() == 1) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(((CharSequence) linkedList.getFirst()).toString())));
            linkedList.clear();
        } else {
            ((ClipboardManager) getSystemService("clipboard")).setText(string);
            Toast.makeText(this, "Text copied to clipboard!", 0).show();
        }
    }
}
