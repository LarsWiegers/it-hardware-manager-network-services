package com.saxion.nl.ns.ithardwaremanager.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Serializable {
    private String name;
    private ArrayList<Item> items = new ArrayList<>();
    private String description;

    /**
     * Main constructor used
     *
     * @param name        the name
     * @param description the description
     */
    public Room(String name, String description) {
        this.setName(name);
        this.setDescription(description);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public String toString() {
        return this.getName() + ", " + this.items;
    }

    /**
     * Remove an item from the current items we have
     *
     * @param item the item to be removed
     */
    public void removeItem(Item item) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getName().equals(item.getName())) {
                this.items.remove(i);
            }
        }
        this.items.remove(item);
    }
}
