package com.semicolon.farm_Links.data.repository;

import com.semicolon.farm_Links.data.model.Order;
import com.semicolon.farm_Links.data.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUser_Id(Long userId);
    List<Order> findByStatus(OrderStatus status);


}

