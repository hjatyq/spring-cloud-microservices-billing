package net.hajar.billingservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.hajar.billingservice.entity.ProductItem;
import net.hajar.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface InventoryServiceRestClient {

    @GetMapping("/products/{id}")
    @CircuitBreaker(name = "inv-service" , fallbackMethod = "getDefaultProduct")
    ProductItem getProduct(@PathVariable Long id);

    default Product getDefaultProduct(long id,Exception e){

        return Product.builder().id(id).build();

    }
}
