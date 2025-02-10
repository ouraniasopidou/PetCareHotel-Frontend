package gr.so.thepethotelapp;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThePetHotelAppApplication {

	public static void main(String[] args) {
		// Φόρτωση των μεταβλητών περιβάλλοντος από το .env
		Dotenv dotenv = Dotenv.load();
		System.setProperty("DB_USER", dotenv.get("DB_USER"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));

		SpringApplication.run(ThePetHotelAppApplication.class, args);
	}
}
