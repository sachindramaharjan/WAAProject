<%@ include file="../layout/taglib.jsp" %>
<link rel="stylesheet" type="text/css" href="<spring:url value="/css/style.css" />" />

<style type="text/css">

fieldset{
	border-radius: 5px;
	width: 500px;
	height: 400px;
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


<%-- <div id="main">
	<fieldset>
	<legend>Add Product</legend>
	<form:form modelAttribute="product" action="/store/products/add" method="POST" enctype="multipart/form-data">
		
		<form:label class="formlabel" path="name"><spring:message code="product.add.label.name" /></form:label>
		<form:input path="name" value="" />
		<form:errors path="name" cssStyle="color: #ff0000;" />
		
		<form:label class="formlabel" path="productcode"><spring:message code="product.add.label.productcode" /></form:label>
		<form:input path="productcode" />
		<form:errors path="productcode" cssStyle="color: #ff0000;" />
		
		<form:label class="formlabel" path="description"><spring:message code="product.add.label.description" /></form:label>
		<form:textarea path="description" rows="4" cols="22"/>
		<form:errors path="description" cssStyle="color: #ff0000;" />
				
		<form:label class="formlabel" path="category.name"><spring:message code="product.add.label.category" /></form:label>
					<form:select path="category.name">
						<form:options items="${categories}" />
					</form:select>
		<form:errors path="category.name" cssStyle="color: #ff0000;" />
		
		<form:label class="formlabel" path="price"><spring:message code="product.add.label.price" /></form:label>
		<form:input path="price" />
		<form:errors path="price" cssStyle="color: #ff0000;" />
		
		<form:label class="formlabel" path="stock"><spring:message code="product.add.label.stock" /></form:label>
		<form:input path="stock" />
		<form:errors path="stock" cssStyle="color: #ff0000;" /> 
				
		<form:label class="formlabel" path="stock_status"><spring:message code="product.add.label.stock_status" /></form:label>
		<form:select path="stock_status" >
			<form:options items="${stockStatus}"/>
		</form:select>
		
		<form:label class="formlabel" path="feature"><spring:message code="product.add.label.feature" /></form:label>
		<form:input path="feature" />
		<form:errors path="feature" cssStyle="color: #ff0000;" />
		
		<form:label class="formlabel" path="isFeatured"><spring:message code="product.add.label.isfeatured" /></form:label>
		<form:checkbox path="isFeatured" />
		
		<form:label class="formlabel" path="imageFile"><spring:message code="product.add.label.image" /></form:label>
		<form:input id="imageFile" path="imageFile" type="file"
						class="form:input-large" />
		
		<input type="submit" name="submit" class="btn-primary" value="<spring:message code="product.add.form.submit" />">
		
	</form:form>
	</fieldset>
</div>
 --%>
<div id="main">
	<form:form modelAttribute="product" action="/store/products/add" method="POST" enctype="multipart/form-data">
		<table border="0">
			<%-- <tr>
				<td colspan="2"><form:errors path="*" cssStyle="color : red;" /></td>
			</tr> --%>
			<tr></tr>
			<tr>
				<td><label><spring:message code="product.add.label.name" /></label></td>
				<td><form:input path="name" value="" /></td>
			</tr>
			<tr>
				<td colspan="2"><form:errors path="name" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><label><spring:message code="product.add.label.productcode" /></label></td>
				<td><form:input path="productcode" /></td>
			</tr>
			<tr>
				<td colspan="2"><form:errors path="productcode" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><label><spring:message code="product.add.label.description" /></label></td>
				<td><form:textarea path="description" rows="4" cols="22"/></td>
			</tr>
			<tr>
				<td colspan="2"><form:errors path="description" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><label><spring:message code="product.add.label.category" /></label></td>
				<td>
					<form:select path="category.name">
						<form:options items="${categories}" />
					</form:select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><form:errors path="category.name" cssStyle="color: #ff0000;" /></td>
			</tr>
			 
			 <tr>
				<td><label><spring:message code="product.add.label.price" /></label></td>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
				<td colspan="2"><form:errors path="price" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><label><spring:message code="product.add.label.stock" /></label></td>
				<td><form:input path="stock" /></td>
			</tr>
			 <tr>
				<td colspan="2"><form:errors path="stock" cssStyle="color: #ff0000;" /></td>
			</tr> 
			<tr>
				<td><label><spring:message code="product.add.label.stock_status" /></label></td>
				<td>
					<form:select path="stock_status" >
						<form:options items="${stockStatus}"/>
					</form:select>
				</td>
			</tr>
			<tr>
				<td><label><spring:message code="product.add.label.feature" /></label></td>
				<td><form:input path="feature" /></td>
			</tr>
			<tr>
				<td colspan="2"><form:errors path="feature" cssStyle="color: #ff0000;" /></td>
			</tr> 
			<tr>
				<td><label><spring:message code="product.add.label.isfeatured" /></label></td>
				<td><form:checkbox path="isFeatured" /></td>
			</tr>
			<tr>
				<td><label><spring:message code="product.add.label.image" /></label></td>
				<td><form:input id="imageFile" path="imageFile" type="file"
						class="form:input-large" /></td>
			</tr>
			<tr>
				<td colspan="2"><form:errors path="imageFile" cssStyle="color: #ff0000;" /></td>
			</tr> 
			<tr>
				<td colspan="2"><input type="submit" name="submit" class="btn-primary"
					value="<spring:message code="product.add.form.submit" />"></td>
			</tr>
			<tr>
		</table>
	</form:form>
</div>