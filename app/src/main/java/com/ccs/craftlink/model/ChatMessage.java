package com.ccs.craftlink.model;

import java.io.Serializable;

public class ChatMessage implements Serializable {
    private long id;
    private String sender;
    private String content;
    private long timestamp;
    private MessageType type;

    public enum MessageType {
        CHAT, SYSTEM, COMMAND, ACTION
    }

    public ChatMessage() {}

    public ChatMessage(String sender, String content, MessageType type) {
        this.sender = sender;
        this.content = content;
        this.type = type;
        this.timestamp = System.currentTimeMillis();
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
    public MessageType getType() { return type; }
    public void setType(MessageType type) { this.type = type; }

    public boolean isSystem() {
        return type == MessageType.SYSTEM || type == MessageType.COMMAND;
    }
}
