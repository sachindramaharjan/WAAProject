<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../layout/taglib.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<spring:url value="/css/style.css" />" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/ui-lightness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript"
	src="<spring:url value="/javascript/cart.js" />"></script>
<div id="main">
	<h2 class="title text-center">Product Detail</h2>
	<div class="product-details">
		<!--product-details-->
		<div class="col-sm-5">
			<div class="view-product">
				<img src="<spring:url value="/images/product/${product.image}" />"
					alt=""/>
			</div>
		</div>
		<div class="col-sm-7">
			<div class="product-information">
				<!--/product-information-->
				<h2>${product.name}</h2>
				<p>
					<spring:message code="product.add.label.productcode" />
					: ${product.productcode}
				</p>
				<span>US $${product.price}</span> <br /> <label><spring:message
						code="cart.table.label.quantity" />:</label><input id="quantity_val"
					type="text" value="3" />
				<button type="button" class="btn-primary-dashboard"
					onclick="addProductToCart(${product.id}, 'quantity_val')">
					<spring:message code="cart.label.addtocart" />
				</button>
				</span>
				<p>
					<b><spring:message code="product.add.label.store" />:</b>
					${store.name}
				</p>
				<p>
					<b><spring:message code="product.add.label.category" />:</b>
					${category.name}
				</p>
				<!--<a href=""><img src="images/product-details/share.png" class="share img-responsive"  alt="" /></a>-->
			</div>
			<!--/product-information-->
		</div>
	</div>
	<!--/product-details-->
	<div id="dialog" title="Cart Notification" style="display:none">
		<p>The product was added to your cart.</p>
	</div>
</div>

