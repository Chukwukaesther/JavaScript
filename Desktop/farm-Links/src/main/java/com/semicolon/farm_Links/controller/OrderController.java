package com.semicolon.farm_Links.controller;

import com.semicolon.farm_Links.data.model.Order;
import com.semicolon.farm_Links.dto.request.AddOrderRequest;
import com.semicolon.farm_Links.dto.request.UpdateOrderRequest;
import com.semicolon.farm_Links.dto.response.AddOrderResponse;
import com.semicolon.farm_Links.dto.response.UpdateOrderResponse;
import com.semicolon.farm_Links.dto.response.ApiResponse;
import com.semicolon.farm_Links.exception.FarmLinkException;
import com.semicolon.farm_Links.service.OrderService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@NonNull
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<?> addOrder(@RequestBody AddOrderRequest request) {
        try {
            AddOrderResponse result = orderService.addOrder(request);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (FarmLinkException exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllOrders() {
        try {
            List<Order> orders = orderService.getAllOrders();

            return ResponseEntity.ok(new ApiResponse(true, orders));
        } catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long id) {
        try {
            Order order = orderService.getOrderById(id)
                    .orElseThrow(() -> new FarmLinkException("Order not found with ID: " + id));
            return ResponseEntity.ok(new ApiResponse(true, order));
        } catch (FarmLinkException exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateOrder(@RequestBody UpdateOrderRequest request) {
        try {
            UpdateOrderResponse result = orderService.updateOrder(request);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (FarmLinkException exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        try {
            orderService.deleteOrder(id);
            return ResponseEntity.ok(new ApiResponse(true, "Order deleted successfully"));
        } catch (FarmLinkException exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }
}
