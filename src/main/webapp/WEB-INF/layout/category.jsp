<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="category">
<!-- <ul>
  <li><a href="#home"><span class="nav">Home</span></a></li>
  <li><a href="#news"><span class="nav">News</span></a></li>
  <li><a href="#contact"><span class="nav">Contact</span></a></li>
  <li><a href="#about"><span class="nav">About</span></a></li>
</ul> -->
<c:forEach items="${categoryList}" var="category">


	 <ul id="${category.id}">

			<li class="category_name"><c:if test="${category.leaf ==false}">

					<span class="nav"><b><c:out
							value="${category.name}" /></b> </span>
							</c:if>
				</li>
	 </ul>	
			<tr>	
			<c:forEach items="${categoryList}"
					var="category2">
					
					<c:if test="${category2.leaf ==true}">
						<c:if test="${category2.parent.id==category.id}">
						<div class="category_name" >
						<a style="font-style: italic; text-align: center;"  href="/store/products/category/${category2.id}" ><span class="nav"><c:out
								value="${category2.name}" /></span></a></div>
						</c:if>
					</c:if>
				</c:forEach>



		</tr>

	</c:forEach>
</div>