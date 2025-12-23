
package net.hajar.billingservice.web;

import net.hajar.billingservice.entity.Bill;
import net.hajar.billingservice.feign.CustomerServiceRestClient;
import net.hajar.billingservice.feign.InventoryServiceRestClient;
import net.hajar.billingservice.model.Customer;
import net.hajar.billingservice.repository.BillRepository;
import net.hajar.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")


public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerServiceRestClient customerRestClient;
    @Autowired
    private InventoryServiceRestClient productRestClient;

    @GetMapping(path = "/bills/{id}")
    public Bill getBill(@PathVariable Long id){
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(productItem -> {
            productItem.setProduct(productRestClient.getProduct(productItem.getProductId()).getProduct());
        });
        return bill;
    }

}
