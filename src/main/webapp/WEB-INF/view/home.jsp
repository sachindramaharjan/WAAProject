<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../layout/taglib.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
				href=" <spring:url value="/products/product/${item.id}" /> "><img
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
	<br />
	<h2 class="title text-center">New Items</h2>
	<ul class="rig columns-3">
		<c:forEach items="${newProducts}" var="newItem">
			<li><a
				href=" <spring:url value="/products/product?id=${newItem.id}" /> "><img
					src="<spring:url value="/images/product/${newItem.image}" />" /> </a>
				<h4>$${newItem.price}</h4>
				<p>${newItem.name}</p>
				<p>
					<button type="button" class="btn-primary-dashboard"
						onclick="addToCart(${newItem.id},1,'add')">
						<spring:message code="cart.label.addtocart" />
					</button>
				</p></li>
		</c:forEach>
	</ul>
	<div id="dialog" title="Cart Notification" style="display: none">
		<p>
			<spring:message code="cart.dialog.message" />
		</p>
	</div>
</div>
