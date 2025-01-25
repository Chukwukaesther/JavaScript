package com.semicolon.farm_Links.dto.request;

import com.semicolon.farm_Links.data.model.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateOrderRequest {
    private Long orderId;
    private Double totalPrice;
    private OrderStatus status;
    private String deliveryAddress;
    private String paymentStatus;
    private String orderDate;

}
