<%@ include file="../layout/taglib.jsp" %>
<link rel="stylesheet" type="text/css" href="<spring:url value="/css/style.css" />" />

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