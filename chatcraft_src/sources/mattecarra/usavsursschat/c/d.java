package mattecarra.usavsursschat.c;

import a.a.a.f.a;
import android.annotation.SuppressLint;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.f;
import com.squareup.a.h;
import java.util.LinkedList;
import mattecarra.usavsursschat.ChatCraftActivity;
import mattecarra.usavsursschat.ChatCraftApplication;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import me.zhanghai.android.materialprogressbar.R;
import org.json.JSONException;

/* compiled from: ChatFragment.java */
/* loaded from: classes.dex */
public class d extends c implements View.OnClickListener, mattecarra.usavsursschat.e.f {
    private Button ag;
    private mattecarra.usavsursschat.a ah;
    private String ai;

    /* renamed from: b, reason: collision with root package name */
    private RecyclerView f4941b;
    private LinearLayoutManager c;
    private mattecarra.usavsursschat.e.b d;
    private mattecarra.usavsursschat.d.d e = new mattecarra.usavsursschat.d.d();
    private volatile boolean f = true;
    private View g;
    private MultiAutoCompleteTextView h;
    private ImageButton i;

    @Override // mattecarra.usavsursschat.c.c
    protected int af() {
        return R.id.ad_view_chat;
    }

    public static d ah() {
        return new d();
    }

    @Override // androidx.fragment.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws IllegalAccessException {
        this.g = layoutInflater.inflate(R.layout.fragment_chat, viewGroup, false);
        this.ah = new mattecarra.usavsursschat.a(10);
        this.ai = l().getResources().getString(R.string.pro_features);
        this.h = (MultiAutoCompleteTextView) this.g.findViewById(R.id.messaggi);
        this.h.setTokenizer(new MultiAutoCompleteTextView.Tokenizer() { // from class: mattecarra.usavsursschat.c.d.1
            @Override // android.widget.MultiAutoCompleteTextView.Tokenizer
            public int findTokenStart(CharSequence charSequence, int i) {
                while (i > 0 && charSequence.charAt(i - 1) != ' ') {
                    i--;
                }
                return i;
            }

            @Override // android.widget.MultiAutoCompleteTextView.Tokenizer
            public int findTokenEnd(CharSequence charSequence, int i) {
                int length = charSequence.length();
                while (i < length) {
                    if (charSequence.charAt(i) == ' ') {
                        return i;
                    }
                    i++;
                }
                return length;
            }

            @Override // android.widget.MultiAutoCompleteTextView.Tokenizer
            public CharSequence terminateToken(CharSequence charSequence) {
                int length = charSequence.length();
                while (length > 0 && charSequence.charAt(length - 1) == ' ') {
                    length--;
                }
                if (length > 0 && charSequence.charAt(length - 1) == ' ') {
                    return charSequence;
                }
                if (charSequence instanceof Spanned) {
                    SpannableString spannableString = new SpannableString(((Object) charSequence) + " ");
                    TextUtils.copySpansFrom((Spanned) charSequence, 0, charSequence.length(), Object.class, spannableString, 0);
                    return spannableString;
                }
                return ((Object) charSequence) + " ";
            }
        });
        this.i = (ImageButton) this.g.findViewById(R.id.button_send);
        this.i.setOnClickListener(this);
        this.h.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: mattecarra.usavsursschat.c.d.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 4 && (keyEvent == null || keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 66)) {
                    return true;
                }
                d.this.ai();
                return true;
            }
        });
        this.g.findViewById(R.id.button_arrow_up).setOnClickListener(this);
        this.g.findViewById(R.id.button_arrow_down).setOnClickListener(this);
        this.ag = (Button) this.g.findViewById(R.id.tabButton);
        this.ag.setOnClickListener(this);
        this.f4941b = (RecyclerView) this.g.findViewById(R.id.listChat);
        this.c = new LinearLayoutManager(l());
        this.c.a(true);
        this.f4941b.setLayoutManager(this.c);
        this.d = new mattecarra.usavsursschat.e.b(this);
        if (bundle != null) {
            this.d.b(bundle);
        }
        this.f4941b.setAdapter(this.d);
        this.f4941b.a(new RecyclerView.n() { // from class: mattecarra.usavsursschat.c.d.4
            @Override // androidx.recyclerview.widget.RecyclerView.n
            public void a(RecyclerView recyclerView, int i, int i2) {
                if (i2 == 0) {
                    return;
                }
                if (i2 < 0) {
                    d.this.f = false;
                } else {
                    if (d.this.f || d.this.c.o() != d.this.d.b() - 1) {
                        return;
                    }
                    d.this.f = true;
                }
            }
        });
        try {
            ChatCraftApplication.f4809a.a(this);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai() {
        this.ah.a();
        final String string = this.h.getText().toString();
        this.ah.a(string);
        ChatCraftApplication.f4810b.c(new mattecarra.usavsursschat.a.b.b(string));
        if (string.toLowerCase().startsWith("/login ") || string.toLowerCase().startsWith("/l ") || string.toLowerCase().startsWith("/register ")) {
            com.afollestad.materialdialogs.f fVarB = new f.a(l()).a("Fast Login").d(R.string.fast_login_save_password).c("Yes").d("No").a(new f.j() { // from class: mattecarra.usavsursschat.c.d.5
                @Override // com.afollestad.materialdialogs.f.j
                public void a(com.afollestad.materialdialogs.f fVar, com.afollestad.materialdialogs.b bVar) throws JSONException {
                    if (d.this.f4939a != null) {
                        String[] strArrSplit = string.split(" ");
                        if (strArrSplit.length > 1) {
                            d.this.f4939a.o().a(d.this.f4939a.n(), d.this.f4939a.m(), strArrSplit[1]);
                        }
                    }
                }
            }).b();
            if (this.f4939a != null) {
                this.f4939a.a(fVarB);
            }
            fVarB.show();
        }
        this.h.setText(BuildConfig.FLAVOR);
    }

    @Override // mattecarra.usavsursschat.c.c, androidx.fragment.app.Fragment
    public void a(View view, Bundle bundle) throws IllegalAccessException, IllegalArgumentException {
        super.a(view, bundle);
        if (a.C0002a.a(l(), "message_input")) {
            ak();
        } else {
            this.h.requestFocus();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void e(Bundle bundle) {
        this.d.a(bundle);
        super.e(bundle);
    }

    @Override // mattecarra.usavsursschat.c.c, androidx.fragment.app.Fragment
    public void x() {
        try {
            ChatCraftApplication.f4809a.b(this);
        } catch (Throwable unused) {
        }
        super.x();
    }

    @Override // mattecarra.usavsursschat.c.c
    protected View ag() {
        return this.g;
    }

    @Override // mattecarra.usavsursschat.e.f
    public void a(int i, View view, boolean z) {
        if (z) {
            b(this.d.a(i), i);
        } else {
            a(this.d.a(i), i);
        }
    }

    @h
    public void editInput(mattecarra.usavsursschat.a.a.b bVar) {
        this.h.setText(bVar.a());
    }

    @h
    public void appendInput(mattecarra.usavsursschat.a.a.a aVar) {
        this.h.setText(this.h.getText().toString() + aVar.a());
    }

    @h
    public void messageReceived(mattecarra.usavsursschat.a.a.a.d dVar) {
        a(new mattecarra.usavsursschat.b.a(mattecarra.usavsursschat.i.e.a(dVar.a())));
    }

    private void a(mattecarra.usavsursschat.b.a aVar) {
        this.d.a(aVar);
        if (this.f) {
            aj();
        }
    }

    @h
    public void tabResponseReceived(mattecarra.usavsursschat.a.a.a.h hVar) {
        if (hVar.a().length == 0) {
            this.d.a(new mattecarra.usavsursschat.b.a(new SpannableString("No hint found!")));
            return;
        }
        this.h.setAdapter(new ArrayAdapter(l(), android.R.layout.simple_dropdown_item_1line, hVar.a()));
        this.h.setThreshold(2);
        this.h.showDropDown();
    }

    private void a(mattecarra.usavsursschat.b.a aVar, int i) {
        try {
            String string = aVar.a().toString();
            if (this.ai.equals(string)) {
                if (this.f4939a != null) {
                    this.f4939a.p().e("chatcraft_pro_features");
                    return;
                }
                return;
            }
            LinkedList linkedList = new LinkedList();
            String[] strArrSplit = string.split(" ");
            int length = strArrSplit.length;
            for (int i2 = 0; i2 < length; i2++) {
                String str = strArrSplit[i2];
                if (!str.startsWith("http://") && !str.startsWith("https://")) {
                    str = "http://" + str;
                }
                if (b(str)) {
                    linkedList.add(str);
                }
            }
            if (linkedList.size() > 1) {
                b(aVar, i);
            } else if (linkedList.size() == 1) {
                a(new Intent("android.intent.action.VIEW", Uri.parse(((CharSequence) linkedList.getFirst()).toString())));
                linkedList.clear();
            } else {
                ((ClipboardManager) l().getSystemService("clipboard")).setText(string);
                Toast.makeText(l(), "Text copied to clipboard!", 0).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b(mattecarra.usavsursschat.b.a aVar, int i) {
        CharSequence[] charSequenceArr;
        try {
            final String string = aVar.a().toString();
            if (string.equals(l().getResources().getText(R.string.pro_features))) {
                if (this.f4939a != null) {
                    this.f4939a.p().e("chatcraft_pro_features");
                    return;
                }
                return;
            }
            final LinkedList linkedList = new LinkedList();
            String[] strArrSplit = string.split(" ");
            int length = strArrSplit.length;
            for (int i2 = 0; i2 < length; i2++) {
                String str = strArrSplit[i2];
                if (!str.startsWith("http://") && !str.startsWith("https://")) {
                    str = "http://" + str;
                }
                if (b(str)) {
                    linkedList.add(str);
                }
            }
            try {
                if (linkedList.size() > 1) {
                    charSequenceArr = new CharSequence[]{"Copy", "Visit links"};
                } else if (linkedList.size() == 1) {
                    charSequenceArr = new CharSequence[]{"Copy", "Visit link"};
                } else {
                    charSequenceArr = new CharSequence[]{"Copy"};
                }
            } catch (Exception unused) {
                charSequenceArr = new CharSequence[]{"Copy"};
            }
            com.afollestad.materialdialogs.f fVarC = new f.a(l()).a(charSequenceArr).a(new f.e() { // from class: mattecarra.usavsursschat.c.d.6
                @Override // com.afollestad.materialdialogs.f.e
                @SuppressLint({"NewApi"})
                public void a(com.afollestad.materialdialogs.f fVar, View view, int i3, CharSequence charSequence) {
                    System.out.println("Text: " + charSequence.toString());
                    if (charSequence.toString().equalsIgnoreCase("Copy")) {
                        if (Build.VERSION.SDK_INT > 11) {
                            ((ClipboardManager) d.this.l().getSystemService("clipboard")).setText(string);
                            Toast.makeText(d.this.l(), "Text copied to clipboard!", 0).show();
                            return;
                        }
                        return;
                    }
                    if (linkedList.size() == 0) {
                        return;
                    }
                    if (linkedList.size() == 1) {
                        d.this.a(new Intent("android.intent.action.VIEW", Uri.parse(((CharSequence) linkedList.getFirst()).toString())));
                        linkedList.clear();
                    } else {
                        com.afollestad.materialdialogs.f fVarC2 = new f.a(d.this.l()).a("Open link").a((CharSequence[]) linkedList.toArray(new CharSequence[linkedList.size()])).a(new f.e() { // from class: mattecarra.usavsursschat.c.d.6.1
                            @Override // com.afollestad.materialdialogs.f.e
                            public void a(com.afollestad.materialdialogs.f fVar2, View view2, int i4, CharSequence charSequence2) {
                                d.this.a(new Intent("android.intent.action.VIEW", Uri.parse(charSequence2.toString())));
                                linkedList.clear();
                            }
                        }).c();
                        if (d.this.f4939a != null) {
                            d.this.f4939a.a(fVarC2);
                        }
                    }
                }
            }).c();
            if (this.f4939a != null) {
                this.f4939a.a(fVarC);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean b(String str) {
        try {
            return this.e.a(str);
        } catch (Exception unused) {
            return false;
        }
    }

    private void aj() {
        if (this.d.a() != 0) {
            return;
        }
        this.f4941b.b(this.d.b() - 1);
    }

    private void ak() {
        try {
            new a.C0002a(n()).b(false).c(false).a(a.a.a.c.c.CENTER).a(a.a.a.c.b.MINIMUM).a(true).d(false).a(a(R.string.tutorial_message_bar)).a(this.g.findViewById(R.id.messaggi)).b("message_input").a(new a.a.a.a.c() { // from class: mattecarra.usavsursschat.c.d.7
                @Override // a.a.a.a.c
                public void a(String str) {
                    d.this.al();
                }
            }).a(-1).b();
        } catch (Exception e) {
            com.crashlytics.android.a.a((Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al() {
        try {
            new a.C0002a(n()).b(false).c(false).a(a.a.a.c.c.CENTER).a(a.a.a.c.b.MINIMUM).a(true).d(false).a(a(R.string.tutorial_send_message)).a(this.g.findViewById(R.id.button_send)).b("send_message").a(new a.a.a.a.c() { // from class: mattecarra.usavsursschat.c.d.8
                @Override // a.a.a.a.c
                public void a(String str) {
                    d.this.am();
                }
            }).a(-1).b();
        } catch (Exception e) {
            com.crashlytics.android.a.a((Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am() {
        try {
            new a.C0002a(n()).b(false).c(false).a(a.a.a.c.c.CENTER).a(a.a.a.c.b.MINIMUM).a(true).d(false).a(a(R.string.tutorial_tab)).a(this.g.findViewById(R.id.tabButton)).b("tab").a(new a.a.a.a.c() { // from class: mattecarra.usavsursschat.c.d.9
                @Override // a.a.a.a.c
                public void a(String str) {
                    d.this.an();
                }
            }).a(-1).b();
        } catch (Exception e) {
            com.crashlytics.android.a.a((Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an() {
        try {
            new a.C0002a(n()).b(false).c(false).a(a.a.a.c.c.CENTER).a(a.a.a.c.b.MINIMUM).a(true).d(false).a(a(R.string.tutorial_message_history)).a(this.g.findViewById(R.id.historybuttons)).b("history_buttons").a(new a.a.a.a.c() { // from class: mattecarra.usavsursschat.c.d.10
                @Override // a.a.a.a.c
                public void a(String str) {
                    d.this.ao();
                }
            }).a(-1).b();
        } catch (Exception e) {
            com.crashlytics.android.a.a((Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao() {
        try {
            new a.C0002a(n()).b(false).c(false).a(a.a.a.c.c.CENTER).a(a.a.a.c.b.MINIMUM).a(true).d(false).a(a(R.string.tutorial_message_actions)).a(this.g.findViewById(R.id.listChat)).b("message_actions").a(new a.a.a.a.c() { // from class: mattecarra.usavsursschat.c.d.2
                @Override // a.a.a.a.c
                public void a(String str) {
                }
            }).a(-1).b();
        } catch (Exception e) {
            com.crashlytics.android.a.a((Throwable) e);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_arrow_down /* 2131230777 */:
                if (ChatCraftActivity.v()) {
                    this.h.setText(this.ah.a(-1));
                    if (this.h.getText().length() >= 0) {
                        this.h.setSelection(this.h.getText().length());
                        break;
                    }
                } else {
                    a(new mattecarra.usavsursschat.b.a(new SpannableString(this.ai)));
                    break;
                }
                break;
            case R.id.button_arrow_up /* 2131230778 */:
                if (ChatCraftActivity.v()) {
                    this.h.setText(this.ah.a(1));
                    if (this.h.getText().length() >= 0) {
                        this.h.setSelection(this.h.getText().length());
                        break;
                    }
                } else {
                    a(new mattecarra.usavsursschat.b.a(new SpannableString(this.ai)));
                    break;
                }
                break;
            case R.id.button_send /* 2131230780 */:
                ai();
                break;
            case R.id.tabButton /* 2131231000 */:
                System.out.println("Sending tab packet ");
                ChatCraftApplication.f4810b.c(new mattecarra.usavsursschat.a.b.d(this.h.getText().toString()));
                break;
        }
    }
}
