package com.ccs.craftlink;

import android.graphics.Bitmap;

public class NativeRender {
    
    static {
        System.loadLibrary("craftrender");
    }

    /**
     * Initializes the C++ rendering engine by mapping the dictionaries into memory.
     * @param atlasPath Path to the generated Texture Atlas map
     * @param mapPath Path to the generated Protocol-Item dictionary
     */
    public native void initEngine(String atlasPath, String mapPath);

    /**
     * O(1) NDK lookup and rendering of the requested Minecraft Item to a Bitmap.
     * @param protocolVersion The Minecraft Protocol Version (e.g., 47 for 1.8.9, 759 for 1.19)
     * @param itemId The raw numerical ID sent by the server
     * @return The rendered 2D Bitmap (isometric 3D block or 2D item sprite)
     */
    public native Bitmap renderItem(int protocolVersion, int itemId);
}
