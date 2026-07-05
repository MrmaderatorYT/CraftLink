package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.ads.bbt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes.dex */
public final class bhp extends DefaultHandler implements bjo<bho> {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f2679a = Pattern.compile("(\\d+)(?:/(\\d+))?");

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f2680b = Pattern.compile("CC([1-4])=.*");
    private static final Pattern c = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");
    private final String d;
    private final XmlPullParserFactory e;

    public bhp() {
        this(null);
    }

    private bhp(String str) {
        this.d = null;
        try {
            this.e = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0573 A[Catch: XmlPullParserException -> 0x0809, TryCatch #0 {XmlPullParserException -> 0x0809, blocks: (B:3:0x0002, B:5:0x0015, B:7:0x0021, B:11:0x0039, B:13:0x004d, B:18:0x005c, B:21:0x0067, B:24:0x0072, B:26:0x007b, B:31:0x0092, B:34:0x009f, B:307:0x07ad, B:319:0x07d1, B:321:0x07d7, B:323:0x07e7, B:324:0x07ee, B:316:0x07c7, B:317:0x07ce, B:37:0x00c0, B:39:0x00c8, B:40:0x00e0, B:42:0x00e8, B:44:0x00fb, B:47:0x0105, B:48:0x0122, B:51:0x0131, B:291:0x0722, B:293:0x072a, B:297:0x0755, B:298:0x0771, B:299:0x0772, B:303:0x0791, B:302:0x078b, B:54:0x0163, B:56:0x016b, B:57:0x01e4, B:60:0x01f3, B:260:0x0634, B:262:0x063c, B:263:0x0646, B:265:0x064c, B:267:0x065f, B:268:0x0668, B:270:0x0677, B:274:0x06a8, B:271:0x0691, B:273:0x0695, B:275:0x06ae, B:276:0x06b5, B:277:0x06b6, B:62:0x0214, B:64:0x021c, B:66:0x0222, B:67:0x0226, B:69:0x022e, B:75:0x0245, B:74:0x023e, B:76:0x0262, B:78:0x026c, B:79:0x027b, B:81:0x0286, B:83:0x028e, B:87:0x0299, B:88:0x029e, B:90:0x02a8, B:92:0x02c2, B:94:0x02ca, B:95:0x02d4, B:97:0x02dc, B:98:0x02e6, B:100:0x02ee, B:101:0x0336, B:104:0x0345, B:126:0x03b3, B:128:0x03bb, B:131:0x03c3, B:133:0x03d1, B:135:0x03d9, B:175:0x0464, B:177:0x046a, B:230:0x0591, B:232:0x05a8, B:242:0x05c1, B:235:0x05b0, B:238:0x05b8, B:229:0x058a, B:179:0x047e, B:181:0x0484, B:182:0x0499, B:184:0x049f, B:187:0x04a8, B:189:0x04ae, B:191:0x04c0, B:193:0x04c4, B:195:0x04d2, B:224:0x0564, B:196:0x04dc, B:198:0x04ec, B:200:0x04f6, B:199:0x04f1, B:201:0x04f9, B:205:0x0504, B:208:0x050f, B:210:0x0515, B:212:0x0525, B:214:0x0529, B:216:0x0537, B:217:0x0541, B:219:0x0552, B:221:0x055c, B:220:0x0557, B:222:0x055f, B:225:0x0573, B:138:0x03e3, B:141:0x03ed, B:144:0x03f9, B:146:0x0403, B:148:0x040b, B:151:0x0412, B:152:0x0415, B:155:0x041d, B:157:0x0425, B:160:0x0430, B:163:0x043b, B:166:0x0445, B:169:0x0450, B:171:0x0458, B:105:0x034c, B:107:0x0354, B:108:0x035b, B:110:0x0363, B:112:0x036e, B:114:0x0376, B:115:0x037f, B:117:0x0387, B:118:0x0390, B:120:0x0398, B:122:0x039e, B:123:0x03a2, B:125:0x03aa, B:244:0x05d2, B:246:0x05ea, B:249:0x05f7, B:251:0x05ff, B:252:0x0608, B:254:0x0610, B:255:0x0619, B:257:0x0621, B:258:0x062d, B:279:0x06e1, B:281:0x06fc, B:283:0x0703, B:285:0x070c, B:286:0x0711, B:288:0x0719, B:10:0x0034, B:326:0x0801, B:327:0x0808), top: B:331:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0587  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x058a A[Catch: XmlPullParserException -> 0x0809, TryCatch #0 {XmlPullParserException -> 0x0809, blocks: (B:3:0x0002, B:5:0x0015, B:7:0x0021, B:11:0x0039, B:13:0x004d, B:18:0x005c, B:21:0x0067, B:24:0x0072, B:26:0x007b, B:31:0x0092, B:34:0x009f, B:307:0x07ad, B:319:0x07d1, B:321:0x07d7, B:323:0x07e7, B:324:0x07ee, B:316:0x07c7, B:317:0x07ce, B:37:0x00c0, B:39:0x00c8, B:40:0x00e0, B:42:0x00e8, B:44:0x00fb, B:47:0x0105, B:48:0x0122, B:51:0x0131, B:291:0x0722, B:293:0x072a, B:297:0x0755, B:298:0x0771, B:299:0x0772, B:303:0x0791, B:302:0x078b, B:54:0x0163, B:56:0x016b, B:57:0x01e4, B:60:0x01f3, B:260:0x0634, B:262:0x063c, B:263:0x0646, B:265:0x064c, B:267:0x065f, B:268:0x0668, B:270:0x0677, B:274:0x06a8, B:271:0x0691, B:273:0x0695, B:275:0x06ae, B:276:0x06b5, B:277:0x06b6, B:62:0x0214, B:64:0x021c, B:66:0x0222, B:67:0x0226, B:69:0x022e, B:75:0x0245, B:74:0x023e, B:76:0x0262, B:78:0x026c, B:79:0x027b, B:81:0x0286, B:83:0x028e, B:87:0x0299, B:88:0x029e, B:90:0x02a8, B:92:0x02c2, B:94:0x02ca, B:95:0x02d4, B:97:0x02dc, B:98:0x02e6, B:100:0x02ee, B:101:0x0336, B:104:0x0345, B:126:0x03b3, B:128:0x03bb, B:131:0x03c3, B:133:0x03d1, B:135:0x03d9, B:175:0x0464, B:177:0x046a, B:230:0x0591, B:232:0x05a8, B:242:0x05c1, B:235:0x05b0, B:238:0x05b8, B:229:0x058a, B:179:0x047e, B:181:0x0484, B:182:0x0499, B:184:0x049f, B:187:0x04a8, B:189:0x04ae, B:191:0x04c0, B:193:0x04c4, B:195:0x04d2, B:224:0x0564, B:196:0x04dc, B:198:0x04ec, B:200:0x04f6, B:199:0x04f1, B:201:0x04f9, B:205:0x0504, B:208:0x050f, B:210:0x0515, B:212:0x0525, B:214:0x0529, B:216:0x0537, B:217:0x0541, B:219:0x0552, B:221:0x055c, B:220:0x0557, B:222:0x055f, B:225:0x0573, B:138:0x03e3, B:141:0x03ed, B:144:0x03f9, B:146:0x0403, B:148:0x040b, B:151:0x0412, B:152:0x0415, B:155:0x041d, B:157:0x0425, B:160:0x0430, B:163:0x043b, B:166:0x0445, B:169:0x0450, B:171:0x0458, B:105:0x034c, B:107:0x0354, B:108:0x035b, B:110:0x0363, B:112:0x036e, B:114:0x0376, B:115:0x037f, B:117:0x0387, B:118:0x0390, B:120:0x0398, B:122:0x039e, B:123:0x03a2, B:125:0x03aa, B:244:0x05d2, B:246:0x05ea, B:249:0x05f7, B:251:0x05ff, B:252:0x0608, B:254:0x0610, B:255:0x0619, B:257:0x0621, B:258:0x062d, B:279:0x06e1, B:281:0x06fc, B:283:0x0703, B:285:0x070c, B:286:0x0711, B:288:0x0719, B:10:0x0034, B:326:0x0801, B:327:0x0808), top: B:331:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x05a8 A[Catch: XmlPullParserException -> 0x0809, TryCatch #0 {XmlPullParserException -> 0x0809, blocks: (B:3:0x0002, B:5:0x0015, B:7:0x0021, B:11:0x0039, B:13:0x004d, B:18:0x005c, B:21:0x0067, B:24:0x0072, B:26:0x007b, B:31:0x0092, B:34:0x009f, B:307:0x07ad, B:319:0x07d1, B:321:0x07d7, B:323:0x07e7, B:324:0x07ee, B:316:0x07c7, B:317:0x07ce, B:37:0x00c0, B:39:0x00c8, B:40:0x00e0, B:42:0x00e8, B:44:0x00fb, B:47:0x0105, B:48:0x0122, B:51:0x0131, B:291:0x0722, B:293:0x072a, B:297:0x0755, B:298:0x0771, B:299:0x0772, B:303:0x0791, B:302:0x078b, B:54:0x0163, B:56:0x016b, B:57:0x01e4, B:60:0x01f3, B:260:0x0634, B:262:0x063c, B:263:0x0646, B:265:0x064c, B:267:0x065f, B:268:0x0668, B:270:0x0677, B:274:0x06a8, B:271:0x0691, B:273:0x0695, B:275:0x06ae, B:276:0x06b5, B:277:0x06b6, B:62:0x0214, B:64:0x021c, B:66:0x0222, B:67:0x0226, B:69:0x022e, B:75:0x0245, B:74:0x023e, B:76:0x0262, B:78:0x026c, B:79:0x027b, B:81:0x0286, B:83:0x028e, B:87:0x0299, B:88:0x029e, B:90:0x02a8, B:92:0x02c2, B:94:0x02ca, B:95:0x02d4, B:97:0x02dc, B:98:0x02e6, B:100:0x02ee, B:101:0x0336, B:104:0x0345, B:126:0x03b3, B:128:0x03bb, B:131:0x03c3, B:133:0x03d1, B:135:0x03d9, B:175:0x0464, B:177:0x046a, B:230:0x0591, B:232:0x05a8, B:242:0x05c1, B:235:0x05b0, B:238:0x05b8, B:229:0x058a, B:179:0x047e, B:181:0x0484, B:182:0x0499, B:184:0x049f, B:187:0x04a8, B:189:0x04ae, B:191:0x04c0, B:193:0x04c4, B:195:0x04d2, B:224:0x0564, B:196:0x04dc, B:198:0x04ec, B:200:0x04f6, B:199:0x04f1, B:201:0x04f9, B:205:0x0504, B:208:0x050f, B:210:0x0515, B:212:0x0525, B:214:0x0529, B:216:0x0537, B:217:0x0541, B:219:0x0552, B:221:0x055c, B:220:0x0557, B:222:0x055f, B:225:0x0573, B:138:0x03e3, B:141:0x03ed, B:144:0x03f9, B:146:0x0403, B:148:0x040b, B:151:0x0412, B:152:0x0415, B:155:0x041d, B:157:0x0425, B:160:0x0430, B:163:0x043b, B:166:0x0445, B:169:0x0450, B:171:0x0458, B:105:0x034c, B:107:0x0354, B:108:0x035b, B:110:0x0363, B:112:0x036e, B:114:0x0376, B:115:0x037f, B:117:0x0387, B:118:0x0390, B:120:0x0398, B:122:0x039e, B:123:0x03a2, B:125:0x03aa, B:244:0x05d2, B:246:0x05ea, B:249:0x05f7, B:251:0x05ff, B:252:0x0608, B:254:0x0610, B:255:0x0619, B:257:0x0621, B:258:0x062d, B:279:0x06e1, B:281:0x06fc, B:283:0x0703, B:285:0x070c, B:286:0x0711, B:288:0x0719, B:10:0x0034, B:326:0x0801, B:327:0x0808), top: B:331:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:241:0x05c0  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x06cc A[LOOP:2: B:57:0x01e4->B:278:0x06cc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0796 A[LOOP:1: B:48:0x0122->B:304:0x0796, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:335:0x072a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:336:0x063c A[EDGE_INSN: B:336:0x063c->B:262:0x063c BREAK  A[LOOP:2: B:57:0x01e4->B:278:0x06cc], SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.bjo
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.bho a(android.net.Uri r86, java.io.InputStream r87) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 2064
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bhp.a(android.net.Uri, java.io.InputStream):com.google.android.gms.internal.ads.bho");
    }

    private static int a(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if ("audio".equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        return "text".equals(attributeValue) ? 3 : -1;
    }

    private static bbt.a b(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        boolean zEquals = "urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95".equals(xmlPullParser.getAttributeValue(null, "schemeIdUri"));
        byte[] bArrA = null;
        UUID uuidA = null;
        boolean z = false;
        do {
            xmlPullParser.next();
            if (bArrA == null && bki.b(xmlPullParser, "cenc:pssh") && xmlPullParser.next() == 4) {
                bArrA = Base64.decode(xmlPullParser.getText(), 0);
                uuidA = bdv.a(bArrA);
                if (uuidA == null) {
                    Log.w("MpdParser", "Skipping malformed cenc:pssh data");
                    bArrA = null;
                }
            } else if (bArrA == null && zEquals && bki.b(xmlPullParser, "mspr:pro") && xmlPullParser.next() == 4) {
                bArrA = bdv.a(azo.c, Base64.decode(xmlPullParser.getText(), 0));
                uuidA = azo.c;
            } else if (bki.b(xmlPullParser, "widevine:license")) {
                String attributeValue = xmlPullParser.getAttributeValue(null, "robustness_level");
                z = attributeValue != null && attributeValue.startsWith("HW");
            }
        } while (!bki.a(xmlPullParser, "ContentProtection"));
        if (bArrA != null) {
            return new bbt.a(uuidA, "video/mp4", bArrA, z);
        }
        return null;
    }

    private final bid a(XmlPullParser xmlPullParser, bid bidVar) throws XmlPullParserException, NumberFormatException, IOException {
        long j;
        long j2;
        long jB = b(xmlPullParser, "timescale", bidVar != null ? bidVar.f2692b : 1L);
        long jB2 = b(xmlPullParser, "presentationTimeOffset", bidVar != null ? bidVar.c : 0L);
        long j3 = bidVar != null ? bidVar.d : 0L;
        long j4 = bidVar != null ? bidVar.e : 0L;
        String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] strArrSplit = attributeValue.split("-");
            j2 = Long.parseLong(strArrSplit[0]);
            j = (Long.parseLong(strArrSplit[1]) - j2) + 1;
        } else {
            j = j4;
            j2 = j3;
        }
        bht bhtVarD = bidVar != null ? bidVar.f2691a : null;
        do {
            xmlPullParser.next();
            if (bki.b(xmlPullParser, "Initialization")) {
                bhtVarD = d(xmlPullParser);
            }
        } while (!bki.a(xmlPullParser, "SegmentBase"));
        return new bid(bhtVarD, jB, jB2, j2, j);
    }

    private final bia a(XmlPullParser xmlPullParser, bia biaVar) throws XmlPullParserException, IOException {
        long jB = b(xmlPullParser, "timescale", biaVar != null ? biaVar.f2692b : 1L);
        long jB2 = b(xmlPullParser, "presentationTimeOffset", biaVar != null ? biaVar.c : 0L);
        long jB3 = b(xmlPullParser, "duration", biaVar != null ? biaVar.e : -9223372036854775807L);
        int iA = a(xmlPullParser, "startNumber", biaVar != null ? biaVar.d : 1);
        List arrayList = null;
        bht bhtVarD = null;
        List<bic> listC = null;
        do {
            xmlPullParser.next();
            if (bki.b(xmlPullParser, "Initialization")) {
                bhtVarD = d(xmlPullParser);
            } else if (bki.b(xmlPullParser, "SegmentTimeline")) {
                listC = c(xmlPullParser);
            } else if (bki.b(xmlPullParser, "SegmentURL")) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(a(xmlPullParser, "media", "mediaRange"));
            }
        } while (!bki.a(xmlPullParser, "SegmentList"));
        if (biaVar != null) {
            if (bhtVarD == null) {
                bhtVarD = biaVar.f2691a;
            }
            if (listC == null) {
                listC = biaVar.f;
            }
            if (arrayList == null) {
                arrayList = biaVar.g;
            }
        }
        return new bia(bhtVarD, jB, jB2, iA, jB3, listC, arrayList);
    }

    private final bib a(XmlPullParser xmlPullParser, bib bibVar) throws XmlPullParserException, IOException {
        long jB = b(xmlPullParser, "timescale", bibVar != null ? bibVar.f2692b : 1L);
        long jB2 = b(xmlPullParser, "presentationTimeOffset", bibVar != null ? bibVar.c : 0L);
        long jB3 = b(xmlPullParser, "duration", bibVar != null ? bibVar.e : -9223372036854775807L);
        int iA = a(xmlPullParser, "startNumber", bibVar != null ? bibVar.d : 1);
        bht bhtVarD = null;
        bif bifVarA = a(xmlPullParser, "media", bibVar != null ? bibVar.h : null);
        bif bifVarA2 = a(xmlPullParser, "initialization", bibVar != null ? bibVar.g : null);
        List<bic> listC = null;
        do {
            xmlPullParser.next();
            if (bki.b(xmlPullParser, "Initialization")) {
                bhtVarD = d(xmlPullParser);
            } else if (bki.b(xmlPullParser, "SegmentTimeline")) {
                listC = c(xmlPullParser);
            }
        } while (!bki.a(xmlPullParser, "SegmentTemplate"));
        if (bibVar != null) {
            if (bhtVarD == null) {
                bhtVarD = bibVar.f2691a;
            }
            if (listC == null) {
                listC = bibVar.f;
            }
        }
        return new bib(bhtVarD, jB, jB2, iA, jB3, listC, bifVarA2, bifVarA);
    }

    private static List<bic> c(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        long jB = 0;
        do {
            xmlPullParser.next();
            if (bki.b(xmlPullParser, "S")) {
                jB = b(xmlPullParser, "t", jB);
                long jB2 = b(xmlPullParser, "d", -9223372036854775807L);
                int iA = a(xmlPullParser, "r", 0) + 1;
                for (int i = 0; i < iA; i++) {
                    arrayList.add(new bic(jB, jB2));
                    jB += jB2;
                }
            }
        } while (!bki.a(xmlPullParser, "SegmentTimeline"));
        return arrayList;
    }

    private static bif a(XmlPullParser xmlPullParser, String str, bif bifVar) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue != null ? bif.a(attributeValue) : bifVar;
    }

    private final bht d(XmlPullParser xmlPullParser) {
        return a(xmlPullParser, "sourceURL", "range");
    }

    private static bht a(XmlPullParser xmlPullParser, String str, String str2) throws NumberFormatException {
        long j;
        long j2;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
        if (attributeValue2 != null) {
            String[] strArrSplit = attributeValue2.split("-");
            j = Long.parseLong(strArrSplit[0]);
            if (strArrSplit.length == 2) {
                j2 = (Long.parseLong(strArrSplit[1]) - j) + 1;
            }
            return new bht(attributeValue, j, j2);
        }
        j = 0;
        j2 = -1;
        return new bht(attributeValue, j, j2);
    }

    private static int e(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int iA = "urn:mpeg:dash:23003:3:audio_channel_configuration:2011".equals(b(xmlPullParser, "schemeIdUri", (String) null)) ? a(xmlPullParser, "value", -1) : -1;
        do {
            xmlPullParser.next();
        } while (!bki.a(xmlPullParser, "AudioChannelConfiguration"));
        return iA;
    }

    private static boolean a(String str) {
        return bjv.c(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/cea-708".equals(str) || "application/cea-608".equals(str);
    }

    private static int a(int i, int i2) {
        if (i == -1) {
            return i2;
        }
        if (i2 == -1) {
            return i;
        }
        bjq.b(i == i2);
        return i;
    }

    private static bhr a(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String strB = b(xmlPullParser, "schemeIdUri", BuildConfig.FLAVOR);
        String strB2 = b(xmlPullParser, "value", (String) null);
        String strB3 = b(xmlPullParser, "id", (String) null);
        do {
            xmlPullParser.next();
        } while (!bki.a(xmlPullParser, str));
        return new bhr(strB, strB2, strB3);
    }

    private static float a(XmlPullParser xmlPullParser, float f) throws NumberFormatException {
        String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue == null) {
            return f;
        }
        Matcher matcher = f2679a.matcher(attributeValue);
        if (!matcher.matches()) {
            return f;
        }
        int i = Integer.parseInt(matcher.group(1));
        return !TextUtils.isEmpty(matcher.group(2)) ? i / Integer.parseInt(r2) : i;
    }

    private static long a(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : bkg.d(attributeValue);
    }

    private static String b(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        xmlPullParser.next();
        return bkf.a(str, xmlPullParser.getText());
    }

    private static int a(XmlPullParser xmlPullParser, String str, int i) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? i : Integer.parseInt(attributeValue);
    }

    private static long b(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : Long.parseLong(attributeValue);
    }

    private static String b(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? str2 : attributeValue;
    }
}
