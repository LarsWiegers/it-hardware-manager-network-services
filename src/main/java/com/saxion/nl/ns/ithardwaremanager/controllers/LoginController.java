package com.saxion.nl.ns.ithardwaremanager.controllers;

import com.saxion.nl.ns.ithardwaremanager.StorageContainer;
import com.saxion.nl.ns.ithardwaremanager.contracts.StorageInterface;
import com.saxion.nl.ns.ithardwaremanager.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/logout")
    public String logout(HttpSession session) {
        if(session.getAttribute("user") != null) {
            session.removeAttribute("user");
            return "redirect:/login";
        }
        return "redirect:/login";
    }

    @PostMapping(path = "")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        HttpSession session) {
        User lars = new User("lars@saxion.nl", "larsPassword");
        User jesse = new User("jesse@saxion.nl", "jessePassword");
        if(lars.equals(new User(email, password))) {
            session.setAttribute("user", lars);
        } else if(jesse.equals(new User(email, password))) {
            session.setAttribute("user", jesse);
        }else {
            return "redirect:/login";
        }

        return "redirect:/room";
    }
}