package mattecarra.usavsursschat.d;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: DomainValidator.java */
/* loaded from: classes.dex */
public class a implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private static final a f4966a = new a(false);

    /* renamed from: b, reason: collision with root package name */
    private static final a f4967b = new a(true);
    private static final String[] c = {"arpa"};
    private static final String[] d = {"abogado", "academy", "accountants", "active", "actor", "adult", "aero", "agency", "airforce", "allfinanz", "alsace", "amsterdam", "android", "aquarelle", "archi", "army", "arpa", "asia", "associates", "attorney", "auction", "audio", "autos", "axa", "band", "bar", "bargains", "bayern", "beer", "berlin", "best", "bid", "bike", "bio", "biz", "black", "blackfriday", "bloomberg", "blue", "bmw", "bnpparibas", "boo", "boutique", "brussels", "budapest", "build", "builders", "business", "buzz", "bzh", "cab", "cal", "camera", "camp", "cancerresearch", "capetown", "capital", "caravan", "cards", "care", "career", "careers", "cartier", "casa", "cash", "cat", "catering", "center", "ceo", "cern", "channel", "cheap", "christmas", "chrome", "church", "citic", "city", "claims", "cleaning", "click", "clinic", "clothing", "club", "coach", "codes", "coffee", "college", "cologne", "com", "community", "company", "computer", "condos", "construction", "consulting", "contractors", "cooking", "cool", "coop", "country", "credit", "creditcard", "cricket", "crs", "cruises", "cuisinella", "cymru", "dad", "dance", "dating", "day", "deals", "degree", "delivery", "democrat", "dental", "dentist", "desi", "dev", "diamonds", "diet", "digital", "direct", "directory", "discount", "dnp", "docs", "domains", "doosan", "durban", "dvag", "eat", "edu", "education", "email", "emerck", "energy", "engineer", "engineering", "enterprises", "equipment", "esq", "estate", "eurovision", "eus", "events", "everbank", "exchange", "expert", "exposed", "fail", "farm", "fashion", "feedback", "finance", "financial", "firmdale", "fish", "fishing", "fitness", "flights", "florist", "flowers", "flsmidth", "fly", "foo", "forsale", "foundation", "frl", "frogans", "fund", "furniture", "futbol", "gal", "gallery", "garden", "gbiz", "gent", "ggee", "gift", "gifts", "gives", "glass", "gle", "global", "globo", "gmail", "gmo", "gmx", "google", "gop", "gov", "graphics", "gratis", "green", "gripe", "guide", "guitars", "guru", "hamburg", "haus", "healthcare", "help", "here", "hiphop", "hiv", "holdings", "holiday", "homes", "horse", "host", "hosting", "house", "how", "ibm", "immo", "immobilien", "industries", "info", "ing", "ink", "institute", "insure", "int", "international", "investments", "irish", "iwc", "jetzt", "jobs", "joburg", "juegos", "kaufen", "kim", "kitchen", "kiwi", "koeln", "krd", "kred", "lacaixa", "land", "latrobe", "lawyer", "lds", "lease", "legal", "lgbt", "lidl", "life", "lighting", "limited", "limo", "link", "loans", "london", "lotto", "ltda", "luxe", "luxury", "madrid", "maison", "management", "mango", "market", "marketing", "media", "meet", "melbourne", "meme", "memorial", "menu", "miami", "mil", "mini", "mobi", "moda", "moe", "monash", "money", "mormon", "mortgage", "moscow", "motorcycles", "mov", "museum", "nagoya", "name", "navy", "net", "network", "neustar", "new", "nexus", "ngo", "nhk", "ninja", "nra", "nrw", "nyc", "okinawa", "ong", "onl", "ooo", "org", "organic", "osaka", "otsuka", "ovh", "paris", "partners", "parts", "party", "pharmacy", "photo", "photography", "photos", "physio", "pics", "pictures", "pink", "pizza", "place", "plumbing", "pohl", "poker", "porn", "post", "praxi", "press", "pro", "prod", "productions", "prof", "properties", "property", "pub", "qpon", "quebec", "realtor", "recipes", "red", "rehab", "reise", "reisen", "reit", "ren", "rentals", "repair", "report", "republican", "rest", "restaurant", "reviews", "rich", "rio", "rip", "rocks", "rodeo", "rsvp", "ruhr", "ryukyu", "saarland", "sale", "samsung", "sarl", "sca", "scb", "schmidt", "schule", "schwarz", "science", "scot", "services", "sew", "sexy", "shiksha", "shoes", "shriram", "singles", "sky", "social", "software", "sohu", "solar", "solutions", "soy", "space", "spiegel", "supplies", "supply", "support", "surf", "surgery", "suzuki", "sydney", "systems", "taipei", "tatar", "tattoo", "tax", "technology", "tel", "tienda", "tips", "tires", "tirol", "today", "tokyo", "tools", "top", "town", "toys", "trade", "training", "travel", "trust", "tui", "university", "uno", "uol", "vacations", "vegas", "ventures", "versicherung", "vet", "viajes", "video", "villas", "vision", "vlaanderen", "vodka", "vote", "voting", "voto", "voyage", "wales", "wang", "watch", "webcam", "website", "wed", "wedding", "whoswho", "wien", "wiki", "williamhill", "wme", "work", "works", "world", "wtc", "wtf", "xn--1qqw23a", "xn--3bst00m", "xn--3ds443g", "xn--45q11c", "xn--4gbrim", "xn--55qw42g", "xn--55qx5d", "xn--6frz82g", "xn--6qq986b3xl", "xn--80adxhks", "xn--80asehdb", "xn--80aswg", "xn--c1avg", "xn--cg4bki", "xn--czr694b", "xn--czrs0t", "xn--czru2d", "xn--d1acj3b", "xn--fiq228c5hs", "xn--fiq64b", "xn--flw351e", "xn--hxt814e", "xn--i1b6b1a6a2e", "xn--io0a7i", "xn--kput3i", "xn--mgbab2bd", "xn--ngbc5azd", "xn--nqv7f", "xn--nqv7fs00ema", "xn--p1acf", "xn--q9jyb4c", "xn--qcka1pmc", "xn--rhqv96g", "xn--ses554g", "xn--unup4y", "xn--vermgensberater-ctb", "xn--vermgensberatung-pwb", "xn--vhquv", "xn--xhq521b", "xn--zfr164b", "xxx", "xyz", "yachts", "yandex", "yoga", "yokohama", "youtube", "zip", "zone", "zuerich"};
    private static final String[] e = {"ac", "ad", "ae", "af", "ag", "ai", "al", "am", "an", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bm", "bn", "bo", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "er", "es", "et", "eu", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "st", "su", "sv", "sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tp", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "uk", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "xn--3e0b707e", "xn--45brj9c", "xn--80ao21a", "xn--90a3ac", "xn--clchc0ea0b2g2a9gcd", "xn--d1alf", "xn--fiqs8s", "xn--fiqz9s", "xn--fpcrj9c3d", "xn--fzc2c9e2c", "xn--gecrj9c", "xn--h2brj9c", "xn--j1amh", "xn--j6w193g", "xn--kprw13d", "xn--kpry57d", "xn--l1acc", "xn--lgbbat1ad8j", "xn--mgb9awbf", "xn--mgba3a4f16a", "xn--mgbaam7a8h", "xn--mgbayh7gpa", "xn--mgbbh1a71e", "xn--mgbc0a9azcg", "xn--mgberp4a5d4ar", "xn--mgbx4cd0ab", "xn--node", "xn--o3cw4h", "xn--ogbpf8fl", "xn--p1ai", "xn--pgbs0dh", "xn--s9brj9c", "xn--wgbh1c", "xn--wgbl6a", "xn--xkc2al3hye2a", "xn--xkc2dl3a5ee0h", "xn--yfro4i67o", "xn--ygbi2ammx", "ye", "yt", "za", "zm", "zw"};
    private static final String[] f = {"localdomain", "localhost"};
    private final boolean g;
    private final c h = new c("^(?:\\p{Alnum}(?>[\\p{Alnum}-]{0,61}\\p{Alnum})?\\.)+(\\p{Alpha}(?>[\\p{Alnum}-]{0,61}\\p{Alnum})?)\\.?$");
    private final c i = new c("\\p{Alnum}(?>[\\p{Alnum}-]{0,61}\\p{Alnum})?");

    private a(boolean z) {
        this.g = z;
    }

    public static a a(boolean z) {
        if (z) {
            return f4967b;
        }
        return f4966a;
    }

    static String a(String str) {
        try {
            return h(str);
        } catch (IllegalArgumentException unused) {
            return str;
        }
    }

    private static final String h(String str) {
        Method method;
        if (i(str) || (method = C0114a.f4968a) == null) {
            return str;
        }
        try {
            return (String) method.invoke(null, str.toLowerCase(Locale.ENGLISH));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof IllegalArgumentException) {
                throw ((IllegalArgumentException) cause);
            }
            throw new RuntimeException(e3);
        }
    }

    private static boolean i(String str) {
        if (str == null) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > 127) {
                return false;
            }
        }
        return true;
    }

    public boolean b(String str) {
        if (str == null) {
            return false;
        }
        String strA = a(str);
        if (strA.length() > 253) {
            return false;
        }
        String[] strArrB = this.h.b(strA);
        if (strArrB == null || strArrB.length <= 0) {
            return this.g && this.i.a(strA);
        }
        return c(strArrB[0]);
    }

    public boolean c(String str) {
        String strA = a(str);
        return (this.g && g(strA)) || d(strA) || e(strA) || f(strA);
    }

    public boolean d(String str) {
        return Arrays.binarySearch(c, j(a(str).toLowerCase(Locale.ENGLISH))) >= 0;
    }

    public boolean e(String str) {
        return Arrays.binarySearch(d, j(a(str).toLowerCase(Locale.ENGLISH))) >= 0;
    }

    public boolean f(String str) {
        return Arrays.binarySearch(e, j(a(str).toLowerCase(Locale.ENGLISH))) >= 0;
    }

    public boolean g(String str) {
        return Arrays.binarySearch(f, j(a(str).toLowerCase(Locale.ENGLISH))) >= 0;
    }

    private String j(String str) {
        return str.startsWith(".") ? str.substring(1) : str;
    }

    /* compiled from: DomainValidator.java */
    /* renamed from: mattecarra.usavsursschat.d.a$a, reason: collision with other inner class name */
    private static class C0114a {

        /* renamed from: a, reason: collision with root package name */
        private static final Method f4968a = b();

        private static Method b() {
            try {
                return Class.forName("java.net.IDN", false, a.class.getClassLoader()).getDeclaredMethod("toASCII", String.class);
            } catch (Exception unused) {
                return null;
            }
        }
    }
}
