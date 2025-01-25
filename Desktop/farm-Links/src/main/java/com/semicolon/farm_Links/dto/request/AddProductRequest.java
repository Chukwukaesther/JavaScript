package com.semicolon.farm_Links.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddProductRequest {
    private String name;
    private double price;
    private int quantity;
    private String description;
    private String category;
    private String image;

}
