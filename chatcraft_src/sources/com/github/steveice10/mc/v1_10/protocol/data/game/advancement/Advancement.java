package com.github.steveice10.mc.v1_10.protocol.data.game.advancement;

import android.os.Build;
import com.github.steveice10.mc.v1_10.protocol.data.game.entity.metadata.ItemStack;
import com.github.steveice10.mc.v1_10.protocol.data.message.Message;
import com.github.steveice10.mc.v1_10.protocol.util.ReflectionToString;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class Advancement {
    private List<String> criteria;
    private DisplayData displayData;
    private String id;
    private String parentId;
    private List<List<String>> requirements;

    public Advancement(String str, String str2, List<String> list, List<List<String>> list2) {
        this.id = str;
        this.parentId = str2;
        this.criteria = list;
        this.requirements = list2;
    }

    public Advancement(String str, String str2, List<String> list, List<List<String>> list2, DisplayData displayData) {
        this(str, str2, list, list2);
        this.displayData = displayData;
    }

    public String getId() {
        return this.id;
    }

    public String getParentId() {
        return this.parentId;
    }

    public DisplayData getDisplayData() {
        return this.displayData;
    }

    public List<String> getCriteria() {
        return this.criteria;
    }

    public List<List<String>> getRequirements() {
        return this.requirements;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Advancement)) {
            return false;
        }
        Advancement advancement = (Advancement) obj;
        return objectEquals(this.id, advancement.id) && objectEquals(this.parentId, advancement.parentId) && objectEquals(this.displayData, advancement.displayData) && objectEquals(this.criteria, advancement.criteria) && objectEquals(this.requirements, advancement.requirements);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean objectEquals(Object obj, Object obj2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Objects.equals(obj, obj2);
        }
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public int hashCode() {
        return Build.VERSION.SDK_INT >= 19 ? Objects.hash(this.id, this.parentId, this.displayData, this.criteria, this.requirements) : this.id.hashCode();
    }

    public String toString() {
        return ReflectionToString.toString(this);
    }

    public static class DisplayData {
        private String backgroundTexture;
        private Message description;
        private FrameType frameType;
        private boolean hidden;
        private ItemStack icon;
        private float posX;
        private float posY;
        private boolean showToast;
        private Message title;

        public enum FrameType {
            TASK,
            CHALLENGE,
            GOAL
        }

        public DisplayData(Message message, Message message2, ItemStack itemStack, FrameType frameType, boolean z, boolean z2, float f, float f2) {
            this.title = message;
            this.description = message2;
            this.icon = itemStack;
            this.frameType = frameType;
            this.showToast = z;
            this.hidden = z2;
            this.posX = f;
            this.posY = f2;
        }

        public DisplayData(Message message, Message message2, ItemStack itemStack, FrameType frameType, boolean z, boolean z2, float f, float f2, String str) {
            this(message, message2, itemStack, frameType, z, z2, f, f2);
            this.backgroundTexture = str;
        }

        public Message getTitle() {
            return this.title;
        }

        public Message getDescription() {
            return this.description;
        }

        public ItemStack getIcon() {
            return this.icon;
        }

        public FrameType getFrameType() {
            return this.frameType;
        }

        public boolean doesShowToast() {
            return this.showToast;
        }

        public boolean isHidden() {
            return this.hidden;
        }

        public String getBackgroundTexture() {
            return this.backgroundTexture;
        }

        public float getPosX() {
            return this.posX;
        }

        public float getPosY() {
            return this.posY;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DisplayData)) {
                return false;
            }
            DisplayData displayData = (DisplayData) obj;
            return this.showToast == displayData.showToast && this.hidden == displayData.hidden && Float.compare(displayData.posX, this.posX) == 0 && Float.compare(displayData.posY, this.posY) == 0 && Advancement.objectEquals(this.title, displayData.title) && Advancement.objectEquals(this.description, displayData.description) && Advancement.objectEquals(this.icon, displayData.icon) && this.frameType == displayData.frameType && Advancement.objectEquals(this.backgroundTexture, displayData.backgroundTexture);
        }

        public int hashCode() {
            return Build.VERSION.SDK_INT >= 19 ? Objects.hash(this.title, this.description, this.icon, this.frameType, Boolean.valueOf(this.showToast), Boolean.valueOf(this.hidden), this.backgroundTexture, Float.valueOf(this.posX), Float.valueOf(this.posY)) : this.title.hashCode();
        }

        public String toString() {
            return ReflectionToString.toString(this);
        }
    }
}
