package stepik.contactsApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import stepik.contactsApp.dao.database.DatabaseInitializer;


@SpringBootApplication
public class ContactsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactsApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDatabase(DatabaseInitializer dbInitializer) {
		return args -> dbInitializer.init();
	}
}
