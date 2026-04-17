package stepik.contactsApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import stepik.contactsApp.dao.database.testdatafaker.DatabaseInitializer;


@SpringBootApplication
public class ContactsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactsApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDatabase(DatabaseInitializer dbInitializer) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				dbInitializer.init();
			}
		};
	}

}
