package com.maharshi.ShoppingMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maharshi.ShoppingMS.model.CustomerCart;

@Repository
public interface CustomerCartDao extends JpaRepository<CustomerCart, Integer>{

}
