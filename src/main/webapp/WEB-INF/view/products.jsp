<%@ include file="../layout/taglib.jsp" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" type="text/css" href="<spring:url value="/css/style.css" />" />

<script type="text/javascript" src="<spring:url value="/javascript/cart.js" />" ></script>

<div id="main">
	<input type="button" class="btn-primary" value="Add New Product" onclick="window.location='<spring:url value="/products/add" />'"  />
	
</div>

