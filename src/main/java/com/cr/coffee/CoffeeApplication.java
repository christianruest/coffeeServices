package com.cr.coffee;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * mvn spring-boot:run
 */
@SpringBootApplication(scanBasePackages = {"com.cr.coffee"})
@EnableJpaRepositories(basePackages = {"com.cr.coffee.repositories"})
public class CoffeeApplication {

    /*static Logger logger = LoggerFactory.getLogger(CoffeeApplication.class);*/

    public static void main(String[] args) {
        SpringApplication.run(CoffeeApplication.class, args);
        /*logger.warn("a WARNING here");*/
    }
}