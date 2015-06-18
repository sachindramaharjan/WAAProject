<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras"%>

<link rel="stylesheet" type="text/css"
	href="<spring:url value="/css/menu-style.css" />" />

<div id='cssmenu'>
<ul>
   <li class="${current == 'home' ? 'active': ''}"><a href="<spring:url value='/home'/>"><span>Home</span></a></li>
	   
   <security:authorize access="hasRole('ROLE_ADMIN')">
  	 	<li class="${current == 'home' ? 'active': ''}"><a href="<spring:url value='/category'/>" ><span>Category</span></a></li>
   		<li class="${current == 'products' ? 'active': ''}"><a href="<spring:url value='/products'/>" ><span>Products</span></a></li>
   </security:authorize>
   
   <li class="${current == 'cart' ? 'active': ''}"><a href="<spring:url value='/cart'/>"><span>Shopping Cart</span></a></li>
   
   <security:authorize access="!isAuthenticated()">
   	<li class="${current == 'login' ? 'active': ''}"><a href="<spring:url value='/login'/>"><span>Login</span></a></li>
   	<li class="${current == 'user' ? 'active': ''}"><a href="<spring:url value='/adduser'/>"><span>Register</span></a></li>
   </security:authorize>
	   
	<security:authorize access="isAuthenticated()">	   
   		<li><a href="<spring:url value='/logout'/>"><span>Logout</span></a></li>
   </security:authorize>
   
   <li class="${current == 'contactus' ? 'active': ''} last"><a href="<spring:url value='/contactus'/>"><span>Contact Us</span></a></li>
</ul>
</div>