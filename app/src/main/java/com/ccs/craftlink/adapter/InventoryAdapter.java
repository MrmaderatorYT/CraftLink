package com.ccs.craftlink.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ccs.craftlink.R;
import com.ccs.craftlink.model.ItemModel;
import com.ccs.craftlink.network.ServerManager;
import com.ccs.craftlink.render.NativeRender;

import java.util.ArrayList;
import java.util.List;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.ViewHolder> {

    public interface OnSlotClickListener {
        void onSlotClick(int slot);
        void onSlotLongClick(int slot);
    }

    private final List<ItemModel> items = new ArrayList<>();
    private final int startSlot;
    private final int endSlot; // inclusive
    private OnSlotClickListener clickListener;
    private int selectedHotbarSlot = 0;
    private boolean isHotbar = false;

    public InventoryAdapter(int startSlot, int endSlot) {
        this.startSlot = startSlot;
        this.endSlot = endSlot;
        if (startSlot == 36 && endSlot == 44) {
            isHotbar = true;
        }
    }

    public void setOnSlotClickListener(OnSlotClickListener listener) {
        this.clickListener = listener;
    }

    public void setSelectedHotbarSlot(int slot) {
        this.selectedHotbarSlot = slot;
        if (isHotbar) {
            notifyDataSetChanged();
        }
    }

    public void setItems(ItemModel[] newItems) {
        items.clear();
        if (newItems != null) {
            // We store the full array internally to map global slots
            for (ItemModel item : newItems) {
                items.add(item);
            }
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_inventory_slot, parent, false);
                
        // Calculate the slot size dynamically based on screen width
        // The fragment has padding of spacing_lg (16dp) on both sides.
        int screenWidth = parent.getContext().getResources().getDisplayMetrics().widthPixels;
        float density = parent.getContext().getResources().getDisplayMetrics().density;
        int paddingPx = (int) (32 * density); // 16dp * 2
        
        int slotSize = (screenWidth - paddingPx) / 9;

        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = slotSize;
        layoutParams.height = slotSize;
        view.setLayoutParams(layoutParams);
        
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int globalSlot = startSlot + position;
        ItemModel item = items.size() > globalSlot ? items.get(globalSlot) : null;
        
        holder.itemView.setOnClickListener(v -> {
            if (item != null) {
                android.widget.Toast.makeText(v.getContext(), item.getName() + " (ID: " + item.getItemId() + ", " + item.getCount() + "x)", android.widget.Toast.LENGTH_SHORT).show();
            }
            if (clickListener != null) clickListener.onSlotClick(globalSlot);
        });

        holder.itemView.setOnLongClickListener(v -> {
            if (clickListener != null) {
                clickListener.onSlotLongClick(globalSlot);
                return true;
            }
            return false;
        });

        // Highlight selected hotbar slot
        if (isHotbar && position == selectedHotbarSlot) {
            holder.itemView.setBackgroundResource(R.drawable.bg_slot_selected);
        } else {
            holder.itemView.setBackgroundResource(R.drawable.bg_slot_default);
        }

        if (item != null && item.getItemId() > 0 && item.getCount() > 0) {
            holder.itemColorBlock.setVisibility(View.VISIBLE);
            
            // Try to load NDK Texture
            int protocol = 47; // Default to 1.8.x if unknown
            com.ccs.craftlink.network.MinecraftConnection conn = ServerManager.getInstance(holder.itemView.getContext()).getActiveConnection();
            if (conn != null && conn.getCurrentServer() != null) {
                protocol = com.ccs.craftlink.network.MinecraftConnection.getProtocolVersion(conn.getCurrentServer().getVersion());
            }
            
            android.graphics.Bitmap bmp = NativeRender.renderItem(protocol, item.getItemId());
            if (bmp != null) {
                holder.itemColorBlock.setImageBitmap(bmp);
                holder.itemColorBlock.getBackground().setTint(android.graphics.Color.TRANSPARENT);
            } else {
                // Generate a unique pastel color based on itemId as fallback
                holder.itemColorBlock.setImageBitmap(null);
                float hue = (item.getItemId() * 137.5f) % 360.0f;
                int color = android.graphics.Color.HSVToColor(new float[]{hue, 0.55f, 0.85f});
                holder.itemColorBlock.getBackground().setTint(color);
            }

            if (item.getCount() > 1) {
                holder.itemCount.setVisibility(View.VISIBLE);
                holder.itemCount.setText(String.valueOf(item.getCount()));
            } else {
                holder.itemCount.setVisibility(View.GONE);
            }
        } else {
            holder.itemColorBlock.setVisibility(View.INVISIBLE);
            holder.itemCount.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return (endSlot - startSlot) + 1;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemColorBlock;
        TextView itemCount;

        ViewHolder(View itemView) {
            super(itemView);
            itemColorBlock = itemView.findViewById(R.id.itemColorBlock);
            itemCount = itemView.findViewById(R.id.itemCount);
        }
    }
}
