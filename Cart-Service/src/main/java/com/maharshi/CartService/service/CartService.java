package com.maharshi.CartService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maharshi.CartService.exception.CartNotFoundException;
import com.maharshi.CartService.model.Cart;
import com.maharshi.CartService.model.LineItem;
import com.maharshi.CartService.repository.CartDao;
import com.maharshi.CartService.repository.LineItemDao;

@Service
public class CartService {

	@Autowired
	private CartDao cartDao;

	@Autowired
	private LineItemDao lineItemDao;

	public Cart createCart(Cart cart) {
		List<LineItem> items = cart.getItems();
		List<Integer> productIds = new ArrayList<Integer>();
		List<LineItem> list = new ArrayList<LineItem>();

		for (LineItem item : items)
			productIds.add(item.getProductId());

		for (int i = 0; i < items.size(); i++) {
			productIds.remove(0);
			if (!productIds.contains(items.get(i).getProductId()))
				list.add(items.get(i));
		}

		cart.setItems(list);
		return cartDao.save(cart);
	}

	public Cart getCartById(int id) throws CartNotFoundException {
		if (cartDao.existsById(id))
			return cartDao.findById(id).get();
		else
			throw new CartNotFoundException("Cart with id=" + id + " does not exist");
	}

	public List<Cart> getCarts() {
		return cartDao.findAll();
	}

	public void deleteCartById(int id) throws CartNotFoundException {
		if (cartDao.existsById(id))
			cartDao.deleteById(id);
		else
			throw new CartNotFoundException("Cart with id=" + id + " does not exist");
	}

	public void deleteAllCarts() {
		lineItemDao.deleteAll();
		cartDao.deleteAll();
	}

	public Cart updateCart(Cart cart) throws CartNotFoundException {
		if (cartDao.existsById(cart.getCartId())) {

			Cart tempCart = cartDao.findById(cart.getCartId()).get();
			List<LineItem> items = cart.getItems();
			List<Integer> productIds = new ArrayList<Integer>();
			List<LineItem> list = new ArrayList<LineItem>();

			for (LineItem item : items)
				productIds.add(item.getProductId());
			for (int i = 0; i < items.size(); i++) {
				productIds.remove(0);
				if (!productIds.contains(items.get(i).getProductId()))
					list.add(items.get(i));
			}
			tempCart.setItems(items);
			return cartDao.save(tempCart);
		} else
			throw new CartNotFoundException("Cart with id=" + cart.getCartId() + " does not exist");
	}

}
