package com.github.steveice10.mc.auth.util;

import com.github.steveice10.mc.auth.exception.request.InvalidCredentialsException;
import com.github.steveice10.mc.auth.exception.request.RequestException;
import com.github.steveice10.mc.auth.exception.request.ServiceUnavailableException;
import com.github.steveice10.mc.auth.exception.request.UserMigratedException;
import com.google.gson.f;
import com.google.gson.g;
import com.google.gson.l;
import com.google.gson.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.UUID;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public class HTTP {
    private static final f GSON = new g().a(UUID.class, new UUIDSerializer()).a();

    private HTTP() {
    }

    public static void makeRequest(Proxy proxy, String str, Object obj) {
        makeRequest(proxy, str, obj, null);
    }

    public static <T> T makeRequest(Proxy proxy, String str, Object obj, Class<T> cls) throws RequestException {
        try {
            l lVar = (l) GSON.a(obj == null ? performGetRequest(proxy, str) : performPostRequest(proxy, str, GSON.a(obj), "application/json"), (Class) l.class);
            if (lVar == null) {
                return null;
            }
            if (lVar.i()) {
                n nVarL = lVar.l();
                if (nVarL.a("error")) {
                    String strC = nVarL.b("error").c();
                    String strC2 = nVarL.a("cause") ? nVarL.b("cause").c() : BuildConfig.FLAVOR;
                    String strC3 = nVarL.a("errorMessage") ? nVarL.b("errorMessage").c() : BuildConfig.FLAVOR;
                    if (!strC.equals(BuildConfig.FLAVOR)) {
                        if (strC.equals("ForbiddenOperationException")) {
                            if (strC2 != null && strC2.equals("UserMigratedException")) {
                                throw new UserMigratedException(strC3);
                            }
                            throw new InvalidCredentialsException(strC3);
                        }
                        throw new RequestException(strC3);
                    }
                }
            }
            if (cls != null) {
                return (T) GSON.a(lVar, (Class) cls);
            }
            return null;
        } catch (Exception e) {
            throw new ServiceUnavailableException("Could not make request to '" + str + "'.", e);
        }
    }

    private static HttpURLConnection createUrlConnection(Proxy proxy, String str) {
        if (proxy == null) {
            throw new IllegalArgumentException("Proxy cannot be null.");
        }
        if (str == null) {
            throw new IllegalArgumentException("URL cannot be null.");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection(proxy);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setUseCaches(false);
        return httpURLConnection;
    }

    private static String performGetRequest(Proxy proxy, String str) throws IOException {
        InputStream errorStream;
        if (proxy == null) {
            throw new IllegalArgumentException("Proxy cannot be null.");
        }
        if (str == null) {
            throw new IllegalArgumentException("URL cannot be null.");
        }
        HttpURLConnection httpURLConnectionCreateUrlConnection = createUrlConnection(proxy, str);
        httpURLConnectionCreateUrlConnection.setDoInput(true);
        InputStream inputStream = null;
        try {
            if (httpURLConnectionCreateUrlConnection.getResponseCode() == 200) {
                errorStream = httpURLConnectionCreateUrlConnection.getInputStream();
            } else {
                errorStream = httpURLConnectionCreateUrlConnection.getErrorStream();
            }
            inputStream = errorStream;
            if (inputStream == null) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return BuildConfig.FLAVOR;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
                sb.append("\n");
            }
            String string = sb.toString();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            return string;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    private static String performPostRequest(Proxy proxy, String str, String str2, String str3) throws Throwable {
        InputStream errorStream;
        if (proxy == null) {
            throw new IllegalArgumentException("Proxy cannot be null.");
        }
        if (str == null) {
            throw new IllegalArgumentException("URL cannot be null.");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("Post cannot be null.");
        }
        if (str3 == null) {
            throw new IllegalArgumentException("Type cannot be null.");
        }
        byte[] bytes = str2.getBytes("UTF-8");
        HttpURLConnection httpURLConnectionCreateUrlConnection = createUrlConnection(proxy, str);
        httpURLConnectionCreateUrlConnection.setRequestProperty("Content-Type", str3 + "; charset=utf-8");
        httpURLConnectionCreateUrlConnection.setRequestProperty("Content-Length", String.valueOf(bytes.length));
        httpURLConnectionCreateUrlConnection.setDoInput(true);
        httpURLConnectionCreateUrlConnection.setDoOutput(true);
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            OutputStream outputStream2 = httpURLConnectionCreateUrlConnection.getOutputStream();
            try {
                outputStream2.write(bytes);
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException unused) {
                    }
                }
                try {
                    if (httpURLConnectionCreateUrlConnection.getResponseCode() == 200) {
                        errorStream = httpURLConnectionCreateUrlConnection.getInputStream();
                    } else {
                        errorStream = httpURLConnectionCreateUrlConnection.getErrorStream();
                    }
                    inputStream = errorStream;
                    if (inputStream == null) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return BuildConfig.FLAVOR;
                    }
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                        sb.append("\n");
                    }
                    String string = sb.toString();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return string;
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = outputStream2;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
