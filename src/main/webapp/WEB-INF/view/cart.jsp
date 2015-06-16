<%@ include file="../layout/taglib.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<link rel="stylesheet" type="text/css" href="<spring:url value="/css/style.css" />" />

<script type="text/javascript" src="<spring:url value="/javascript/cart.js" />" ></script>

  <div id="main">
  	<c:set var="cartsize" value="${fn:length(cart.cartItems)}" />
  
  	<c:choose>
  		<c:when test="${cartsize == 0 }">
  			<div>
  				<h2>No products added to the cart</h2>
  			</div>
  		</c:when>
  		<c:otherwise>
  			<div id="table">
			  	<table style="width: 100%;text-align: center;">
					<thead>
						<tr class="cart_menu">
							<td class="image" width="20%">Item</td>
							<td class="description" width="30%" >Description</td>
							<td class="price"  width="15%" >Price</td>
							<td class="quantity" width="15%" >Quantity</td>
							<td class="total"  width="15%">Total</td>
							<td ></td>
						</tr>
					</thead>
			  		<tbody>
			  			
			  			<c:forEach items="${cart.cartItems}" var="cart">
			  				<tr id="product_${cart.value.product.id}">
								<td class="cart_product">
									<a href=""><img src="<spring:url value="/images/product/one.png" />" alt=""></a>
								</td>
								<td class="cart_description">
									<h4><a href="/product/${cart.value.product.id}"><c:out value="${cart.value.product.name}"  /></a></h4>
									<p>Web ID: <c:out value="${cart.value.product.productcode}" /></p>
								</td>
								<td class="cart_price">
									<p>$ <c:out value="${cart.value.product.price}" /></p>
								</td>
								<td class="cart_quantity">
									<div class="cart_quantity_button">
										<input id="#quantity${cart.value.product.id}" class="cart_quantity_input" type="text" name="quantity"  value="<c:out value="${cart.value.quantity}"/>" autocomplete="off" size="2">
									</div>
								</td>
								<td class="cart_total">
									<p class="cart_total_price">$ <c:out value="${cart.value.totalPrice}"/></p>
								</td>
								<td class="cart_delete">
									<button type="button" onclick="removeFromCart('product_'+${cart.value.product.id},${cart.value.product.id});">Remove</button>
								</td>
							</tr>
							
						</c:forEach>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td>Total Price</td>
							<td>$ ${cart.total}</td>
						</tr>
			  		</tbody>
			 	 </table>  
				
					<input type="submit" value="Checkout" class="btn-primary" />
				</div>
	  		</c:otherwise>
	  	</c:choose>
  		
  		<div class="checkout">
			<button type="button" class="btn-primary" value="Continue Shopping" onclick="window.location='<spring:url value="/home" />'">Continue Shopping</button>
			<button type="button" class="btn-primary" value="Add To Cart" onclick="addToCart(1)">Add To Cart</button>
		</div>
</div>
  	
