package com.maharshi.OrderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maharshi.OrderService.model.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {
}
