package mum.waaproject.repositoryImpl;

import java.util.HashMap;
import java.util.Map;

import mum.waaproject.model.Cart;
import mum.waaproject.repository.CartRepository;

import org.springframework.stereotype.Component;

@Component
public class CartRepositoryImpl implements CartRepository {

	private Map<String, Cart> cartList;

	public CartRepositoryImpl() {
		cartList = new HashMap<String, Cart>();
	}

	@Override
	public Cart create(Cart cart) {
		if (cartList.containsKey(cart.getCartId())) {
			throw new IllegalArgumentException("Product aleardy exists in cart");
		}

		cartList.put(cart.getCartId(), cart);
		return cart;
	}

	@Override
	public Cart read(String cartId) {
		return cartList.get(cartId);
	}

	@Override
	public void update(String cartId, Cart cart) {
		if (!cartList.containsKey(cart.getCartId())) {
			throw new IllegalArgumentException(
					"Can not update cart. Product does not exist in cart");
		}

		cartList.put(cartId, cart);
	}

	@Override
	public void delete(String cartId) {
		if (!cartList.containsKey(cartId)) {
			throw new IllegalArgumentException(
					"Can not delete product from cart. Product does not exist in cart");
		}

		cartList.remove(cartId);
	}

}
