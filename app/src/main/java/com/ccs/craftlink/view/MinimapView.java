package com.ccs.craftlink.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.ccs.craftlink.network.WorldTracker;

public class MinimapView extends View {

    private Paint backgroundPaint;
    private Paint playerPaint;
    
    // View dimensions
    private int width;
    private int height;
    
    // Player coordinates
    private double playerX = 0;
    private double playerZ = 0;
    
    private WorldTracker worldTracker;
    
    private static final int BLOCK_SIZE = 8; // Pixels per block
    
    public MinimapView(Context context) {
        super(context);
        init();
    }

    public MinimapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        backgroundPaint = new Paint();
        backgroundPaint.setColor(Color.parseColor("#4C8A3B")); // Base green for grass
        backgroundPaint.setStyle(Paint.Style.FILL);
        
        playerPaint = new Paint();
        playerPaint.setColor(Color.RED);
        playerPaint.setStyle(Paint.Style.FILL);
    }
    
    public void setWorldTracker(WorldTracker tracker) {
        this.worldTracker = tracker;
        invalidate();
    }
    
    public void updatePlayerPosition(double x, double z) {
        this.playerX = x;
        this.playerZ = z;
        invalidate(); // Redraw
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.width = w;
        this.height = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        
        canvas.drawRect(0, 0, width, height, backgroundPaint);
        
        int centerX = width / 2;
        int centerY = height / 2;
        
        int blocksX = (width / BLOCK_SIZE) / 2 + 2;
        int blocksZ = (height / BLOCK_SIZE) / 2 + 2;
        
        int pX = (int) Math.floor(playerX);
        int pZ = (int) Math.floor(playerZ);
        
        float offsetX = (float) (playerX - pX) * BLOCK_SIZE;
        float offsetZ = (float) (playerZ - pZ) * BLOCK_SIZE;
        
        Paint blockPaint = new Paint();
        blockPaint.setStyle(Paint.Style.FILL);
        
        if (worldTracker != null) {
            for (int dz = -blocksZ; dz <= blocksZ; dz++) {
                for (int dx = -blocksX; dx <= blocksX; dx++) {
                    int worldX = pX + dx;
                    int worldZ = pZ + dz;
                    
                    int chunkX = worldX >> 4;
                    int chunkZ = worldZ >> 4;
                    
                    int[] colors = worldTracker.getChunkColors(chunkX, chunkZ);
                    if (colors != null) {
                        int localX = worldX & 15;
                        int localZ = worldZ & 15;
                        int index = localX + localZ * 16;
                        int color = colors[index];
                        
                        if ((color >>> 24) != 0) {
                            blockPaint.setColor(color);
                            float drawX = centerX + dx * BLOCK_SIZE - offsetX;
                            float drawY = centerY + dz * BLOCK_SIZE - offsetZ;
                            canvas.drawRect(drawX, drawY, drawX + BLOCK_SIZE, drawY + BLOCK_SIZE, blockPaint);
                        }
                    } else {
                        // Chunk not loaded, draw checkerboard or grey
                        if ((chunkX + chunkZ) % 2 == 0) {
                            blockPaint.setColor(Color.parseColor("#40000000")); // Semi-transparent black
                            float drawX = centerX + dx * BLOCK_SIZE - offsetX;
                            float drawY = centerY + dz * BLOCK_SIZE - offsetZ;
                            canvas.drawRect(drawX, drawY, drawX + BLOCK_SIZE, drawY + BLOCK_SIZE, blockPaint);
                        }
                    }
                }
            }
        }
        
        // Draw Player
        canvas.drawCircle(centerX, centerY, BLOCK_SIZE / 2f, playerPaint);
        
        if (WorldTracker.lastError != null) {
            Paint textPaint = new Paint();
            textPaint.setColor(Color.WHITE);
            textPaint.setTextSize(30);
            textPaint.setShadowLayer(3, 0, 0, Color.BLACK);
            canvas.drawText("ERR: " + WorldTracker.lastError, 20, 50, textPaint);
        }
    }
}
