package com.saxion.nl.ns.ithardwaremanager.controllers;

import com.saxion.nl.ns.ithardwaremanager.Storage;
import com.saxion.nl.ns.ithardwaremanager.contracts.StorageInterface;
import com.saxion.nl.ns.ithardwaremanager.models.Room;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/room")
public class RoomController {

    private StorageInterface storage;

    /**
     * Add storage to RoomController
     */
    RoomController() {
        this.storage = new Storage();
    }

    /**
     * Add a new room with the added JSON in the body
     *
     * @param room Room
     */
    @PostMapping(path = "/add")
    @ResponseBody
    public void add(@RequestBody Room room) {
        this.storage.addRoom(room);
    }

    /**
     * Get all rooms
     */
    @GetMapping(path = "")
    @ResponseBody
    public String index() {
        // TODO thymeleaf show page
        return storage.getRooms().toString();
    }

    /**
     * Get room by UUID
     *
     * @param uuid UUID
     */
    @GetMapping(path = "/get/{uuid}")
    @ResponseBody
    public String get(@PathVariable UUID uuid) {
        // TODO thymeleaf show page
        return storage.getRoomByUUID(uuid).toString();
    }

    /**
     * Edit room by UUID
     *
     * @param uuid UUID
     */
    @GetMapping(path = "/get/{uuid}/edit")
    @ResponseBody
    public void edit(@PathVariable UUID uuid) {
        // TODO thymeleaf edit page
    }

    /**
     * Remove room by UUID
     *
     * @param uuid UUID
     */
    @PostMapping(path = "/remove/{uuid}")
    @ResponseBody
    public void remove(@PathVariable UUID uuid) {
        Room room = this.storage.getRoomByUUID(uuid);
        this.storage.removeRoom(room);
    }
}