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
	<h2 class="title text-center">Features Items</h2>
	<ul class="rig columns-3">

		<c:forEach items="${featureProducts}" var="item">
			<li><a
				href=" <spring:url value="/products/product?id=${item.id}" /> "><img
					src="<spring:url value="/images/product/${item.image}" />" /> </a>
				<h4>$${item.price}</h4>
				<p>${item.name}</p>
				<p>
					<button type="button" class="btn-primary-dashboard"
						onclick="addToCart(${item.id},1,'add')">
						<spring:message code="cart.label.addtocart" />
					</button>
				</p></li>
		</c:forEach>
	</ul>
	<h4 class="title text-center">More...</h4>
	<br />
	<h2 class="title text-center">Recommended Items</h2>
	<ul class="rig columns-3">
		<li><img
			src="<spring:url value="/images/product/product1.jpg" />" />
			<h4>$56</h4>
			<p>Easy Polo Black Edition</p>
			<p>
				<button type="button" class="btn-primary-dashboard"
					onclick="addToCart(1,1,'add')">
					<spring:message code="cart.label.addtocart" />
			</p></li>
		<li><img
			src="<spring:url value="/images/product/product1.jpg" />" />
			<h4>$56</h4>
			<p>Easy Polo Black Edition</p>
			<p>
				<button type="button" class="btn-primary-dashboard"
					onclick="addToCart(1,1,'add')">
					<spring:message code="cart.label.addtocart" />
			</p></li>
		<li><img
			src="<spring:url value="/images/product/product1.jpg" />" />
			<h4>$56</h4>
			<p>Easy Polo Black Edition</p>
			<p>
				<button type="button" class="btn-primary-dashboard"
					onclick="addToCart(1,1,'add')">
					<spring:message code="cart.label.addtocart" />
			</p></li>
		<li><img
			src="<spring:url value="/images/product/product1.jpg" />" />
			<h4>$56</h4>
			<p>Easy Polo Black Edition</p>
			<p>
				<button type="button" class="btn-primary-dashboard"
					onclick="addToCart(1,1,'add')">
					<spring:message code="cart.label.addtocart" />
			</p></li>
		<li><img
			src="<spring:url value="/images/product/product1.jpg" />" />
			<h4>$56</h4>
			<p>Easy Polo Black Edition</p>
			<p>
				<button type="button" class="btn-primary-dashboard"
					onclick="addToCart(1,1,'add')">
					<spring:message code="cart.label.addtocart" />
			</p></li>
		<li><img
			src="<spring:url value="/images/product/product1.jpg" />" />
			<h4>$56</h4>
			<p>Easy Polo Black Edition</p>
			<p>
				<button type="button" class="btn-primary-dashboard"
					onclick="addToCart(1,1,'add')">
					<spring:message code="cart.label.addtocart" />
			</p></li>
	</ul>
	<div id="dialog" title="Cart Notification" style="display:none">
		<p>The product was added to your cart.</p>
	</div>
</div>

