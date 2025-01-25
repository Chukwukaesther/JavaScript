package com.semicolon.farm_Links.data.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    @Enumerated(EnumType.STRING)
    private ProductCategory category;
    @ManyToOne
    @JoinColumn(name = "farmer_id", referencedColumnName = "id")
    private User farmer;

    private String image;



}
