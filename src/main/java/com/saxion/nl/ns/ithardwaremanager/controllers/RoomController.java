package com.saxion.nl.ns.ithardwaremanager.controllers;

import com.saxion.nl.ns.ithardwaremanager.StorageContainer;
import com.saxion.nl.ns.ithardwaremanager.contracts.StorageInterface;
import com.saxion.nl.ns.ithardwaremanager.models.Room;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/room")
public class RoomController {

    /**
     * The storage for the items
     */
    private StorageInterface storage;

    /**
     * Add storage to RoomController
     */
    RoomController() {
        this.storage = StorageContainer.getStorage();
    }

    /**
     * Add a new room with the added JSON in the body
     */
    @PostMapping(path = "/add")
    public String add(@RequestParam("name") String name,
                      @RequestParam("description") String description,
                      Model model) {
        Room room = new Room(name, description);
        this.storage.addRoom(room);
        model.addAttribute(room);
        return "redirect:/room";
    }

    @GetMapping(path = "/add")
    public String addRoom() {
        return "edit-room";
    }

    /**
     * Get all rooms
     */
    @GetMapping(path = "")
    public String index(Model model) {
        // TODO thymeleaf show page
        model.addAttribute("rooms", storage.getRooms());
        return "room-index";
    }

    /**
     * Get room by UUID
     *
     * @param uuid UUID
     */
    @GetMapping(path = "/get/{uuid}/edit")
    public String edit(@PathVariable UUID uuid,
                       Model model) {
        Room room = this.storage.getRoomByUUID(uuid);
        model.addAttribute("room", room);
        // TODO return an thymeleaf index page
        return "edit-room";
    }

    /**
     * Show a page that allows the user to edit the item
     */
    @PostMapping(path = "/get/{uuid}/edit")
    public String update(@PathVariable UUID uuid,
                         @RequestParam("name") String name,
                         @RequestParam("description") String description) {
        Room room = this.storage.getRoomByUUID(uuid);
        room.setName(name);
        room.setDescription(description);
        this.storage.updateRoom(room);
        return "redirect:/room";
    }

    /**
     * Remove room by UUID
     *
     * @param uuid UUID
     */
    @PostMapping(path = "/remove/{uuid}")
    public String remove(@PathVariable UUID uuid) {
        Room room = this.storage.getRoomByUUID(uuid);
        this.storage.removeRoom(room);
        return "redirect:/room";
    }
}