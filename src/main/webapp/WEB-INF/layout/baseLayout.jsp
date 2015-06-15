<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras"%>
<%@ include file="/WEB-INF/layout/taglib.jsp" %>

<html>
<head>

<title><tiles:getAsString name="title"></tiles:getAsString></title>

<link rel="stylesheet" type="text/css" href="<spring:url value="/css/animate.css" />" />
<link rel="stylesheet" type="text/css" href="<spring:url value="/css/bootstrap.min.css" />" />
<link rel="stylesheet" type="text/css" href="<spring:url value="/css/font-awesome.min.css" />" />
<link rel="stylesheet" type="text/css" href="<spring:url value="/css/prettyPhoto.css" />" />
<link rel="stylesheet" type="text/css" href="<spring:url value="/css/price-range.css" />" />
<link rel="stylesheet" type="text/css" href="<spring:url value="/css/responsive.css" />" />
<link rel="stylesheet" type="text/css" href="<spring:url value="/css/main.css" />" />

<link rel="shortcut icon" href="/images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="<spring:url value="/images/ico/apple-touch-icon-144-precomposed.png"/>">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="<spring:url value="/images/ico/apple-touch-icon-114-precomposed.png"/>">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="<spring:url value="/images/ico/apple-touch-icon-72-precomposed.png"/>" >
</head>

<body>
	<header id="header">
		<tiles:insertAttribute name="header-top" />
		<tiles:insertAttribute name="header-middle" />
		<tiles:insertAttribute name="header-bottom" />
	</header>
	
	<tiles:insertAttribute name="slider" /> <!-- slider in home page -->
	<tiles:insertAttribute name="business" /> <!-- main block -->
	<tiles:insertAttribute name="footer" /> <!-- footer -->

 	<script src="<spring:url value="/js/jquery.js"/>"></script>
	<script src="<spring:url value="/js/bootstrap.min.js"/>" ></script>
	<script src="<spring:url value="/js/jquery.scrollUp.min.js"/>"></script>
	<script src="<spring:url value="/js/price-range.js"/>"></script>
    <script src="<spring:url value="/js/jquery.prettyPhoto.js"/>"></script>
    <script src="<spring:url value="/js/main.js"/>"></script>
</body>
</html>