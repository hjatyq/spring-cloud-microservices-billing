package net.hajar.customerservice.repository;

import net.hajar.customerservice.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
