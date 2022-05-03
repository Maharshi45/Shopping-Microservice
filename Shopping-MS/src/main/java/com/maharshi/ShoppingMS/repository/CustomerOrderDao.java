package com.maharshi.ShoppingMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maharshi.ShoppingMS.model.CustomerOrder;

@Repository
public interface CustomerOrderDao extends JpaRepository<CustomerOrder, Integer> {

	public List<CustomerOrder> getCustomerOrdersByCustomerId(int id);

	@Transactional
	public void deleteByCustomerId(int id);

}
