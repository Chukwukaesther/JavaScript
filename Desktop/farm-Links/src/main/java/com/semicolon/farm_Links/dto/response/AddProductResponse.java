package com.semicolon.farm_Links.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddProductResponse {
    private Long productId;
    private String name;
    private double price;
    private String message;
}
