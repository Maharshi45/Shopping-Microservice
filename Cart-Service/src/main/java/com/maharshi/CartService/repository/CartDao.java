package com.maharshi.CartService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maharshi.CartService.model.Cart;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer> {

}
