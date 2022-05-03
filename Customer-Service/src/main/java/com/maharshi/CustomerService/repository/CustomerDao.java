package com.maharshi.CustomerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maharshi.CustomerService.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
