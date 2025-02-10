package gr.so.thepethotelapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Controller
public class RoomDetailsController {

    private final RestTemplate restTemplate;

    public RoomDetailsController() {
        this.restTemplate = new RestTemplate();
    }

    @GetMapping("/rooms/{id}")
    public String roomDetails(@PathVariable Long id, Model model) {
        // Καλούμε το backend API για τα δεδομένα του δωματίου
        String backendUrl = "http://localhost:8081/api/rooms/" + id;
        try {
            Object room = restTemplate.getForObject(backendUrl, Object.class);
            model.addAttribute("room", room);
            return "roomDetails"; // Επιστροφή του HTML template roomDetails.html
        } catch (HttpClientErrorException.NotFound e) {
            model.addAttribute("error", "Room with ID " + id + " not found!");
            return "error"; // Επιστροφή σελίδας λάθους αν το δωμάτιο δεν βρεθεί
        } catch (Exception e) {
            model.addAttribute("error", "An unexpected error occurred!");
            return "error"; // Επιστροφή σελίδας λάθους για γενικά προβλήματα
        }
    }
}
