package application;


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
    CommandLineRunner initDatabase(CustomerRepository customerRepository) {
        return args -> {
            log.info("Preloading Customer-----------------------------------------------");
            log.info("Preloading -----------------------------------------------");
            log.info("----------------------------------------------------------");
            log.info("Customers in DataBase:");
            //if (customerRepository.findAll().isEmpty()) log.error("Nothing preloaded");
            //customerRepository.findAll().forEach(customer -> log.info(customer.toString()));

        };
    }
}
