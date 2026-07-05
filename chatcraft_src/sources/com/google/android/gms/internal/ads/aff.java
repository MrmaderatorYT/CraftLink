package com.google.android.gms.internal.ads;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@qj
/* loaded from: classes.dex */
public final class aff extends aex {
    private static final Set<String> d = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat e = new DecimalFormat("#,###");
    private File f;
    private boolean g;

    public aff(adk adkVar) {
        super(adkVar);
        File cacheDir = this.f1915a.getCacheDir();
        if (cacheDir == null) {
            xe.e("Context.getCacheDir() returned null");
            return;
        }
        this.f = new File(cacheDir, "admobVideoStreams");
        if (!this.f.isDirectory() && !this.f.mkdirs()) {
            String strValueOf = String.valueOf(this.f.getAbsolutePath());
            xe.e(strValueOf.length() != 0 ? "Could not create preload cache directory at ".concat(strValueOf) : new String("Could not create preload cache directory at "));
            this.f = null;
        } else {
            if (this.f.setReadable(true, false) && this.f.setExecutable(true, false)) {
                return;
            }
            String strValueOf2 = String.valueOf(this.f.getAbsolutePath());
            xe.e(strValueOf2.length() != 0 ? "Could not set cache file permissions at ".concat(strValueOf2) : new String("Could not set cache file permissions at "));
            this.f = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01fd, code lost:
    
        if (r1 < 400) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0201, code lost:
    
        r3 = java.lang.String.valueOf(java.lang.Integer.toString(r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x020f, code lost:
    
        if (r3.length() == 0) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0211, code lost:
    
        r3 = "HTTP request failed. Code: ".concat(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0217, code lost:
    
        r3 = new java.lang.String("HTTP request failed. Code: ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x021c, code lost:
    
        r5 = new java.lang.StringBuilder(java.lang.String.valueOf(r31).length() + 32);
        r5.append("HTTP status code ");
        r5.append(r1);
        r5.append(" at ");
        r5.append(r31);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0244, code lost:
    
        throw new java.io.IOException(r5.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0245, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0246, code lost:
    
        r15 = "badUrl";
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0248, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0249, code lost:
    
        r15 = "badUrl";
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x024b, code lost:
    
        r7 = r5.getContentLength();
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x024f, code lost:
    
        if (r7 >= 0) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0251, code lost:
    
        r1 = java.lang.String.valueOf(r31);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x025b, code lost:
    
        if (r1.length() == 0) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x025d, code lost:
    
        r0 = "Stream cache aborted, missing content-length header at ".concat(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0262, code lost:
    
        r0 = new java.lang.String("Stream cache aborted, missing content-length header at ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0268, code lost:
    
        com.google.android.gms.internal.ads.xe.e(r0);
        a(r31, r12.getAbsolutePath(), "contentLengthMissing", null);
        com.google.android.gms.internal.ads.aff.d.remove(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0279, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x027a, code lost:
    
        r1 = com.google.android.gms.internal.ads.aff.e.format(r7);
        r3 = ((java.lang.Integer) com.google.android.gms.internal.ads.bra.e().a(com.google.android.gms.internal.ads.o.o)).intValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0291, code lost:
    
        if (r7 <= r3) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0293, code lost:
    
        r2 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 33) + java.lang.String.valueOf(r31).length());
        r2.append("Content length ");
        r2.append(r1);
        r2.append(" exceeds limit at ");
        r2.append(r31);
        com.google.android.gms.internal.ads.xe.e(r2.toString());
        r1 = java.lang.String.valueOf(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x02cc, code lost:
    
        if (r1.length() == 0) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x02ce, code lost:
    
        r0 = "File too big for full file cache. Size: ".concat(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x02d3, code lost:
    
        r0 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x02d9, code lost:
    
        a(r31, r12.getAbsolutePath(), "sizeExceeded", r0);
        com.google.android.gms.internal.ads.aff.d.remove(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x02e7, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x02e8, code lost:
    
        r4 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 20) + java.lang.String.valueOf(r31).length());
        r4.append("Caching ");
        r4.append(r1);
        r4.append(" bytes from ");
        r4.append(r31);
        com.google.android.gms.internal.ads.xe.b(r4.toString());
        r5 = java.nio.channels.Channels.newChannel(r5.getInputStream());
        r4 = new java.io.FileOutputStream(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0323, code lost:
    
        r2 = r4.getChannel();
        r1 = java.nio.ByteBuffer.allocate(1048576);
        r16 = com.google.android.gms.ads.internal.ax.l();
        r17 = r16.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0341, code lost:
    
        r20 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0343, code lost:
    
        r10 = new com.google.android.gms.internal.ads.zr(((java.lang.Long) com.google.android.gms.internal.ads.bra.e().a(com.google.android.gms.internal.ads.o.r)).longValue());
        r13 = ((java.lang.Long) com.google.android.gms.internal.ads.bra.e().a(com.google.android.gms.internal.ads.o.q)).longValue();
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x035d, code lost:
    
        r21 = r5.read(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0361, code lost:
    
        if (r21 < 0) goto L286;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0363, code lost:
    
        r6 = r6 + r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0365, code lost:
    
        if (r6 <= r3) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0369, code lost:
    
        r2 = java.lang.String.valueOf(java.lang.Integer.toString(r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0377, code lost:
    
        if (r2.length() == 0) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0379, code lost:
    
        r10 = "File too big for full file cache. Size: ".concat(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0384, code lost:
    
        r10 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x038c, code lost:
    
        throw new java.io.IOException("stream cache file size limit exceeded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x038d, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x038e, code lost:
    
        r15 = "sizeExceeded";
        r3 = r10;
        r1 = r20;
        r10 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0395, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0396, code lost:
    
        r15 = "sizeExceeded";
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0399, code lost:
    
        r10 = r4;
        r1 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x039e, code lost:
    
        r1.flip();
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x03a5, code lost:
    
        if (r2.write(r1) > 0) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x03a7, code lost:
    
        r1.clear();
        r25 = ((r16.a() - r17) > (1000 * r13) ? 1 : ((r16.a() - r17) == (1000 * r13) ? 0 : -1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x03b8, code lost:
    
        if (r25 > 0) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x03bc, code lost:
    
        if (r30.g != false) goto L289;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x03c2, code lost:
    
        if (r10.a() == false) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x03c4, code lost:
    
        r26 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x03cc, code lost:
    
        r27 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x03d0, code lost:
    
        r22 = r1;
        r23 = r2;
        r24 = r3;
        r25 = r4;
        r11 = r5;
        r19 = r6;
        r29 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x03eb, code lost:
    
        com.google.android.gms.internal.ads.aac.f1778a.post(new com.google.android.gms.internal.ads.aey(r30, r31, r12.getAbsolutePath(), r6, r7, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x03f2, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x03f3, code lost:
    
        r25 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x03f7, code lost:
    
        r22 = r1;
        r23 = r2;
        r24 = r3;
        r25 = r4;
        r11 = r5;
        r19 = r6;
        r29 = r7;
        r26 = r10;
        r27 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x040a, code lost:
    
        r5 = r11;
        r6 = r19;
        r1 = r22;
        r2 = r23;
        r3 = r24;
        r4 = r25;
        r10 = r26;
        r15 = r27;
        r7 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x042b, code lost:
    
        throw new java.io.IOException("abort requested");
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x042c, code lost:
    
        r25 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0430, code lost:
    
        r15 = "downloadTimeout";
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0432, code lost:
    
        r0 = java.lang.Long.toString(r13);
        r2 = new java.lang.StringBuilder(java.lang.String.valueOf(r0).length() + 29);
        r2.append("Timeout exceeded. Limit: ");
        r2.append(r0);
        r2.append(" sec");
        r10 = r2.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x045d, code lost:
    
        throw new java.io.IOException("stream cache time limit exceeded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x045e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x045f, code lost:
    
        r3 = r10;
        r1 = r20;
        r10 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0466, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0469, code lost:
    
        r25 = r4;
        r27 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x046f, code lost:
    
        r25.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0476, code lost:
    
        if (com.google.android.gms.internal.ads.xe.a(3) == false) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0478, code lost:
    
        r1 = com.google.android.gms.internal.ads.aff.e.format(r6);
        r3 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 22) + java.lang.String.valueOf(r31).length());
        r3.append("Preloaded ");
        r3.append(r1);
        r3.append(" bytes from ");
        r3.append(r31);
        com.google.android.gms.internal.ads.xe.b(r3.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x04ae, code lost:
    
        r12.setReadable(true, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x04b7, code lost:
    
        if (r0.isFile() == false) goto L254;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x04b9, code lost:
    
        r0.setLastModified(java.lang.System.currentTimeMillis());
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x04c1, code lost:
    
        r0.createNewFile();
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x04d6, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x04d7, code lost:
    
        r1 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x04de, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x04df, code lost:
    
        r25 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x04e3, code lost:
    
        r1 = r20;
        r25 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x04e6, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x04e7, code lost:
    
        r25 = r4;
        r1 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x04ec, code lost:
    
        r10 = r25;
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01f2, code lost:
    
        if ((r5 instanceof java.net.HttpURLConnection) == false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01f4, code lost:
    
        r1 = r5.getResponseCode();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 27, insn: 0x0507: MOVE (r15 I:??[OBJECT, ARRAY]) = (r27 I:??[OBJECT, ARRAY]), block:B:212:0x0507 */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0514  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0524  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0571  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0587  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x058c  */
    /* JADX WARN: Type inference failed for: r25v2 */
    /* JADX WARN: Type inference failed for: r25v3 */
    /* JADX WARN: Type inference failed for: r25v8, types: [int] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.aex
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(java.lang.String r31) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aff.a(java.lang.String):boolean");
    }

    @Override // com.google.android.gms.internal.ads.aex
    public final void a() {
        this.g = true;
    }

    private final File a(File file) {
        return new File(this.f, String.valueOf(file.getName()).concat(".done"));
    }
}
