package com.maharshi.CartService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maharshi.CartService.model.LineItem;

@Repository
public interface LineItemDao extends JpaRepository<LineItem, Integer> {

}
