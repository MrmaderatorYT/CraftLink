package com.crashlytics.android.c;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: Utils.java */
/* loaded from: classes.dex */
final class ay {

    /* renamed from: a, reason: collision with root package name */
    private static final FilenameFilter f1333a = new FilenameFilter() { // from class: com.crashlytics.android.c.ay.1
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return true;
        }
    };

    static int a(File file, int i, Comparator<File> comparator) {
        return a(file, f1333a, i, comparator);
    }

    static int a(File file, FilenameFilter filenameFilter, int i, Comparator<File> comparator) {
        File[] fileArrListFiles = file.listFiles(filenameFilter);
        if (fileArrListFiles == null) {
            return 0;
        }
        int length = fileArrListFiles.length;
        Arrays.sort(fileArrListFiles, comparator);
        for (File file2 : fileArrListFiles) {
            if (length <= i) {
                return length;
            }
            file2.delete();
            length--;
        }
        return length;
    }
}
