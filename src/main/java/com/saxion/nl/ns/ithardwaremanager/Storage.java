package com.saxion.nl.ns.ithardwaremanager;

import com.saxion.nl.ns.ithardwaremanager.contracts.StorageInterface;
import com.saxion.nl.ns.ithardwaremanager.models.Room;

import java.util.ArrayList;
import java.util.UUID;

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

    public Room getRoomByUUID(UUID uuid) {
        Room returnRoom = null;
        for (Room room : rooms) {
            if (room.getUuid() == uuid) {
                returnRoom = room;
            }
        }
        return returnRoom;
    }
}
