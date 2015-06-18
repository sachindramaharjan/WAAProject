<%@ include file="../layout/taglib.jsp" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" type="text/css" href="<spring:url value="/css/style.css" />" />
<script type="text/javascript" src="<spring:url value="/javascript/product.js" />" ></script>

<script type="text/javascript" src="<spring:url value="/javascript/cart.js" />" ></script>

<div id="main">
	<div style="float:right">
	<input type="button" class="btn-primary" value="Add New Product" onclick="window.location='<spring:url value="/products/add" />'"  />
	</div>
	<br/>
	
	<h2 class="title text-center">All Products</h2>
	<ul class="rig columns-3">

		<c:forEach items="${products}" var="item">
			<li><a
				href=" <spring:url value="/products/product/${item.id}" /> "><img
					src="<spring:url value="/images/product/${item.image}" />" /> </a>
				<h4>$${item.price}</h4>
				<p>${item.name}</p>
				<p>
					<button type="button" class="btn-primary-dashboard"
						onclick="removeProduct(${item.id})">
						<spring:message code="product.list.label.remove" />
					</button>
				</p></li>
		</c:forEach>
	</ul>
</div>
<div id="confirm" title="Confirm" style="display:none">
		<p><spring:message code="product.dialog.message"/></p>
	</div>
