<%@ include file="../layout/taglib.jsp" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" type="text/css" href="<spring:url value="/css/style.css" />" />
<style type="text/css">

fieldset{
	border-radius: 5px;
	width: 400px;
	height: 300px;
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
	margin-top:10px;
	min-width: 300px;
	margin-left: 20px;
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
	background-color: #FE980F;
	border-radius: 5px;
	border: 2px solid #6E6E6E;
	padding: 2px;
}

</style>


<fieldset>
<legend>Add Categories</legend>
<form:form modelAttribute="category" action="saveCategory" method="POST" class="forminput" >

<form:label path="name" class="formlabel">Category Name</form:label> 
<form:input  path="name" class="forminput"/>
<form:errors path="name" cssClass="formerror"/><br>

<form:label path="description" class="formlabel">Description</form:label> 
<form:input  path="description" class="forminput"/>
<form:errors path="description" cssClass="formerror"/><br>


<%-- <form:label path="store.id" class="formlabel">Choose Store</form:label>

<form:select path="store.id" class="forminput">
	<form:options items="${storeList}" itemLabel="name" itemValue= "id" />
</form:select>
<br>
 --%>
<form:label path="parent.id" class="formlabel">Choose Parent(Default if no parent category)</form:label>
<form:select  path="parent.id" class="forminput" >
					<form:option value="0" label= "Add Main Category"/>
					<form:options items="${rootCategoryList}" itemLabel="name" itemValue= "id"/>
</form:select>
<br>

<input class="forminput btn-primary" type="submit" name="submit"
					value="<spring:message code="product.add.form.submit" />">
					
					
</form:form>
</fieldset>


<div >
	

</div>