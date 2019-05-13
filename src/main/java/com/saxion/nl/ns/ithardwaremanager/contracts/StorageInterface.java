package com.saxion.nl.ns.ithardwaremanager.contracts;

import com.saxion.nl.ns.ithardwaremanager.models.Room;

import java.util.ArrayList;

public interface StorageInterface {

    /**
     * Get all rooms from Storage
     *
     * @return new Arraylist<>(rooms)
     */
    ArrayList<Room> getRooms();

    /**
     * Set rooms of Storage with ArrayList
     *
     * @param rooms ArrayList<Room>
     */
    void setRooms(ArrayList<Room> rooms);

    /**
     * Add room to Storage
     *
     * @param room new Room(String name, String description)
     */
    void addRoom(Room room);
}
