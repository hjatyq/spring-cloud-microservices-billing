package net.hajar.inventoryservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class Product {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private double price;
    private int quantity;
}
