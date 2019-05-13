package com.saxion.nl.ns.ithardwaremanager.controllers;

import com.saxion.nl.ns.ithardwaremanager.Storage;
import com.saxion.nl.ns.ithardwaremanager.contracts.StorageInterface;
import com.saxion.nl.ns.ithardwaremanager.models.Item;
import com.saxion.nl.ns.ithardwaremanager.models.Room;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/item")
public class ItemController {

    private StorageInterface storage;

    ItemController() {
        this.storage = new Storage();
    }

    @PostMapping(path = "/add/{roomUuid}")
    @ResponseBody
    public void add(@RequestBody Item item, @PathVariable UUID roomUuid) {
        Room room = this.storage.getRoomByUUID(roomUuid);
        room.addItem(item);
        this.storage.updateRoom(room);
    }

    @GetMapping(path = "/get/{uuid}")
    @ResponseBody
    public void edit() {

    }

}
