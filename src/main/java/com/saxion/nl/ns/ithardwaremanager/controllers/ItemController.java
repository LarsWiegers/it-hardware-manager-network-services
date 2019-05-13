package com.saxion.nl.ns.ithardwaremanager.controllers;

import com.saxion.nl.ns.ithardwaremanager.Storage;
import com.saxion.nl.ns.ithardwaremanager.contracts.StorageInterface;
import com.saxion.nl.ns.ithardwaremanager.models.Item;
import com.saxion.nl.ns.ithardwaremanager.models.Room;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@Controller
@RequestMapping("/item")
public class ItemController {

    /**
     * The storage for the items
     */
    private StorageInterface storage;

    /**
     * ItemController
     */
    ItemController() {
        // TODO use dependency injection here so we dont specify
        // TODO the real class we want but the contract we would like to use
        this.storage = new Storage();
    }

    /**
     * Return a list of items
     */
    @GetMapping(path = "/")
    @ResponseBody
    public void index() {
        ArrayList<Room> rooms = this.storage.getRooms();
        ArrayList<Item> items = new ArrayList<Item>();
        for (Room room: rooms) {
            items.addAll(room.getItems());
        }
        // TODO return an thymeleaf index page
    }

    /**
     * Add an item to an existing room
     *
     * @param item     Item
     * @param roomUuid UUID
     */
    @PostMapping(path = "/add/{roomUuid}")
    @ResponseBody
    public void add(@RequestBody Item item,
                    @PathVariable String roomUuid) {
        Room room = this.storage.getRoomByUUID(UUID.fromString(roomUuid));
        room.addItem(item);
        this.storage.updateRoom(room);
    }

    /**
     * Show an page that allows the user to edit the item
     */
    @GetMapping(path = "/get/{uuid}")
    @ResponseBody
    public void edit() {
        // TODO thymeleaf edit page
    }

    /**
     * Remove the item from a room
     */
    @PostMapping(path = "/remove/{roomUuid}/{itemUuid}")
    @ResponseBody
    public void remove(@PathVariable String roomUuid,
                       @PathVariable String itemUuid) {
        Room room = this.storage.getRoomByUUID(UUID.fromString(roomUuid));
        Item item = this.storage.getItemByUUID(UUID.fromString(itemUuid));
        room.removeItem(item);
        this.storage.updateRoom(room);
    }
}
