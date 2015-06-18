<%@ include file="../layout/taglib.jsp" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" type="text/css" href="<spring:url value="/css/style.css" />" />
<script>
var removeCategory = function(rowid){
	$.ajax({
		url:"/store/category/remove/"+rowid,
		type: "DELETE",
		dataType: "json",
		contentType: "application/json",
		success:function(success){
			
			location.reload();
		},
		error:function(error){
		}
	});
}

</script>
 <div id="main">
 
 <div id="table">
	 <input class="btn-primary" style="float:right" type="button" value="<spring:message code="category.label.add" />" onclick="window.location='<spring:url value="category/addCategory"/>'" >
	<br>
	  	<table style="width: 100%;text-align: center; ">
			<thead>
				<tr class="cart_menu ">
				<td class="name"  width="20%"><spring:message code="category.table.label.name" /></td>
				<td class="description" width="30%" ><spring:message code="category.table.label.description" /></td>
				<td ></td>
				</tr>
			</thead>
	  		<tbody>
	  			
	  			<c:forEach items="${categoryList}" var="category">
	  				<tr   style="border: 1px solid black;" id="${category.id}">
						
						 <td class="category_name">
							<c:out value="${category.name}"  />
							
						</td>
						<td class="category_description">
							<c:out value="${category.description}"/>
						</td>
						<td class="">
							<button type="button" class="btn-primary" onclick="removeCategory(${category.id});"><spring:message code="category.table.label.remove" /></button>
						</td> 
					</tr>
					
				</c:forEach>
				
			
	  		</tbody>
	 	 </table>  
		</div>
 </div>