package com.saxion.nl.ns.ithardwaremanager.controllers;

import com.saxion.nl.ns.ithardwaremanager.StorageContainer;
import com.saxion.nl.ns.ithardwaremanager.contracts.StorageInterface;
import com.saxion.nl.ns.ithardwaremanager.models.Item;
import com.saxion.nl.ns.ithardwaremanager.models.Room;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@Controller
@RequestMapping("/login")
public class LoginController {

    /**
     * The storage for the items
     */
    private StorageInterface storage;

    /**
     * ItemController
     */
    LoginController() {
        // TODO use dependency injection here so we dont specify
        // TODO the real class we want but the contract we would like to use
        this.storage = StorageContainer.getStorage();
    }

    @GetMapping(path = "/")
    public String index() {
        return "login-index";
    }
}