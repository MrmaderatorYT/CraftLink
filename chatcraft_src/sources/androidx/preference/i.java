package androidx.preference;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: PreferenceInflater.java */
/* loaded from: classes.dex */
class i {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?>[] f991a = {Context.class, AttributeSet.class};

    /* renamed from: b, reason: collision with root package name */
    private static final HashMap<String, Constructor> f992b = new HashMap<>();
    private final Context c;
    private final Object[] d = new Object[2];
    private j e;
    private String[] f;

    public i(Context context, j jVar) {
        this.c = context;
        a(jVar);
    }

    private void a(j jVar) {
        this.e = jVar;
        a(new String[]{Preference.class.getPackage().getName() + ".", SwitchPreference.class.getPackage().getName() + "."});
    }

    public void a(String[] strArr) {
        this.f = strArr;
    }

    public Context a() {
        return this.c;
    }

    public Preference a(int i, PreferenceGroup preferenceGroup) throws Resources.NotFoundException {
        XmlResourceParser xml = a().getResources().getXml(i);
        try {
            return a(xml, preferenceGroup);
        } finally {
            xml.close();
        }
    }

    public Preference a(XmlPullParser xmlPullParser, PreferenceGroup preferenceGroup) {
        int next;
        PreferenceGroup preferenceGroupA;
        synchronized (this.d) {
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
            this.d[0] = this.c;
            do {
                try {
                    next = xmlPullParser.next();
                    if (next == 2) {
                        break;
                    }
                } catch (InflateException e) {
                    throw e;
                } catch (IOException e2) {
                    InflateException inflateException = new InflateException(xmlPullParser.getPositionDescription() + ": " + e2.getMessage());
                    inflateException.initCause(e2);
                    throw inflateException;
                } catch (XmlPullParserException e3) {
                    InflateException inflateException2 = new InflateException(e3.getMessage());
                    inflateException2.initCause(e3);
                    throw inflateException2;
                }
            } while (next != 1);
            if (next != 2) {
                throw new InflateException(xmlPullParser.getPositionDescription() + ": No start tag found!");
            }
            preferenceGroupA = a(preferenceGroup, (PreferenceGroup) b(xmlPullParser.getName(), attributeSetAsAttributeSet));
            a(xmlPullParser, preferenceGroupA, attributeSetAsAttributeSet);
        }
        return preferenceGroupA;
    }

    private PreferenceGroup a(PreferenceGroup preferenceGroup, PreferenceGroup preferenceGroup2) {
        if (preferenceGroup != null) {
            return preferenceGroup;
        }
        preferenceGroup2.a(this.e);
        return preferenceGroup2;
    }

    private Preference a(String str, String[] strArr, AttributeSet attributeSet) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Class<?> clsLoadClass;
        Constructor<?> constructor = f992b.get(str);
        if (constructor == null) {
            try {
                try {
                    ClassLoader classLoader = this.c.getClassLoader();
                    if (strArr == null || strArr.length == 0) {
                        clsLoadClass = classLoader.loadClass(str);
                    } else {
                        int length = strArr.length;
                        int i = 0;
                        clsLoadClass = null;
                        ClassNotFoundException e = null;
                        while (true) {
                            if (i >= length) {
                                break;
                            }
                            try {
                                clsLoadClass = classLoader.loadClass(strArr[i] + str);
                                break;
                            } catch (ClassNotFoundException e2) {
                                e = e2;
                                i++;
                            }
                        }
                        if (clsLoadClass == null) {
                            if (e == null) {
                                throw new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                            }
                            throw e;
                        }
                    }
                    constructor = clsLoadClass.getConstructor(f991a);
                    constructor.setAccessible(true);
                    f992b.put(str, constructor);
                } catch (Exception e3) {
                    InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                    inflateException.initCause(e3);
                    throw inflateException;
                }
            } catch (ClassNotFoundException e4) {
                throw e4;
            }
        }
        Object[] objArr = this.d;
        objArr[1] = attributeSet;
        return (Preference) constructor.newInstance(objArr);
    }

    protected Preference a(String str, AttributeSet attributeSet) {
        return a(str, this.f, attributeSet);
    }

    private Preference b(String str, AttributeSet attributeSet) {
        try {
            if (-1 == str.indexOf(46)) {
                return a(str, attributeSet);
            }
            return a(str, (String[]) null, attributeSet);
        } catch (InflateException e) {
            throw e;
        } catch (ClassNotFoundException e2) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class (not found)" + str);
            inflateException.initCause(e2);
            throw inflateException;
        } catch (Exception e3) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e3);
            throw inflateException2;
        }
    }

    private void a(XmlPullParser xmlPullParser, Preference preference, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                String name = xmlPullParser.getName();
                if ("intent".equals(name)) {
                    try {
                        preference.a(Intent.parseIntent(a().getResources(), xmlPullParser, attributeSet));
                    } catch (IOException e) {
                        XmlPullParserException xmlPullParserException = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException.initCause(e);
                        throw xmlPullParserException;
                    }
                } else if ("extra".equals(name)) {
                    a().getResources().parseBundleExtra("extra", attributeSet, preference.u());
                    try {
                        a(xmlPullParser);
                    } catch (IOException e2) {
                        XmlPullParserException xmlPullParserException2 = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException2.initCause(e2);
                        throw xmlPullParserException2;
                    }
                } else {
                    Preference preferenceB = b(name, attributeSet);
                    ((PreferenceGroup) preference).b(preferenceB);
                    a(xmlPullParser, preferenceB, attributeSet);
                }
            }
        }
    }

    private static void a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return;
            }
        }
    }
}
