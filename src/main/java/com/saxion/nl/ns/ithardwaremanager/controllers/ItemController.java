package com.saxion.nl.ns.ithardwaremanager.controllers;

import com.saxion.nl.ns.ithardwaremanager.StorageContainer;
import com.saxion.nl.ns.ithardwaremanager.contracts.StorageInterface;
import com.saxion.nl.ns.ithardwaremanager.models.Item;
import com.saxion.nl.ns.ithardwaremanager.models.Room;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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
        this.storage = StorageContainer.getStorage();
    }

    /**
     * Add an item to an existing room
     *
     * @param roomUuid UUID
     */
    @GetMapping(path = "/add/{roomUuid}")
    public String addView(@PathVariable UUID roomUuid) {
        Room room = this.storage.getRoomByUUID(roomUuid);
        return "edit-item";
    }

    /**
     * Add an item to an existing room
     *
     * @param roomUuid UUID
     */
    @PostMapping(path = "/add/{roomUuid}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String add(@RequestParam("name") String name,
                      @RequestParam("description") String description,
                      @PathVariable UUID roomUuid) {
        Room room = this.storage.getRoomByUUID(roomUuid);
        room.addItem(new Item(name, description));
        this.storage.updateRoom(room);
        return "redirect:/item";
    }

    /**
     * Return a list of items
     */
    @GetMapping(path = "")
    public String index(Model model,
                        @RequestParam(defaultValue = "", value = "search") String search,
                        @CookieValue(value = "lastSearchResult", defaultValue = "defaultValue") String lastSearchResult,
                        HttpServletResponse response) {
        ArrayList<Room> rooms = this.storage.getRooms();
        ArrayList<Item> items = new ArrayList<>();
        Cookie searchCookie = null;
        if (!search.equals("")) {
            for (Room room : rooms) {
                for (Item item : room.getItems()) {
                    if (item.getName().contains(search) ||
                            item.getDescription().contains(search)) {
                        items.add(item);
                    }
                }
            }
            searchCookie = new Cookie("lastSearchResult", search);
            response.addCookie(searchCookie);
        } else {
            for (Room room : rooms) {
                items.addAll(room.getItems());
            }
        }

        model.addAttribute("items", items);
        model.addAttribute("lastSearchResult", lastSearchResult);
        model.addAttribute("search", searchCookie);

        // TODO return an thymeleaf index page
        return "item-index";
    }

    /**
     * Show a page that allows the user to edit the item
     */
    @GetMapping(path = "/get/{uuid}/edit")
    public String edit(@PathVariable UUID uuid,
                       Model model) {
        Item item = this.storage.getItemByUUID(uuid);
        model.addAttribute("item", item);
        System.out.println(item);
        // TODO return an thymeleaf index page
        return "edit-item";
    }

    /**
     * Show a page that allows the user to edit the item
     */
    @PostMapping(path = "/get/{uuid}/edit")
    public String update(@PathVariable UUID uuid,
                         @RequestParam("name") String name,
                         @RequestParam("description") String description) {
        Item item = this.storage.getItemByUUID(uuid);
        item.setName(name);
        item.setDescription(description);
        this.storage.updateItem(item);
        return "redirect:/item";
    }

    /**
     * Remove the item from a room
     */
    @PostMapping(path = "/remove/{uuid}")
    public String remove(@PathVariable UUID uuid) {
        Item item = this.storage.getItemByUUID(uuid);
        this.storage.removeItem(item);
        return "redirect:/item";
    }
}
