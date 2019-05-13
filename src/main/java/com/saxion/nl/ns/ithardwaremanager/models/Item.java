package main.java.com.saxion.nl.ns.ithardwaremanager.models;

import java.io.Serializable;

public class Item implements Serializable {
    private String name;
    private String description;

    public Item(String name, String description) {
        this.setName(name);
        this.setDescription(description);
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

    @Override
    public String toString() {
        return "( " + this.getName() + " , " + this.getDescription() + " )";
    }
}
