package net.hajar.customerservice;

import net.hajar.customerservice.entity.Customer;
import net.hajar.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(CustomerRepository customerRepository) {
        return args -> {
//            customerRepository.save(new Customer(null, "John", "Doe@gmail.com"));
            customerRepository.save(Customer.builder()
                    .name("Hajar").email("hajar@gmail.com").build());
            customerRepository.save(Customer.builder()
                    .name("Imane").email("imane@gmail.com").build());
            customerRepository.save(Customer.builder()
                    .name("Hanane").email("hanane@gmail.com").build());
        };
    }

}
