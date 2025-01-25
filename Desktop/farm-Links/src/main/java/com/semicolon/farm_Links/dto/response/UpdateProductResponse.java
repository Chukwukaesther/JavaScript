package com.semicolon.farm_Links.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductResponse {
    private String message;
    private Long productId;
    private String UpdatedName;
}
