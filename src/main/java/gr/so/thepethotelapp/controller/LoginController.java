package gr.so.thepethotelapp.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class LoginController {

    private final RestTemplate restTemplate;

    public LoginController() {
        this.restTemplate = new RestTemplate();
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        String loginUrl = "http://localhost:8081/api/users/login";

        // Δημιουργία του JSON αιτήματος
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        String requestBody = String.format("{\"username\":\"%s\",\"password\":\"%s\"}", username, password);
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        try {
            // POST αίτημα στο backend
            ResponseEntity<String> response = restTemplate.exchange(
                    loginUrl,
                    HttpMethod.POST,
                    request,
                    String.class
            );

            if (response.getStatusCode().is2xxSuccessful()) {
                // Αν επιτυχής σύνδεση, ανακατεύθυνση στο dashboard
                return "redirect:/dashboard";
            } else {
                // Εμφάνιση μηνύματος λάθους αν τα credentials είναι λανθασμένα
                model.addAttribute("error", "Invalid username or password");
                return "login";
            }
        } catch (Exception e) {
            // Εμφάνιση μηνύματος λάθους σε περίπτωση σφάλματος του server
            model.addAttribute("error", "Server error. Please try again later.");
            return "login";
        }
    }
}
