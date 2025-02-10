package gr.so.thepethotelapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Εδώ μπορείς να περάσεις δεδομένα, όπως διαθέσιμα δωμάτια
        return "dashboard"; // Επιστροφή του dashboard.html
    }

    @PostMapping("/api/reservations")
    public String makeReservation(@RequestParam("room") String room,
                                  @RequestParam("startDate") String startDate,
                                  @RequestParam("endDate") String endDate,
                                  Model model) {
        // Εδώ μπορείς να κάνεις λογική για την αποθήκευση της κράτησης
        System.out.println("Room: " + room + ", Start Date: " + startDate + ", End Date: " + endDate);

        // Μπορείς να κατευθύνεις τον χρήστη σε σελίδα επιβεβαίωσης ή να δείξεις μήνυμα
        model.addAttribute("success", "Reservation successfully created for Room " + room);
        return "dashboard";
    }
}
