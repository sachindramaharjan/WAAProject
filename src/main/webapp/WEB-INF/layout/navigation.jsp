<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<link rel="stylesheet" type="text/css"
	href="<spring:url value="/css/menu-style.css" />" />

<div id='cssmenu'>
<ul>
   <li class="active"><a href="<spring:url value='/home'/>"><span>Home</span></a></li>
   <li><a href="<spring:url value='/newproducts'/>" ><span>NewProducts</span></a></li>
   <li><a href="<spring:url value='/shoppingcart'/>"><span>Shopping Cart</span></a></li>
   <li><a href="<spring:url value='/login'/>"><span>Login</span></a></li>
   <li class='last'><a href="<spring:url value='/contactus'/>"><span>Contact Us</span></a></li>
</ul>
</div>