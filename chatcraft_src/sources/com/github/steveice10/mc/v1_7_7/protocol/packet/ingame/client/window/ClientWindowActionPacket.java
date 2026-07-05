package com.github.steveice10.mc.v1_7_7.protocol.packet.ingame.client.window;

import com.github.steveice10.mc.v1_7_7.protocol.data.game.ItemStack;
import com.github.steveice10.mc.v1_7_7.protocol.util.NetUtil;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;
import com.github.steveice10.packetlib.packet.Packet;
import java.io.IOException;

/* loaded from: classes.dex */
public class ClientWindowActionPacket implements Packet {
    private Action action;
    private int actionId;
    private ItemStack clicked;
    private ActionParam param;
    private int slot;
    private int windowId;

    public enum Action {
        CLICK_ITEM,
        SHIFT_CLICK_ITEM,
        MOVE_TO_HOTBAR_SLOT,
        CREATIVE_GRAB_MAX_STACK,
        DROP_ITEM,
        SPREAD_ITEM,
        FILL_STACK
    }

    public interface ActionParam {
    }

    public enum ClickItemParam implements ActionParam {
        LEFT_CLICK,
        RIGHT_CLICK
    }

    public enum CreativeGrabParam implements ActionParam {
        GRAB
    }

    public enum DropItemParam implements ActionParam {
        DROP_FROM_SELECTED,
        DROP_SELECTED_STACK,
        LEFT_CLICK_OUTSIDE_NOT_HOLDING,
        RIGHT_CLICK_OUTSIDE_NOT_HOLDING
    }

    public enum FillStackParam implements ActionParam {
        FILL
    }

    public enum MoveToHotbarParam implements ActionParam {
        SLOT_1,
        SLOT_2,
        SLOT_3,
        SLOT_4,
        SLOT_5,
        SLOT_6,
        SLOT_7,
        SLOT_8,
        SLOT_9
    }

    public enum ShiftClickItemParam implements ActionParam {
        LEFT_CLICK,
        RIGHT_CLICK
    }

    public enum SpreadItemParam implements ActionParam {
        LEFT_MOUSE_BEGIN_DRAG,
        LEFT_MOUSE_ADD_SLOT,
        LEFT_MOUSE_END_DRAG,
        RIGHT_MOUSE_BEGIN_DRAG,
        RIGHT_MOUSE_ADD_SLOT,
        RIGHT_MOUSE_END_DRAG
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public boolean isPriority() {
        return false;
    }

    private ClientWindowActionPacket() {
    }

    public ClientWindowActionPacket(int i, int i2, int i3, ItemStack itemStack, Action action, ActionParam actionParam) {
        this.windowId = i;
        this.actionId = i2;
        this.slot = i3;
        this.clicked = itemStack;
        this.action = action;
        this.param = actionParam;
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

    public Action getAction() {
        return this.action;
    }

    public ActionParam getParam() {
        return this.param;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.windowId = netInput.readByte();
        this.slot = netInput.readShort();
        byte b2 = netInput.readByte();
        this.actionId = netInput.readShort();
        this.action = Action.values()[netInput.readByte()];
        this.clicked = NetUtil.readItem(netInput);
        this.param = valueToParam(b2);
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) throws IOException {
        netOutput.writeByte(this.windowId);
        netOutput.writeShort(this.slot);
        netOutput.writeByte(paramToValue(this.param));
        netOutput.writeShort(this.actionId);
        netOutput.writeByte(this.action.ordinal());
        NetUtil.writeItem(netOutput, this.clicked);
    }

    private byte paramToValue(ActionParam actionParam) throws IOException {
        if (actionParam == ClickItemParam.LEFT_CLICK) {
            return (byte) 0;
        }
        if (actionParam == ClickItemParam.RIGHT_CLICK) {
            return (byte) 1;
        }
        if (actionParam == ShiftClickItemParam.LEFT_CLICK) {
            return (byte) 0;
        }
        if (actionParam == ShiftClickItemParam.RIGHT_CLICK) {
            return (byte) 1;
        }
        if (actionParam == MoveToHotbarParam.SLOT_1) {
            return (byte) 0;
        }
        if (actionParam == MoveToHotbarParam.SLOT_2) {
            return (byte) 1;
        }
        if (actionParam == MoveToHotbarParam.SLOT_3) {
            return (byte) 2;
        }
        if (actionParam == MoveToHotbarParam.SLOT_4) {
            return (byte) 3;
        }
        if (actionParam == MoveToHotbarParam.SLOT_5) {
            return (byte) 4;
        }
        if (actionParam == MoveToHotbarParam.SLOT_6) {
            return (byte) 5;
        }
        if (actionParam == MoveToHotbarParam.SLOT_7) {
            return (byte) 6;
        }
        if (actionParam == MoveToHotbarParam.SLOT_8) {
            return (byte) 7;
        }
        if (actionParam == MoveToHotbarParam.SLOT_9) {
            return (byte) 8;
        }
        if (actionParam == CreativeGrabParam.GRAB) {
            return (byte) 2;
        }
        if (actionParam == DropItemParam.DROP_FROM_SELECTED) {
            return (byte) 0;
        }
        if (actionParam == DropItemParam.DROP_SELECTED_STACK) {
            return (byte) 1;
        }
        if (actionParam == DropItemParam.LEFT_CLICK_OUTSIDE_NOT_HOLDING) {
            return (byte) 0;
        }
        if (actionParam == DropItemParam.RIGHT_CLICK_OUTSIDE_NOT_HOLDING) {
            return (byte) 1;
        }
        if (actionParam == SpreadItemParam.LEFT_MOUSE_BEGIN_DRAG) {
            return (byte) 0;
        }
        if (actionParam == SpreadItemParam.LEFT_MOUSE_ADD_SLOT) {
            return (byte) 1;
        }
        if (actionParam == SpreadItemParam.LEFT_MOUSE_END_DRAG) {
            return (byte) 2;
        }
        if (actionParam == SpreadItemParam.RIGHT_MOUSE_BEGIN_DRAG) {
            return (byte) 4;
        }
        if (actionParam == SpreadItemParam.RIGHT_MOUSE_ADD_SLOT) {
            return (byte) 5;
        }
        if (actionParam == SpreadItemParam.RIGHT_MOUSE_END_DRAG) {
            return (byte) 6;
        }
        if (actionParam == FillStackParam.FILL) {
            return (byte) 0;
        }
        throw new IOException("Unmapped action param: " + actionParam);
    }

    private ActionParam valueToParam(byte b2) throws IOException {
        if (this.action == Action.CLICK_ITEM) {
            if (b2 == 0) {
                return ClickItemParam.LEFT_CLICK;
            }
            if (b2 == 1) {
                return ClickItemParam.RIGHT_CLICK;
            }
        }
        if (this.action == Action.SHIFT_CLICK_ITEM) {
            if (b2 == 0) {
                return ShiftClickItemParam.LEFT_CLICK;
            }
            if (b2 == 1) {
                return ShiftClickItemParam.RIGHT_CLICK;
            }
        }
        if (this.action == Action.MOVE_TO_HOTBAR_SLOT) {
            if (b2 == 0) {
                return MoveToHotbarParam.SLOT_1;
            }
            if (b2 == 1) {
                return MoveToHotbarParam.SLOT_2;
            }
            if (b2 == 2) {
                return MoveToHotbarParam.SLOT_3;
            }
            if (b2 == 3) {
                return MoveToHotbarParam.SLOT_4;
            }
            if (b2 == 4) {
                return MoveToHotbarParam.SLOT_5;
            }
            if (b2 == 5) {
                return MoveToHotbarParam.SLOT_6;
            }
            if (b2 == 6) {
                return MoveToHotbarParam.SLOT_7;
            }
            if (b2 == 7) {
                return MoveToHotbarParam.SLOT_8;
            }
            if (b2 == 8) {
                return MoveToHotbarParam.SLOT_9;
            }
        }
        if (this.action == Action.CREATIVE_GRAB_MAX_STACK && b2 == 2) {
            return CreativeGrabParam.GRAB;
        }
        if (this.action == Action.DROP_ITEM) {
            if (this.slot == -999) {
                if (b2 == 0) {
                    return DropItemParam.LEFT_CLICK_OUTSIDE_NOT_HOLDING;
                }
                if (b2 == 1) {
                    return DropItemParam.RIGHT_CLICK_OUTSIDE_NOT_HOLDING;
                }
            } else {
                if (b2 == 0) {
                    return DropItemParam.DROP_FROM_SELECTED;
                }
                if (b2 == 1) {
                    return DropItemParam.DROP_SELECTED_STACK;
                }
            }
        }
        if (this.action == Action.SPREAD_ITEM) {
            if (b2 == 0) {
                return SpreadItemParam.LEFT_MOUSE_BEGIN_DRAG;
            }
            if (b2 == 1) {
                return SpreadItemParam.LEFT_MOUSE_ADD_SLOT;
            }
            if (b2 == 2) {
                return SpreadItemParam.LEFT_MOUSE_END_DRAG;
            }
            if (b2 == 4) {
                return SpreadItemParam.RIGHT_MOUSE_BEGIN_DRAG;
            }
            if (b2 == 5) {
                return SpreadItemParam.RIGHT_MOUSE_ADD_SLOT;
            }
            if (b2 == 6) {
                return SpreadItemParam.RIGHT_MOUSE_END_DRAG;
            }
        }
        if (this.action == Action.FILL_STACK && b2 == 0) {
            return FillStackParam.FILL;
        }
        throw new IOException("Unknown action param value: " + ((int) b2));
    }
}
