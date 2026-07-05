package mattecarra.usavsursschat.i;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.github.steveice10.mc.auth.exception.request.RequestException;
import com.github.steveice10.mc.auth.service.AuthenticationService;
import com.github.steveice10.mc.common.message.ChatFormat;
import com.github.steveice10.mc.common.message.MessageInterface;
import com.github.steveice10.mc.v1_10.protocol.MinecraftConstants;
import com.github.steveice10.mc.v1_5.util.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import mattecarra.usavsursschat.exception.InvalidMessageInterfaceException;

/* compiled from: ProtocolUtils.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<String, Integer> f5021a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public static HashMap<Character, Integer> f5022b = new HashMap<>();

    public static int a() {
        return MinecraftConstants.PROTOCOL_VERSION;
    }

    public static String a(int i) {
        if (i >= 404) {
            return com.github.steveice10.mc.v1_13_2.protocol.MinecraftConstants.GAME_VERSION;
        }
        if (i >= 401) {
            return com.github.steveice10.mc.v1_13_1.protocol.MinecraftConstants.GAME_VERSION;
        }
        if (i >= 393) {
            return com.github.steveice10.mc.v1_13.protocol.MinecraftConstants.GAME_VERSION;
        }
        if (i >= 340) {
            return com.github.steveice10.mc.v1_12_2.protocol.MinecraftConstants.GAME_VERSION;
        }
        if (i >= 338) {
            return com.github.steveice10.mc.v1_12_1.protocol.MinecraftConstants.GAME_VERSION;
        }
        if (i >= 335) {
            return com.github.steveice10.mc.v1_12.protocol.MinecraftConstants.GAME_VERSION;
        }
        if (i >= 316) {
            return com.github.steveice10.mc.v1_11_2.protocol.MinecraftConstants.GAME_VERSION;
        }
        if (i >= 315) {
            return com.github.steveice10.mc.v1_11.protocol.MinecraftConstants.GAME_VERSION;
        }
        if (i >= 210) {
            return MinecraftConstants.GAME_VERSION;
        }
        if (i >= 110) {
            return com.github.steveice10.mc.v1_9_4.protocol.MinecraftConstants.GAME_VERSION;
        }
        if (i >= 109) {
            return com.github.steveice10.mc.v1_9_2.protocol.MinecraftConstants.GAME_VERSION;
        }
        if (i > 47) {
            return com.github.steveice10.mc.v1_9.protocol.MinecraftConstants.GAME_VERSION;
        }
        switch (i) {
            case -78:
                return "1.6.4";
            case -74:
                return com.github.steveice10.mc.v1_6_4.protocol.MinecraftConstants.MINECRAFT_VERSION;
            case -73:
                return "1.6.1";
            case -61:
                return "1.5.2";
            case -60:
                return Constants.STANDARD_MINECRAFT_VERSION;
            case 4:
                return "1.7.2";
            case 5:
                return "1.7.10";
            case 47:
                return "1.8";
            case 107:
                return com.github.steveice10.mc.v1_9.protocol.MinecraftConstants.GAME_VERSION;
            default:
                return i >= 0 ? "1.8" : i < 0 ? "1.6.4" : com.github.steveice10.mc.v1_9_2.protocol.MinecraftConstants.GAME_VERSION;
        }
    }

    public static boolean a(char c) {
        return c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == 'a' || c == 'b' || c == 'c' || c == 'd' || c == 'e' || c == 'f';
    }

    static {
        b();
    }

    public static boolean a(String str) {
        return Pattern.compile("^.+@.+\\..+$").matcher(str).matches();
    }

    private static void b() {
        f5021a.put("black", -1);
        f5021a.put("dark_blue", Integer.valueOf(Color.argb(255, 0, 0, 190)));
        f5021a.put("dark_green", Integer.valueOf(Color.argb(255, 0, 190, 0)));
        f5021a.put("dark_aqua", Integer.valueOf(Color.argb(255, 0, 190, 190)));
        f5021a.put("dark_red", Integer.valueOf(Color.argb(255, 190, 0, 0)));
        f5021a.put("dark_purple", Integer.valueOf(Color.argb(255, 190, 0, 190)));
        f5021a.put("gold", Integer.valueOf(Color.argb(255, 217, 163, 52)));
        f5021a.put("gray", Integer.valueOf(Color.argb(255, 190, 190, 190)));
        f5021a.put("blue", Integer.valueOf(Color.argb(255, 63, 63, 254)));
        f5021a.put("dark_gray", Integer.valueOf(Color.argb(255, 63, 63, 63)));
        f5021a.put("green", Integer.valueOf(Color.argb(255, 63, 254, 63)));
        f5021a.put("aqua", Integer.valueOf(Color.argb(255, 63, 254, 254)));
        f5021a.put("red", Integer.valueOf(Color.argb(255, 254, 63, 63)));
        f5021a.put("light_purple", Integer.valueOf(Color.argb(255, 254, 63, 254)));
        f5021a.put("yellow", Integer.valueOf(Color.argb(255, 254, 254, 63)));
        f5021a.put("white", -1);
        f5022b.put('0', Integer.valueOf(b("black")));
        f5022b.put('1', Integer.valueOf(b("dark_blue")));
        f5022b.put('2', Integer.valueOf(b("dark_green")));
        f5022b.put('3', Integer.valueOf(b("dark_aqua")));
        f5022b.put('4', Integer.valueOf(b("dark_red")));
        f5022b.put('5', Integer.valueOf(b("dark_purple")));
        f5022b.put('6', Integer.valueOf(b("gold")));
        f5022b.put('7', Integer.valueOf(b("gray")));
        f5022b.put('8', Integer.valueOf(b("dark_gray")));
        f5022b.put('9', Integer.valueOf(b("blue")));
        f5022b.put('a', Integer.valueOf(b("green")));
        f5022b.put('b', Integer.valueOf(b("aqua")));
        f5022b.put('c', Integer.valueOf(b("red")));
        f5022b.put('d', Integer.valueOf(b("light_purple")));
        f5022b.put('e', Integer.valueOf(b("yellow")));
        f5022b.put('f', Integer.valueOf(b("white")));
    }

    public static int b(String str) {
        return f5021a.get(str).intValue();
    }

    public static mattecarra.usavsursschat.b.e a(String str, String str2) {
        String name;
        String string;
        if (str == null || str2 == null) {
            return null;
        }
        AuthenticationService authenticationService = new AuthenticationService(UUID.randomUUID().toString());
        authenticationService.setUsername(str);
        authenticationService.setPassword(str2);
        try {
            authenticationService.login();
            try {
                name = authenticationService.getSelectedProfile().getName();
                string = authenticationService.getSelectedProfile().getId().toString();
            } catch (Throwable th) {
                th.printStackTrace();
                try {
                    name = authenticationService.getAvailableProfiles().get(0).getName();
                    string = authenticationService.getAvailableProfiles().get(0).getId().toString();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return new mattecarra.usavsursschat.b.e(name, string, true, str, authenticationService.getAccessToken(), authenticationService.getClientToken());
        } catch (RequestException e2) {
            System.err.println("Failed to log in!");
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
    
        switch(r0) {
            case 46679168: goto L21;
            case 46679170: goto L18;
            case 1446818689: goto L15;
            case 1446994643: goto L12;
            default: goto L105;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0009, code lost:
    
        switch(r0) {
            case 1505532: goto L87;
            case 1505533: goto L84;
            case 1505534: goto L81;
            case 1505535: goto L78;
            default: goto L5;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
    
        switch(r0) {
            case 46675323: goto L75;
            case 46675324: goto L72;
            default: goto L6;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000f, code lost:
    
        switch(r0) {
            case 46676284: goto L69;
            case 46676285: goto L66;
            case 46676286: goto L63;
            case 46676287: goto L60;
            default: goto L7;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
    
        switch(r0) {
            case 46677246: goto L57;
            case 46677247: goto L54;
            case 46677248: goto L51;
            case 46677249: goto L48;
            case 46677250: goto L45;
            case 46677251: goto L42;
            case 46677252: goto L39;
            case 46677253: goto L36;
            default: goto L8;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        switch(r0) {
            case 1446819649: goto L33;
            case 1446819650: goto L30;
            default: goto L9;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0018, code lost:
    
        switch(r0) {
            case 1446820610: goto L27;
            case 1446820611: goto L24;
            default: goto L10;
        };
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0182  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(java.lang.String r3) {
        /*
            Method dump skipped, instructions count: 618
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: mattecarra.usavsursschat.i.e.c(java.lang.String):int");
    }

    public static void a(SpannableString spannableString, String str, int i) {
        if (str.contains("§")) {
            int i2 = i;
            int i3 = 0;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            char c = 'r';
            while (i2 < str.length()) {
                if (str.charAt(i2) == 167) {
                    i2++;
                    if (i2 != str.length()) {
                        char cCharAt = str.charAt(i2);
                        if (cCharAt != 'r') {
                            switch (cCharAt) {
                                case 'k':
                                    break;
                                case 'l':
                                    z = true;
                                    continue;
                                case 'm':
                                    z3 = true;
                                    continue;
                                case 'n':
                                    z4 = true;
                                    continue;
                                case 'o':
                                    z2 = true;
                                    continue;
                                default:
                                    if (f5022b.containsKey(Character.valueOf(cCharAt))) {
                                        c = cCharAt;
                                        z = false;
                                        z2 = false;
                                        z3 = false;
                                        z4 = false;
                                        break;
                                    }
                                    break;
                            }
                        } else {
                            z = false;
                            z2 = false;
                            z3 = false;
                            z4 = false;
                        }
                        c = 'r';
                    }
                } else {
                    int i4 = i3 + 1;
                    a(spannableString, z, z2, z3, z4, c, i3, i4);
                    i3 = i4;
                }
                i2++;
            }
        }
    }

    public static void a(SpannableString spannableString, boolean z, boolean z2, boolean z3, boolean z4, char c, int i, int i2) {
        if (z) {
            spannableString.setSpan(new StyleSpan(1), i, i2, 17);
        }
        if (z4) {
            spannableString.setSpan(new UnderlineSpan(), i, i2, 17);
        }
        if (z2) {
            spannableString.setSpan(new StyleSpan(2), i, i2, 17);
        }
        if (z3) {
            spannableString.setSpan(new StrikethroughSpan(), i, i2, 17);
        }
        if (c != 'r') {
            spannableString.setSpan(new ForegroundColorSpan(f5022b.get(Character.valueOf(c)).intValue()), i, i2, 17);
        }
    }

    public static SpannableString a(MessageInterface messageInterface) {
        if (messageInterface == null) {
            return new SpannableString("Message is null");
        }
        SpannableString spannableString = new SpannableString(e(b(messageInterface)));
        try {
            a(spannableString, messageInterface, 0);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            com.crashlytics.android.a.a((Throwable) new InvalidMessageInterfaceException("Fatal error during colorSpan of string: " + messageInterface.getFullText(), e));
        }
        return spannableString;
    }

    public static String b(MessageInterface messageInterface) {
        StringBuilder sb = new StringBuilder(messageInterface.getText());
        List<ChatFormat> formats = messageInterface.getStyle().getFormats();
        Iterator<ChatFormat> it = formats.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ChatFormat next = it.next();
            if (next != null && next.toString().equalsIgnoreCase("OBFUSCATED")) {
                sb = b(sb.length());
                messageInterface.getStyle().removeFormat(next);
                break;
            }
        }
        formats.clear();
        List<MessageInterface> extra = messageInterface.getExtra();
        for (MessageInterface messageInterface2 : extra) {
            if (messageInterface2 != null) {
                sb.append(b(messageInterface2));
            }
        }
        extra.clear();
        return sb.toString();
    }

    public static int a(SpannableString spannableString, MessageInterface messageInterface, int i) {
        String text = messageInterface.getText();
        int length = e(text).length();
        if (length != 0 && messageInterface.getStyle() != null && messageInterface.getStyle().getColor() != null) {
            String string = messageInterface.getStyle().getColor().toString();
            if (!f5021a.containsKey(string)) {
                System.out.println("Unknown Color: " + string);
            } else {
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(f5021a.get(string).intValue());
                int i2 = i + length;
                spannableString.setSpan(foregroundColorSpan, i, i2, 17);
                Iterator<ChatFormat> it = messageInterface.getStyle().getFormats().iterator();
                while (it.hasNext()) {
                    String string2 = it.next().toString();
                    if (string2.equalsIgnoreCase("BOLD")) {
                        spannableString.setSpan(new StyleSpan(1), i, i2, 17);
                    } else if (string2.equalsIgnoreCase("ITALIC")) {
                        spannableString.setSpan(new StyleSpan(2), i, i2, 17);
                    } else if (string2.equalsIgnoreCase("UNDERLINED")) {
                        spannableString.setSpan(new UnderlineSpan(), i, i2, 17);
                    } else if (string2.equalsIgnoreCase("STRIKETHROUGH")) {
                        spannableString.setSpan(new StrikethroughSpan(), i, i2, 17);
                    }
                }
            }
        }
        if (text.contains("§")) {
            a(spannableString, text, i);
        }
        List<MessageInterface> extra = messageInterface.getExtra();
        int iA = i + length;
        Iterator<MessageInterface> it2 = extra.iterator();
        while (it2.hasNext()) {
            iA = a(spannableString, it2.next(), iA);
        }
        extra.clear();
        return iA;
    }

    public static SpannableString d(String str) {
        SpannableString spannableString = new SpannableString(e(str));
        a(spannableString, str, 0);
        return spannableString;
    }

    public static String e(String str) {
        if (!str.contains("§")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        boolean z = false;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt == 167) {
                i++;
                if (i != str.length()) {
                    char cCharAt2 = str.charAt(i);
                    if (cCharAt2 == 'k') {
                        z = true;
                    } else if (z && (a(cCharAt2) || cCharAt2 == 'r')) {
                        z = false;
                    }
                }
            } else if (z) {
                sb.append("▒");
            } else {
                sb.append(cCharAt);
            }
            i++;
        }
        return sb.toString();
    }

    public static StringBuilder b(int i) {
        StringBuilder sb = new StringBuilder(i);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("▒");
        }
        return sb;
    }

    public static boolean f(String str) {
        return str == null || str.isEmpty();
    }

    public static int g(String str) {
        if (str == null || str.trim().isEmpty()) {
            return 25565;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 25565;
        }
    }
}
