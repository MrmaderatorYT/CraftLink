package com.ccs.craftlink.network;

import android.content.Context;
import java.io.InputStream;
import java.io.DataInputStream;
import android.util.Log;

public class BlockColors {
    private static int[] COLORS;

    public static void load(Context context) {
        if (COLORS != null) return;
        try (InputStream is = context.getAssets().open("colors.bin");
             DataInputStream dis = new DataInputStream(is)) {
            
            // File size is multiple of 4
            int count = is.available() / 4;
            COLORS = new int[count];
            for (int i = 0; i < count; i++) {
                COLORS[i] = dis.readInt();
            }
        } catch (Exception e) {
            Log.e("BlockColors", "Failed to load colors.bin", e);
            COLORS = new int[0];
        }
    }

    public static int getColor(int stateId) {
        if (COLORS == null || stateId < 0 || stateId >= COLORS.length) return 0xFF000000;
        return COLORS[stateId];
    }
}
