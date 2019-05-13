package com.saxion.nl.ns.ithardwaremanager.controllers;

import com.saxion.nl.ns.ithardwaremanager.Storage;
import com.saxion.nl.ns.ithardwaremanager.contracts.StorageInterface;
import com.saxion.nl.ns.ithardwaremanager.models.Room;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/room")
public class RoomController {

    private StorageInterface storage;

    RoomController() {
        this.storage = new Storage();
    }

    @PostMapping(path = "/add")
    @ResponseBody
    public void add(@RequestBody Room room) {
        storage.addRoom(room);
    }
}
