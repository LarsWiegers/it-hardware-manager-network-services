package com.saxion.nl.ns.ithardwaremanager;

import com.saxion.nl.ns.ithardwaremanager.contracts.StorageInterface;
import com.saxion.nl.ns.ithardwaremanager.models.Room;

import java.util.ArrayList;

public class Storage implements StorageInterface {

    private ArrayList<Room> rooms = new ArrayList<>();

    public ArrayList<Room> getRooms() {
        return new ArrayList<>(rooms);
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }
}
