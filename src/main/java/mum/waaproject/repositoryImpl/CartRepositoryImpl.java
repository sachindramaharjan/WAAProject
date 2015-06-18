package mum.waaproject.repositoryImpl;

import java.util.HashMap;
import java.util.Map;

import mum.waaproject.model.Cart;
import mum.waaproject.repository.CartRepository;

import org.springframework.stereotype.Component;

/**
 * Holds user cart in memory
 * @author sachindra
 *
 */
@Component
public class CartRepositoryImpl implements CartRepository {

	private Map<String, Cart> cartList;

	/**
	 * Creates new instance of HashMap<String, Cart>
	 */
	public CartRepositoryImpl() {
		cartList = new HashMap<String, Cart>();
	}

	/**
	 * Adds cart into the map, throws IllegalArgumentException
	 */
	@Override
	public Cart create(Cart cart) {
		if (cartList.containsKey(cart.getCartId())) {
			throw new IllegalArgumentException("Product aleardy exists in cart");
		}

		cartList.put(cart.getCartId(), cart);
		return cart;
	}

	/**
	 * Returns HashMap
	 */
	@Override
	public Cart read(String cartId) {
		return cartList.get(cartId);
	}

	/**
	 * Updates HashMap, throws IllegalArgumentException
	 */
	@Override
	public void update(String cartId, Cart cart) {
		if (!cartList.containsKey(cart.getCartId())) {
			throw new IllegalArgumentException(
					"Can not update cart. Product does not exist in cart");
		}

		cartList.put(cartId, cart);
	}

	/**
	 * Deletes cart from HashMap, throws IllegalArgumentException
	 */
	@Override
	public void delete(String cartId) {
		if (!cartList.containsKey(cartId)) {
			throw new IllegalArgumentException(
					"Can not delete product from cart. Product does not exist in cart");
		}

		cartList.remove(cartId);
	}

}
