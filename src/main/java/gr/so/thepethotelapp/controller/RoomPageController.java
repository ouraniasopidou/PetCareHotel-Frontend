package gr.so.thepethotelapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class RoomPageController {

    private final RestTemplate restTemplate;

    public RoomPageController() {
        this.restTemplate = new RestTemplate();
    }

    @GetMapping("/rooms")
    public String listRooms(Model model) {
        String apiUrl = "http://localhost:8081/api/rooms"; // URL για το API του backend
        Object[] rooms = restTemplate.getForObject(apiUrl, Object[].class); // Λήψη δεδομένων από το API
        model.addAttribute("rooms", rooms); // Προσθήκη των δωματίων στο μοντέλο
        return "rooms"; // Επιστροφή στο rooms.html
    }
}
