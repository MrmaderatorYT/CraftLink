package org.yaml.snakeyaml.error;

import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.yaml.snakeyaml.scanner.Constant;

/* loaded from: classes.dex */
public final class Mark {
    private String buffer;
    private int column;
    private int index;
    private int line;
    private String name;
    private int pointer;

    public Mark(String str, int i, int i2, int i3, String str2, int i4) {
        this.name = str;
        this.index = i;
        this.line = i2;
        this.column = i3;
        this.buffer = str2;
        this.pointer = i4;
    }

    private boolean isLineBreak(char c) {
        return Constant.NULL_OR_LINEBR.has(c);
    }

    public String get_snippet(int i, int i2) {
        if (this.buffer == null) {
            return null;
        }
        float f = (i2 / 2) - 1;
        int i3 = this.pointer;
        String str = BuildConfig.FLAVOR;
        while (true) {
            if (i3 <= 0 || isLineBreak(this.buffer.charAt(i3 - 1))) {
                break;
            }
            i3--;
            if (this.pointer - i3 > f) {
                str = " ... ";
                i3 += 5;
                break;
            }
        }
        String str2 = BuildConfig.FLAVOR;
        int i4 = this.pointer;
        while (true) {
            if (i4 >= this.buffer.length() || isLineBreak(this.buffer.charAt(i4))) {
                break;
            }
            i4++;
            if (i4 - this.pointer > f) {
                str2 = " ... ";
                i4 -= 5;
                break;
            }
        }
        String strSubstring = this.buffer.substring(i3, i4);
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < i; i5++) {
            sb.append(" ");
        }
        sb.append(str);
        sb.append(strSubstring);
        sb.append(str2);
        sb.append("\n");
        for (int i6 = 0; i6 < ((this.pointer + i) - i3) + str.length(); i6++) {
            sb.append(" ");
        }
        sb.append("^");
        return sb.toString();
    }

    public String get_snippet() {
        return get_snippet(4, 75);
    }

    public String toString() {
        String str = get_snippet();
        StringBuilder sb = new StringBuilder(" in \"");
        sb.append(this.name);
        sb.append("\", line ");
        sb.append(this.line + 1);
        sb.append(", column ");
        sb.append(this.column + 1);
        if (str != null) {
            sb.append(":\n");
            sb.append(str);
        }
        return sb.toString();
    }

    public String getName() {
        return this.name;
    }

    public int getLine() {
        return this.line;
    }

    public int getColumn() {
        return this.column;
    }

    public int getIndex() {
        return this.index;
    }
}
