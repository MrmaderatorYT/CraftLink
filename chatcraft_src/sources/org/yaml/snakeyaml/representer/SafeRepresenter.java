package org.yaml.snakeyaml.representer;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes.dex */
class SafeRepresenter extends BaseRepresenter {
    public static Pattern BINARY_PATTERN = Pattern.compile("[\\x00-\\x08\\x0B\\x0C\\x0E-\\x1F]");
    public static Pattern MULTILINE_PATTERN = Pattern.compile("\n|\u0085|\u2028|\u2029");
    protected Map<Class<? extends Object>, Tag> classTags;
    protected TimeZone timeZone = null;

    public SafeRepresenter() {
        this.nullRepresenter = new RepresentNull();
        this.representers.put(String.class, new RepresentString());
        this.representers.put(Boolean.class, new RepresentBoolean());
        this.representers.put(Character.class, new RepresentString());
        this.representers.put(byte[].class, new RepresentByteArray());
        this.multiRepresenters.put(Number.class, new RepresentNumber());
        this.multiRepresenters.put(List.class, new RepresentList());
        this.multiRepresenters.put(Map.class, new RepresentMap());
        this.multiRepresenters.put(Set.class, new RepresentSet());
        this.multiRepresenters.put(Iterator.class, new RepresentIterator());
        this.multiRepresenters.put(new Object[0].getClass(), new RepresentArray());
        this.multiRepresenters.put(Date.class, new RepresentDate());
        this.multiRepresenters.put(Enum.class, new RepresentEnum());
        this.multiRepresenters.put(Calendar.class, new RepresentDate());
        this.classTags = new HashMap();
    }

    protected Tag getTag(Class<?> cls, Tag tag) {
        return this.classTags.containsKey(cls) ? this.classTags.get(cls) : tag;
    }

    public Tag addClassTag(Class<? extends Object> cls, String str) {
        return addClassTag(cls, new Tag(str));
    }

    public Tag addClassTag(Class<? extends Object> cls, Tag tag) {
        if (tag == null) {
            throw new NullPointerException("Tag must be provided.");
        }
        return this.classTags.put(cls, tag);
    }

    protected class RepresentNull implements Represent {
        protected RepresentNull() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            return SafeRepresenter.this.representScalar(Tag.NULL, "null");
        }
    }

    protected class RepresentString implements Represent {
        protected RepresentString() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            Character ch;
            Tag tag = Tag.STR;
            String string = obj.toString();
            if (SafeRepresenter.BINARY_PATTERN.matcher(string).find()) {
                tag = Tag.BINARY;
                try {
                    string = String.valueOf(Base64Coder.encode(string.getBytes("UTF-8")));
                    ch = '|';
                } catch (UnsupportedEncodingException e) {
                    throw new YAMLException(e);
                }
            } else {
                ch = null;
            }
            if (SafeRepresenter.this.defaultScalarStyle == null && SafeRepresenter.MULTILINE_PATTERN.matcher(string).find()) {
                ch = '|';
            }
            return SafeRepresenter.this.representScalar(tag, string, ch);
        }
    }

    protected class RepresentBoolean implements Represent {
        protected RepresentBoolean() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            return SafeRepresenter.this.representScalar(Tag.BOOL, Boolean.TRUE.equals(obj) ? "true" : "false");
        }
    }

    protected class RepresentNumber implements Represent {
        protected RepresentNumber() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            Tag tag;
            String string;
            if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof BigInteger)) {
                tag = Tag.INT;
                string = obj.toString();
            } else {
                Number number = (Number) obj;
                tag = Tag.FLOAT;
                if (number.equals(Double.valueOf(Double.NaN))) {
                    string = ".NaN";
                } else if (number.equals(Double.valueOf(Double.POSITIVE_INFINITY))) {
                    string = ".inf";
                } else {
                    string = number.equals(Double.valueOf(Double.NEGATIVE_INFINITY)) ? "-.inf" : number.toString();
                }
            }
            return SafeRepresenter.this.representScalar(SafeRepresenter.this.getTag(obj.getClass(), tag), string);
        }
    }

    protected class RepresentList implements Represent {
        protected RepresentList() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            return SafeRepresenter.this.representSequence(SafeRepresenter.this.getTag(obj.getClass(), Tag.SEQ), (List) obj, null);
        }
    }

    protected class RepresentIterator implements Represent {
        protected RepresentIterator() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            return SafeRepresenter.this.representSequence(SafeRepresenter.this.getTag(obj.getClass(), Tag.SEQ), new IteratorWrapper((Iterator) obj), null);
        }
    }

    private static class IteratorWrapper implements Iterable<Object> {
        private Iterator<Object> iter;

        public IteratorWrapper(Iterator<Object> it) {
            this.iter = it;
        }

        @Override // java.lang.Iterable
        public Iterator<Object> iterator() {
            return this.iter;
        }
    }

    protected class RepresentArray implements Represent {
        protected RepresentArray() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            return SafeRepresenter.this.representSequence(Tag.SEQ, Arrays.asList((Object[]) obj), null);
        }
    }

    protected class RepresentMap implements Represent {
        protected RepresentMap() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            return SafeRepresenter.this.representMapping(SafeRepresenter.this.getTag(obj.getClass(), Tag.MAP), (Map) obj, null);
        }
    }

    protected class RepresentSet implements Represent {
        protected RepresentSet() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = ((Set) obj).iterator();
            while (it.hasNext()) {
                linkedHashMap.put(it.next(), null);
            }
            return SafeRepresenter.this.representMapping(SafeRepresenter.this.getTag(obj.getClass(), Tag.SET), linkedHashMap, null);
        }
    }

    protected class RepresentDate implements Represent {
        protected RepresentDate() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            Calendar calendar;
            Object objValueOf;
            if (obj instanceof Calendar) {
                calendar = (Calendar) obj;
            } else {
                calendar = Calendar.getInstance(SafeRepresenter.this.getTimeZone() == null ? TimeZone.getTimeZone("UTC") : SafeRepresenter.this.timeZone);
                calendar.setTime((Date) obj);
            }
            int i = calendar.get(1);
            int i2 = calendar.get(2) + 1;
            int i3 = calendar.get(5);
            int i4 = calendar.get(11);
            int i5 = calendar.get(12);
            int i6 = calendar.get(13);
            int i7 = calendar.get(14);
            StringBuilder sb = new StringBuilder(String.valueOf(i));
            while (sb.length() < 4) {
                sb.insert(0, "0");
            }
            sb.append("-");
            if (i2 < 10) {
                sb.append("0");
            }
            sb.append(String.valueOf(i2));
            sb.append("-");
            if (i3 < 10) {
                sb.append("0");
            }
            sb.append(String.valueOf(i3));
            sb.append("T");
            if (i4 < 10) {
                sb.append("0");
            }
            sb.append(String.valueOf(i4));
            sb.append(":");
            if (i5 < 10) {
                sb.append("0");
            }
            sb.append(String.valueOf(i5));
            sb.append(":");
            if (i6 < 10) {
                sb.append("0");
            }
            sb.append(String.valueOf(i6));
            if (i7 > 0) {
                if (i7 < 10) {
                    sb.append(".00");
                } else if (i7 < 100) {
                    sb.append(".0");
                } else {
                    sb.append(".");
                }
                sb.append(String.valueOf(i7));
            }
            if (TimeZone.getTimeZone("UTC").equals(calendar.getTimeZone())) {
                sb.append("Z");
            } else {
                int offset = calendar.getTimeZone().getOffset(calendar.get(0), calendar.get(1), calendar.get(2), calendar.get(5), calendar.get(7), calendar.get(14)) / 60000;
                int i8 = offset / 60;
                int i9 = offset % 60;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i8 > 0 ? "+" : BuildConfig.FLAVOR);
                sb2.append(i8);
                sb2.append(":");
                if (i9 < 10) {
                    objValueOf = "0" + i9;
                } else {
                    objValueOf = Integer.valueOf(i9);
                }
                sb2.append(objValueOf);
                sb.append(sb2.toString());
            }
            return SafeRepresenter.this.representScalar(SafeRepresenter.this.getTag(obj.getClass(), Tag.TIMESTAMP), sb.toString(), null);
        }
    }

    protected class RepresentEnum implements Represent {
        protected RepresentEnum() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            return SafeRepresenter.this.representScalar(SafeRepresenter.this.getTag(obj.getClass(), new Tag((Class<? extends Object>) obj.getClass())), ((Enum) obj).name());
        }
    }

    protected class RepresentByteArray implements Represent {
        protected RepresentByteArray() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            return SafeRepresenter.this.representScalar(Tag.BINARY, String.valueOf(Base64Coder.encode((byte[]) obj)), '|');
        }
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }
}
