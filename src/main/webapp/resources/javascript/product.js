var removeProduct = function(productId){
	alert(productId);
	$.ajax({
		url:"/store/products/remove/"+productId,
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