package net.hajar.billingservice.model;

import jakarta.persistence.Transient;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    private Long id;
    private String name;
    private String email;
    @Transient
    private Customer customer;
}
