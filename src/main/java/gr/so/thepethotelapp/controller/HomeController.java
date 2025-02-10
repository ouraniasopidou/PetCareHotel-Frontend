package gr.so.thepethotelapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        // Αυτό επιστρέφει το όνομα της σελίδας (home.html) που θα εμφανίζεται
        return "home";
    }
}
