package com.ccs.craftlink.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ccs.craftlink.R;
import com.ccs.craftlink.adapter.InventoryAdapter;
import com.ccs.craftlink.network.MinecraftConnection;
import android.widget.TextView;
import com.ccs.craftlink.autofeatures.AutoEatManager;
import com.ccs.craftlink.network.ServerManager;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class InventoryFragment extends Fragment implements InventoryAdapter.OnSlotClickListener {
    private static final String TAG = "InventoryFragment";

    private InventoryAdapter armorAdapter;
    private InventoryAdapter offhandAdapter;
    private InventoryAdapter mainAdapter;
    private InventoryAdapter hotbarAdapter;
    
    private final CompositeDisposable disposables = new CompositeDisposable();
    private View viewHpIndicator;
    private TextView tvHpStatus;
    private View viewHungerIndicator;
    private TextView tvHungerStatus;
    private MinecraftConnection connection;
    private View viewNotConnected;
    private View inventoryContent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_inventory, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rvArmor = view.findViewById(R.id.rvArmor);
        RecyclerView rvOffhand = view.findViewById(R.id.rvOffhand);
        RecyclerView rvMain = view.findViewById(R.id.rvMain);
        RecyclerView rvHotbar = view.findViewById(R.id.rvHotbar);
        viewHpIndicator = view.findViewById(R.id.view_hp_indicator);
        tvHpStatus = view.findViewById(R.id.tv_hp_status);
        viewHungerIndicator = view.findViewById(R.id.view_hunger_indicator);
        tvHungerStatus = view.findViewById(R.id.tv_hunger_status);
        viewNotConnected = view.findViewById(R.id.view_not_connected);
        inventoryContent = view.findViewById(R.id.inventory_content);

        setupNotConnected();

        // Armor: Slots 5-8 (4 slots)
        rvArmor.setLayoutManager(new GridLayoutManager(requireContext(), 1));
        armorAdapter = new InventoryAdapter(5, 8);
        armorAdapter.setOnSlotClickListener(this);
        rvArmor.setAdapter(armorAdapter);

        // Offhand: Slot 45
        rvOffhand.setLayoutManager(new GridLayoutManager(requireContext(), 1));
        offhandAdapter = new InventoryAdapter(45, 45);
        offhandAdapter.setOnSlotClickListener(this);
        rvOffhand.setAdapter(offhandAdapter);

        // Main Inventory: Slots 9-35
        rvMain.setLayoutManager(new GridLayoutManager(requireContext(), 9));
        mainAdapter = new InventoryAdapter(9, 35);
        mainAdapter.setOnSlotClickListener(this);
        rvMain.setAdapter(mainAdapter);

        // Hotbar: Slots 36-44
        rvHotbar.setLayoutManager(new GridLayoutManager(requireContext(), 9));
        hotbarAdapter = new InventoryAdapter(36, 44);
        hotbarAdapter.setOnSlotClickListener(this);
        rvHotbar.setAdapter(hotbarAdapter);

        observeInventory();
        observeStatus();
    }

    private void setupNotConnected() {
        if (viewNotConnected == null) return;

        viewNotConnected.findViewById(R.id.btn_go_to_servers).setOnClickListener(v -> {
            if (getActivity() != null) {
                com.google.android.material.bottomnavigation.BottomNavigationView bnv =
                        getActivity().findViewById(R.id.bottom_navigation);
                if (bnv != null) {
                    bnv.setSelectedItemId(R.id.nav_servers);
                }
            }
        });

        updateConnectedState();
    }

    private void updateConnectedState() {
        MinecraftConnection conn = ServerManager.getInstance(requireContext()).getActiveConnection();
        boolean isConnected = conn != null && conn.isConnected();

        if (viewNotConnected != null) {
            viewNotConnected.setVisibility(isConnected ? View.GONE : View.VISIBLE);
        }
        if (inventoryContent != null) {
            inventoryContent.setVisibility(isConnected ? View.VISIBLE : View.GONE);
        }
    }

    private void observeInventory() {
        connection = ServerManager.getInstance(requireContext()).getActiveConnection();
        if (connection != null) {
            disposables.add(connection.getInventoryObservable()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(items -> {
                        armorAdapter.setItems(items);
                        offhandAdapter.setItems(items);
                        mainAdapter.setItems(items);
                        hotbarAdapter.setItems(items);
                    }, error -> Log.e(TAG, "Error observing inventory", error)));
                    
            hotbarAdapter.setSelectedHotbarSlot(connection.getSelectedSlot());
        }
    }

    private void observeStatus() {
        AutoEatManager autoEat = AutoEatManager.getInstance();
        disposables.add(autoEat.observeStatus()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(status -> updateStatusBar(status[0], status[1]),
                           error -> Log.e(TAG, "Error observing status", error)));
    }

    private void updateStatusBar(int health, int hunger) {
        if (tvHpStatus == null) return;
        
        tvHpStatus.setText("HP: " + health + "/20");
        tvHungerStatus.setText("Food: " + hunger + "/20");

        if (health <= 6) {
            viewHpIndicator.setBackgroundResource(R.drawable.bg_status_offline);
        } else if (health <= 12) {
            viewHpIndicator.setBackgroundResource(R.drawable.bg_status_offline);
        } else {
            viewHpIndicator.setBackgroundResource(R.drawable.bg_status_online);
        }

        if (hunger <= 6) {
            viewHungerIndicator.setBackgroundResource(R.drawable.bg_status_offline);
        } else if (hunger <= 12) {
            viewHungerIndicator.setBackgroundResource(R.drawable.bg_status_offline);
        } else {
            viewHungerIndicator.setBackgroundResource(R.drawable.bg_status_online);
        }
    }

    @Override
    public void onSlotClick(int slot) {
        if (connection == null) return;
        
        if (slot >= 36 && slot <= 44) {
            int hotbarIndex = slot - 36;
            connection.selectHotbarSlot(hotbarIndex);
            hotbarAdapter.setSelectedHotbarSlot(hotbarIndex);
        } else {
            connection.sendClickWindow(slot, 0, 1);
        }
    }

    @Override
    public void onSlotLongClick(int slot) {
        if (connection == null) return;
        
        connection.sendClickWindow(slot, 1, 4);
        Toast.makeText(requireContext(), "Dropped item", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        disposables.clear();
    }
}
