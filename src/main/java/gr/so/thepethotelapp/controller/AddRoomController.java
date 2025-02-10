package gr.so.thepethotelapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddRoomController {

    @GetMapping("/add-room")
    public String addRoom() {
        return "addRoom"; // Το όνομα του HTML αρχείου
    }
}
