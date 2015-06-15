<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras"%>
<%@ include file="/WEB-INF/layout/taglib.jsp" %>

<html>
<head>

<title><tiles:getAsString name="title"></tiles:getAsString></title>

<link rel="stylesheet" type="text/css"
	href="<spring:url value="/css/style.css" />" />

</head>
<body>
	<div id="container">
		<div id="header">
			<div id="logo">
			</div>
			<div id="login">
				<tiles:insertAttribute name="login" />
			</div>
			<div id="addtocart">
				<tiles:insertAttribute name="addtocart" />
			</div>
			<div>
				<tiles:insertAttribute name="navigation" />
			</div>
		</div>
		
		<div id="content">
			<div id="left">
				<tiles:insertAttribute name="category" />
			</div>
			<div id="right">		
				<tiles:insertAttribute name="main" />
			</div>
		</div>			
	
		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>