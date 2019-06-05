package com.saxion.nl.ns.ithardwaremanager;

import com.saxion.nl.ns.ithardwaremanager.contracts.StorageInterface;
import com.saxion.nl.ns.ithardwaremanager.models.Item;
import com.saxion.nl.ns.ithardwaremanager.models.Room;
import com.saxion.nl.ns.ithardwaremanager.models.User;

import java.util.ArrayList;
import java.util.UUID;

public class Storage implements StorageInterface {

    private ArrayList<Room> rooms = new ArrayList<>();

    private ArrayList<User> users = new ArrayList<>();


    Storage() {
        this.users.add(new User("lars@saxion.nl", "larsPassword"));
        this.users.add(new User("jesse@saxion.nl", "jessePassword"));
    }

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
        for (Room room : rooms) {
            if (room.getUuid().equals(uuid)) {
                return room;
            }
        }
        return null;
    }

    public void updateRoom(Room room) {
        UUID uuid = room.getUuid();
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getUuid().equals(uuid)) {
                this.rooms.set(i, room);
            }
        }
    }

    public void updateItem(Item item) {
        for (Room room : rooms) {
            for (int j = 0; j < room.getItems().size(); j++) {
                Item currentItem = room.getItems().get(j);
                if (currentItem.getUuid() == item.getUuid()) {
                    room.getItems().set(j, item);
                }
            }
        }
    }

    public Item getItemByUUID(UUID uuid) {
        for (Room room : rooms) {
            for (Item item : room.getItems()) {
                if (item.getUuid().equals(uuid)) {
                    return item;
                }
            }
        }
        return null;
    }

    public void removeRoom(Room room) {
        UUID uuid = room.getUuid();
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getUuid().equals(uuid)) {
                this.rooms.remove(i);
            }
        }
    }
    public void removeItem(Item item) {
        UUID uuid = item.getUuid();
        for (Room room : rooms) {
            for (Item currentItem : room.getItems()) {
                if (currentItem.getUuid().equals(uuid)) {
                    room.getItems().remove(item);
                    return;
                }
            }
        }
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public ArrayList<User> getUsers() {
        return new ArrayList(this.users);
    }
}
