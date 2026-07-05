package androidx.e.a;

import android.content.res.AssetManager;
import android.util.Log;
import com.github.steveice10.mc.v1_11.protocol.MinecraftConstants;
import com.github.steveice10.mc.v1_5.util.Constants;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: ExifInterface.java */
/* loaded from: classes.dex */
public class a {
    private static final Pattern X;
    private static final Pattern Y;
    private final String G;
    private final AssetManager.AssetInputStream H;
    private int I;
    private final HashMap<String, b>[] J = new HashMap[h.length];
    private Set<Integer> K = new HashSet(h.length);
    private ByteOrder L = ByteOrder.BIG_ENDIAN;
    private boolean M;
    private int N;
    private int O;
    private byte[] P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private boolean W;
    private static final List<Integer> k = Arrays.asList(1, 6, 3, 8);
    private static final List<Integer> l = Arrays.asList(2, 7, 4, 5);

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f692a = {8, 8, 8};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f693b = {4};
    public static final int[] c = {8};
    static final byte[] d = {-1, -40, -1};
    private static final byte[] m = {79, 76, 89, 77, 80, 0};
    private static final byte[] n = {79, 76, 89, 77, 80, 85, 83, 0, Constants.ObjectIds.THROWN_POTION, Constants.ObjectIds.THROWN_POTION};
    static final String[] e = {BuildConfig.FLAVOR, "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};
    static final int[] f = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] g = {65, 83, 67, Constants.ObjectIds.THROWN_POTION, Constants.ObjectIds.THROWN_POTION, 0, 0, 0};
    private static final c[] p = {new c("NewSubfileType", 254, 4), new c("SubfileType", 255, 4), new c("ImageWidth", 256, 3, 4), new c("ImageLength", 257, 3, 4), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273, 3, 4), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278, 3, 4), new c("StripByteCounts", 279, 3, 4), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", MinecraftConstants.PROTOCOL_VERSION, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("SensorTopBorder", 4, 4), new c("SensorLeftBorder", 5, 4), new c("SensorBottomBorder", 6, 4), new c("SensorRightBorder", 7, 4), new c("ISO", 23, 3), new c("JpgFromRaw", 46, 7)};
    private static final c[] q = {new c("ExposureTime", 33434, 5), new c("FNumber", 33437, 5), new c("ExposureProgram", 34850, 3), new c("SpectralSensitivity", 34852, 2), new c("PhotographicSensitivity", 34855, 3), new c("OECF", 34856, 7), new c("ExifVersion", 36864, 2), new c("DateTimeOriginal", 36867, 2), new c("DateTimeDigitized", 36868, 2), new c("ComponentsConfiguration", 37121, 7), new c("CompressedBitsPerPixel", 37122, 5), new c("ShutterSpeedValue", 37377, 10), new c("ApertureValue", 37378, 5), new c("BrightnessValue", 37379, 10), new c("ExposureBiasValue", 37380, 10), new c("MaxApertureValue", 37381, 5), new c("SubjectDistance", 37382, 5), new c("MeteringMode", 37383, 3), new c("LightSource", 37384, 3), new c("Flash", 37385, 3), new c("FocalLength", 37386, 5), new c("SubjectArea", 37396, 3), new c("MakerNote", 37500, 7), new c("UserComment", 37510, 7), new c("SubSecTime", 37520, 2), new c("SubSecTimeOriginal", 37521, 2), new c("SubSecTimeDigitized", 37522, 2), new c("FlashpixVersion", 40960, 7), new c("ColorSpace", 40961, 3), new c("PixelXDimension", 40962, 3, 4), new c("PixelYDimension", 40963, 3, 4), new c("RelatedSoundFile", 40964, 2), new c("InteroperabilityIFDPointer", 40965, 4), new c("FlashEnergy", 41483, 5), new c("SpatialFrequencyResponse", 41484, 7), new c("FocalPlaneXResolution", 41486, 5), new c("FocalPlaneYResolution", 41487, 5), new c("FocalPlaneResolutionUnit", 41488, 3), new c("SubjectLocation", 41492, 3), new c("ExposureIndex", 41493, 5), new c("SensingMethod", 41495, 3), new c("FileSource", 41728, 7), new c("SceneType", 41729, 7), new c("CFAPattern", 41730, 7), new c("CustomRendered", 41985, 3), new c("ExposureMode", 41986, 3), new c("WhiteBalance", 41987, 3), new c("DigitalZoomRatio", 41988, 5), new c("FocalLengthIn35mmFilm", 41989, 3), new c("SceneCaptureType", 41990, 3), new c("GainControl", 41991, 3), new c("Contrast", 41992, 3), new c("Saturation", 41993, 3), new c("Sharpness", 41994, 3), new c("DeviceSettingDescription", 41995, 7), new c("SubjectDistanceRange", 41996, 3), new c("ImageUniqueID", 42016, 2), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720, 3, 4)};
    private static final c[] r = {new c("GPSVersionID", 0, 1), new c("GPSLatitudeRef", 1, 2), new c("GPSLatitude", 2, 5), new c("GPSLongitudeRef", 3, 2), new c("GPSLongitude", 4, 5), new c("GPSAltitudeRef", 5, 1), new c("GPSAltitude", 6, 5), new c("GPSTimeStamp", 7, 5), new c("GPSSatellites", 8, 2), new c("GPSStatus", 9, 2), new c("GPSMeasureMode", 10, 2), new c("GPSDOP", 11, 5), new c("GPSSpeedRef", 12, 2), new c("GPSSpeed", 13, 5), new c("GPSTrackRef", 14, 2), new c("GPSTrack", 15, 5), new c("GPSImgDirectionRef", 16, 2), new c("GPSImgDirection", 17, 5), new c("GPSMapDatum", 18, 2), new c("GPSDestLatitudeRef", 19, 2), new c("GPSDestLatitude", 20, 5), new c("GPSDestLongitudeRef", 21, 2), new c("GPSDestLongitude", 22, 5), new c("GPSDestBearingRef", 23, 2), new c("GPSDestBearing", 24, 5), new c("GPSDestDistanceRef", 25, 2), new c("GPSDestDistance", 26, 5), new c("GPSProcessingMethod", 27, 7), new c("GPSAreaInformation", 28, 7), new c("GPSDateStamp", 29, 2), new c("GPSDifferential", 30, 3)};
    private static final c[] s = {new c("InteroperabilityIndex", 1, 2)};
    private static final c[] t = {new c("NewSubfileType", 254, 4), new c("SubfileType", 255, 4), new c("ThumbnailImageWidth", 256, 3, 4), new c("ThumbnailImageLength", 257, 3, 4), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273, 3, 4), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278, 3, 4), new c("StripByteCounts", 279, 3, 4), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", MinecraftConstants.PROTOCOL_VERSION, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720, 3, 4)};
    private static final c u = new c("StripOffsets", 273, 3);
    private static final c[] v = {new c("ThumbnailImage", 256, 7), new c("CameraSettingsIFDPointer", 8224, 4), new c("ImageProcessingIFDPointer", 8256, 4)};
    private static final c[] w = {new c("PreviewImageStart", 257, 4), new c("PreviewImageLength", 258, 4)};
    private static final c[] x = {new c("AspectFrame", 4371, 3)};
    private static final c[] y = {new c("ColorSpace", 55, 3)};
    static final c[][] h = {p, q, r, s, t, p, v, w, x, y};
    private static final c[] z = {new c("SubIFDPointer", 330, 4), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("InteroperabilityIFDPointer", 40965, 4), new c("CameraSettingsIFDPointer", 8224, 1), new c("ImageProcessingIFDPointer", 8256, 1)};
    private static final c A = new c("JPEGInterchangeFormat", 513, 4);
    private static final c B = new c("JPEGInterchangeFormatLength", 514, 4);
    private static final HashMap<Integer, c>[] C = new HashMap[h.length];
    private static final HashMap<String, c>[] D = new HashMap[h.length];
    private static final HashSet<String> E = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
    private static final HashMap<Integer, Integer> F = new HashMap<>();
    static final Charset i = Charset.forName("US-ASCII");
    static final byte[] j = "Exif\u0000\u0000".getBytes(i);
    private static SimpleDateFormat o = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");

    static {
        o.setTimeZone(TimeZone.getTimeZone("UTC"));
        for (int i2 = 0; i2 < h.length; i2++) {
            C[i2] = new HashMap<>();
            D[i2] = new HashMap<>();
            for (c cVar : h[i2]) {
                C[i2].put(Integer.valueOf(cVar.f698a), cVar);
                D[i2].put(cVar.f699b, cVar);
            }
        }
        F.put(Integer.valueOf(z[0].f698a), 5);
        F.put(Integer.valueOf(z[1].f698a), 1);
        F.put(Integer.valueOf(z[2].f698a), 2);
        F.put(Integer.valueOf(z[3].f698a), 3);
        F.put(Integer.valueOf(z[4].f698a), 7);
        F.put(Integer.valueOf(z[5].f698a), 8);
        X = Pattern.compile(".*[1-9].*");
        Y = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
    }

    /* compiled from: ExifInterface.java */
    private static class d {

        /* renamed from: a, reason: collision with root package name */
        public final long f700a;

        /* renamed from: b, reason: collision with root package name */
        public final long f701b;

        d(long j, long j2) {
            if (j2 == 0) {
                this.f700a = 0L;
                this.f701b = 1L;
            } else {
                this.f700a = j;
                this.f701b = j2;
            }
        }

        public String toString() {
            return this.f700a + "/" + this.f701b;
        }

        public double a() {
            double d = this.f700a;
            double d2 = this.f701b;
            Double.isNaN(d);
            Double.isNaN(d2);
            return d / d2;
        }
    }

    /* compiled from: ExifInterface.java */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f696a;

        /* renamed from: b, reason: collision with root package name */
        public final int f697b;
        public final byte[] c;

        b(int i, int i2, byte[] bArr) {
            this.f696a = i;
            this.f697b = i2;
            this.c = bArr;
        }

        public static b a(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[a.f[3] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i : iArr) {
                byteBufferWrap.putShort((short) i);
            }
            return new b(3, iArr.length, byteBufferWrap.array());
        }

        public static b a(int i, ByteOrder byteOrder) {
            return a(new int[]{i}, byteOrder);
        }

        public static b a(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[a.f[4] * jArr.length]);
            byteBufferWrap.order(byteOrder);
            for (long j : jArr) {
                byteBufferWrap.putInt((int) j);
            }
            return new b(4, jArr.length, byteBufferWrap.array());
        }

        public static b a(long j, ByteOrder byteOrder) {
            return a(new long[]{j}, byteOrder);
        }

        public static b a(String str) {
            byte[] bytes = (str + (char) 0).getBytes(a.i);
            return new b(2, bytes.length, bytes);
        }

        public static b a(d[] dVarArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[a.f[5] * dVarArr.length]);
            byteBufferWrap.order(byteOrder);
            for (d dVar : dVarArr) {
                byteBufferWrap.putInt((int) dVar.f700a);
                byteBufferWrap.putInt((int) dVar.f701b);
            }
            return new b(5, dVarArr.length, byteBufferWrap.array());
        }

        public static b a(d dVar, ByteOrder byteOrder) {
            return a(new d[]{dVar}, byteOrder);
        }

        public String toString() {
            return "(" + a.e[this.f696a] + ", data length:" + this.c.length + ")";
        }

        /* JADX WARN: Removed duplicated region for block: B:184:0x01dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        java.lang.Object a(java.nio.ByteOrder r9) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 518
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.e.a.a.b.a(java.nio.ByteOrder):java.lang.Object");
        }

        public double b(ByteOrder byteOrder) throws Throwable {
            Object objA = a(byteOrder);
            if (objA == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            }
            if (objA instanceof String) {
                return Double.parseDouble((String) objA);
            }
            if (objA instanceof long[]) {
                if (((long[]) objA).length == 1) {
                    return r4[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objA instanceof int[]) {
                if (((int[]) objA).length == 1) {
                    return r4[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objA instanceof double[]) {
                double[] dArr = (double[]) objA;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objA instanceof d[]) {
                d[] dVarArr = (d[]) objA;
                if (dVarArr.length == 1) {
                    return dVarArr[0].a();
                }
                throw new NumberFormatException("There are more than one component");
            }
            throw new NumberFormatException("Couldn't find a double value");
        }

        public int c(ByteOrder byteOrder) throws Throwable {
            Object objA = a(byteOrder);
            if (objA == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            if (objA instanceof String) {
                return Integer.parseInt((String) objA);
            }
            if (objA instanceof long[]) {
                long[] jArr = (long[]) objA;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objA instanceof int[]) {
                int[] iArr = (int[]) objA;
                if (iArr.length == 1) {
                    return iArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            throw new NumberFormatException("Couldn't find a integer value");
        }

        public String d(ByteOrder byteOrder) throws Throwable {
            Object objA = a(byteOrder);
            if (objA == null) {
                return null;
            }
            if (objA instanceof String) {
                return (String) objA;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (objA instanceof long[]) {
                long[] jArr = (long[]) objA;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (objA instanceof int[]) {
                int[] iArr = (int[]) objA;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (objA instanceof double[]) {
                double[] dArr = (double[]) objA;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (!(objA instanceof d[])) {
                return null;
            }
            d[] dVarArr = (d[]) objA;
            while (i < dVarArr.length) {
                sb.append(dVarArr[i].f700a);
                sb.append('/');
                sb.append(dVarArr[i].f701b);
                i++;
                if (i != dVarArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
    }

    /* compiled from: ExifInterface.java */
    static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f698a;

        /* renamed from: b, reason: collision with root package name */
        public final String f699b;
        public final int c;
        public final int d;

        c(String str, int i, int i2) {
            this.f699b = str;
            this.f698a = i;
            this.c = i2;
            this.d = -1;
        }

        c(String str, int i, int i2, int i3) {
            this.f699b = str;
            this.f698a = i;
            this.c = i2;
            this.d = i3;
        }

        boolean a(int i) {
            if (this.c == 7 || i == 7 || this.c == i || this.d == i) {
                return true;
            }
            if ((this.c == 4 || this.d == 4) && i == 3) {
                return true;
            }
            if ((this.c == 9 || this.d == 9) && i == 8) {
                return true;
            }
            return (this.c == 12 || this.d == 12) && i == 11;
        }
    }

    public a(String str) throws Throwable {
        if (str == null) {
            throw new IllegalArgumentException("filename cannot be null");
        }
        FileInputStream fileInputStream = null;
        this.H = null;
        this.G = str;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                a((InputStream) fileInputStream2);
                a((Closeable) fileInputStream2);
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                a((Closeable) fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private b b(String str) {
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        for (int i2 = 0; i2 < h.length; i2++) {
            b bVar = this.J[i2].get(str);
            if (bVar != null) {
                return bVar;
            }
        }
        return null;
    }

    public String a(String str) {
        b bVarB = b(str);
        if (bVarB == null) {
            return null;
        }
        if (!E.contains(str)) {
            return bVarB.d(this.L);
        }
        if (str.equals("GPSTimeStamp")) {
            if (bVarB.f696a != 5 && bVarB.f696a != 10) {
                Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + bVarB.f696a);
                return null;
            }
            d[] dVarArr = (d[]) bVarB.a(this.L);
            if (dVarArr == null || dVarArr.length != 3) {
                Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(dVarArr));
                return null;
            }
            return String.format("%02d:%02d:%02d", Integer.valueOf((int) (dVarArr[0].f700a / dVarArr[0].f701b)), Integer.valueOf((int) (dVarArr[1].f700a / dVarArr[1].f701b)), Integer.valueOf((int) (dVarArr[2].f700a / dVarArr[2].f701b)));
        }
        try {
            return Double.toString(bVarB.b(this.L));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public int a(String str, int i2) {
        b bVarB = b(str);
        if (bVarB == null) {
            return i2;
        }
        try {
            return bVarB.c(this.L);
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    private void a(InputStream inputStream) {
        for (int i2 = 0; i2 < h.length; i2++) {
            try {
                try {
                    this.J[i2] = new HashMap<>();
                } catch (IOException unused) {
                    this.W = false;
                }
            } finally {
                a();
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
        this.I = a(bufferedInputStream);
        C0045a c0045a = new C0045a(bufferedInputStream);
        switch (this.I) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
                a(c0045a);
                break;
            case 4:
                a(c0045a, 0, 0);
                break;
            case 7:
                c(c0045a);
                break;
            case 9:
                b(c0045a);
                break;
            case 10:
                d(c0045a);
                break;
        }
        f(c0045a);
        this.W = true;
    }

    private int a(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (a(bArr)) {
            return 4;
        }
        if (b(bArr)) {
            return 9;
        }
        if (c(bArr)) {
            return 7;
        }
        return d(bArr) ? 10 : 0;
    }

    private static boolean a(byte[] bArr) {
        for (int i2 = 0; i2 < d.length; i2++) {
            if (bArr[i2] != d[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean b(byte[] bArr) {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i2 = 0; i2 < bytes.length; i2++) {
            if (bArr[i2] != bytes[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean c(byte[] bArr) throws IOException {
        C0045a c0045a = new C0045a(bArr);
        this.L = e(c0045a);
        c0045a.a(this.L);
        short s2 = c0045a.readShort();
        c0045a.close();
        return s2 == 20306 || s2 == 21330;
    }

    private boolean d(byte[] bArr) throws IOException {
        C0045a c0045a = new C0045a(bArr);
        this.L = e(c0045a);
        c0045a.a(this.L);
        short s2 = c0045a.readShort();
        c0045a.close();
        return s2 == 85;
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x011d, code lost:
    
        r9.a(r8.L);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0122, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(androidx.e.a.a.C0045a r9, int r10, int r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.e.a.a.a(androidx.e.a.a$a, int, int):void");
    }

    private void a(C0045a c0045a) throws Throwable {
        b bVar;
        a(c0045a, c0045a.available());
        b(c0045a, 0);
        d(c0045a, 0);
        d(c0045a, 5);
        d(c0045a, 4);
        b((InputStream) c0045a);
        if (this.I != 8 || (bVar = this.J[1].get("MakerNote")) == null) {
            return;
        }
        C0045a c0045a2 = new C0045a(bVar.c);
        c0045a2.a(this.L);
        c0045a2.a(6L);
        b(c0045a2, 9);
        b bVar2 = this.J[9].get("ColorSpace");
        if (bVar2 != null) {
            this.J[1].put("ColorSpace", bVar2);
        }
    }

    private void b(C0045a c0045a) throws IOException {
        c0045a.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        c0045a.read(bArr);
        c0045a.skipBytes(4);
        c0045a.read(bArr2);
        int i2 = ByteBuffer.wrap(bArr).getInt();
        int i3 = ByteBuffer.wrap(bArr2).getInt();
        a(c0045a, i2, 5);
        c0045a.a(i3);
        c0045a.a(ByteOrder.BIG_ENDIAN);
        int i4 = c0045a.readInt();
        for (int i5 = 0; i5 < i4; i5++) {
            int unsignedShort = c0045a.readUnsignedShort();
            int unsignedShort2 = c0045a.readUnsignedShort();
            if (unsignedShort == u.f698a) {
                short s2 = c0045a.readShort();
                short s3 = c0045a.readShort();
                b bVarA = b.a((int) s2, this.L);
                b bVarA2 = b.a((int) s3, this.L);
                this.J[0].put("ImageLength", bVarA);
                this.J[0].put("ImageWidth", bVarA2);
                return;
            }
            c0045a.skipBytes(unsignedShort2);
        }
    }

    private void c(C0045a c0045a) throws Throwable {
        a(c0045a);
        b bVar = this.J[1].get("MakerNote");
        if (bVar != null) {
            C0045a c0045a2 = new C0045a(bVar.c);
            c0045a2.a(this.L);
            byte[] bArr = new byte[m.length];
            c0045a2.readFully(bArr);
            c0045a2.a(0L);
            byte[] bArr2 = new byte[n.length];
            c0045a2.readFully(bArr2);
            if (Arrays.equals(bArr, m)) {
                c0045a2.a(8L);
            } else if (Arrays.equals(bArr2, n)) {
                c0045a2.a(12L);
            }
            b(c0045a2, 6);
            b bVar2 = this.J[7].get("PreviewImageStart");
            b bVar3 = this.J[7].get("PreviewImageLength");
            if (bVar2 != null && bVar3 != null) {
                this.J[5].put("JPEGInterchangeFormat", bVar2);
                this.J[5].put("JPEGInterchangeFormatLength", bVar3);
            }
            b bVar4 = this.J[8].get("AspectFrame");
            if (bVar4 != null) {
                int[] iArr = (int[]) bVar4.a(this.L);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                if (iArr[2] <= iArr[0] || iArr[3] <= iArr[1]) {
                    return;
                }
                int i2 = (iArr[2] - iArr[0]) + 1;
                int i3 = (iArr[3] - iArr[1]) + 1;
                if (i2 < i3) {
                    int i4 = i2 + i3;
                    i3 = i4 - i3;
                    i2 = i4 - i3;
                }
                b bVarA = b.a(i2, this.L);
                b bVarA2 = b.a(i3, this.L);
                this.J[0].put("ImageWidth", bVarA);
                this.J[0].put("ImageLength", bVarA2);
            }
        }
    }

    private void d(C0045a c0045a) throws Throwable {
        a(c0045a);
        if (this.J[0].get("JpgFromRaw") != null) {
            a(c0045a, this.V, 5);
        }
        b bVar = this.J[0].get("ISO");
        b bVar2 = this.J[1].get("PhotographicSensitivity");
        if (bVar == null || bVar2 != null) {
            return;
        }
        this.J[1].put("PhotographicSensitivity", bVar);
    }

    private void a(byte[] bArr, int i2) throws IOException {
        C0045a c0045a = new C0045a(bArr);
        a(c0045a, bArr.length);
        b(c0045a, i2);
    }

    private void a() {
        String strA = a("DateTimeOriginal");
        if (strA != null && a("DateTime") == null) {
            this.J[0].put("DateTime", b.a(strA));
        }
        if (a("ImageWidth") == null) {
            this.J[0].put("ImageWidth", b.a(0L, this.L));
        }
        if (a("ImageLength") == null) {
            this.J[0].put("ImageLength", b.a(0L, this.L));
        }
        if (a("Orientation") == null) {
            this.J[0].put("Orientation", b.a(0L, this.L));
        }
        if (a("LightSource") == null) {
            this.J[1].put("LightSource", b.a(0L, this.L));
        }
    }

    private ByteOrder e(C0045a c0045a) throws IOException {
        short s2 = c0045a.readShort();
        if (s2 == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s2 == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(s2));
    }

    private void a(C0045a c0045a, int i2) throws IOException {
        this.L = e(c0045a);
        c0045a.a(this.L);
        int unsignedShort = c0045a.readUnsignedShort();
        if (this.I != 7 && this.I != 10 && unsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(unsignedShort));
        }
        int i3 = c0045a.readInt();
        if (i3 < 8 || i3 >= i2) {
            throw new IOException("Invalid first Ifd offset: " + i3);
        }
        int i4 = i3 - 8;
        if (i4 <= 0 || c0045a.skipBytes(i4) == i4) {
            return;
        }
        throw new IOException("Couldn't jump to first Ifd: " + i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(androidx.e.a.a.C0045a r21, int r22) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 828
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.e.a.a.b(androidx.e.a.a$a, int):void");
    }

    private void c(C0045a c0045a, int i2) throws IOException {
        b bVar;
        b bVar2 = this.J[i2].get("ImageLength");
        b bVar3 = this.J[i2].get("ImageWidth");
        if ((bVar2 == null || bVar3 == null) && (bVar = this.J[i2].get("JPEGInterchangeFormat")) != null) {
            a(c0045a, bVar.c(this.L), i2);
        }
    }

    private void f(C0045a c0045a) throws Throwable {
        HashMap<String, b> map = this.J[4];
        b bVar = map.get("Compression");
        if (bVar != null) {
            this.Q = bVar.c(this.L);
            int i2 = this.Q;
            if (i2 != 1) {
                switch (i2) {
                    case 6:
                        a(c0045a, map);
                        break;
                }
            }
            if (a((HashMap) map)) {
                b(c0045a, map);
                return;
            }
            return;
        }
        this.Q = 6;
        a(c0045a, map);
    }

    private void a(C0045a c0045a, HashMap map) throws Throwable {
        b bVar = (b) map.get("JPEGInterchangeFormat");
        b bVar2 = (b) map.get("JPEGInterchangeFormatLength");
        if (bVar == null || bVar2 == null) {
            return;
        }
        int iC = bVar.c(this.L);
        int iMin = Math.min(bVar2.c(this.L), c0045a.available() - iC);
        if (this.I == 4 || this.I == 9 || this.I == 10) {
            iC += this.R;
        } else if (this.I == 7) {
            iC += this.S;
        }
        if (iC <= 0 || iMin <= 0) {
            return;
        }
        this.M = true;
        this.N = iC;
        this.O = iMin;
        if (this.G == null && this.H == null) {
            byte[] bArr = new byte[iMin];
            c0045a.a(iC);
            c0045a.readFully(bArr);
            this.P = bArr;
        }
    }

    private void b(C0045a c0045a, HashMap map) throws IOException {
        b bVar = (b) map.get("StripOffsets");
        b bVar2 = (b) map.get("StripByteCounts");
        if (bVar == null || bVar2 == null) {
            return;
        }
        long[] jArrA = a(bVar.a(this.L));
        long[] jArrA2 = a(bVar2.a(this.L));
        if (jArrA == null) {
            Log.w("ExifInterface", "stripOffsets should not be null.");
            return;
        }
        if (jArrA2 == null) {
            Log.w("ExifInterface", "stripByteCounts should not be null.");
            return;
        }
        long j2 = 0;
        for (long j3 : jArrA2) {
            j2 += j3;
        }
        byte[] bArr = new byte[(int) j2];
        int i2 = 0;
        int length = 0;
        for (int i3 = 0; i3 < jArrA.length; i3++) {
            int i4 = (int) jArrA[i3];
            int i5 = (int) jArrA2[i3];
            int i6 = i4 - i2;
            if (i6 < 0) {
                Log.d("ExifInterface", "Invalid strip offset value");
            }
            c0045a.a(i6);
            int i7 = i2 + i6;
            byte[] bArr2 = new byte[i5];
            c0045a.read(bArr2);
            i2 = i7 + i5;
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
            length += bArr2.length;
        }
        this.M = true;
        this.P = bArr;
        this.O = bArr.length;
    }

    private boolean a(HashMap map) throws Throwable {
        b bVar;
        b bVar2 = (b) map.get("BitsPerSample");
        if (bVar2 == null) {
            return false;
        }
        int[] iArr = (int[]) bVar2.a(this.L);
        if (Arrays.equals(f692a, iArr)) {
            return true;
        }
        if (this.I != 3 || (bVar = (b) map.get("PhotometricInterpretation")) == null) {
            return false;
        }
        int iC = bVar.c(this.L);
        return (iC == 1 && Arrays.equals(iArr, c)) || (iC == 6 && Arrays.equals(iArr, f692a));
    }

    private boolean b(HashMap map) {
        b bVar = (b) map.get("ImageLength");
        b bVar2 = (b) map.get("ImageWidth");
        if (bVar == null || bVar2 == null) {
            return false;
        }
        return bVar.c(this.L) <= 512 && bVar2.c(this.L) <= 512;
    }

    private void b(InputStream inputStream) throws Throwable {
        a(0, 5);
        a(0, 4);
        a(5, 4);
        b bVar = this.J[1].get("PixelXDimension");
        b bVar2 = this.J[1].get("PixelYDimension");
        if (bVar != null && bVar2 != null) {
            this.J[0].put("ImageWidth", bVar);
            this.J[0].put("ImageLength", bVar2);
        }
        if (this.J[4].isEmpty() && b(this.J[5])) {
            this.J[4] = this.J[5];
            this.J[5] = new HashMap<>();
        }
        if (b(this.J[4])) {
            return;
        }
        Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
    }

    private void d(C0045a c0045a, int i2) throws Throwable {
        b bVarA;
        b bVarA2;
        b bVar = this.J[i2].get("DefaultCropSize");
        b bVar2 = this.J[i2].get("SensorTopBorder");
        b bVar3 = this.J[i2].get("SensorLeftBorder");
        b bVar4 = this.J[i2].get("SensorBottomBorder");
        b bVar5 = this.J[i2].get("SensorRightBorder");
        if (bVar == null) {
            if (bVar2 != null && bVar3 != null && bVar4 != null && bVar5 != null) {
                int iC = bVar2.c(this.L);
                int iC2 = bVar4.c(this.L);
                int iC3 = bVar5.c(this.L);
                int iC4 = bVar3.c(this.L);
                if (iC2 <= iC || iC3 <= iC4) {
                    return;
                }
                b bVarA3 = b.a(iC2 - iC, this.L);
                b bVarA4 = b.a(iC3 - iC4, this.L);
                this.J[i2].put("ImageLength", bVarA3);
                this.J[i2].put("ImageWidth", bVarA4);
                return;
            }
            c(c0045a, i2);
            return;
        }
        if (bVar.f696a == 5) {
            d[] dVarArr = (d[]) bVar.a(this.L);
            if (dVarArr == null || dVarArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(dVarArr));
                return;
            }
            bVarA = b.a(dVarArr[0], this.L);
            bVarA2 = b.a(dVarArr[1], this.L);
        } else {
            int[] iArr = (int[]) bVar.a(this.L);
            if (iArr == null || iArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                return;
            }
            bVarA = b.a(iArr[0], this.L);
            bVarA2 = b.a(iArr[1], this.L);
        }
        this.J[i2].put("ImageWidth", bVarA);
        this.J[i2].put("ImageLength", bVarA2);
    }

    /* compiled from: ExifInterface.java */
    /* renamed from: androidx.e.a.a$a, reason: collision with other inner class name */
    private static class C0045a extends InputStream implements DataInput {
        private static final ByteOrder c = ByteOrder.LITTLE_ENDIAN;
        private static final ByteOrder d = ByteOrder.BIG_ENDIAN;

        /* renamed from: a, reason: collision with root package name */
        final int f694a;

        /* renamed from: b, reason: collision with root package name */
        int f695b;
        private DataInputStream e;
        private ByteOrder f;

        public C0045a(InputStream inputStream) {
            this.f = ByteOrder.BIG_ENDIAN;
            this.e = new DataInputStream(inputStream);
            this.f694a = this.e.available();
            this.f695b = 0;
            this.e.mark(this.f694a);
        }

        public C0045a(byte[] bArr) {
            this(new ByteArrayInputStream(bArr));
        }

        public void a(ByteOrder byteOrder) {
            this.f = byteOrder;
        }

        public void a(long j) throws IOException {
            if (this.f695b > j) {
                this.f695b = 0;
                this.e.reset();
                this.e.mark(this.f694a);
            } else {
                j -= this.f695b;
            }
            int i = (int) j;
            if (skipBytes(i) != i) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        public int a() {
            return this.f695b;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.e.available();
        }

        @Override // java.io.InputStream
        public int read() {
            this.f695b++;
            return this.e.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.e.read(bArr, i, i2);
            this.f695b += i3;
            return i3;
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() {
            this.f695b++;
            return this.e.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public String readLine() {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public boolean readBoolean() {
            this.f695b++;
            return this.e.readBoolean();
        }

        @Override // java.io.DataInput
        public char readChar() {
            this.f695b += 2;
            return this.e.readChar();
        }

        @Override // java.io.DataInput
        public String readUTF() {
            this.f695b += 2;
            return this.e.readUTF();
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i, int i2) throws IOException {
            this.f695b += i2;
            if (this.f695b > this.f694a) {
                throw new EOFException();
            }
            if (this.e.read(bArr, i, i2) != i2) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            this.f695b += bArr.length;
            if (this.f695b > this.f694a) {
                throw new EOFException();
            }
            if (this.e.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public byte readByte() throws EOFException {
            this.f695b++;
            if (this.f695b > this.f694a) {
                throw new EOFException();
            }
            int i = this.e.read();
            if (i >= 0) {
                return (byte) i;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            this.f695b += 2;
            if (this.f695b > this.f694a) {
                throw new EOFException();
            }
            int i = this.e.read();
            int i2 = this.e.read();
            if ((i | i2) < 0) {
                throw new EOFException();
            }
            if (this.f == c) {
                return (short) ((i2 << 8) + i);
            }
            if (this.f == d) {
                return (short) ((i << 8) + i2);
            }
            throw new IOException("Invalid byte order: " + this.f);
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            this.f695b += 4;
            if (this.f695b > this.f694a) {
                throw new EOFException();
            }
            int i = this.e.read();
            int i2 = this.e.read();
            int i3 = this.e.read();
            int i4 = this.e.read();
            if ((i | i2 | i3 | i4) < 0) {
                throw new EOFException();
            }
            if (this.f == c) {
                return (i4 << 24) + (i3 << 16) + (i2 << 8) + i;
            }
            if (this.f == d) {
                return (i << 24) + (i2 << 16) + (i3 << 8) + i4;
            }
            throw new IOException("Invalid byte order: " + this.f);
        }

        @Override // java.io.DataInput
        public int skipBytes(int i) {
            int iMin = Math.min(i, this.f694a - this.f695b);
            int iSkipBytes = 0;
            while (iSkipBytes < iMin) {
                iSkipBytes += this.e.skipBytes(iMin - iSkipBytes);
            }
            this.f695b += iSkipBytes;
            return iSkipBytes;
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            this.f695b += 2;
            if (this.f695b > this.f694a) {
                throw new EOFException();
            }
            int i = this.e.read();
            int i2 = this.e.read();
            if ((i | i2) < 0) {
                throw new EOFException();
            }
            if (this.f == c) {
                return (i2 << 8) + i;
            }
            if (this.f == d) {
                return (i << 8) + i2;
            }
            throw new IOException("Invalid byte order: " + this.f);
        }

        public long b() {
            return readInt() & 4294967295L;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            this.f695b += 8;
            if (this.f695b > this.f694a) {
                throw new EOFException();
            }
            int i = this.e.read();
            int i2 = this.e.read();
            int i3 = this.e.read();
            int i4 = this.e.read();
            int i5 = this.e.read();
            int i6 = this.e.read();
            int i7 = this.e.read();
            int i8 = this.e.read();
            if ((i | i2 | i3 | i4 | i5 | i6 | i7 | i8) < 0) {
                throw new EOFException();
            }
            if (this.f == c) {
                return (i8 << 56) + (i7 << 48) + (i6 << 40) + (i5 << 32) + (i4 << 24) + (i3 << 16) + (i2 << 8) + i;
            }
            if (this.f == d) {
                return (i << 56) + (i2 << 48) + (i3 << 40) + (i4 << 32) + (i5 << 24) + (i6 << 16) + (i7 << 8) + i8;
            }
            throw new IOException("Invalid byte order: " + this.f);
        }

        @Override // java.io.DataInput
        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }
    }

    private void a(int i2, int i3) throws Throwable {
        if (this.J[i2].isEmpty() || this.J[i3].isEmpty()) {
            return;
        }
        b bVar = this.J[i2].get("ImageLength");
        b bVar2 = this.J[i2].get("ImageWidth");
        b bVar3 = this.J[i3].get("ImageLength");
        b bVar4 = this.J[i3].get("ImageWidth");
        if (bVar == null || bVar2 == null || bVar3 == null || bVar4 == null) {
            return;
        }
        int iC = bVar.c(this.L);
        int iC2 = bVar2.c(this.L);
        int iC3 = bVar3.c(this.L);
        int iC4 = bVar4.c(this.L);
        if (iC >= iC3 || iC2 >= iC4) {
            return;
        }
        HashMap<String, b> map = this.J[i2];
        this.J[i2] = this.J[i3];
        this.J[i3] = map;
    }

    private static void a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    private static long[] a(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                jArr[i2] = iArr[i2];
            }
            return jArr;
        }
        if (obj instanceof long[]) {
            return (long[]) obj;
        }
        return null;
    }
}
