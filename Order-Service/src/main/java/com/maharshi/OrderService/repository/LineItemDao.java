package com.maharshi.OrderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maharshi.OrderService.model.LineItem;

@Repository
public interface LineItemDao extends JpaRepository<LineItem, Integer> {
}
