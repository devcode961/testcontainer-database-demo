package com.example.demo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customers")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_generator")
    @SequenceGenerator(name = "customer_id_generator", sequenceName = "customer_id_seq", allocationSize = 1)
    private Long Id;

    @Column(name = "name")
    private String name;

}
