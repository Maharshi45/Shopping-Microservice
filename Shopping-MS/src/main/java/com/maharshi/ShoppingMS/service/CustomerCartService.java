package com.maharshi.ShoppingMS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maharshi.ShoppingMS.exception.ResourceNotFoundException;
import com.maharshi.ShoppingMS.model.CustomerCart;
import com.maharshi.ShoppingMS.repository.CustomerCartDao;

@Service
public class CustomerCartService {

	@Autowired
	private CustomerCartDao dao;

	public CustomerCart createCustomerCart(CustomerCart customerCart) {
		return dao.save(customerCart);
	}

	public CustomerCart getCustomerCartById(int id) throws ResourceNotFoundException {
		if (dao.existsById(id))
			return dao.findById(id).get();
		else
			throw new ResourceNotFoundException("Resource Not Found");
	}

	public void deleteCustomerCartById(int id) throws ResourceNotFoundException {
		if (dao.existsById(id))
			dao.deleteById(id);
		else
			throw new ResourceNotFoundException("Resource Not Found");
	}

	public void deleteAllCustomerCart() {
		dao.deleteAll();
	}

}
