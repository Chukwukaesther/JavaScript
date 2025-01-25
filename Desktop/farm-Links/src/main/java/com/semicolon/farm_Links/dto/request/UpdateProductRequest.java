package com.semicolon.farm_Links.dto.request;
import com.semicolon.farm_Links.data.model.ProductCategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductRequest {
    private Long productId;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private ProductCategory category;
}
