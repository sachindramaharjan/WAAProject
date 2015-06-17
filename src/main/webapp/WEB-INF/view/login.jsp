<%@ include file="../layout/taglib.jsp" %>
<link rel="stylesheet" type="text/css" href="<spring:url value="/css/style.css" />" />
<html>
<head>
<title>Login Page</title>
<style type="text/css">

fieldset{
	border-radius: 5px;
	width: 750px;
	margin: auto;
	margin-top: 50px;
	border: 2px solid #6E6E6E;
	margin-bottom: 50px;
}

.formlabel{
	display: block;
	margin-left: 20px;
	min-width: 100px;
	float: left;
	margin-top:4px;
	clear: left;
}
.forminput{
	display: inline-block;
	float: left;
	margin-top:4px;
	min-width: 300px;
}
.formerror{
	display: inline-block;
	color: red;
	border: 1px solid red;
	background-color: #F6CED8;
	border-radius: 3px;
	min-width: 300px;
	clear: right;
	margin-top: 4px;
	margin-left: 4px;
}
button{
	display:block;
	clear:both;
	margin-left: 20px;
	margin-bottom: 20px;
}

legend{
	background-color: #F2F2F2;
	border-radius: 5px;
	border: 2px solid #6E6E6E;
	padding: 4px;
}
#failmsg{
	color:red;
	background-color: #F5A9BC;
	border-radius: 5px;
	width: 750px;
	margin: auto;
	margin-top: 50px;
	border: 2px solid red;
	margin-bottom: 50px;
	text-align: center;
}
</style>
</head>
<body>
    <c:if test="${'fail' eq param.auth}">
    
        <div id="failmsg">
                Login Failed! <br />  
                Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
         </div>
         
    </c:if>
    
    <fieldset>
    <legend>Login Form</legend>
    <form action="login" method="post">

                <label for="username" class="formlabel">Username:</label>
                <input type='text' name='username' class="forminput" />
                
                <label for="password" class="formlabel">Password:</label>
                <input type='password' name='password' id="password" class="forminput"></td>
				<button>Login</button>
    </form>
    </fieldset>
</body>
</html>