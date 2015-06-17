<%@ include file="../layout/taglib.jsp" %>
<link rel="stylesheet" type="text/css" href="<spring:url value="/css/style.css" />" />

<style>
#msg{
margin-top: 50px;
margin-bottom: 50px;
margin-left: auto;
margin-right: auto;
min-height: 50px;
max-width: 600px;
background-color: #D8D8D8;
border-radius: 5px;
border: 1px solid #6E6E6E;
}
#msg>p{
border-left: 15px;
font-family: sans-serif;
font-size: 15pt;
}
</style>

<div id="msg">
<p>
User ${user.customer.firstname} ${user.customer.lastname} has been registered Succesfully.
</p>
</div>
