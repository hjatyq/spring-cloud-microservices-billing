package net.hajar.inventoryservice.repository;

import net.hajar.inventoryservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface ProductRepository extends JpaRepository<Product,Long> {
}
