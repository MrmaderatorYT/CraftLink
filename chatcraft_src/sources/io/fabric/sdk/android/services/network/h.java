package io.fabric.sdk.android.services.network;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashMap;

/* compiled from: SystemKeyStore.java */
/* loaded from: classes.dex */
class h {

    /* renamed from: a, reason: collision with root package name */
    final KeyStore f4339a;

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<Principal, X509Certificate> f4340b;

    public h(InputStream inputStream, String str) throws IOException, KeyStoreException {
        KeyStore keyStoreA = a(inputStream, str);
        this.f4340b = a(keyStoreA);
        this.f4339a = keyStoreA;
    }

    public boolean a(X509Certificate x509Certificate) {
        X509Certificate x509Certificate2 = this.f4340b.get(x509Certificate.getSubjectX500Principal());
        return x509Certificate2 != null && x509Certificate2.getPublicKey().equals(x509Certificate.getPublicKey());
    }

    public X509Certificate b(X509Certificate x509Certificate) {
        X509Certificate x509Certificate2 = this.f4340b.get(x509Certificate.getIssuerX500Principal());
        if (x509Certificate2 == null || x509Certificate2.getSubjectX500Principal().equals(x509Certificate.getSubjectX500Principal())) {
            return null;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return x509Certificate2;
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    private HashMap<Principal, X509Certificate> a(KeyStore keyStore) throws KeyStoreException {
        try {
            HashMap<Principal, X509Certificate> map = new HashMap<>();
            Enumeration<String> enumerationAliases = keyStore.aliases();
            while (enumerationAliases.hasMoreElements()) {
                X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate(enumerationAliases.nextElement());
                if (x509Certificate != null) {
                    map.put(x509Certificate.getSubjectX500Principal(), x509Certificate);
                }
            }
            return map;
        } catch (KeyStoreException e) {
            throw new AssertionError(e);
        }
    }

    private KeyStore a(InputStream inputStream, String str) throws IOException, KeyStoreException {
        try {
            KeyStore keyStore = KeyStore.getInstance("BKS");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                keyStore.load(bufferedInputStream, str.toCharArray());
                return keyStore;
            } finally {
                bufferedInputStream.close();
            }
        } catch (IOException e) {
            throw new AssertionError(e);
        } catch (KeyStoreException e2) {
            throw new AssertionError(e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new AssertionError(e3);
        } catch (CertificateException e4) {
            throw new AssertionError(e4);
        }
    }
}
