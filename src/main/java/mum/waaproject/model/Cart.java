package mum.waaproject.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

	private String cartId;
	private Map<String, CartItem> cartItems;
	private double total;

	public Cart() {
		cartItems = new HashMap<String, CartItem>();
		total = new Double(0);
	}

	public Cart(String cartId) {
		this();
		this.cartId = cartId;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public double getTotal() {
		return total;
	}

	public void addCartItem(CartItem item, String mode) {
		String productId = String.valueOf(item.getProduct().getId());

		if (cartItems.containsKey(productId)) {
			CartItem existingCartItem = cartItems.get(productId);
			if(mode.equalsIgnoreCase("update")){
				existingCartItem.setQuantity(item.getQuantity());
			}else{
				existingCartItem.setQuantity(existingCartItem.getQuantity()
					+ item.getQuantity());
			}
			cartItems.put(productId, existingCartItem);
		} else {
			cartItems.put(productId, item);
		}
		updateGrandTotal();
	}

	public void removeCartItem(CartItem item) {
		String productId = String.valueOf(item.getProduct().getId());
		cartItems.remove(productId);
		updateGrandTotal();
	}

	public void updateGrandTotal() {
		total = new Double(0);
		for (CartItem item : cartItems.values()) {
			total = total + item.getTotalPrice();
		}
		
		total = (double) Math.round(total * 100) / 100;
	}

	@Override
	public int hashCode() {
		final int prime = 71;
		int result = 1;
		result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (cartId == null) {
			if (other.cartId != null)
				return false;
		} else if (!cartId.equals(other.cartId))
			return false;
		return true;
	}
}
