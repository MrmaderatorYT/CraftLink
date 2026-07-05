package com.ccs.craftlink.model;

import java.io.Serializable;

public class MinecraftServer implements Serializable {
    private long id;
    private String name;
    private String address;
    private int port;
    private String version;
    private String serverType;
    private boolean connected;
    private long lastConnected;
    private String notes;

    public MinecraftServer() {}

    public MinecraftServer(String name, String address, int port, String version, String serverType) {
        this.name = name;
        this.address = address;
        this.port = port;
        this.version = version;
        this.serverType = serverType;
        this.connected = false;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public int getPort() { return port; }
    public void setPort(int port) { this.port = port; }
    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }
    public String getServerType() { return serverType; }
    public void setServerType(String serverType) { this.serverType = serverType; }
    public boolean isConnected() { return connected; }
    public void setConnected(boolean connected) { this.connected = connected; }
    public long getLastConnected() { return lastConnected; }
    public void setLastConnected(long lastConnected) { this.lastConnected = lastConnected; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public String getHost() {
        return address + ":" + port;
    }

    public String getDisplayName() {
        return name + " (" + address + ":" + port + ")";
    }
}
