package com.semicolon.farm_Links.service;

import com.semicolon.farm_Links.data.model.Order;
import com.semicolon.farm_Links.dto.request.AddOrderRequest;
import com.semicolon.farm_Links.dto.request.UpdateOrderRequest;
import com.semicolon.farm_Links.dto.response.AddOrderResponse;
import com.semicolon.farm_Links.dto.response.UpdateOrderResponse;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    AddOrderResponse addOrder(AddOrderRequest request);
    List<Order> getAllOrders();
    Optional<Order> getOrderById(Long orderId);
    UpdateOrderResponse updateOrder(UpdateOrderRequest request);
    void deleteOrder(Long orderId);
}
