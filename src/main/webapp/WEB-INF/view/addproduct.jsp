<%@ include file="../layout/taglib.jsp" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" type="text/css" href="<spring:url value="/css/style.css" />" />

<div id="main">
	
	<form:form modelAttribute="product" action="/store/products/add" method="POST" enctype="multipart/form-data" >
		<table border="0">
			<tr>
				<td colspan="2"><form:errors path="*" cssStyle="color : red;" /></td>
			<tr>
				<td colspan="2">============================================</td>
			<tr>
				<td><label><spring:message code="product.add.label.id" /></label></td>
				<td><form:input path="id" value="" /></td>
			</tr>
			<tr>
				<td colspan="2"><form:errors path="id" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><label><spring:message code="product.add.label.name" /></label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td colspan="2"><form:errors path="name" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><label><spring:message code="product.add.label.description" /></label></td>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
				<td colspan="2"><form:errors path="description" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><label><spring:message code="product.add.label.productcode" /></label></td>
				<td><form:input path="productcode" /></td>
			</tr>
			<tr>
				<td colspan="2"><form:errors path="productcode" cssStyle="color: #ff0000;" /></td>
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
				<td><label><spring:message code="product.add.label.price" /></label></td>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
				<td colspan="2"><form:errors path="price" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><label><spring:message code="product.add.label.feature" /></label></td>
				<td><form:input path="feature" /></td>
			</tr>
			<tr>
				<td colspan="2"><form:errors path="feature" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><label><spring:message code="product.add.label.stock" /></label></td>
				<td><form:input path="stock" /></td>
			</tr>
			<tr>
				<td colspan="2"><form:errors path="stock" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><label><spring:message code="product.add.label.category" /></label></td>
				<td><form:input path="category" /></td>
			</tr>
			<tr>
				<td colspan="2"><form:errors path="category" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><label><spring:message code="product.add.label.store" /></label></td>
				<td><form:input path="store" /></td>
			</tr>
			<tr>
				<td colspan="2"><form:errors path="store" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="submit"
					value="<spring:message code="product.add.form.submit" />"></td>
			</tr>
			<tr>
		</table>
	</form:form>
</div>