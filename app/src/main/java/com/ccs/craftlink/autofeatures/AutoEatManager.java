package com.ccs.craftlink.autofeatures;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.ccs.craftlink.network.MinecraftConnection;
import com.ccs.craftlink.network.ServerManager;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AutoEatManager {
    private static final String TAG = "AutoEatManager";
    private static AutoEatManager instance;

    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final java.util.Random random = new java.util.Random();
    private final java.util.concurrent.atomic.AtomicBoolean isEating = new java.util.concurrent.atomic.AtomicBoolean(false);

    private boolean enabled = false;
    private int hungerThreshold = 14;
    private int healthThreshold = 16;
    private long lastEatTime = 0;
    private static final long EAT_COOLDOWN_MS = 30000;
    private static final long EAT_USE_DELAY_MS = 1700;

    private volatile int currentHealth = 20;
    private volatile int currentHunger = 20;
    private final io.reactivex.rxjava3.subjects.BehaviorSubject<int[]> statusSubject =
            io.reactivex.rxjava3.subjects.BehaviorSubject.createDefault(new int[]{20, 20});

    private Runnable eatCheckRunnable;

    private static final int[] FOOD_IDS = {
        363, 364, 366, 365, 367, 463, 464,
        297, 322, 396, 260, 391, 392, 393,
        597, 282, 283, 360, 457, 688,
        610, 611, 612, 613, 614, 615, 616, 617, 618, 619
    };

    public interface AutoEatListener {
        void onEatAction(String foodName);
        void onStatusBar(int health, int hunger);
    }

    private AutoEatListener listener;

    public static AutoEatManager getInstance() {
        if (instance == null) instance = new AutoEatManager();
        return instance;
    }

    public void setListener(AutoEatListener listener) { this.listener = listener; }
    public boolean isEnabled() { return enabled; }
    public int getHungerThreshold() { return hungerThreshold; }
    public int getHealthThreshold() { return healthThreshold; }
    public int getCurrentHealth() { return currentHealth; }
    public int getCurrentHunger() { return currentHunger; }

    public io.reactivex.rxjava3.core.Observable<int[]> observeStatus() {
        return statusSubject;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        Log.i(TAG, "Auto-Eat " + (enabled ? "enabled" : "disabled"));
        if (enabled) startEatCheck(); else stopEatCheck();
    }

    public void setHungerThreshold(int t) { this.hungerThreshold = t; }
    public void setHealthThreshold(int t) { this.healthThreshold = t; }

    public void onFoodLevelChange(int hunger) {
        this.currentHunger = hunger;
        statusSubject.onNext(new int[]{currentHealth, currentHunger});
        if (listener != null) listener.onStatusBar(currentHealth, currentHunger);
        if (enabled && hunger <= hungerThreshold) scheduleEat();
    }

    public void onHealthChange(int health) {
        this.currentHealth = health;
        statusSubject.onNext(new int[]{currentHealth, currentHunger});
        if (listener != null) listener.onStatusBar(currentHealth, currentHunger);
        if (listener != null) listener.onStatusBar(currentHealth, currentHunger);
        if (enabled && health <= healthThreshold) scheduleEat();
    }

    private void startEatCheck() {
        stopEatCheck();
        eatCheckRunnable = new Runnable() {
            @Override
            public void run() {
                if (!enabled) return;
                checkAndEat();
                mainHandler.postDelayed(this, 5000);
            }
        };
        mainHandler.postDelayed(eatCheckRunnable, 3000);
    }

    private void stopEatCheck() {
        if (eatCheckRunnable != null) {
            mainHandler.removeCallbacks(eatCheckRunnable);
            eatCheckRunnable = null;
        }
    }

    private void scheduleEat() {
        if (System.currentTimeMillis() - lastEatTime < EAT_COOLDOWN_MS) return;
        if (isEating.get()) return;
        executor.execute(this::performEat);
    }

    private void checkAndEat() {
        if ((currentHunger <= hungerThreshold || currentHealth <= healthThreshold)
                && System.currentTimeMillis() - lastEatTime > EAT_COOLDOWN_MS
                && !isEating.get()) {
            executor.execute(this::performEat);
        }
    }

    private void performEat() {
        if (!isEating.compareAndSet(false, true)) return;

        try {
            ServerManager sm = ServerManager.getInstance(null);
            MinecraftConnection conn = sm.getActiveConnection();
            if (conn == null || !conn.isConnected()) {
                Log.w(TAG, "Not connected, cannot eat");
                isEating.set(false);
                return;
            }

            int protocol = MinecraftConnection.getProtocolVersion(sm.getActiveServer().getVersion());
            int hotbarSlot = findFoodInInventory(protocol);
            if (hotbarSlot < 0) {
                Log.d(TAG, "No food found in hotbar");
                isEating.set(false);
                return;
            }

            Log.i(TAG, "Found food in hotbar slot " + hotbarSlot + ", selecting...");

            int previousSlot = conn.getSelectedSlot();
            conn.selectHotbarSlot(hotbarSlot);

            Thread.sleep(100);

            Log.i(TAG, "Sending Use Item packet...");
            conn.sendUseItem(protocol);

            Thread.sleep(EAT_USE_DELAY_MS);

            conn.selectHotbarSlot(previousSlot);
            lastEatTime = System.currentTimeMillis();
            Log.i(TAG, "Eat completed, restored slot " + previousSlot);

            if (listener != null) listener.onEatAction("food_slot_" + hotbarSlot);

        } catch (Exception e) {
            Log.e(TAG, "Eat failed", e);
        } finally {
            isEating.set(false);
        }
    }

    private int findFoodInInventory(int protocol) {
        ServerManager sm = ServerManager.getInstance(null);
        MinecraftConnection conn = sm.getActiveConnection();
        if (conn == null) return -1;

        int[] inventory = conn.getInventorySlots();
        if (inventory == null) return -1;

        for (int slot = 0; slot < 9 && slot < inventory.length; slot++) {
            if (isFoodItem(inventory[slot])) {
                return slot;
            }
        }
        return -1;
    }

    private boolean isFoodItem(int itemId) {
        for (int foodId : FOOD_IDS) {
            if (itemId == foodId) return true;
        }
        return false;
    }

    public void cleanup() {
        stopEatCheck();
        executor.shutdownNow();
    }
}
