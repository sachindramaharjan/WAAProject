<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<spring:url value="/css/style.css" />" />
<title>File Upload Error</title>
</head>
<body>

	<center>
			<img src="<spring:url value="/images/errorexceptionicon.png"  htmlEscape="true" />" alt=""  />
			<p><spring:message code="${message}"/></p>
			
			<p>
				<button onclick="window.location='<spring:url value="${referred}" />' " class="btn-primary">Back</button>
			</p>
		
	</center>
</body>
</html>




