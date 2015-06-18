package mum.waaproject.serviceImpl;

import mum.waaproject.model.Cart;
import mum.waaproject.repository.CartRepository;
import mum.waaproject.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Cart Service
 * @author sachindra
 *
 */
@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepository;

	/**
	 * Delegates create request to CartRepository, returns Cart object
	 */
	@Override
	public Cart create(Cart cart) {
		return cartRepository.create(cart);
	}

	/**
	 * Delegates read request to CartRepository, returns Cart object
	 */
	@Override
	public Cart read(String cartId) {
		return cartRepository.read(cartId);
	}
	
	/**
	 * Deletes update request to CartRepository, returns void
	 */
	@Override
	public void update(String cartId, Cart cart) {
		cartRepository.update(cartId, cart);
	}

	/**
	 * Delegates delete request to CartRepository, return void
	 */
	@Override
	public void delete(String cartId) {
		cartRepository.delete(cartId);
	}

}
