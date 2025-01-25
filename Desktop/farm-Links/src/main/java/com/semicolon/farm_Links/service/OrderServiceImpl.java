package com.semicolon.farm_Links.service;

import com.semicolon.farm_Links.data.model.Order;
import com.semicolon.farm_Links.data.repository.OrderRepository;
import com.semicolon.farm_Links.dto.request.AddOrderRequest;
import com.semicolon.farm_Links.dto.request.UpdateOrderRequest;
import com.semicolon.farm_Links.dto.response.AddOrderResponse;
import com.semicolon.farm_Links.dto.response.UpdateOrderResponse;
import com.semicolon.farm_Links.exception.FarmLinkException;
import com.semicolon.farm_Links.exception.OrderNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public AddOrderResponse addOrder(AddOrderRequest request) {
        Order order = new Order();
        BeanUtils.copyProperties(order, request);
        order = orderRepository.save(order);

        AddOrderResponse response = new AddOrderResponse();
        response.setOrderId(order.getId());
        response.setMessage("Order placed successfully");
        return response;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
    public UpdateOrderResponse updateOrder(UpdateOrderRequest request) {

        Order order = orderRepository.findById(request.getOrderId())
                .orElseThrow(() -> new OrderNotFoundException("Order not found with ID: " + request.getOrderId()));

        BeanUtils.copyProperties(request, order);
        order = orderRepository.save(order);

        UpdateOrderResponse response = new UpdateOrderResponse();
        response.setOrderId(order.getId());
        response.setMessage("Order updated successfully");

        return response;
    }



    @Override
    public void deleteOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new FarmLinkException("Order not found with ID: " + orderId));
        orderRepository.delete(order);
    }
}
