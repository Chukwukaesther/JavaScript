package com.semicolon.farm_Links.dto.request;

import com.semicolon.farm_Links.data.model.OrderStatus;
import com.semicolon.farm_Links.data.model.Product;
import com.semicolon.farm_Links.data.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddOrderRequest {
    private User user;
    private List<Product> products;
    private Double totalPrice;
    private OrderStatus status;
    private String deliveryAddress;
    private String paymentStatus;
    private String orderDate;

}
