package com.github.steveice10.mc.v1_9_4.protocol.packet.ingame.client.window;

import com.github.steveice10.mc.v1_9_4.protocol.data.MagicValues;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.entity.metadata.ItemStack;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.window.ClickItemParam;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.window.CreativeGrabParam;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.window.DropItemParam;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.window.FillStackParam;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.window.MoveToHotbarParam;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.window.ShiftClickItemParam;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.window.SpreadItemParam;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.window.WindowAction;
import com.github.steveice10.mc.v1_9_4.protocol.data.game.window.WindowActionParam;
import com.github.steveice10.mc.v1_9_4.protocol.util.NetUtil;
import com.github.steveice10.mc.v1_9_4.protocol.util.ReflectionToString;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class ClientWindowActionPacket implements Packet {
    private WindowAction action;
    private int actionId;
    private ItemStack clicked;
    private WindowActionParam param;
    private int slot;
    private int windowId;

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientWindowActionPacket() {
    }

    public ClientWindowActionPacket(int i, int i2, int i3, ItemStack itemStack, WindowAction windowAction, WindowActionParam windowActionParam) {
        this.windowId = i;
        this.actionId = i2;
        this.slot = i3;
        this.clicked = itemStack;
        this.action = windowAction;
        this.param = windowActionParam;
    }

    public int getWindowId() {
        return this.windowId;
    }

    public int getActionId() {
        return this.actionId;
    }

    public int getSlot() {
        return this.slot;
    }

    public ItemStack getClickedItem() {
        return this.clicked;
    }

    public WindowAction getAction() {
        return this.action;
    }

    public WindowActionParam getParam() {
        return this.param;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.windowId = netInput.readByte();
        this.slot = netInput.readShort();
        byte b2 = netInput.readByte();
        this.actionId = netInput.readShort();
        this.action = (WindowAction) MagicValues.key(WindowAction.class, Byte.valueOf(netInput.readByte()));
        this.clicked = NetUtil.readItem(netInput);
        if (this.action == WindowAction.CLICK_ITEM) {
            this.param = (WindowActionParam) MagicValues.key(ClickItemParam.class, Byte.valueOf(b2));
            return;
        }
        if (this.action == WindowAction.SHIFT_CLICK_ITEM) {
            this.param = (WindowActionParam) MagicValues.key(ShiftClickItemParam.class, Byte.valueOf(b2));
            return;
        }
        if (this.action == WindowAction.MOVE_TO_HOTBAR_SLOT) {
            this.param = (WindowActionParam) MagicValues.key(MoveToHotbarParam.class, Byte.valueOf(b2));
            return;
        }
        if (this.action == WindowAction.CREATIVE_GRAB_MAX_STACK) {
            this.param = (WindowActionParam) MagicValues.key(CreativeGrabParam.class, Byte.valueOf(b2));
            return;
        }
        if (this.action == WindowAction.DROP_ITEM) {
            this.param = (WindowActionParam) MagicValues.key(DropItemParam.class, Integer.valueOf(b2 + (this.slot != -999 ? (byte) 2 : (byte) 0)));
        } else if (this.action == WindowAction.SPREAD_ITEM) {
            this.param = (WindowActionParam) MagicValues.key(SpreadItemParam.class, Byte.valueOf(b2));
        } else if (this.action == WindowAction.FILL_STACK) {
            this.param = (WindowActionParam) MagicValues.key(FillStackParam.class, Byte.valueOf(b2));
        }
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeByte(this.windowId);
        netOutput.writeShort(this.slot);
        if (this.action == WindowAction.CLICK_ITEM || this.action == WindowAction.SHIFT_CLICK_ITEM || this.action == WindowAction.MOVE_TO_HOTBAR_SLOT || this.action == WindowAction.CREATIVE_GRAB_MAX_STACK) {
            iIntValue = ((Integer) MagicValues.value(Integer.class, (Enum) this.param)).intValue();
        } else if (this.action == WindowAction.DROP_ITEM) {
            iIntValue = (this.slot != -999 ? 2 : 0) + ((Integer) MagicValues.value(Integer.class, (Enum) this.param)).intValue();
        } else if (this.action == WindowAction.SPREAD_ITEM || this.action == WindowAction.FILL_STACK) {
            iIntValue = ((Integer) MagicValues.value(Integer.class, (Enum) this.param)).intValue();
        }
        netOutput.writeByte(iIntValue);
        netOutput.writeShort(this.actionId);
        netOutput.writeByte(((Integer) MagicValues.value(Integer.class, this.action)).intValue());
        NetUtil.writeItem(netOutput, this.clicked);
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }
}
