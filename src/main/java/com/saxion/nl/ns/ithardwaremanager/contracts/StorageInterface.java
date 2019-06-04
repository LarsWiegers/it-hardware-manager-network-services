package com.saxion.nl.ns.ithardwaremanager.contracts;

import com.saxion.nl.ns.ithardwaremanager.models.Item;
import com.saxion.nl.ns.ithardwaremanager.models.Room;
import com.saxion.nl.ns.ithardwaremanager.models.User;

import java.util.ArrayList;
import java.util.UUID;

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

    /**
     * Returns the room that is associated with the uuid
     *
     * @param uuid Uuid
     * @return room Room
     */
    Room getRoomByUUID(UUID uuid);

    /**
     * Update the room
     *
     * @param room Room
     */
    void updateRoom(Room room);

    /**
     * Returns the item that is associated with the uuid
     *
     * @param itemUuid UUID
     * @return item Item
     */
    Item getItemByUUID(UUID itemUuid);

    /**
     * Remove a room
     *
     * @param room
     */
    void removeRoom(Room room);

    /**
     * Update the item
     *
     * @param item Item
     */
    void updateItem(Item item);

    /**
     * Remove the item
     *
     * @param item Item
     */
    void removeItem(Item item);

    /**
     * Add a user
     *
     * @param user User
     */
    void addUser(User user);

    /**
     * @return Arraylist<User> users
     */
    ArrayList<User> getUsers();
}
