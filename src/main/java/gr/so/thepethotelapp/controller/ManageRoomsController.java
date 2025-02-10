package gr.so.thepethotelapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManageRoomsController {

    @GetMapping("/manage-rooms")
    public String manageRooms(Model model) {
        return "manageRooms"; // Το όνομα του HTML αρχείου
    }
}
