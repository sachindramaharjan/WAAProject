package mum.waaproject.controller;

import javax.servlet.http.HttpServletRequest;

import mum.waaproject.exception.ProductNotFoundException;
import mum.waaproject.model.Cart;
import mum.waaproject.model.CartItem;
import mum.waaproject.model.Product;
import mum.waaproject.service.CartService;
import mum.waaproject.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@Autowired
	private ProductService productService;

	@RequestMapping
	public String show(HttpServletRequest request) {
		return "redirect:/cart/view?Id=" + request.getSession(true).getId();
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String showCart(@RequestParam("Id") String cartId, Model model) {
		model.addAttribute("cartId", cartId);
		Cart cart = cartService.read(cartId);
		
		if (cart == null) {
			cart = new Cart(cartId);
			cartService.create(cart);
		}
		model.addAttribute("cart", cart);
		return "cart";
	}

	@RequestMapping(value = "/add/{productid}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addToCart(@PathVariable("productid") int productId,
			Model model, HttpServletRequest request) {
	
		// get cart id from session
		String cartId = request.getSession(true).getId();
		Cart cart = cartService.read(cartId);

		if (cart == null) {
			cart = cartService.create(new Cart(cartId));
		}

		// get product infomation
		Product product = productService.getProductById(productId);
		if (product == null) {
			throw new ProductNotFoundException(productId, "{product.not.found}");
		}
		CartItem item = new CartItem(product);
		cart.addCartItem(item);

		cartService.update(cartId, cart);
	}

	@RequestMapping(value = "/remove/{productid}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeFromCart(@PathVariable("productid") int productId,
			Model model, HttpServletRequest request) {

		String cartId = request.getSession().getId();
		Cart cart = cartService.read(cartId);
		if (cart != null) {
			Product product = productService.getProductById(productId);
			if (product == null) {
				throw new ProductNotFoundException(productId,
						"{product.not.found}");
			}

			cart.removeCartItem(new CartItem(product));
			cartService.update(cartId, cart);
		}
	}

}
