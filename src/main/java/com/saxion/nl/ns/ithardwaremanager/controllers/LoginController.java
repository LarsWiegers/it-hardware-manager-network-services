package com.saxion.nl.ns.ithardwaremanager.controllers;

import com.saxion.nl.ns.ithardwaremanager.StorageContainer;
import com.saxion.nl.ns.ithardwaremanager.contracts.StorageInterface;
import com.saxion.nl.ns.ithardwaremanager.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

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
    public LoginController() {
        // TODO use dependency injection here so we dont specify
        // TODO the real class we want but the contract we would like to use
        this.storage = StorageContainer.getStorage();
    }

    @GetMapping(path = "")
    public String index(HttpSession session) {
            if(session.getAttribute("user") != null) {
                return "redirect:/room";
            }
        return "login-index";
    }

    @PostMapping(path = "")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        HttpSession session) {
        for (User user: this.storage.getUsers()) {
            if(user.equals(new User(email, password))) {
                session.setAttribute("user", user);
                return "redirect:/room";
            }
        }
        return "redirect:/login";
    }
}