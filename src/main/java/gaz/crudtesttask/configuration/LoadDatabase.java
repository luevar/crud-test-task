package gaz.crudtesttask.configuration;

import gaz.crudtesttask.models.User;
import gaz.crudtesttask.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new User("Alexander Miller", "+78231132452")));
            log.info("Preloading " + repository.save(new User("Viktor Aksenov", "+79518423714")));
            log.info("Preloading " + repository.save(new User("Nikolai Andreev", "+79532456752")));
        };
    }
}
