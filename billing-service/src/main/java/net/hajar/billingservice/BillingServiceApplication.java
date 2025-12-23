package net.hajar.billingservice;

import net.hajar.billingservice.entity.Bill;
import net.hajar.billingservice.entity.ProductItem;
import net.hajar.billingservice.feign.CustomerServiceRestClient;
import net.hajar.billingservice.repository.BillRepository;
import net.hajar.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
  public CommandLineRunner commandLineRunner (BillRepository billRepository, ProductItemRepository  productItemRepository) {
        return args -> {
            List<Long> customersIds=List.of(1L,2L,3L);
            List<Long>  productIds=List.of(1L,2L,3L);

            customersIds.forEach(clientId->{
                Bill bill=new Bill();
                bill.setBillingDate(new Date());
                bill.setCustomerId(clientId);
                billRepository.save(bill);

                productIds.forEach(productId->{
                    ProductItem productItem=new ProductItem();
                    productItem.setPrice(1000*Math.random()*6000);
                    productItem.setQuantity(1+new Random().nextInt(20));
                    productItem.setBill(bill);
                    productItem.setProductId(productItem.getProductId());
                    productItemRepository.save(productItem);

                });

            });

        };
    }

}
