package com.saxion.nl.ns.ithardwaremanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/logout")
public class LogoutController {


    @GetMapping(path = "")
    public String logout(HttpSession session) {
        if(session.getAttribute("user") != null) {
            session.removeAttribute("user");
            return "redirect:/login";
        }
        return "redirect:/login";
    }
}