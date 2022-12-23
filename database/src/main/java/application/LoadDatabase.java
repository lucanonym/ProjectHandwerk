package application;

import application.entities.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import application.repositories.CustomerRepository;


@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CustomerRepository repository) {
        return args -> {
            log.info("Preloading -----------------------------------------------");
            repository.save(new Customer("Bilbo", "Baggins","littleStreet"));
            log.info("Preloading -----------------------------------------------");
            repository.save(new Customer("Frodo", "Baggins", "bigStreet"));
            log.info("----------------------------------------------------------");
            log.info("Customers in DataBase:");
            if (repository.findAll().isEmpty()) log.error("Nothing preloaded");
            repository.findAll().forEach(customer -> log.info(customer.toString()));

        };
    }
}
