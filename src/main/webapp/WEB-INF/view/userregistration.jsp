
<%@ include file="../layout/taglib.jsp" %>
<link rel="stylesheet" type="text/css" href="<spring:url value="/css/style.css" />" />

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
	min-height: 20px;
}
button{
	display:block;
	clear:both;
	margin-left: 20px;
	margin-bottom: 30px;
}

legend{
	background-color: #F2F2F2;
	border-radius: 5px;
	border: 2px solid #6E6E6E;
}

</style>


<fieldset>
<legend>User Registration</legend>

<form:form commandName="user" action="saveuser" class="forminput">

<form:label path="username" class="formlabel">Username</form:label> 
<form:input  path="username" class="forminput"/>
<form:errors path="username" cssClass="formerror"/><br>

<form:label path="password" class="formlabel">Password</form:label> 
<form:password path="password" class="forminput"/>
<form:errors path="password" cssClass="formerror" /><br>

<form:hidden path="enabled" />

<form:label path="userRole" class="formlabel">Role</form:label>

<form:select path="userRole" class="forminput">
	<form:options items="${roles}" />
</form:select>

<form:label path="customer.firstname" class="formlabel">First Name</form:label> 
<form:input  path="customer.firstname" class="forminput"/>
<form:errors path="customer.firstname" cssClass="formerror"/><br>


<form:label path="customer.lastname" class="formlabel">Last Name</form:label> 
<form:input  path="customer.lastname" class="forminput"/>
<form:errors path="customer.lastname" cssClass="formerror"/><br>

<form:label path="customer.phone" class="formlabel">Phone</form:label> 
<form:input  path="customer.phone" class="forminput"/>
<form:errors path="customer.phone" cssClass="formerror"/><br>

<form:label path="customer.mobile" class="formlabel">Mobile</form:label> 
<form:input  path="customer.mobile" class="forminput"/>
<form:errors path="customer.mobile" cssClass="formerror"/><br>

<form:label path="customer.address.street" class="formlabel">Street</form:label> 
<form:input  path="customer.address.street" class="forminput"/>
<form:errors path="customer.address.street" cssClass="formerror"/><br>

<form:label path="customer.address.city" class="formlabel">City</form:label> 
<form:input  path="customer.address.city" class="forminput"/>
<form:errors path="customer.address.city" cssClass="formerror"/><br>

<form:label path="customer.address.state" class="formlabel">State</form:label> 
<form:input  path="customer.address.state" class="forminput"/>
<form:errors path="customer.address.state" cssClass="formerror"/><br>

<form:label path="customer.address.zip" class="formlabel">Zip</form:label> 
<form:input  path="customer.address.zip" class="forminput"/>
<form:errors path="customer.address.zip" cssClass="formerror"/><br>

<form:label path="customer.address.country" class="formlabel">Country</form:label> 
<form:input  path="customer.address.country" class="forminput"/>
<form:errors path="customer.address.country" cssClass="formerror"/><br>

<button>Register</button>

</form:form>
</fieldset>