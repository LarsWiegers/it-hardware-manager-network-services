package com.saxion.nl.ns.ithardwaremanager.models;

import java.io.Serializable;
import java.util.UUID;

public class Item implements Serializable {
    private String name;
    private String description;
    private UUID uuid;

    public Item(String name, String description) {
        this.setName(name);
        this.setDescription(description);
        this.setUuid(UUID.randomUUID());
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "## " + this.getName() + ", " + this.getUuid() + ", " + this.getDescription();
    }
}
